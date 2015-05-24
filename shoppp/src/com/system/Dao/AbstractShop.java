package com.system.Dao;

import java.util.HashSet;
import java.util.Set;

import com.system.model.Staff;

/**
 * AbstractShop entity provides the base persistence definition of the Shop
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractShop implements java.io.Serializable {

	// Fields

	private Integer shopId;
	private Staff staff;
	private String shopName;
	private String district;
	private Double price;
	private Set sales = new HashSet(0);
	private Set purchases = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractShop() {
	}

	/** minimal constructor */
	public AbstractShop(Staff staff, String shopName, String district) {
		this.staff = staff;
		this.shopName = shopName;
		this.district = district;
	}

	/** full constructor */
	public AbstractShop(Staff staff, String shopName, String district,
			Double price, Set sales, Set purchases) {
		this.staff = staff;
		this.shopName = shopName;
		this.district = district;
		this.price = price;
		this.sales = sales;
		this.purchases = purchases;
	}

	// Property accessors

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Set getSales() {
		return this.sales;
	}

	public void setSales(Set sales) {
		this.sales = sales;
	}

	public Set getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set purchases) {
		this.purchases = purchases;
	}

}