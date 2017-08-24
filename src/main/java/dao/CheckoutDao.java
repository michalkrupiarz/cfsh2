package dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Car;
import bean.Checkout;

@Repository
@Transactional
public class CheckoutDao {
	
	 @Autowired  
	 private SessionFactory sessionFactory;  
	 
	 private Checkout ch = new Checkout();
	 
	 private ReusableDaos rD = new ReusableDaos();
	 
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }  
	 @Transactional
	 public List<Checkout> getAllCheckouts() {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  List<Checkout> checkoutList = (List<Checkout>) rD.getAllWithOrderBy(ch.getClass(), session, " ch order by ch.id");
		  //List<Checkout> checkoutList = session.createQuery("from Checkout").list();  
		  getAllSubLists(checkoutList);
		  return checkoutList;  
		 }
	 @Transactional
	private void getAllSubLists(List<Checkout> checkoutList) {
		for (Checkout c : checkoutList) {
			  System.out.println(c.getCar());
			  System.out.println(c.getStatus());
		  }
	}  
	 @Transactional	 
	 public Checkout getCheckout(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  Checkout checkout = (Checkout) session.get(Checkout.class, new Integer(id)); 
		  return checkout;  
		 }  
	 @Transactional
	 public Checkout addCheckout(Checkout checkout) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  checkout.setId(GeneralQuerrys.maxIdFromTable("select max(checkouts.id) from Checkout checkouts",session)); 
		  System.out.println("this is set id "+checkout.getId());
		  System.out.println(checkout.toString());
		  session.merge(checkout);  
		  return checkout;  
		 }  
	 @Transactional  
	 public void updateCheckout(Checkout checkout) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  session.update(checkout);  
		 }  
	 @Transactional
	 public void deleteCheckout(int id) {  
		 
		  Session session = this.sessionFactory.getCurrentSession();  
		  Checkout p = (Checkout) session.load(Checkout.class, new Integer(id));  
		  System.out.println(p.getNote());
		  if (null != p) {  
		   session.delete(p);  
		  }  
		 }
	 @Transactional
	public List<Checkout> getCheckoutsUpcomingIn(int days) {
		 Session session = this.sessionFactory.getCurrentSession();  
		 Calendar cDate = Calendar.getInstance();
		 cDate.add(Calendar.DATE, days);
		 Query q = session.createQuery("from Checkout c join fetch c.status s where c.dateTo<=:cDate and s.progress = :status");
		 q.setParameter("status", "in status");
		 q.setParameter("cDate",cDate);
		 List<Checkout> cS = q.list();
		 getAllSubLists(cS);  
		return cS;
	}
	 @Transactional
	public List<Checkout> getPendingCheckouts() {
		Session s = sessionFactory.getCurrentSession();
		Calendar cDate = Calendar.getInstance();
		Query q = s.createQuery("from Checkout c join fetch c.status s where c.dateTo>=:cDate and s.progress =:status");
		q.setParameter("cDate",cDate);
		q.setParameter("status", "in status");
		List<Checkout> cs = q.list();
		getAllSubLists(cs);
		return cs;
	}   
}	
