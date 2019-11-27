package com.ssm.test;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import com.alibaba.fastjson.JSON;

  
public class ExcelUtil {
	//默认单元格内容为数字时格式  
    private static DecimalFormat df = new DecimalFormat("0");  
    // 默认单元格格式化日期字符串   
    private static SimpleDateFormat sdf = new SimpleDateFormat(  "yyyy-MM-dd HH:mm:ss");   
    // 格式化数字  
    private static DecimalFormat nf = new DecimalFormat("0.00");
    
    public static void main(String[] args) throws Exception {
    	//String zaitu = "C:/Users/Administrator/Desktop/在途数据(1).xlsx";
    	//String mx = "C:/Users/Administrator/Desktop/采购在途数据/在途数据.xlsx";
    	String mx = "C:/Users/Administrator/Desktop/采购在途数据/rd.xlsx";
		File file = new File(mx);
		ArrayList<ArrayList<Object>> arrayList2 = ExcelUtil.readExcel(file);
		String str = "select * from t_stock_onroute_order where ";
		PrintWriter pw = new PrintWriter("sql.txt");
		PrintWriter pws = new PrintWriter("C:/Users/Administrator/Desktop/采购在途数据/rd.txt");
		for(ArrayList<Object> objects : arrayList2){
			//StringBuilder sb = new StringBuilder(str);
			
			/*for(Object object : objects){
				//delivery_order_no = '"&B2&"' and sku_no = '"&A2&"';
			}*/
			/*sb.append("delivery_order_no=").append("'").append(objects.get(1)).append("'").append("and ");
			sb.append("sku_no=").append("'").append(objects.get(0)).append("'").append(" and ").append("lock_count=0").append(";");
			pw.write(sb.toString()+"\n");*/
			pws.write(objects.get(0)+","+objects.get(1)+","+objects.get(2)+","+objects.get(3)+"\n");
		}
		pw.close();
		pws.close();
	}
    
    @Test
    public void testMx() throws Exception{
    	String mx = "C:/Users/Administrator/Desktop/t_passage_stock_detail_new(1).xls";
		File file = new File(mx);
		ArrayList<ArrayList<Object>> arrayList2 = ExcelUtil.readExcel(file);
		PrintWriter pws = new PrintWriter("C:/Users/Administrator/Desktop/采购在途数据/toss.txt");
		int a = 0;
		for(ArrayList<Object> objects : arrayList2){
			a++;
			System.err.println(JSON.toJSONString(objects));
			if(a == 1){
				continue;
			}
			String num = (String) objects.get(2);
			num = num.substring(0,num.indexOf("."));
			pws.write(objects.get(0)+","+objects.get(1)+","+num+","+objects.get(5)+"\n");
		}
		pws.close();
    }
    @Test
    public void testInteger(){
    	Integer a = 127 ;
    	int b = 127;
    	Integer c = 128;
    	Integer d = 128;
    	
    	Integer e = 129;
    	Integer f = 129;
    	
    	Integer g = -128;
    	Integer h = -128;
    	Integer l = -129;
    	Integer m = -129;
    	//-128~127 重复利用
    	System.err.println((a == b) +","+(c == d) +"," +(e == f)+","+(g == h)+","+(l == m));
    }
    @Test
    public void testReadWriteToFile() throws Exception{
    	String mx = "C:\\Users\\Administrator\\Desktop\\采购在途数据\\jout.txt";
		File file = new File(mx);
		BufferedReader bf = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String str = null;
		PrintWriter pws = new PrintWriter("C:/Users/Administrator/Desktop/采购在途数据/mmss.txt");
		PrintWriter pwsq = new PrintWriter("C:/Users/Administrator/Desktop/采购在途数据/mmssq.txt");
		while((str=bf.readLine()) != null){
			String[] strs = str.split(",");
			String m = null;
			String ml = null;
			if(strs.length == 5){
				m = strs[0]+","+strs[1]+","+strs[2]+","+strs[3];
				ml = strs[0]+","+strs[4]+","+Math.abs(Integer.valueOf(strs[2]))+","+strs[3];
			}else{
				pws.write(str+"\n");
			}
			if(m != null && ml != null){
				pws.write(m+"\n");
				pwsq.write(ml+"\n");
			}
		}
		bf.close();
		pws.close();
		pwsq.close();
    }

    
    
