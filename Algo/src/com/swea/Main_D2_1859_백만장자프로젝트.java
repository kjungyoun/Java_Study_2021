package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D2_1859_백만장자프로젝트 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			int[] arr = new int[N];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			long num = 0;
			for (int i = N-1, j = i-1; j > -1; j--) {
				if(arr[i] > arr[j]) {
					num += arr[i] - arr[j];
				}else if(arr[i] < arr[j]) {
					i = j;
				}
			}
			System.out.println("#"+test_case+" "+ num);
		}
	}

}
