package com.ssafy.workshop.fileIO;

public interface IBookManager {
	public void add(Book book);
	public void remove(String isbn);
	public Book[] getList();
	public Book searchByIsbn(String isbn);
	public Book[] searchByTitle(String title);
	public Magazine[] getMagazines();
	public Book[] getBooks();
	public int getTotalPrice();
	public double getPriceAvg();
	public void sell(String isbn, int quantity);
	public void buy(String isbn, int quantity);
	public void saveData();
	
}
