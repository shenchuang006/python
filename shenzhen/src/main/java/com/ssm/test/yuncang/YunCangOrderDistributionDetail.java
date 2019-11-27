package com.ssm.test.yuncang;

import java.io.Serializable;

/**
 * 
* @ClassName:YunCangOrderDistributionDetail 
* @version:1.0.0
* @Description:云仓货品配送物流信息详情
* @author: Sc 
* @date: 2019年3月7日 上午10:58:54
 */
public class YunCangOrderDistributionDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4310830153568207816L;
	/**
	 * 物流公司
	 */
	private String logisticsCompany;
	/**
	 * 运单号
	 */
	private String expressCode;
	/**
	 * 司机姓名
	 */
	private String driverName;
	/**
	 * 司机手机号
	 */
	private String driverMobile;
	/**
	 * 车牌号
	 */
	private String plateNumber;
	/**
	 * 云仓出入库单号
	 */
	private String outInOrderCode;
	/**
	 * 商家编码
	 */
	private String merchantCode;
	
	public YunCangOrderDistributionDetail() {
		
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getExpressCode() {
		return expressCode;
	}

	public void setExpressCode(String expressCode) {
		this.expressCode = expressCode;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getDriverMobile() {
		return driverMobile;
	}

	public void setDriverMobile(String driverMobile) {
		this.driverMobile = driverMobile;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public String getOutInOrderCode() {
		return outInOrderCode;
	}

	public void setOutInOrderCode(String outInOrderCode) {
		this.outInOrderCode = outInOrderCode;
	}

	public String getMerchantCode() {
		return merchantCode;
	}

	public void setMerchantCode(String merchantCode) {
		this.merchantCode = merchantCode;
	}
}
