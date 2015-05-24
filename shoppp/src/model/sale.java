package model;

import java.io.Serializable;
import java.sql.Date;

public class sale implements Serializable{
	private int sale_id;
	private int goods_id;
	private int shop_id;
	private int staff_id;
	private String work_day;
	private Date sale_time;
	private double sale_price;
	private int sale_num;
	
	
	public int getSale_id() {
		return sale_id;
	}
	public void setSale_id(int sale_id) {
		this.sale_id = sale_id;
	}
	public int getGoods_id() {
		return goods_id;
	}
	public void setGoods_id(int goods_id) {
		this.goods_id = goods_id;
	}
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getWork_day() {
		return work_day;
	}
	public void setWork_day() {//work_dayÊÇsale_timeµÄtoString()
		this.work_day = getSale_time().toString();
	}
	public Date getSale_time() {
		return sale_time;
	}
	public void setSale_time(Date sale_time) {
		this.sale_time = sale_time;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public int getSale_num() {
		return sale_num;
	}
	public void setSale_num(int sale_num) {
		this.sale_num = sale_num;
	}
	
}
