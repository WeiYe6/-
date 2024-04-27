package 模拟赛题;

/**
 * 　　对于以下这些数（6行，每行6个，共36个），请问约数个数最多的是哪个？（如果有多个，请回答出现最早的那个）
 * 　　393353 901440 123481 850930 423154 240461
 * 　　373746 232926 396677 486579 744860 468782
 * 　　941389 777714 992588 343292 385198 876426
 * 　　483857 241899 544851 647930 772403 109929
 * 　　882745 372491 877710 340000 659788 658675
 * 　　296521 491295 609764 718967 842000 670302
 */
public class Test3 {
        public static void main(String[] args) {
            //int number = 36; // 要计算约数个数的数
            //int count = findDivisorCount(number);
            //System.out.println("约数个数：" + count);
            int[][] data = {
                    {393353, 901440, 123481, 850930, 423154, 240461},
                    {373746, 232926, 396677, 486579, 744860, 468782},
                    {941389, 777714, 992588, 343292, 385198, 876426},
                    {483857, 241899, 544851, 647930, 772403, 109929},
                    {882745, 372491, 877710, 340000, 659788, 658675},
                    {296521, 491295, 609764, 718967, 842000, 670302}
            };

            int maxData = 0;
            int maxNum = 0;

            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 6; j++) {
                    int res = findDivisorCount(data[i][j]);
                    if (res > maxNum) {//当前数值的约数个数 如果大于前一个数值的约数个数则重新赋值
                        maxData = data[i][j];
                        maxNum = res;
                    }
                }
            }

            System.out.printf("约数个数最多的数：%d，约数个数为%d%n", maxData, maxNum);
        }

        //计算某个数的约数个数
        public static int findDivisorCount(int number) {
            int count = 0;
            for (int i = 1; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    if (i * i == number) {//如果某个数的平方等于 number，那么它只会被计算一次，因此 count++。
                        count++;
                    } else { // 如果i是number的约数，那么number/i也是约数，因此count加2
                        count += 2;
                    }
                }
            }

            return count;
        }
}
