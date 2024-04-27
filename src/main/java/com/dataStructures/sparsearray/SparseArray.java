package com.dataStructures.sparsearray;

public class SparseArray {
    public static void main(String[] args) {

        //创建一个二维数组，表示棋盘
        // 0-没有棋子   1-黑色子   2-蓝色子

        int[][] ChessArray = new int[11][11];

        //添加棋子
        ChessArray[1][2]=1; //第二行 第三列
        ChessArray[2][3]=2; //第三行 第四列
        ChessArray[3][4]=2;
        //原始的二维数组
        System.out.println("--------------原二维数组---------------");
        for (int[] ints : ChessArray) {
            for (int anInt : ints) {
                System.out.print(anInt+ "\t");
            }
            System.out.println();
        }

        //二维数组转化为稀疏数组
        /*
          先遍历所有的值，得到非零值的个数，即有效值，用sum记录
          稀疏数组的 行数：sum+1 , 列数：3 （行、列、值）
         */
        int sum = 0;
        for (int[] ints : ChessArray) {
            for (int anInt : ints) {
                if (anInt != 0) {
                    sum++;
                }
            }
        }

        //创建二维数组
        int[][] Sparse = new int[sum + 1][3];
        //给表头赋值
        Sparse[0][0] = 11;
        Sparse[0][1] = 11;
        Sparse[0][2] = sum;

        int count=0;
        //给稀疏数组附上非零值
        for (int i = 0; i < ChessArray.length; i++) {
            for (int j = 0; j < ChessArray[i].length; j++) {
               if (ChessArray[i][j] != 0){
                   count++;
                   Sparse[count][0] = i;
                   Sparse[count][1] = j;
                   Sparse[count][2] = ChessArray[i][j];
               }
            }
        }

        System.out.println("--------------稀疏数组---------------");
        for (int[] ints : Sparse) {
            for (int anInt : ints) {
                System.out.print(anInt+ "\t");
            }
            System.out.println();
        }

        //将稀疏数组转换回二维数组 (理解稀疏数组的含义就懂了下面的 Sparse[x][x] 的含义)
        int[][] ChessArray1 = new int[ Sparse[0][0]] [Sparse[0][1] ];
        //遍历稀疏数组，将有效值 放回二维数组中
        for (int i = 1; i < Sparse.length; i++) {
            ChessArray1[ Sparse[i][0] ][ Sparse[i][1] ] = Sparse[i][2];
        }

        System.out.println("-----------转换回来的二维数组-----------");
        for (int[] ints : ChessArray1) {
            for (int anInt : ints) {
                System.out.print(anInt+ "\t");
            }
            System.out.println();
        }
    }
}
