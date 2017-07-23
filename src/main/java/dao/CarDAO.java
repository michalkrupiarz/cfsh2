package dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
  List<Car> carList = session.createQuery("from Car").list();  
  for (Car c : carList){
		 System.out.println(c.getRepairs());
		 Set<Repair> reps = c.getRepairs();	
		 for (Repair r:reps ) {
			 System.out.println(r.getStatus());
		 }
		 System.out.println(c.getLends());
		 Set <carLend> cLends = c.getLends();
		 for (carLend lend:cLends) {
			 System.out.println(lend.getStatus());
		 }
		 System.out.println(c.getInsurances());
		 Set<Insurance> insurances = c.getInsurances();
		 for(Insurance insurance:insurances) {
			 System.out.println(insurance.getStatus());
		 }
		 System.out.println(c.getTires());
		 Set <Tire> tires = c.getTires();
		 for (Tire tire:tires) {
			 System.out.println(tire.getStatus());
		 }
		 System.out.println(c.getDoc());
		 Set<Document> documents = c.getDoc();
		 for (Document d:documents) {
			 System.out.println(d.getStatus());
		 }
		 System.out.println(c.getCheck());
		 Set<Checkout> checks = c.getCheck();
		 for(Checkout ch:checks) {
			 System.out.println(ch.getStatus());
		 }
	 }
  return carList;  
 }  
 /**
  * 
  * @return List of Cars that repairs are not null
  */
 public List<Car> getAllCarsWithRepairs(){
	 Session s = this.sessionFactory.getCurrentSession();
	 	 
	 List<Car> carList = s.createQuery("select distinct car from Car car "
		+ "join car.repairs").list();
	 
	 for (Car c : carList){
		 System.out.println(c.getRepairs());
		 System.out.println(c.getLends());
	 }
	 
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
}  
