package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_D3_3307_최장증가부분수열_BinarySearch {
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
			
			int size = 0;
			LIS[size++] = input[0];
			for (int i = 1; i < N; i++) {
				int temp = Math.abs(Arrays.binarySearch(LIS, 0, size, input[i]))-1;
				LIS[temp] = input[i];
				if(size == temp) size++;
			}
			
			
			
			System.out.println("#"+tc+" "+size);
		}
	}
}
