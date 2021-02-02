package com.ssafy.recursive;

public class SumTest {
		static int N = 10;
		
		// basis 조건일 때 재귀함수를 멈추는 방법
		public static int sum1(int n) {
			if(n==N) return n;
			return n + sum1(n+1);
		}
		
		// basis 조건일 때 재귀함수를 멈추는 방법
		public static int sum2(int n) {
			if(n == 1) return n;
			return n + sum2(n-1);
		}
		
		// basis 조건에 동작하도록 하는 재귀함수
		public static int sum3(int n) {
			if(n<N)
			return n + sum1(n+1);
			return n;
		}
		
		// basis 조건에 동작하도록 하는 재귀함수
		public static int sum4(int n) {
			if(n >1) 
			return n + sum2(n-1);
			return n;
		}
	public static void main(String[] args) {
		System.out.println("sum: " + sum1(1));
		System.out.println("sum: " + sum2(10));
		System.out.println("sum: " + sum3(1));
		System.out.println("sum: " + sum4(10));

	}

}
