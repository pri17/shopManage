package com.system.service.impl;

import java.util.List;

import com.system.Dao.GoodsDao;
import com.system.Dao.PurchaseDao;
import com.system.Dao.SaleDao;
import com.system.Dao.ShopDao;
import com.system.Dao.StaffDao;
import com.system.Dao.TypeDao;
import com.system.model.*;
import com.system.service.goodsManager;

public class goodsManagerImpl implements goodsManager{
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
	
	@Override
	public List<Goods> getAll(){
		return ( goodsDao).findAll(Goods.class);
	}
	@Override
	public Goods getGoodsById(int goodsId){
		Goods goods=(Goods) goodsDao.findGoodsById(goodsId);
		return goods;
	}
	@Override
	public List<Goods> getGoodsByname(String name){
		List<Goods> goods=goodsDao.findByGoodsName(name);
		return goods;
	}
	@Override
	public List<Goods> getGoodsByType(String typeName){
		List<Goods> goods=goodsDao.findGoodsByType(typeName);
		return goods;
	}
}
