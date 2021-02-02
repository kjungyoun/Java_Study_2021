package com.ssafy.recursive;
import java.util.Scanner;

public class FactorialTest2 {
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		System.out.printf("%d! : %d\n",N,fac1(1));
		System.out.printf("%d! : %d\n",N,fac2(N));
		System.out.printf("%d! : %d\n",N,fac3(1));
		System.out.printf("%d! : %d\n",N,fac4(N));
		
	}
	
	public static int fac1(int n) {
		if(n==N) {
			return n;
		}
		return n*fac1(n+1);
	}
	public static int fac2(int n) {
		if(n==1) {
			return n;
		}
		return n*fac2(n-1);
	}
	public static int fac3(int n) {
		if(n<N) {
			return n*fac3(n+1);
		}
		return n;
	}
	public static int fac4(int n) {
		if(n>1) {
			return n*fac4(n-1);
		}
		return n;
	}

}
