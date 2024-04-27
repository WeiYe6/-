package 真题;

import java.util.Scanner;
// 1:无需package
// 2: 类名必须Main, 不可修改

public class pro5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        String s = scan.nextLine();
        if(s.length() <= 1){
          System.out.println(0);
          return;
        }
        //1.dp[j]含义
        //dp[j] -在长度为(j+1)的子串中出现最多互不重叠 00 11字串的最多数量为dp[j]
        int[] dp = new int[s.length()+1];
        //2.递推公式
        //dp[j]-在长度为(j+1)的子串中出现的最多次数 ,保持现状 和 进行递增
        //dp[j]  = Math.max(dp[j - 1], dp[j - 2] +1); //我们的00 11子串长度为2，如果满足递增则+1
        //3.初始化
        //dp[0]: 长度为1的子串个数 dp[0] = 0
        //dp[1]: 长度为2的子串个数 判断 索引 0 和 1，如果相等或者 有任何一方有? 则加1
        dp[0] = 0;
        if(s.charAt(0) == s.charAt(1) || s.charAt(0) =='?' || s.charAt(1) == '?') {
          dp[1] =  1;
          dp[2] =  1;
        }else if(s.charAt(1) != s.charAt(2)){
          dp[2]  = 0;
        }else{
          dp[2]  = 1;
        }
        //4.递推公式： 由递推公式可知需要前面的状态值，由左往右
        for(int j = 2; j < s.length(); j++){
          if(s.charAt(j) == s.charAt(j-1) || s.charAt(j) == '?' || s.charAt(j-1) == '?'){
            dp[j] = Math.max(dp[j-1], dp[j-2] + 1);
          }else{
            dp[j] = dp[j-1];
          }
        }
        System.out.println(dp[s.length() - 1]);
        scan.close();
    }
}