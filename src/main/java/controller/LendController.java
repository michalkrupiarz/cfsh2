package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.carLend;
import bean.carLend;
import hsqlServer.CreateAndPopulateDB;
import service.lendService;

@RestController
public class LendController {

	@Autowired
	lendService ls;
	
	@CrossOrigin(origins="http://localhost:8100")
	@RequestMapping(value="/getAllLends",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<carLend> getLends() throws Exception{		
		List<carLend> listLend = ls.getAllLends();
		return listLend;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(value = "/getLend/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public carLend getLendById(@PathVariable int id) {  
	  return ls.getLend(id);  
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/addLend", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addcarLend(@RequestBody carLend carLend) {  
	  ls.addLend(carLend);  
	    
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/updatecarLend", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updatecarLend(@RequestBody carLend carLend) {  
	  ls.updateLend(carLend);  
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/deletecarLend/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deletecarLend(@PathVariable("id") int id) {  
	  ls.deleteLEnd(id);    
	 }   

}
