package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17069_파이프옮기기2_김정윤 {
	
	static int[][] map;
	static int[][][] D;
	static int N,cnt;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		// 0:가로, 1: 세로, 2:대각선
		D = new int[N][N][3];
		cnt = 0;
		
		
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		D[0][1][0] = 1;
		
		for (int i = 0; i < N; i++) {
			for (int j = 2; j < N; j++) {
				if(map[i][j] != 1) { // 가로로 두는 경우
					D[i][j][0] = D[i][j-1][0] + D[i][j-1][2];
				}
				if(i-1 >-1 && map[i][j] != 1) { // 세로로 두는 경우
					D[i][j][1] = D[i-1][j][1] + D[i-1][j][2];
				}
				if(i-1>-1 && map[i][j] != 1 && map[i-1][j] != 1 && map[i][j-1] != 1) { // 대각선으로 두는 경우
					D[i][j][2] = D[i-1][j-1][0] + D[i-1][j-1][1] +D[i-1][j-1][2];
				}
			}
		}
		int answer = D[N-1][N-1][0]+D[N-1][N-1][1]+D[N-1][N-1][2];
		System.out.println(answer);

	}

}
