package com.ssafy;

import java.util.PriorityQueue;

public class PriorityQueueTest {

	public static void main(String[] args) {
		PriorityQueue<Student> pQueue = new PriorityQueue<Student>();
		pQueue.offer(new Student(4,20));
		pQueue.offer(new Student(3,50));
		pQueue.offer(new Student(1,60));
		
		// Student 클래스의 CompareTo 메서드에 학번을 기준으로 내림차순 정렬되어 있기 때문에
		// 학번의 오름차순 순서대로 출력된다.
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());
		System.out.println(pQueue.poll());

	}

}
