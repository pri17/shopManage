package com.system.model;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Purchase entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "purchase", catalog = "shopinf")
public class Purchase implements java.io.Serializable {

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
	public Purchase() {
	}

	/** minimal constructor */
	public Purchase(Shop shop, Staff staff, Goods goods, String workDay,
			Timestamp purchaseTime, Double purchasePrice, Integer purchaseNum) {
		this.shop = shop;
		this.staff = staff;
		this.goods = goods;
		this.workDay = workDay;
		this.purchaseTime = purchaseTime;
		this.purchasePrice = purchasePrice;
		this.purchaseNum = purchaseNum;
	}

	/** full constructor */
	public Purchase(Shop shop, Staff staff, Goods goods, String workDay,
			Timestamp purchaseTime, Double purchasePrice, Double salePrice,
			Integer purchaseNum) {
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
	@Id
	@GeneratedValue
	@Column(name = "purchase_id", unique = true, nullable = false)
	public Integer getPurchaseId() {
		return this.purchaseId;
	}

	public void setPurchaseId(Integer purchaseId) {
		this.purchaseId = purchaseId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "shop_id", nullable = false)
	public Shop getShop() {
		return this.shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "staff_id", nullable = false)
	public Staff getStaff() {
		return this.staff;
	}

	public void setStaff(Staff staff) {
		this.staff = staff;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goods_id", nullable = false)
	public Goods getGoods() {
		return this.goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	@Column(name = "work_day", nullable = false, length = 50)
	public String getWorkDay() {
		return this.workDay;
	}

	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}

	@Column(name = "purchase_time", nullable = false, length = 19)
	public Timestamp getPurchaseTime() {
		return this.purchaseTime;
	}

	public void setPurchaseTime(Timestamp purchaseTime) {
		this.purchaseTime = purchaseTime;
	}

	@Column(name = "purchase_price", nullable = false, precision = 22, scale = 0)
	public Double getPurchasePrice() {
		return this.purchasePrice;
	}

	public void setPurchasePrice(Double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	@Column(name = "sale_price", precision = 22, scale = 0)
	public Double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	@Column(name = "purchase_num", nullable = false)
	public Integer getPurchaseNum() {
		return this.purchaseNum;
	}

	public void setPurchaseNum(Integer purchaseNum) {
		this.purchaseNum = purchaseNum;
	}

}