package com.test;

import java.io.Serializable;

/*도서 정보를 나타내는 클래스
   encapsulation
   constructor
   getter, setter
   toString
     직렬화 객체
 */
//VO. DOMAIN 객체
public class Book implements Serializable,Comparable<Book>{	
	
	 private String isbn;	
	 private String title;	
	 private String author;		
	 private String publisher;
	 private int price;	
	 private String desc;	
	 private int quantity;
	 
	/** 기본 생성자 */
	public Book() {}

	/** 도서 정보를 모두 받아 생성하는 생성자 */
	public Book(String isbn, String title, String author, String publisher, int price, String desc, int quantity) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
		this.quantity = quantity;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price > -1) this.price = price;
		else throw new BookException("0이상의 가격을 입력하세요");
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		if(quantity > -1) this.quantity = quantity;
		else throw new BookException("0이상의 재고를 입력하세요");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isbn).append("\t|").append(title).append("  ").append("\t|").append(author)
				.append("\t|").append(publisher).append("\t|").append(price).append("\t|")
				.append(desc).append("\t|").append(quantity);
		return builder.toString();
	}

	@Override
	public int compareTo(Book o) {
		return this.isbn.compareTo(o.isbn);
	}
}

