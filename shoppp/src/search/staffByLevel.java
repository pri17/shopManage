package search;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.staff;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import dbConn.DB;

public class staffByLevel extends HttpServlet{
	protected void doGet(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    this.doPost(request, response);
		  }
	
	protected void doPost(HttpServletRequest request,
		      HttpServletResponse response) throws ServletException, IOException {
		    response.setContentType("text/xml");
		    response.setContentType("text/html;charset=utf-8");
		    DB db=new DB();
			int level=Integer.parseInt(request.getParameter("level"));
			PrintWriter out=response.getWriter();
			JSONArray array = new JSONArray();	
			JSONObject member = null;
			member = new JSONObject();

			ArrayList al=db.getStaffByLevel(level);
			Iterator it=al.iterator();
				while(it.hasNext()){
					staff t=(staff) it.next();
					member.put("name",t.getStaff_name());
					member.put("id", t.getStaff_id());
					member.put("level",t.getStaff_level());
				    array.add(member);
			}

				String str=array.toString();
				PrintWriter pw = response.getWriter();
				pw.print(str);
				pw.close();
	}

}
