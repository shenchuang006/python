package com.ssm.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class ReadFile {
	public static void main(String[] args) throws Exception {
		FileInputStream in = new FileInputStream(new File("C:/Users/Administrator/Desktop/c.txt"));
		
		PrintWriter pw = new PrintWriter("mmjj.txt");
		BufferedReader bReader  = new BufferedReader(new InputStreamReader(in));
		String line = null;
		while((line = bReader.readLine()) != null){
			String[] strs = line.split(",");
			System.err.println(strs);
			String s1 = "SELECT SUM(t.`out_count`),SUM(t.`in_count`) FROM t_stock_collect_tmp t WHERE  t.`sku_no`= '"+
			strs[0] +"' AND t.`warehouse_code` = '"+ strs[1]+
"' AND t.`supplier_code` = '" +strs[2]+"' AND t.`org_code` = '"+strs[3]+"'  AND t.`inventory_type` = '"+strs[4]+"';"+"\n";
			
			String s2 = "SELECT * FROM t_stock_collect_tmp t WHERE  t.`sku_no`= '"+
			strs[0] +"' AND t.`warehouse_code` = '"+ strs[1]+
"' AND t.`supplier_code` = '" +strs[2]+"' AND t.`org_code` = '"+strs[3]+"'  AND t.`inventory_type` = '"+strs[4]+"';"+"\n";
			

			String s3 = "SELECT * FROM t_stock_collect t WHERE  t.`sku_no`= '"+
					strs[0] +"' AND t.`warehouse_code` = '"+ strs[1]+
		"' AND t.`supplier_code` = '" +strs[2]+"' AND t.`org_code` = '"+strs[3]+"'  AND t.`inventory_type` = '"+strs[4]+"';"+"\n";
			
			String s4 =  "SELECT "+
			"SUM(CASE "+
			"WHEN order_type = 0 THEN change_stock_count "+
			"WHEN order_type = 1 THEN change_stock_count "+
			"WHEN order_type = 2 THEN change_stock_count " +
			"WHEN order_type = 3 THEN change_stock_count " +
			"WHEN order_type = 4 THEN change_stock_count " +
			"WHEN order_type = 5 THEN change_stock_count " +
			"WHEN order_type = 6 THEN change_stock_count " +
			"WHEN order_type = 7 THEN change_stock_count " +
			"WHEN order_type = 8 THEN change_stock_count " +
			"WHEN order_type = 9 THEN change_stock_count " +
			"WHEN order_type = 13 THEN change_stock_count " +
			"WHEN order_type = 28 THEN change_stock_count " +
			"WHEN order_type = 31 THEN change_stock_count " +
			"WHEN order_type = 45 THEN change_stock_count " +
			"ELSE 0 END ) AS inStock, " +
			"SUM(CASE  " +
			"WHEN order_type = 10 THEN change_stock_count " +
			"WHEN order_type = 12 THEN change_stock_count " +
			"WHEN order_type = 14 THEN change_stock_count " +
			"WHEN order_type = 20 THEN change_stock_count " +
			"WHEN order_type = 21 THEN change_stock_count " +
			"WHEN order_type = 22 THEN change_stock_count " +
			"WHEN order_type = 23 THEN change_stock_count " +
			"WHEN order_type = 24 THEN change_stock_count " +
			"WHEN order_type = 25 THEN change_stock_count " +
			"WHEN order_type = 26 THEN change_stock_count " +
			"WHEN order_type = 27 THEN change_stock_count " +
			"WHEN order_type = 29 THEN change_stock_count " +
			"WHEN order_type = 32 THEN change_stock_count " +
			"WHEN order_type = 46 THEN change_stock_count " +
			"ELSE 0 END ) AS outStock, " +
			"`sku_no` AS skuNo, " +
			"`supplier_code` AS supplierCode, " +
			"`warehouse_code` AS warehouseCode, " +
			"`inventory_type` AS inventoryType, " +
			"`org_code` AS companyCode, " +
			"`broken_grade` AS brokenGrade " +
			"FROM  t_stock_change_log"+getTableSuffix(strs[0],1024,"_0000")+
			" WHERE 1=1 AND sku_no ='"+strs[0]+"' "+
			"GROUP BY sku_no,warehouse_code,supplier_code,org_code,inventory_type,broken_grade;"+"\n";
			pw.write(s1);
			pw.write(s2);
			pw.write(s3);
			pw.write(s4);
			pw.write("\n\n");
		}
		
	}
	
 public static String getTableSuffix(String businessId,long tableSize,String tableSuffix){
        long routeValue = Math.abs(businessId.hashCode());
        long index = routeValue%tableSize;
        String format = "%0"+(tableSuffix.length()-1)+"d";
        return "_"+String.format(format, index);
    }

}
