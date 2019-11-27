package com.ssm.test.yuncang;

import java.io.Serializable;

/**
 * 
* YunCangOrderSenderDetail 
* @version:1.0.0
* @Description: 云仓货品发货人信息
* @author: Sc 
* @date: 2019年3月7日 上午10:48:01
 */
public class YunCangOrderSenderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3502206540533187209L;
	/**
	 * 云仓出入库单号
	 */
	private String outInOrderCode;
	/**
	 * 商家编码
	 */
	private String merchantCode;
	/**
	 * 供应商编码
	 */
	private String supplierCode;
	/**
	 * 供应商名称
	 */
	private String supplierName;
	/**
	 * 邮编
	 */
	private String zipCode;
	/**
	 * 固定电话
	 */
	private String fixedTelephone;
	/**
	 * 联系人姓名
	 */
	private String contactName;
	/**
	 * 手机号码
	 */
	private String mobileCode;
	/**
	 * 邮箱地址
	 */
	private String emailAddress;
	/**
	 * 国家编码
	 */
	private String countryCode;
	/**
	 * 省份名称
	 */
	private String provinceName;
	/**
	 * 市名称
	 */
	private String cityName;
	/**
	 * 区域名称
	 */
	private String areaName;
	/**
	 * 详细地址
	 */
	private String detailAddress;
	
	public YunCangOrderSenderDetail() {

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

	public String getSupplierCode() {
		return supplierCode;
	}

	public void setSupplierCode(String supplierCode) {
		this.supplierCode = supplierCode;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getFixedTelephone() {
		return fixedTelephone;
	}

	public void setFixedTelephone(String fixedTelephone) {
		this.fixedTelephone = fixedTelephone;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getMobileCode() {
		return mobileCode;
	}

	public void setMobileCode(String mobileCode) {
		this.mobileCode = mobileCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}

	public String getCityName() {
		return cityName;
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

}
