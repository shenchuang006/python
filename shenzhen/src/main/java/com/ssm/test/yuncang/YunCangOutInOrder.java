package com.ssm.test.yuncang;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
/**
 * 
* @ClassName:YunCangOutInOrder 
* @version:1.0.0
* @Description: 云仓客 出入库单
* @author: Sc 
* @date: 2019年3月7日 上午9:58:06
 */
public class YunCangOutInOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5787012263980995635L;
	/**
	 * 云仓创建的出入库单号
	 */
	String outInOrderCode;
	/**
	 * 客户ERP接口调用传的商家编码
	 */
	String merchantCode;
	/**
	 * 商家名称
	 */
	String merchantName;
	/**
	 * 出库/入库接口传递的仓库编码
	 */
	String warehouseCode;
	/**
	 * 仓库名称
	 */
	String warehouseCodeName;
	/**
	 * 客户ERP接口调用传参-原始单号
	 */
	String resourceOrderCode;
	/**
	 * 接口传参-关联单号
	 */
	String associateOrderCode;
	/**
	 * 接口传参-单据类型
	 */
	String orderType;
	/**
	 * 单据类型名称CG=采购单，DB=调拨单, CK=出库单，RK=入库单
	 */
	String orderTypeName;
	/**
	 * 是否使用云集干线--N:不使用;Y:使用
	 */
	String isUseYJGX;
	/**
	 * 系统统计商品总行数
	 */
	Integer totalRow;
	/**
	 * 系统统计商品出入库累计值
	 */
	Integer totalNums;
	/**
	 * 总体积
	 */
	BigDecimal totalVolume;
	/**
	 * 总箱数
	 */
	Integer totalBoxes;
	/**
	 * 运输方式
	 */
	String transportMode;
	/**
	 * 干线客户
	 */
	String mainCustomer;
	/**
	 * 订单单据创建时间
	 */
	Date orderCreateTime;
	/**
	 * 业务期望送达时间
	 */
	Date expectedDeliveryTime;
	/**
	 * 期望提货时间
	 */
	Date expectPickUpGoodsTime;
	/**
	 * 释放使用托盘装--Y:是;N:否
	 */
	String isTray;
	/**
	 * 托盘尺寸
	 */
	BigDecimal traySize;
	/**
	 * 是否需要装卸工--Y:需要;N:不需要
	 */
	String isLoader;
	/**
	 * 是否限行--Y:限行;N:不限行
	 */
	String isTrafficRestriction;
	/**
	 * 接口传参--备注
	 */
	String remark;
	/**
	 * 单据状态--1：已创建;2:已审核;3:待入库;4:部分入库;5:全部入库;0:已取消
	 */
	Integer status;
	/**
	 * 预计到货时间
	 */
	Date expectArrivalTime;
	/**
	 * 是否允许低于标准收货--默认N-不允许低于标准收货;Y:允许
	 */
	String lowstandardReceipt;
	/**
	 * 单据创建人
	 */
	String createPerson;
	/**
	 * 创建时间
	 */
	Date createTime;
	/**
	 * 审核人
	 */
	String auditPerson;
	/**
	 * 审核时间
	 */
	Date auditTime;
	public YunCangOutInOrder() {
		
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
	public String getMerchantName() {
		return merchantName;
	}
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}
	public String getWarehouseCode() {
		return warehouseCode;
	}
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}
	public String getWarehouseCodeName() {
		return warehouseCodeName;
	}
	public void setWarehouseCodeName(String warehouseCodeName) {
		this.warehouseCodeName = warehouseCodeName;
	}
	public String getResourceOrderCode() {
		return resourceOrderCode;
	}
	public void setResourceOrderCode(String resourceOrderCode) {
		this.resourceOrderCode = resourceOrderCode;
	}
	public String getAssociateOrderCode() {
		return associateOrderCode;
	}
	public void setAssociateOrderCode(String associateOrderCode) {
		this.associateOrderCode = associateOrderCode;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getOrderTypeName() {
		return orderTypeName;
	}
	public void setOrderTypeName(String orderTypeName) {
		this.orderTypeName = orderTypeName;
	}
	public String getIsUseYJGX() {
		return isUseYJGX;
	}
	public void setIsUseYJGX(String isUseYJGX) {
		this.isUseYJGX = isUseYJGX;
	}
	public Integer getTotalRow() {
		return totalRow;
	}
	public void setTotalRow(Integer totalRow) {
		this.totalRow = totalRow;
	}
	public Integer getTotalNums() {
		return totalNums;
	}
	public void setTotalNums(Integer totalNums) {
		this.totalNums = totalNums;
	}
	public BigDecimal getTotalVolume() {
		return totalVolume;
	}
	public void setTotalVolume(BigDecimal totalVolume) {
		this.totalVolume = totalVolume;
	}
	public Integer getTotalBoxes() {
		return totalBoxes;
	}
	public void setTotalBoxes(Integer totalBoxes) {
		this.totalBoxes = totalBoxes;
	}
	public String getTransportMode() {
		return transportMode;
	}
	public void setTransportMode(String transportMode) {
		this.transportMode = transportMode;
	}
	public String getMainCustomer() {
		return mainCustomer;
	}
	public void setMainCustomer(String mainCustomer) {
		this.mainCustomer = mainCustomer;
	}
	public Date getOrderCreateTime() {
		return orderCreateTime;
	}
	public void setOrderCreateTime(Date orderCreateTime) {
		this.orderCreateTime = orderCreateTime;
	}
	public Date getExpectedDeliveryTime() {
		return expectedDeliveryTime;
	}
	public void setExpectedDeliveryTime(Date expectedDeliveryTime) {
		this.expectedDeliveryTime = expectedDeliveryTime;
	}
	public Date getExpectPickUpGoodsTime() {
		return expectPickUpGoodsTime;
	}
	public void setExpectPickUpGoodsTime(Date expectPickUpGoodsTime) {
		this.expectPickUpGoodsTime = expectPickUpGoodsTime;
	}
	public String getIsTray() {
		return isTray;
	}
	public void setIsTray(String isTray) {
		this.isTray = isTray;
	}
	public BigDecimal getTraySize() {
		return traySize;
	}
	public void setTraySize(BigDecimal traySize) {
		this.traySize = traySize;
	}
	public String getIsLoader() {
		return isLoader;
	}
	public void setIsLoader(String isLoader) {
		this.isLoader = isLoader;
	}
	public String getIsTrafficRestriction() {
		return isTrafficRestriction;
	}
	public void setIsTrafficRestriction(String isTrafficRestriction) {
		this.isTrafficRestriction = isTrafficRestriction;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Date getExpectArrivalTime() {
		return expectArrivalTime;
	}
	public void setExpectArrivalTime(Date expectArrivalTime) {
		this.expectArrivalTime = expectArrivalTime;
	}
	public String getLowstandardReceipt() {
		return lowstandardReceipt;
	}
	public void setLowstandardReceipt(String lowstandardReceipt) {
		this.lowstandardReceipt = lowstandardReceipt;
	}
	public String getCreatePerson() {
		return createPerson;
	}
	public void setCreatePerson(String createPerson) {
		this.createPerson = createPerson;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public String getAuditPerson() {
		return auditPerson;
	}
	public void setAuditPerson(String auditPerson) {
		this.auditPerson = auditPerson;
	}
	public Date getAuditTime() {
		return auditTime;
	}
	public void setAuditTime(Date auditTime) {
		this.auditTime = auditTime;
	}
}
