package com.ssafy1;

public class PhoneTest {

	public static void main(String[] args) {
//		Phone phone = new Phone(); // 기본 생성자 사용
//		Phone phone2 = new Phone("S21"); // 우리가 만든 생성자 사용
//		System.out.println(phone2.name);
//		phone.setColor('B');
//		phone.setPrice(10000);
//		System.out.println(phone.getSalePrice());
//		
//		Phone [] phoneArray = new Phone[5];
//		for (int i = 0; i < phoneArray.length; i++) {
//			phoneArray[i] = new Phone();
//			phoneArray[i].setPrice(i*2000);
//		}
//		
//		for(Phone phone3 : phoneArray) {
//			System.out.println(phone3.getPrice());
//		}

		Phone phone = new Phone();
		
		phone.setName("Galaxy Note");
		phone.setColor('B');
		phone.setPrice(200000);
		System.out.println(phone);
	}

}
