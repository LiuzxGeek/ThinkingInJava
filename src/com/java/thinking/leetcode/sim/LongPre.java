package com.java.thinking.leetcode.sim;

/**
 * https://leetcode-cn.com/problems/longest-common-prefix/submissions/
 * 
 * @author fred
 *
 */
public class LongPre {

	public String longestCommonPrefix(String[] strs) {
		if (strs != null && strs.length > 0) {
			// 最短字符串
			String sho = "";
			int sl = 0;
			for (String str : strs) {
				if (sl == 0 || str.length() < sl) {
					sl = str.length();
					sho = str;
				}
			}
			while (!sho.equals("") && sho.length() > 0) {
				// 从最长开始遍历
				boolean exist = true;
				for (String str : strs) {
					if (!str.startsWith(sho)) {
						exist = false;
						break;
					}
				}
				if (exist) {
					return sho;
				}
				sho = sho.substring(0, sho.length() - 1);
			}
		}
		return "";
	}

	public static void main(String[] args) {
		LongPre longPre = new LongPre();
		System.out.println(longPre.longestCommonPrefix(new String[] { "reflower", "flow", "flight" }));
	}
}
