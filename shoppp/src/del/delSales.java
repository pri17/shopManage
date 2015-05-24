package del;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.goods;
import dbConn.DB;

public class delSales extends HttpServlet {
	public  void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException ,IOException{
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		DB db=new DB(); 
		db.delSales(id);
		response.sendRedirect("salesList.jsp");//商店注册之后跳转到登陆界面
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException ,IOException{
		doPost(request,response);
	}
}
