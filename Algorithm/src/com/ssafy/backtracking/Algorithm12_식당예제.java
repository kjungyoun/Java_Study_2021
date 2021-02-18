package com.ssafy.backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm12_식당예제 {
	static int answer,R,C;
	static char [][] map;
	static boolean [][] isSelected;
	public static void main(String[] args) throws IOException {
//		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("res/Algorithm_12_input.txt")));
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		isSelected = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String line = in.readLine();
			for (int j = 0; j < C; j++) {
				map[i][j] = line.charAt(j);
			}
		}
		for (int i = 0; i < R; i++) {
			pipe(0,0);			
		}
		System.out.println(answer);
		

	}
	
	public static void pipe(int r, int c) {
		if(c == C-1) {
			answer++;
			return;
		}
		isSelected[r][c] = true;
		if(isAvailable(r-1,c+1))pipe(r-1,c+1); // 최대한 파이프를 깔아야하기 때문에 위로 최대한 붙임
		else if(isAvailable(r,c+1)) pipe(r,c+1); // 오른쪽 위로 못가면 오른쪽으로
		else {
			if(isAvailable(r+1,c+1)) pipe(r+1,c+1); // 그것도 안되면 오른쪽 아래로
			else return;  // 그것마저 안되면 파이프를 둘 수 없기때문
		}
	}
	
	public static boolean isAvailable(int r, int c) {
		if(r<0 || r >= R || c < 0 || c >=C || map[r][c] == 'x' || isSelected[r][c]) return false;
		return true;
	}

}
