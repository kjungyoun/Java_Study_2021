package com.ssafy.object;

public class CustomerManagerTest {

	public static void main(String[] args) {
		CustomerManager mgr = CustomerManager.getInstance(); // 싱글톤 패턴 적용
		
		mgr.add(new Customer("SSAFY", "강남", 22));
		mgr.add(new Customer("김잔디","마포구",28));
		mgr.add(new Customer("고길동","쌍문동",55));
		
		System.out.println("============== 고객 등록 후 ===================");
		mgr.printCustomers();
		
		System.out.println("============== 이름으로 고객 찾 ===================");
		System.out.println(mgr.searchByName("김잔디"));
		System.out.println(mgr.searchByName("김정윤"));
		
		System.out.println("============== 고객 수정 후 ===================");
		mgr.update(new  Customer("고길동", "홍대", 32));
		mgr.printCustomers();
		
		System.out.println("============== 고객 목록 출력 ===================");
		Customer[] cust = mgr.getList();
		for(Customer customer : cust) {
			System.out.println(customer);
		}
		
		System.out.println("============== 고객 삭제 후 ===================");
		mgr.remove("SSAFY");
		mgr.printCustomers();
		
	}

}
