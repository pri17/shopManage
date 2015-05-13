package org.spsystem.dao.impl;

import java.util.Date;
import java.util.List;

import org.common.dao.impl.BaseDaoHibernate;
import org.spsystem.dao.PurchaseDao;
import org.spsystem.domain.Goods;
import org.spsystem.domain.Purchase;
import org.spsystem.domain.Shop;
import org.spsystem.domain.Staff;
import org.spsystem.domain.Type;

public class PurchaseDaoHibernate extends BaseDaoHibernate<Purchase> implements PurchaseDao{

	@Override
	public List<Purchase> findByShop(Shop shop) {
		return find("from Purchase as a where a.shop=?0", shop);
	}

	

	@Override
	public List<Purchase> findByGoods(Shop shop, Goods goods) {
		return find("from Purchase as a where a.shop=?0 and a.goods=?1", shop, goods);
	}

	@Override
	public List<Purchase> findOrderbyTime(Shop shop) {
		return find("from Purchase as a where a.shop=?0 order by a.purchaseTime desc", shop);
	}

	@Override
	public List<Purchase> findOrderbyNum(Shop shop) {
		return find("from Purchase as a where a.shop=?0 order by a.num desc", shop);
	}

	@Override
	public List<Purchase> findByType(Shop shop, Type type) {
		return find("from Purchase as a where a.shop=?0 and a.goods.type=?1", shop, type);
	}

	@Override
	public List<Purchase> findGoodsByType(Shop shop, Type type) {
		return find("from Purchase as a where a.shop=?0 and a.goods.type=?1 group by a.goods", shop, type);
	}

	@Override
	public List<Purchase> findGoodsByShop(Shop shop, String name) {
		return find("from Purchase as a where a.shop=?0 and a.goods.name like '%"+name+"%'", shop);
	}

	@Override
	public List<Purchase> findGoodsByStaff(Shop shop, Staff staff) {
		return find("from Purchase as a where a.shop=?0 and a.staff=?1", shop, staff);
	}



	@Override
	public List<Purchase> findGoodsPurchases(Shop shop, Goods goods, int num) {
		return findTop("from Purchase as a where a.shop=?0 and a.goods=?1 order by workDay desc, purchaseTime desc", num , shop, goods);
	}



	@Override
	public double findGoodsPurchasesPriceByYear(Shop shop, Goods goods, String year) {
		Object obj = select("select sum(a.inprice*a.num) from Purchase as a where a.shop=?0 and a.goods=?1 and a.workDay like '%"+year+"%'", shop, goods).get(0);
		return (obj == null)?0:(Double)obj;
	}



	@Override
	public double findPurchasesPriceByYear(Shop shop, String year) {
		Object obj = select("select sum(a.inprice*a.num) from Purchase as a where a.shop=?0 and a.workDay like '%"+year+"%'", shop).get(0);
		return (obj == null)?0:(Double)obj;
	}



	@Override
	public double findPurchasePirce(Shop shop) {
		Object obj = select("select sum(a.inprice*a.num) from Purchase as a where a.shop=?0", shop).get(0);
		return (obj == null)?0:(Double)obj;
	}

}
