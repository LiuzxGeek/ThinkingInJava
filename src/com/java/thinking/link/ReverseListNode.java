package com.java.thinking.link;

import java.util.ArrayList;
import java.util.List;

public class ReverseListNode {

	/**
	 * 创建链表
	 * 
	 * @param depth
	 * @return
	 */
	private static ListNode createListNode(int firstVal, int depth) {
		int preVal = firstVal;
		ListNode head = new ListNode(preVal);
		ListNode pre = head;
		while (++preVal <= depth) {
			ListNode temp = new ListNode(preVal);
			pre.next = temp;
			pre = temp;
		}
		return head;
	}

	/**
	 * 插入结点
	 * 
	 * @param head
	 * @param target
	 * @param index
	 * @return
	 */
	private static ListNode addListNode(ListNode head, ListNode target, int index) {
		if (index == 0) {
			target.next = head;
			return target;
		}
		// 查到前一个结点
		ListNode preNode = queryListNode(head, 0, index - 1);
		// index位的结点
		ListNode next = preNode.next;
		// 将target指向前一个结点
		preNode.next = target;
		// 将index位结点，指向target
		target.next = next;
		return head;
	}

	/**
	 * 修改结点
	 * 
	 * @param head
	 * @param index
	 * @param val
	 * @return
	 */
	private static ListNode setListNodeVal(ListNode head, int index, int val) {
		if (index < 0) {
			throw new IllegalArgumentException("下标不合法！");
		}
		if (index == 0) {
			// 如果是首结点
			ListNode next = head.next;
			ListNode nh = new ListNode(val);
			nh.next = next;
			return nh;
		}
		// 查到的目标前一结点
		ListNode preNode = queryListNode(head, 0, index - 1);
		if (preNode == null || preNode.next == null) {
			throw new IndexOutOfBoundsException("下标超界！");
		}
		// 查到结点
		ListNode queryNode = preNode.next;
		// 下个结点
		ListNode nextNode = queryNode.next;
		// 新建结点
		ListNode targetNode = new ListNode(val);
		// 断开结点/插入结点
		preNode.next = targetNode;
		// 完善结点
		targetNode.next = nextNode;
		return head;
	}

	/**
	 * 轮询链表
	 * 
	 * @param head
	 */
	private static void loopListNode(ListNode head) {
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

	/**
	 * 递归查看链接
	 * 
	 * @param head
	 */
	private static void recusiveListNode(ListNode head) {
		if (head != null) {
			System.out.println(head.val);
			recusiveListNode(head.next);
		}
	}

	/**
	 * 
	 * @param head
	 * @param position
	 *            head所在下标位
	 * @param index
	 *            目标对象下标位
	 * @return
	 */
	private static ListNode queryListNode(ListNode head, int position, int index) {
		if (head == null) {
			return null;
		}
		if (++position == index) {
			return head.next;
		}
		return queryListNode(head.next, position, index);
	}

	/**
	 * 链表反转
	 * 
	 * @param head
	 * @return
	 */
	private static ListNode reverseListNode1(ListNode head) {
		List<ListNode> list = getListNodeSize(head, new ArrayList<>());
		ListNode preNode = null;
		for (int i = list.size() - 1; i > -1; i--) {
			ListNode node = list.get(i);
			// 切断结点
			node.next = null;
			if (preNode == null) {
				// 赋值初结点
				preNode = node;
			} else {
				// 临时结点
				ListNode temp = preNode.next;
				if (temp != null) {
					while (temp.next != null) {
						// 每次都将指针移到最后一个，查到最后一个结点
						temp = temp.next;
					}
					temp.next = node;
				} else {
					preNode.next = node;
				}
			}
		}
		return preNode;
	}

	private static ListNode reverseListNode2(ListNode head) {
		List<ListNode> list = getListNodeSize(head, new ArrayList<>());
		// 头部结点
		ListNode headNode = null;
		// 指针结点
		ListNode curNode = null;
		for (int i = list.size() - 1; i > -1; i--) {
			ListNode node = list.get(i);
			// 切断结点
			node.next = null;
			if (headNode == null) {
				// 赋值头部结点
				headNode = node;
			} else {
				// 链接结点
				curNode.next = node;
			}
			// 指针移到下一位
			curNode = node;
		}
		return headNode;
	}

	private static ListNode reverseListNode(ListNode head) {
		return reverseNode(head, null);
	}

	/**
	 * 
	 * @param curNode
	 *            指针结点
	 * @param headNode
	 *            新的链表
	 * @return
	 */
	private static ListNode reverseNode(ListNode curNode, ListNode headNode) {
		// 指针结点为空
		if (curNode == null) {
			return headNode;
		}
		// 新的链表
		if (headNode == null) {
			headNode = new ListNode(curNode.val);
		}
		// 指针结点
		ListNode nextNode = curNode.next;
		if (nextNode == null) {
			return headNode;
		}
		// 新链表结点
		curNode = new ListNode(nextNode.val);
		curNode.next = headNode;
		return reverseNode(nextNode, curNode);
	}

	private static List<ListNode> getListNodeSize(ListNode head, List<ListNode> list) {
		while (head != null) {
			list.add(head);
			return getListNodeSize(head.next, list);
		}
		return list;
	}

	/**
	 * 内循环算法
	 * 
	 * @param head
	 * @return
	 */
	public static ListNode reverseInnerLoop(ListNode head) {
		ListNode newNode = null;
		while (head != null) {
			// 下个结点
			ListNode nextNode = head.next;
			// 将head的下一个，指向新结点
			head.next = newNode;
			// 得到新的结点，完成反指
			newNode = head;
			// 指针结点，实现循环
			head = nextNode;
		}
		return newNode;
	}

	public static void main(String[] args) {
		// 创建链表
		ListNode head = createListNode(1, 5);
		// 递归链表
		// recusiveListNode(head);
		// 根据下标，查询链接
		// ListNode threeListNode = queryListNode(head.next, 1, 2);
		// if (threeListNode != null) {
		// System.out.println(threeListNode.val);
		// }
		// System.out.println("----");
		// 添加结点
		// addListNode(head, new ListNode(6), 3);
		// 根据下标修改结点数据
		// setListNodeVal(head, 3, 8);
		head = reverseInnerLoop(head);
		// 轮询链表
		loopListNode(head);
		System.out.println(Integer.MAX_VALUE);
	}
}
