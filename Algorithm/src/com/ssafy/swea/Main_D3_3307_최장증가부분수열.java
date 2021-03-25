package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D3_3307_최장증가부분수열 {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <=T; tc++) {
			
			int N = Integer.parseInt(in.readLine());
			
			int[] input = new int[N];
			int[] LIS = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			
			for (int i = 0; i <N; i++) {
				input[i] = Integer.parseInt(st.nextToken().trim());
			}
			
			int max = 0;
			for (int i = 0; i <N; i++) {
				LIS[i] = 1;
				for (int j = 0; j < i; j++) {
					if(input[i]>input[j] && LIS[j]+1 > LIS[i]) {
						LIS[i] = LIS[j]+1;
					}
				}
				max = Math.max(max, LIS[i]);
			}
			System.out.println("#"+tc+" "+max);
		}
	}
}
