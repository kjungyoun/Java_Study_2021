package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D5_1247_김정윤_Permutation {
	static int[][] location,numbers;
	static int answer,N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		StringBuilder sb = null;
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb = new StringBuilder();
			answer = Integer.MAX_VALUE;
			N = Integer.parseInt(in.readLine());
			location = new int [N+2][2];
			numbers = new int [N+2][2];
			st = new StringTokenizer(in.readLine());
			// 회사 & 집 좌표 저장
			location[0][0] = numbers[0][0] = Integer.parseInt(st.nextToken());
			location[0][1] = numbers[0][1] = Integer.parseInt(st.nextToken());
			location[N+1][0] = numbers[N+1][0] = Integer.parseInt(st.nextToken());
			location[N+1][1] = numbers[N+1][1] = Integer.parseInt(st.nextToken());
			
			// 고객 좌표 저장
			for (int i = 1; i < N+1; i++) {
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}
			
			permutation(1,0);
			sb.append("#").append(test_case).append(" ").append(answer);
			System.out.println(sb);
		}

	}
	
	/*
	 * 순열로 구현
	 */
	public static void permutation(int cnt, int flag) {
		
		if(cnt == N+1) {
			int sum = 0;
			for (int i = 1; i < N+2; i++) {
				sum += Math.abs(numbers[i-1][0]-numbers[i][0]) + Math.abs(numbers[i-1][1]-numbers[i][1]);
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for (int i = 1; i < N+1; i++) {
			if((flag & 1 <<i) != 0) continue;
			numbers[cnt] = location[i];
			permutation(cnt+1,flag | 1<<i);
			
		}
	}

}
