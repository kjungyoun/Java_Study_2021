package com.ssafy.object.account;
/**
 * 마이너스 계좌 
 */
public class MinusAccount extends Account {
	/** 마이너스 한도*/
	private int limit;
	
	public MinusAccount() {}

	public MinusAccount(String no, String password, int balance, int limit) {
		super(no, password, balance);
		this.limit = limit;
	}
	
	/** Getter & Setter*/
	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
	
	@Override
	public void setBalance(int balance) {
		if(-limit<=balance) {
			this.balance = balance;
		}else System.out.println("한도 부족으로 출금할 수 없습니다.");
	}
}
