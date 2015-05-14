package org.spsystem.dao;

import java.util.List;

import org.common.dao.BaseDao;
import org.spsystem.domain.Goods;
import org.spsystem.domain.Shop;
import org.spsystem.vo.GoodsInfBean;

public interface GoodsDao extends BaseDao<Goods>{
	
	/**
	 * 按商品名查找商品
	 * @param goodsName 商品名
	 * @return 商品信息
	 */
	List<Goods> findByGoodsName(String goodsName);
	
	/**
	 * 查找指定商店的拥有的所有商品
	 * @param shop 商店
	 * @return 该商店的所有的商品
	 */
	List<Goods> findGoodsByShop(Shop shop);
	
	/**
	 * 查找指定商店的拥有的某个商品的售货信息
	 * @param shop 商店
	 * @param goods 商品
	 * @return 该商店该商品的售货信息（销量、收入、售货单数目）
	 */
	List<Object[]> findSaleInfByGoods(Shop shop, Goods goods);
	
	/**
	 * 查找指定商店的拥有的某个商品的进货信息
	 * @param shop 商店
	 * @param goods 商品
	 * @return 该商店该商品的进货信息（库存、成本、进货单数目）
	 */
	List<Object[]> findPurchaseInfByGoods(Shop shop, Goods goods);
	
	/**
	 * 查找指定商店的拥有的商品的售货信息
	 * @param shop 商店
	 * @return 该商店所有商品的售货信息（销量、收入、售货单数目）
	 */
	List<Object[]> findSaleInfByGoods(Shop shop);
	
	/**
	 * 查找指定商店的拥有的商品的进货信息
	 * @param shop 商店
	 * @return 该商店所有商品的进货信息（库存、成本、进货单数目）
	 */
	List<Object[]> findPurchaseInfByGoods(Shop shop);
	
	/**
	 * 查找指定商店的与商品名有关的商品信息
	 * @param shop 商店
	 * @param goodsName 商品名
	 * @return 该商店模糊查找的所有商品
	 */
	List<Goods> findGoodsByName(Shop shop, String goodsName);

	/**
	 * 查找指定商店的与商品名有关的进货信息
	 * @param shop 商店
	 * @param goodsName 商品名
	 * @return 该商店所有商品的进货信息（库存、成本、进货单数目）
	 */
	List<Object[]> findPurchaseInfByName(Shop shop, String goodsName);

	/**
	 * 查找指定商店的与商品名有关的销售信息
	 * @param shop 商店
	 * @param goodsName 商品名
	 * @return 该商店所有商品的售货信息（销量、收入、售货单数目）
	 */
	List<Object[]> findSaleInfByName(Shop shop, String goodsName);
	//////////////////////////////////////
	/////////////////////////////////////
	/**
	 * 通过商品id查找商品信息
	 * @param id id
	 * @return 该商品的信息
	 */
	List<Goods> findGoodsByid(int id);
	/**
	 * 通过种类名模糊查找商品信息
	 * @param String type_name
	 * @return 该商品的信息
	 */
	List<Goods> findGoodsByType(String type_name);
}
