package com.java.thinking.leetcode.sim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class NumEquivDominoPairs {
	public int numEquivDominoPairs(int[][] dominoes) {
		Map<Integer, Queue<int[]>> map = new HashMap<>();
		for (int i = 0; i < dominoes.length; i++) {
			int sum = dominoes[i][0] + dominoes[i][1];
			Queue<int[]> queue = map.get(sum);
			if (queue == null) {
				queue = new LinkedList<>();
				map.put(sum, queue);
			}
			queue.offer(dominoes[i]);
		}
		int count = 0;
		for (int i = 0; i < dominoes.length; i++) {
			int sum = dominoes[i][0] + dominoes[i][1];
			Queue<int[]> queue = map.get(sum);
			if (queue.size() > 1) {
				Iterator<int[]> iterator = queue.iterator();
				while (iterator.hasNext()) {
					int[] target = iterator.next();
					if (target[0] == dominoes[i][0] || target[0] == dominoes[i][1]) {
						// 有一个数相等，则另一个数也相等
						count++;
					}
				}
				// 减去自己
				count--;
			}
			queue.remove(dominoes[i]);
		}
		return count;
	}

	public int numEquivDominoPairs2(int[][] dominoes) {
		int count = 0;
		Map<Integer, Queue<int[]>> map = new HashMap<>();
		for (int i = 0; i < dominoes.length; i++) {
			int sum = dominoes[i][0] + dominoes[i][1];
			Queue<int[]> queue = map.get(sum);
			if (queue == null) {
				queue = new LinkedList<>();
				map.put(sum, queue);
			} else {
				Iterator<int[]> iterator = queue.iterator();
				while (iterator.hasNext()) {
					int[] target = iterator.next();
					if (target[0] == dominoes[i][0] || target[0] == dominoes[i][1]) {
						// 有一个数相等，则另一个数也相等
						count++;
					}
				}
			}
			queue.offer(dominoes[i]);
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] { { 1, 2 }, { 2, 1 }, { 1, 2 }, { 5, 6 } };
		System.out.println((new NumEquivDominoPairs()).numEquivDominoPairs(arr));

	}
}
