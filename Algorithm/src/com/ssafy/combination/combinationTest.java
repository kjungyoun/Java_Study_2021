package com.ssafy.combination;

import java.util.Arrays;

public class combinationTest {
	static int N;						//원소 개수
	static int numbers[];		// 조합을 저장하는 배열
	static int R;						// 뽑을 원소 개수
	static int tc;						// 조합 개수
	static int count;				// 재귀 함수 호출 수
	public static void main(String[] args) {
		    N = 26;
		    R = 10;
			numbers = new int[R];
			long stime = System.currentTimeMillis();
			combination(0,1);
			long etime = System.currentTimeMillis();
			System.out.printf("%dC%d의 조합의 시간 : %dms\n",N,R,(etime-stime));
			System.out.printf("%dC%d의 조합의 개수 : %d\n",N,R,tc);
			System.out.printf("%dC%d의 조합의 콜수 : %d\n",N,R,count);

	}
	
	public static void combination(int index, int start) {
		count++;
		if(index == R) {   // 한 개의 조합을 모두 만든 경우
			tc++;
//			System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=start; i<=N;i++) {
			numbers[index] = 1;
			combination(index+1,i+1);
		}
	}

}
