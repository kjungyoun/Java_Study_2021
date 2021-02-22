package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  BOJ B1 13300 방배정 14852kb 144ms
 */
public class Main_B2_13300 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		int student[][] = new int[7][2];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int grade = Integer.parseInt(st.nextToken());
			student[grade][sex]++;
		}
		
		for (int i = 1; i < 7; i++) {
			for (int j = 0; j < 2; j++) {
				if(student[i][j] % k == 0) ans += student[i][j]/k;
				else ans += student[i][j]/k + 1;
			}
		}
		
		System.out.println(ans);

	}

}
