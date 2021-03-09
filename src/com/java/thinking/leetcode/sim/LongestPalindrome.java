package com.java.thinking.leetcode.sim;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LongestPalindrome {
	public int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		char[] attr = s.toCharArray();
		for (int i = 0; i < attr.length; i++) {
			map.put(attr[i], map.getOrDefault(attr[i], 0) + 1);
		}
		Iterator<Character> it = map.keySet().iterator();
		int ans = 0;
		while (it.hasNext()) {
			int value = map.get(it.next());
			ans += value - (value & 1);
		}
		// ans肯定为偶数，如果比s短，则可以再多用一个字符串
		return ans < s.length() ? ans + 1 : ans;
	}

	public int longestPalindrome3(String s) {
		int[] result = new int[58];
		char[] attr = s.toCharArray();
		for (int i = 0; i < attr.length; i++) {
			result[attr[i] - 'A']++;
		}
		int ans = 0;
		for (int value : result) {
			ans += value - (value & 1);
		}
		// ans肯定为偶数，如果比s短，则可以再多用一个字符串
		return ans < s.length() ? ans + 1 : ans;
	}

	public int longestPalindrome2(String s) {
		int[] cnt = new int[58];
		for (char c : s.toCharArray()) {
			cnt[c - 'A'] += 1;
		}

		int ans = 0;
		for (int x : cnt) {
			// 字符出现的次数最多用偶数次。
			ans += x - (x & 1);
		}
		// 如果最终的长度小于原字符串的长度，说明里面某个字符出现了奇数次，那么那个字符可以放在回文串的中间，所以额外再加一。
		return ans < s.length() ? ans + 1 : ans;
	}

	public static void main(String[] args) {
		LongestPalindrome palindrome = new LongestPalindrome();
		System.out.println(palindrome.longestPalindrome3(
				"civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
	}
}
