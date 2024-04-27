package 模拟赛题;

/**
 * 求 2**2023%1000，即 2的2023次方除以1000的余数。
 */
public class Test1 {
    public static void main(String[] args) {
        long result = 1;
        for (int i = 0; i < 2023; i++) {
            result *= 2;
            result %= 1000;
        }
        System.out.println(result);
    }
}
