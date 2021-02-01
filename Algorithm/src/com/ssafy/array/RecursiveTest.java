package com.ssafy.array;

public class RecursiveTest {

	private static int sum1(int n) {
		if(n<= 0) return 0;
		return n + sum1(n-1);
	}
	
	private static int sum2(int n) {
		if(n>10) return 0;
		return n+ sum2(n+1);
	}
	
	public static void main(String[] args) {
		
		System.out.println(sum1(10));
		System.out.println(sum2(1));

	}

}
