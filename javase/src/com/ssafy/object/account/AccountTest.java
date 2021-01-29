package com.ssafy.object.account;

public class AccountTest {

	public static void main(String[] args) {
		Account account = new Account("1111", "1111", 10000);
		
		System.out.println("3000원 입금 후: "+account.deposit(3000));
		try {
			System.out.println("15000원 출금 후: "+account.withdraw("2222", 15000));
			// 비밀번호 오류 시 잔액 나오지 못하게 exception으로 할 것
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println("15000원 출금 후: "+account.withdraw("1111", 15000));
		
		System.out.println("======================================================");
		MinusAccount account2 = new MinusAccount("1111", "1111", 10000, 10000000);
		
		System.out.println("3000원 입금 후: "+account2.deposit(3000));
		System.out.println("15000원 출금 후: "+account2.withdraw("2222", 150000));
		System.out.println("15000원 출금 후: "+account2.withdraw("1111", 150000));
		System.out.println("15000원 출금 후: "+account2.withdraw("1111", 10000000));
		// 마이너스 한도는 1000만원 이므로 출금이 가능했다.
		System.out.println("15000원 출금 후: "+account2.withdraw("1111", 9863000));
	}
}
