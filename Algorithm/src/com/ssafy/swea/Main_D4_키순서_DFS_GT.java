package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D4_키순서_DFS_GT {

	static int N, M, adj[][]; // 뒤집어진 배열 radj 선언
	static int[] gtCnt, ltCnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N + 1][M + 1];
			gtCnt = new int[N+1];
			ltCnt = new int[N+1];
			StringTokenizer st = null;

			int i, j;
			for (int m = 0; m < N; m++) {
				st = new StringTokenizer(in.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i는 j보다 키가 작다
			} // 친구 키 관계로 인접 행렬 대입

			int ans = 0;
			for (int k = 1; k <= N; k++) {
				DFS(k, k,new boolean[N + 1]);
			}
			
			for (int k = 1; k <= N; k++) {
				if(gtCnt[k]+ltCnt[k] == N-1) ans++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void DFS(int cur,int src,boolean[] visited) {
		visited[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) { 
				visited[i] = true;
				gtCnt[src]++; // 현재 시작 정점보다 큰 애들을 저장
				ltCnt[i]++; // i번째 정점에 i보다 작은애들 저장
				DFS(i,src,visited);
			}
		}
	}

}
