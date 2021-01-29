package com.ssafy.workshop.fileIO;

public class ISBNNotFoundException extends RuntimeException{
	private String isbn;
	public String getIsbn() {
		return isbn;
	}
	public ISBNNotFoundException(String isbn) {
		super(String.format("%s 번의 책을 찾지 못했습니다", isbn));
	}
}
