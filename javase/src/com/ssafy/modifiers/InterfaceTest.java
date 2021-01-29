package com.ssafy.modifiers;

import java.io.Serializable;
//인터페이스 선언  Trans, Flyer
interface Trans extends Serializable, Cloneable{ // 두 인터페이스를 확장한 Trans 인터페이스
	void start();
	void stop();
}

interface Flyer {
	void fly();
}

class Human{
	String name;
	public void start() { // 이름 충돌 일어나지 않음. 구현된 start 알아서 찾아 썼다.
		System.out.println("걸어 갑니다.");
	};
}
class SuperMan extends Human implements Trans, Flyer{//다중 상속
	public void fly() {
		System.out.println("날아서 지구를 구해야지!");
	}
	public void stop() {
		System.out.println("잠깐 쉬자!");
	}
}

public class InterfaceTest {
	public static void main(String[] args) {
		SuperMan clark = new SuperMan();
		
		Flyer f = clark;
		
		Trans t = clark;
		
		Cloneable c = clark; // JVM은 아무 객체나 복사해주는 것이 아니라 cloneable 객체만 복사
		
		clark.start();
		clark.fly();
	}
}
