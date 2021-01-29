/**
 * 입출금 프로그램
 * 계좌 정보 - 계좌 번호, 비밀번호, 잔액 정보
 * Account는 입출금
 */

package com.ssafy.object.account;
/** 입출금만 가능한 클래스*/
public class Account {
	private String no; //계좌번호
	private String password; //비밀번호
	protected int balance; //잔액
	// 부모 자식간에는 접근 가능하도록
	public Account() {}
	public Account(String no, String password, int balance) {
		this.no = no;
		this.password = password;
		this.balance = balance; // 여기까지 속성, 생성자 선언했음
	}
	/** 입금 기능 */
	public int deposit(int amount) {
		return this.balance += amount;
	}
	/** 출금 기능 	 **/
	public int withdraw(String password, int amount) {
		if(password.equals(this.password)) {
			setBalance(balance-amount);
		}else {
			throw new InvalidPasswordException();
		}
		return balance;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		if (balance>0) {
			this.balance = balance;
		}else {
			System.out.println("계좌에 잔액이 부족합니다.");
		}
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [no=").append(no).append(", password=").append(password).append(", balance=")
				.append(balance).append("]");
		return builder.toString();
	}
	
}
