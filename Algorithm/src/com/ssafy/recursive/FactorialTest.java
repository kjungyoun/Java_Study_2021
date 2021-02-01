package com.ssafy.recursive;

import java.util.Scanner;

public class FactorialTest {
	static int i = 1;

	public static int fact1(int n) {
		if(n<=1) return 1;
		return n * fact1(n-1);
	}
	
	public static int fact2(int n, int i) {
		if(i >=n) return n;
		return i * fact2(n, i+1);
	}
	
	public static int fact3(int n) {
		if(n>1) 
		return n * fact3(n-1);
		return 1;
	}
	
	public static int fact4(int n, int i) {
		if(i < n) 
		return i * fact4(n, i+1);
		return n;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		System.out.println(fact1(n));
		System.out.println(fact2(n,i));
		System.out.println(fact3(n));
		System.out.println(fact4(n,i));
	}

}
