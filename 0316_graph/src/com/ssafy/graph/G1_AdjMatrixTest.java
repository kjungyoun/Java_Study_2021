package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 7 정점 개수
 * 8 간선 개수
 * 0 1
 * 0 2
 * 1 3
 * 1 4
 * 2 4
 * 3 5
 * 4 5
 * 5 6
 */

public class G1_AdjMatrixTest {
	
	static int N;
	static boolean[][] adjMatrix;
	static boolean[] visited;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int C = Integer.parseInt(in.readLine());
		adjMatrix = new boolean[N][N];
		
		StringTokenizer st = null;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// 무향 그래프이므로 대칭적으로 정보 저장
			adjMatrix[from][to] = adjMatrix[to][from] =true;
		}
		
		System.out.println("====================bfs======================");
		bfs();
		System.out.println("====================bfs======================");
		visited = new boolean[N];
		dfs(0);
	}
	
	private static void dfs(int cur) {
		visited[cur] = true;
		System.out.println((char)(cur+'A'));
		for (int i = 0; i < N; i++) {
			if(adjMatrix[cur][i] && !visited[i]) {
				dfs(i);
			}
		}
		
	}

	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[]visited = new boolean[N];
		
		// 탐색 시작 정점: 0으로 출발
		int start = 0;
		queue.offer(start);
		visited[0] = true;
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			// 현재 정점에 관련된 처리
			System.out.println((char)(current+65));
			
			// 인접 정점 탐색
			for (int i = 0; i < N; i++) {
				if(adjMatrix[current][i] // 인접 정점 여부
						&& !visited[i]) { // 미방문 정점 여부
					queue.offer(i);
					visited[i] = true;
				}
				
			}
		}
		
	}

}
