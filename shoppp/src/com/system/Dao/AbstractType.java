package com.system.Dao;

import java.util.HashSet;
import java.util.Set;

/**
 * AbstractType entity provides the base persistence definition of the Type
 * entity. @author MyEclipse Persistence Tools
 */

public abstract class AbstractType implements java.io.Serializable {

	// Fields

	private Integer typeId;
	private String typeName;
	private Set goodses = new HashSet(0);

	// Constructors

	/** default constructor */
	public AbstractType() {
	}

	/** minimal constructor */
	public AbstractType(String typeName) {
		this.typeName = typeName;
	}

	/** full constructor */
	public AbstractType(String typeName, Set goodses) {
		this.typeName = typeName;
		this.goodses = goodses;
	}

	// Property accessors

	public Integer getTypeId() {
		return this.typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public Set getGoodses() {
		return this.goodses;
	}

	public void setGoodses(Set goodses) {
		this.goodses = goodses;
	}

}