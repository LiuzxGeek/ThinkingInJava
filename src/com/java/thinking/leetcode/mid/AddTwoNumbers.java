package com.java.thinking.leetcode.mid;

import com.java.thinking.link.BuildNode;
import com.java.thinking.link.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if (l1 == null && l2 == null)
			return null;
		l1 = reverse(l1);
		l2 = reverse(l2);
		ListNode node = null;
		ListNode next = null;
		int extra = 0;
		while (l1 != null || l2 != null) {
			int val1 = 0, val2 = 0;
			if (l1 != null) {
				val1 = l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				val2 = l2.val;
				l2 = l2.next;
			}
			int result = val1 + val2 + extra;
			if (result > 9) {
				extra = result / 10;
				result = result % 10;
			} else {
				extra = 0;
			}
			if (node == null) {
				node = new ListNode(result);
			} else {
				if (next == null) {
					next = new ListNode(result);
					node.next = next;
				} else {
					next.next = new ListNode(result);
					next = next.next;
				}
			}
		}
		if (extra > 0) {
			if (next != null) {
				next.next = new ListNode(extra);
			} else {
				node.next = new ListNode(extra);
			}
		}
		return reverse(node);
	}

	public ListNode reverse(ListNode l1) {
		ListNode node = new ListNode(l1.val);
		ListNode next = null;
		while (l1 != null && l1.next != null) {
			next = new ListNode(l1.next.val);
			next.next = node;
			node = next;
			l1 = l1.next;
		}
		return node;
	}

	public static void main(String[] args) {
		BuildNode buildNode = new BuildNode();
		ListNode l1 = buildNode.array2ListNode(new int[] { 7, 2, 4, 3 });
		ListNode l2 = buildNode.array2ListNode(new int[] { 5, 6, 4 });
		ListNode node = (new AddTwoNumbers()).addTwoNumbers(l1, l2);
		buildNode.printListNode(node);
	}
}
