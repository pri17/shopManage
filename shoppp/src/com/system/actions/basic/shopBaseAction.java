package com.system.actions.basic;

import com.opensymphony.xwork2.ActionSupport;
import com.system.service.shopManager;

public class shopBaseAction extends ActionSupport{
	protected shopManager sm;

	public shopManager getSm() {
		return sm;
	}

	public void setSm(shopManager sm) {
		this.sm = sm;
	}
	
}
