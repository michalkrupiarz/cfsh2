package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.DBDao;

@Service("dbService")
@Transactional
public class DBService {
	@Autowired
	DBDao dbDao;
	@Transactional
	public void cleanDB(){
		dbDao.cleanDB();
	}
	@Transactional
	public void createDB() throws Exception{
		dbDao.createDB();
	}
}
