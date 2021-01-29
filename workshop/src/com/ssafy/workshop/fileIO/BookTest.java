package com.ssafy.workshop.fileIO;

/**
 * BookManager 클래스를 이용하여 도서 객체 추가,삭제,조회하는 클래스
 */
public class BookTest {

	public static void main(String[] args) {

		
		IBookManager mgr = BookManagerImpl.getInstance();
		mgr.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법",10));
		mgr.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용",20));
		mgr.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링",30));
		mgr.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 40, 2021, 1));
		mgr.saveData(); // 도서리스트를 파일에 저장한다.

		System.out.println("**********************불러온 도서 전체 목록**********************");
		Book[] books = mgr.getList();
		if (books == null || books.length == 0) { // 도서리스트가 없는 경우
			System.out.println("등록된 도서가 없습니다.");
		} else { // 도서리스트가 잇는 경우
			for (Book b : books) {
				System.out.println(b);
			}
		}
		System.out.println("**********************불러온 도서 제목으로 검색**********************");
		books = mgr.searchByTitle("Java");
		if (books == null || books.length == 0) { // 도서리스트가 없는 경우
			System.out.println("등록된 도서가 없습니다.");
		} else { // 도서리스트가 잇는 경우
			for (Book b : books) {
				System.out.println(b);
			}
		}
		
		System.out.println("**********************책만 검색**********************");
		books = mgr.getBooks();
		if (books == null || books.length == 0) { // 도서리스트가 없는 경우
			System.out.println("등록된 도서가 없습니다.");
		} else { // 도서리스트가 잇는 경우
			for (Book b : books) {
				System.out.println(b);
			}
		}
		System.out.println("**********************잡지만 검색**********************");
		books = mgr.getMagazines();
		if (books == null || books.length == 0) { // 도서리스트가 없는 경우
			System.out.println("등록된 도서가 없습니다.");
		} else { // 도서리스트가 잇는 경우
			for (Book b : books) {
				System.out.println(b);
			}
		}
		
		System.out.println("**********************구매,판매**********************");
		mgr.buy("21424", 5);
		mgr.sell("35355", 21);
//		mgr.sell("21425", 30);
		books = mgr.getList();
		if (books == null || books.length == 0) { // 도서리스트가 없는 경우
			System.out.println("등록된 도서가 없습니다.");
		} else { // 도서리스트가 잇는 경우
			for (Book b : books) {
				System.out.println(b);
			}
		}
		System.out.println("총 도서 가격 :"+mgr.getTotalPrice());
		System.out.println("총 도서 가격의 평균 :"+mgr.getPriceAvg());
			
		// BookManager 객체를 이용해 도서정보를 추가한다.
//
	}
}
