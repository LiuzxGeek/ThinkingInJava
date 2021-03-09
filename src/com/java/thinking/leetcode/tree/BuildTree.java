package com.java.thinking.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BuildTree {
	public TreeNode arrayToTreeNode(Integer[] array) {
		if (array.length == 0) {
			return null;
		}
		TreeNode root = new TreeNode(array[0]);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		boolean isLeft = true;
		for (int i = 1; i < array.length; i++) {
			// 取出第一个元素（不删除）
			TreeNode node = queue.peek();
			if (isLeft) {
				if (array[i] != null) {
					node.left = new TreeNode(array[i]);
					// 相比add超出容量会抛异常，它只会返回false
					queue.offer(node.left);
				}
			} else {
				if (array[i] != null) {
					node.right = new TreeNode(array[i]);
					queue.offer(node.right);
				}
				// 取出第一个元素（删除）-神操作，每次给右结点赋值后，均移动指针
				queue.poll();
			}
			isLeft = !isLeft;
		}
		return root;
	}
}
