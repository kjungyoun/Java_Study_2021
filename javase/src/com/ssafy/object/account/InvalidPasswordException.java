package com.ssafy.object.account;

public class InvalidPasswordException extends RuntimeException {
	public InvalidPasswordException() {
		super("비밀번호 오류!!!");
	}
	public InvalidPasswordException(int number) {
		super(String.format("비밀번호 %d회 오류!!!", number));
	}
	
}
