package com.file.util.MultiThread;

import com.mouse.InvocationHandler.MultiThread.Model.RWDictionary;
import org.junit.Test;

/**
 * Created  on 2016/5/25.
 */
public class SynchronizedTest {

	//	@Test
	public static void testReentrantReadWriteLock() {
		RWDictionary rwDictionary = new RWDictionary();
		//写一条数据
		new Thread(new Runnable() {
			@Override
			public void run() {
				rwDictionary.put("nickname", "superman");
				System.out.println("write one data...");

			}
		}).start();

		//5个线程同时读
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("read one data..." + rwDictionary.get("nickname"));
				}
			}).start();
		}
		new Thread(new Runnable() {
			@Override
			public void run() {
				rwDictionary.put("nickname", "superman1");
				System.out.println("write one data...");

			}
		}).start();
		//5个线程同时读
		for (int i = 0; i < 5; i++) {
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("read one data..." + rwDictionary.get("nickname"));
				}
			}).start();
		}
	}

	public static void main(String[] args) {
		testReentrantReadWriteLock();
	}
}
