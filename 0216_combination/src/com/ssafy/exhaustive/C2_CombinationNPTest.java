package com.ssafy.exhaustive;

import java.util.Arrays;
import java.util.Scanner;

public class C2_CombinationNPTest {
	static int N,R;
	static int[] input, check;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		// N 크기의 flag 배열
		check = new int [N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		// 가장 작은 순열 생성
		// NextPermutiation을 위한 초기 작업
		int cnt = 0;
		while(++cnt<=R) check[N-cnt] = 1;
		
		do {
			for (int i = 0; i < N; i++) {
				if(check[i] == 1) System.out.print(input[i]+" ");
			}
			System.out.println();
		} while (np());
	}
	
	public static boolean np() {
		int i = N-1;
		while(i>0 && check[i-1] >= check[i]) i--;
		
		if(i == 0) return false;
		
		int j = N-1;
		while(check[i-1]>= check[j]) --j;
		swap(i-1,j);
		
		int k = N-1;
		while(i< k)
			swap(i++,k--);
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = check[i];
		check[i] = check[j];
		check[j] = temp;
	}

}
