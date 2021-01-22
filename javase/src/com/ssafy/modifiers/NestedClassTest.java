package com.ssafy.modifiers;

class OuterClass{
	private int i;
	
	// nested class는 static, private, protected도 사용 가능
	// Outer class 만을 위한 클래스로써 OuterClass에 선언된 private 멤버에 접근 가능
	class NestedClass{
		public void test() {
			System.out.println(i);
		}
	}

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
	
}

public class NestedClassTest { //outer class 만을 위한 클래스

	public static void main(String[] args) {
		
		OuterClass o = new OuterClass();
		System.out.println(o.getI());

	}

}
