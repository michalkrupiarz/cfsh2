package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Tire;
import dao.TireDao;

@Service("TiresService")
@Transactional
public class TireService {
	@Autowired
	TireDao tiresDao;
	
	@Transactional
	public List<Tire> getAllTires(){
		return tiresDao.getAllTires();
	}
	@Transactional 
	public Tire getTires(int id){
		return tiresDao.getTires(id);
	}
	
	@Transactional
	public void addTires(Tire t){
		tiresDao.addTires(t);
	}
	
	@Transactional
	public void updateTires(Tire t){
		tiresDao.updateTires(t);
	}
	
	@Transactional
	public void deleteLEnd(int id){
		tiresDao.deleteTires(id);
	}
	public List<Tire> getTiresToChangeIn(int days) {
		return tiresDao.getTiresToChangeIn(days);
	}
}
