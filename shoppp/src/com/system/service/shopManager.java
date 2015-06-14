package com.system.service;

import java.util.List;

import com.system.model.Shop;


public interface shopManager {
	/**
	 * 获取商店全部信息
	 * return 商店全部信息
	 */
	List<Shop> getAll();
	/**
	 * 通过id获取商店信息
	 * @param shopId 商店号
	 * return 该商店全部信息
	 */
	Shop getShop(int shopId);

	
}
