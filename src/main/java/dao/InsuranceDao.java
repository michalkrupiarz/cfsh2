package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Insurance;
import bean.Insurance;

@Repository
@Transactional
public class InsuranceDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory (SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<Insurance> getAllInsurances(){
		Session session = this.sessionFactory.getCurrentSession();
	
		List<Insurance> insuranceList = session.createQuery("from Insurance").list();
		for (Insurance i:insuranceList) {
			System.out.println(i.getCar());
		}
		return insuranceList;
	}
	
	public Insurance getInsurance (int id){
		Session session = this.sessionFactory.getCurrentSession();
		Insurance Insurance = (Insurance) session.get(Insurance.class,new Integer (id));
		return Insurance;
	}
	
	public Insurance addInsurance(Insurance Insurance){
		Session session = this.sessionFactory.getCurrentSession();
		Insurance.setId(GeneralQuerrys.maxIdFromTable("select max(insurances.id, session) from Insurance insurances",session));
		session.merge(Insurance);
		return Insurance;
	}
	
	public void updateInsurance(Insurance Insurance){
		Session session = this.sessionFactory.getCurrentSession();
		session.update(Insurance);
	}
	
	public void deleteInsurance(int id){
		Session session = this.sessionFactory.getCurrentSession();
		Insurance l = (Insurance) session.load(Insurance.class,new Integer (id));
		if (null !=l){
			session.delete(l);
		}
	}
}
