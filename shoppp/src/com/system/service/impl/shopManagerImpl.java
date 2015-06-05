package com.system.service.impl;

import java.util.List;

import com.system.Dao.*;
import com.system.model.Shop;
import com.system.service.shopManager;

public class shopManagerImpl implements shopManager{
	private PurchaseDao purDao;
	private ShopDao shopDao;
	private GoodsDao goodsDao;
	private TypeDao typeDao;
	private StaffDao staffDao;
	private SaleDao saleDao;
	
	public PurchaseDao getPurDao() {
		return purDao;
	}
	public void setPurDao(PurchaseDao purDao) {
		this.purDao = purDao;
	}
	public ShopDao getShopDao() {
		return shopDao;
	}
	public void setShopDao(ShopDao shopDao) {
		this.shopDao = shopDao;
	}
	public GoodsDao getGoodsDao() {
		return goodsDao;
	}
	public void setGoodsDao(GoodsDao goodsDao) {
		this.goodsDao = goodsDao;
	}
	public TypeDao getTypeDao() {
		return typeDao;
	}
	public void setTypeDao(TypeDao typeDao) {
		this.typeDao = typeDao;
	}
	public StaffDao getStaffDao() {
		return staffDao;
	}
	public void setStaffDao(StaffDao staffDao) {
		this.staffDao = staffDao;
	}
	public SaleDao getSaleDao() {
		return saleDao;
	}
	public void setSaleDao(SaleDao saleDao) {
		this.saleDao = saleDao;
	}
	
	public List<Shop> getAll(){
		return shopDao.findAll(com.system.model.Shop.class);
	}
}
