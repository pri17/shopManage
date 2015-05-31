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

public class goodsByName extends HttpServlet{

	protected void doGet(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    this.doPost(request, response);
		  }
	
	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/xml");
		    response.setContentType("text/html;charset=utf-8");
		    DB db=new DB();
			String name=request.getParameter("name");
			PrintWriter out=response.getWriter();
			JSONArray array = new JSONArray();	
			JSONObject member = null;
			member = new JSONObject();

			ArrayList al=db.getGoodsByName(name);
			Iterator it=al.iterator();
				while(it.hasNext()){
					goods t=(goods) it.next();
					String type=db.getTypeName(t.getType_id());
					member.put("name",t.getGoods_name());
					member.put("id", t.getGoods_id());
					member.put("type",type);
				    array.add(member);
			}
				String str=array.toString();
				PrintWriter pw = response.getWriter();
				pw.print(str);
				pw.close();
	}

}
