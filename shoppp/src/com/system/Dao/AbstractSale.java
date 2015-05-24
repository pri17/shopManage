package com.system.Dao;

import java.sql.Timestamp;

import com.system.model.Goods;
import com.system.model.Shop;
import com.system.model.Staff;

/**
 * AbstractSale entity provides the base persistence definition of the Sale
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractSale implements java.io.Serializable {

	// Fields

	private Integer saleId;
	private Shop shop;
	private Staff staff;
	private Goods goods;
	private String workDay;
	private Timestamp saleTime;
	private Double salePrice;
	private Integer saleNum;

	// Constructors

	/** default constructor */
	public AbstractSale() {
	}

	/** full constructor */
	public AbstractSale(Shop shop, Staff staff, Goods goods, String workDay,
			Timestamp saleTime, Double salePrice, Integer saleNum) {
		this.shop = shop;
		this.staff = staff;
		this.goods = goods;
		this.workDay = workDay;
		this.saleTime = saleTime;
		this.salePrice = salePrice;
		this.saleNum = saleNum;
	}

	// Property accessors

	public Integer getSaleId() {
		return this.saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
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

	public Timestamp getSaleTime() {
		return this.saleTime;
	}

	public void setSaleTime(Timestamp saleTime) {
		this.saleTime = saleTime;
	}

	public Double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	public Integer getSaleNum() {
		return this.saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

}