package com.java.thinking.link;

public class BuildNode {

	public ListNode array2ListNode(int[] nums) {
		if (nums == null || nums.length == 0)
			return null;
		ListNode node = new ListNode(nums[0]);
		ListNode next = new ListNode(nums[1]);
		node.next = next;
		for (int i = 2; i < nums.length; i++) {
			next.next = new ListNode(nums[i]);
			next = next.next;
		}
		return node;
	}

	public void printListNode(ListNode node) {
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

}
