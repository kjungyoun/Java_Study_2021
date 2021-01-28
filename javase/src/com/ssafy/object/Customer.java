package com.ssafy.object;

public class Customer {
	private String name;
	private String address;
	private int age;
	public Customer() {} // 기본 생성자가 없으면 자식의 대부분의 생성자에 에러가 난다.
	// 자식이 어떤 생성자로 객체를 생성하던 객체 생성 시점에 부모 속성이 상속 되므로 부모 속성의 초기화가 필요
	// 따라서 부모측에 기본 생성자를 선언해 놓는다.
	public Customer(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		if(age>-1) {
			this.age = age;
		}else {
			System.out.println("나이는 0 이상으로 설정해 주세요.");
		}
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Customer name=").append(name)
		.append(", address=").append(address).append(", age=").append(age);
				
		return builder.toString();
	}

	
	
	
	
	
	
}
