package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import bean.carLend;

@Repository
@Transactional
public class LendDao {
	@Autowired
	private SessionFactory sessionFactory;
	private ReusableDaos rDaos = new ReusableDaos();
	private carLend cLend = new carLend();
	
	public void setSessionFactory (SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	public List<carLend> getAllLends(){
		Session session = this.sessionFactory.getCurrentSession();
		List<carLend> lendList = (List<carLend>) rDaos.getAllWithOrderBy(cLend.getClass(), this.sessionFactory.getCurrentSession(), "cL order by cL.id");
		getSubLists(lendList);
		return lendList;
	}

	private void getSubLists(List<carLend> lendList) {
		for (carLend l:lendList) {
			System.out.println(l.getCar());
			System.out.println(l.getStatus());
		}
	}
	
	public carLend getLend (int id){
		Session session = this.sessionFactory.getCurrentSession();
		carLend carLend = (carLend) session.get(carLend.class,new Integer (id));
		return carLend;
	}
	
	public carLend addLend(carLend carLend){
		Session session = this.sessionFactory.getCurrentSession();
		carLend.setId(GeneralQuerrys.maxIdFromTable("select max(lends.id) from carLend lends",session));
		System.out.println("id set "+carLend.getId());
		session.clear();
		session.save(carLend);
		session.flush();
		
		return carLend;
	}
	
	public void updateLend(carLend carLend){
		Session session = this.sessionFactory.getCurrentSession();
		session.update(carLend);
	}
	
	public void deleteLend(int id){
		Session session = this.sessionFactory.getCurrentSession();
		carLend l = (carLend) session.load(carLend.class,new Integer (id));
		if (null !=l){
			session.delete(l);
		}
	}
}
