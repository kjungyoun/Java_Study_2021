package com.ssafy.dp2;

import java.util.Scanner;

public class DP2_LISTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 원소들 저장
		int[] LIS = new int[N];	// 각 원소를 마지막에 세웠을 때 최장 길이
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		for (int i = 0; i < N; i++) {
			LIS[i] = 1; // 자기 혼자 세웠을 때의 길이로 초기화
			for (int j = 0; j < i; j++) { // 맨 앞부터 자신의 직전의 원소들과 비교
				// 나보다 작은 수인가? && 자신의 최장 길이보다 이전의 최장 길이에 자신을 붙인게 더 큰가?
				if(arr[j]<arr[i] && LIS[j]+1>LIS[i]) {
					LIS[i] = LIS[j]+1; // 현재 수에 대한 최장 길이 갱신!
				}
			} // 현재 수까지의 최장 길이를 구함
			
			// 전체 결과 중에 최장 길이를 갱신!
			if(max<LIS[i]) max = LIS[i];
		}
		System.out.println(max);
	}

}
