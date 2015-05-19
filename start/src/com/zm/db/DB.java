package com.zm.db;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import com.zm.model.*;
public class DB {
	Connection con;
	PreparedStatement statement;
	public DB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/shopinf","root","12345");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	public Staff checkUser(String username,String password){
		try{
			statement=con.prepareStatement("select staff_id, staff_name, staff_pwd, staff_level, shop_id from staff where staff_name=? and staff_pwd=?");
			statement.setString(1,username);
			statement.setString(2,password);
			ResultSet res=statement.executeQuery();
			Staff user=new Staff();
			while(res.next()){
				user.setStaff_id(res.getInt(1));
				user.setStaff_name(res.getString(2));
				user.setStaff_pwd(res.getString(3));
				user.setStaff_level(res.getInt(4));
				user.setShop_id(res.getInt(5));
				return user;
			}
			return null;
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}	
	}
	
	public void saveSale(int id, double price, int num, Staff s ){
		java.util.Date now = new java.util.Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		try {
			statement=con.prepareStatement("insert into sale(goods_id, shop_id, staff_id, work_day, sale_time, sale_price, sale_num) values (?, ?, ?, ?, ?, ?, ?) ");
			statement.setInt(1, id);
			statement.setInt(2, s.getShop_id());
			statement.setInt(3, s.getStaff_id());
			statement.setDouble(6, price);
			statement.setString(4, DateFormat.getDateInstance().format(now));
			statement.setObject(5, timestamp);
			statement.setInt(7, num);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void savePurchase(int id, double price, int num, Staff s, double inprice ){
		java.util.Date now = new java.util.Date();
		Timestamp timestamp = new Timestamp(now.getTime());
		try {
			statement=con.prepareStatement("insert into purchase(goods_id, shop_id, staff_id, work_day, purchase_time, purchase_price, sale_price, purchase_num) values (?, ?, ?, ?, ?, ?, ?, ?) ");
			statement.setInt(1, id);
			statement.setInt(2, s.getShop_id());
			statement.setInt(3, s.getStaff_id());
			statement.setDouble(6, inprice);
			statement.setDouble(7, price);
			statement.setString(4, DateFormat.getDateInstance().format(now));
			statement.setObject(5,  timestamp);
			statement.setInt(8, num);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public int saveGoods(String name, int typeId ){
		int res = 0;
		try {
			statement=con.prepareStatement("insert into goods(goods_name, type_id) values (?, ?)");
			statement.setInt(2, typeId);
			statement.setString(1, name);
			statement.executeUpdate();
			statement=con.prepareStatement("select goods_id from goods where goods_name='"+name+"' and type_id="+typeId+"order by goods_id desc" );
			
			ResultSet result = statement.executeQuery();
			if(result.next()){
				res = result.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public boolean GoodsExist(int id){
		try {
			statement=con.prepareStatement("select * from goods where goods_id="+id);
			
			ResultSet res = statement.executeQuery();
			if(res.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
