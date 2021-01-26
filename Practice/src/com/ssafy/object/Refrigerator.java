package com.ssafy.object;

public class Refrigerator {
	private int num;
	private String name;
	private int price;
	private int stuck;
	private int size;
	
	public Refrigerator() {
		this(0000, "냉장고 이름", 99999, 12, 100);
	}

	public Refrigerator(int num, String name, int price, int stuck, int size) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stuck = stuck;
		this.size = size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num>-1) this.num = num;
		else System.out.println("0보다 큰 값을 입력하시오");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price>-1) this.price = price;
		else System.out.println("0보다 큰 값을 입력하시오");
	}

	public int getStuck() {
		return stuck;
	}

	public void setStuck(int stuck) {
		if(stuck>-1) this.stuck = stuck;
		else System.out.println("0보다 큰 값을 입력하시오");
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		if(size>-1) this.size = size;
		else System.out.println("0보다 큰 값을 입력하시오");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Refrigerator [num=").append(num).append(", name=").append(name).append(", price=").append(price)
				.append(", stuck=").append(stuck).append(", size=").append(size).append("]");
		return builder.toString();
	}
	
	
	
	
	
}
