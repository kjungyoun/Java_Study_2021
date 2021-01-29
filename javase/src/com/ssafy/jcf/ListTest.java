package com.ssafy.jcf;

import java.util.ArrayList;

import com.ssafy.object.Employee;

public class ListTest {

	public static void main(String[] args) {
		//1.4ver
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(1);
		list.add("Hello");
		list.add("World");
		list.add(new Employee("1","1",1));
	
		System.out.println(list);
	
		Employee emp = (Employee) list.get(4);
		
		/*1.5ver Generic 적용
		컬렉션클래스<저장할타입> 변수명 = 컬렉션클래스<저장할타입>();
		- 지정한 타입만 저장됨.
		- 형변환 없이 바로 사용
		*/
		ArrayList<String> list2 = new ArrayList<>(); //나쁜코드!!!! 기본 생성자로 생성하지말고
//		list2.add(1); 지정한 타입이 아닌 경우 저장 시 에러 발생
		list2.add("hello");
		list2.add("world");
		String str = list2.get(0); //형변환 없이 바로 사용 가능

		
	}

}
