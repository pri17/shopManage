//获取数据库中的staff表信息
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
import com.origi.model.staff;

public class staffList extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out=response.getWriter();
			DB db=new DB();
			ArrayList  al=db.getStaffInfo();
			Iterator it=al.iterator();
			out.print("<table border='3px' id='serTable'>");
			out.print("<tr id='tableTr'><B><th>管理者ID</th><th>管理者姓名</th><th>权限等级</th></B></tr>");
			while(it.hasNext()){
				staff s=(staff)it.next();		
				out.print("<tr><td>"+s.getStaff_id()+"</td>"+"<td>"+s.getStaff_name()+"</td>"+"<td>"+s.getStaff_level()+"</td></tr>");
			}
			out.print("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}

}
