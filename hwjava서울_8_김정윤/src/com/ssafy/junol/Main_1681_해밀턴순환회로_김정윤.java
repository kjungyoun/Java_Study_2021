package com.ssafy.junol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1681_해밀턴순환회로_김정윤 {
	
	static int min,N,cost[][],numbers[];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		cost = new int [N][N]; // 비용 맵 배열 생성
		numbers = new int[N+1]; // 순열 저장 배열
		StringTokenizer st = null;
		min = Integer.MAX_VALUE; // 최소 이동비용 변수
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		permutation(1,0,0); // 순열 시작
		System.out.println(min);
	}
	
	public static void permutation(int cnt, int flag, int sum) {
		if(min < sum) return; // 최소보다 합이 크면 버림
		if(cnt == N) {
			if(cost[numbers[N-1]][numbers[N]] != 0) { // cost[][] == 0 이면 이동 불가
				sum += cost[numbers[N-1]][numbers[N]]; // 마지막 위치에서 출발지로의 이동 비용 추가
				min = Math.min(min, sum);				
			}
			return;
		}
		
		for (int i = 1; i < N; i++) { // 1 ~ N-1 까지 순열 생성
			if((flag & 1<<i) != 0 || cost[numbers[cnt-1]][i] == 0) continue; // cost[][] == 0 이면 이동 불가
			numbers[cnt] = i; // numbers 배열에 저장
			permutation(cnt+1, flag | 1<<i, sum + cost[numbers[cnt-1]][i]);
		}
	}

}
