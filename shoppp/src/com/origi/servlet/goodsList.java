package com.origi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.origi.dbConn.DB;
import com.origi.model.goods;
import com.origi.model.shop;

public class goodsList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out=response.getWriter();
		DB db=new DB();
		ArrayList  al=db.getGoodsInfo();
		Iterator it=al.iterator();
		out.print("<table border='3px' id='serTable'>");
		out.print("<tr id='tableTr'><B><th>商品ID</th><th>商品名</th><th>所属种类</B>"
				+ "<th><font color='orange'>操作</font></th></tr>");
		while(it.hasNext()){
			goods g=(goods)it.next();	
			int type_id=g.getType_id();//从数据库中根据id获取种类名字
			String type=db.getTypeName(type_id);
			out.print("<tr><td>"+g.getGoods_id()+"</td><td>"+g.getGoods_name()+"</td><td>"+type+"</td>"
					+ "<td><a href='delGoods?id="+g.getGoods_id()+"'>删除</a></td></tr>");
		}
		out.print("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}
}
