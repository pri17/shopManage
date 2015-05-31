package com.system.Dao.impl;

import java.util.List;

import com.basic.Dao.impl.BasicDaoHibernate;
import com.system.Dao.GoodsDao;
import com.system.model.Goods;
import com.system.model.Shop;

public class GoodsDaoHibernate extends BasicDaoHibernate<Goods> implements GoodsDao {

	@Override
	public List<Goods> findByGoodsName(String goodsName) {
		return find("from Goods as a where a.goodsName like '%'"+goodsName+"%'");
	}
	@Override
	public List<Goods> findGoodsById(int id) {
		return find("from  Goods as a  where a.goodsId="+id);
	}

	@Override
	public List<Goods> findGoodsByType(String type_name) {
		return find("select b.name,a.id,a.name from Goods as a ,Type as b where a.type.typeId=b.typeId and b.typeName like '%"+type_name+'%');
	}
	@Override
	public List<Goods> findGoodsByShop(Shop shop) {
		return find("select a.goods from Purchase as a where a.shop=?0 group by a.goods order by a.goods.id", shop);
	}

	@Override
	public List<Object[]> findSaleInfByGoods(Shop shop, Goods goods) {
		return select("select a.goods.id, sum(a.num), sum(a.price), count(*) from Sale as a where a.shop=?0 and a.goods=?1 group by a.goods", shop, goods);
	}

	@Override
	public List<Object[]> findPurchaseInfByGoods(Shop shop, Goods goods) {
		return select("select a.goods.id, sum(a.num), sum(a.inprice*a.num), count(*) from Purchase as a where a.shop=?0 and a.goods=?1 group by a.goods", shop, goods);
	}

	@Override
	public List<Object[]> findSaleInfByGoods(Shop shop) {
		return select("select a.goods.id, sum(a.num), sum(a.price), count(*) from Sale as a where a.shop=?0 group by a.goods order by a.goods.id", shop);
	}

	@Override
	public List<Object[]> findPurchaseInfByGoods(Shop shop) {
		return select("select a.goods.id, sum(a.num), sum(a.inprice*a.num), count(*) from Purchase as a where a.shop=?0 group by a.goods order by a.goods.id", shop);
	}

	@Override
	public List<Goods> findGoodsByName(Shop shop, String goodsName) {
		return find("select a.goods from Purchase as a where a.shop=?0 and a.goods.name like'%"+goodsName+"%' order by a.goods.id", shop);
	}

	@Override
	public List<Object[]> findPurchaseInfByName(Shop shop, String goodsName) {
		return select("select a.goods.id, sum(a.num), sum(a.inprice*a.num), count(*) from Purchase as a where a.shop=?0 and a.goods.name like'%"+goodsName+"%' group by a.goods order by a.goods.id", shop);
	}

	@Override
	public List<Object[]> findSaleInfByName(Shop shop, String goodsName) {
		return select("select a.goods.id, sum(a.num), sum(a.price), count(*) from Sale as a where a.shop=?0 and a.goods.name like '%"+goodsName+"%'group by a.goods order by a.goods.id", shop);
	}

	
}