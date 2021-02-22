package com.test;

/**
 * 잡지 정보를 나타내는 클래스
 * Book 클래스를 상속 받음
 */
public class Magazine extends Book{
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
		super(isbn,title,author,publisher,price,desc,quantity);
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
		if(month>0 && month <13)
		this.month = month;
		else throw new BookException("1에서 12 사이의 월을 입력하시오");
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(super.toString());
		builder.append("\t|");
		builder.append(year + "\t| ");
		builder.append(month);
		return builder.toString();
	}
}
