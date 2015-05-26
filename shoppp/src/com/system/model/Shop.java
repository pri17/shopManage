package com.system.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "shop", catalog = "shopinf")
public class Shop implements java.io.Serializable {

	// Fields

	private Integer shopId;
	private Staff staff;
	private String shopName;
	private String district;
	private Double price;
	private Set<Sale> sales = new HashSet<Sale>(0);
	private Set<Purchase> purchases = new HashSet<Purchase>(0);

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** minimal constructor */
	public Shop(Staff staff, String shopName, String district) {
		this.staff = staff;
		this.shopName = shopName;
		this.district = district;
	}

	/** full constructor */
	public Shop(Staff staff, String shopName, String district, Double price,
			Set<Sale> sales, Set<Purchase> purchases) {
		this.staff = staff;
		this.shopName = shopName;
		this.district = district;
		this.price = price;
		this.sales = sales;
		this.purchases = purchases;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "shop_id", unique = true, nullable = false)
	public Integer getShopId() {
		return this.shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@Column(name = "shop_name", nullable = false, length = 100)
	public String getShopName() {
		return this.shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	@Column(name = "district", nullable = false, length = 400)
	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	@Column(name = "price", precision = 22, scale = 0)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shop")
	public Set<Sale> getSales() {
		return this.sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "shop")
	public Set<Purchase> getPurchases() {
		return this.purchases;
	}

	public void setPurchases(Set<Purchase> purchases) {
		this.purchases = purchases;
	}

}