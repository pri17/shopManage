package com.origi.search;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.origi.dbConn.DB;
import com.origi.model.goods;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class goodsByType extends HttpServlet{

	protected void doGet(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    this.doPost(request, response);
		  }
	
	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/xml");
		    response.setContentType("text/html;charset=utf-8");
		    DB db=new DB();
			String type=request.getParameter("type");
			PrintWriter out=response.getWriter();
			JSONArray array = new JSONArray();	
			JSONObject member = null;
			member = new JSONObject();

			ArrayList al=db.getGoodsByType(type);
			Iterator it=al.iterator();
				while(it.hasNext()){
					goods t=(goods) it.next();
					member.put("name",t.getGoods_name());
					member.put("id", t.getGoods_id());
					member.put("type",db.getTypeName(t.getType_id()));//在用数据库的方法获取完整的种类名字
				    array.add(member);
			}
				String str=array.toString();
				PrintWriter pw = response.getWriter();
				pw.print(str);
				pw.close();
	}

}
