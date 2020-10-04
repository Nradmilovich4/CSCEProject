package com.bc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
/**
 * CSCE 156
 * 
 * Authors: Caden Kirby Nick Radmilovich
 * 
 * 10/1/2020
 * 
 * Description: The Products class is a superclass to Rental, Repair, Towing, and Concessions.  It is used by the invoice class
 * to store information about the products offered by BumprCars.
 */
public abstract class Products {
	
	protected String productCode;
	protected String productType;
	protected String productLabel;
	protected double workValue;
	
	// Constructor
	public Products(String productCode, String productType, String productLabel, double workValue) {
		super();
		this.productCode = productCode;
		this.productType = productType;
		this.productLabel = productLabel;
		this.workValue = workValue;
		
	}
	public Products() {
		super();
	}

	// Getters and Setters
	public String getProductCode() {
		return productCode;
	}

	public String getProductType() {
		return productType;
	}


	public String getProductLabel() {
		return productLabel;
	}

	public double getWorkValue() {
		return workValue;
	}
	
	// Added a hashmap conversion for invoices.
	public static HashMap<String,Products> productMap(ArrayList<Products> list){
		HashMap<String,Products> map = new HashMap<String,Products>();
		for(Products p: list) {
			map.put(p.getProductCode(),p);
		}
		return map;
	}
	// Creates an arraylist of Products based on input file.
	public static ArrayList<Products> importProducts(String filename){
	ArrayList<Products> products  = new ArrayList<Products>();
	
	Scanner s;
	String file = "data/" + filename;
	try {
		
		s = new Scanner(new File(file));
		int productNum = Integer.parseInt(s.nextLine());
		while (s.hasNext()) {
			
			String[] tokens = s.nextLine().split(";");
			
			if (tokens[1].compareTo("R") == 0) {
				Rental r = null;
				r = new Rental(tokens[0], tokens[1], tokens[2], 0.0, Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]), Double.parseDouble(tokens[5]));		
				products.add(r);
				
			} else if (tokens[1].compareTo("F") == 0) {
				Repair f = null;
				f = new Repair(tokens[0], tokens[1], tokens[2], 0.0, Double.parseDouble(tokens[3]), Double.parseDouble(tokens[4]));		
				products.add(f);
				
			} else if (tokens[1].compareTo("C") == 0) {
				Concession c = null;
				c = new Concession(tokens[0], tokens[1], tokens[2], 0.0, Double.parseDouble(tokens[3]));		
				products.add(c);
				
			} else if (tokens[1].compareTo("T") == 0) {
				Towing t = null;
				t = new Towing(tokens[0], tokens[1], tokens[2], 0.0, Double.parseDouble(tokens[3]));		
				products.add(t);
				
			}
			
		}
		s.close();
		
	} catch(FileNotFoundException e) {
		System.err.print("File not Found");
		e.printStackTrace();
	}
	return products;
	}
	
	// Creates a deep copy of a Products, based on the input type
	public static Products deepCopy(Products oldProd, double workVal) {
		Products newProd = null;
		if(oldProd instanceof Rental) {
			Rental old = (Rental) oldProd;
			newProd = new Rental(old, workVal);
		}else if(oldProd instanceof Towing) {
			Towing old = (Towing) oldProd;
			newProd = new Towing(old, workVal);
		}else if(oldProd instanceof Repair) {
			Repair old = (Repair) oldProd;
			newProd = new Repair(old,workVal);
		}else {
			Concession old = (Concession) oldProd;
			newProd = new Concession(old,workVal);
		}return newProd;
	}
	
	// Product Calculations
	public abstract double getSubtotal();
	public abstract double getDiscounts(int freeFlag);
	public abstract double getTotal();
	public abstract String costPrint();
	public abstract String feePrint();
	public static void associatedRepairCheck(ArrayList<Products> potentials, ArrayList<Products> products, String repairVal) {
		
	}
	

	}
