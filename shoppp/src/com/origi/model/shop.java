package com.origi.model;

import java.io.Serializable;

public class shop implements Serializable{
	private int shop_id;
	private String shop_name;
	private String district;
	private int staff_id;
	private double price;
	
	public shop(){
	}
	public shop(String name,String dis,int id,double p){
		this.shop_name=name;
		this.district=dis;
		this.staff_id=id;
		this.price=p;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
}
