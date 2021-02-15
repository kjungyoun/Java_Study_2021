package com.ssafy;

public class Student implements Comparable<Student> {
	int no,score;

	public Student(int no, int score) {
		super();
		this.no = no;
		this.score = score;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [no=").append(no).append(", score=").append(score).append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Student o) {
		return this.no - o.no;
	}
	
	
	
}
