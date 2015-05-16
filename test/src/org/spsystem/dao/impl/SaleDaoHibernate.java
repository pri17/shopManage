package org.spsystem.dao.impl;

import java.util.List;

import org.common.dao.impl.BaseDaoHibernate;
import org.spsystem.dao.SaleDao;
import org.spsystem.domain.*;

public class SaleDaoHibernate extends BaseDaoHibernate<Sale> implements SaleDao{

	@Override
	public List<Sale> findByShop(Shop shop) {
		return find("from Sale as a where a.shop=?0", shop);
	}

	@Override
	public List<Sale> findByGoods(Shop shop, Goods goods) {
		return find("from Sale as a where a.shop=?0 and a.goods=?1", shop, goods);
	}

	@Override
	public List<Sale> findByStaff(Shop shop, Staff staff) {
		return find("from Sale as a where a.shop=?0 and a.staff=?1", shop, staff);
	}

	
	@Override
	public List<Sale> findGoodsNumByDate(Shop shop, Goods goods, String Date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sale> findGoodsNumByMonth(Shop shop, Goods goods, String month) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sale> findGoodsNumByYear(Shop shop, Goods goods, String year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Sale> findGoodsSales(Shop shop, Goods goods, int num) {
		return findTop("from Sale as a where a.shop=?0 and a.goods=?1 order by workDay desc, saleTime desc", num , shop, goods);
	}

	@Override
	public long findGoodsSalesNumByYear(Shop shop, Goods goods, String year) {
		Object obj = select("select sum(num) from Sale as a where a.shop=?0 and a.goods=?1 and a.workDay like '%"+year+"%'", shop, goods).get(0);
		return (obj == null) ? 0:(long)obj;
	}

	@Override
	public long findSalesNumByYear(Shop shop, String year) {
		Object obj = select("select sum(num) from Sale as a where a.shop=?0 and a.workDay like '%"+year+"%'", shop).get(0);
		return (obj == null) ? 0:(long)obj;
	}

	@Override
	public double findGoodsSalesPriceByYear(Shop shop, Goods goods, String year) {
		Object obj = select("select sum(price) from Sale as a where a.shop=?0 and a.goods=?1 and a.workDay like '%"+year+"%'", shop, goods).get(0);
		return (obj == null) ? 0:(double)obj;
	}

	@Override
	public double findSalesPriceByYear(Shop shop, String year) {
		Object obj = select("select sum(price) from Sale as a where a.shop=?0 and a.workDay like '%"+year+"%'", shop).get(0);
		return (obj == null) ? 0:(double)obj;
	}

	@Override
	public List<Object[]> findGoodsByDate(Shop shop, Goods goods) {
		return select("select workDay, sum(num), sum(price) from Sale as a where a.shop=?0 and a.goods=?1 group by workDay order by workDay", shop, goods);
	}

	@Override
	public List<Object[]> findGoodsSalesPriceNum(Shop shop, Goods goods) {
		return select("select a.price, sum(a.num) from Sale as a where shop=?0 and goods=?1 group by price order by price", shop, goods);
	}

	@Override
	public double findSalesPrice(Shop shop) {
		Object obj = select("select sum(a.price) from Sale as a where a.shop=?0", shop).get(0);
		return (obj == null)?0:(double)obj;
	}

	@Override
	public List<Object[]> findTopGoodsNum(Shop shop, String start) {
		return select("select a.goods, sum(a.num) as c, sum(a.price)-(avg(b.inprice)*sum(a.num)) from Sale as a,Purchase as b where a.shop=?0 and a.shop=b.shop and a.goods=b.goods and a.workDay>'"+start+"' group by a.goods order by  c desc", shop);
	}

	@Override
	public List<Object[]> findHotGoodsPrice(Shop shop, String start) {
		return select("select a.goods, sum(a.num), sum(a.price)-(avg(b.inprice)*sum(a.num)) as c from Sale as a, Purchase as b where a.shop=?0 and a.shop=b.shop and a.goods=b.goods and a.workDay>'"+start+"' group by a.goods order by c desc", shop);
	}

	@Override
	public List<Object[]> findGoodsTypeNum(Shop shop, String ym) {
		return select("select a.goods.type, sum(a.num) from Sale as a where a.shop=?0 and a.workDay like '%"+ym+"%' group by a.goods.type order by a.goods.type.id", shop);
	}

	@Override
	public List<Object[]> findGoodsNumType(Shop shop, String ym, Type type) {
		return select("select a.goods, sum(a.num) as b from Sale as a where a.shop=?0 and a.workDay like '%"+ym+"%' group by a.goods order by b", shop);
	}

	@Override
	public List<Object[]> findGoodsNum(Shop shop, String ym) {
		
		return select("select a.goods, sum(a.num) from Sale as a where a.shop=?0 and a.workDay like '%"+ym+"%' group by a.goods", shop);
	}

}
