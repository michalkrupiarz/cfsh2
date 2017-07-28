package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import bean.Tire;

@Repository
@Transactional
public class TireDao {
	
	 @Autowired  
	 private SessionFactory sessionFactory;  
	 private Tire t = new Tire();
	 private ReusableDaos rD = new ReusableDaos();
	  
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }  

	 public List<Tire> getAllTires() {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  List<Tire> tiresList = (List<Tire>) rD.getAllWithOrderBy(t.getClass(), session, " t order by t.id");
		  getAllSubLists(tiresList);
		  return tiresList;  
		 }

	private void getAllSubLists(List<Tire> tiresList) {
		for (Tire t:tiresList) {
			  System.out.println(t.getCar());
			  System.out.println(t.getStatus());
		  }
	}  
		 
	 
	 
		 public Tire getTires(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  Tire tires = (Tire) session.get(Tire.class, new Integer(id)); 
		  return tires;  
		 }  
		  
		 public Tire addTires(Tire tires) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  tires.setId(GeneralQuerrys.maxIdFromTable("select max(tires.id) from Tire tires",session)); 
		  System.out.println(tires.toString());
		  session.merge(tires);  
		  return tires;  
		 }  
		  
		 public void updateTires(Tire tires) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  session.update(tires);  
		 }  
		  
		 public void deleteTires(int id) {  
		 
		  Session session = this.sessionFactory.getCurrentSession();  
		  Tire p = (Tire) session.load(Tire.class, new Integer(id));  
		  if (null != p) {  
		   session.delete(p);  
		  }  
		 }   
}	
