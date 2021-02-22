package com.ssafy.book;

import java.util.ArrayList;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {

	public static void main(String[] args) {
		
		// 도서 리스트를 유지하고 관리하는 BookManager 객체를 생성한다.
		IBookManager man = BookManagerImpl.getInstance();
		
		System.out.println("**********************불러온 도서 전체 목록**********************");
		ArrayList<Book> books = man.getList();
		
		if(books == null || books.size() == 0){		// 도서리스트가 없는 경우
			System.out.println("등록된 도서가 없습니다.");
			
		}else{										// 도서리스트가 잇는 경우
			printList(books);
		}
		
		// BookManager 객체를 이용해  도서정보를 추가한다.
		man.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법",10));
		man.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용",20));
		man.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링",30));
		man.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 1,40));
		
		
		printList(books);
	
		System.out.println(man.searchByIsbn("21424"));
		System.out.println("------------------------------------------------------------------------------------");
		
		printList(man.searchByTitle("분석설계"));
		printList2(man.getMagazines());
		System.out.println(man.getTotalPrice());
		System.out.println("------------------------------------------------------------------------------------");
		
		System.out.println(man.getPriceAvg());
		System.out.println("------------------------------------------------------------------------------------");
		
		man.remove("35355");
		try {
			man.sell("21425", 5);
			man.sell("21424", 15);
		} catch (QuantityException | ISBNNotFoundException e) {
			System.out.println(e);			
		} 
		
		try {
			man.sell("99999", 3);			
		} catch (QuantityException | ISBNNotFoundException e) {
			System.out.println(e);			
		} 
		
		try {
			man.buy("32567", 5);
		} catch (ISBNNotFoundException e) {
			System.out.println(e);	
		}
		
		printList(man.sortedByIsbn());
		printList(man.sortedByTitle());
		
		//man.saveData(); // 도서리스트를 파일에 저장한다.
	}
	
	
	static void printList(ArrayList<Book> arrayList) {
		for (Book b : arrayList) {
			System.out.println(b);
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
	static void printList2(ArrayList<Magazine> arrayList) {
		for (Magazine b : arrayList) {
			System.out.println(b);
		}
		System.out.println("------------------------------------------------------------------------------------");
	}
	
}
