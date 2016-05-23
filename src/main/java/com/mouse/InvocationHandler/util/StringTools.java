package com.mouse.InvocationHandler.util;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Xiaobao on 15/10/29.
 */
public class StringTools {
	public static String trimPreAndSuf(String nets) {
		return StringUtils.replace(nets, "'", "");
	}

	/**
	 * 去掉最后一个逗号
	 *
	 * @param str
	 * @return
	 */
	public static String removeLastStr(String str, String reg) {
		if (StringUtils.isNotEmpty(str)) {
			str = str.substring(0, str.lastIndexOf(reg));
		}
		return str;
	}

}
