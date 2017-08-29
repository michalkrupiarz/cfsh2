package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Insurance;
import dao.InsuranceDao;

@Service("InsuranceService")
@Transactional
public class InsuranceService {
	@Autowired
	InsuranceDao insDao;
	
	@Transactional
	public List<Insurance> getAllInsurances(){
		return insDao.getAllInsurances();
	}
	@Transactional 
	public Insurance getInsurance(int id){
		return insDao.getInsurance(id);
	}
	
	@Transactional
	public void addInsurance(Insurance ins){
		insDao.addInsurance(ins);
	}
	
	@Transactional
	public void updateInsurance(Insurance ins){
		insDao.updateInsurance(ins);
	}
	
	@Transactional
	public void deleteLEnd(int id){
		insDao.deleteInsurance(id);
	}
	public List<Insurance> getInsurancesEndingIn(int days) { 
		return insDao.getInsurancesEndingIn(days);
	}
}
