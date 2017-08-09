package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Status;
import dao.StatusDao;

@Service("statusService")
@Transactional
public class StatusService {
	@Autowired
	StatusDao statusDao;
	
	public List<Status> getAllStatus(){
		return statusDao.getAllStatuses();
	}
}
