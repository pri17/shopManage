package com.system.model;

import java.sql.Timestamp;

import com.system.Dao.AbstractSale;

/**
 * Sale entity. @author MyEclipse Persistence Tools
 */
public class Sale extends AbstractSale implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Sale() {
	}

	/** full constructor */
	public Sale(Shop shop, Staff staff, Goods goods, String workDay,
			Timestamp saleTime, Double salePrice, Integer saleNum) {
		super(shop, staff, goods, workDay, saleTime, salePrice, saleNum);
	}

}
