package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import service.DBService;

@RestController
public class DBController {
	@Autowired
	DBService dbservice;
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/clean", method = RequestMethod.GET, headers = "Accept=application/json")
	public void cleanDB () {
		dbservice.cleanDB();
	}
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/createDB", method = RequestMethod.GET, headers = "Accept=application/json")
	public void createDB () throws Exception {
		dbservice.createDB();
	}
}
