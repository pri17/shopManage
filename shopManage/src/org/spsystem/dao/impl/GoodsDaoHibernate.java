package org.spsystem.dao.impl;

import java.util.List;

import org.common.dao.impl.BaseDaoHibernate;
import org.spsystem.dao.GoodsDao;
import org.spsystem.domain.Goods;
import org.spsystem.domain.Shop;
import org.spsystem.vo.GoodsInfBean;

public class GoodsDaoHibernate extends BaseDaoHibernate<Goods> implements GoodsDao{

	@Override
	public List<Goods> findByGoodsName(String goodsName) {
		return find("from Goods as a where a.name ='"+goodsName+"'");
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