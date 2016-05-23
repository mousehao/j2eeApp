package com.mouse.InvocationHandler.util;

import org.apache.commons.lang.StringUtils;

import java.util.Collection;

/**
 * Created by huawei on 2016/1/7.
 */
public class StringUtil {

	public static String joinAndSplitByComma(Collection<String> codes) {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (String code : codes) {
			sb.append(code);
			if (counter != (codes.size())) {
				sb.append(",");
			}
			counter++;
		}
		return sb.toString();
	}

	public static String joinAndSplitByStr(Object[] objs, String str) {
		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (int i = 0; i < objs.length; i++) {
			sb.append(objs[i].toString());
			if (counter != (objs.length)) {
				sb.append(str);
			}
			counter++;
		}
		return sb.toString();
	}

	public static String getStrWhenNull(String checkValue, String returnStr) {
		return StringUtils.isEmpty(checkValue) ? returnStr : checkValue;
	}

	public static String truncateStr(String str, int num) {
		if (StringUtils.isEmpty(str)) {
			return "";
		}
		return str.length() > num ? str.substring(0, num) : str;
	}
}

