package com.ssafy.workshop.fileIO;

public class Book implements Cloneable{
	private String isbn       ;
	private String title      ;
	private String author     ;
	private String publisher  ;
	private int    price      ;
	private String desc       ;
	private int quantity;
	public Book() {}
	public Book(String isbn, String title, String author, String publisher, int price, String desc ,int quantity) {		//반드시 인자를 받아서 생성하는 것이 아니면 생성하는 것이 좋다.
//		this : 클래스로부터 생성된 객체 중 현재 사용중인 객체를  가리킨다.
//			1. 속성과 로컬변수의 이름이 동일할 떄 구별하기 위해서 속성 앞에 this.을 붙인다.
//			2. 코드 재사용을 위해 인자가 다른 생성자를 호출할  때 this([인자]) - new, this
//			3. 현재 사용중인 객체를 필요로 할 때 this 사용
		
		this.isbn = isbn; // 데이터가 무엇을 뜻하는지 알 수 있다. 구별을 위해 this.을 붙임
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
		if(price > -1) {
			this.price = price;
		}else {
			System.out.println("도서의 가격을 0원 이상으로 설정해 주세요.");
		}
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(isbn).append("\t,").append(title).append("\t,").append(author)
		.append("\t,").append(publisher).append("\t,").append(price).append("\t,")
		.append(desc).append("\t,").append(quantity);
		return builder.toString();
	}
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + ((author == null) ? 0 : author.hashCode());
//		result = prime * result + ((title == null) ? 0 : title.hashCode());
//		return result;
//	}
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof Book) {
			Book book = (Book) obj;
			if(author.equals(book.getAuthor()) && title.equals(book.getTitle())) {
				return true;
			}
		}return false;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	protected void finalize() throws Throwable{
		System.out.println(hashCode()+"제거됨.");
	}
}	
	


