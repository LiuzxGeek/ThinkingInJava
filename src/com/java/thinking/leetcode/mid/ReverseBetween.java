package com.java.thinking.leetcode.mid;

import com.java.thinking.link.BuildNode;
import com.java.thinking.link.ListNode;

public class ReverseBetween {
	public ListNode reverseBetween(ListNode head, int left, int right) {
		if (left == right)
			return head;
		// left到right中间的反转链表,以及反转后的最后一个结点
		ListNode top = null, tail = null;
		// 目标链表，及其指针
		ListNode root = null, next = null;
		int index = 1;
		while (head != null) {
			if (index == left) {
				tail = top = new ListNode(head.val);
			} else if (index == right) {
				ListNode tem = new ListNode(head.val);
				tem.next = top;
				top = tem;
				tail.next = head.next;
				break;
			} else {
				if (top == null) {
					// 左位，尚未开始
					if (root == null) {
						next = root = new ListNode(head.val);
					} else {
						next.next = new ListNode(head.val);
						next = next.next;
					}
				} else {
					// 开始后，进行反转
					ListNode tem = new ListNode(head.val);
					tem.next = top;
					top = tem;
				}
			}
			head = head.next;
			index++;
		}
		if (left == 1) {
			// 从第0个开始，则有root==top;
			root = top;
		} else {
			next.next = top;
		}
		return root;
	}

	public static void main(String[] args) {
		ReverseBetween between = new ReverseBetween();
		int[] nums = { 1, 2, 3, 4, 5 };
		int left = 3, right = 4;
		ListNode head = new BuildNode().array2ListNode(nums);
		ListNode re = between.reverseBetween(head, left, right);
		new BuildNode().printListNode(re);
	}
}