    @Test
    public void testMxss() throws Exception{
    	String mx = "C:/Users/Administrator/Desktop/to.xls";
		File file = new File(mx);
		ArrayList<ArrayList<Object>> arrayList2 = ExcelUtil.readExcel(file);
		PrintWriter pws = new PrintWriter("C:/Users/Administrator/Desktop/to.txt");
		int a = 0;
		for(ArrayList<Object> objects : arrayList2){
			a++;
			System.err.println(JSON.toJSONString(objects));
			if(a == 1){
				continue;
			}
			if(objects.size() < 5){
				continue;
			}
			if(objects.get(0) == null || objects.get(0).equals("")){
				continue;
			}
			/*if(objects.get(1) == null || objects.get(1).equals("")){
				continue;
			}
			if(objects.get(2) == null || objects.get(2).equals("")){
				continue;
			}*/
			/*if(objects.get(3) == null || objects.get(3).equals("")){
				continue;
			}
			if(objects.get(4) == null || objects.get(4).equals("")){
				continue;
			}*/
			String num = (String) objects.get(2);
			num = num.substring(0,num.indexOf("."));
			pws.write(objects.get(0)+","+objects.get(1)+","+num+","+objects.get(5)+"\n");
		}
		pws.close();
    }
    
    @Test
    public void testReadExcel() throws Exception{
    	String mx = "C:/Users/Administrator/Desktop/无标题.xls";
		File file = new File(mx);
		ArrayList<ArrayList<Object>> arrayList2 = ExcelUtil.readExcel(file);
		PrintWriter pws = new PrintWriter("C:/Users/Administrator/Desktop/dubbo.txt");
		if(arrayList2 == null || arrayList2.size() == 0){
			return;
		}
		int a = 0;
		for(ArrayList<Object> objects : arrayList2){
			a++;
			if(a == 1){
				continue;
			}
			if(objects.get(0) == null || objects.get(0).equals("")){
				continue;
			}
			String num = (String) objects.get(1);
			num = num.substring(num.indexOf("-")+1,num.indexOf("."));
			String abc = "{"+"\"deliveryOrderId\""+":"+"\""+objects.get(0)+"\","+"\"businessType\":"+"2"+","+"\"outBizCode\":"+"\""+System.currentTimeMillis()+"\","+"\"skuNo\":"+"\""+objects.get(2)+"\","+"\"count\":"+num+","+"\"warehouseCode\":"+"\"0001\""+","+"\"isNationWarehouse\":"+"\"Y\""+"}";
			System.err.println(abc);
			pws.write("com.yunji.oms.stockaccount.stock.api.IStockOnRouteOrderRepairService.repairStockOnRouteToYJPlateform("+abc+")"+"\n");
			Thread.sleep(5);
		}
		pws.close();
    }
    
    @Test
    public void testabc(){
    	String abc = "{"+"\"deliveryOrderId\""+":"+"\""+"FO201812200014"+"\","+"\"businessType\":"+"2"+","+"\"outBizCode\":"+"\"20190814220157-220623064\","+"\"skuNo\":"+"\"6971135300485\","+"\"count\":"+"2"+","+"\"warehouseCode\":"+"\"0001\""+","+"\"isNationWarehouse\":"+"\"Y\""+"}";
    	System.err.println(abc);
    	String num = "-2.00";
    	System.err.println(num.substring(num.indexOf("-")+1,num.indexOf(".")));
    }
    
    public static ArrayList<ArrayList<Object>> readExcel(File file){  
        if(file == null){  
            return null;  
        }  
        if(file.getName().endsWith("xlsx")){  
            //处理ecxel2007 
        	ArrayList<ArrayList<Object>> arrayList2 = readExcel2007(file);
        	System.err.println(JSON.toJSONString(arrayList2));
            return readExcel2007(file);  
        }else{  
            //处理ecxel2003  
            return readExcel2003(file);  
        }  
    }  
    /*  
     * @return 将返回结果存储在ArrayList内，存储结构与二位数组类似  
     * lists.get(0).get(0)表示过去Excel中0行0列单元格  
     */  
    public static ArrayList<ArrayList<Object>> readExcel2003(File file){  
        try{  
            ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();  
            ArrayList<Object> colList;  
            HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(file));  
            HSSFSheet sheet = wb.getSheetAt(0);  
            HSSFRow row;  
            HSSFCell cell;  
            Object value;  
            for(int i = sheet.getFirstRowNum() , rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows() ; i++ ){  
                row = sheet.getRow(i);  
                colList = new ArrayList<Object>();  
                if(row == null){  
                    //当读取行为空时  
                    if(i != sheet.getPhysicalNumberOfRows()){//判断是否是最后一行  
                        rowList.add(colList);  
                    }  
                    continue;  
                }else{  
                    rowCount++;  
                }  
                for( int j = row.getFirstCellNum() ; j <= row.getLastCellNum() ;j++){  
                    cell = row.getCell(j);  
                    if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){  
                        //当该单元格为空  
                        if(j != row.getLastCellNum()){//判断是否是该行中最后一个单元格  
                            colList.add("");  
                        }  
                        continue;  
                    }  
                    switch(cell.getCellType()){  
                     case XSSFCell.CELL_TYPE_STRING:    
                            System.out.println(i + "行" + j + " 列 is String type");    
                            value = cell.getStringCellValue();    
                            break;    
                        case XSSFCell.CELL_TYPE_NUMERIC:    
                            if ("@".equals(cell.getCellStyle().getDataFormatString())) {    
                                value = df.format(cell.getNumericCellValue());    
                            } else if ("General".equals(cell.getCellStyle()    
                                    .getDataFormatString())) {    
                                value = nf.format(cell.getNumericCellValue());    
                            } else {    
                                value = sdf.format(HSSFDateUtil.getJavaDate(cell    
                                        .getNumericCellValue()));    
                            }    
                            System.out.println(i + "行" + j    
                                    + " 列 is Number type ; DateFormt:"    
                                    + value.toString());   
                            break;    
                        case XSSFCell.CELL_TYPE_BOOLEAN:    
                            System.out.println(i + "行" + j + " 列 is Boolean type");    
                            value = Boolean.valueOf(cell.getBooleanCellValue());  
                            break;    
                        case XSSFCell.CELL_TYPE_BLANK:    
                            System.out.println(i + "行" + j + " 列 is Blank type");    
                            value = "";    
                            break;    
                        default:    
                            System.out.println(i + "行" + j + " 列 is default type");    
                            value = cell.toString();    
                    }// end switch  
                    colList.add(value);  
                }//end for j  
                rowList.add(colList);  
            }//end for i  
              
