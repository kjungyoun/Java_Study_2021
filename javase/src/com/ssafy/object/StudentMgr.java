package com.ssafy.object;

import java.util.Arrays;

public class StudentMgr {
	private static StudentMgr instance;
	private int size;
	private int MAX_SIZE = 100;
	private Student[] students;
	
	public StudentMgr() {
		students = new Student[MAX_SIZE];
	}
	
	public void add(Student s) {
		if(size<MAX_SIZE) {
			students[size++] = s;
		}else {
			MAX_SIZE +=10;
			students = Arrays.copyOf(students, MAX_SIZE);
			students[size++] = s ;
		}
	}
	
	public void remove(String hakbun) {
		for (int i = 0; i < size; i++) {
			if(hakbun.equals(students[i].getHakbun())) {
				students[i]=students[size-1];
				students[size-1]= null;
				size--;
			}
		}
	}
	public Student[] list() {
		return Arrays.copyOf(students, size);
	}
	
	public Student searchByHakbun(String hakbun) {
		for (int i = 0; i < size; i++) {
			if(hakbun.equals(students[i].getHakbun()))
				return students[i];
		}
		return null;
	}
	
	public Student[] searchByName(String name) {
		int index = 0;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if(name.equals(students[i].getName())) count++;
		}
		Student[] std = new Student[count];
		for (int i = 0; i < size; i++) {
			if(name.equals(students[i].getName())) {
				std[index++] = students[i];
			}
		}
		return std;
	}
	
	public Student[] searchByScore(int score) {
		int index = 0;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if(score == students[i].getScore()) count++;
		}
		Student[] std = new Student[count];
		for (int i = 0; i < size; i++) {
			if(score == students[i].getScore()) {
				std[index++] = students[i];
			}
		}
		return std;
	}
}
