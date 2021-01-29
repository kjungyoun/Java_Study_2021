package com.ssafy.workshop.fileIO;

public class Magazine extends Book{
	private int year;
	private int month;
	public Magazine() {}
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int quantity,int year, int month) {
		super(isbn, title, author, publisher, price, desc,quantity);
		this.year = year;
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		if(month>0 && month<13)
		this.month = month;
		else throw new BookException("월을 다시 입력하세요");
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("\t,").append(year).append("\t,").append(month);
		return builder.toString();
	}
	
	
}
