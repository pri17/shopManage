package com.system.model;

import java.util.Set;

import com.system.Dao.AbstractShop;

/**
 * Shop entity. @author MyEclipse Persistence Tools
 */
public class Shop extends AbstractShop implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Shop() {
	}

	/** minimal constructor */
	public Shop(Staff staff, String shopName, String district) {
		super(staff, shopName, district);
	}

	/** full constructor */
	public Shop(Staff staff, String shopName, String district, Double price,
			Set sales, Set purchases) {
		super(staff, shopName, district, price, sales, purchases);
	}

}
