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
	
}
