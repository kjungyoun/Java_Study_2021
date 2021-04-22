package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D4_키순서_DFS_Memo {

	static int N, M, adj[][]; // 뒤집어진 배열 radj 선언

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N + 1][M + 1];
			StringTokenizer st = null;
			
			for (int i = 0; i <= N; i++) adj[i][0] = -1; // 자신이 보다 큰 학생을 아직 탐색하지 않은 초기값

			for (int m = 0; m < N; m++) {
				st = new StringTokenizer(in.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i는 j보다 키가 작다
			} // 친구 키 관계로 인접 행렬 대입

			int ans = 0;
			for (int k = 1; k <= N; k++) {
				// 메모의 상태를 보고 아직 탐색전이면 자신보다 큰 학생 쭉 따라 검색
				if(adj[k][0] == -1) DFS(k); 
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[0][j] += adj[i][j];
				}
			}// 자신보다 작은 학생의 수 카운트
			
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] + adj[0][i] == N-1) ans ++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}

	}

	private static void DFS(int cur) {
		for (int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1) {
				if(adj[i][0]==-1) DFS(i); // 아직 탐색하지 않은 학생이면 탐색하러 가기
				
				// i학생을 탐색하고 왔거나, 이미 탐색이 되어있어서 탐색하지 않고 내려옴
				if(adj[i][0] > 0) { // i학생보다 큰 학생이 있다면
					for (int j = 1; j <= N; j++) {
						if(adj[i][j] == 1) adj[cur][j] = 1;
					}
				}
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += adj[cur][i]; // cur 학생보다 큰 학생들만 더해짐
		}
		adj[cur][0] = cnt;
	}

}
