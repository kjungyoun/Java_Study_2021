package com.ssafy.permutation;

import java.util.Arrays;

/**
 * 재귀를 이용한 순열 & 중복 순열
 * 중복 체크를 BitMask를 이용
 * nPn
 */
public class Permutation_nPn3 {
	static int N;							// 원소 개수
	static int[] number; 				// 원소를 저장해주는 배열
	static int tc; 							// 순열의 갯수
	static int count; 						// 재귀 함수 호출 수
	public static void main(String[] args) {
		N = 3;
		number = new int[N];
		long stime = System.currentTimeMillis();
		permutation(0,0);
		long etime = System.currentTimeMillis();
		System.out.printf("%dTT%d 의 시간 : %dms\n",N,N,(etime-stime)); // 순열을 만드는데 걸리는 시간
		System.out.printf("%dTT%d 의 개수 : %d\n",N,N,tc);
		System.out.printf("%dTT%d 를 구하는데 수행된 재귀 호출 수 : %d\n",N,N,count);

	}
	private static void permutation(int idx, int flag) {
		count++;
		if(idx == N) { 	// 순열 요소를 다 (기저 조건)
			tc++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 1; i <= N; i++) {
			// 중복 검사
			// 0이 아니라면 사용한 것 즉, i라는 숫자를 썼는지 안썼는지
			// 지수승을 데이터로!
			if((flag & 1<<i) != 0) continue; 
			// 중복되지 않은 경우 이므로
			number[idx] = i;
			permutation(idx+1,flag | 1<<i); // 다음 요소를 뽑으러 감
		}
	}
}
