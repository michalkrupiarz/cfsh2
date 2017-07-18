package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Tire;
import service.TireService;

@RestController
public class TireController {

	@Autowired
	TireService tS;
	
	@CrossOrigin(origins="http://localhost:8100")
	@RequestMapping(value="/getAllTires",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Tire> getTires() throws Exception{
		List<Tire> listTires = tS.getAllTires();
		return listTires;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(value = "/getTires/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Tire getTiresById(@PathVariable int id) {  
	  return tS.getTires(id);  
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/addTires", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addTires(@RequestBody Tire Tires) {  
	  tS.addTires(Tires);  
	    
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/updateTires", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updateTires(@RequestBody Tire Tires) {  
	  tS.updateTires(Tires);  
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/deleteTires/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteTires(@PathVariable("id") int id) {  
	  tS.deleteLEnd(id);   
	 }   

}
