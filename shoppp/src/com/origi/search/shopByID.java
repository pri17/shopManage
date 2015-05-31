package com.origi.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.origi.dbConn.DB;
import com.origi.model.shop;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class shopByID extends HttpServlet{
	protected void doGet(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    this.doPost(request, response);
		  }
	
	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		 	response.setContentType("text/xml");
		    response.setContentType("text/html;charset=utf-8");
		    DB db=new DB();
			String id=request.getParameter("id");
			PrintWriter out=response.getWriter();
			JSONArray array = new JSONArray();	
			JSONObject member = null;
			member = new JSONObject();

			ArrayList al=db.getShopByID(id);
			Iterator it=al.iterator();
				while(it.hasNext()){
					shop t=(shop) it.next();
					String staff_name=db.getStaffName(t.getStaff_id());
					int level=db.getStaffLevel(t.getStaff_id());
					member.put("shop_name",t.getShop_name());
					member.put("shop_id", t.getShop_id());
					member.put("staff_id",t.getStaff_id());
					member.put("area", t.getDistrict());
					member.put("level", level);
					member.put("staff_name", staff_name);
					member.put("price", t.getPrice());
				    array.add(member);
			}
				String str=array.toString();
				PrintWriter pw = response.getWriter();
				pw.print(str);
				pw.close();
	}

}
