package com.ssafy.exhasutive;

import java.util.Arrays;
import java.util.Scanner;

public class P4_PermutationNPTest {
	static int N;
	static int[] input, numbers;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		numbers = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		long stime = System.currentTimeMillis();
		
		// 1. 가장 작은 순열을 만들어 놓기 ⇒ 오름차순으로 정렬해놓기
		Arrays.sort(input); // 오름차순 정렬하여 가장 작은 순열의 상태로 만듦
		
		do {
//			System.out.println(Arrays.toString(input));
		}while(np()); // 2. 다음 큰 순열 만들기
		
		long etime = System.currentTimeMillis();
		System.out.printf("%dms",etime-stime);
	}
	
	/*
	 * NextPermutation
	 * - 현재 순열의 상태에서 사전순 (오름차순) 으로 나열했을 때 다음 단계의 순열을 생성
	 *  
	 * - 최종 목표 : 가장 큰 순열을 생성 => 가장 큰 순열을 생성하면 NP는 종료됨.
	 */
	public static boolean np() {
		// 배열의 가장 뒤에서부터 탐색
		// 2.1  교차점 찾기
		int i = N-1;
		while(i>0 && input[i-1]>= input[i]) --i;
		
		//  더이상 앞자리가 없는 상황 : 현 순열의 상태가 가장 큰 순열 ( 마지막 순열 )
		//  i = 0 이면 순열 생성 못함 ( 가장 마지막 순열 )
		if(i==0) return false;
		
		// 현재 i 값은 꼭대기 index 값
		
		// 뒤에서부터 탐색
		// 2.2  교차할 데이터 위치 찾기
		// 뒤쪽부터 탐색하여 교환할 큰 값 ( j ) 찾기
		int j = N-1;
		while(input[i-1]>=input[j]) --j;
		
		// j를 찾으면 서로 바꾸어줌
		// 2.3  i-1 번째와 j 번째 데이터 교환 ( swap )
		swap(i-1, j);
		
		int k = N-1;
		// 오름차순으로 정렬해줌
		// 2.4  다음 순열을 위해서 교환 후 꼭지 이후는 오름차순으로 바꾸어준다.
		while(i<k) {
			swap(i++,k--);
		}
		
		return true;
	}
	
	public static void swap(int i, int j) {
		int temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}
	
}
