package com.ssafy.modifiers;

/**
 * static : 동적인 자바에 정적인 특성을 부여하는 modifier
 * 
 * 자바는 동적이다.
 * 	- 클래스 로딩을 동적으로 (무조건 동적으로 해야) -> 따라서 클래스 선언에 static 사용 불가
 * 	- 메모리 할당 (객체 생성) -> static 사용 가능
 * 	- 메서드 링킹(binding)을 동적 -> static 사용 가능
 * 
 * @author youn
 *
 */

class Counter{
	// static variable, class variable
	static int scount;
	// non-static variable, instance variable
	int icount;
	
	Counter(){
		System.out.println("생성자가 호출됨");
		scount++;
		icount++;
	}
	void print() {
		System.out.printf("scount:%d\ticount:%d\n",scount,icount);
	}
	static void sprint() {
		//static 메서드는 non-static 속성에 접근 불가!
		//System.out.printf("scount:%d\ticount:%d\n",scount,icount);
		System.out.printf("scount:%d\n",scount);
	}
	
	static { // static block
		System.out.println("static block이 호출됨......");
	}
	
	{ // instance block
		System.out.println("instance block이 호출됨......");
	}
}

public class StaticTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Counter.scount++; // 이걸 실행하기 위해 class 로딩을 수행 
		System.out.println(Counter.scount);
		
		Counter c1 = new Counter(); 
		// scount는 저장된 값에서 증가하여 1->2 로 된다.
		// icount는 새로 생성된 속성 값 0->1로 증가한다.
		c1.print();
		
		Counter c2 = new Counter();
		// scount 값 2->3으로 증가
		// icount 새로 생성된 값 0->1로 증가
		c2.print();
		Counter.sprint();
	}

}
