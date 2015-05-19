package com.mansys.interceptor;

import java.util.Map;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class authorityIntercep extends AbstractInterceptor{

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		//取得请求相关的ActionContext实例
		ActionContext context=arg0.getInvocationContext();
		Map session=context.getSession();
		//取出Session属性
		String user=(String)session.get("user");
		if(user!=null ){
			return arg0.invoke();
		}
		context.put("tip", "请登录");
		return Action.LOGIN;
	}

}
