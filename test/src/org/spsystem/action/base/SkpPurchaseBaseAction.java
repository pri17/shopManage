package org.spsystem.action.base;

import org.spsystem.service.SkpPurchaseManager;

import com.opensymphony.xwork2.ActionSupport;

public class SkpPurchaseBaseAction extends ActionSupport{
	protected SkpPurchaseManager skp;
	public SkpPurchaseManager getSkp() {
		return skp;
	}
	public void setSkp(SkpPurchaseManager skp) {
		this.skp = skp;
	}
	public void setSkpPurchaseManager(SkpPurchaseManager skp){
		this.skp = skp;
	}
}
