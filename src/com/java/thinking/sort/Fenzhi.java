package com.java.thinking.sort;

public class Fenzhi {
	// 插入，从小到大；冒泡，从大到小；二分法，分块处理，最后合并
	private int[] fenzhi(int[] attr) {
		if (attr.length > 2) {
			int[] first = new int[attr.length / 2];
			System.arraycopy(attr, 0, first, 0, first.length);
			int[] last = new int[attr.length - attr.length / 2];
			System.arraycopy(attr, attr.length / 2, last, 0, last.length);
			return merge(fenzhi(first), fenzhi(last));
		}
		attr = sort(attr);
		return attr;
	}

	/**
	 * 只剩下1个或2个，或者0个元素
	 * 
	 * @param attr
	 * @return
	 */
	private int[] sort(int[] attr) {
		if (attr.length == 2) {
			if (attr[1] < attr[0]) {
				int tem = attr[1];
				attr[1] = attr[0];
				attr[0] = tem;
			}
		}
		return attr;
	}

	private int[] merge(int[] attr1, int[] attr2) {
		int attr[] = new int[attr1.length + attr2.length];
		int count = 0;
		for (int i = 0, j = 0; i < attr1.length || j < attr2.length;) {
			if (i < attr1.length && j < attr2.length) {
				int av = attr1[i];
				int bv = attr2[j];
				if (av <= bv) {
					attr[count++] = av;
					i++;
				} else {
					attr[count++] = bv;
					j++;
				}
			} else if (i < attr1.length) {
				attr[count++] = attr1[i];
				i++;
			} else if (j < attr2.length) {
				attr[count++] = attr2[j];
				j++;
			}
		}
		return attr;
	}

	public static void main(String[] args) {
		Fenzhi fenzhi = new Fenzhi();
		int[] result = fenzhi.fenzhi(new int[] { 10, 8, 7, 7, 2, 9, 3, 0, 1 });
		for (int v : result) {
			System.out.println(v);
		}
	}
}
