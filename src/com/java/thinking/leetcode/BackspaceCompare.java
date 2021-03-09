package com.java.thinking.leetcode;

public class BackspaceCompare {
	public boolean backspaceCompare(String S, String T) {
		String s = S;
		String t = T;
		int bs = 0;
		int ts = 0;
		char[] sc = S.toCharArray();
		char[] tc = T.toCharArray();
		for (int i = sc.length - 1; i >= 0; i--) {
			if (sc[i] == '#') {
				bs++;
				sc[i] = ' ';
			} else {
				if (bs > 0) {
					bs--;
					sc[i] = ' ';
				}
			}
		}
		s = new String(sc);
		s = s.replaceAll(" ", "");
		for (int i = tc.length - 1; i >= 0; i--) {
			if (tc[i] == '#') {
				ts++;
				tc[i] = ' ';
			} else {
				if (ts > 0) {
					ts--;
					tc[i] = ' ';
				}
			}
		}
		t = new String(tc);
		t = t.replaceAll(" ", "");
		return t.equals(s);
	}

	public boolean backspaceCompare2(String S, String T) {
		int sIndex = S.length() - 1;
		int tIndex = T.length() - 1;
		while (sIndex > -1 || tIndex > -1) {
			int count = 0;
			while (sIndex > -1) {
				if (S.charAt(sIndex) == '#') {
					count++;
					sIndex--;
				} else {
					if (count > 0) {
						count--;
						sIndex--;
					} else if (count == 0) {
						break;
					}
				}
			}
			count = 0;
			while (tIndex > -1) {
				if (T.charAt(tIndex) == '#') {
					count++;
					tIndex--;
				} else {
					if (count > 0) {
						count--;
						tIndex--;
					} else if (count == 0) {
						// 比较当前值
						break;
					}
				}
			}
			char s = ' ';
			char t = ' ';
			if (sIndex > -1) {
				s = S.charAt(sIndex);
			}
			if (tIndex > -1) {
				t = T.charAt(tIndex);
			}
			if (s != t) {
				return false;
			}
			// 各退一步，解决下个字符问题
			sIndex--;
			tIndex--;
		}
		return true;
	}

	public static void main(String[] args) {
		BackspaceCompare compare = new BackspaceCompare();
		System.out.println(compare.backspaceCompare2("a#c", "b"));
	}
}
