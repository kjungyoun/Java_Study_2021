package com.ssafy.dp;

import java.util.Arrays;
import java.util.Scanner;

public class LISTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 원소들 저장
		int[] LIS = new int[N];	// 각 원소를 마지막에 세웠을 때 최장 길이
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0; // 전체 수열중에 가장 최장이 되는 수
		int size = 0; // LIS 개수이면서 LIS의 저장 위치
		
		LIS[size++] = arr[0]; // LIS의 0번째에 첫번째 숫자를 담음 (첫번째 수열 저장)
		
		for (int i = 1; i < N; i++) {
			// arr[i] : 탐색기 => 찾으면 찾은 데이터의 index를 리턴, 못 찾은 경우 음수 값으로 마지막까지 찾은 위치(-마지막까지 찾은 위치)
			int temp = Math.abs(Arrays.binarySearch(LIS,0,size,arr[i]))-1;
			LIS[temp] = arr[i];
			
			if(temp == size) {
				++size;
			}
		}
		System.out.println(size);
		System.out.println(Arrays.toString(LIS));
	}

}
