package com.mouse.InvocationHandler.util;

/**
 * Created  on 2016/5/25.
 */
public class ThreadUtils {

	/**
	 * 线程休息sec秒
	 *
	 * @param sec
	 */
	public static void sleep(int sec) {
		int i = 1;
		while (i <= sec) {
			try {
				Thread.sleep(1000);
				System.out.println(i + "秒....");
				i++;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
