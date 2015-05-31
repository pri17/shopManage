package com.origi.model;

import java.io.Serializable;

public class staff implements Serializable{
	private int staff_id;
	private String staff_name;
	private String staff_pwd;
	private int staff_level;
	
	
	public int getStaff_id() {
		return staff_id;
	}
	public void setStaff_id(int staff_id) {
		this.staff_id = staff_id;
	}
	public String getStaff_name() {
		return staff_name;
	}
	public void setStaff_name(String staff_name) {
		this.staff_name = staff_name;
	}
	public String getStaff_pwd() {
		return staff_pwd;
	}
	public void setStaff_pwd(String staff_pwd) {
		this.staff_pwd = staff_pwd;
	}
	public int getStaff_level() {
		return staff_level;
	}
	public void setStaff_level(int staff_level) {
		this.staff_level = staff_level;
	}
	
	
}
