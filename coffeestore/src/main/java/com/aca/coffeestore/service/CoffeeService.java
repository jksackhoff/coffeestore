package com.aca.coffeestore.service;

import java.util.List;

import com.aca.coffeestore.dao.CoffeeDao;
import com.aca.coffeestore.dao.CoffeeDaoImpl;
import com.aca.coffeestore.dao.CoffeeDaoMock;
import com.aca.coffeestore.model.Coffee;
import com.aca.coffeestore.model.FlavorWheel;
import com.aca.coffeestore.model.Process;
import com.aca.coffeestore.model.RequestError;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;



public class CoffeeService {

	private CoffeeDao coffeeDao = new CoffeeDaoImpl();
	
	public List<Coffee> getProducts() {
		return coffeeDao.getProducts();
	}
	
	public List<Coffee> getCoffeesByProcess(Process process) {
		return coffeeDao.getCoffeesByProcess(process);
	}
	
	public List<Coffee> getProductsByFlavorWheel(FlavorWheel flavorWheel) {
		return coffeeDao.getProductsByFlavorWheel(flavorWheel);
	}

	public List<Coffee> getCoffeesByOrigin(String origin) {
		return coffeeDao.getCoffeesByOrigin(origin);
	}
	
	public List<Coffee> getCoffeesById(int id) {
		return coffeeDao.getCoffeesById(id);
	}
	
	public Coffee deleteCoffee(int id) {
		List <Coffee> coffees = coffeeDao.getCoffeesById(id);
		if (coffees.size() == 1) {
			return coffeeDao.deleteCoffeeById(id);
		} else {
			RequestError error = new RequestError(5, 
					"Coffee id does not exist: '" + id + "'");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}		
		
	}
	
	public Coffee updateCoffee(Coffee coffee) {
		List <Coffee> coffees = coffeeDao.getCoffeesById(coffee.getId());
		if (coffees.size() == 1) {
			return coffeeDao.updateCoffee(coffee);
		} else {
			RequestError error = new RequestError(4, 
					"Coffee id does not exist: '" + coffee.getId() + "'");
			Response response = Response.status(400)
					.entity(error)
					.build();
			throw new WebApplicationException(response);
		}			
	}
	
	public Coffee createCoffee(Coffee coffee) {
		return coffeeDao.createCoffee(coffee);
	}

	public List<Coffee> getCoffeesByQuizSearch() {
		// TODO Auto-generated method stub
		return coffeeDao.getCoffeesByQuizSearch();
	}
}
