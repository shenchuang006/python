package com.ssm.test.yuncang;

import java.io.Serializable;
import java.util.Date;

/**
 * 
* @ClassName:YunCangOutInOrderDetail 
* @version:1.0.0
* @Description:云仓出入库单详细
* @author: Sc 
* @date: 2019年3月7日 上午11:07:12
 */
public class YunCangOutInOrderDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3130448542855132139L;
	/**
	 * 货品编码
	 */
	private String itemCode;
	/**
	 * 货品条形码
	 */
	private String barCode;
	/**
	 * 货品名称
	 */
	private String itemName;
	/**
	 * 规格编码
	 */
	private String specificationCode;
	/**
	 * 规格名称
	 */
	private String specificationName;
	/**
	 * 品牌编码
	 */
	private String brandCode;
	/**
	 * 品牌名称
	 */
	private String brandName;
	/**
	 * 计划出入库数量
	 */
	private Integer planOutInNumber;
	/**
	 * 实际出入库数量
	 */
	private Integer actualOutInNumber;
	/**
	 * 库存类型 ZP=正品, CC=残次
	 */
	private String inventoryType;
	/**
	 * 残次等级
	 */
	private Integer brokenGrade;
	/**
	 * 生产日期 YYYY-MM-DD
	 */
	private String prouctDate;
	/**
	 * 失效日期
	 */
	private String expireDate;
	/**
	 * sku商品属性
	 */
	private String skuProperty;
	/**
	 * 买手组
	 */
	private String category;
	/**
	 * 采购价
	 */
	private String purchasePrice;
	/**
	 * 零售价
	 */
	private String retailPrice;
	/**
	 * 云集出入库单号
	 */
	private String outInOrderCode;
	/**
	 * 商家编码
	 */
	private String merchantCode;
	
	public YunCangOutInOrderDetail() {

	}

	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getBarCode() {
		return barCode;
	}

	public void setBarCode(String barCode) {
		this.barCode = barCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getSpecificationCode() {
		return specificationCode;
	}

	public void setSpecificationCode(String specificationCode) {
		this.specificationCode = specificationCode;
	}

	public String getSpecificationName() {
		return specificationName;
	}

	public void setSpecificationName(String specificationName) {
		this.specificationName = specificationName;
	}

	public String getBrandCode() {
		return brandCode;
	}

	public void setBrandCode(String brandCode) {
		this.brandCode = brandCode;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	public Integer getPlanOutInNumber() {
		return planOutInNumber;
	}

	public void setPlanOutInNumber(Integer planOutInNumber) {
		this.planOutInNumber = planOutInNumber;
	}

	public Integer getActualOutInNumber() {
		return actualOutInNumber;
	}

	public void setActualOutInNumber(Integer actualOutInNumber) {
		this.actualOutInNumber = actualOutInNumber;
	}

	public String getInventoryType() {
		return inventoryType;
	}

	public void setInventoryType(String inventoryType) {
		this.inventoryType = inventoryType;
	}

	public Integer getBrokenGrade() {
		return brokenGrade;
	}

	public void setBrokenGrade(Integer brokenGrade) {
		this.brokenGrade = brokenGrade;
	}

	public String getProuctDate() {
		return prouctDate;
	}

	public void setProuctDate(String prouctDate) {
		this.prouctDate = prouctDate;
	}

	public String getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}

	public String getSkuProperty() {
		return skuProperty;
	}

	public void setSkuProperty(String skuProperty) {
		this.skuProperty = skuProperty;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(String purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public String getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(String retailPrice) {
		this.retailPrice = retailPrice;
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
