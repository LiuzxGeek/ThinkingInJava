package com.java.thinking.leetcode.tree;

public class FindTilt {
	public int findTilt(TreeNode root) {
		if (root != null) {
			int l = sumTree(root.left);
			int r = sumTree(root.right);
			return Math.abs(l - r) + Math.abs(findTilt(root.left, l)) + Math.abs(findTilt(root.right, r));
		}
		return 0;
	}

	public int findTilt(TreeNode root, int sum) {
		if (root != null) {
			int r = sumTree(root.right);
			int l = sum - root.val - r;
			return Math.abs(l - r) + Math.abs(findTilt(root.left, l)) + Math.abs(findTilt(root.right, r));
		}
		return 0;
	}

	public int sumTree(TreeNode root) {
		if (root != null) {
			return root.val + sumTree(root.left) + sumTree(root.right);
		}
		return 0;
	}

	public int findTilt2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		Integer sum = new Integer(0);
		sumLeaf(root, sum);
		return sum;
	}

	public int sumLeaf(TreeNode root, Integer sum) {
		if (root == null) {
			return 0;
		}
		int left = sumLeaf(root.left, sum);
		int right = sumLeaf(root.left, sum);
		// 将叶子的绝对值加起来
		sum+=(Math.abs(left - right));
		// 返回叶子结点值的和
		return left + right + root.val;
	}

	public static void main(String[] args) {
		BuildTree buildTree = new BuildTree();
		TreeNode node = buildTree.arrayToTreeNode(new Integer[] { 4, 2, 9, 3, 5, null, 7 });
		FindTilt findTilt = new FindTilt();
		System.out.println(findTilt.findTilt2(node));
	}
}
