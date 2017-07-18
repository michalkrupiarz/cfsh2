package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bean.Checkout;
import dao.CheckoutDao;

@Service("checkoutService")
@Transactional
public class CheckoutService {
	@Autowired
	CheckoutDao checkoutDao;
	
	@Transactional
	public List<Checkout> getAllCheckouts() {
		return checkoutDao.getAllCheckouts();
	}
	@Transactional
	public Checkout getCheckout(int id) {
		return checkoutDao.getCheckout(id);
	}
	@Transactional
	public void addCheckout(Checkout checkout) {
		checkoutDao.addCheckout(checkout);
		
	}
	@Transactional
	public void updateCheckout(Checkout checkout) {
		checkoutDao.updateCheckout(checkout);
		
	}

	public void deleteCheckout(int id) {
		checkoutDao.deleteCheckout(id);		
	}
	
}
