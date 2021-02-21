package com.java.thinking.leetcode.sim;

import com.java.thinking.link.ListNode;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
 * 
 * @author fred
 *
 */
public class MergeListNode {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		return merge(l1, l2, null, null);
	}

	public ListNode merge(ListNode l1, ListNode l2, ListNode target, ListNode last) {
		if (l1 == null && l2 == null) {
			return target;
		} else if (l1 == null) {
			if (target == null) {
				target = l2;
			} else {
				last.next = l2;
			}
			return target;
		} else if (l2 == null) {
			if (target == null) {
				target = l1;
			} else {
				last.next = l1;
			}
			return target;
		}
		if (l1.val <= l2.val) {
			if (target == null) {
				target = l1;
				last = target;
			} else {
				last.next = l1;
				last = last.next;
			}
			l1 = l1.next;
		} else {
			if (target == null) {
				target = l2;
				last = target;
			} else {
				last.next = l2;
				last = last.next;
			}
			l2 = l2.next;
		}
		return merge(l1, l2, target, last);
	}

	public static void main(String[] args) {

	}
}
