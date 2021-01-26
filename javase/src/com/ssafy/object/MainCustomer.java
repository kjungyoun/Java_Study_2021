package com.ssafy.object;

public class MainCustomer extends Customer {
	private String hobby;
	public MainCustomer() {
		
	}
	public MainCustomer(String name, String address, int age) {
		//super(name, address, age);
		//this.name = name;
		//this.address = address;
		//this.age = age;
		setName(name);
		setAddress(address);
		setAge(age);
	}
	public MainCustomer(String name, String address, int age, String hobby) {
		this(name, address, age);
		this.hobby = hobby;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append(", hobby=").append(hobby);
		return builder.toString();
	}
	
	
	
}
