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
 * Sale entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "sale", catalog = "shopinf")
public class Sale implements java.io.Serializable {

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
	public Sale() {
	}

	/** full constructor */
	public Sale(Shop shop, Staff staff, Goods goods, String workDay,
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
	@Id
	@GeneratedValue
	@Column(name = "sale_id", unique = true, nullable = false)
	public Integer getSaleId() {
		return this.saleId;
	}

	public void setSaleId(Integer saleId) {
		this.saleId = saleId;
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

	@Column(name = "sale_time", nullable = false, length = 19)
	public Timestamp getSaleTime() {
		return this.saleTime;
	}

	public void setSaleTime(Timestamp saleTime) {
		this.saleTime = saleTime;
	}

	@Column(name = "sale_price", nullable = false, precision = 22, scale = 0)
	public Double getSalePrice() {
		return this.salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}

	@Column(name = "sale_num", nullable = false)
	public Integer getSaleNum() {
		return this.saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

}