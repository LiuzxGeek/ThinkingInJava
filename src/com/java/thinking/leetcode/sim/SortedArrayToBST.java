package com.java.thinking.leetcode.sim;

import com.java.thinking.leetcode.tree.TreeNode;

public class SortedArrayToBST {
	public TreeNode sortedArrayToBST(int[] nums) {
		int len = nums.length;
		int mid = len / 2;
		TreeNode root = new TreeNode(nums[mid]);
		buildTreeNode(true, mid - 1, 0, root, nums);
		buildTreeNode(false, mid + 1, len - 1, root, nums);
		return root;
	}

	private void buildTreeNode(boolean left, int cur, int value, TreeNode root, int[] nums) {
		if (left) {
			if (cur >= value) {
				root.left = new TreeNode(nums[cur]);
				buildTreeNode(true, cur - 1, value, root.left, nums);
			}
		} else {
			if (cur <= value) {
				root.right = new TreeNode(nums[cur]);
				buildTreeNode(false, cur + 1, value, root.right, nums);
			}
		}
	}

	public TreeNode sortedArrayToBST2(int[] nums) {
		return build(0, nums.length - 1, nums);
	}

	private TreeNode build(int left, int right, int[] nums) {
		if (left > right) {
			return null;
		}
		int mid = left + right >> 1;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = build(left, mid - 1, nums);
		root.right = build(mid + 1, right, nums);
		return root;
	}

}
