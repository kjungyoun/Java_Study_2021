package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1037 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int N = Integer.parseInt(in.readLine());
		int map[][] = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		int rcount = 0; 
		int row = 0;
		int ccount = 0;
		int col = 0;
		for (int r = 0; r < N; r++) {
			int sum = 0;
			for (int c = 0; c < N; c++) {
				sum += map[r][c];
			}
			if(sum %2 != 0) {
				rcount++;
				row = r+1;
			}
			if(rcount>1) {
				System.out.println("Corrupt");
				return;
			}
		
		}
		
		for (int c = 0; c < N; c++) {
			int sum = 0;
			for (int r = 0; r < N; r++) {
				sum += map[r][c];
			}
			if(sum%2 != 0) {
				ccount++;
				col = c+1;
			}
			if(ccount>1) {
				System.out.println("Corrupt");
				return;
			}
		}
		
		if(rcount == 0 && ccount==0)
			System.out.println("OK");
		else if(rcount == 1 && ccount == 1)
			System.out.printf("Change bit (%d,%d)",row,col);
		
		
	}

}
