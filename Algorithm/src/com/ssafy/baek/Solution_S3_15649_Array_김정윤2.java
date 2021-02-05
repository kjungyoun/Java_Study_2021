package com.ssafy.baek;

import java.util.Scanner;

public class Solution_S3_15649_Array_김정윤2 {
	static int N,M;
	static int numbers[];
	static boolean isSelected[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		numbers = new int[M];
		isSelected = new boolean [N+1];
		permutation(0);

	}
	
	public static void permutation(int cnt) {
		if(cnt == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(numbers[i]+" ");
			}
			System.out.println();
			return;
		}
		for (int i = 1; i <= N; i++) {
			//중복 체크
			if(isSelected[i]) continue;
			isSelected[i] = true;
			numbers[cnt] = i;
			// or 연산을 통해 해당 숫자를 사용했다고 표현
			permutation(cnt+1);
			isSelected[i] = false;
		}
	}
}
