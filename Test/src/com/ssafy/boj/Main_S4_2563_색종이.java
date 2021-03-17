package com.ssafy.boj;

import java.util.Scanner;

public class Main_S4_2563_색종이 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int map[][] = new int [100][100];
		int N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			
			for (int j = r; j < r+10; j++) { // 색종이 배치
				for (int k = c; k < c+10; k++) {
					map[j][k] = 1;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if(map[i][j] == 1) count++;
			}
		}
		System.out.println(count);
		
	}

}
