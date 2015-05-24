//获取数据库中的sale表信息
package servlet;

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




import model.sale;
import dbConn.DB;

public class salesList extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8"); 
		PrintWriter out=response.getWriter();
			DB db=new DB();
			ArrayList  al=db.getSalesInfo();
			Iterator it=al.iterator();
			out.print("<table border='3px' id='serTable'>");
			out.print("<tr id='tableTr'><B><th>销售列表ID</th><th>商品名</th><th>商品ID</th><th>商店</th><th>商店ID</th>"
					+ "<th>商店管理员</th><th>商店管理者ID</th><th>销售日期</th>"
					+ "<th>售价</th><th>销售数目</th></B><th><font color='orange'>操作</font></th></tr>");
			while(it.hasNext()){
				sale s=(sale)it.next();	
				int staff_id=s.getStaff_id();//从数据库中根据id获取管理员名字
				int goods_id=s.getGoods_id();//从数据库中根据id获取商品名字
				int shop_id=s.getShop_id();//从数据库中根据id获取商店名字
				String staff_name=db.getStaffName(staff_id);
				String goods_name=db.getGoodsByID1(goods_id);
				String shop_name=db.getShopName(shop_id);
				//out.print("0999"+shop_name);
				out.print("<tr><td>"+s.getSale_id()+"</td><td>"+goods_name+"</td><td>"+goods_id+"</td><td>"+shop_name+"</td><td>"+s.getShop_id()+"</td><td>"
						+staff_name+"</td><td>"+s.getStaff_id()+"</td><td>"+s.getSale_time()+"</td><td>"
						+s.getSale_price()+"</td><td>"+s.getSale_num()+"</td><td><a href='delSales?id="+s.getSale_id()+"'>删除</a></td></tr>");
			}
			out.print("</table>");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request,response);
	}

}
