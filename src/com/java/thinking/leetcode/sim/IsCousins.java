package com.java.thinking.leetcode.sim;

import java.util.HashMap;
import java.util.Map;

import com.java.thinking.leetcode.tree.TreeNode;

public class IsCousins {
	public boolean isCousins(TreeNode root, int x, int y) {
		Map<Integer, Integer> depMap = new HashMap<Integer, Integer>();
		Map<Integer, TreeNode> parMap = new HashMap<>();
		dfs(root, null, depMap, parMap);
		return (depMap.get(x) == depMap.get(y) && parMap.get(x) != parMap.get(y));
	}

	private void dfs(TreeNode node, TreeNode par, Map<Integer, Integer> depMap, Map<Integer, TreeNode> parMap) {
		if (node != null) {
			depMap.put(node.val, par == null ? 0 : (depMap.get(par.val) + 1));
			parMap.put(node.val, par);
			dfs(node.left, node, depMap, parMap);
			dfs(node.right, node, depMap, parMap);
		}
	}

	public static void main(String[] args) {
		IsCousins cousins = new IsCousins();
		Integer[] nums = { 1, 2, 3, null, 4, null, 5 };
		TreeNode node = (new LevelOrderBottom()).arrayToTreeNode(nums);
		int x = 5, y = 4;
		System.out.println(cousins.isCousins(node, x, y));
	}
}
