package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D2_1974_김정윤 {
	static int[][] map;
	static boolean isSdo;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = 9;
		map = new int[N][N];
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			isSdo = true;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
				top:
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						rowCheck(i,j);
						if(!isSdo) break top;
						colCheck(i,j);
						if(!isSdo) break top;
						check(selectNum(i/3),selectNum(j/3),i,j);
						if(!isSdo) break top;
					}
				}
			System.out.print("#"+test_case+" ");
			if(isSdo) System.out.println(1);
			else System.out.println(0);
		}
	}
	
	public static void rowCheck(int r,int c) {
		// 행 고정, 열만 바뀜
		for (int i = 0; i < N; i++) {
			if(c != i && map[r][c] == map[r][i]) {
				isSdo = false;
				return;
			}
		}
	}

	public static void colCheck(int r,int c) {
		// 열 고정, 행만 바뀜
		for (int i = 0; i < N; i++) {
			if(r != i && map[r][c] == map[i][c]) {
				isSdo = false;
				return;
			}
		}
	}
	public static int selectNum(int i) {
		switch (i) {
		case 0:
			return 3;
		case 1:
			return 6;
		case 2:
			return 9;
		}
		return -1;
	}
	public static void check(int x, int y,int r, int c) {
		if(x == -1 || y == -1) return;
		for (int i = x-3; i < x; i++) {
			for (int j = y-3; j < y; j++) {
				if(r!= i && c!= j && map[r][c] == map[i][j]) {
					isSdo = false;
					return;
				}
			}
		}
	}
}
