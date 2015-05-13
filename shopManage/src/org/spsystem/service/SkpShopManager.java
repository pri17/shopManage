package org.spsystem.service;

import java.util.List;

import org.spsystem.domain.Shop;
import org.spsystem.vo.GoodsInfBean;

public interface SkpShopManager {
	/*
	 * 获取商店全部信息
	 * @param shopId 商店号
	 * return 该商店全部信息
	 */
	Shop getShop(int shopId);
	
	/*
	 * 获取商店售货利润值
	 * @param shop 商店
	 * return 该商店利润值
	 */
	double getProfit(Shop shop);
	
	/*
	 * 获取商店销量最高的5件商品
	 * @param shop 商店
	 * return 该商店销量最高5件商品的信息
	 */
	List<GoodsInfBean> getTopGoods(Shop shop);
	
	/*
	 * 获取商店盈利最高的5件商品
	 * @param shop 商店
	 * return 该商店盈利最高的5件商品的信息
	 */
	List<GoodsInfBean> getHotGoods(Shop shop);
	
	/**
	 * 店主查看本店本月不同类别的销量
	 * @param shop 商店
	 * @return 结果的的json数据
	 */
	String getGoodsTypeInf(Shop shop);
	
	/**
	 * 店主查看本店本月不同类别的销量
	 * @param shop 商店
	 * @return 结果的的json数据
	 */
	String getTypeInf(Shop shop);
}
