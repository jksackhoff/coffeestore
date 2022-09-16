package com.aca.coffeestore.dao;

import java.util.ArrayList;
import java.util.List;

import com.aca.coffeestore.model.Coffee;
import com.aca.coffeestore.model.FlavorWheel;
import com.aca.coffeestore.model.Process;

public class CoffeeDaoMock implements CoffeeDao {

	private static List<Coffee> products = new ArrayList<Coffee>();
	
	static {
		Coffee pinnacle = new Coffee();
		pinnacle.setName("Pinnacle");
		pinnacle.setProductId(1);
		pinnacle.setOrigin("blend");
		pinnacle.setProcess(Process.Natural);
		pinnacle.setElevation(1200);
		pinnacle.setFlavor(FlavorWheel.Nutty);
		pinnacle.setPrice(11.00);
		pinnacle.setDescription("Sweet toffee, brown sugar, pecan");
		
		Coffee ouachita = new Coffee();
		ouachita.setName("Ouachita");
		ouachita.setProductId(2);
		ouachita.setOrigin("blend");
		ouachita.setProcess(Process.Natural);
		ouachita.setElevation(1200);
		ouachita.setFlavor(FlavorWheel.Sweet);
		ouachita.setPrice(12.00);
		ouachita.setDescription("berries, orange, caramel");
		
		Coffee brazil = new Coffee();
		brazil.setName("Brazil");
		brazil.setProductId(3);
		brazil.setOrigin("Brazil");
		brazil.setProcess(Process.Natural);
		brazil.setElevation(1100);
		brazil.setFlavor(FlavorWheel.Nutty);
		brazil.setPrice(11.00);
		brazil.setDescription("Nutty, chocolate, sweet");
		
		Coffee decaf = new Coffee();
		decaf.setName("Decaf");
		decaf.setProductId(4);
		decaf.setOrigin("Honduras");
		decaf.setProcess(Process.Washed);
		decaf.setElevation(1250);
		decaf.setFlavor(FlavorWheel.Nutty);
		decaf.setPrice(12.00);
		decaf.setDescription("Brown sugar, almond, raisin");
		
		Coffee ethiopia = new Coffee();
		ethiopia.setName("Ethiopia");
		ethiopia.setProductId(5);
		ethiopia.setOrigin("Ethiopia");
		ethiopia.setProcess(Process.Washed);
		ethiopia.setElevation(1800);
		ethiopia.setFlavor(FlavorWheel.Bright);
		ethiopia.setPrice(18.00);
		ethiopia.setDescription("Strawberry, orange marmalade, floral");
		
		Coffee guatemala = new Coffee();
		guatemala.setName("Guatemala");
		guatemala.setProductId(6);
		guatemala.setOrigin("Guatemala");
		guatemala.setProcess(Process.Honey);
		guatemala.setElevation(1300);
		guatemala.setFlavor(FlavorWheel.Fruity);
		guatemala.setPrice(14.00);
		guatemala.setDescription("cocoa, vanilla, caramel, blackberry");
		
		Coffee honduras = new Coffee();
		honduras.setName("Honduras");
		honduras.setProductId(7);
		honduras.setOrigin("Honduras");
		honduras.setProcess(Process.Natural);
		honduras.setElevation(1450);
		honduras.setFlavor(FlavorWheel.Fruity);
		honduras.setPrice(13.00);
		honduras.setDescription("Caramel, pear, blueberry, pecan");
		
		products.add(pinnacle);
		products.add(ouachita);
		products.add(brazil);
		products.add(decaf);
		products.add(ethiopia);
		products.add(guatemala);
		products.add(honduras);
		
	}
	
	
	@Override
	public List<Coffee> getProducts() {
		List<Coffee> myProducts = new ArrayList<Coffee>();
		myProducts.addAll(products);
		return myProducts;
	}



	@Override
	public List<Coffee> getProductsByFlavorWheel(FlavorWheel flavorWheel) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Coffee> getCoffeesByProcess(Process process) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Coffee> getCoffeesByOrigin(String origin) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Coffee> getCoffeesById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Coffee deleteCoffeeById(int id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Coffee updateCoffee(Coffee updateCoffee) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Coffee createCoffee(Coffee coffee) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<Coffee> getCoffeesByQuizSearch() {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public List<Coffee> getCoffeesByProcess(Process process) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//
//
//	@Override
//	public List<Coffee> getCoffeesByProcess(Process process) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	
	
}
