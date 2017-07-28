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
	 
	 private ReusableDaos rD=new ReusableDaos();
	 
	 private Repair r = new Repair();
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }  

	 public List<Repair> getAllRepairs() {  
		 Session session = this.sessionFactory.getCurrentSession();  
		  
		  Repair r = new Repair();
		  r.setCost((float) 12);
		  List<Repair> repairList = (List<Repair>) rD.getAllWithOrderBy(r.getClass(), session," r order by r.id");
		  getAllSubLists(repairList);
		  return repairList;  
		 }

	private void getAllSubLists(List<Repair> repairList) {
		for (Repair rL:repairList) {
			  System.out.println("this is car from repair "+rL.getCar());
			  System.out.println("this is repair status "+rL.getStatus());
		  }
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
		 Repair rep = new Repair();
		 Session session = this.sessionFactory.getCurrentSession();  
		 Query q = session.createQuery("from Repair r where r.dateEnd >=:cDate");
		 //Query q = session.createQuery("from Repair r ")
		 q.setParameter("cDate", currentDate);
		 List <Repair> repairList = q.list();
		 return repairList;  
	 }
	 public List<Repair> getRepairsThatAreToEndInDays(int daysToEnd){
		 
//		 LocalDate cDate = LocalDate.now();
//		 int day = cDate.getDayOfMonth();
//		 int month = 7;//cDate.getMonthValue();
//		 Session s = this.sessionFactory.getCurrentSession();
//		 Query q = s.createQuery("select r.dateEnd , day(r.dateEnd) , month(r.dateEnd) from Repair r where (((day(r.dateEnd)-:dTE) =:cDay) and (month(r.dateEnd)=:cMonth))");
//		 q.setParameter("cDay", day);
//     	 q.setParameter("cMonth", month);
//         q.setParameter("dTE", daysToEnd);
//		 List<Repair> repairList = q.list();
//			 for (Repair r:repairList) {
//				  System.out.println("this is car from repair "+r.getCar());
//			  }
			 
		 return null;
	 }
}	
