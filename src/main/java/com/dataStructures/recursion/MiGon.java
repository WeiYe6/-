package com.dataStructures.recursion;

//迷宫问题
public class MiGon {
    public static void main(String[] args) {
        //先初始化一个数组，用来表示迷宫
        int[][] map = new int[8][7]; //8行7列
        //补上墙，用1来表示。墙-1
        //上下（第1行和第8行）
        for (int i = 0; i < 7; i++) {
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右（第1列和第7列）
        for (int i = 0; i < 8; i++) {
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //挡板
        map[3][1] = 1;
        map[3][2] = 1;
        System.out.println("迷宫的地图为:");
        for (int[] ints : map) {
            for (int a : ints) {
                System.out.print(a + "     ");
            }
            System.out.println();
        }

        System.out.println("小球所走的迷宫路线：");
        //setWay(map, 1, 1);//标明地图和小球的初始位置：注意：引用类型用的是同一个地址，所以递归修改的也是同一个map
        setWay2(map,1,1);
        for (int[] ints : map) {
            for (int a : ints) {
                System.out.print(a + "     ");
            }
            System.out.println();
        }
    }
    /*
    约定：
    1.map表示地图
    2.i、j表示小球的坐标
    3.  表示： 1-墙壁 、2-小球走过的路线 、3-小球走过但走不通的路线
    4.当map[6][5] = 2 时，小球到达目的地
    5.策略：我们规定小球的移动方式为： 右 - 下 - 左 - 上 （人为规定）
     */

    /**
     * @param map 地图
     * @param i   横坐标
     * @param j   纵坐标
     * @return 是否找到正确的路线
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //到达目的地
            return true;
        } else {//还在路上，需要继续走
            if (map[i][j] == 0) {  //此时的路为 - 0，表示还没走过，需要探测路的正确性
                map[i][j] = 2; //暂标记为走过的路-2 ， 继续走下去才知道通不通 如此路不通则至为 -3
                if (setWay(map, i, j + 1)) {//往右走
                    return true;
                } else if (setWay(map, i + 1, j)) {//往下走
                    return true;
                } else if (setWay(map, i, j - 1)) {//往左走
                    return true;
                } else if (setWay(map, i - 1, j)) {//往上走
                    return true;
                } else {// 如果我们的移动策略都走不通，说明这条路为死路，走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {// 不等于 0 ，就有可能 为：1、2、3 都是不需要 或 者走不通的路。无需再走这步
                return false;
            }
        }
    }

    //策略改为：下-右-左-上
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) { //到达目的地
            return true;
        } else {//还在路上，需要继续走
            if (map[i][j] == 0) {  //此时的路为 - 0，表示还没走过，需要探测路的正确性
                map[i][j] = 2; //暂标记为走过的路-2 ， 继续走下去才知道通不通 如此路不通则至为 -3
                if (setWay2(map, i + 1, j)) {//往右走
                    return true;
                } else if (setWay2(map, i, j + 1)) {//往下走
                    return true;
                } else if (setWay2(map, i, j - 1)) {//往左走
                    return true;
                } else if (setWay2(map, i - 1, j)) {//往上走
                    return true;
                } else {// 如果我们的移动策略都走不通，说明这条路为死路，走不通
                    map[i][j] = 3;
                    return false;
                }
            } else {// 不等于 0 ，就有可能 为：1、2、3 都是不需要 或 者走不通的路。无需再走这步
                return false;
            }
        }
    }
}
