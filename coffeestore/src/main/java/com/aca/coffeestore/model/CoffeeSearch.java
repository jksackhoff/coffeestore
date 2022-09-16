package com.aca.coffeestore.model;

import jakarta.ws.rs.QueryParam;

public class CoffeeSearch {

	private String bright;
	private String floral;
	private String fruity;
	private String nutty;
	private String sweet;
	private String natural;
	private String washed;
	private String honey;
	
	 public String getBright() {
		return bright;
	}
	public void setBright(String bright) {
		this.bright = bright;
	}
	public String getFloral() {
		return floral;
	}
	public void setFloral(String floral) {
		this.floral = floral;
	}
	public String getFruity() {
		return fruity;
	}
	public void setFruity(String fruity) {
		this.fruity = fruity;
	}
	public String getNutty() {
		return nutty;
	}
	public void setNutty(String nutty) {
		this.nutty = nutty;
	}
	public String getSweet() {
		return sweet;
	}
	public void setSweet(String sweet) {
		this.sweet = sweet;
	}
	public String getNatural() {
		return natural;
	}
	public void setNatural(String natural) {
		this.natural = natural;
	}
	public String getWashed() {
		return washed;
	}
	public void setWashed(String washed) {
		this.washed = washed;
	}
	public String getHoney() {
		return honey;
	}
	public void setHoney(String honey) {
		this.honey = honey;
	}
	
}
