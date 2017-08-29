package dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.Checkout;
import bean.Insurance;
import bean.Insurance;

@Repository
@Transactional
public class InsuranceDao {
	@Autowired
	private SessionFactory sessionFactory;
	private ReusableDaos rD = new ReusableDaos();
	private Insurance i = new Insurance();
	public void setSessionFactory (SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<Insurance> getAllInsurances(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Insurance> insuranceList = (List<Insurance>) rD.getAllWithOrderBy(i.getClass(), session, " i order by i.id");
		getAllSubLists(insuranceList);
		return insuranceList;
	}

	private void getAllSubLists(List<Insurance> insuranceList) {
		for (Insurance i:insuranceList) {
			System.out.println(i.getCar());
			System.out.println(i.getStatus());
		}
	}
	
	public Insurance getInsurance (int id){
		Session session = this.sessionFactory.getCurrentSession();
		Insurance Insurance = (Insurance) session.get(Insurance.class,new Integer (id));
		return Insurance;
	}
	
	public Insurance addInsurance(Insurance Insurance){
		Session session = this.sessionFactory.getCurrentSession();
		Insurance.setId(GeneralQuerrys.maxIdFromTable("select max(insurances.id) from Insurance insurances",session));
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

	public List<Insurance> getInsurancesEndingIn(int days) {
		 Session session = this.sessionFactory.getCurrentSession();  
		 Calendar cDate = Calendar.getInstance();
		 cDate.add(Calendar.DATE, days);
		 Query q = session.createQuery("from Insurance i join fetch i.status s where i.dateEnd<=:cDate and s.progress = :status");
		 q.setParameter("status", "in status");
		 q.setParameter("cDate",cDate);
		 List<Insurance> iS = q.list();
		 getAllSubLists(iS);  
		 return iS;
	}
}
