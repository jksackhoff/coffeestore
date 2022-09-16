package com.aca.coffeestore.dao;

import java.util.List;
import com.aca.coffeestore.model.Coffee;
import com.aca.coffeestore.model.FlavorWheel;
import com.aca.coffeestore.model.Process;

public interface CoffeeDao {
	
	public List<Coffee> getProducts();
	public List<Coffee> getProductsByFlavorWheel(FlavorWheel flavorWheel);
	public List<Coffee> getCoffeesByProcess(Process process);
	public List<Coffee> getCoffeesByOrigin(String origin);
	public List<Coffee> getCoffeesById(int id);
	public Coffee deleteCoffeeById(int id);
	public Coffee updateCoffee(Coffee updateCoffee);
	public Coffee createCoffee(Coffee coffee);
	public List<Coffee> getCoffeesByQuizSearch();
}
