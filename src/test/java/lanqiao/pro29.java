package lanqiao;

import java.util.HashMap;
import java.util.Scanner;

public class pro29 {

	public static void main(String[] args) {
		// 图形排版
		Scanner scanner = new Scanner(System.in);
		int m = Integer.valueOf(scanner.next()); //纸张宽度
		int n = Integer.valueOf(scanner.next()); //图片数量
		int sum = 0;
		int[] wArr = new int[n]; //宽度
		int[] hArr = new int[n]; //高度
		HashMap<Integer, Integer> map = new HashMap<>(); //k:第几个图形   v：高
		int maxH  = 0; //记录最大高度
		for(int i = 0; i< n; i++) {
			int w = Integer.valueOf(scanner.next());
			int h = Integer.valueOf(scanner.next());
			wArr[i] = w;
			hArr[i] = h;
			map.put(i, h);
		}
		
		//如果m还有位置，会把下一张图片进行缩放，高度向上取整 (int)Math.ceil(double (a/b));
		//计算 v 的总和(考虑缩放的情况)，最后删除掉 v 最高的哪一个。
		int sum2 = 0;//记录用了多长的宽度
		for(int i = 0; i < n; i++) {//遍历
			sum2 = sum2 + wArr[i];
			if (sum2 <= m) {
				 maxH = Math.max(maxH, map.get(i)); //记录最大高度
				sum += map.get(i);
			}else {
				sum2 = sum2 - wArr[i];//减去刚刚累加的宽度
			}
			//当 sum2+wArr[i] > m 的时候，位于 i 图形下的高是没有被累加的
			//这时候就要再次进行判断，并进行图片的缩放
			if(m - sum2 < wArr[i] && m - sum2 != 0) {//判断剩余的宽度是否小于下一张要存放的图片的宽度
				int a = map.get(i); //取出该图片的高度，经行缩放
				int b = m - sum2; //剩余的宽度作为该图片的宽度
				//压缩之后的高度
				int x = 0;
				x = (int)Math.ceil(1.0 * wArr[i] * a  / b);
				 maxH = Math.max(maxH, x); //记录最大高度
				sum += x;
			}
		}
		System.out.println(sum - maxH);
		scanner.close();

	}

}
