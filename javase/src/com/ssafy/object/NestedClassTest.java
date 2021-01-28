package com.ssafy.object;

interface Flyer{
	void fly();
}
class Outer{
//	private Flyer f = new Flyer();인터페이스라서 불가능
	// 딱 한 번만 구현하고 끝일 때
	private Flyer d = new Flyer() {
		@Override
		public void fly() {
		} 
	};
}
public class NestedClassTest {
	public static void main(String[] args) {
	}
}
