package dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;  
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import dao.GeneralQuerrys;

import bean.Car;  
  
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
