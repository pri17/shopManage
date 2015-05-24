package com.system.model;

import java.util.Set;

import com.system.Dao.AbstractType;

/**
 * Type entity. @author MyEclipse Persistence Tools
 */
public class Type extends AbstractType implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public Type() {
	}

	/** minimal constructor */
	public Type(String typeName) {
		super(typeName);
	}

	/** full constructor */
	public Type(String typeName, Set goodses) {
		super(typeName, goodses);
	}

}
