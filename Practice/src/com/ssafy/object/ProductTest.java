package com.ssafy.object;

public class ProductTest {

	public static void main(String[] args) {
		Tv tv = new Tv();
		Refrigerator ref = new Refrigerator(0001, "LG 냉장고", 2340000, 12, 200);
		System.out.println(ref);
		tv.setName("삼성 tv");
		tv.setNum(0002);
		System.out.println(tv);
	}

}
