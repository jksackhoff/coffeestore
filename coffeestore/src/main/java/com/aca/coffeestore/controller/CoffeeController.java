package com.aca.coffeestore.controller;

import java.util.List;

import com.aca.coffeestore.model.Coffee;
import com.aca.coffeestore.model.FlavorWheel;
import com.aca.coffeestore.service.CoffeeService;
import com.aca.coffeestore.model.Process;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/coffee")
public class CoffeeController {

	private CoffeeService service = new CoffeeService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coffee> getProducts() {
		return service.getProducts();
	}
	
	@GET
	@Path("/{coffeeIdValue}")
	public List<Coffee> getCoffeesById(@PathParam("coffeeIdValue")int id) {
		System.out.println("coffee id: " + id);
		return service.getCoffeesById(id);
	}

	
	@GET
	@Path("/process/{processValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coffee> getCoffeesByProcess(@PathParam("processValue") Process process) {
		System.out.println("process: " + process);
		return service.getCoffeesByProcess(process);
	}
	
	@GET
	@Path("/flavorwheel/{flavorWheelValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coffee> getProductsByFlavorWheel(@PathParam("flavorWheelValue") FlavorWheel flavorWheel) {
		System.out.println("Flavor wheel: " + flavorWheel);
		return service.getProductsByFlavorWheel(flavorWheel);
	}
	
	@GET
	@Path("/origin/{originValue}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Coffee> getCoffeesByOrigin(@PathParam("originValue") String origin) {
		System.out.println("Origin: " + origin);
		return service.getCoffeesByOrigin(origin);
	}
	
	@DELETE
	@Path("/{coffeeIdValue}")
	public Coffee deleteCoffee(@PathParam("coffeeIdValue") int id) {
		System.out.println("coffeeId: " + id);
		return service.deleteCoffee(id);
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Coffee updateCoffee(Coffee coffee) {
		System.out.println(coffee);
		return service.updateCoffee(coffee);
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Coffee createCoffee(Coffee coffee) {
		System.out.println(coffee);
		return service.createCoffee(coffee);
	}
	
	@GET
	@Path("/quizsearch")	
	public List<Coffee> getCoffeesByQuizSearch(
			@QueryParam("bright") String bright,
			@QueryParam("floral") String floral,
			@QueryParam("fruity") String fruity,
			@QueryParam("nutty") String nutty,
			@QueryParam("sweet") String sweet,
			@QueryParam("natural") String natural,
			@QueryParam("washed") String washed,
			@QueryParam("honey") String honey
			) {
		
		System.out.println("bright: " + bright);		
		
		return service.getProducts();
	}
	
}
