package service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Car;
import dao.CarDAO;

@Service("carService")
@Transactional
public class CarService {
	@Autowired
	CarDAO carDao;
	
	@Transactional
	public List<Car> getAllCars() {
		return carDao.getAllCars();
	}
	
	@Transactional
	public List<Car> getAllCarsWithPendingRepairs(){
		List<Car> lC = carDao.getAllCarsWithPendingRepairs();
		return lC;
	}
	
	@Transactional
	public List<Car> getAllCarsWithRepairs(){
		List<Car> lC = carDao.getAllCarsWithRepairs();
		return lC;
	}
	
	@Transactional
	public List<Car> getAllCarsWithPendingTires(){
		List<Car> lC = carDao.getAllCarsWithPendingTires();
		return lC;
	}
	
	@Transactional
	public List<Car> getAllCarsWithTires(){
		List<Car> lC = carDao.getAllCarsWithTires();
		return lC;
	}
	@Transactional
	public Car getCar(int id) {
		return carDao.getCar(id);
	}
	@Transactional
	public void addCar(Car car) {
		carDao.addCar(car);
		
	}
	@Transactional
	public void updateCar(Car car) {
		carDao.updateCar(car);
		
	}

	public void deleteCar(int id) {
		carDao.deleteCar(id);		
	}

	public List<Car> getFilteredCarsByValue(String value) {
		String repairs = "repairs";
		String checkouts = "checkouts";
		String insurances = "insurances";
		String tires = "tires";
		String lendsTaken = "taken";
		String lendsFree = "free";
		
		if (value.equals(repairs)) {
			return carDao.getAllCarsWithPendingRepairs();
		} else if (value.equals(checkouts)) {
			return carDao.getAllCarsWithPendingCheckouts();
		} else if (value.equals(insurances)) {
			return carDao.getAllCarsWithPendingInsurances();
		} else if (value.equals(tires)) {
			return carDao.getAllCarsWithPendingTires();
		} else if (value.equals(lendsFree)) {
			return carDao.getAllCarsLendsFree();
		} else if (value.equals(lendsTaken)) {
			return carDao.getAllCarsLendsTaken();
		}
		return null;
	}
	
}
