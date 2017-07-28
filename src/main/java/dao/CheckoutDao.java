package dao;

import java.util.List;

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

	 public List<Checkout> getAllCheckouts() {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  List<Checkout> checkoutList = (List<Checkout>) rD.getAllWithOrderBy(ch.getClass(), session, " ch order by ch.id");
		  //List<Checkout> checkoutList = session.createQuery("from Checkout").list();  
		  getAllSubLists(checkoutList);
		  return checkoutList;  
		 }

	private void getAllSubLists(List<Checkout> checkoutList) {
		for (Checkout c : checkoutList) {
			  System.out.println(c.getCar());
			  System.out.println(c.getStatus());
		  }
	}  
		 	 
	 public Checkout getCheckout(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  Checkout checkout = (Checkout) session.get(Checkout.class, new Integer(id)); 
		  return checkout;  
		 }  
		  
	 public Checkout addCheckout(Checkout checkout) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  checkout.setId(GeneralQuerrys.maxIdFromTable("select max(checkouts.id) from Checkout checkouts",session)); 
		  System.out.println(checkout.toString());
		  session.merge(checkout);  
		  return checkout;  
		 }  
		  
	 public void updateCheckout(Checkout checkout) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  session.update(checkout);  
		 }  
		  
	 public void deleteCheckout(int id) {  
		 
		  Session session = this.sessionFactory.getCurrentSession();  
		  Checkout p = (Checkout) session.load(Checkout.class, new Integer(id));  
		  System.out.println(p.getNote());
		  if (null != p) {  
		   session.delete(p);  
		  }  
		 }   
}	
