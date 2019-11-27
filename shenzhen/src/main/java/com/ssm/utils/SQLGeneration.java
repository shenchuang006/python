package com.ssm.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;


/**
 * 创建生成表以及新增字段
 * @author Administrator
 *
 */
public class SQLGeneration{
	private static final Integer TABLESIZE = 1024;
	
	@Test
	public void testAlterAdd() throws Exception, Exception{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("D:/生成表文件/(yunjiomssaleorganization)库存明细账增加字段_沈闯_20180806发版前.sql")),"UTF-8");
		PrintWriter pw = new PrintWriter(osw);
		/**文件头**/
		StringBuilder sb = new StringBuilder();
		sb.append("/***********************************").append("\n");
		sb.append("** 作者:沈闯").append("\n");
		sb.append(" ** 创建日期：2018年07月20日").append("\n");
		sb.append(" ** 版本：0807版本").append("\n");
		sb.append("** 数据库：yunjiomssaleorganization").append("\n");
		sb.append("** 功能描述：库存明细增加字段").append("\n");
		sb.append("***********************************/").append("\n\n\n\n");
		pw.write(sb.toString());
		for(int i = 0;i<TABLESIZE ; i++){
			/**生成的内容*/
			String tableSuffix = TableNumFormatUtil.completionNumberFormat(i);
			StringBuilder st = new StringBuilder();
			st.append("ALTER TABLE t_stock_detail_bill"+tableSuffix+" ADD COLUMN stock_type VARCHAR(3) DEFAULT NULL COMMENT \'库存类型-ZP:正品;CC:残品\'");
			st.append(";\n");
			st.append("ALTER TABLE t_stock_detail_bill"+tableSuffix+" ADD COLUMN broken_grade TINYINT(2) DEFAULT NULL COMMENT \'残次等级-1:残一;2:残二:3:残三\'");
			st.append(";\n");
			pw.write(st.toString());
		}
		pw.close();
	}
	
	@Test
	public void testDao() throws Exception, Exception{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("D:/生成表文件/(yunjiomssaleorganization)删除库存明细账数据_沈闯_20180907.sql")),"UTF-8");
		PrintWriter pw = new PrintWriter(osw);
		/**文件头**/
		StringBuilder sb = new StringBuilder();
		sb.append("/***********************************").append("\n");
		sb.append("** 作者:沈闯").append("\n");
		sb.append(" ** 创建日期：2018年09月07日").append("\n");
		//sb.append(" ** 版本：0907版本").append("\n");
		sb.append("** 数据库：yunjiomssaleorganization").append("\n");
		sb.append("** 功能描述：删除库存明细账9月份数据").append("\n");
		sb.append("***********************************/").append("\n\n\n\n");
		pw.write(sb.toString());
		for(int i = 0;i<TABLESIZE ; i++){
			/**生成的内容*/
			String tableSuffix = TableNumFormatUtil.completionNumberFormat(i);
			StringBuilder st = new StringBuilder();
			st.append("DELETE FROM t_stock_detail_bill"+tableSuffix+" WHERE `ims_create_time` >= '2018-09-01 00:00:00' AND `ims_create_time` < '2018-09-04 00:00:00'");
			st.append(";\n");
			pw.write(st.toString());
		}
		pw.close();
	}
	
	@Test
	public void testDel() throws Exception, Throwable{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("D:/生成表文件/(yunjiomssaleorganization)删除库存明细账数据_沈闯_20180917.sql")),"UTF-8");
		PrintWriter pw = new PrintWriter(osw);
		/**文件头**/
		StringBuilder sb = new StringBuilder();
		sb.append("/***********************************").append("\n");
		sb.append("** 作者:沈闯").append("\n");
		sb.append(" ** 创建日期：2018年09月17日").append("\n");
		//sb.append(" ** 版本：0907版本").append("\n");
		sb.append("** 数据库：yunjiomssaleorganization").append("\n");
		sb.append("** 功能描述：删除t_org_stock表中的部分数据").append("\n");
		sb.append("***********************************/").append("\n\n\n\n");
		pw.write(sb.toString());
		//String tableSuffix = TableNumFormatUtil.completionNumberFormat(i);
		StringBuilder st = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\重复id.txt"))));
		String readLine = null;
		st.append("DELETE FROM t_org_stock WHERE `id` IN (" );
		while((readLine = br.readLine()) != null){
			Long value = Long.valueOf(readLine);
			st.append(value +",");
		}
		st.append(");");
		pw.write(st.toString());
		pw.close();
		br.close();
	}
	
	@Test
	public void testStockOrder() throws Exception, Exception{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("D:/生成表文件/(yunjiimshistory)迁移销售订单历史数据_沈闯_20190306.sql")),"UTF-8");
		PrintWriter pw = new PrintWriter(osw);
		/**文件头**/
		StringBuilder sb = new StringBuilder();
		sb.append("/***********************************").append("\n");
		sb.append("** 作者:沈闯").append("\n");
		sb.append(" ** 创建日期：2019年02月28日").append("\n");
		//sb.append(" ** 版本：0907版本").append("\n");
		sb.append("** 数据库：yunjiimshistory").append("\n");
		sb.append("** 功能描述：创建yunjiomsstock销售订单历史数据迁移到备份库").append("\n");
		sb.append("***********************************/").append("\n\n\n\n");
		pw.write(sb.toString());
		for(int i = 0;i<TABLESIZE ; i++){
			/**生成的内容*/
			String tableSuffix = TableNumFormatUtil.completionNumberFormat(i);
			StringBuilder st = new StringBuilder();
			st.append("CREATE TABLE `t_stock_order" + tableSuffix+"` (").append("\n");
						st.append("`id` bigint(19) NOT NULL COMMENT '主键ID',").append("\n");
						st.append("`sku_no` varchar(50) NOT NULL COMMENT 'sku编码',").append("\n");
						st.append("`warehouse_code` varchar(50) NOT NULL COMMENT '仓库编码',").append("\n");
						st.append("`inventory_type` varchar(2) DEFAULT NULL COMMENT '库存类型，ZP=正品, CC=残次，默认为ZP',").append("\n");
						st.append("`org_code` varchar(50) DEFAULT NULL COMMENT '机构编码',").append("\n");
						st.append("`broken_grade` int(2) DEFAULT NULL COMMENT '退货仓残次等级，1：一级残，2：二级残，3：三级残',").append("\n");
						st.append("`supplier_code` varchar(50) DEFAULT NULL COMMENT '供应商编码',").append("\n");
						st.append("`batch_code` varchar(50) DEFAULT NULL COMMENT '批次号',").append("\n");
						st.append("`produce_time` datetime DEFAULT NULL COMMENT '出厂日期',").append("\n");
						st.append("`expire_time` datetime DEFAULT NULL COMMENT '过期日期',").append("\n");
						st.append("`source` tinyint(1) NOT NULL COMMENT '订单来源，1：交易平台订单，2：非平台订单',").append("\n");
						st.append("`order_id` varchar(50) NOT NULL COMMENT '订单号',").append("\n");
						st.append("`goods_count` int(11) NOT NULL COMMENT '原始占用数量，即购买数量',").append("\n");
						st.append("`lock_count` int(11) NOT NULL COMMENT '已占用库存',").append("\n");
						st.append("`out_stock_count` int(11) NOT NULL COMMENT '已出库库存',").append("\n");
						st.append("`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',").append("\n");
						st.append("`modify_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',").append("\n");
						st.append("PRIMARY KEY (`id`),").append("\n");
						st.append("KEY `idx_orderId_skuNo` (`sku_no`,`order_id`),").append("\n");
						st.append("KEY `idx_orderId_warehouseCode` (`order_id`,`warehouse_code`)").append("\n");
						st.append(") ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='销售订单占用和出库明细表';").append("\n");
						st.append("\n\n\n");
						
			pw.write(st.toString());
		}
		pw.close();
	}
	
	@Test
	public void testCreateTable() throws Exception, Exception{
		OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(new File("D:/生成表文件/(yunjiimshistory)迁移销售订单历史数据_沈闯_20190307.sql")),"UTF-8");
		PrintWriter pw = new PrintWriter(osw);
		/**文件头**/
		StringBuilder sb = new StringBuilder();
		sb.append("/***********************************").append("\n");
		sb.append("** 作者:沈闯").append("\n");
		sb.append(" ** 创建日期：2019年02月28日").append("\n");
		//sb.append(" ** 版本：0907版本").append("\n");
		sb.append("** 数据库：yunjiimshistory").append("\n");
		sb.append("** 功能描述：创建yunjiomsstock销售订单历史数据迁移到备份库").append("\n");
		sb.append("***********************************/").append("\n\n\n\n");
		pw.write(sb.toString());
		for(int i = 1;i< TABLESIZE ; i++){
			/**生成的内容*/
			String tableSuffix = TableNumFormatUtil.completionNumberFormat(i);
			StringBuilder st = new StringBuilder();
			st.append("CREATE TABLE `t_stock_order"+tableSuffix +"` LIKE t_stock_order_0000;").append("\n");
			pw.write(st.toString());
		}
		pw.close();
	}
	
	@Test
	public void testmx(){
		boolean isTrue = true;
		for(int i = 1;i<10;i++){
			for(int j = 0;j<10;j++){
				if(j%i != 0){
					isTrue = false;
				}
				if(!isTrue){
					//break;
					return;
				}
			}
			if(!isTrue){
				break;
			}
		}
		System.err.print(isTrue);
	}

}
