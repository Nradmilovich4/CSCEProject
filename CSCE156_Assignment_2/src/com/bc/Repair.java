package com.bc;

import java.util.ArrayList;

public class Repair extends Products{
	
	private Double partsCost;
	private Double hourlyLaborCost;
	
	// Constructor
	public Repair(String productCode, String productType, String productLabel, double workVal,Double partsCost,
			Double hourlyLaborCost) {
		super(productCode, productType, productLabel, workVal);
		this.partsCost = partsCost;
		this.hourlyLaborCost = hourlyLaborCost;
	}
	public Repair() {
		super();
	}
	// Copy Constructor
	public Repair(Repair old, double workVal) {
		super();
		this.productCode = old.getProductCode();
		this.productType = old.getProductType();
		this.productLabel = old.productLabel;
		this.workValue = workVal;
		this.partsCost = old.partsCost;
		this.hourlyLaborCost = old.hourlyLaborCost;
	}

	// Getters and Setters
	public Double getPartsCost() {
		return partsCost;
	}

	public void setPartsCost(Double partsCost) {
		this.partsCost = partsCost;
	}

	public Double getHourlyLaborCost() {
		return hourlyLaborCost;
	}

	public void setHourlyLaborCost(Double hourlyLaborCost) {
		this.hourlyLaborCost = hourlyLaborCost;
	}

	// Price Calculations
	@Override
	public double getSubtotal() {
		return this.partsCost + (this.hourlyLaborCost * this.workValue);
	}

	@Override
	public double getTotal() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getDiscounts(int freeFlag) {
		return 0;
	}
	public String costPrint() {	
		String out = " ("+ this.workValue + " hours of labor @ $" + this.getHourlyLaborCost() + "/hour)";
		return out;
	}
	public String feePrint() {
		String fees = "(+ $" + this.getPartsCost() + " for parts)";
		return fees;
	}
	public static void associatedRepairCheck(ArrayList<Products> potentials, ArrayList<Products> products, String repairVal) {
		
	}
}
