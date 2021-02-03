package com.ssafy.jungol;

import java.util.Scanner;

public class Main_1810_김정윤 {
	static int hat[];  			// 난쟁이의 모자 번호 저장
	static int numbers[];	// 뽑은 조합 저장
	static int N;					// 전체 난쟁이의 수
	static int R;					// 뽑을 난쟁이의 수
	static int result =0;
	public static void main(String[] args) {
		N=9;
		R=7;
		Scanner sc = new Scanner(System.in);
		hat = new int[N];
		for (int i = 0; i < N; i++) {
			hat[i] = sc.nextInt();
		}
		numbers = new int[R];
		combination1(0,0);

	}
	// 첫번째 방법				시간 : 323ms
	public static void combination(int idx, int start) {
		if(idx == R) {
			int sum=0;		// 모자의 합을 저장
			for (int i = 0; i < R; i++) {
				sum += numbers[i];
			}
			if(sum ==100) {		// 모자의 합이 100이면 출력
				for(int x : numbers) {
					System.out.println(x);
				}
			}
			return;
		}
		for (int i = start; i < hat.length; i++) {
			numbers[idx] = hat[i];
			combination(idx+1, i+1);
		}
	}
	
	// 두번째 방법				시간 : 382ms
	public static void combination1(int idx, int start) {
		if(idx == R) {
			if(result ==100) {		// 모자의 합이 100이면 출력
				for(int x : numbers) {
					System.out.println(x);
				}
			}
			return;
		}
		for (int i = start; i < hat.length; i++) {
			numbers[idx] = hat[i];
			result += hat[i];
			combination1(idx+1, i+1);
			result -= hat[i];
		}
	}
	
}
