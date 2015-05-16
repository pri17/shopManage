package org.spsystem.service;

import java.util.List;

import org.spsystem.vo.PurchaseBean;

public interface SkpPurchaseManager {
	/**
	 * 店主查看本店所有的进货单
	 * @param shopId 商店ID
	 * @return 该商店所有的进货单
	 */
	List<PurchaseBean> getAllPurchase(int shopId);
	
	/**
	 * 店主查看本店所有的进货单按时间排序
	 * @param shopId 商店ID
	 * @return 该商店所有的进货单
	 */
	List<PurchaseBean> getAllPurchaseOrderbyTime(int shopId);
	
	/**
	 * 店主查看本店所有的进货单按商品的进货量排序
	 * @param shopId 商店ID
	 * @return 该商店所有的进货单
	 */
	List<PurchaseBean> getAllPurchaseOrderbyNum(int shopId);
	
	/**
	 * 店主查看本店指定类型的进货单
	 * @param shopId 商店ID
	 * @param typeId 商品类型ID
	 * @return 该商店所有的进货单
	 */
	List<PurchaseBean> getPurchaseByType(int shopId, int typeId);
	
	/**
	 * 店主按商品名查找进货单
	 * @param shopId 商店ID
	 * @param goodsName 商品名
	 * @return 该商店所有的进货单
	 */
	List<PurchaseBean> getPurchaseByGoods(int shopId, String goodsName);
	
	/**
	 * 店主按商品编号查找进货单
	 * @param shopId 商店ID
	 * @param goodsName 商品名
	 * @return 该商店所有的进货单
	 */
	List<PurchaseBean> getPurchaseByGoods(int shopId, int goodsId);
	
	/**
	 * 店主按员工名查找进货单
	 * @param shopId 商店ID
	 * @param staffId 员工号
	 * @return 该商店所有的进货单
	 */
	List<PurchaseBean> getPurchaseByStaff(int shopId, int staffId);
	
	/**
	 * 店主将原有的数据按所需类型分类
	 * @param data 要挑选的原有的所有数据
	 * @param typeId 类型号
	 * @return 该商店符合要求的进货单
	 */
	List<PurchaseBean> getPurchaseByType(List<PurchaseBean> data, int typeId);
	
	/**
	 * 店主将删除指定订单号的进货单
	 * @param id 要删除的进货单ID
	 * @return null
	 */
	void deletePurchase(int id);
	
	/**
	 * 店主保存更新后的进货单
	 * @param p 更改后的进货单
	 * @param goodsName 更改后的商品名
	 * @param type 更改后的商品类型
	 * @return null
	 */
	void changePurchase(PurchaseBean p, String goodsName, int type);
}
