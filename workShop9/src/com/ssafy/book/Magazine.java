package com.ssafy.book;

/**
 * 잡지 정보를 나타내는 클래스
 * Book 클래스를 상속 받음
 */
public class Magazine extends Book  {
	/**
	 * 발행년도
	 */
	private int year;
	/**
	 * 발행월
	 */
	private int month;
	
	/** 기본 생성자 */
	public Magazine() {}
	
	/** 잡지 정보 모두를 받아 생성하는 생성자 */
	public Magazine(String isbn, String title, String author, String publisher, int price, String desc, int year, int month,int quantity) {
		super(isbn, title, author, publisher, price, desc, quantity );
		this.year = year;
		this.month= month;
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
		this.month = month;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("|");
		builder.append(year + "\t| ");
		builder.append(month);
		return builder.toString();
	}
}
