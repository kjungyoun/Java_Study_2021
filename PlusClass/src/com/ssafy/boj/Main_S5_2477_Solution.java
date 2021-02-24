package com.ssafy.boj;

import java.util.Scanner;

public class Main_S5_2477_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int[][]arr = new int[6][2];
		int wMax = 0, hMax=0;
		for (int i = 0; i < 6; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			if(arr[i][0]<3)
				wMax = Math.max(wMax, arr[i][1]);
			else
				hMax = Math.max(hMax, arr[i][1]);
		}
		
		// 최솟값 구하기
		int min = 1;
		for (int i = 0; i < 6; i++) {
			if(arr[(i+5)%6][0] == arr[(i+1)%6][0]) { // 자신의 앞의 인덱스 & 자신의 뒤의 인덱스
				min *= arr[i][1];
			}
		}
		
		System.out.println((wMax*hMax - min)*K);
	}
	
}
