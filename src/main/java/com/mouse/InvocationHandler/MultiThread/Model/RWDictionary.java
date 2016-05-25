package com.mouse.InvocationHandler.MultiThread.Model;

import com.mouse.InvocationHandler.util.ThreadUtils;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created  on 2016/5/25.
 */
public class RWDictionary {
	private final Map<String, String> m = new TreeMap<String, String>();
	private final ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private final Lock r = rwl.readLock();
	private final Lock w = rwl.writeLock();

	public String get(String key) {
		r.lock();
		try {
			ThreadUtils.sleep(5);
			return m.get(key);
		} finally {
			r.unlock();
		}
	}

	public Object[] allKeys() {
		r.lock();
		try {
			return m.keySet().toArray();
		} finally {
			r.unlock();
		}
	}

	public String put(String key, String value) {
		w.lock();
		try {
			ThreadUtils.sleep(5);
			return m.put(key, value);
		} finally {
			w.unlock();
		}
	}

	public void clear() {
		w.lock();
		try {
			m.clear();
		} finally {
			w.unlock();
		}
	}
}
