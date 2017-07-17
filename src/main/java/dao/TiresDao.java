package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import bean.Tires;

@Repository
@Transactional
public class TiresDao {
	
	 @Autowired  
	 private SessionFactory sessionFactory;  
	  
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }  

	 public List<Tires> getAllTires() {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  List<Tires> tiresList = session.createQuery("from Tires").list();  
		  return tiresList;  
		 }  
		 
	 
	 
		 public Tires getTires(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  Tires tires = (Tires) session.get(Tires.class, new Integer(id)); 
		  return tires;  
		 }  
		  
		 public Tires addTires(Tires tires) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  tires.setId(GeneralQuerrys.maxIdFromTable("select max(tires.id) from Tires tires",session)); 
		  System.out.println(tires.toString());
		  session.merge(tires);  
		  return tires;  
		 }  
		  
		 public void updateTires(Tires tires) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  session.update(tires);  
		 }  
		  
		 public void deleteTires(int id) {  
		 
		  Session session = this.sessionFactory.getCurrentSession();  
		  Tires p = (Tires) session.load(Tires.class, new Integer(id));  
		  if (null != p) {  
		   session.delete(p);  
		  }  
		 }   
}	
