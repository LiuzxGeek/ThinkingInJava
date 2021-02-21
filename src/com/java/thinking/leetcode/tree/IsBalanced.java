package com.java.thinking.leetcode.tree;

import com.java.thinking.leetcode.sim.LevelOrderBottom;

public class IsBalanced {

	public boolean isBalanced(TreeNode root) {
		if (root != null) {
			int leftCount = getHeight(root.left);
			int rightCount = getHeight(root.right);
			if (Math.abs(leftCount - rightCount) > 1) {
				return false;
			}
			return isBalanced(root.left) && isBalanced(root.right);
		}
		return true;
	}

	private int getHeight(TreeNode node) {
		if (node != null) {
			return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		IsBalanced isBalanced = new IsBalanced();
		Integer[] attr = new Integer[] { 1, 2, 3, 4, 5, 6, null, 8 };
		LevelOrderBottom bottom = new LevelOrderBottom();
		TreeNode root = bottom.arrayToTreeNode(attr);
		System.out.println(isBalanced.isBalanced(root));
	}
}
