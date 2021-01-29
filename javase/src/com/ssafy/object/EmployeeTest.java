package com.ssafy.object;

public class EmployeeTest {

	public static void main(String[] args) {
	//	EmployeeManagerPoly mgr = new EmployeeManagerPoly();
		EmployeeManagerPolyList mgr = new EmployeeManagerPolyList();
		
		System.out.println("==========등록==========");
		mgr.add(new Employee("1111","박재준",2500000));
		mgr.add(new Engineer("1111","박재준",2500000, "개발자"));
		mgr.add(new Engineer("2222","홍길동",2500000, "개발자"));
		mgr.add(new Manager("3333","고길동",2500000, "대리"));
		mgr.print();
		System.out.println("==========검색==========");
		System.out.println(mgr.findEmployee("1111"));
		System.out.println(mgr.findEmployee("3333"));
		System.out.println(mgr.findEmployee("4"));
		
		System.out.println("==========수정==========");
		mgr.update(new Manager("3333", "고길동", 4000000, "팀장"));
		mgr.print();
		
		System.out.println("==========삭제==========");
		mgr.remove("1111");
		mgr.print();

	}

}
