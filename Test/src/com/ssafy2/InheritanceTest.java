package com.ssafy2;

public class InheritanceTest {

	public static void main(String[] args) {
//		Phone phone = new Phone();
//		phone.setName("Note");
//		phone.setColor('B');
//		phone.setPrice(20000);
//		
//		System.out.println(phone);
		
		FolderblePhone fphone = new FolderblePhone();
		fphone.setName("Galaxy Folder2");
		fphone.setColor('A');
		fphone.setPrice(3000000);
		System.out.println(fphone);
		
		fphone.setWidth(500);
		fphone.setHeight(1000);
		
		System.out.println(fphone.getSmallSize());
		System.out.println(fphone.getLargeSize());
		System.out.println(fphone);
	}

}
