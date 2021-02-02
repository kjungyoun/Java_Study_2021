package com.ssafy.permutation;

import java.util.Arrays;

/**
 * 재귀를 이용한 순열 & 중복 순열
 * nPn
 */
public class Permutation_nTTr {
	static int N;				// 원소 개수
	static int R;				// 뽑을 개수
	static int[] number; 	// 원소를 저장해주는 배열
	static int tc; 				// 순열의 갯수
	static int count; 			// 재귀 함수 호출 수
	public static void main(String[] args) {
		N = 30;
		R = 6;
		
		number = new int[R];
		long stime = System.currentTimeMillis();
		permutation(0);
		long etime = System.currentTimeMillis();
		System.out.printf("%dTT%d 의 시간 : %dms\n",N,R,(etime-stime)); // 순열을 만드는데 걸리는 시간
		System.out.printf("%dTT%d 의 개수 : %d\n",N,R,tc);
		System.out.printf("%dTT%d 를 구하는데 수행된 재귀 호출 수 : %d\n",N,R,count);

	}
	private static void permutation(int idx) {
		count++;
		if(idx == R) { 	// 순열 요소를 다 (기저 조건)
			tc++;
//			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 1; i <= N; i++) {
			number[idx] = i;
			permutation(idx+1); // 다음 요소를 뽑으러 감
		}
	}
}
