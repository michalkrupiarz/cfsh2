package dao;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;



import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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
		  for (Repair r:repairList) {
			  System.out.println("this is car from repair "+r.getCar());
		  }
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
	 public List<Repair> getPendingRepairs() {
		 Calendar currentDate = Calendar.getInstance();
		 Session session = this.sessionFactory.getCurrentSession();  
		 Query q = session.createQuery("from Repair r where r.dateEnd >=:cDate");
		 System.out.println(currentDate.toString());
		 q.setParameter("cDate", currentDate);
		 List <Repair> repairList = q.list();
		 return repairList;  
	 }
	 public List<Repair> getRepairsThatAreToEndInDays(int daysToEnd){
		 
		 LocalDate cDate = LocalDate.now();
		 int day = cDate.getDayOfMonth();
		 int month = 7;//cDate.getMonthValue();
		 Session s = this.sessionFactory.getCurrentSession();
		 Query q = s.createQuery("select r.dateEnd , day(r.dateEnd) , month(r.dateEnd) from Repair r where (((day(r.dateEnd)-:dTE) =:cDay) and (month(r.dateEnd)=:cMonth))");
		 //where (day(r.dateEnd)-:dTE) =:cDay and month(r.dateEnd) = :cMonth
	//	 Query q = s.createQuery("from Repair r where month(r.dateEnd)=:cMonth and day(r.dateEnd)-:dTE=:cDay");
		 q.setParameter("cDay", day);
     	 q.setParameter("cMonth", month);
         q.setParameter("dTE", daysToEnd);
		 List<Repair> repairList = q.list();
	//		 for (Repair r:repairList) {
	//			  System.out.println("this is car from repair "+r.getCar());
	//		  }
		 return repairList;
	 }
}	
