package com.java.thinking.leetcode.sim;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.java.thinking.leetcode.tree.TreeNode;

public class LevelOrderBottom {

	public TreeNode generateTreeNode(Integer[] attr) {
		if (attr == null || attr.length == 0)
			return null;
		TreeNode root = new TreeNode(attr[0]);
		return generateTreeNode(attr, root, root, 1);
	}

	public TreeNode generateTreeNode(Integer[] attr, TreeNode root, TreeNode pointer, int index) {
		if (++index < attr.length) {
			Integer left = attr[index];
			if (left != null) {
				pointer.left = new TreeNode(left);
			}
			if (++index < attr.length) {
				Integer right = attr[index];
				if (right != null) {
					pointer.right = new TreeNode(right);
				}
			}
		}
		return root;
	}

	public TreeNode buildTreeNode(LinkedList<Integer> list) {
		if (list == null || list.size() == 0)
			return null;
		Integer val = list.removeFirst();
		TreeNode node = null;
		if (val != null) {
			node = new TreeNode(val);
			node.left = buildTreeNode(list);
			node.right = buildTreeNode(list);
		}
		return node;
	}

	public static ArrayList<Integer> bfs(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<>();
		// 先进先出
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode t = queue.remove();
			list.add(t.val);
			if (t.left != null) {
				queue.add(t.left);
			}
			if (t.right != null) {
				queue.add(t.right);
			}
		}
		return list;
	}

	public static ArrayList<Integer> dfs(TreeNode root) {
		// 先进后出
		Stack<TreeNode> stack = new Stack<>();
		ArrayList<Integer> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode t = stack.pop();
			list.add(t.val);
			if (t.right != null) {
				stack.push(t.right);
			}
			if (t.left != null) {
				stack.push(t.left);
			}
		}
		return list;
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> all = new ArrayList<>();
		if (root != null) {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			all.add(list);
			levelOrderBottom(root, all);
		}
		return all;
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root, List<List<Integer>> all) {
		if (root != null) {
			List<Integer> list = null;
			if (root.left != null) {
				list = new ArrayList<Integer>();
				list.add(root.left.val);
			}
			if (root.right != null) {
				if (list == null) {
					list = new ArrayList<>();
				}
				list.add(root.right.val);
			}
			if (list != null) {
				all.add(0, list);
			}
			if (root.left != null) {
				levelOrderBottom(root.left, all);
			}
			if (root.right != null) {
				levelOrderBottom(root.right, all);
			}
		}
		return all;
	}

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

	public static void main(String[] args) {
		LevelOrderBottom bottom = new LevelOrderBottom();
		Integer[] attr = new Integer[] { 1, 2, 3, 4, 5, 6, 7 };
		// LinkedList<Integer> list = new LinkedList<>();
		// for (Integer val : attr) {
		// list.add(val);
		// }
		TreeNode root = bottom.arrayToTreeNode(attr);
		// TreeNode root = bottom.generateTreeNode(attr);
		List<List<Integer>> all = bottom.levelOrderBottom(root);
		for (List<Integer> tem : all) {
			System.out.println(tem);
		}
	}
}
