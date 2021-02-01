package com.ssafy.recursive;

public class R1_FactorialTest {
		//반복문
		private static int factorial(int n) {
			int result = 1;
			for (int i = n; i >0; i--) {
				result *= i; // 단위반복
			}
			return result;
		}
		
		// 재귀 함수 이용 ( 리턴값 이용 X)
		private static int res = 1; // 함수의 결과를 저장할 멤버 변수
		private static void factorial2(int n) {
			if(n == 0) return; // 함수를 끝내기 위함 ( 나를 호출한 곳으로 돌아가라)
			res *= n; // 자신은 결과에 곱하고
			factorial2(n-1); // 나머지는 뒤로 toss한다. -> 단위 반복
		}
		
		//재귀 함수 이용 ( 리턴값 이용)
		private static int factorial3(int n) {
			if(n <= 1) return 1; // 함수를 끝내기 위함 ( 나를 호출한 곳으로 돌아가라)
			return n * factorial3(n-1);
		}

		public static void main(String[] args) {
			int n =5;
			System.out.println(factorial(n));
			factorial2(n);
			System.out.println(res);
			System.out.println(factorial3(n));
		}
}
