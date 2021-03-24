package com.ssafy.baek;

import java.util.Arrays;
import java.util.Scanner;

public class Main_B1_2839_김정윤_설탕배달_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int memo[] = new int[N+1];
		Arrays.fill(memo, 10000);
		memo[0] = 0;
		
		int min = 10000;
		for (int i = 3; i <= N; i++) {
				if(i>=5) {
					min = Math.min(memo[i-3] +1, memo[i-5]+1);					
				}else{
					min = memo[i-3]+1;
				}
			
			memo[i] = min;
		}

		System.out.println(memo[N] >= 10000 ? -1 : memo[N]);
	}

}
