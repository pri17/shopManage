//获取数据库中的shop表信息
package com.origi.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;






import com.origi.dbConn.DB;
import com.origi.model.shop;

public class shopsList extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out=response.getWriter();
			DB db=new DB();
			ArrayList  al=db.getShopInfo();
			Iterator it=al.iterator();
			out.print("<table border='3px' id='serTable'>");
			out.print("<tr id='tableTr'><B><th>商店ID</th><th>商店名</th><th>商店所在地</th><th>商店管理者ID</th>"
					+ "<th>商店管理者</th><th>管理者等级</th><th>商店总金额</th></B><th><font color='orange'>操作</font></th></tr>");
			while(it.hasNext()){
				shop s=(shop)it.next();	
				int staff_id=s.getStaff_id();//从数据库中根据id获取管理员名字
				String staff_name=db.getStaffName(staff_id);
				int staff_level=db.getStaffLevel(staff_id);//get staff level by if from db
				out.print("<tr><td>"+s.getShop_id()+"</td>"+"<td>"+s.getShop_name()+"</td>"+"<td>"+s.getDistrict()+"</td>"+"<td>"+s.getStaff_id()
						+"<td>"+staff_name+"</td>"+"<td>"+staff_level+"</td>"+"<td>"+s.getPrice()+"</td><td><a href='delShop?id="+s.getShop_id()+"'>删除</a></td></tr>");
			}
			out.print("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}

}
