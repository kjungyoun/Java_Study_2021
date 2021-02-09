package com.ssafy.tree;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 * Java는 정렬할 때 항상 default 가 오름차순이다.
 */
public class HeapTest {

	public static void main(String[] args) {
		Integer[] array = { 2, 4, 6, 1, 5 };
		Arrays.sort(array); // 오름차순 정렬
		System.out.println(Arrays.toString(array));

		// 내림차순 정렬 ( 객체만 사용할 수 있으므로 int형이 아닌 Integer형으로 배열 선언
		Arrays.sort(array, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
//				return o2-o1;
				// 원래 코드는 아래와 같이 짜야하지만 굳이 그렇지 않고 두 값을 뺀 값을 리턴해도 똑같다.
				 if(o1>o2) return 1;
				 else if(o1==o2) return 0;
				 else return -1;
			}
		});

		// PriorityQueue<Integer> queue = new PriorityQueue<>(); // min 값 heap이 기본

		PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
			// comparator를 선언하여 compare 메서드를 오버라이드 해야지 내림차순 정렬 가능
			// max 값 heap으로 구성할 때
			@Override
			public int compare(Integer o1, Integer o2) {
				// 뒤의 것에서 앞의 것을 빼면 내림차순
				// 앞의 것에서 뒤의 것을 빼면 오름차순
				return o2 - o1;

				// 데이터 overflow 발생 시에도 그 전까지 정렬을 하게 해주는 Integer의 compare
//				return Integer.compare(o2, o1);
			}

		});

		queue.offer(3);
		queue.offer(1);
		queue.offer(10);
		queue.offer(4);
		queue.offer(2);

		while (!queue.isEmpty()) {
			// 기본은 오름차순 정렬되어 나온다.
			System.out.println(queue.poll());
		}
	}

}
