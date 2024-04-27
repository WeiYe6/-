package 模拟赛题;

import java.util.Scanner;

/**
 * 小蓝有一个01矩阵。他打算将第一行第一列的 0 变为 2 。变化过程有传染性，每次 2 的上下左右四个相邻的位置中的 0 都会变成 2 。
 * 直到最后每个 2 的周围都是 1 或 2 结束。
 * 　　请问，最终矩阵中有多少个 2 ？
 * 　　以下是小蓝的矩阵，共 30 行 40 列。
 *
 0000100010000001101010101001001100000011
 0101111001111101110111100000101010011111
 1000010000011101010110000000001011010100
 0110101010110000000101100100000101001001
 0000011010100000111111001101100010101001
 0110000110000000110100000000010010100011
 0100110010000110000000100010000101110000
 0010011010100110001111001101100110100010
 1111000111101000001110010001001011101101
 0011110100011000000001101001101110100001
 0000000101011000010011111001010011011100
 0000100000011001000100101000111011101100
 0010110000001000001010100011000010100011
 0110110000100011011010011010001101011011
 0000100100000001010000101100000000000010
 0011001000001000000010011001100101000110
 1110101000011000000100011001001100111010
 0000100100111000001101001000001010010001
 0100010010000110100001100000110111110101
 1000001001100010011001111101011001110001
 0000000010100101000000111100110010101101
 0010110101001100000100000010000010110011
 0000011101001001000111011000100111010100
 0010001100100000011000101011000000010101
 1001111010010110011010101110000000101110
 0110011101000010100001000101001001100010
 1101000000010010011001000100110010000101
 1001100010100010000100000101111111111100
 1001011010101100001000000011000110110000
 0011000100011000010111101000101110110001
 */

/**
 * 使用了递归 和 深度优先搜索(DFS)的方式完成的
 * 1.dfs() 方法是一个递归函数，用于进行深度优先搜索。它接受当前位置的行号 r 和列号 c 作为参数，并根据一定的条件进行递归调用。
 * 2.在 dfs() 方法中，首先检查当前位置是否越界或已经被访问过。如果满足这些条件之一，则直接返回，结束当前递归调用。
 * 3.如果当前位置符合要求，即 data[r][c] 的值为0（表示未被访问），则将其标记为2（表示已访问）。
 * 4.然后，分别对当前位置的上、下、左、右四个相邻位置进行递归调用 dfs()。
 * 5.通过递归调用 dfs() 方法，可以遍历整个网格，并将连通的区域标记为2。最后，统计数组中值为2的元素的个数，即为岛屿的数量。
 */
public class Test4 {
        static int[][] data = new int[30][40];
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            for (int i = 0; i < 30; i++) {
                String input = scanner.nextLine().trim();
                for (int j = 0; j < 40; j++) {
                    data[i][j] = Character.getNumericValue(input.charAt(j));
                }
            }
            dfs(0, 0);
            int cnt = 0;
            for (int[] row : data) {
                for (int num : row) {
                    if (num == 2) {
                        cnt++;
                    }
                }
            }

            System.out.println(cnt);
        }
        public static void dfs(int r, int c) {
            if (r < 0 || r >= 30 || c < 0 || c >= 40) {
                return;
            }
            if (data[r][c] != 0) {
                return;
            }
            data[r][c] = 2;
            dfs(r - 1, c);
            dfs(r + 1, c);
            dfs(r, c - 1);
            dfs(r, c + 1);
        }

}
