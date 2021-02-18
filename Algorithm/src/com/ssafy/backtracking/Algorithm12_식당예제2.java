package com.ssafy.backtracking;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm12_식당예제2 {
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
		if(!isAvailable(r,c)) return;
		if(c == C-1) {
			answer++;
			return;
		}
		isSelected[r][c] = true;
		pipe(r-1,c+1);
		pipe(r,c+1);
		pipe(r+1,c+1);
	}
	
	public static boolean isAvailable(int r, int c) {
		if(r<0 || r >= R || c < 0 || c >=C || map[r][c] == 'x' || isSelected[r][c]) return false;
		return true;
	}

}
