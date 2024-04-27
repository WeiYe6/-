package 热题100;


/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * <p>
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 */
public class demo5 {
    public static void main(String[] args) {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int maxArea = maxArea(height);
        System.out.println("maxArea = " + maxArea);
    }

    public static int maxArea(int[] height) {
        //移动短板(高度)，如果一样，随便移动均可
        int i = 0; //左边柱子 （值为高度）
        int j = height.length - 1; // 右边柱子 （值为高度）
        int res = 0; //面积 （储水量）

        while (i < j) { //左右的柱子相撞了，不合理
            //短柱 * 两个柱子之间的距离
            res = height[i] < height[j] ? //左边柱子高度小于右边的，移动左边的
                    Math.max(res, (j - i) * height[i++]) :
                    Math.max(res, (j - i) * height[j--]); //反之移动右边的

        }
        return res;
    }
}
