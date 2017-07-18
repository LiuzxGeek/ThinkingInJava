package com.java.thinking.alto;

import java.util.UUID;

public class TestUuid {
	public static void main(String[] args) {
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.randomUUID());
		System.out.println(UUID.nameUUIDFromBytes("123".getBytes()));
		System.out.println(UUID.nameUUIDFromBytes("123".getBytes()));

		UUID uuid = new UUID(128, 64);
		System.out.println(uuid.getLeastSignificantBits());
		System.out.println(uuid.getMostSignificantBits());
		System.out.println(uuid.variant());
		System.out.println(uuid.version());

		/**
		 * java.lang.IllegalArgumentException: Invalid UUID string: a12safda3
		 */
		// System.out.println(UUID.fromString("a12safda3"));
		// System.out.println(UUID.fromString("a12safda3"));

		/**
		 * java.lang.UnsupportedOperationException: Not a time-based UUID
		 */
		// System.out.println(uuid.clockSequence());
		// System.out.println(uuid.clockSequence());
		// System.out.println(uuid.node());
		// System.out.println(uuid.timestamp());
	}
}
