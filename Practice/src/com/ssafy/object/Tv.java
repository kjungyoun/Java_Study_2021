package com.ssafy.object;

public class Tv {
	private int num;
	private String name;
	private int price;
	private int stuck;
	private int inch;
	private String type;
	
	public Tv() {
		this(0000,"제품 등록", 99999, 00, 32, "WQHD");
	}
	
	
	public Tv(int num, String name, int price, int stuck, int inch, String type) {
		this.num = num;
		this.name = name;
		this.price = price;
		this.stuck = stuck;
		this.inch = inch;
		this.type = type;
	}


	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		if(num>-1) this.num = num;
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
		else System.out.println("0보다 큰 값을 입력하세요");
	}
	public int getStuck() {
		return stuck;
	}
	public void setStuck(int stuck) {
		if(stuck>-1) this.stuck = stuck;
		else System.out.println("0보다 큰 값을 입력하세요");
	}
	public int getInch() {
		return inch;
	}
	public void setInch(int inch) {
		if(inch>-1) this.inch = inch;
		else System.out.println("0보다 큰 값을 입력하세요");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("\t").append(num).append("| \t").append(name).append(" ").append("| \t").append(price)
				.append("| \t").append(stuck).append("| \t").append(inch).append("| \t").append(type);
		return builder.toString();
	}
	
	
}
