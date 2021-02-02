package com.ssafy.permutaion;

import java.util.Arrays;

public class PermutationTest {
	static int N;    // 원소의 개수
	static int cnt;  // 수열의 자리수
	static int numbers[];  // 수열이 저장될 배열
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static void permutation(int cnt) {
		if(cnt==N) {
			System.out.println(Arrays.toString(numbers));
			return;
		}
		top:
		for(int i=1;i<=N;i++) {
			for (int j = 0; j < cnt; j++) {
				if(numbers[j]==i) 
				continue top;
			}
			numbers[cnt] = i;
			permutation(cnt+1);
		}
	}

}
