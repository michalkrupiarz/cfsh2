package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Car;
import bean.Repair;
import hsqlServer.CreateAndPopulateDB;
import service.RepairService;

@RestController
public class RepairController {
	@Autowired
	RepairService repairService;
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/getAllRepairs",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Repair>getRepairs() throws Exception{
		List<Repair> listOfRepairs = repairService.getAllRepairs();
		return listOfRepairs;
	}
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value = "/getRepair/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Repair getRepairById(@PathVariable int id) {  
	  return repairService.getRepair(id);  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/addRepair", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addRepair(@RequestBody Repair repair) {  
	  repairService.addRepair(repair);  
	    
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/updateRepair", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updateRepair(@RequestBody Repair repair) {  
	  repairService.updateRepair(repair);  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/deleteRepair/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteRepair(@PathVariable("id") int id) {  
	  repairService.deleteRepair(id);    
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/getPendingRepairs", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<Repair> getPendingRepairs(){  
	  return repairService.getPendingRepairs();  
	 } 
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value = "/getRepairsThatEndInDays/{days}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<Repair> getRepairsThatEndInDays(@PathVariable int days) {  
	  return repairService.getRepairsThatEndInDays(days);  
	 }  
}
