package com.aowin.objectarray;

public class Book {
	private String name;
	private double price;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Book(String name, double price) {
		this.name = name;
		this.price = price;
	}
	@Override
	public String toString() {
		return "����:"+name+"\n�۸�:"+price;
	}
	
}
