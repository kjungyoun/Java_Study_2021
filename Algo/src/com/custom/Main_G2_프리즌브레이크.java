package com.custom;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_프리즌브레이크 {
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static String map[][];
	static int N,M,startR,startC,endR,endC;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			
			// 지도 크기 입력
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 지도 선언
			map = new String[N][M];
			
			
			// 시작위치, 종료위치 저장
			st = new StringTokenizer(in.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			
			// 입력 저장
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = st.nextToken();
				}
			}
			
			System.out.println(bfs());
		}

	}
	
	public static int bfs() {
		Queue queue = new LinkedList<>();
		return 0;
	}
}
