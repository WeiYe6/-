package 动态规划;

import java.util.HashMap;

public class pro67 {

	public static void main(String[] args) {
		// 打家劫舍III

	}

	// 暴力递归
	public static int rob1(TreeNode root) {
		// 结束条件
		if (root == null) {
			return 0;
		}
		int money = root.val; // 当前节点的金额
		// 1.偷当前节点 --（可以偷左孙子节点)当前节点的左子节点的左子节点的金额 + 当前节点的左子节点的右子节点的金额
		if (root.left != null) {
			money += rob1(root.left.left) + rob1(root.left.right);
		}
		// 2.偷当前节点 -- （可以偷右孙子节点)当前节点的右子节点的左子节点的金额 + 当前节点的右子节点的右子节点的金额
		if (root.right != null) {
			money += rob1(root.right.left) + rob1(root.right.right);
		}

		// 获取偷当前节点 或者 不偷当前节点（偷左右子解决）的最大金额
		return Math.max(money, rob1(root.left) + rob1(root.right));
	}

	// 记忆递归（记录状态，计算过该节点的金额时，不用重复计算）
	public static int rob2(TreeNode root) {
		HashMap<TreeNode, Integer> hashMap = new HashMap<>();
		return robAction(root, hashMap);
	}

	public static int robAction(TreeNode root, HashMap<TreeNode, Integer> hashMap) {
		if (root == null) {
			return 0;
		}
		if (hashMap.containsKey(root)) { // 记住过往，减少重复计算
			return hashMap.get(root);
		}
		int money = root.val; // 当前节点的金额
		// 1.偷当前节点 --（可以偷左孙子节点)当前节点的左子节点的左子节点的金额 + 当前节点的左子节点的右子节点的金额
		if (root.left != null) {
			money += robAction(root.left.left, hashMap) + robAction(root.left.right, hashMap);
		}
		// 2.偷当前节点 -- （可以偷右孙子节点)当前节点的右子节点的左子节点的金额 + 当前节点的右子节点的右子节点的金额
		if (root.right != null) {
			money += robAction(root.right.left, hashMap) + robAction(root.right.right, hashMap);
		}
		int res = Math.max(money, robAction(root.left, hashMap) + robAction(root.right, hashMap));
		hashMap.put(root, res);
		return res;
	}

	// 状态标记递归 + 动态规划
	public static int rob3(TreeNode root) {
		int[] res = robAction3(root);
		// 获取对该节点 取 还是 不取 的最大值
		return Math.max(res[0], res[1]);
	}

	public static int[] robAction3(TreeNode root) {
		// dp[0]： 不取当前节点
		// dp[1]： 取当前节点
		int[] dp = new int[2];
		if (root == null) {
			return dp;
		}
		//对左子节点进行标记
		int[] left = robAction3(root.left);
		//对右子节点进行标记
		int[] right = robAction3(root.right);
		// 不偷：Max(左孩子不偷，左孩子偷) + Max(右孩子不偷，右孩子偷)
	    // 偷：左孩子不偷+ 右孩子不偷 + 当前节点偷
		//不取当前节点： 取/不取【左子节点 、右子节点】最大值
		dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //取当前节点，不取左右子节点
		dp[1] = root.val + left[0] + right[0];
		return dp;
	}

}

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
