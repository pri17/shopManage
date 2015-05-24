package com.system.Dao;

import com.system.model.Purchase;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * Purchase entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.system.model.Purchase
 * @author MyEclipse Persistence Tools
 */
public class PurchaseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(PurchaseDAO.class);
	// property constants
	public static final String WORK_DAY = "workDay";
	public static final String PURCHASE_PRICE = "purchasePrice";
	public static final String SALE_PRICE = "salePrice";
	public static final String PURCHASE_NUM = "purchaseNum";

	public void save(Purchase transientInstance) {
		log.debug("saving Purchase instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Purchase persistentInstance) {
		log.debug("deleting Purchase instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Purchase findById(java.lang.Integer id) {
		log.debug("getting Purchase instance with id: " + id);
		try {
			Purchase instance = (Purchase) getSession().get(
					"com.system.model.Purchase", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Purchase instance) {
		log.debug("finding Purchase instance by example");
		try {
			List results = getSession()
					.createCriteria("com.system.model.Purchase")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Purchase instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Purchase as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByWorkDay(Object workDay) {
		return findByProperty(WORK_DAY, workDay);
	}

	public List findByPurchasePrice(Object purchasePrice) {
		return findByProperty(PURCHASE_PRICE, purchasePrice);
	}

	public List findBySalePrice(Object salePrice) {
		return findByProperty(SALE_PRICE, salePrice);
	}

	public List findByPurchaseNum(Object purchaseNum) {
		return findByProperty(PURCHASE_NUM, purchaseNum);
	}

	public List findAll() {
		log.debug("finding all Purchase instances");
		try {
			String queryString = "from Purchase";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Purchase merge(Purchase detachedInstance) {
		log.debug("merging Purchase instance");
		try {
			Purchase result = (Purchase) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Purchase instance) {
		log.debug("attaching dirty Purchase instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Purchase instance) {
		log.debug("attaching clean Purchase instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}