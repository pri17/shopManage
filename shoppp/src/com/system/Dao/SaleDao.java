package com.system.Dao;

import java.util.List;

import com.basic.Dao.BasicDao;
import com.system.model.*;

public interface SaleDao extends BasicDao<Sale>{
	/**
	 * 查找指定商店的销售情况
	 * @param shop 商店
	 * @return 该商店的销售信息表 
	 */
	List<Sale> findByShop(Shop shop);
	
	/**
	 * 查找指定商店指定商品的销售情况
	 * @param shop 商店
	 * @param goods 商品
	 * @return 该商店的销售信息表 
	 */
	List<Sale> findByGoods(Shop shop, Goods goods);
	
	/**
	 * 查找指定售货员的销售情况
	 * @param shop 商店
	 * @param staff 售货员
	 * @return 该商店的销售信息表 
	 */
	List<Sale> findByStaff(Shop shop, Staff staff);
	
	
	
	/**
	 * 查找指定商店指定商品某天的销售情况
	 * @param shop 商店
	 * @param goods 商品
	 * @param date 日期
	 * @return 该商店的销售信息表 
	 */
	List<Sale> findGoodsNumByDate(Shop shop, Goods goods, String Date);
	
	/**
	 * 查找指定商店指定商品某月的销售情况
	 * @param shop 商店
	 * @param goods 商品
	 * @param month 月份
	 * @return 该商店的销售信息表 
	 */
	List<Sale> findGoodsNumByMonth(Shop shop, Goods goods, String month);
	
	/**
	 * 查找指定商店指定商品某年的销售情况
	 * @param shop 商店
	 * @param goods 商品
	 * @param year 年
	 * @return 该商店的销售信息表 
	 */
	List<Sale> findGoodsNumByYear(Shop shop, Goods goods, String year);
	
	/**
	 * 按Date查找某商品的销售情况
	 * @param shop 商店
	 * @param goods 商品
	 * @return 该商店的销售信息（Date, SUM(num), SUM(price)）
	 */
	List findGoodsByDate(Shop shop, Goods goods);
	
	/**
	 * 查找该商店某位员工负责的售货单
	 * @param shop 商店
	 * @param goods 商品
	 * @param num 售货单数目
	 * @return 该商店该商品的售货信息表 
	 */
	List<Sale> findGoodsSales(Shop shop, Goods goods, int num);
	
	/**
	 * 查找商店某商品的某年总销量
	 * @param shop 商店
	 * @param goods 商品
	 * @return 商店该商品的销量 
	 */
	long findGoodsSalesNumByYear(Shop shop, Goods goods, String year);
	
	/**
	 * 查找商店的某年总销量
	 * @param shop 商店
	 * @return 商店的销量 
	 */
	long findSalesNumByYear(Shop shop, String year);
	
	/**
	 * 查找商店某商品的某年总收入
	 * @param shop 商店
	 * @param goods 商品
	 * @return 商店该商品的销量 
	 */
	double findGoodsSalesPriceByYear(Shop shop, Goods goods, String year);
	
	/**
	 * 查找商店的某年总收入
	 * @param shop 商店
	 * @return 商店的销量 
	 */
	double findSalesPriceByYear(Shop shop, String year);
	
	/**
	 * 查找商店的总收入
	 * @param shop 商店
	 * @return 商店的销量 
	 */
	double findSalesPrice(Shop shop);
	
	/**
	 * 查找商店的某年某商品的售价与销量关系
	 * @param shop 商店
	 * @param goods 商品
	 * @return 商店商品的销量和售价关系 
	 */
	List<Object[]> findGoodsSalesPriceNum(Shop shop, Goods goods);
	
	/**
	 * 查找商店的最近一周的销量最高的5个商品
	 * @param shop 商店
	 * @param start 本周周一
	 * @return 商店销量最高5个商品的销售单 
	 */
	List<Object[]> findTopGoodsNum(Shop shop, String start);
	
	/**
	 * 查找商店的某年某月商品类别的销量	 
	 * @param shop 商店
	 * @param ym 年月
	 * @return 商店销量最高5个商品的销售单 
	 */
	List<Object[]> findGoodsTypeNum(Shop shop, String ym);
	
	/**
	 * 查找商店的最近一周的盈利最高的5个商品
	 * @param shop 商店
	 * @param start 本周周一
	 * @return 商店销量最高5个商品的销售单 
	 */
	List<Object[]> findHotGoodsPrice(Shop shop, String start);
	
	/**
	 * 查找商店的某年某月某类商品的销量	 
	 * @param shop 商店
	 * @param ym 年月
	 * @param type类别
	 * @return 商店销量最高5个商品的销售单 
	 */
	List<Object[]> findGoodsNumType(Shop shop, String ym, Type type);
	
	/**
	 * 查找商店的某年某月商品的销量	 
	 * @param shop 商店
	 * @param ym 年月
	 * @param type类别
	 * @return 商店销量最高5个商品的销售单 
	 */
	List<Object[]> findGoodsNum(Shop shop, String ym);
}
