package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Repair;
import dao.RepairDao;

@Service("repairService")
@Transactional
public class RepairService {
	@Autowired
	RepairDao repairDao;
	
	@Transactional
	public List<Repair> getAllRepairs() {
		return repairDao.getAllRepairs();
	}
	@Transactional
	public Repair getRepair(int id) {
		return repairDao.getRepair(id);
	}
	@Transactional
	public void addRepair(Repair repair) {
		repairDao.addRepair(repair);
		
	}
	@Transactional
	public void updateRepair(Repair repair) {
		repairDao.updateRepair(repair);
		
	}
	
	public void deleteRepair(int id) {
		repairDao.deleteRepair(id);		
	}
	@Transactional
	public List<Repair> getPendingRepairs() {
		return repairDao.getPendingRepairs();
	}
}
