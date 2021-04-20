package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_모의SW_1949_등산로조성2 {
	
	static int N,K,answer,map[][],tmp[][];
	static boolean visited[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			tmp = new int[N][N];
			visited = new boolean [N][N];
			answer = -1;
			int max = 0; // 최대 봉우리 높이 저장
			
			// 입력 저장
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = tmp[i][j] = Integer.parseInt(st.nextToken());
					max = Math.max(max, map[i][j]);
				}
			}
			
			List<int[]> list = new LinkedList<int[]>();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					// 높이가 최대인 봉우리 dfs 돌림
					if(map[i][j] == max) 
						dfs(i,j,1,K);
				}
			}
			
			System.out.println("#"+tc+" "+answer);
			
		}

	}
	
	private static void dfs(int r, int c, int cnt, int k) {
		visited[r][c] = true; // 방문 처리
		int nr,nc;
		
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if(nr>-1 && nr<N && nc>-1 && nc<N && !visited[nr][nc]) {
				int diff = tmp[nr][nc] - tmp[r][c];
				if(diff<0) dfs(nr,nc,cnt+1,k); // 다음이 나보다 낮은 경우
				else if(diff+1 <= k) { // 공사가 가능한 경우
					tmp[nr][nc] -= diff+1; // 해당 위치 공사
					dfs(nr,nc,cnt+1,k-k); // 공사 가능 깊이를 0으로 만듬
				}
			}
		}
		// 아무대도 가지 못할 경우
		answer = Math.max(answer, cnt); // answer 에 cnt 저장
		if(tmp[r][c] != map[r][c]) // 공사했으면 원래대로 돌림
			tmp[r][c] = map[r][c];
		visited[r][c] = false; // 방문처리 원래대로
	}

}
