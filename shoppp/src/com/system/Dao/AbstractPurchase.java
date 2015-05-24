package com.system.Dao;

import java.sql.Timestamp;

import com.system.model.Goods;
import com.system.model.Shop;
import com.system.model.Staff;

/**
 * AbstractPurchase entity provides the base persistence definition of the
 * Purchase entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractPurchase implements java.io.Serializable {

	// Fields

	private Integer purchaseId;
	private Shop shop;
	private Staff staff;
	private Goods goods;
	private String workDay;
	private Timestamp purchaseTime;
	private Double purchasePrice;
	private Double salePrice;
	private Integer purchaseNum;

	// Constructors

	/** default constructor */
	public AbstractPurchase() {
	}

	/** minimal constructor */
	public AbstractPurchase(Shop shop, Staff staff, Goods goods,
			String workDay, Timestamp purchaseTime, Double purchasePrice,
			Integer purchaseNum) {
		this.shop = shop;
		this.staff = staff;
		this.goods = goods;
		this.workDay = workDay;
		this.purchaseTime = purchaseTime;
		this.purchasePrice = purchasePrice;
		this.purchaseNum = purchaseNum;
	}

	/** full constructor */
	public AbstractPurchase(Shop shop, Staff staff, Goods goods,
			String workDay, Timestamp purchaseTime, Double purchasePrice,
			Double salePrice, Integer purchaseNum) {
		this.shop = shop;
		this.staff = staff;
		this.goods = goods;
		this.workDay = workDay;
		this.purchaseTime = purchaseTime;
		this.purchasePrice = purchasePrice;
		this.salePrice = salePrice;
		this.purchaseNum = purchaseNum;
	}

	// Property accessors

	public Integer getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public String getWorkDay() {
		return this.workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	public Timestamp getPurchaseTime() {
		return this.purchaseTime;
	}

	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	public Double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public Double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getPurchaseNum() {
		return this.purchaseNum;
	}

	public void setPurchaseNum(Integer purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

}