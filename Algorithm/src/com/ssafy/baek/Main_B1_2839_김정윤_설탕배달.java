package com.ssafy.baek;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B1_2839_김정윤_설탕배달 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int memo[] = new int[N+1];
		Arrays.fill(memo, Integer.MAX_VALUE);
		memo[0] = 0;
		
		for (int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			if(i>=3 && memo[i-3] != Integer.MAX_VALUE) {
				min = memo[i-3] +1;
			}
			if(i>= 5 && memo[i-5] != Integer.MAX_VALUE) {
				min = Math.min(min, memo[i-5]+1);
			}
			
			memo[i] = min;
		}

		System.out.println(memo[N] == Integer.MAX_VALUE ? -1 : memo[N]);
	}

}
