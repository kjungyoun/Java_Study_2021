package com.ssafy.object;

public class BookTest {

	public static void main(String[] args) {
		BookManager mgr = BookManager.getInstance();
		mgr.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		mgr.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		mgr.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
		System.out.println("**********************도서목록*******************");
		Book books[] = mgr.getList();
		for(Book bk : books) {
			System.out.println(bk);
		}
		System.out.println("**********************도서조회:21424*******************");
		System.out.println(mgr.searchByIsbn("21424"));
		System.out.println("**********************도서삭제:21424*******************");
		mgr.remove("21424");
		System.out.println("**********************도서목록*******************");
		books = mgr.getList();
		for(Book bk : books) {
			System.out.println(bk);
		}
	}

}
