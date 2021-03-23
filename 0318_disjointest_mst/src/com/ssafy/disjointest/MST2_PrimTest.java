package com.ssafy.disjointest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MST2_PrimTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int[][] adjMatrix = new int[N][N]; // 특정 정점간의 간선 비용 저장
		boolean[] visited = new boolean[N]; // 정점이 선택됬는지 선택되지 않았는지 저장하는 배열
		int[] minEdge = new int[N]; 
		
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
			minEdge[i] = Integer.MAX_VALUE;
		}
		
		int result = 0;
		minEdge[0] = 0; // 0을 시작 정점으로 처리하기 위해 0 세팅
		
		for (int c = 0; c < N; c++) { 
			int min = Integer.MAX_VALUE;
			int minVertex = 0;
			// 신장트리에 연결되지 않은 정점중 minEdge 비용이 최소인 정점 
			for (int i = 0; i < N; i++) {
				if(!visited[i] && min > minEdge[i]) {
					min = minEdge[i];
					minVertex = i;
				}
			}
			result += min; // 해당 정점의 간선 비용 누적
			visited[minVertex] = true; // 선택된 정점을 신장트리에 포함
			
			for (int i = 0; i < N; i++) { // 자신과 자신으로 오는 정점들 중 최소 가중치인 것을 뽑음
				if(!visited[i] && adjMatrix[minVertex][i] != 0 && minEdge[i] > adjMatrix[minVertex][i]) {
					minEdge[i] = adjMatrix[minVertex][i];
				}
			}
		}
		System.out.println(result);
	}

}
