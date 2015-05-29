package com.system.Dao.impl;

import java.util.List;

import com.basic.Dao.impl.BasicDaoHibernate;
import com.system.model.Goods;
import com.system.model.Shop;
import com.system.Dao.ShopDao;

public class ShopDaoHibernate extends BasicDaoHibernate<Shop> implements ShopDao {

	@Override
	public List<Shop> findByShopName(String name) {
		return find("from Shop where name like %"+name+"%");
	}

	@Override
	public List<Shop> findByShopId(int id) {
		return find("from Shop where id="+id);
	}

	@Override
	public List<Shop> findByArea(String area) {
		return find("from Shop where district like %"+area+"%");
	}

	@Override
	public List<Shop> findByPrice(double p1, double p2) {
		return find("from Shop where price between "+p1+" and "+p2);
	}

}
