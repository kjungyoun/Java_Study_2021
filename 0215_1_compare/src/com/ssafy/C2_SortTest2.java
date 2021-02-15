package com.ssafy;

import java.util.Arrays;
import java.util.Comparator;

public class C2_SortTest2 {

	public static void main(String[] args) {
		int[][]students = {
				{1,10},{3,50},{4,10},{1,100}	
		};
		print(students);
		// 2차원 배열이므로 각 원소에 자신만의 비교 가능한 연산자가 없으므로 Comparator를 구현해야한다.
		Arrays.sort(students, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
//				int diff =  o1[0]- o2[0];
				
				// 비교 판단 시 양수와 음수가 섞여 있을 경우 값 보정 후 비교해야한다.
				// 값을 주는 순서는 위에 빼는 순서 그대로 주면 된다.
				int diff = Integer.compare(o1[0], o2[0]);
				// 학번이 같으면 점수를 기준으로 내림차순 정렬
				return diff != 0 ? diff : o2[1] - o1[1];
			}
			
		});
		print(students);
	}
	private static void print(int[][] arr) {
		for(int[] is : arr) {
			System.out.print(Arrays.toString(is));
		}
		System.out.println();
	}

}
