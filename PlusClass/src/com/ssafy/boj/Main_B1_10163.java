package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * BOJ B1 10163 색종이 17160kb 200ms
 */
public class Main_B1_10163 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int map [][] = new int[101][101];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(in.readLine());
			int sR = Integer.parseInt(st.nextToken());
			int sC = Integer.parseInt(st.nextToken());
			int width = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			for (int r = sR; r < sR+width; r++) {
				for (int c = sC; c < sC+height; c++) {
					map[r][c] = i;
				}
			}
		}
		
		for (int k = 1; k <= N; k++) {
			int sum = 0;
			for(int i = 0; i< 101; i++) {
				for (int j = 0; j < 101; j++) {
					if(map[i][j] == k) sum++;
				}
			}
			System.out.println(sum);
		}
		
		

	}

}
