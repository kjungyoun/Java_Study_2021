package com.ssafy.workshop;

public class workshop2_0323 {
	
	public static int DP(int n) {
		memo[1] = 2;
		memo[2] = 5;
		
		for (int i = 3; i <= n; i++) {
			memo[i] = 2*memo[i-1] + memo[i-2];
		}
		
		return memo[n];
		
	}
	
	static int [] memo;
	public static void main(String[] args) {
		int n = 6;
		memo = new int[n+1];
		
		System.out.println(DP(n));

	}

}
