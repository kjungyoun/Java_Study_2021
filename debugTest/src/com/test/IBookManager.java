package com.test;

import java.util.ArrayList;

/* 도서리스트를 관리하기 위한 클래스를 위한 명세역할의 인터페이스 */
public interface IBookManager {
	
	void add(Book book); //도서를 도서리스트에 추가한다.	
	void remove(String isbn);	//고유번호의 해당 도서를 도서리스트에서 삭제한다.
	ArrayList<Book> getList();	//등록된 도서리스트를 반환한다.
	ArrayList<Book> sortedByIsbn();	//isbn 기준 정렬된 도서리스트를 반환한다.(기본 정렬기준)
	ArrayList<Book> sortedByTitle();//title 기준 정렬된 도서리스트를 반환한다.
	
	Book searchByIsbn(String isbn);	//고유번호로 해당 도서를 조회한다.
	ArrayList<Book> searchByTitle(String title);//도서 제목을 포함하고 있는 도서리스트를 반환한다.	
	ArrayList<Magazine> getMagazines();	//잡지리스트를 반환한다.
	Book[] getBooks();//도서리스트를 반환한다. 	
	int getTotalPrice();//도서리스트의 가격의 총합을 반환한다.
	
	double getPriceAvg();//도서리스트의 가격의 평균을 반환한다.	
	
	//고유번호에 해당하는 도서를 수량만큼 판매처리하여 재고를 감소시킨다.
	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;
	
	//고유번호에 해당하는 도서를 수량만큼 구매 처리하여 재고를 증가시킨다.
	void buy(String isbn, int quantity) throws ISBNNotFoundException;

}