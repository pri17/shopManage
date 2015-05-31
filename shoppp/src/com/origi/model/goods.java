package com.origi.model;

import java.io.Serializable;

public class goods implements Serializable{
	private int goods_id;
	private String goods_name;
	private int type_id;
	
	public goods(){}
	public goods(String name,int type){
		this.goods_name=name;
		this.type_id=type;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public String getGoods_name() {
		return goods_name;
	}
	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}
	public int getType_id() {
		return type_id;
	}
	public void setType_id(int type_id) {
		this.type_id = type_id;
	}
}
