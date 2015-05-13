package org.spsystem.action.base;

import org.spsystem.service.SkpGoodsManager;

import com.opensymphony.xwork2.ActionSupport;

public class SkpGoodsBaseAction extends ActionSupport{
	protected SkpGoodsManager skp;

	public SkpGoodsManager getSkp() {
		return skp;
	}

	public void setSkp(SkpGoodsManager skp) {
		this.skp = skp;
	}
	public void setSkpGoodsManager(SkpGoodsManager skp){
		this.skp = skp;
	}
}
