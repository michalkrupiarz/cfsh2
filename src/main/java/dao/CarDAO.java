package dao;


import java.util.Calendar;
import java.util.List;
import java.util.List;

import javax.swing.plaf.synth.SynthSeparatorUI;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dao.GeneralQuerrys;

import bean.Car;
import bean.Checkout;
import bean.Document;
import bean.Insurance;
import bean.Repair;
import bean.Tire;
import bean.carLend;  
  
@Repository 
@Transactional
public class CarDAO {  
  
 @Autowired  
 private SessionFactory sessionFactory;  
 
 public void setSessionFactory(SessionFactory sf) {  
  this.sessionFactory = sf;  
 }  
  
 public List<Car> getAllCars() {  
  Session session = this.sessionFactory.getCurrentSession();  
  ReusableDaos rDao = new ReusableDaos();
  Car c = new Car();
  List<Car> carList= (List<Car>) rDao.getAllWithOrderBy(c.getClass(), session, " c order by c.id");
  carList = setAllSubList(carList);
  
  return carList;  
 }  
  /**
  * 
  * @return List of Cars that repairs are not null
  */
 public List<Car> getAllCarsWithPendingRepairs(){
	 Session s = this.sessionFactory.getCurrentSession();
	 ReusableDaos rDao = new ReusableDaos();
	 Car c = new Car();
	 String name = "car";
	 String joinPart =  "join fetch car.repairs r "+
	    				"join  fetch r.status s ";
	 String wereClause = "where s.id = 2";
	 List<Car> carList = (List<Car>) rDao.getPendingActivities(c.getClass(), s, joinPart, wereClause,name);
	 carList = setAllSubList(carList); 
	 return carList;
 }
  
 public List<Car> getAllCarsWithRepairs(){
	 Session s = this.sessionFactory.getCurrentSession();
	 ReusableDaos rDao = new ReusableDaos();
	 Car c = new Car();
	 String name = "car";
	 String joinPart = "join fetch car.repairs";
	 List<Car> carList = (List<Car>) rDao.getCarsWithSubClass(c.getClass(), s, joinPart, name);
	 carList = setAllSubList(carList);
	 return carList;
 }
 
 public List<Car> getAllCarsWithPendingTires(){
	 Session s = this.sessionFactory.getCurrentSession();
	 ReusableDaos rDao = new ReusableDaos();
	 Car c = new Car();
	 String name = "car";
	 String joinPart =  "join fetch car.tires t "+
	    				"join  fetch t.status s ";
	 String wereClause = "where s.id = 2";
	 List<Car> carList = (List<Car>) rDao.getPendingActivities(c.getClass(), s, joinPart, wereClause,name);
	 carList = setAllSubList(carList); 
	 return carList;
 } 
 
 public List<Car> getAllCarsWithTires(){
	 Session s = this.sessionFactory.getCurrentSession();
	 ReusableDaos rDao = new ReusableDaos();
	 Car c = new Car();
	 String name = "car";
	 String joinPart = "join fetch car.tires";
	 List<Car> carList = (List<Car>) rDao.getCarsWithSubClass(c.getClass(), s, joinPart, name);
	 carList = setAllSubList(carList);
	 return carList;
 }
 
 public Car getCar(int id) {  
  Session session = this.sessionFactory.getCurrentSession();  
  Car car = (Car) session.get(Car.class, new Integer(id)); 
  return car;  
 }  
  
 public Car addCar(Car car) {  
  Session session = this.sessionFactory.getCurrentSession();
  car.setId(GeneralQuerrys.maxIdFromTable("select max(cars.id) from Car cars",session)); 
  System.out.println(car.toString());
  session.merge(car);  
  return car;  
 }  
  
 public void updateCar(Car car) {  
  Session session = this.sessionFactory.getCurrentSession();  
  session.update(car);  
 }  
  
