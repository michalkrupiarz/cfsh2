package dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ReusableDaos {
	
	
	public <T> List<T> getAll(Class<T> cls, Session s){
		List<T> result = s.createQuery("from "+cls.getName()).list();
		return result;
	}
	
	public <T> List<T> getAllWithOrderBy(Class<T> cls, Session s, String orderByClause){
		List <T> result = s.createQuery("from "+cls.getName()+" "+orderByClause).list();
		return result;
	}
	
	public <T> List<T> getPendingActivities(Class<T> cls, Session s, String joinPart, String wereClause, String className){
		List<T> result = s.createQuery("select distinct "+className+" from "+cls.getName()+" "+className+" "+joinPart+
				 wereClause).list();
		return result;
	}
	public <T> List<T> getCarsWithSubClass(Class<T> cls, Session s, String joinPart, String className){
		List<T> result = s.createQuery("Select distinct "+className+" from "+cls.getName()+" "+className+" "+joinPart).list();
		return result;
	}
	public <T> List<T> getPendingActivitiesNotDistinct(Class<T> cls, Session s, String joinPart, String wereClause, String className){
		List<T> result = s.createQuery("select distinct "+className+" from "+cls.getName()+" "+className+" "+joinPart+
				 wereClause).list();
		return result;
	}
}	
