package com.promineotech.storeApp.util;

public enum MilitaryDiscount {
	
	NONE(.00),
	MILITARY(.10);
	
	private double discount;
	
	MilitaryDiscount(double discount) {
		this.discount = discount;
	}
	
	public double getDiscount() {
		return discount;
	}
	
	

}
