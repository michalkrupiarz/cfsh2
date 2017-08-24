package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import bean.Checkout;
import hsqlServer.CreateAndPopulateDB;
import service.CheckoutService;

@RestController
public class CheckoutController {
	@Autowired
	CheckoutService checkoutService;
	
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value="/getAllCheckouts",method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Checkout>getCheckouts() throws Exception{
		List<Checkout> listOfCheckouts = checkoutService.getAllCheckouts();
		return listOfCheckouts;
	}
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value = "/getCheckout/{id}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public Checkout getCheckoutById(@PathVariable int id) {  
	  return checkoutService.getCheckout(id);  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/addCheckout", method = RequestMethod.POST, headers = "Accept=application/json")  
	 public void addCheckout(@RequestBody Checkout checkout) {  
	  checkoutService.addCheckout(checkout);  
	    
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/updateCheckout", method = RequestMethod.PUT, headers = "Accept=application/json")  
	 public void updateCheckout(@RequestBody Checkout checkout) {  
	  checkoutService.updateCheckout(checkout);  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	 @RequestMapping(value = "/deleteCheckout/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")  
	 public void deleteCheckout(@PathVariable("id") int id) {  
	  checkoutService.deleteCheckout(id);    
	 } 
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value = "/getPendingCheckouts", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<Checkout> getPendingCheckouts() {  
	  return checkoutService.getPendingCheckouts();  
	 }  
	@CrossOrigin(origins = "http://localhost:8800")
	@RequestMapping(value = "/getCheckoutsUpcomingIn/{days}", method = RequestMethod.GET, headers = "Accept=application/json")  
	 public List<Checkout> getCheckoutsUpcomingIn(@PathVariable int days) {  
	  return checkoutService.getCheckoutsUpcomingIn(days);  
	 }  
}
