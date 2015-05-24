package com.system.model;

import java.util.Set;

import com.system.Dao.AbstractGoods;

/**
 * Goods entity. @author MyEclipse Persistence Tools
 */
public class Goods extends AbstractGoods implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Goods() {
	}

	/** minimal constructor */
	public Goods(Type type, String goodsName) {
		super(type, goodsName);
	}

	/** full constructor */
	public Goods(Type type, String goodsName, Set sales, Set purchases) {
		super(type, goodsName, sales, purchases);
	}

}
