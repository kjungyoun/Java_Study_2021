package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D4_키순서_DFS2 {

	static int N, M, adj[][],radj[][]; // 뒤집어진 배열 radj 선언
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N + 1][M + 1];
			radj = new int[N+1][M+1];
			StringTokenizer st = null;

			int i, j;
			for (int m = 0; m < N; m++) {
				st = new StringTokenizer(in.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = radj[j][i] = 1; // i는 j보다 키가 작다
			} // 친구 키 관계로 인접 행렬 대입

			int ans = 0;
			for (int k = 1; k <= N; k++) {
				cnt = 0;
				DFS(k, adj, new boolean[N + 1]);
				DFS(k, radj, new boolean[N + 1]);
				if (cnt == N - 1)
					++ans; // 자신의 키 순서를 알 수는 학생임
			}
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void DFS(int cur, int[][] adj,boolean[] visited) {
		visited[cur] = true;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) { // adj에 따라 자신보다 큰 학생을 탐색하거나 자신보다 작은 학생을 탐색하는 의미
				visited[i] = true;
				cnt++;
				DFS(i,adj,visited);
			}
		}
	}

}
