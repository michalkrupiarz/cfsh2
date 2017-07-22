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
	
}
