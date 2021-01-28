package com.ssafy.object;

public class ObjectTest {

	public static void main(String[] args) throws CloneNotSupportedException {
		Book book = new Book("1", "눈 감고도 코딩하는 자바", "동글맘", "멀캠", 30000, "쉽게하는 자바");
				
		Book book2 =(Book) book.clone();
		
		System.out.println(book);
		System.out.println(book2);
		System.out.printf("book:%d   book2:%d\n", book.hashCode(), book2.hashCode());
		book = null;
		
		System.gc();
		
		try {Thread.sleep(3000);}catch(Exception e) {}
		System.out.println("main end");
	}

}
