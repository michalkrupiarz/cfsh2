package dao;

import java.time.chrono.ThaiBuddhistChronology;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class GeneralQuerrys {
	
	public static Integer maxIdFromTable(String querry, Session session){
		Integer out = (Integer) session.createQuery(querry).uniqueResult();
		
		
		
		return out+1;
	}
}
