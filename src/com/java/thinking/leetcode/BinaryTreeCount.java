package com.java.thinking.leetcode;

import javax.swing.tree.TreeNode;

public class BinaryTreeCount {
	public static int countNodes(TreeNode root) {
		int count = 0;
		if (root == null) {
			return count;
		}
		count++;
		int index = 0;
		while (index++ < root.getChildCount()) {
			count += countNodes(root.getChildAt(index));
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(2 << 1);
		System.out.println(2 >> 1);
	}
}
