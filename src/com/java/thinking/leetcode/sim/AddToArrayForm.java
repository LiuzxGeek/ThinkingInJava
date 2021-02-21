package com.java.thinking.leetcode.sim;

import java.util.ArrayList;
import java.util.List;

public class AddToArrayForm {

	public List<Integer> addToArrayForm(int[] A, int K) {
		long ar = 0;
		for (int i = 0; i < A.length; i++) {
			ar += Math.pow(10, A.length - 1 - i) * A[i];
		}
		ar += K;
		String re = String.valueOf(ar);
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < re.length(); i++) {
			list.add(re.charAt(i) - '0');
		}
		return list;
	}

	public List<Integer> addToArrayForm2(int[] A, int K) {
		String ks = String.valueOf(K);
		int[] ka = new int[ks.length()];
		int index = 0;
		while (index < ks.length()) {
			ka[index] = ks.charAt(index++) - '0';
		}
		int extra = 0;
		int count = 0;
		StringBuilder builder = new StringBuilder();
		while (A.length > count || ka.length > count) {
			int av = 0, kv = 0;
			if (A.length - count > 0) {
				av = A[A.length - count - 1];
			}
			if (ka.length - count > 0) {
				kv = ka[ka.length - count - 1];
			}
			int sum = av + kv + extra;
			builder.append(sum % 10);
			extra = sum / 10;
			count++;
		}
		if (extra > 0) {
			builder.append(extra);
		}
		String result = builder.reverse().toString();
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < result.length(); i++) {
			list.add(result.charAt(i) - '0');
		}
		return list;
	}

	public static void main(String[] args) {
		AddToArrayForm form = new AddToArrayForm();
		System.out.println(form.addToArrayForm2(new int[] { 9, 9, 9 }, 999));
	}
}
