package com.ssm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FileTest {
	
	@Test
	public void testRead() throws Exception{
		InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\skuList.txt")));
		
		BufferedReader br = new BufferedReader(reader);
		
		PrintWriter pw = new PrintWriter(new File("差异.txt"));
		String line = null;
		while((line = br.readLine()) != null){
			line ="'"+line+"'," +"\n";
			pw.write(line);
		}
		br.close();
		pw.close();
	}
	@Test
	public void testm() throws Exception{
		InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\lists.txt")));
		
		BufferedReader br = new BufferedReader(reader);
		PrintWriter pw = new PrintWriter(new File("sqls.txt"));
		String line = null;
		while((line = br.readLine()) != null){
			String sql = "select * from t_sku_stock_account_detail t WHERE t.`sku_no` =" + "'" + line
					+"'" +"AND t.`real_time` >=" + "\'2018-07-01\'"+ " AND t.`real_time` <=" + "\'2018-07-31\'" + 
					"AND t.`supplier_code` ="+"\'GYS00735\'" +" AND t.`org_code` =" + "\'YJ\'"+" AND t.`warehouse_code` ="+"\'45\';" +"\n";
			pw.write(sql);
		}
		br.close();
		pw.close();
	}
	
	@Test
	public void testReads() throws Exception{
		InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\重复sku.txt")));
		
		BufferedReader br = new BufferedReader(reader);
		
		PrintWriter pw = new PrintWriter(new File("repeat.txt"));
		String line = null;
		while((line = br.readLine()) != null){
			line ="'"+line+"'," +"\n";
			pw.write(line);
		}
		br.close();
		pw.close();
	}
	
	@Test
	public void testReadss() throws Exception{
		InputStreamReader reader = new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\期初数量不对sku.txt")));
		InputStreamReader readers = new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\对应库存数量.txt")));
		BufferedReader br = new BufferedReader(reader);
		
		String line = null;
		List<String> skuList = new ArrayList<String>();
		List<Integer> stocks = new ArrayList<Integer>();
		while((line = br.readLine()) != null){
			skuList.add(line);
		}
		BufferedReader brs = new BufferedReader(readers);
		String lines = null;
		while((lines = brs.readLine()) != null){
			stocks.add(Integer.valueOf(lines));
		}
		br.close();
		brs.close();
		for(int i = 0;i < skuList.size();i++){
			StringBuilder sb = new StringBuilder();
			sb.append("update t_sku_stock_account_detail t set t.begin_total_stock_num =" + stocks.get(i) +"where t.id = ''");
		}
	}

}
