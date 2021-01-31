package com.ssafy.array;

class Parent{
	public int getNum() {
		return 1;
	}
}

class Child extends Parent{
	public int getNum(int x) { // 
		return x;
	}
	public long getNum(int x, int y) {
		return x;
	}
}

public class Test {

	public static void main(String[] args) {
		Parent p = new Parent();
		Child c = new Child();
		System.out.println(p.getNum());
		System.out.println(c.getNum());
	}

}
