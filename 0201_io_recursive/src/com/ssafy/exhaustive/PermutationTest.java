package com.ssafy.exhaustive;

import java.util.Arrays;

// nPn을 구하는 것
public class PermutationTest {
	static int[] numbers ;
	static boolean[] isSelected;
	static int N = 4;
	public static void main(String[] args) {
		numbers = new int[N];
		isSelected = new boolean[N+1];
		permutation(0);
	}
	
	/**
	 * 순열을 시행하는 메서드
	 * @param cnt 현재 뽑는 자리수
	 */
	static void permutation(int cnt) {
		if(cnt == 3) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		
		// 1부터 3까지 3개의 숫자가 있다고 가정
		for (int i = 1; i <= N; i++) {
			// i : 시도하는 숫자
			if(isSelected[i]) continue;
			numbers[cnt] = i;
			isSelected[i] = true;
			// 현재 내 위치의 자리수를 다 뽑았으므로 다음 수 뽑으라고 넘김
			permutation(cnt+1);
			// 다음 경우의 수를 뽑기 위해 넘어가기 전 초기화를 해준다.
			isSelected[i] = false;
			
		}
	}

}
