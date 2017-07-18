package com.java.thinking.file;

import java.util.concurrent.locks.ReentrantLock;

public interface ILockInterface {
	ReentrantLock lock = new ReentrantLock();
}
