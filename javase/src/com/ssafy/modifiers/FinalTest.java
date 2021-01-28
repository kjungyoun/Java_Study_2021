package com.ssafy.modifiers;


class MyFinal{
	public final void test() {
		System.out.println("MyFinal's test call");
	}
}

class MyFinalSub extends MyFinal {
//	public void test() {} final 메소드는 오버라이딩 금지
}

//class SubString extends String{}
// final로 선언된 클래스는 상속 불가


public class FinalTest {

	public static void main(String[] args) {
		final double PI = 3.14;
//		PI = 3.141; 에러발생 - 수정할 수 없음 

	}

}
