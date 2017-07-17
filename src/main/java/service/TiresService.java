package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Tires;
import dao.TiresDao;

@Service("TiresService")
@Transactional
public class TiresService {
	@Autowired
	TiresDao tiresDao;
	
	@Transactional
	public List<Tires> getAllTires(){
		return tiresDao.getAllTires();
	}
	@Transactional 
	public Tires getTires(int id){
		return tiresDao.getTires(id);
	}
	
	@Transactional
	public void addTires(Tires t){
		tiresDao.addTires(t);
	}
	
	@Transactional
	public void updateTires(Tires t){
		tiresDao.updateTires(t);
	}
	
	@Transactional
	public void deleteLEnd(int id){
		tiresDao.deleteTires(id);
	}
}
