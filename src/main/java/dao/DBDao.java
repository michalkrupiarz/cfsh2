package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository 
@Transactional
public class DBDao {
	@Autowired
	private SessionFactory sessionFactory;  
	  
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }
	 
	 public void cleanDB(){
		 Session session = this.sessionFactory.getCurrentSession();
		 System.out.println(session.createSQLQuery("drop table cars").executeUpdate());
	 }
}
