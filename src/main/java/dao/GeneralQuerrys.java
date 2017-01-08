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
	@Autowired
	private SessionFactory sessionFactory;
	public void seSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	public Integer maxIdFromTable(String querry){
		Session session = this.sessionFactory.getCurrentSession();
		return Integer.parseInt(session.createQuery(querry).toString());
	}
}
