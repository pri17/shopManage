package com.zm.model;
public class Staff {
	private int staff_id;
	private String staff_name;
	private String staff_pwd;
	private int staff_level;
	private int shop_id;
	
	public int getShop_id() {
		return shop_id;
	}
	public void setShop_id(int shop_id) {
		this.shop_id = shop_id;
	}
	public void setStaff_id(int id)
	{
		staff_id=id;
	}
	public int getStaff_id()
	{
		return staff_id;
	}
	public void setStaff_name(String name)
	{
		staff_name=name;
	}
	public String getStaff_name()
	{
		return staff_name;
	}
	public void setStaff_pwd(String pwd)
	{
		staff_pwd=pwd;
	}
	public String getStaff_pwd()
	{
		return staff_pwd;
	}
	public void setStaff_level(int level)
	{
		staff_level=level;
	}
	public int getStaff_level()
	{
		return staff_level;
	}
}
