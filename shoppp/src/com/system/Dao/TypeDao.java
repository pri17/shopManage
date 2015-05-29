package com.system.Dao;

import java.util.List;

import com.system.model.Goods;


public interface TypeDao {
	//对Type对象的所有操作
	/**
	 * 按种类名查找商品（模糊）
	 * @param name 种类名
	 * @return 商品信息
	 */
	List<Goods> findByTypeName(String goodsName);
}