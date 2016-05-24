package com.file.util.weixin;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.mouse.InvocationHandler.util.HttpRequestUtils;
import com.mouse.InvocationHandler.util.HttpUtils;
import org.apache.http.entity.StringEntity;

import java.io.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created  on 2016/5/24.
 */
public class TestWeiXinAPI {
	public static String ACCESS_TOKEN = "4qjzrm_ZLGQRCNAk9D8RWVrWNbc-9cZFaF9-HoFXzn0F6QhpwTFPJ-7AO9YqTnmr8wHNqEWWV-Ww3swEpi8UmVZeIvXhn6DnyOSUtXxBmxgDAKohy7ekFxjlB0NEaB4xZBZbAJAEGE";
	public static String getUserInfoUrl = "https://api.weixin.qq" +
			".com/cgi-bin/user/info?access_token=" + ACCESS_TOKEN + "&openid=%s&lang=zh_CN";
	public static String getUserList = "https://api.weixin.qq" +
			".com/cgi-bin/user/get?access_token=" + ACCESS_TOKEN + "&next_openid=";

	public static List<String> getOpenIdList() {
		String json = HttpRequestUtils.sendGet(getUserList);
		JSONObject jsonObject = JSON.parseObject(json);
		JSONArray jsonArray = jsonObject.getJSONObject("data").getJSONArray("openid");
		return Arrays.asList(jsonArray.toArray(new String[]{}));
	}

	public static String getUserInfo() {
		StringBuilder sb = new StringBuilder();
		List<String> openIds = getOpenIdList();
		for (String openid : openIds) {
			System.out.println(openid);
			String json = HttpRequestUtils.sendGet(String.format(getUserInfoUrl, new Object[]{openid}));
			json += "\r\t";
			sb.append(json);
		}
		return sb.toString();
	}

	public static void writeToFile(String str, File file) {
		BufferedWriter bufferedWriter = null;
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
			bufferedWriter.write(str);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		/*File file=new File("D:\\result.txt");
		String str=getUserInfo();
		writeToFile(str,file);*/
		List<String> openidList = Lists.newArrayList();
		openidList.add("okBG6jvj8nGX-5LPyIcDJkA4TS14");


	}

	public static void testHB() {
		String url = "http://localhost:47863/Default.aspx";
		String xml = "<xml>\n" +
				"<ToUserName><![CDATA[neversaycare]]></ToUserName>\n" +
				"<FromUserName><![CDATA[oLSFZwEb7JDhJffue1bDvhRwNSM4]]></FromUserName>\n" +
				"<CreateTime>123456789</CreateTime>\n" +
				"<MsgType><![CDATA[event]]></MsgType>\n" +
				"<Event><![CDATA[CLICK]]></Event>\n" +
				"<EventKey><![CDATA[CLICK_Notification]]></EventKey>\n" +
				"</xml>";
		try {
			StringEntity stringEntity = new StringEntity(xml);
			HttpUtils.post(url, stringEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public static void testHB1() {
		String url = "http://localhost:47863/Default.aspx";
		String xml = "<xml>\n" +
				"<ToUserName><![CDATA[neversaycare]]></ToUserName>\n" +
				"<FromUserName><![CDATA[oLSFZwEb7JDhJffue1bDvhRwNSM4]]></FromUserName>\n" +
				"<CreateTime>123456789</CreateTime>\n" +
				"<MsgType><![CDATA[event]]></MsgType>\n" +
				"<Event><![CDATA[CLICK]]></Event>\n" +
				"<EventKey><![CDATA[CLICK_Notification]]></EventKey>\n" +
				"</xml>";
		try {
			StringEntity stringEntity = new StringEntity(xml);
			HttpUtils.post(url, stringEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}

	public static void testHB2() {
		String url = "http://localhost:47863/Default.aspx";
		String xml = "<xml>\n" +
				"\t<ToUserName><![CDATA[neversaycare]]></ToUserName>\n" +
				"\t<FromUserName><![CDATA[oLSFZwEb7JDhJffue1bDvhRwNSM4]]></FromUserName>\n" +
				"\t<CreateTime>1348831860</CreateTime>\n" +
				"\t<MsgType><![CDATA[text]]></MsgType>\n" +
				"\t<Content><![CDATA[TY927561NNX5235563814]]></Content>\n" +
				"\t<MsgId>1234567890123456</MsgId>\n" +
				"\t</xml>";
		try {
			StringEntity stringEntity = new StringEntity(xml);
			HttpUtils.post(url, stringEntity);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

	}
}