            return rowList;  
        }catch(Exception e){  
            return null;  
        }  
    }  
      
    public static ArrayList<ArrayList<Object>> readExcel2007(File file){  
        try{  
            ArrayList<ArrayList<Object>> rowList = new ArrayList<ArrayList<Object>>();  
            ArrayList<Object> colList;  
            XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream(file));  
            XSSFSheet sheet = wb.getSheetAt(0);  
            XSSFRow row;  
            XSSFCell cell;  
            Object value;  
            for(int i = sheet.getFirstRowNum() , rowCount = 0; rowCount < sheet.getPhysicalNumberOfRows() ; i++ ){  
                row = sheet.getRow(i);  
                colList = new ArrayList<Object>();  
                if(row == null){  
                    //当读取行为空时  
                    if(i != sheet.getPhysicalNumberOfRows()){//判断是否是最后一行  
                        rowList.add(colList);  
                    }  
                    continue;  
                }else{  
                    rowCount++;  
                }  
                for( int j = row.getFirstCellNum() ; j <= row.getLastCellNum() ;j++){  
                    cell = row.getCell(j);  
                    if(cell == null || cell.getCellType() == HSSFCell.CELL_TYPE_BLANK){  
                        //当该单元格为空  
                        if(j != row.getLastCellNum()){//判断是否是该行中最后一个单元格  
                            colList.add("");  
                        }  
                        continue;  
                    }  
                   
                    colList.add(cell.toString());  
                }//end for j  
                rowList.add(colList);  
            }//end for i  
              
            return rowList;  
        }catch(Exception e){  
            System.out.println("exception");  
            return null;  
        }  
    }  
      
    public static void writeExcel(ArrayList<ArrayList<Object>> result,String path){  
        if(result == null){  
            return;  
        }  
        HSSFWorkbook wb = new HSSFWorkbook();  
        HSSFSheet sheet = wb.createSheet("sheet1");  
        for(int i = 0 ;i < result.size() ; i++){  
             HSSFRow row = sheet.createRow(i);  
            if(result.get(i) != null){  
                for(int j = 0; j < result.get(i).size() ; j ++){  
                    HSSFCell cell = row.createCell(j);  
                    cell.setCellValue(result.get(i).get(j).toString());  
                }  
            }  
        }  
        ByteArrayOutputStream os = new ByteArrayOutputStream();  
        try  
        {  
            wb.write(os);  
        } catch (IOException e){  
            e.printStackTrace();  
        }  
        byte[] content = os.toByteArray();  
        File file = new File(path);//Excel文件生成后存储的位置。  
        OutputStream fos  = null;  
        try  
        {  
            fos = new FileOutputStream(file);  
            fos.write(content);  
            os.close();  
            fos.close();  
        }catch (Exception e){  
            e.printStackTrace();  
        }             
    }  
      
    public static DecimalFormat getDf() {  
        return df;  
    }  
    public static void setDf(DecimalFormat df) {  
        ExcelUtil.df = df;  
    }  
    public static SimpleDateFormat getSdf() {  
        return sdf;  
    }  
    public static void setSdf(SimpleDateFormat sdf) {  
        ExcelUtil.sdf = sdf;  
    }  
    public static DecimalFormat getNf() {  
        return nf;  
    }  
    public static void setNf(DecimalFormat nf) {  
        ExcelUtil.nf = nf;  
    }  
      
}