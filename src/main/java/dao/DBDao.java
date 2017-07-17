package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hsqlServer.CreateAndPopulateDB;

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
		 System.out.println(session.createSQLQuery("drop table tires").executeUpdate());
		 System.out.println(session.createSQLQuery("drop table insurances").executeUpdate());
		 System.out.println(session.createSQLQuery("drop table calendar").executeUpdate());
		 System.out.println(session.createSQLQuery("drop table lends").executeUpdate());
		 System.out.println(session.createSQLQuery("drop table repairs").executeUpdate());
		 System.out.println(session.createSQLQuery("drop table cars").executeUpdate());
			 }

	public void createDB() throws Exception {
		CreateAndPopulateDB db = new CreateAndPopulateDB();
	    CreateAndPopulateDB.checkOrCreateTable(db);
		
	}
}
