package lanqiao;

import java.util.Arrays;

public class pro30 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] charArray = "WHERETHEREISAWILLTHEREISAWAY".toCharArray();
		// 排序 默认从小到达排序
		// Arrays.sort(charArray);
		Character[] charObjectArray = new Character[charArray.length];
		for (int i = 0; i < charArray.length; i++) {
		    charObjectArray[i] = charArray[i];
		}
		//注意: 要用自定义排序规则，必须要用包装类才能，不能用char基本类型
		 Arrays.sort(charObjectArray, (o1,o2) -> o2 - o1);
		for(int i = 0; i < charArray.length; i++) {
			System.out.print(charObjectArray[i]);
		}
	}

}
