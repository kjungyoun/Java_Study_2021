package com.ssafy.employee.model.dto;

public class Manager extends Employee {
	private String position; // 추가된 기능
	public Manager() {}
	public Manager(String empno, String name, int salary, String position) {
		super(empno, name, salary);
		this.position = position;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public String toString() {
		return  new StringBuilder(50)
				.append(super.toString())
				.append(" 직위:")
				.append(position).toString();
	}
	
}
