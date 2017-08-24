package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.carLend;
import dao.LendDao;

@Service("lendService")
@Transactional
public class lendService {
	@Autowired
	LendDao lendDao;
	
	@Transactional
	public List<carLend> getAllLends(){
		return lendDao.getAllLends();
	}
	@Transactional 
	public carLend getLend(int id){
		return lendDao.getLend(id);
	}
	
	@Transactional
	public void addLend(carLend cL){
		lendDao.addLend(cL);
	}
	
	@Transactional
	public void updateLend(carLend cL){
		lendDao.updateLend(cL);
	}
	
	@Transactional
	public void deleteLEnd(int id){
		lendDao.deleteLend(id);
	}
	@Transactional
	public int getFreeCarsNumber() {
		// TODO Auto-generated method stub
		return lendDao.getFreeCarsNumber();
	}
	@Transactional
	public int getTakenCarsNumber() {
		// TODO Auto-generated method stub
		return lendDao.getTakenCarsNumber();
	}
	public int getCarsThatLendEndsIn(int days) {
		// TODO Auto-generated method stub
		return lendDao.getCarsThatLendEndsIn(days);
	}
}
