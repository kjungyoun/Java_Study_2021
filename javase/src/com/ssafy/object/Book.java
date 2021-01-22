package com.ssafy.object;

public class Book {
	private String isbn;
	private String title;
    private	String author;
	private String publisher;
	private int price;
	private String desc;
	
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
		if(price >-1)
		this.price = price;
		else System.out.println("책의 가격을 0원 이상으로 설정해주세요.");
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Book() { // 인자가 다른 생성자 호출함
		this("11","ssafy", "ssafy","멀캠",10000,"화이팅");
	}
	
	public Book(String isbn, String title, String author, String publisher, int price, String desc) {
		// this : 현재 사용하는 객체를 가리킴
		// 		1. 속성과 로컬 변수의 이름이 동일할 때 구별해주기 위해 속성 앞에 this.을 붙임
		//		2. 로컬 변수의 이름과 속성의 이름이 다를 경우 this를 굳이 사용할 필요X
		//		3. 코드 재사용을 위해 인자가 다른 생성자를 호출할 때 this([인자])로 사용
		//		4. 현재 사용중인 객체를 필요로 할 때 this 사용
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.publisher = publisher;
		this.price = price;
		this.desc = desc;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isbn).append("\t|").append(title).append(" ").append("\t|").append(author).append("\t|")
				.append(publisher).append("\t|").append(price).append("\t|")
				.append(desc);
		return builder.toString();
	}
	
	public boolean equals(Book book) { 
		// 현재 사용중인 객체를 필요로 할 때 사용한 this
		return this == book;
	}
}
