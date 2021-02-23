package com.promineotech.storeApp.util;

public enum Price {

	LARGE(39.99),
	MED(23.99),
	SMALL(19.99);
	
	private double size;
	
	Price(double size){
		this.size = size;
	}
	
	public double getPriceFromSize() {
		return size;
	}
}
