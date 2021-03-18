package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D4_1486_장훈이의높은선반 {
	
	static int N,B,min,input[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			input = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			combination(0,0);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ").append(min);
			System.out.println(sb);
		}
	}
	private static void combination(int start, int sum) {
		if(sum >= B) {
			min = Math.min(min, sum-B);
			return;
		}
		
		for (int i = start; i < N; i++) {
			combination(i+1,sum+input[i]);
		}
		
	}
	
	

}
