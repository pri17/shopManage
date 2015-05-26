package com.system.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "staff", catalog = "shopinf")
public class Staff implements java.io.Serializable {

	// Fields

	private Integer staffId;
	private String staffName;
	private String staffPwd;
	private Integer staffLevel;
	private Integer shopId;
	private Set<Purchase> purchases = new HashSet<Purchase>(0);
	private Set<Sale> sales = new HashSet<Sale>(0);
	private Set<Shop> shops = new HashSet<Shop>(0);

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** minimal constructor */
	public Staff(String staffName, String staffPwd, Integer staffLevel) {
		this.staffName = staffName;
		this.staffPwd = staffPwd;
		this.staffLevel = staffLevel;
	}

	/** full constructor */
	public Staff(String staffName, String staffPwd, Integer staffLevel,
			Integer shopId, Set<Purchase> purchases, Set<Sale> sales,
			Set<Shop> shops) {
		this.staffName = staffName;
		this.staffPwd = staffPwd;
		this.staffLevel = staffLevel;
		this.shopId = shopId;
		this.purchases = purchases;
		this.sales = sales;
		this.shops = shops;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "staff_id", unique = true, nullable = false)
	public Integer getStaffId() {
		return this.staffId;
	}

	public void setStaffId(Integer staffId) {
		this.staffId = staffId;
	}

	@Column(name = "staff_name", nullable = false, length = 50)
	public String getStaffName() {
		return this.staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	@Column(name = "staff_pwd", nullable = false, length = 50)
	public String getStaffPwd() {
		return this.staffPwd;
	}

	public void setStaffPwd(String staffPwd) {
		this.staffPwd = staffPwd;
	}

	@Column(name = "staff_level", nullable = false)
	public Integer getStaffLevel() {
		return this.staffLevel;
	}

	public void setStaffLevel(Integer staffLevel) {
		this.staffLevel = staffLevel;
	}

	@Column(name = "shop_id")
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<Sale> getSales() {
		return this.sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "staff")
	public Set<Shop> getShops() {
		return this.shops;
	}

	public void setShops(Set<Shop> shops) {
		this.shops = shops;
	}

}