package org.spsystem.action.base;

import org.spsystem.service.SkpShopManager;

import com.opensymphony.xwork2.ActionSupport;

public class SkpShopBaseAction extends ActionSupport{
	protected SkpShopManager skp;
	public SkpShopManager getSkp() {
		return skp;
	}
	public void setSkp(SkpShopManager skp) {
		this.skp = skp;
	}
	public void setSkpShopManager(SkpShopManager skp) {
		this.skp = skp;
	}
}
