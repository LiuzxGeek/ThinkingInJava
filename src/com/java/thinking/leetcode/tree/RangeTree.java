package com.java.thinking.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RangeTree {

	private List<Integer> rangeDeep(TreeNode node) {
		List<Integer> list = new ArrayList<Integer>();
		rangeDeep(node, list);
		return list;
	}

	private void rangeDeep(TreeNode node, List<Integer> list) {
		if (node != null) {
			list.add(node.val);
			rangeDeep(node.left, list);
			rangeDeep(node.right, list);
		}
	}

	private List<Integer> rangeWide(TreeNode node) {
		List<Integer> list = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<>();
		list.add(node.val);
		queue.add(node);
		while (queue.size() > 0) {
			TreeNode root = queue.poll();
			if (root.left != null) {
				list.add(root.left.val);
				queue.offer(root.left);
			}
			if (root.right != null) {
				list.add(root.right.val);
				queue.offer(root.right);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Integer[] attr = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
		BuildTree buildTree = new BuildTree();
		TreeNode node = buildTree.arrayToTreeNode(attr);
		RangeTree rangeTree = new RangeTree();
		List<Integer> list = rangeTree.rangeWide(node);
		for (Integer i : list) {
			System.out.println(i);
		}
		Integer num = new Integer(2);
		System.out.println(num + 1);
	}
}
