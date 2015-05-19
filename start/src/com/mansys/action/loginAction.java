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
            Staff user = dao.isValidAdmin(username, password);//��username��password���ݵ�dao�㽻��hibernate�ж�
            if(user!=null){
                session.put("user", user);//����½�ɹ��򽫸�user��¼��session��
                return SUCCESS;
            }else{
                addActionError("��û�й���Ȩ��");
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
