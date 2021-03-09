package com.java.thinking.leetcode.hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxEnvelopes {
	static int ans = 0;

	public static int maxEnvelopes(int[][] envelopes) {
		int len = envelopes.length;
		if (len >= 1) {
			ans = 1;
			maxEnvelopes(envelopes, 0, new ArrayList<int[]>());
		}
		return ans;
	}

	public static void maxEnvelopes(int[][] envelopes, int index, List<int[]> list) {
		while (index < envelopes.length) {
			int[] attr = envelopes[index];
			// 找到attr可以插入的位置
			int start = 0;
			int end = list.size() - 1;
			boolean shouldAdd = true;
			while (start <= end) {
				int mid = end + start >> 1;
				int[] ar = list.get(mid);
				if (ar[0] > attr[0] && ar[1] > attr[1]) {
					end = mid - 1;
				} else if (ar[0] < attr[0] && ar[1] < attr[1]) {
					start = mid + 1;
				} else {
					shouldAdd = false;
					break;
				}
			}
			if (shouldAdd) {
				list.add(start, attr);
				ans = Math.max(ans, list.size());
			}
			maxEnvelopes(envelopes, index++ + 1, list);
			// 主要这里，可以删除失败
			list.remove(attr);
		}
	}

	public static int maxEnvelopes2(int[][] envelopes) {
		int len = envelopes.length;
		int ans = 0;
		if (len >= 1) {
			ans = 1;
			// 按照第一维进行升序，如相等则比较第二维
			Arrays.sort(envelopes, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if (o1[0] != o2[0]) {
						return o1[0] - o2[0];
					}
					return o2[1] - o1[1];
				}
			});
			int[] arr = new int[len];
			Arrays.fill(arr, 1);
			for (int i = 1; i < len; i++) {
				for (int j = 0; j < i; j++) {
					if (envelopes[i][1] > envelopes[j][1]) {
						// 与前面组合的元素个数+1进行比较
						arr[i] = Math.max(arr[i], arr[j] + 1);
					}
				}
				ans = Math.max(arr[i], ans);
			}
		}
		return ans;
	}

	public static int maxEnvelopes3(int[][] envelopes) {
		int len = envelopes.length;
		int ans = 0;
		if (len >= 1) {
			// 按照x进行升序，如相等则按y降序
			Arrays.sort(envelopes, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					// TODO Auto-generated method stub
					if (o1[0] != o2[0]) {
						return o1[0] - o2[0];
					}
					return o2[1] - o1[1];
				}
			});
			List<Integer> list = new ArrayList<>();
			list.add(envelopes[0][1]);
			for (int i = 1; i < len; i++) {
				int num = envelopes[i][1];
				if (num > list.get(list.size() - 1)) {
					list.add(num);
				} else {
					int index = 0;
					int high = list.size() - 1;
					// 要替换前面y大的值，这样才能容得下更多元素
					while (index < high) {
						int mid = high + index >> 1;
						if (num > list.get(mid)) {
							index = mid + 1;
						} else {
							high = mid;
						}
					}
					list.set(index, num);
				}
			}
			ans = list.size();
		}
		return ans;
	}

	public static int maxEnvelopes4(int[][] envelopes) {
		if (envelopes.length == 0) {
			return 0;
		}
		int n = envelopes.length;
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] e1, int[] e2) {
				if (e1[0] != e2[0]) {
					return e1[0] - e2[0];
				} else {
					return e2[1] - e1[1];
				}
			}
		});

		List<Integer> f = new ArrayList<Integer>();
		f.add(envelopes[0][1]);
		for (int i = 1; i < n; ++i) {
			int num = envelopes[i][1];
			if (num > f.get(f.size() - 1)) {
				f.add(num);
			} else {
				int index = binarySearch(f, num);
				f.set(index, num);
			}
		}
		return f.size();
	}

	public static int binarySearch(List<Integer> f, int target) {
		int low = 0, high = f.size() - 1;
		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (f.get(mid) < target) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	// [[2, 100], [3, 200], [4, 300], [5, 250], [5, 400], [5, 500], [6, 360], [6,
	// 370], [7, 380]]
	public static void main(String[] args) {
		int[][] envelopes = { { 2, 100 }, { 3, 200 }, { 4, 300 }, { 5, 500 }, { 5, 400 }, { 5, 250 }, { 6, 370 },
				{ 6, 360 }, { 7, 380 } };
		// envelopes = new int[][] { { 21, 33 }, { 27, 39 }, { 6, 29 }, { 45, 2 }, { 5,
		// 16 }, { 14, 15 }, { 31, 31 },
		// { 28, 43 }, { 14, 13 }, { 44, 29 }, { 44, 47 }, { 26, 1 }, { 40, 18 }, { 33,
		// 6 }, { 39, 40 },
		// { 39, 13 }, { 1, 33 }, { 31, 4 }, { 21, 40 }, { 50, 14 }, { 17, 44 }, { 21,
		// 22 }, { 32, 41 },
		// { 18, 28 }, { 29, 50 }, { 9, 24 }, { 25, 26 }, { 32, 30 }, { 17, 32 }, { 21,
		// 2 }, { 17, 39 } };
		// envelopes = new int[][] { { 2, 3 }, { 5, 4 }, { 6, 7 } };
		// envelopes = new int[][] { { 4, 5 }, { 4, 6 }, { 6, 7 }, { 2, 3 }, { 1, 1 } };
		// envelopes = new int[][] { { 15, 8 }, { 2, 20 }, { 2, 14 }, { 4, 17 }, { 8, 19
		// }, { 8, 9 }, { 5, 7 }, { 11, 19 },
		// { 8, 11 }, { 13, 11 }, { 2, 13 }, { 11, 19 }, { 8, 11 }, { 13, 11 }, { 2, 13
		// }, { 11, 19 }, { 16, 1 },
		// { 18, 13 }, { 14, 17 }, { 18, 19 } };
		// envelopes = new int[][] { { 5, 4 }, { 6, 4 }, { 6, 7 }, { 5, 6 } };
		// { { 5, 6 } ,{ 5, 4 }, { 6, 7 },{ 6, 4 } };
		System.out.println(maxEnvelopes3(envelopes));
		int left = 0;
		int area = 5;
		int dif = 0;
		while (((left = area - dif) & 1) == 1 || (area % (left >> 1)) == 1) {
			// area-dif是奇数，或者area跟area-dif除2的余数是奇数
			// dif=0 5, | 1 4,3 | 2 3, | 3 2,5 | 4 1 | 5 0,
			dif++;
		}
	}
}
