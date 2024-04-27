package lanqiao;

public class pro13 {

	public static void main(String[] args) {
		// 滑动窗口实现 最大连续子数组和
		int[] nums1 = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSum(nums1));
	}

	private static int maxSum(int[] nums1) {
		// 定义最大子数组和
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums1.length; i++) {
			sum += nums1[i]; //累加
			maxSum = Math.max(maxSum, sum); //更新最大子数组和
			if (sum < 0) {
				//如果当前和小于0，则丢弃之前的结果，从当前元素重新开始累加
				sum = 0;
			}
		}
		return maxSum;
	}

}
