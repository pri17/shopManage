package com.system.Dao;

import java.util.List;

import com.system.model.Shop;

public interface ShopDao {
	//对Shop对象的所有操作
	/**
	* 按商店名查找商店（模糊）
	* @param name 商店名
	* @return 商店信息
	*/
	List<Shop> findByShopName(String name);
	/**
	* 按商店id查找商店
	* @param id 商店id
	* @return 商店信息
	*/
	List<Shop> findByShopId(int id);
	/**
	* 按地区查找商店（模糊）
	* @param area 地区名
	* @return 商店信息
	*/
	List<Shop> findByArea(String area);
	/**
	* 按商店价值查找商店（范围）
	* @param p1 最低价
	* @param p2 最高价
	* @return 商店信息
	*/
	List<Shop> findByPrice(double p1,double p2);
}
