package dao;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Car;
import bean.Repair;
import usefull_tools.DateAndTime;

@Repository
@Transactional
public class RepairDao {
	 CarDAO cD = new CarDAO();
	 DateAndTime dAT = new DateAndTime();
	 @Autowired  
	 private SessionFactory sessionFactory;  
	 
	 private ReusableDaos rD=new ReusableDaos();
	 
	 private Repair r = new Repair();
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }  
	 @Transactional
	 public List<Repair> getAllRepairs() {  
		 Session session = this.sessionFactory.getCurrentSession();  
		  
		  Repair r = new Repair();
		  r.setCost((float) 12);
		  List<Repair> repairList = (List<Repair>) rD.getAllWithOrderBy(r.getClass(), session," r order by r.id");
		  getAllSubLists(repairList);
		  return repairList;  
		 }
	 @Transactional
	 public Repair getRepair(int id) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  Repair repair = (Repair) session.get(Repair.class, new Integer(id)); 
		  return repair;  
		 }  
	 @Transactional
	 public Repair addRepair(Repair repair) {  
		  Session session = this.sessionFactory.getCurrentSession();
		  repair.setId(GeneralQuerrys.maxIdFromTable("select max(repairs.id) from Repair repairs",session)); 
		  //repair.setCar(repair.getCar());
		  session.clear();
		  session.save(repair);  
		 
		  return repair;  
		 }  
	 @Transactional	  
	 public void updateRepair(Repair repair) {  
		  Session session = this.sessionFactory.getCurrentSession();  
		  session.update(repair);  
		 }  
	 @Transactional	  
	 public void deleteRepair(int id) {  
		 
		  Session session = this.sessionFactory.getCurrentSession();  
		  Repair p = (Repair) session.load(Repair.class, new Integer(id));  
		  System.out.println(p.getNote());
		  if (null != p) {  
		   session.delete(p);  
		  }  
		 }   
	 @Transactional
	 public List<Repair> getPendingRepairs() {
		 Calendar currentDate = Calendar.getInstance();
		 Session session = this.sessionFactory.getCurrentSession();  
		 Query q = session.createQuery("from Repair r join fetch r.status s where r.dateEnd >=:cDate and s.progress = :status ");
		 q.setParameter("cDate", currentDate);
		 q.setParameter("status", "in status");
		 List <Repair> repairList = q.list();
		 getAllSubLists(repairList);
		 return repairList;  
	 }
	 @Transactional
	 public List<Repair> getRepairsThatWillEndInDays(int days){
		 Session session = this.sessionFactory.getCurrentSession();  
		 Calendar cDate = Calendar.getInstance();
		 cDate.add(Calendar.DATE, days);
		 Query q = session.createQuery("from Repair r join fetch r.status s where r.dateEnd <=:cDate and s.progress = :status ");
		 q.setParameter("cDate", cDate);
		 q.setParameter("status", "in status");
		 List <Repair> repairList = q.list();
		 getAllSubLists(repairList);
		 return repairList;  
	 }
	 private void getAllSubLists(List<Repair> repairList) {
			for (Repair rL:repairList) {
				  System.out.println("this is car from repair "+rL.getCar());
				  System.out.println("this is repair status "+rL.getStatus());
			  }
		}  
	 
}	
