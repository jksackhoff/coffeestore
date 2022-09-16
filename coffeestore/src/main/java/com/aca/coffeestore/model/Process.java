package com.aca.coffeestore.model;

public enum Process {
	Natural, Washed, Honey;
	
	public static Process convertStringToProcess(String value) {
		Process myProcess = null;
		for (Process process : Process.values()) {
			if (process.toString().equalsIgnoreCase(value)) {
				myProcess = process;
			}
		}
		return myProcess;
	}
}
