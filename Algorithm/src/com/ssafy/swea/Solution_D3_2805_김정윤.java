package com.ssafy.swea;

import java.util.Scanner;

public class Solution_D3_2805_김정윤 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] farm = new int[N][N]; // 배열 생성
			int sum = 0;

			sc.nextLine();

			for (int i = 0; i < N; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < N; j++) {
					farm[i][j] = Character.getNumericValue(line.charAt(j));
				}
			}
			// 정 가운데 좌표를 기준으로 십자가 좌표 먼저 더하기
			// 중복 검사를 피하기 용
			int center = N / 2;
			for (int i = 0; i < N; i++) {
				sum += farm[center][i]; // 세로 줄 더하기
				sum += farm[i][center]; // 가로 줄 더하기
			}
			
			sum -= farm[center][center];

			for (int i = 1; i <= center; i++) {
				for (int j = 1; j <= center - i; j++) {
					sum += farm[center + j][center - i];
					sum += farm[center - j][center - i];
					sum += farm[center + j][center + i];
					sum += farm[center - j][center + i];
				}

			}
			System.out.printf("#%d ", test_case);
			System.out.println(sum);
		}
	}

}
