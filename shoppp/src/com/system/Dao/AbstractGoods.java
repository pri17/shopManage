package com.system.Dao;

import java.util.HashSet;
import java.util.Set;

import com.system.model.Type;

/**
 * AbstractGoods entity provides the base persistence definition of the Goods
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractGoods implements java.io.Serializable {

	// Fields

	private Integer goodsId;
	private Type type;
	private String goodsName;
	private Set sales = new HashSet(0);
	private Set purchases = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractGoods() {
	}

	/** minimal constructor */
	public AbstractGoods(Type type, String goodsName) {
		this.type = type;
		this.goodsName = goodsName;
	}

	/** full constructor */
	public AbstractGoods(Type type, String goodsName, Set sales, Set purchases) {
		this.type = type;
		this.goodsName = goodsName;
		this.sales = sales;
		this.purchases = purchases;
	}

	// Property accessors

	public Integer getGoodsId() {
		return this.goodsId;
	}

	public void setGoodsId(Integer goodsId) {
		this.goodsId = goodsId;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
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