package com.java.thinking.leetcode.hard;

import java.util.Arrays;

public class MinCut {

	public int minCut4(String s) {
		int len = s.length();
		// 默认从第一个开始，每个元素都需要分裂
		int[] attr = new int[len];
		Arrays.fill(attr, len);
		// 以i为中心，寻找奇数个或者偶数个元素
		for (int i = 0, flag = 0; i < len; i += flag, flag = (flag + 1) % 2) {
			for (int left = i, right = i + flag; left >= 0 && right < len; left--, right++) {
				if (s.charAt(left) != s.charAt(right)) {
					break;
				}
				//以right下标代表的字符为结尾的字符串，最少需要分裂的次数
				attr[right] = left == 0 ? 0 : Math.min(attr[left - 1] + 1, attr[right]);
				//left为0，代表直到最左边，一直是回文数，所以分裂数为0；否则，左侧的分裂数+当前的字符，即代表右侧的分裂
			}
		}
		return attr[len - 1];
	}

	int ans = 0;

	public int minCut(String s) {
		longestPalindrome(s);
		return ans;
	}

	public void longestPalindrome(String s) {
		int[] target = new int[2];
		char[] attr = s.toCharArray();
		int len = attr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = i + 1; j < len; j++) {
				if (isPalindrome(attr, i, j)) {
					if (j - i > target[1] - target[0]) {
						target[0] = i;
						target[1] = j;
					}
				}
			}
		}
		if (target[0] > 0) {
			ans++;
			longestPalindrome(s.substring(0, target[0]));
		}
		if (target[1] < len - 1) {
			ans++;
			longestPalindrome(s.substring(target[1] + 1));
		}
	}

	public boolean isPalindrome(char[] attr, int left, int right) {
		while (left < right) {
			if (attr[left] == attr[right]) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	public int minCut2(String s) {
		int n = s.length();
		boolean[][] g = new boolean[n][n];
		for (int i = 0; i < n; ++i) {
			Arrays.fill(g[i], true);
		}

		for (int i = n - 2; i >= 0; --i) {
			for (int j = i + 1; j < n; ++j) {
				g[i][j] = s.charAt(i) == s.charAt(j) && g[i + 1][j - 1];
			}
		}

		int[] f = new int[n];
		Arrays.fill(f, Integer.MAX_VALUE);
		for (int i = 0; i < n; ++i) {
			if (g[0][i]) {
				f[i] = 0;
			} else {
				for (int j = 0; j < i; ++j) {
					if (g[j + 1][i]) {
						f[i] = Math.min(f[i], f[j] + 1);
					}
				}
			}
		}

		return f[n - 1];
	}

	public int minCut3(String s) {
		if (s == null || s.length() < 2)
			return 0;
		int len = s.length();
		char[] chars = s.toCharArray();
		int[] dp = new int[len];
		Arrays.fill(dp, len);
		for (int i = 0, flag = 0; i < len; i += flag, flag = (flag + 1) % 2) {
			for (int left = i, right = i + flag; left >= 0 && right < len; left--, right++) {
				if (chars[left] != chars[right])
					break;
				dp[right] = left == 0 ? 0 : Math.min(dp[right], dp[left - 1] + 1);
			}
		}
		return dp[len - 1];
	}

	public static void main(String[] args) {
		MinCut cut = new MinCut();
		String s = "eegiicgaeadbcfacfhifdbiehbgejcaeggcgbahfcajfhjjdgj";
		// s = "bb";
		// s = "aab";
		// s = "ab";
		// s = "aaabaa";
		s = "apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp";
		s = "adabdcaebdcebdcacaaaadbbcadabcbeabaadcbcaaddebdbddcbdacdbbaedbdaaecabdceddccbdeeddccdaabbabbdedaaabcdadbdabeacbeadbaddcbaacdbabcccbaceedbcccedbeecbccaecadccbdbdccbcbaacccbddcccbaedbacdbcaccdcaadcbaebebcceabbdcdeaabdbabadeaaaaedbdbcebcbddebccacacddebecabccbbdcbecbaeedcdacdcbdbebbacddddaabaedabbaaabaddcdaadcccdeebcabacdadbaacdccbeceddeebbbdbaaaaabaeecccaebdeabddacbedededebdebabdbcbdcbadbeeceecdcdbbdcbdbeeebcdcabdeeacabdeaedebbcaacdadaecbccbededceceabdcabdeabbcdecdedadcaebaababeedcaacdbdacbccdbcece";
		// s = "bdaadbbaabbdaad";
		System.out.println(cut.minCut4(s));
		System.out.println(cut.minCut3(s));
		new String(new char[3]);
	}
}
