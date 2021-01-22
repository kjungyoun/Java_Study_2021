package com.ssafy.object;

import java.util.Arrays;

public class BookManager {
	private static BookManager instance;
	private Book[] books;
	private static int MAX_SIZE = 100;
	private int size;
	
	/**
	 * 싱글톤으로 객체 생성하기 위해 private으로 설정한 생성자
	 */
	private BookManager() {
		books = new Book[MAX_SIZE];
	}
	
	/**
	 * 싱글톤 객체 생성 메서드
	 * @return 생성된 객체 반환
	 */
	static BookManager getInstance() {
		if (instance == null)
			instance = new BookManager();
		return instance;
	}
	
	/**
	 * 책 추가 기능
	 * @param book 추가할 책 객체
	 */
	public void add(Book book) {
		if (size < MAX_SIZE)
			books[size++] = book;
		else
			System.out.println("더 이상 등록할 수 없습니다.");
	}

	/**
	 * 고유 번호로 책 목록 제거
	 * 
	 * @param isbn 제거할 책 고유번호
	 */
	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if (isbn.equals(books[i].getIsbn())) {
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
			} else
				System.out.println("고유번호가 잘못되었습니다.");
		}
	}
	
	/**
	 * 책 목록 조회 기능
	 * @return 조회한 책 객체 배열 리턴
	 */
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	
	/**
	 * 책 고유번호로 책 정보 조회 기능
	 * @param isbn 조회할 책 고유번호
	 * @return 조회하여 나온 책 객체 리턴
	 */
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if (isbn.equals(books[i].getIsbn()))
				return books[i];

		}
		return null;
	}
}
