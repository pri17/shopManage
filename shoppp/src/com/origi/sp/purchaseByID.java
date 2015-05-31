package com.origi.sp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.origi.dbConn.DB;
import com.origi.model.goods;
import com.origi.model.purchase;
import com.origi.model.sale;
import com.origi.model.shop;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class purchaseByID extends HttpServlet{

	protected void doGet(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    this.doPost(request, response);
		  }
	
	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/xml");
		    response.setContentType("text/html;charset=utf-8");
		    DB db=new DB();
			int id=Integer.parseInt(request.getParameter("id"));
			PrintWriter out=response.getWriter();
			JSONArray array = new JSONArray();	
			JSONObject member = null;
			member = new JSONObject();

			ArrayList al=db.getPurchaseByID(id);
			Iterator it=al.iterator();
				while(it.hasNext()){
					purchase t=(purchase) it.next();
					String staff_name=db.getStaffName(t.getStaff_id());
					String shop_name=db.getShopName(t.getShop_id());
					String goods_name=db.getGoodsByID1(t.getGoods_id());
					member.put("goods_id", t.getGoods_id());
					member.put("goods_name",goods_name);
					member.put("shop_name",shop_name);
					member.put("shop_id", t.getShop_id());
					member.put("staff_id",t.getStaff_id());
					member.put("staff_name", staff_name);
					member.put("sales_id", t.getPurchase_id());
					member.put("date", t.getWork_day());
					member.put("num", t.getPurchase_num());
					member.put("price", t.getSale_price());//8
				    array.add(member);
			}
				String str=array.toString();
				PrintWriter pw = response.getWriter();
				pw.print(str);
				pw.close();
	}

}
