package com;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractStaff entity provides the base persistence definition of the Staff
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractStaff implements java.io.Serializable {

	// Fields

	private Integer staffId;
	private String staffName;
	private String staffPwd;
	private Integer staffLevel;
	private Integer shopId;
	private Set purchases = new HashSet(0);
	private Set sales = new HashSet(0);
	private Set shops = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractStaff() {
	}

	/** minimal constructor */
	public AbstractStaff(String staffName, String staffPwd, Integer staffLevel) {
		this.staffName = staffName;
		this.staffPwd = staffPwd;
		this.staffLevel = staffLevel;
	}

	/** full constructor */
	public AbstractStaff(String staffName, String staffPwd, Integer staffLevel,
			Integer shopId, Set purchases, Set sales, Set shops) {
		this.staffName = staffName;
		this.staffPwd = staffPwd;
		this.staffLevel = staffLevel;
		this.shopId = shopId;
		this.purchases = purchases;
		this.sales = sales;
		this.shops = shops;
	}

	// Property accessors

	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getStaffPwd() {
		return this.staffPwd;
	}

	public void setStaffPwd(String staffPwd) {
		this.staffPwd = staffPwd;
	}

	public Integer getStaffLevel() {
		return this.staffLevel;
	}

	public void setStaffLevel(Integer staffLevel) {
		this.staffLevel = staffLevel;
	}

	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public Set getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set purchases) {
		this.purchases = purchases;
	}

	public Set getSales() {
		return this.sales;
	}

	public void setSales(Set sales) {
		this.sales = sales;
	}

	public Set getShops() {
		return this.shops;
	}

	public void setShops(Set shops) {
		this.shops = shops;
	}

}