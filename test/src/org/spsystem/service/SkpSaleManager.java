package org.spsystem.service;

import java.util.List;

import org.spsystem.vo.SaleBean;

public interface SkpSaleManager {
	/**
	 * 店主查看本店所有的售货单
	 * @param shopId 商店ID
	 * @return 该商店所有的售货单
	 */
	List<SaleBean> getAllSale(int shopId);
	
	/**
	 * 店主按商品名查找售货单
	 * @param shopId 商店ID
	 * @param goodsName 商品名
	 * @return 该商店所有的售货单
	 */
	List<SaleBean> getSaleByGoods(int shopId, String goodsName);
	
	/**
	 * 店主按商品编号查找售货单
	 * @param shopId 商店ID
	 * @param goodsId 商品号
	 * @return 该商店所有的售货单
	 */
	List<SaleBean> getSaleByGoods(int shopId, int goodsId);
	
	/**
	 * 店主按员工名查找售货单
	 * @param shopId 商店ID
	 * @param staffId 员工号
	 * @return 该商店所有的售货单
	 */
	List<SaleBean> getSaleByStaff(int shopId, int staffId);
	
	/**
	 * 店主将原有的数据按所需类型分类
	 * @param data 要挑选的原有的所有数据
	 * @param typeId 类型号
	 * @return 该商店符合要求的售货单
	 */
	List<SaleBean> getSaleByType(List<SaleBean> data, int typeId);
	
	/**
	 * 店主将删除指定订单号的售货单
	 * @param id 要删除的售货单ID
	 * @return null
	 */
	void deleteSale(int id);
	
	/**
	 * 店主保存更新后的售货单
	 * @param p 更改后的售货单
	 * @return null
	 */
	void changeSale(SaleBean p);
}
