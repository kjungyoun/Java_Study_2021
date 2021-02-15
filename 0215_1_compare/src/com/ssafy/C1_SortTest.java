package com.ssafy;

import java.util.Arrays;
import java.util.Comparator;

public class C1_SortTest {
	
	static class StudentComparator implements Comparator<Student>{

		@Override
		public int compare(Student o1, Student o2) {
			// 뒤에 것에서 앞의 것을 빼면 내림차순 정렬
			return o2.no - o1.no;
		}
		
	}
	public static void main(String[] args) {
		Student[] students = {
				new Student(1,10),
				new Student(3,50),
				new Student(2,80),
				new Student(4,10)
		};
		System.out.println(Arrays.toString(students));
		// sort 하면 학번으로 오름차순 정렬이 된다.
		// sort는 매개변수로 전달되는 원소에 compareTo가 있다고 가정하고 동작함
		// 따라서 sort를 사용하기 위해 클래스에 compareTo를 Override해야한다. 
		Arrays.sort(students);
		System.out.println(Arrays.toString(students));
		// 두번째 인자로 Comparator 객체가 온다. (내림차순 정렬)
		Arrays.sort(students,new StudentComparator());
		System.out.println(Arrays.toString(students));
		
		// anonymous 클래스로 Comparator 구현
		Arrays.sort(students, new Comparator<Student>() {

			@Override
			public int compare(Student o1, Student o2) {
				// 점수로 오름차순 구현
				return o1.score - o2.score;
			}
			
		});
		System.out.println(Arrays.toString(students));
		
		// Lambda 로 Comparator 구현
		Arrays.sort(students,(o1,o2)->o2.score-o1.score);
		System.out.println(Arrays.toString(students));
		
		

}

}
