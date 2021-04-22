package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D4_키순서_BFS {
	
	static int N,M,adj[][];
	static int gtCnt,ltCnt;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			M = Integer.parseInt(in.readLine());
			adj = new int[N+1][M+1];
			StringTokenizer st = null;
			
			int i,j;
			for (int m = 0; m < N; m++) {
				st = new StringTokenizer(in.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i는 j보다 키가 작다
			} // 친구 키 관계로 인접 행렬 대입
			
			int ans = 0;
			for (int k = 1; k <= N; k++) {
				gtCnt = ltCnt = 0;
				gtBFS(k,new boolean[N+1]); // 자신보다 큰 학생 쭉 따라 탐색
				ltBFS(k,new boolean[N+1]); // 자신보다 작은 학생 쭉 따라 탐색
				if(gtCnt + ltCnt == N-1) ++ ans; // 자신의 키 순서를 알 수는 학생임
			}
			System.out.println("#"+tc+" "+ans);
		}

	}
	
	private static void gtBFS(int start, boolean[]visited) {
		Queue<Integer>queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[k][i] ==1) {
					queue.add(i);
					visited[i] = true;
					gtCnt++;
				}
			}
		}
	}
	
	private static void ltBFS(int start, boolean[]visited) {
		Queue<Integer>queue = new LinkedList<Integer>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int k = queue.poll();
			for (int i = 1; i <= N; i++) {
				if(!visited[i] && adj[i][k] ==1) {
					queue.add(i);
					visited[i] = true;
					ltCnt++;
				}
			}
		}
	}

}
