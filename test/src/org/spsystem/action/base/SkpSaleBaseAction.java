package org.spsystem.action.base;

import org.spsystem.service.SkpPurchaseManager;
import org.spsystem.service.SkpSaleManager;

import com.opensymphony.xwork2.ActionSupport;

public class SkpSaleBaseAction extends ActionSupport{
	protected SkpSaleManager skp;

	public SkpSaleManager getSkp() {
		return skp;
	}

	public void setSkp(SkpSaleManager skp) {
		this.skp = skp;
	}
	public void setSkpSaleManager(SkpSaleManager skp){
		this.skp = skp;
	}
}
