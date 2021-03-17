package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_2669_직사각형네개의합집합의면적구하기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int [][] map = new int[101][101];
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(in.readLine());
			int startR = Integer.parseInt(st.nextToken());
			int startC = Integer.parseInt(st.nextToken());
			int endR = Integer.parseInt(st.nextToken());
			int endC = Integer.parseInt(st.nextToken());
			
			for (int r = startR; r < endR; r++) {
				for (int c = startC; c < endC; c++) {
					map[r][c] = 1;
				}
			}
		}
		
		int count =0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j] == 1) count++;
			}
		}
		System.out.println(count);

	}

}
