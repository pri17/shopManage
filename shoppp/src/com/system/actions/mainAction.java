package com.system.actions;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class mainAction extends ActionSupport{
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		int level= Integer.valueOf(request.getParameter("level"));
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("level", level);
		return SUCCESS;
	}
}
