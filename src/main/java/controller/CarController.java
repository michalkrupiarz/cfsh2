package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Car;
import hsqlServer.CreateAndPopulateDB;
import service.CarService;

@RestController
public class CarController {

	@Autowired
	CarService carService;
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/getAllCars",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Car>getCars() throws Exception{
		List<Car> listOfCars = carService.getAllCars();
		return listOfCars;
	}
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/getAllCarsWithPendingRepairs",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Car> getCarsWithPendingRepairs() throws Exception{
		List<Car>lOC = carService.getAllCarsWithPendingRepairs();
		return lOC; 
	}
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/getAllCarsWithRepairs",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Car> getCarsWithRepairs() throws Exception{
		List<Car>lOC = carService.getAllCarsWithRepairs();
		return lOC; 
	}
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/getAllCarsWithPendingTires",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Car> getCarsWithPendingTires() throws Exception{
		List<Car>lOC = carService.getAllCarsWithPendingTires();
		return lOC; 
	}
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/getAllCarsWithTires",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Car> getCarsWithTires() throws Exception{
		List<Car>lOC = carService.getAllCarsWithTires();
		return lOC; 
	}
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value = "/getCar/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Car getCarById(@PathVariable("id") int id) {  
	  return carService.getCar(id);  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/addCar", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addCar(@RequestBody Car car) {  
	  carService.addCar(car);  
	    
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/updateCar", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updateCar(@RequestBody Car car) {  
	  carService.updateCar(car);  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/deleteCar/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteCar(@PathVariable("id") int id) {  
	  carService.deleteCar(id);    
	 }   
	@CrossOrigin(origins = "http://loclahost:8800")
	@RequestMapping(value = "/sortCarsBy/{value}", method = RequestMethod.GET,  headers = "Accept=application/json")
	public List<Car> getSortedCarsByValue(@PathVariable("value") String value){
		return carService.getFilteredCarsByValue(value);
	}
	
}
