package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Car;
import bean.Status;
import service.StatusService;

@RestController
public class StatusController {
	@Autowired
	StatusService statusService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getAllStatuses",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Status>getStatuses() throws Exception{
		List<Status> lS = statusService.getAllStatus();
		return lS;
	}
}
