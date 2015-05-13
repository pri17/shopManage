import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.spsystem.domain.Sale;
import org.spsystem.domain.Type;



public class test {

	public static void main(String[] args) {
		 Configuration conf = new Configuration().configure();	  
		  ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(conf.getProperties()).buildServiceRegistry();		     
		  SessionFactory sf=conf.buildSessionFactory(serviceRegistry);	
			Session sess = sf.openSession();
			Transaction tx = sess.beginTransaction();
			//测试1.1:insert into
			/*Type n = new Type();
			n.setName("生活用品");
			sess.save(n);*/
			//测试1.2
			/*Query query= sess.createQuery("from Type where id = 1");
			Type t = (Type)query.list().get(0);
			Goods g = new Goods();
			g.setName("shirt");
			g.setType(t);
			sess.save(g);*/
			//测试2.1:单表select
			Query query= sess.createQuery("from Sale");
		     List<Sale> l = query.list();
		for (Iterator<Sale> it = l.iterator(); it.hasNext(); )
		    {
			Sale n = it.next();
		        System.out.println(n.getId()+" "+n.getShop().getId());
		    }
			//测试2.2:多表select
			/*Date now = new Date();
			Query query= sess.createQuery("from Purchase as a where a.purchaseTime.year="+(now.getYear()+1900));
		     List<Purchase> l = query.list();
		for (Iterator<Purchase> it = l.iterator(); it.hasNext(); )
		    {
				Purchase n = it.next();
				 System.out.println(n.getId());
		        System.out.println(n.getGoods().getName());
		        System.out.println(n.getWorkDay());
		    }
		Query q = sess.createQuery("select sum(num) from Sale");
		Object obj = q.list().get(0);
		int i = ( obj== null)? 0:(int)obj;
		//int i = (int)q.list().get(0);
		System.out.println(i);*/
			tx.commit();
			sess.close();
	}
}
