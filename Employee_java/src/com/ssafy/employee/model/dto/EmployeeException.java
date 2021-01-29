package com.ssafy.employee.model.dto;

public class EmployeeException extends RuntimeException{ 
	//unchecked Exception : 예외처리 안해도 에러 X
	// 따라서 try - catch 나 throws 할 필요 없음
	public EmployeeException(String msg) {
		super(msg);
	}
}
