package com.ssafy.workshop;

public class workshop_0323 {
	
	static int memo[];
	
	public static int Dp(int n) {
		memo[1] = 2;
		memo[2] = 3;
		
		for (int i = 3; i <= n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		return memo[n];
	}
	
	public static void main(String[] args) {
	int n = 8;
	memo = new int[n+1];
	
	System.out.println(Dp(n));
	}

}
