package org.spsystem.service;

import java.util.List;

import org.spsystem.vo.GoodsBean;

public interface SkpGoodsManager {
	/**
	 * 店主查看本店所有的商品
	 * @param shopId 商店ID
	 * @return 该商店所有的商品的商品信息
	 */
	List<GoodsBean> getAllGoods( int shopId );
	
	/**
	 * 店主按商品名查找本店商品
	 * @param shopId 商店ID
	 * @param goodsName 商品名
	 * @return 该商店含有该商品名的所有商品信息
	 */
	List<GoodsBean> getGoodsByName( int shopId, String goodsName );
	
	/**
	 * 店主按商品号查找本店商品
	 * @param shopId 商店ID
	 * @param goodsId 商品号
	 * @return 该商店该商品名的商品信息
	 */
	List<GoodsBean> getGoodsById( int shopId, int goodsId );
	
	/**
	 * 店主按类型查找本店商品
	 * @param data 原有数据
	 * @param typeId 类型ID
	 * @return 该商店该类别的所有商品信息
	 */
	List<GoodsBean> getGoodsByType( List<GoodsBean> data, int typeId );
	
	/**
	 * 店主查看本店某商品的10条近期的进货记录
	 * @param shopId 商店ID
	 * @param goodsId 商品名
	 * @return 该进货记录的json数据
	 */
	String getGoodsPurchase(  int shopId, int goodsId );
	
	/**
	 * 店主查看本店某商品的10条近期的售货记录
	 * @param shopId 商店ID
	 * @param goodsId 商品名
	 * @return 该售货记录的json数据
	 */
	String getGoodsSalas(  int shopId, int goodsId );
	
	/**
	 * 店主查看本店某商品销售比例
	 * @param shopId 商店ID
	 * @param goodsId 商品名
	 * @return 销售比例的json数据
	 */
	String getGoodsSaleScale( int shopId, int goodsId );
	
	/**
	 * 店主查看本店某商品盈利比例
	 * @param shopId 商店ID
	 * @param goodsId 商品名
	 * @return 盈利比例的json数据
	 */
	String getGoodsProfitScale( int shopId, int goodsId );
	
	/**
	 * 店主查看本店某商品销售情况
	 * @param shopId 商店ID
	 * @param goodsId 商品名
	 * @return 销售情况的json数据
	 * @throws Exception 
	 */
	String getGoodsSaleInf( int shopId, int goodsId ) throws Exception;
	
	/**
	 * 店主查看本店某商品销量与售价
	 * @param shopId 商店ID
	 * @param goodsId 商品名
	 * @return 结果的的json数据
	 */
	String getGoodsSalePriceNum( int shopId, int goodsId );
}
