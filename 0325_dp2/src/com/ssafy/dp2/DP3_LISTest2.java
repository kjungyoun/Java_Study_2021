package com.ssafy.dp2;

import java.util.Arrays;
import java.util.Scanner;

public class DP3_LISTest2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N]; // 원소들 저장
		int[] LIS = new int[N];	// 각 위치 = LIS의 길이를 만족하는 원소의 최소값
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int size = 0;
		for (int i = 0; i < N; i++) {
			int temp = Arrays.binarySearch(LIS, 0, size, arr[i]);
			temp = Math.abs(temp)-1; // 중복 값이 없으므로 탐색에 실패하여 음수값 리턴
			LIS[temp] = arr[i];	// 맨 뒤에 추가되거나 기존 위치에 덮어 쓰거나
			
			if(temp == size) { // 요소 하나가 배열의 끝에 추가됐다는 의미
				size++;
			}
		}
		System.out.println(size);
	}

}
