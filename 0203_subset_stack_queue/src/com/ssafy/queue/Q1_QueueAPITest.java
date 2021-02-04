package com.ssafy.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q1_QueueAPITest {

	public static void main(String[] args) {
		// LinkedList는 queue 인터페이스만 구현한 것이 아닌 다른 것들도 구현되어 있음
//		LinkedList<String> queue = new LinkedList<String>();
		// Queue 타입으로 선언하여 Queue에 있는 메서드들만 사용할 수 있도록 제한을 둠
		Queue<String> queue = new LinkedList<String>();
		queue.offer("야도란");
		queue.offer("또가스");
		queue.offer("잠만보");
		queue.offer("롱스톤");
		
		System.out.println(queue.isEmpty()+"//"+queue.size());
		System.out.println(queue.peek()); // 제일 앞에 있는 것을 반환
		System.out.println(queue.isEmpty()+"//"+queue.size());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
		// 큐는 안에 인자가 아무것도 없을때 poll을 시행해도 에러가 아닌 null을 반환
		System.out.println(queue.poll());

	}

}
