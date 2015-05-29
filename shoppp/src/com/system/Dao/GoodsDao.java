package com.system.Dao;

import java.util.List;
import com.system.model.Goods;
import com.system.model.Shop;

public interface GoodsDao {
	//对Goods对象的所有操作
	/**
	 * 按商品名查找商品（模糊）
	 * @param goodsName 商品名
	 * @return 商品信息
	 */
	List<Goods> findByGoodsName(String goodsName);
	/**
	 * 通过商品id号来查找
	 * @param int id
	 * @return 该商店基本信息
	 */
	List<Goods> findGoodsById(int id);
	/**
	 * 通过种类名字来模糊查找
	 * @param string type_name
	 * @return 该商店基本信息
	 */
	List<Goods>findGoodsByType(String type_name);
	/**
	 * 查找 '指定商店 '的拥有的所有商品
	 * @param shop 商店
	 * @return 该商店的所有的商品
	 */
	List<Goods> findGoodsByShop(Shop shop);
	
	/**
	 * 查找  '指定商店 '的拥有的某个商品的售货信息
	 * @param shop 商店
	 * @param goods 商品
	 * @return 该商店该商品的售货信息（销量、收入、售货单数目）
	 */
	List<Object[]> findSaleInfByGoods(Shop shop, Goods goods);
	
	/**
	 * 查找 '指定商店 '的拥有的某个商品的进货信息
	 * @param shop 商店
	 * @param goods 商品
	 * @return 该商店该商品的进货信息（库存、成本、进货单数目）
	 */
	List<Object[]> findPurchaseInfByGoods(Shop shop, Goods goods);
	
	/**
	 * 查找 '指定商店 '的拥有的商品的售货信息
	 * @param shop 商店
	 * @return 该商店所有商品的售货信息（销量、收入、售货单数目）
	 */
	List<Object[]> findSaleInfByGoods(Shop shop);
	
	/**
	 * 查找 '指定商店 '的拥有的商品的进货信息
	 * @param shop 商店
	 * @return 该商店所有商品的进货信息（库存、成本、进货单数目）
	 */
	List<Object[]> findPurchaseInfByGoods(Shop shop);
	
	/**
	 * 查找 '指定商店 '的与商品名有关的商品信息
	 * @param shop 商店
	 * @param goodsName 商品名
	 * @return 该商店模糊查找的所有商品
	 */
	List<Goods> findGoodsByName(Shop shop, String goodsName);

	/**
	 * 查找 '指定商店 '的与商品名有关的进货信息
	 * @param shop 商店
	 * @param goodsName 商品名
	 * @return 该商店所有商品的进货信息（库存、成本、进货单数目）
	 */
	List<Object[]> findPurchaseInfByName(Shop shop, String goodsName);

	/**
	 * 查找 '指定商店 '的与商品名有关的销售信息
	 * @param shop 商店
	 * @param goodsName 商品名
	 * @return 该商店所有商品的售货信息（销量、收入、售货单数目）
	 */
	List<Object[]> findSaleInfByName(Shop shop, String goodsName);

}