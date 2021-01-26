package com.ssafy.object;

public class StudentMgrTest {

	public static void main(String[] args) {
		StudentMgr mgr = new StudentMgr();
		mgr.add(new Student("1000","김정윤","정보통신",100));
		mgr.add(new Student("2000","함주은","컴퓨터공학",80));
		mgr.add(new Student("3000","김정윤","컴퓨터통신",100));
		Student[] std = mgr.list();
		for(Student st : std) System.out.println(st);
		System.out.println("*****************************");
		mgr.remove("2000");
		std=mgr.list();
		for(Student st : std) System.out.println(st);
		System.out.println("*****************************");
		System.out.println(mgr.searchByHakbun("3000"));
		System.out.println("*****************************");
		std = mgr.searchByName("김정윤");
		for(Student st : std) System.out.println(st);
		System.out.println("*****************************");
		std=mgr.searchByScore(100);
		for(Student st : std) System.out.println(st);
	}

}
