package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D5_1247_김정윤_Backtracking {
	static int[][] location;
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
			st = new StringTokenizer(in.readLine());
			// 회사 & 집 좌표 저장
			location[0][0] = Integer.parseInt(st.nextToken());
			location[0][1] = Integer.parseInt(st.nextToken());
			location[N+1][0] = Integer.parseInt(st.nextToken());
			location[N+1][1] = Integer.parseInt(st.nextToken());
			
			// 고객 좌표 저장
			for (int i = 1; i < N+1; i++) {
				location[i][0] = Integer.parseInt(st.nextToken());
				location[i][1] = Integer.parseInt(st.nextToken());
			}
			
			backTracking(1,0,0,0);
			sb.append("#").append(test_case).append(" ").append(answer);
			System.out.println(sb);
		}

	}
	
	/*
	 * 백트래킹으로 구현
	 */
	public static void backTracking(int cnt, int sum, int idx, int flag) {
		if(answer < sum) return;
		
		if(cnt == N+1) {
			// 마지막 고객과 집과의 거리 계산
			int dist = Math.abs(location[idx][0] - location[N+1][0]) + Math.abs(location[idx][1]-location[N+1][1]);
			answer = Math.min(answer, sum+dist);
			return;
		}
		
		for (int i = 1; i < N+1; i++) {
			if((flag & 1 <<i) != 0) continue;
			int dist = Math.abs(location[idx][0] - location[i][0]) + Math.abs(location[idx][1]-location[i][1]);
			backTracking(cnt+1,sum+dist,i,flag | 1<<i);
			
		}
	}

}
