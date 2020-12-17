package com.java.thinking.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxNumber {
	public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
		List<ListBean> list = new ArrayList<>();
		addArray2List(nums1, list);
		addArray2List(nums2, list);
		Collections.sort(list, new Comparator<ListBean>() {
			@Override
			public int compare(ListBean o1, ListBean o2) {
				// TODO Auto-generated method stub
				// 倒序
				return o2.value - o1.value;
			}
		});
		System.out.println("排序后的结果：");
		ListBean lastBean = null;
		List<ListBean> num1List = new ArrayList<>();
		List<ListBean> num2List = new ArrayList<>();
		for (int i = 0; i < list.size(); i++) {
			ListBean currBean = list.get(i);
			if (lastBean == null) {
				lastBean = currBean;
			} else {
				if (lastBean.value == currBean.value) {
					if (lastBean.key == 1) {
						num1List.add(lastBean);
					} else {
						num2List.add(lastBean);
					}
					if (currBean.key == 1) {
						num1List.add(currBean);
					} else {
						num2List.add(currBean);
					}
				} else {
					if (currBean.key == 1) {
						// 第一个数组
						for (int j = 0; j < list.size(); j++) {
							ListBean bean = list.get(i);
						}
					} else {
					}
				}
			}
		}
		for (ListBean bean : list) {
			System.out.println(bean.getValue() + ":" + bean.getKey() + ":" + bean.getIndex());
		}
		System.out.println("--------------");
		int[] result = new int[k];
		getProperBig(nums1, nums2, k, -1, -1, result, list, 0);
		System.out.println("最终结果：");
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
		return result;
	}

	private static int[] getProperBig(int[] nums1, int[] nums2, int leftNumber, int num1Index, int num2Index,
			int[] result, List<ListBean> list, int listIndex) {
		if (list.size() > 0 && list.size() > listIndex) {
			ListBean bean = list.get(listIndex);
			if (bean.getKey() == 1) {
				if (bean.index > num1Index) {
					int leftCount1 = nums1.length - bean.index;
					int leftCount2 = nums2.length - (num2Index == -1 ? 0 : num2Index);
					if ((leftCount1 + leftCount2) >= leftNumber) {
						result[result.length - leftNumber] = bean.value;
						list.remove(listIndex);
						listIndex = 0;
						leftNumber--;
						num1Index = bean.index;
					} else {
						// 进入下个循环
						listIndex++;
					}
				} else {
					// 进入下个循环
					listIndex++;
				}
			} else {
				if (bean.index > num2Index) {
					int leftCount1 = nums1.length - (num1Index == -1 ? 0 : (num1Index + 1));
					int leftCount2 = nums2.length - bean.index;
					if ((leftCount1 + leftCount2) >= leftNumber) {
						result[result.length - leftNumber] = bean.value;
						list.remove(listIndex);
						listIndex = 0;
						leftNumber--;
						num2Index = bean.index;
					} else {
						// 进入下个循环
						listIndex++;
					}
				} else {
					// 进入下个循环
					listIndex++;
				}
			}
		}
		if (leftNumber == 0) {
			return result;
		}
		return getProperBig(nums1, nums2, leftNumber, num1Index, num2Index, result, list, listIndex);
	}

	private static void addArray2List(int[] nums, List<ListBean> list) {
		ListBean bean;
		int key = list.size() > 0 ? 2 : 1;
		for (int i = 0; i < nums.length; i++) {
			bean = new ListBean(key, i, nums[i]);
			list.add(bean);
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] { 6, 7 };// { 3, 4, 6, 5 };
		int[] nums2 = new int[] { 6, 0, 4 };// { 9, 1, 2, 5, 8, 3 };
		maxNumber(nums1, nums2, 5);
		System.out.println(3 - 1 + 0 > 2);
	}

	public static class ListBean {
		private int key = 0;
		private int index = 0;
		private int value = 0;

		public ListBean(int key, int index, int value) {
			super();
			this.key = key;
			this.index = index;
			this.value = value;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}

		public int getIndex() {
			return index;
		}

		public void setIndex(int index) {
			this.index = index;
		}

		public int getValue() {
			return value;
		}

		public void setValue(int value) {
			this.value = value;
		}

	}
}
