package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_B2_2669 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int[][] map = new int[101][101];
		
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(in.readLine());
			int sr = Integer.parseInt(st.nextToken());
			int sc = Integer.parseInt(st.nextToken());
			int er = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			for (int j = sr; j <er; j++) {
				for (int k = sc; k < ec; k++) {
					map[j][k] = 1;
				}
			}
		}
		int count = 0;
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(map[i][j] == 1)count++;
			}
		}
		System.out.println(count);

	}

}
