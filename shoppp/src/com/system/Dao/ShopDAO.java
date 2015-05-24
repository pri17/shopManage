package com.system.Dao;

import com.system.model.Shop;

import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for Shop
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.system.model.Shop
 * @author MyEclipse Persistence Tools
 */
public class ShopDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(ShopDAO.class);
	// property constants
	public static final String SHOP_NAME = "shopName";
	public static final String DISTRICT = "district";
	public static final String PRICE = "price";

	public void save(Shop transientInstance) {
		log.debug("saving Shop instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Shop persistentInstance) {
		log.debug("deleting Shop instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Shop findById(java.lang.Integer id) {
		log.debug("getting Shop instance with id: " + id);
		try {
			Shop instance = (Shop) getSession()
					.get("com.system.model.Shop", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Shop instance) {
		log.debug("finding Shop instance by example");
		try {
			List results = getSession().createCriteria("com.system.model.Shop")
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
		log.debug("finding Shop instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Shop as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByShopName(Object shopName) {
		return findByProperty(SHOP_NAME, shopName);
	}

	public List findByDistrict(Object district) {
		return findByProperty(DISTRICT, district);
	}

	public List findByPrice(Object price) {
		return findByProperty(PRICE, price);
	}

	public List findAll() {
		log.debug("finding all Shop instances");
		try {
			String queryString = "from Shop";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Shop merge(Shop detachedInstance) {
		log.debug("merging Shop instance");
		try {
			Shop result = (Shop) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Shop instance) {
		log.debug("attaching dirty Shop instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Shop instance) {
		log.debug("attaching clean Shop instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}