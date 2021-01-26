package com.ssafy.object;

public class Product {
	private int num;
	private String name;
	private int price;
	private int stuck;
	
	public Product() {
		this(1000, "상품 이름", 100000, 10);
	}

	public Product(int num, String name, int price, int stuck) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stuck = stuck;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		if(num>-1) this.num = num;
		else System.out.println("0보다 큰 수를 입력하시오");
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
		this.price = price;
	}

	public int getStuck() {
		return stuck;
	}

	public void setStuck(int stuck) {
		this.stuck = stuck;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Product [num=").append(num).append(", name=").append(name).append(", price=").append(price)
				.append(", stuck=").append(stuck).append("]");
		return builder.toString();
	}
	
	
	
	
}
