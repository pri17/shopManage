package model;

import java.io.Serializable;
import java.sql.Date;

public class purchase implements Serializable{
	private int purchase_id;
	private int goods_id;
	private int shop_id;
	private int staff_id;
	private String work_day;
	private Date purchase_time;
	private double purchase_price;
	private double sale_price;//未用,直接用sale表的价格
	private int purchase_num;
	
	
	public int getPurchase_id() {
		return purchase_id;
	}
	public void setPurchase_id(int purchase_id) {
		this.purchase_id = purchase_id;
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
	public void setWork_day() {
		this.work_day = purchase_time.toString();
	}
	public Date getPurchase_time() {
		return purchase_time;
	}
	public void setPurchase_time(Date purchase_time) {
		this.purchase_time = purchase_time;
	}
	public double getPurchase_price() {
		return purchase_price;
	}
	public void setPurchase_price(double purchase_price) {
		this.purchase_price = purchase_price;
	}
	public double getSale_price() {
		return sale_price;
	}
	public void setSale_price(double sale_price) {
		this.sale_price = sale_price;
	}
	public int getPurchase_num() {
		return purchase_num;
	}
	public void setPurchase_num(int purchase_num) {
		this.purchase_num = purchase_num;
	}
	
	
	
	
}
