package com.ssafy.book;

/**
 * 도서고유 번호가 존재하지 않는 예외정보를 나타내는 클래스
 */
public class ISBNNotFoundException  extends Exception {

	/**	존재하지 않는 도서 고유번호 */
	private String isbn;
	
	/** 고유번호를 받아 생성하는 생성자 */
	public ISBNNotFoundException(String isbn) {		
		super(isbn+" 고유번호는 존재하지 않습니다.");
		this.isbn = isbn;
	}	
	
	@Override
	public String toString() {
		return "ISBNNotFoundException [isbn=" + isbn + "]";
	}

	public String getIsbn() {
		return isbn;
	}
}
