package com.system.model;

import java.sql.Timestamp;

import com.system.Dao.AbstractPurchase;

/**
 * Purchase entity. @author MyEclipse Persistence Tools
 */
public class Purchase extends AbstractPurchase implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Purchase() {
	}

	/** minimal constructor */
	public Purchase(Shop shop, Staff staff, Goods goods, String workDay,
			Timestamp purchaseTime, Double purchasePrice, Integer purchaseNum) {
		super(shop, staff, goods, workDay, purchaseTime, purchasePrice,
				purchaseNum);
	}

	/** full constructor */
	public Purchase(Shop shop, Staff staff, Goods goods, String workDay,
			Timestamp purchaseTime, Double purchasePrice, Double salePrice,
			Integer purchaseNum) {
		super(shop, staff, goods, workDay, purchaseTime, purchasePrice,
				salePrice, purchaseNum);
	}

}
