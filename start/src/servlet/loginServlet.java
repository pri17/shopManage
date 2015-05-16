package servlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import model.Staff;
import db.DB;
public class loginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=new String(request.getParameter("username").getBytes("ISO-8859-1"),"UTF-8");
		String password=new String(request.getParameter("password").getBytes("ISO-8859-1"),"UTF-8");
		DB db=new DB();
		HttpSession session=request.getSession();
		Staff user=(Staff)session.getAttribute("user");
		
			user=db.checkUser(username,password);
		
		session.setAttribute("user", user);
		if(user!=null){
			int level=user.getStaff_level();
			//System.out.print(level);
			session.setAttribute("level",level);
			if(level == 1)
				response.sendRedirect("/shoppp/");
			else if(level ==2)
				response.sendRedirect("/test/main?id="+user.getShop_id());
			else if(user.getStaff_level()==3)
				response.sendRedirect("../goods/homePage.jsp");
			else if(user.getStaff_level()==4)
				response.sendRedirect("../seller/homePage.jsp");
		}
		else{
			response.sendRedirect("../index.jsp");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
