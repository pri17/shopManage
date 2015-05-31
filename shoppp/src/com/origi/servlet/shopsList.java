//��ȡ���ݿ��е�shop����Ϣ
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
			out.print("<tr id='tableTr'><B><th>�̵�ID</th><th>�̵���</th><th>�̵����ڵ�</th><th>�̵������ID</th>"
					+ "<th>�̵������</th><th>�����ߵȼ�</th><th>�̵��ܽ��</th></B><th><font color='orange'>����</font></th></tr>");
			while(it.hasNext()){
				shop s=(shop)it.next();	
				int staff_id=s.getStaff_id();//�����ݿ��и���id��ȡ����Ա����
				String staff_name=db.getStaffName(staff_id);
				int staff_level=db.getStaffLevel(staff_id);//get staff level by if from db
				out.print("<tr><td>"+s.getShop_id()+"</td>"+"<td>"+s.getShop_name()+"</td>"+"<td>"+s.getDistrict()+"</td>"+"<td>"+s.getStaff_id()
						+"<td>"+staff_name+"</td>"+"<td>"+staff_level+"</td>"+"<td>"+s.getPrice()+"</td><td><a href='delShop?id="+s.getShop_id()+"'>ɾ��</a></td></tr>");
			}
			out.print("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}

}
