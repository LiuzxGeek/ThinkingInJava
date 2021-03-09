package com.java.thinking.leetcode.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.java.thinking.leetcode.sim.LevelOrderBottom;

public class AverageLevel {
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> list = new ArrayList<>();
		list.add(1.0 * root.val);
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		// 当前层级
		int currCount = 1;
		int nextCount = 0;
		Long sum = null;
		while (queue.size() > 0) {
			TreeNode node = queue.poll();
			if (node.left != null) {
				queue.offer(node.left);
				if (sum == null) {
					sum = new Long(node.left.val);
				} else {
					sum += node.left.val;
				}
				nextCount++;
			}
			if (node.right != null) {
				queue.offer(node.right);
				if (sum == null) {
					sum = new Long(node.right.val);
				} else {
					sum += node.right.val;
				}
				nextCount++;
			}
			if (--currCount == 0) {
				// 当前层级已经遍历结束
				if (sum != null) {
					list.add(1.0 * sum / nextCount);
				}
				sum = null;
				currCount = nextCount;
				nextCount = 0;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		Integer[] attr = new Integer[] { 3, 9, 20, 15, 7 };
		LevelOrderBottom bottom = new LevelOrderBottom();
		TreeNode root = bottom.arrayToTreeNode(attr);
		AverageLevel averageLevel = new AverageLevel();
		List<Double> all = averageLevel.averageOfLevels(root);
		for (Double tem : all) {
			System.out.println(tem);
		}
		Double dou=new Double(1);
		char[] att=new char[1] ;
		att[0]=' ';
		System.out.println();
	}
}
