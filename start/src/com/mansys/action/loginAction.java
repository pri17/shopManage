package com.mansys.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionSupport;
import com.zm.model.Staff;

public class loginAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
    Staff dao = new Staff();
    private String username;
    private String password;
    private Map<String,Object> session;
    
    public String execute(){
            Staff user = dao.isValidAdmin(username, password);//将username和password传递到dao层交个hibernate判断
            if(user!=null){
                session.put("user", user);//若登陆成功则将该user记录在session中
                return SUCCESS;
            }else{
                addActionError("你没有管理权限");
                return INPUT;
            }
    }
    
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Map getSession() {
        return session;
    }

    public void setSession(Map session) {
        this.session = session;
    }

}
