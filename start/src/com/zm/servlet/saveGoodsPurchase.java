package com.zm.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zm.db.DB;
import com.zm.model.Staff;

public class saveGoodsPurchase extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		HttpSession session=request.getSession();
		Staff user=(Staff)session.getAttribute("user");
		if(user == null){
			try {
				response.sendRedirect("../index.jsp");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else{
			DB db=new DB();
			try{
				double price = Double.parseDouble(request.getParameter("price"));
				double inprice = Double.parseDouble(request.getParameter("inprice"));
				int num = Integer.parseInt(request.getParameter("num"));
				int type = Integer.parseInt(request.getParameter("type"));
				String name = request.getParameter("name");
				int id = db.saveGoods(name, type);
				
					db.savePurchase(id, price, num, user, inprice);
					try {
						
						response.sendRedirect("../goods/homePage.jsp?error=no");
					} catch (IOException e) {
						e.printStackTrace();
					}	
			
			}catch(Exception e){
				try {
					response.sendRedirect("../goods/homePage.jsp?IOerror=yes");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
			
		}
	}
}