 public void deleteCar(int id) {  
 
  Session session = this.sessionFactory.getCurrentSession();  
  Car p = (Car) session.load(Car.class, new Integer(id));  
  System.out.println(p.getCarName());
  if (null != p) {  
   session.delete(p);  
  }  
 }
  
public List<Car> getAllCarsWithPendingCheckouts() {
	Session s = this.sessionFactory.getCurrentSession();
	 ReusableDaos rDao = new ReusableDaos();
	 Car c = new Car();
	 String name = "car";
	 String joinPart =  "join fetch car.check c "+
	    				"join  fetch c.status s ";
	 String wereClause = "where s.id = 2";
	 List<Car> carList = (List<Car>) rDao.getPendingActivities(c.getClass(), s, joinPart, wereClause,name);
	 carList = setAllSubList(carList); 
	return carList;
}

public List<Car> getAllCarsWithPendingInsurances() {
	Session s = this.sessionFactory.getCurrentSession();
	 ReusableDaos rDao = new ReusableDaos();
	 Car c = new Car();
	 String name = "car";
	 String joinPart =  "join fetch car.insurances i "+
	    				"join  fetch i.status s ";
	 String wereClause = "where s.id = 2";
	 List<Car> carList = (List<Car>) rDao.getPendingActivities(c.getClass(), s, joinPart, wereClause,name);
	 carList = setAllSubList(carList); 
	return carList;
}

	public List<Car> getAllCarsLendsFree(Session s) {
	 //Session s = this.sessionFactory.getCurrentSession();
	 ReusableDaos rDao = new ReusableDaos();
	 Car c = new Car();
	 String name = "car";
	 String joinPart =  "left join car.lends l "
	 		+ "left join l.status s ";
	 String wereClause = "where s.id!=2 or s.id is null";
	 List<Car> carList = (List<Car>) rDao.getPendingActivities(c.getClass(), s, joinPart, wereClause,name);
	 carList = setAllSubList(carList); 
	 return carList;	
}

	public List<Car> getAllCarsLendsTaken(Session s) {
	//Session s = this.sessionFactory.getCurrentSession();
	 ReusableDaos rDao = new ReusableDaos();
	 Car c = new Car();
	 String name = "car";
	 String joinPart =  "join fetch car.lends l "+
	    				"join  fetch l.status s ";
	 String wereClause = "where s.id = 2";
	 List<Car> carList = (List<Car>) rDao.getPendingActivities(c.getClass(), s, joinPart, wereClause,name);
	 carList = setAllSubList(carList); 
	 return carList;	
	}
	
	public List<Car> getAllFreeCars(){
		Session s = this.sessionFactory.getCurrentSession();
		 ReusableDaos rDao = new ReusableDaos();
		 Car c = new Car();
		 Calendar currDate = Calendar.getInstance();
		 String name = "car";
		 String joinPart =  "join fetch car.lends l ";
		 String wereClause = "where l.lendend < "+currDate;
		 List<Car> carList = (List<Car>) rDao.getPendingActivities(c.getClass(), s, joinPart, wereClause,name);
		 carList = setAllSubList(carList); 
		 return carList;	
	}
	public List<Car> getAllTakenCars(){
		Session s = this.sessionFactory.getCurrentSession();
		 ReusableDaos rDao = new ReusableDaos();
		 Car c = new Car();
		 Calendar currDate = Calendar.getInstance();
		 String name = "car";
		 String joinPart =  "join fetch car.lends l ";
		 String wereClause = "where l.lendend > "+currDate;
		 List<Car> carList = (List<Car>) rDao.getPendingActivities(c.getClass(), s, joinPart, wereClause,name);
		 carList = setAllSubList(carList); 
		 return carList;	
	}
	private List<Car> setAllSubList(List<Car> carList) {
	 for (Car c : carList){
		 System.out.println(c.getRepairs());
		 List<Repair> reps = c.getRepairs();	
		 for (Repair r:reps ) {
			 System.out.println(r.getStatus());
		 }
		 System.out.println(c.getLends());
		 List <carLend> cLends = c.getLends();
		 for (carLend lend:cLends) {
			 System.out.println(lend.getStatus());
		 }
		 System.out.println(c.getInsurances());
		 List<Insurance> insurances = c.getInsurances();
		 for(Insurance insurance:insurances) {
			 System.out.println(insurance.getStatus());
		 }
		 System.out.println(c.getTires());
		 List <Tire> tires = c.getTires();
		 for (Tire tire:tires) {
			 System.out.println(tire.getStatus());
		 }
		 System.out.println(c.getDoc());
		 List<Document> documents = c.getDoc();
		 for (Document d:documents) {
			 System.out.println(d.getStatus());
		 }
		 System.out.println(c.getCheck());
		 List<Checkout> checks = c.getCheck();
		 for(Checkout ch:checks) {
			 System.out.println(ch.getStatus());
		 }
	 }
	return carList;
	}
	
}
