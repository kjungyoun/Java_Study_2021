package com.ssafy1;

public class Phone {
	public String name = "Galaxy Note";
	public char color;
	public int price;
	
	public int getSalePrice() {
		if(this.color == 'A') {
			return this.price;
		}else return this.price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getColor() {
		return color;
	}

	public void setColor(char color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRealDebt() {
		return 1000;
	}
	
	public Phone(String name) {
		System.out.println("A");
		System.out.println(this.name);
		this.name = name;
	}
	
	public Phone() {
		System.out.println("B");
		System.out.println(this.name);
	}
	
	public String toString() {
		return this.name + "," + this.price;
	}
}
