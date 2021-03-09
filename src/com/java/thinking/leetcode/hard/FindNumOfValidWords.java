package com.java.thinking.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNumOfValidWords {
	public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
		List<Integer> ans = new ArrayList<Integer>(puzzles.length);
		for (String puz : puzzles) {
			int count = 0;
			String first = String.valueOf(puz.charAt(0));
			for (String wor : words) {
				boolean find = true;
				if (!wor.contains(first)) {
					continue;
				}
				for (int i = 0; i < wor.length(); i++) {
					if (!puz.contains(String.valueOf(wor.charAt(i)))) {
						find = false;
						break;
					}
				}
				if (find) {
					count++;
				}
			}
			ans.add(count);
		}
		return ans;
	}

	public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
		List<Integer> ans = new ArrayList<Integer>(puzzles.length);
		List<List<Character>> wordList = new ArrayList<>();
		List<Character> wordChild;
		for (String wor : words) {
			wordChild = new ArrayList<>();
			char[] arr = wor.toCharArray();
			Arrays.sort(arr);
			for (char ch : arr) {
				if (!wordChild.contains(ch)) {
					wordChild.add(ch);
				}
			}
			wordList.add(wordChild);
		}
		List<List<Character>> puzList = new ArrayList<>();
		List<Character> puzChild;
		for (String puz : puzzles) {
			puzChild = new ArrayList<>();
			char[] arr = puz.toCharArray();
			Arrays.sort(arr);
			for (char ch : arr) {
				if (!puzChild.contains(ch)) {
					puzChild.add(ch);
				}
			}
			puzChild.add(0, puz.charAt(0));
			puzList.add(puzChild);
		}
		for (List<Character> pList : puzList) {
			int count = 0;
			Character first = pList.remove(0);
			for (List<Character> wList : wordList) {
				if (!wList.contains(first)) {
					continue;
				}
				boolean find = true;
				for (Character ch : wList) {
					if (!pList.contains(ch)) {
						find = false;
						break;
					}
				}
				if (find) {
					count++;
				}
			}
			ans.add(count);
		}
		return ans;
	}

	public List<Integer> findNumOfValidWords3(String[] words, String[] puzzles) {
		List<Integer> ans = new ArrayList<Integer>();
		for (String puz : puzzles) {
			int pb = getBinary(puz);
			int count = 0;
			char first = puz.charAt(0);
			for (String word : words) {
				int wb = getBinary(word);
				if ((wb >> first & 1) == 0) {
					// 代表不存在首字母
					continue;
				}
				if ((wb & pb) == wb) {
					count++;
				}
			}
			ans.add(count);
		}
		return ans;
	}

	private int getBinary(String str) {
		int ans = 0;
		char[] arr = str.toCharArray();
		for (char ch : arr) {
			int index = ch - 'a';
			if ((ans << index & 1) == 0) {
				// 不存在
				ans += 1 << index;
			}
		}
		return ans;
	}
}
