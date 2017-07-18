package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Car;
import bean.Repair;

@Repository
@Transactional
public class RepairDao {
	
	 @Autowired  
	 private SessionFactory sessionFactory;  
	  
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }  

	 public List<Repair> getAllRepairs() {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  List<Repair> repairList = session.createQuery("from Repair").list();  
		  return repairList;  
		 }  
		 	 
	 public Repair getRepair(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  Repair repair = (Repair) session.get(Repair.class, new Integer(id)); 
		  return repair;  
		 }  
		  
	 public Repair addRepair(Repair repair) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  repair.setId(GeneralQuerrys.maxIdFromTable("select max(repairs.id) from Repair repairs",session)); 
		  System.out.println(repair.toString());
		  session.merge(repair);  
		  return repair;  
		 }  
		  
	 public void updateRepair(Repair repair) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  session.update(repair);  
		 }  
		  
	 public void deleteRepair(int id) {  
		 
		  Session session = this.sessionFactory.getCurrentSession();  
		  Repair p = (Repair) session.load(Repair.class, new Integer(id));  
		  System.out.println(p.getNote());
		  if (null != p) {  
		   session.delete(p);  
		  }  
		 }   
}	
