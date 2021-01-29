package com.ssafy.object;
public class Engineer extends Employee {
	private String skill;//사원엔 없는 추가된 기능
	public Engineer() {}
	public Engineer(String empno, String name, int salary, String skill) {
		super(empno, name, salary);
		this.skill = skill;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public String toString() {
		return  new StringBuilder(50)
				.append(super.toString())
				.append(" 보유기술:")
				.append(skill).toString();
	}
}








