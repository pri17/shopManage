package org.spsystem.vo;

import java.math.BigDecimal;

public class GoodsInfBean {
	private int id;
	private String name;
	private double price;
	private long num;
	public GoodsInfBean(){}
	public GoodsInfBean(int id, String name, double price, long num) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.num = num;
	}
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		BigDecimal   b   =   new   BigDecimal(price);  
		return  b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
	}
	public void setPrice(double price) {
		BigDecimal   b   =   new   BigDecimal(price);  
		this.price   =   b.setScale(2,   BigDecimal.ROUND_HALF_UP).doubleValue();  
	}
	public long getNum() {
		return num;
	}
	public void setNum(long num) {
		this.num = num;
	}	
}
