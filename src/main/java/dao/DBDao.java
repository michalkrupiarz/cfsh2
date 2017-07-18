package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import hsqlServer.CreateAndPopulateDB;
import javassist.CodeConverter.ArrayAccessReplacementMethodNames;

@Repository 
@Transactional
public class DBDao {
	@Autowired
	private SessionFactory sessionFactory;  
	 
	private List<String> tableNames = Arrays.asList("documents","tires","insurances","calendar","lends","repairs","cars");
		
	 public void setSessionFactory(SessionFactory sf) {  
	  this.sessionFactory = sf;  
	 }
	 
	 public void cleanDB(){
		 Session session = this.sessionFactory.getCurrentSession();
		 List<String> failedTables = new ArrayList<String>();
		 for (String tableName : tableNames) {
		 	dropTable(session,tableName,failedTables);
		 }
		 System.out.println(failedTables);
//		 try {
//			System.out.println(session.createSQLQuery("drop table documents").executeUpdate());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 System.out.println(session.createSQLQuery("drop table tires").executeUpdate());
//		 System.out.println(session.createSQLQuery("drop table insurances").executeUpdate());
//		 System.out.println(session.createSQLQuery("drop table calendar").executeUpdate());
//		 System.out.println(session.createSQLQuery("drop table lends").executeUpdate());
//		 System.out.println(session.createSQLQuery("drop table repairs").executeUpdate());
//		 System.out.println(session.createSQLQuery("drop table cars").executeUpdate());
	}

	public void createDB() throws Exception {
		CreateAndPopulateDB db = new CreateAndPopulateDB();
	    CreateAndPopulateDB.checkOrCreateTable(db);
		
	}
	
	private void dropTable(Session s, String tName, List<String> failedT) {
		try {
			System.out.println(s.createSQLQuery("drop table "+tName).executeUpdate());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			failedT.add(tName);
		}
	}
	
	
}
