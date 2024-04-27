package 模拟赛题;

import java.util.Scanner;

/**
 * 问题描述
 * 　　小蓝站在一个 n 行 m 列的方格图中间，方格图的每一个方格上都标有一个正整数。
 * 　　如果两个相邻方格（上下左右四个方向相邻）内的数的最大公约数大于 1 ，则可以从其中一个方格移动到另一个方格，当然也可以从另一个方格移回第一个方格。
 * 　　假设小蓝开始时站在第 r 行第 c 列，请问小蓝可以移动到方格图内的多少个方格？
 * 输入格式
 * 　　输入的第一行包含两个整数 n, m ，用一个空格分隔，表示方格图的行数和列数。
 * 　　接下来 n 行，每行包含 m 个正整数，相邻整数间用一个空格分隔，依次表示方格图中从第 1 行到第 n 行，每行从第 1 列到第 m 列中的数。
 * 　　接下来一行包含两个整数 r, c，用一个空格分隔，表示小蓝所在的行号和列号。
 * 输出格式
 * 　　输出一行包含一个整数，表示答案。
 * 样例输入
 * 3 4
 * 3 6 5 5
 * 2 4 3 5
 * 7 8 3 8
 * 3 2
 * 样例输出
 * 5
 * 评测用例规模与约定
 * 　　对于50%的评测用例，1 <= n, m <= 100，方格图中的每个数不超过 10**5 （10的5次方）。
 * 　　对于所有评测用例，1 <= n, m <= 1000，方格图中的每个数不超过 10**9 （10的9次方）。
 */

/**
 * 首先，我们可以使用深度优先搜索（DFS）来解决这个问题。从小蓝所在的方格开始，递归地探索其相邻的方格，并将已经访问过的方格标记为已访问。
 * 在递归过程中，我们需要判断两个相邻方格的数的最大公约数是否大于1，如果是，则可以移动到该方格并继续递归搜索。
 */
public class Test8 {
        private static int[][] grid;
        private static boolean[][] visited;
        private static int n, m;
        private static int count;

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            m = scanner.nextInt();

            grid = new int[n + 1][m + 1];
            visited = new boolean[n + 1][m + 1];

            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    grid[i][j] = scanner.nextInt();
                }
            }

            int r = scanner.nextInt();
            int c = scanner.nextInt();

            count = 0;
            dfs(r, c);

            System.out.println(count);
        }

        private static void dfs(int x, int y) {
            if (x < 1 || x > n || y < 1 || y > m || visited[x][y]) {
                return;
            }

            visited[x][y] = true;
            count++;

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 1 && nx <= n && ny >= 1 && ny <= m && !visited[nx][ny] &&
                        gcd(grid[x][y], grid[nx][ny]) > 1) {
                    dfs(nx, ny);
                }
            }
        }

        private static int gcd(int a, int b) {
            if (b == 0) {
                return a;
            }
            return gcd(b, a % b);
        }

}
