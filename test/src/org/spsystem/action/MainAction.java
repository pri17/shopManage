package org.spsystem.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.spsystem.vo.PurchaseBean;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class MainAction extends ActionSupport{
	public String execute() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();
		int id = Integer.valueOf(request.getParameter("id"));
		ActionContext ctx = ActionContext.getContext();
		ctx.getSession().put("shopId", id);
		return SUCCESS;
	}

}
