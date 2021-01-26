package com.ssafy.object;

public class Student {
	private String hakbun;
	private String name;
	private String major;
	private int	score;
	public Student() {
		
	}
	public Student(String hakbun, String name, String major, int score) {
		this.hakbun = hakbun;
		this.name = name;
		this.major = major;
		this.score = score;
	}
	public String getHakbun() {
		return hakbun;
	}
	public void setHakbun(String hakbun) {
		this.hakbun = hakbun;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		if(score>-1) this.score = score;
		else System.out.println("0보다 큰 값을 입력하세요");
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [hakbun=").append(hakbun).append(", name=").append(name).append(", major=")
				.append(major).append(", score=").append(score).append("]");
		return builder.toString();
	}
	
	
}
