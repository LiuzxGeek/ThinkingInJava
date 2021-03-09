package com.java.thinking.leetcode.mid;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToIntFunction;

public class ClosestCost {

	public static int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		int ans = 0;
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		for (int i = 0, n = baseCosts.length; i < n; i++) {
			int base = baseCosts[i];
			if (base == target) {
				return base;
			} else if (base > target) {
				if (ans == 0) {
					ans = base;
				} else if (Math.abs(ans - target) > base - target) {
					ans = base;
				} else if (Math.abs(ans - target) == base - target) {
					if (ans > base) {
						ans = base;
					}
				}
			} else {
				if (list.size() == 0) {
					// 获得配料的所有可能性
					getClosetNumber(toppingCosts, 0, new ArrayList<Integer>(), list);
				}
				boolean flag = false;
				int sum = base;
				for (List<Integer> al : list) {
					for (Integer num : al) {
						sum += num;
						if (Math.abs(sum - target) > Math.abs(ans - target)) {
							flag = true;
							break;
						}
					}
				}
				if (!flag) {
					if (sum == target) {
						return sum;
					} else if (ans == 0) {
						ans = sum;
					} else if (Math.abs(sum - target) < Math.abs(ans - target)) {
						ans = sum;
					} else if (Math.abs(sum - target) == Math.abs(ans - target)) {
						if (ans > sum) {
							ans = sum;
						}
					}
				}
			}
		}
		return ans;
	}

	private static void getClosetNumber(int[] arr, int index, List<Integer> tem, List<List<Integer>> list) {
		if (index == arr.length) {
			list.add(new ArrayList<>(tem));
			return;
		}
		for (int i = 0; i < 3; i++) {
			int value = i * arr[index];
			tem.add(value);
			getClosetNumber(arr, index + 1, tem, list);
			tem.remove(tem.size() - 1);
		}
	}

	private static void test(int[] toppingCosts) {
		List<String> list = new ArrayList<String>();
		// 获得配料的所有可能性
		getClosetNumber2(toppingCosts, 0, new ArrayList<String>(), list);
		System.out.println(list);
	}

	private static void getClosetNumber2(int[] arr, int index, List<String> tem, List<String> list) {
		if (index == arr.length) {
			String result = "";
			for (String sr : tem) {
				result += sr + "+";
			}
			list.add(result.substring(0, result.length() - 1));
			return;
		}
		for (int i = 0; i < 3; i++) {
			tem.add(String.valueOf(i) + "*" + arr[index]);
			getClosetNumber2(arr, index + 1, tem, list);
			tem.remove(tem.size() - 1);
		}
	}

	public static void origin() {
		List<Integer> list = new ArrayList<>();
		int[] arr = { 1, 2, 3, 4 };
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += i * arr[0];
			for (int i1 = 0; i1 < 3; i1++) {
				sum += i1 * arr[1];
				for (int i2 = 0; i2 < 3; i2++) {
					sum += i2 * arr[2];
					for (int i3 = 0; i3 < 3; i3++) {
						sum += i3 * arr[3];
						list.add(sum);
					}
				}
			}
		}
		System.out.println(list.size());
		System.out.println(list);
	}

	public static List<Integer> closestCost(int[] baseCosts) {
		List<Integer> ans = new ArrayList<>();
		closestCost(baseCosts, 0, 3, ans, new ArrayList<>());
		return ans;
	}

	public static void closestCost(int[] baseCosts, int index, int size, List<Integer> ans, List<Integer> tem) {
		if (index == size + 1) {
			// 数组长度为4，跟size间的差距为1
			int value = tem.stream().mapToInt(new ToIntFunction<Integer>() {
				@Override
				public int applyAsInt(Integer value) {
					// TODO Auto-generated method stub
					return value;
				}
			}).sum();
			ans.add(value + (ans.size() > 0 ? ans.get(ans.size() - 1) : 0));
			return;
		}
		for (int i = 0; i < size; i++) {
			int value = i * baseCosts[index];
			tem.add(value);
			closestCost(baseCosts, index + 1, size, ans, tem);
			tem.clear();
		}
	}

	public static void main(String[] args) {
		// origin();
		// int[] arr = new int[] { 1, 2, 3, 4 };
		// List<Integer> list = closestCost(arr);
		// System.out.println(list);
		// System.out.println(list.size());
		// System.out.println(list.stream().mapToInt(new ToIntFunction<Integer>() {
		// @Override
		// public int applyAsInt(Integer value) {
		// // TODO Auto-generated method stub
		// return value;
		// }
		// }).sum());
		// System.out.println(Arrays.asList(1, 2, 3).stream().mapToInt(new
		// ToIntFunction<Integer>() {
		// @Override
		// public int applyAsInt(Integer value) {
		// // TODO Auto-generated method stub
		// return value;
		// }
		// }).sum());
		int[] baseCosts = { 2, 3 };
		int[] toppingCosts = { 4, 5, 100 };
		int target = 18;
		System.out.println(closestCost(baseCosts, toppingCosts, target));
		String[] attr="aba".split("b");
		System.out.println(attr.length);
		for(String str:attr) {
			System.out.println(str);
		}
		// test(toppingCosts);
	}

}
