package com.system.Dao.impl;

import java.util.List;

import com.basic.Dao.impl.BasicDaoHibernate;
import com.system.Dao.StaffDao;
import com.system.model.Goods;
import com.system.model.Shop;
import com.system.model.Staff;

public class StaffDaoHibernate extends BasicDaoHibernate<Staff> implements StaffDao{

	@Override
	public List<Staff> findSatffById(int id) {
		return (find("from Staff where staffId="+id));
	}

	@Override
	public List<Staff> findStaffByName(String name) {
		return (find("from Staff where staffName like %"+name+"%"));
	}

	@Override
	public List<Staff> findStaffByLevel(int level) {
		return (find("from Staff where staffLevel="+level));
	}

	@Override
	public List<Staff> findShopKeeper(Shop shop) {
		return find("from Staff where staffLevel=2 and shopId="+shop.getShopId());
	}

	@Override
	public List<Staff> findShopImporter(Shop shop) {
		return find("from Staff where staffLevel=3 and shopId="+shop.getShopId());
	}

	@Override
	public List<Staff> findShopExporter(Shop shop) {
		return find("from Staff where staffLevel=4 and shopId="+shop.getShopId());
	}

}
