package lanqiao;



public class pro14 {

	public static void main(String[] args) {
		// 滑动窗口实现 最小大小的子数组和
		int[] nums = {1, 4, 2, 6, 6, 3, 4};
		int target = 7; //目标值
		System.out.println(minLenSum(nums, target));
	}

	private static int minLenSum(int[] nums, int target) {
		//定义左和右指针
		int left = 0;
		int right = 0;
		int sum = 0;
		int minLen = Integer.MAX_VALUE; //定义最小长度
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i]; //累加和
			while (sum >= target) { //累加和 大于等于目标值的话，不断缩小窗口继续判断
				//记录最小大小的数组个数==> 最少多少个数相加等于目标值
				minLen = Math.min(minLen, (right - left + 1));
				//清空左指针，并移动左指针
				sum -= nums[left];
				left++;
			}
			//移动右指针
			right++;
		}
		return minLen == Integer.MAX_VALUE ? 0: minLen;
	}

}
