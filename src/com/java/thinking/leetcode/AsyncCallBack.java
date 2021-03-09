package com.java.thinking.leetcode;
/*
*@author:liuxian
*@date:2020年7月8日
*/

import java.lang.ref.WeakReference;

public class AsyncCallBack<T> {
	private WeakReference<T> reference;

	public AsyncCallBack(WeakReference<T> reference) {
		super();
		this.reference = reference;
	}

	public boolean canBack() {
		return reference != null && reference.get() != null;
	}

	public T get() {
		return reference.get();
	}

	public void release() {
		reference.clear();
	}
}
