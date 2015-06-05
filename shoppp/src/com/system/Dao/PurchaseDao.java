package com.system.Dao;

import java.util.List;

import com.basic.Dao.BasicDao;
import com.system.model.*;




public interface PurchaseDao extends BasicDao<Purchase>{
	//对Purchase对象的所有操作
	/**
	 * 查找指定商店的进货情况
	 * @param shop 商店
	 * @return 该商店的进货信息表 
	 */
	List<Purchase> findByShop(Shop shop);
	
	
	
	/**
	 * 查找该商店按商品名查找的商品
	 * @param shop 商店
	 * @return 该商店的所有的商品
	 */
	List<Purchase> findGoodsByShop(Shop shop, String name);
	
	/**
	 * 查找指定商店、指定商品的进货情况
	 * @param shop 商店
	 * @param goods 商品
	 * @return 该商店的进货信息表 
	 */
	List<Purchase> findByGoods(Shop shop, Goods goods);
	
	/**
	 * 查找指定商店的按时间排序的进货情况
	 * @param shop 商店
	 * @return 该商店的进货信息表 
	 */
	List<Purchase> findOrderbyTime(Shop shop);
	
	/**
	 * 查找指定商店按每次进货数量排序的进货情况
	 * @param shop 商店
	 * @return 该商店的进货信息表 
	 */
	List<Purchase> findOrderbyNum(Shop shop);
	
	/**
	 * 查找指定商店按不同商品类别的进货情况
	 * @param shop 商店
	 * @param type 商品类型
	 * @return 该商店的进货信息表 
	 */
	List<Purchase> findByType(Shop shop, Type type);
	
	/**
	 * 查找指定商店不同商品类别的商品库存情况
	 * @param shop 商店
	 * @return 该商店的进货信息表 
	 */
	List<Purchase> findGoodsByType(Shop shop, Type type);
	
	/**
	 * 查找该商店某位员工负责的进货单
	 * @param shop 商店
	 * @param staff 员工
	 * @return 该商店的进货信息表 
	 */
	List<Purchase> findGoodsByStaff(Shop shop, Staff staff);
	
	/**
	 * 查找该商店某位员工负责的进货单
	 * @param shop 商店
	 * @param goods 商品
	 * @param num 进货单数目
	 * @return 该商店该商品的进货信息表 
	 */
	List<Purchase> findGoodsPurchases(Shop shop, Goods goods, int num);

	/**
	 * 查找商店某商品的某年总成本
	 * @param shop 商店
	 * @param goods 商品
	 * @return 商店该商品的销量 
	 */
	double findGoodsPurchasesPriceByYear(Shop shop, Goods goods, String year);
	
	/**
	 * 查找商店的某年总成本
	 * @param shop 商店
	 * @return 商店的销量 
	 */
	double findPurchasesPriceByYear(Shop shop, String year);
	
	/**
	 * 查找商店的总成本
	 * @param shop 商店
	 * @return 商店的销量 
	 */
	double findPurchasePirce(Shop shop);
}
