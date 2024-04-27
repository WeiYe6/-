package lanqiao;

import java.util.Scanner;

public class pro37 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //在此输入您的代码...
        //考察: 进制的转换
        int count = 0;
        for(int i = 1; i <= 1000000; i++){
          if(is(i, 2) && is(i, 8) && is(i, 10) && is(i, 16)){
            count++;
          }
          if(count == 2023){
            System.out.println(i);
            break;
          }
        }
        scan.close();
    }

    //进制转换，以及判断 该数能否 整除 该进制下的位数累加和
    public static boolean is(int n, int x){
      int i = n;
      int sum = 0;
      while(i > 0){
        sum = sum + i % x;
        i = i / x;
      }
      return n % sum == 0;
    }
}
