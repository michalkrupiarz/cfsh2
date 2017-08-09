package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Status;

@Repository
@Transactional
public class StatusDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sf;
	}
	public List<Status> getAllStatuses(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Status> lS = session.createQuery("from Status st order by st.id").list();
		return lS;
	}
}
