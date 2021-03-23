package com.ssafy.dp;

public class FiboTest {
	static long memo[];

	public static long fiboRec(int n) {
		if(n <= 1) {
			return n;
		}
		return fiboRec(n-1)+fiboRec(n-2);
	}
	
	public static long fiboMemo(int n) {
		if(n<=1) return n;
		if(memo[n-1] == 0) {
			memo[n-1] = fiboMemo(n-1);
		}
		
		if(memo[n-2] == 0) {
			memo[n-2] = fiboMemo(n-2);
		}
		
		return memo[n-1] + memo[n-2];
	}
	
	public static long fiboDp(int n) {
		// 초기항은 기본적으로 셋팅
		memo[1] = 1;
		
		// 점화식을 이용한 구현 (for문 사용)
		for (int i = 2; i <=n; i++) {
			memo[i] = memo[i-1] + memo[i-2];
		}
		
		return memo[n];
	}
	public static void main(String[] args) {
		
		int n = 45;
		long start = System.nanoTime();
		
		memo = new long[n+1];
		
//		System.out.println(fiboRec(n));
//		System.out.println(fiboMemo(n));
		System.out.println(fiboDp(n));
		
		long end = System.nanoTime();
		
		System.out.printf("%dms\n",end-start);
	}

}
