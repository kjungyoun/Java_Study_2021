package com.ssafy.baek;

import java.util.Scanner;

public class Solution_S3_15649_Bitmask_김정윤 {
	static int N,M;
	static int numbers[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		permutation(0,0);

	}
	
	public static void permutation(int cnt, int flag) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			//중복 체크
			if((flag & 1<<i) !=0) continue;
			numbers[cnt] = i;
			// or 연산을 통해 해당 숫자를 사용했다고 표현
			permutation(cnt+1, flag | 1<<i);
		}
	}
}
