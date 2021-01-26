package com.ssafy.object;

import java.util.Arrays;

public class BookManager {
	private int size;
	private static int MAX_SIZE = 100;
	private static BookManager instance;
	private Book[] books;
	
	private BookManager() {
		books = new Book[MAX_SIZE];
	}
	
	public static BookManager getInstance() {
		if(instance==null) instance = new BookManager();
		return instance;
	}
	
	public void add(Book book) {
		if(size<MAX_SIZE) {
			books[size++] = book;
		}else {
			MAX_SIZE += 10;
			books = Arrays.copyOf(books, MAX_SIZE);
			books[size++] = book;
		}
	}
	
	public void remove(String isbn) {
		for (int i = 0; i < size; i++) {
			if(isbn.equals(books[i].getIsbn())) {
				books[i] = books[size-1];
				books[size-1] = null;
				size--;
				break;
			}
		}
	}
	
	public Book[] getList() {
		return Arrays.copyOfRange(books, 0, size);
	}
	
	public Book searchByIsbn(String isbn) {
		for (int i = 0; i < size; i++) {
			if(isbn.equals(books[i].getIsbn()))
				return books[i];
		}
		return null;
	}
}
