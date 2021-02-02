package com.ssafy.permutation;

import java.util.Arrays;

/**
 * 재귀를 이용한 순열 & 중복 순열
 * nPn
 */
public class Permutation_nPn2 {
	static int N;							// 원소 개수
	static int[] number; 				// 원소를 저장해주는 배열
	static boolean[] selected; 		// 원소 중복 여부를 알려주는 상태 배열
	static int tc; 							// 순열의 갯수
	static int count; 						// 재귀 함수 호출 수
	public static void main(String[] args) {
		N = 9;
		number = new int[N];
		selected = new boolean[N+1];
		long stime = System.currentTimeMillis();
		permutation(0);
		long etime = System.currentTimeMillis();
		System.out.printf("%dTT%d 의 시간 : %dms\n",N,N,(etime-stime)); // 순열을 만드는데 걸리는 시간
		System.out.printf("%dTT%d 의 개수 : %d\n",N,N,tc);
		System.out.printf("%dTT%d 를 구하는데 수행된 재귀 호출 수 : %d\n",N,N,count);

	}
	private static void permutation(int idx) {
		count++;
		if(idx == N) { 	// 순열 요소를 다 (기저 조건)
			tc++;
			//System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 1; i <= N; i++) {
			// 중복 검사
			if(selected[i] == true) continue;
			// 중복되지 않은 경우 이므로
			number[idx] = i;
			selected[i] = true;
			permutation(idx+1); // 다음 요소를 뽑으러 감
			selected[i] = false;
		}
	}
}
