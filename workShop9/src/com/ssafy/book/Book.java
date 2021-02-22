package com.ssafy.book;

import java.io.Serializable;

/*도서 정보를 나타내는 클래스
   encapsulation
   constructor
   getter, setter
   toString
     직렬화 객체
 */
//VO. DOMAIN 객체
public class Book  implements Serializable, Comparable<Book> {	
	
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
		this.price = price;
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
		this.quantity = quantity;
	}
	/**
	 * 도서의 정보를 문자열로 반환한다
	 * @return 도서정보
	 */
	public String toString() {
		return isbn + '\t' + "- " + title + "  \t" + "- " + author + '\t' + "- " + publisher + '\t'
				+ "- " + price + '\t' + "- " + desc + '\t'+ "- " + quantity + '\t';
	}
	
	@Override
	public int compareTo(Book o) {
		return isbn.compareTo(o.isbn);
	}
}



















