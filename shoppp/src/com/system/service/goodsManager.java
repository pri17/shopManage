package com.system.service;

import com.system.model.*;

import java.util.List;

public interface goodsManager {
	/**
	 * 获取所有商品信息
	 * return 全部商品信息
	 */
	List<Goods> getAll();
	/**
	 * 通过id获取商品信息
	 * @param  goodsId 商品id
	 * return 指定的商品信息
	*/
	Goods getGoodsById(int goodsId);
	/**
	 * 通过name获取商品信息
	 * @param name 商品名字
	 * return 指定的商品信息
	*/
	List<Goods> getGoodsByname(String name);
	/**
	 * 通过种类名字获取商品信息
	 * @param typeName 种类名字
	 * return 指定的商品信息
	*/
	List<Goods> getGoodsByType(String typeName);
	
}
