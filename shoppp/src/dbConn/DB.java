package dbConn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import java.util.ArrayList;

import model.goods;
import model.purchase;
import model.sale;
import model.shop;
import model.staff;

public class DB {
	Connection conn;
	PreparedStatement state;
	
	public DB() {
			try{
				Class.forName("com.mysql.jdbc.Driver");
				conn=DriverManager.getConnection("jdbc:mysql:"
						+ "//localhost:3307/shopinf","root","12345");
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
	//get table 'shop' info
		public ArrayList getShopInfo(){
			try{
				state=conn.prepareStatement("select * from shop");
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					shop st=new shop();
					st.setShop_id(rs.getInt(1));
					st.setShop_name(rs.getString(2));
					st.setDistrict(rs.getString(3));
					st.setStaff_id(rs.getInt(4));
					st.setPrice(rs.getDouble(5));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	
		//get table 'staff's info
				public ArrayList getStaffInfo(){
					try{
						state=conn.prepareStatement("select * from staff");
						ArrayList al=new ArrayList();
						ResultSet rs=state.executeQuery();
						while(rs.next()){
							staff st=new staff();
							st.setStaff_id(rs.getInt(1));
							st.setStaff_name(rs.getString(2));
							st.setStaff_level(rs.getInt(4));
							al.add(st);
						}
						return al;
					}catch(Exception e){
						e.printStackTrace();
						return null;
					}
				}
		
	//get table 'sales''s info
	public ArrayList getSalesInfo(){
		try{
			state=conn.prepareStatement("select * from sale");
			ArrayList al=new ArrayList();
			ResultSet rs=state.executeQuery();
			while(rs.next()){
				sale st=new sale();
				st.setSale_id(rs.getInt(1));
				st.setGoods_id(rs.getInt(2));
				st.setShop_id(rs.getInt(3));
				st.setStaff_id(rs.getInt(4));
				st.setSale_time(rs.getDate(6));
				st.setWork_day();
				st.setSale_price(rs.getDouble(7));
				st.setSale_num(rs.getInt(8));
				al.add(st);
			}
			return al;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	//get table 'goods's info
	public ArrayList getGoodsInfo(){
		try{
			state=conn.prepareStatement("select * from goods");
			ArrayList a=new ArrayList();
			ResultSet rs=state.executeQuery();
			while(rs.next()){
				goods g=new goods();
				g.setGoods_id(rs.getInt(1));
				g.setGoods_name(rs.getString(2));
				g.setType_id(rs.getInt(3));
				a.add(g);
			}
			return a;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	//get table 'purchase's info
		public ArrayList getPurchaseInfo(){
			try{
				state=conn.prepareStatement("select * from purchase");
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					purchase p=new purchase();
					p.setPurchase_id(rs.getInt(1));
					p.setGoods_id(rs.getInt(2));
					p.setShop_id(rs.getInt(3));
					p.setStaff_id(rs.getInt(4));
					p.setPurchase_time(rs.getDate(6));
					p.setWork_day();
					p.setPurchase_price(rs.getDouble(7));
					p.setSale_price(rs.getDouble(8));
					p.setPurchase_num(rs.getInt(9));
					a.add(p);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
	//get user's name by user's id
	public String getUserName(int id){
		String name=null;
		try{
			state=conn.prepareStatement("select username from users where id=?");
			state.setInt(1, id);
			ResultSet rs=state.executeQuery();
			while(rs.next()){
				name=rs.getString("username");
			}
			return name;
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
	}
	
	//add shop's info
		public boolean addShop(shop st){
			try{
				state=conn.prepareStatement("insert into shop (shop_name,district,staff_id,price) values(?,?,?,?)");
				state.setString(1, st.getShop_name());
				state.setString(2, st.getDistrict());
				state.setInt(3,st.getStaff_id());
				state.setDouble(4, st.getPrice());
				state.executeUpdate();
				return true;
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
		
	//add goods's info
		public boolean addGoods(goods st){
			try{
				state=conn.prepareStatement("insert into goods (goods_name,type_id) values(?,?)");
				state.setString(1, st.getGoods_name());
				state.setInt(2, st.getType_id());;
				state.executeUpdate();
				return true;
			}catch(SQLException e){
				e.printStackTrace();
				return false;
			}
		}
//****get type name by id	
		public String getTypeName(int id){
			String name=null;
			try{
				state=conn.prepareStatement("select type_name from type where type_id=?");
				state.setInt(1, id);
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					name=rs.getString("type_name");
				}
				return name;
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
//get staff info by name
		public ArrayList getStaffByName(String name) {
			try{
				state=conn.prepareStatement("select * from staff where staff_name like ? order by staff_name desc,staff_id desc");
				state.setString(1,"%"+ name+"%");
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					staff st=new staff();
					st.setStaff_id(rs.getInt(1));
					st.setStaff_name(rs.getString(2));
					st.setStaff_level(rs.getInt(4));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get staff info by id
		public ArrayList getStaffByID(String id) {
			try{
				int i=Integer.parseInt(id);
				state=conn.prepareStatement("select * from staff where staff_id=? ");
				state.setInt(1, i);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					staff st=new staff();
					st.setStaff_id(rs.getInt(1));
					st.setStaff_name(rs.getString(2));
					st.setStaff_level(rs.getInt(4));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get staff info by level
		public ArrayList getStaffByLevel(int level) {
			try{
				state=conn.prepareStatement("select * from staff where staff_level=? order by staff_id desc");
				state.setInt(1, level);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					staff st=new staff();
					st.setStaff_id(rs.getInt(1));
					st.setStaff_name(rs.getString(2));
					st.setStaff_level(rs.getInt(4));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//*******get staff name by id
		public String getStaffName(int id) {
			String name=null;
			try{
				state=conn.prepareStatement("select staff_name from staff where staff_id=?");
				state.setInt(1, id);
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					name=rs.getString("staff_name");
				}
				return name;
			}catch(SQLException e){
				e.printStackTrace();
				return null;
			}
		}
////对商店搜寻
//get shop by shop_name
		public ArrayList getShopByName(String name) {
			try{
				state=conn.prepareStatement("select * from shop where shop_name like ? order by shop_name desc,shop_id desc");
				state.setString(1, "%"+name+"%");
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					shop st=new shop();
					st.setShop_id(rs.getInt(1));
					st.setShop_name(rs.getString(2));
					st.setDistrict(rs.getString(3));
					st.setStaff_id(rs.getInt(4));
					st.setPrice(rs.getDouble(5));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get shop by shop_id
		public ArrayList getShopByID(String id) {
			try{
				state=conn.prepareStatement("select * from shop where shop_id = ?");
				state.setString(1, id);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					shop st=new shop();
					st.setShop_id(rs.getInt(1));
					st.setShop_name(rs.getString(2));
					st.setDistrict(rs.getString(3));
					st.setStaff_id(rs.getInt(4));
					st.setPrice(rs.getDouble(5));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get shop info by staff name
		public ArrayList getShopByStaffName(String name) {
			try{
				state=conn.prepareStatement("select distinct * from shop,staff where shop.staff_id=staff.staff_id and staff_name like ? order by staff_name desc,shop_id desc");
				state.setString(1, "%"+name+"%");
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					shop st=new shop();
					st.setShop_id(rs.getInt(1));
					st.setShop_name(rs.getString(2));
					st.setDistrict(rs.getString(3));
					st.setStaff_id(rs.getInt(4));
					st.setPrice(rs.getDouble(5));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//********get staff level
		public int getStaffLevel(int staff_id) {
			int l=0;
			try{
				state=conn.prepareStatement("select staff_level from staff where staff_id=? ");
				state.setInt(1, staff_id);
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					l=rs.getInt("staff_level");
				}
				return l;
			}catch(SQLException e){
				e.printStackTrace();
				return -1;
			}
		}
//get shop info by staff id
		public ArrayList getShopByStaffID(int id) {
			try{
				state=conn.prepareStatement("select * from shop where staff_id = ? order by staff_id desc,shop_id desc");
				state.setInt(1, id);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					shop st=new shop();
					st.setShop_id(rs.getInt(1));
					st.setShop_name(rs.getString(2));
					st.setDistrict(rs.getString(3));
					st.setStaff_id(rs.getInt(4));
					st.setPrice(rs.getDouble(5));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get shop info by area
		public ArrayList getShopByArea(String area) {
			try{
				state=conn.prepareStatement("select * from shop where district like ? order by district desc,shop_id desc");
				state.setString(1, "%"+area+"%");
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					shop st=new shop();
					st.setShop_id(rs.getInt(1));
					st.setShop_name(rs.getString(2));
					st.setDistrict(rs.getString(3));
					st.setStaff_id(rs.getInt(4));
					st.setPrice(rs.getDouble(5));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get shop by price 
		public ArrayList getShopByPrice(double p1, double p2) {
			try{
				state=conn.prepareStatement("select * from shop where price between ? and ? order by shop_id desc");
				state.setDouble(1,p1);
				state.setDouble(2, p2);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					shop st=new shop();
					st.setShop_id(rs.getInt(1));
					st.setShop_name(rs.getString(2));
					st.setDistrict(rs.getString(3));
					st.setStaff_id(rs.getInt(4));
					st.setPrice(rs.getDouble(5));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
/////对商品搜寻
//get goods info by name
		public ArrayList getGoodsByName(String name) {
			try{
				state=conn.prepareStatement("select * from goods where goods_name like ? order by goods_name desc,goods_id desc");
				state.setString(1,"%"+ name+"%");
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					goods st=new goods();
					st.setGoods_id(rs.getInt(1));
					st.setGoods_name(rs.getString(2));
					st.setType_id(rs.getInt(3));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get goods info by id
		public ArrayList getGoodsByID(int id) {
			try{
				state=conn.prepareStatement("select * from goods where goods_id = ? ");
				state.setInt(1, id);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					goods st=new goods();
					st.setGoods_id(rs.getInt(1));
					st.setGoods_name(rs.getString(2));
					st.setType_id(rs.getInt(3));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
///********get goods name by id
				public String getGoodsByID1(int id) {
					try{
						String name="";
						state=conn.prepareStatement("select * from goods where goods_id = ? ");
						state.setInt(1, id);
						ResultSet rs=state.executeQuery();
						while(rs.next()){
							name=rs.getString("goods_name");
						}
						return name;
					}catch(Exception e){
						e.printStackTrace();
						return "";
					}
				}
//get goods info by type
		public ArrayList getGoodsByType(String type) {
			try{
				state=conn.prepareStatement("select * from goods,type where goods.type_id = type.type_id and type_name like ? order by type_name desc,goods_id desc");
				state.setString(1,"%"+type+"%");
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					goods st=new goods();
					st.setGoods_id(rs.getInt(1));
					st.setGoods_name(rs.getString(2));
					st.setType_id(rs.getInt(3));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//
//
//del shop info by shop id
		public void delShop(int id) {
			try {
				state=conn.prepareStatement("delete from shop where shop_id =?");
				state.setInt(1,id);
				state.executeUpdate();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
//del goods info 
		public void delGoods(int id) {
			try {
				state=conn.prepareStatement("delete from goods where goods_id =?");
				state.setInt(1,id);
				state.executeUpdate();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
//	del sale info
		public void delSales(int id) {
			try {
				state=conn.prepareStatement("delete from sale where sale_id =?");
				state.setInt(1,id);
				state.executeUpdate();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
		
		
//del purchase info
			public void delPurchase(int id) {
				try {
					state=conn.prepareStatement("delete from purchase where purchase_id =?");
					state.setInt(1,id);
					state.executeUpdate();
					} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
			
//**************get shop name
		public String getShopName(int id) {
			try{
				String name="";
				state=conn.prepareStatement("select * from shop where shop_id = ? ");
				state.setInt(1, id);
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					name=rs.getString("shop_name");
				}
				return name;
			}catch(Exception e){
				e.printStackTrace();
				return "";
			}
		}

		
////////////search 'sale' table	
//get sales info by shop name
		public ArrayList getSalesByShopName(String name) {
			try{
				state=conn.prepareStatement("select * from sale ,shop where sale.shop_id=shop.shop_id and shop_name like ? ");
				state.setString(1, "%"+name+"%");
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					sale st=new sale();
					st.setSale_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setSale_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setSale_num(rs.getInt(8));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get sale info by shop id
		public ArrayList getSalesByShopID(int id) {
			try{
				state=conn.prepareStatement("select * from sale  where  shop_id = ? ");
				state.setInt(1, id);
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					sale st=new sale();
					st.setSale_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setSale_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setSale_num(rs.getInt(8));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get sale by staff name
		public ArrayList getSalesByStaffName(String name) {
			try{
				state=conn.prepareStatement("select * from sale,staff  where  staff.staff_id=sale.staff_id and staff_name like ? ");
				state.setString(1, "%"+name+"%");
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					sale st=new sale();
					st.setSale_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setSale_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setSale_num(rs.getInt(8));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get sale inf by staff id
		public ArrayList getSalesByStaffID(int id) {
			try{
				state=conn.prepareStatement("select * from sale  where  staff_id = ? ");
				state.setInt(1, id);
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					sale st=new sale();
					st.setSale_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setSale_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setSale_num(rs.getInt(8));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
		
//get sale info by id
		public ArrayList getSalesByID(int id) {
			try{
				state=conn.prepareStatement("select * from sale  where  sale_id = ? ");
				state.setInt(1, id);
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					sale st=new sale();
					st.setSale_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setSale_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setSale_num(rs.getInt(8));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//get sale info by num
		public ArrayList getSaleByNum(int p1, int p2) {
			try{
				state=conn.prepareStatement("select * from sale where sale_num between ? and ? order by sale_id desc");
				state.setInt(1,p1);
				state.setInt(2, p2);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					sale st=new sale();
					st.setSale_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setSale_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setSale_num(rs.getInt(8));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
////
////
////search purchase by shop name
		public ArrayList getPurchaseByShopName(String name) {
			try{
				state=conn.prepareStatement("select * from purchase ,shop where purchase.shop_id=shop.shop_id and shop_name like ? ");
				state.setString(1, "%"+name+"%");
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					purchase st=new purchase();
					st.setPurchase_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setPurchase_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setPurchase_num(rs.getInt(9));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//
		public ArrayList getPurchaseByShopID(int id) {
			try{
				state=conn.prepareStatement("select * from purchase where shop_id = ? ");
				state.setInt(1, id);
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					purchase st=new purchase();
					st.setPurchase_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setPurchase_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setPurchase_num(rs.getInt(9));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//
		public ArrayList getPurchaseByStaffName(String name) {
			try{
				state=conn.prepareStatement("select * from purchase,staff  where  staff.staff_id=purchase.staff_id and staff_name like ? ");
				state.setString(1, "%"+name+"%");
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					purchase st=new purchase();
					st.setPurchase_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setPurchase_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setPurchase_num(rs.getInt(9));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//
		public ArrayList getPurchaseByStaffID(int id) {
			try{
				state=conn.prepareStatement("select * from purchase where staff_id = ? ");
				state.setInt(1, id);
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					purchase st=new purchase();
					st.setPurchase_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setPurchase_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setPurchase_num(rs.getInt(9));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//
		public ArrayList getPurchaseByID(int id) {
			try{
				state=conn.prepareStatement("select * from purchase where purchase_id = ? ");
				state.setInt(1, id);
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					purchase st=new purchase();
					st.setPurchase_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setPurchase_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setPurchase_num(rs.getInt(9));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//
		public ArrayList getPurchaseByNum(int p1, int p2) {
			try{
				state=conn.prepareStatement("select * from purchase where purchase_num between ? and ? order by purchase_id desc");
				state.setInt(1,p1);
				state.setInt(2, p2);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					purchase st=new purchase();
					st.setPurchase_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setPurchase_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setPurchase_num(rs.getInt(9));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}

//
		public ArrayList getSaleByDate(String p1, String p2) {
			try{
				state=conn.prepareStatement("select * from sale  where sale_time > ? and sale_time < ? ");
				state.setString(1,p1);
				state.setString(2,p2);
				ArrayList al=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					sale st=new sale();
					st.setSale_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setSale_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setSale_num(rs.getInt(8));
					al.add(st);
				}
				return al;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}
//
		public ArrayList getPurchaseByDate(String p1, String p2) {
			try{
				state=conn.prepareStatement("select * from purchase where purchase_time > ? and purchase_time < ? order by purchase_id desc");
				state.setString(1,p1);
				state.setString(2, p2);
				ArrayList a=new ArrayList();
				ResultSet rs=state.executeQuery();
				while(rs.next()){
					purchase st=new purchase();
					st.setPurchase_id(rs.getInt(1));
					st.setGoods_id(rs.getInt(2));
					st.setShop_id(rs.getInt(3));
					st.setStaff_id(rs.getInt(4));
					st.setPurchase_time(rs.getDate(6));
					st.setWork_day();
					st.setSale_price(rs.getDouble(7));
					st.setPurchase_num(rs.getInt(9));
					a.add(st);
				}
				return a;
			}catch(Exception e){
				e.printStackTrace();
				return null;
			}
		}

	
		
				
}

