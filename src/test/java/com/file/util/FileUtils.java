package com.file.util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by huawei on 2016/4/7.
 */
public class FileUtils {

	public static List<String[]> getContent(String filePath){
		List<String[]> result=new ArrayList<String[]>();
		File file=new File(filePath);
		BufferedReader bReader=null;
		try {
			bReader=new BufferedReader(new InputStreamReader(new FileInputStream(file),"UTF-8"));
			String line=bReader.readLine();
			while(line!=null){
				String []strs=line.split(",");
				for (int i = 0; i <strs.length ; i++) {
					strs[i]=strs[i].trim();
				}
				result.add(strs);
				line=bReader.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void readCrmProvince(){
		String filepath="C:\\Users\\xiaobao\\Desktop\\address\\crm省.txt";
		List<String[]> result=getContent(filepath);
		int count=0;
		for (int i = 1; i <result.size() ; i++) {
			String []values=result.get(i);
			if(values==null||values.length!=2){
				System.out.println(String.format("读取crmProvince第  %s  行出错",new Object[]{(i+1)+""}));
			}else {
				String sql = String.format("insert into crmProVince(crmProvinceId,crmProvince) values('%s','%s');", new
						Object[]{values[0], values[1]});
				System.out.println(sql);
//				DBUtil.executeSql(sql);
				count++;
			}
		}
		System.out.println(String.format("总共插入了数据 %s 条",new Object[]{count+""}));
	}

	public static void readCrmCity(){
		String filepath="C:\\Users\\xiaobao\\Desktop\\address\\crm市.txt";
		List<String[]> result=getContent(filepath);
		int count=0;
		for (int i = 1; i <result.size() ; i++) {
			String []values=result.get(i);
			if(values==null||values.length!=4){
				System.out.println(String.format("读取crmCity第  %s  行出错",new Object[]{(i+1)+""}));
			}else {
				String sql = String.format("insert into crmCity(crmCityId,crmCity,crmProvinceId,crmProvince) values" +
						"('%s','%s','%s','%s');", new
						Object[]{values[0], values[1], values[2], values[3]});
				System.out.println(sql);
//				DBUtil.executeSql(sql);
				count++;
			}
		}
		System.out.println(String.format("总共插入了数据 %s 条",new Object[]{count+""}));
	}

	public static void readCrmDistrict(){
		String filepath="C:\\Users\\xiaobao\\Desktop\\address\\crm区.txt";
		List<String[]> result=getContent(filepath);
		int count=0;
		for (int i = 1; i <result.size() ; i++) {
			String []values=result.get(i);
			if(values==null||values.length!=4){
				System.out.println(String.format("读取crmProvince第  %s  行出错",new Object[]{(i+1)+""}));
			}else {
				String sql = String.format("insert into crmDistrict(crmDistrictId,crmDistrict,crmCityId,crmCity) " +
						"values('%s','%s','%s','%s');", new
						Object[]{values[0], values[1], values[2], values[3]});
				System.out.println(sql);
//				DBUtil.executeSql(sql);
				count++;
			}
		}
		System.out.println(String.format("总共插入了数据 %s 条",new Object[]{count+""}));
	}

	public static void readTaobaoAll(){
		String filepath="C:\\Users\\xiaobao\\Desktop\\address\\淘宝标准地址.txt";
		List<String[]> result=getContent(filepath);
		int count=0;
		for (int i = 1; i <result.size() ; i++) {
			String []values=result.get(i);
			if(values==null||values.length!=2){
				System.out.println(String.format("读取taobaoall第  %s  行出错",new Object[]{(i+1)+""}));
			}else {
				String sql = String.format("insert into taobaoAll(taobaoId,taobao) values('%s','%s');", new
						Object[]{values[0], values[1]});
				System.out.println(sql);
//				DBUtil.executeSql(sql);
				count++;
			}
		}
		System.out.println(String.format("总共插入了数据 %s 条",new Object[]{count+""}));
	}

	public static void main(String[] args) {
//		readCrmProvince();
//		readCrmCity();
//		readCrmDistrict();
		readTaobaoAll();
	}

}
