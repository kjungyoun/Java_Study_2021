package com.ssafy.book;

public class QuantityException extends Exception {
	public QuantityException() {
		super("수량이 부족합니다.");
	}
}
