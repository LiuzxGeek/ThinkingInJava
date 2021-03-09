package com.java.thinking.data;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.Objects;

public interface IMap<E> {
	default int size() {
		return 0;
	}

	interface Entry<K, V> {
		public static <K, V> Comparator<Map.Entry<K, V>> comparingByKey(Comparator<? super K> cmp) {
			Objects.requireNonNull(cmp);
			return (Comparator<Map.Entry<K, V>> & Serializable) (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
		}
		public static <K, V> Comparator<Map.Entry<K, V>> getKey(Comparator<? super K> cmp) {
			Objects.requireNonNull(cmp);
			return (Comparator<Map.Entry<K, V>> & Serializable) (c1, c2) -> cmp.compare(c1.getKey(), c2.getKey());
		}
	}
}
