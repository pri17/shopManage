package com.zm.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.zm.db.DB;
import com.zm.model.Staff;

public class saveSale  extends HttpServlet {
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
				int id = Integer.parseInt(request.getParameter("id"));
				double price = Double.parseDouble(request.getParameter("price"));
				int num = Integer.parseInt(request.getParameter("num"));
				if(db.GoodsExist(id)){
					db.saveSale(id, price, num, user);
					try {
						
						response.sendRedirect("../seller/homePage.jsp?error=no");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}	
				else{
					try {
						response.sendRedirect("../seller/homePage.jsp?error=yes");
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}catch(Exception e){
				try {
					response.sendRedirect("../seller/homePage.jsp?IOerror=yes");
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
			
		}
	}
}
