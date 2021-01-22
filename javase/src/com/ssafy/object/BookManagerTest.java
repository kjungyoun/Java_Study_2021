package com.ssafy.object;

public class BookManagerTest {

	public static void main(String[] args) {
		BookManager books = BookManager.getInstance();

		books.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
		books.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
		books.add(new Book("35355", "분석 설계", "소나무", "jaen.kr", 30000, "SW 모델링"));

		System.out.println("*********************도서목록***********************");
		Book[] book = books.getList();
		for (Book bk : book) {
			System.out.println(bk);
		}

		System.out.println("*********************도서조회:21424***********************");
		System.out.println(books.searchByIsbn("21424"));
		System.out.println("*********************도서삭제:21424***********************");
		books.remove("21424");
		System.out.println("*********************도서목록***********************");
		book = books.getList();
		for (Book bk : book) {
			System.out.println(bk);
		}

	}

}
