package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Tires;
import service.TiresService;

@RestController
public class TiresController {

	@Autowired
	TiresService tS;
	
	@CrossOrigin(origins="http://localhost:8100")
	@RequestMapping(value="/getAllTires",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Tires> getTires() throws Exception{
		List<Tires> listTires = tS.getAllTires();
		return listTires;
	}
	
	@CrossOrigin(origins = "http://localhost:8100")
	@RequestMapping(value = "/getTires/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Tires getTiresById(@PathVariable int id) {  
	  return tS.getTires(id);  
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/addTires", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addTires(@RequestBody Tires Tires) {  
	  tS.addTires(Tires);  
	    
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/updateTires", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updateTires(@RequestBody Tires Tires) {  
	  tS.updateTires(Tires);  
	 }  
	@CrossOrigin(origins = "http://localhost:8100")
	 @RequestMapping(value = "/deleteTires/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteTires(@PathVariable("id") int id) {  
	  tS.deleteLEnd(id);   
	 }   

}
