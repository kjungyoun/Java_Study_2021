package com.ssafy.exhaustive;

import java.util.Arrays;

// nCr을 구하는 것
public class CombinationTest {
	static int[] numbers;
	static int N=4, R=2; // R은 뽑는 갯수
	public static void main(String[] args) {
		numbers = new int[R];
		combination(0,1);

	}
	static void combination(int cnt, int start) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 처음부터 끝까지 반복을 돌리지 않고 각자의 시작위치에서 돌린다.
		// 자동으로 중복 제거
		for (int i = start; i <= N; i++) {
			numbers[cnt] = i;
			// i라는 숫자를 뽑았을 경우 다음 숫자를 뽑는 메서드의 for문은 i+1부터 시작하도록함
			// 자동 중복 제거
			combination(cnt+1, i+1);
		}
	}

}
