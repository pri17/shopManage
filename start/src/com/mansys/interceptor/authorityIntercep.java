package com.mansys.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class authorityIntercep extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//ȡ��������ص�ActionContextʵ��
		ActionContext context=arg0.getInvocationContext();
		Map session=context.getSession();
		//ȡ��Session����
		String user=(String)session.get("user");
		if(user!=null ){
			return arg0.invoke();
		}
		context.put("tip", "���¼");
		return Action.LOGIN;
	}

}
