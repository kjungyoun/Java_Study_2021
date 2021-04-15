package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범검거_sol_dfs {
	
	
	static int N,M,R,C,L,map[][],visited[][];
	static int[] dr = {-1,0,0,1}; // 상0, 좌1, 우2, 하3
	static int[] dc = {0,-1,1,0}; // 상0, 좌1, 우2, 하3
	static String[] type = { // 각 구조물의 타입에 따라 이동할 수 있는 방향 저장
			null, // 인덱스를 1부터 시작하도록 자리 맞춤
			"0312", // 1: 상하좌우
			"03", //   2: 상하
			"12", //   3: 좌우
			"02", //   4: 상우
			"32", //   5: 하우
			"31", //   6: 하좌
			"01" //    7: 상좌
	};
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			visited = new int[N][M]; // 방문 처리를 시간으로 관리
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = Integer.MAX_VALUE; // 최소값 갱신 위해 맥스값으로 초기화
				}
			}
			dfs(R,C,1);
			System.out.println("#"+tc+" " +getCount());
		}

	}
	
	private static int getCount() {
		int count = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(visited[i][j] != Integer.MAX_VALUE) count++;
			}
		}
		return count;
	}
	private static void dfs(int r, int c, int time) {
		
		visited[r][c] = time;
		if(time==L) return;
		
		String info = type[map[r][c]]; // 현 구조물의 타입으로 이동가능한 방향의 정보
		
		for (int d = 0, length=info.length(); d <length ; d++) {
			int dir = info.charAt(d)-'0';
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			
			if(nr>-1 && nr< N && nc>-1 && nc<M 
					&& map[nr][nc] > 0  
					&& type[map[nr][nc]].contains(Integer.toString(3-dir))
					&& visited[nr][nc] > time) {
				dfs(nr,nc,time+1);
			}
		}
		
		
		
	}

}
