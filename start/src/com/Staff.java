package com;

import java.util.Set;

/**
 * Staff entity. @author MyEclipse Persistence Tools
 */
public class Staff extends AbstractStaff implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Staff() {
	}

	/** minimal constructor */
	public Staff(String staffName, String staffPwd, Integer staffLevel) {
		super(staffName, staffPwd, staffLevel);
	}

	/** full constructor */
	public Staff(String staffName, String staffPwd, Integer staffLevel,
			Integer shopId, Set purchases, Set sales, Set shops) {
		super(staffName, staffPwd, staffLevel, shopId, purchases, sales, shops);
	}

}
