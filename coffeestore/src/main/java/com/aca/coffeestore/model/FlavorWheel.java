package com.aca.coffeestore.model;

public enum FlavorWheel {
	Bright, Floral, Fruity, Nutty, Sweet;
	
	public static FlavorWheel convertStringToFlavorWheel(String value) {
		FlavorWheel myFlavor = null;
		for (FlavorWheel flavor : FlavorWheel.values()) {
			if (flavor.toString().equalsIgnoreCase(value)) {
				myFlavor = flavor;
			}
		}
		return myFlavor;
	}
}
