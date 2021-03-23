package com.ssafy.jungol;

import java.util.Scanner;

public class Main_1411_김정윤_두줄로타일깔기 {
	static int memo[];
	
	public static int DP(int n) {
		memo[1] = 1;
		memo[2] = 3;
		for (int i = 3; i <= n; i++) {
			memo[i] = (memo[i-1]+ 2*memo[i-2]) % 20100529;
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		memo = new int[n+1];
		System.out.println(DP(n));

	}

}
