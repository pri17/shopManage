//��ȡ���ݿ��е�purchase����Ϣ
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
import com.origi.model.purchase;
import com.origi.model.sale;

public class purchaseList extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out=response.getWriter();
			DB db=new DB();
			ArrayList  al=db.getPurchaseInfo();
			Iterator it=al.iterator();
			out.print("<table border='3px' id='serTable'>");
			out.print("<tr id='tableTr'><B><th>����ID</th><th>��Ʒ��</th><th>��ƷID</th><th>�̵�</th><th>�̵�ID</th>"
					+ "<th>�̵����Ա</th><th>�̵������ID</th><th>��������</th>"
					+ "<th>����</th><th>������Ŀ</th></B><th><font color='orange'>����</font></th></tr>");
			while(it.hasNext()){
				purchase s=(purchase)it.next();	
				int staff_id=s.getStaff_id();//�����ݿ��и���id��ȡ����Ա����
				int goods_id=s.getGoods_id();//�����ݿ��и���id��ȡ��Ʒ����
				int shop_id=s.getShop_id();//�����ݿ��и���id��ȡ�̵�����
				String staff_name=db.getStaffName(staff_id);
				String goods_name=db.getGoodsByID1(goods_id);
				String shop_name=db.getShopName(shop_id);
				//out.print("0999"+shop_name);
				out.print("<tr><td>"+s.getPurchase_id()+"</td><td>"+goods_name+"</td><td>"+goods_id+"</td><td>"+shop_name+"</td><td>"+s.getShop_id()+"</td><td>"
						+staff_name+"</td><td>"+s.getStaff_id()+"</td><td>"+s.getPurchase_time()+"</td><td>"
						+s.getPurchase_price()+"</td><td>"+s.getPurchase_num()+"</td><td><a href='delPurchase?id="+s.getPurchase_id()+"'>ɾ��</a></td></tr>");
			}
			out.print("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}

}
