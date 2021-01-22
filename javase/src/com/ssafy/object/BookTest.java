package com.ssafy.object;

public class BookTest {

	public static void main(String[] args) {
		// 클래스명 변수명;
		// 생성 : 변수명 = new 생성자(); 	or		클래스명 변수명 = new 생성자();
			Book book;
			book = new Book();
			System.out.println(book);
			
			Book book2 = new Book("1111", "자바가좋아", "정윤킹", "멀캠", 200000, "자바 기초를 배웁시다" );
			System.out.println(book2);
			
			System.out.println(book.equals(book2)); // 이럴 때 this가 가리키는 것은 book 객체이다.
		
		
	}

}
