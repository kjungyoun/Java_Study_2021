package com.ssafy.boj;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/*
 * BOJ B1 10163 색종이 17160kb 200ms
 */
public class Main_B1_10164_solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 색종이 개수
		int[] ans = new int[N+1]; // 색종이의 보이는 면적 count
		int[][]map = new int [101][101]; // 전체 영역
		
		for (int n = 1; n <= N; n++) {
			int i = sc.nextInt();
			int j = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			for (int x = i; x < i+w; x++) {
				for (int y = j; y < j+h; y++) {
					map[x][y] = n;
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				ans[map[i][j]]++;
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			System.out.println(ans[i]);
		}
		

	}

}
