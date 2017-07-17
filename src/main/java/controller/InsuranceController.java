package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Insurance;
import bean.Insurance;
import hsqlServer.CreateAndPopulateDB;
import service.InsuranceService;

@RestController
public class InsuranceController {

	@Autowired
	InsuranceService ins;
	
	@CrossOrigin(origins="http://localhost:8100")
	@RequestMapping(value="/getAllInsurances",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Insurance> getInsurances() throws Exception{
		CreateAndPopulateDB capDB = new CreateAndPopulateDB();
		CreateAndPopulateDB.checkOrCreateTable(capDB);
		
		List<Insurance> listInsurance = ins.getAllInsurances();
		return listInsurance;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(value = "/getInsurance/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Insurance getInsuranceById(@PathVariable int id) {  
	  return ins.getInsurance(id);  
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/addInsurance", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addInsurance(@RequestBody Insurance Insurance) {  
	  ins.addInsurance(Insurance);  
	    
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/updateInsurance", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updateInsurance(@RequestBody Insurance Insurance) {  
	  ins.updateInsurance(Insurance);  
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/deleteInsurance/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteInsurance(@PathVariable("id") int id) {  
	  ins.deleteLEnd(id);;    
	 }   

}
