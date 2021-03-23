package com.ssafy.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dijkstra {
	
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		// 정점 개수
		int V = Integer.parseInt(in.readLine().trim());
		
		// 1. 초기화
		int [][] map = new int[V][V];		// 인접 정점에 대한 행렬 정보
		boolean[] visited = new boolean[V]; // 정점에 대한 방문 처리를 위한 배열
		int []distance = new int [V];		// 정점에 대한 최소 비용 처리를 위한 배열
		
		// 시작 정점
		int start = 0;
		// 도착 정점
		int end = V-1;
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < V; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 정점의 비용을 최대값으로 설정하기
		Arrays.fill(distance, Integer.MAX_VALUE);
		// 시작 정점에 0값을 입력하기
		distance[start] = 0;
		
		// 2. 각 정점 수만큼 반복해서 최소 비용 찾기
		int min = 0, cur = 0;
		for (int i = 0; i < V; i++) {
			min = Integer.MAX_VALUE;
			// 2.1 방문하지 않은 정점중에서 최소 비용의 정점을 선택
			for (int j = 0; j < V; j++) {
				if(!visited[j] && distance[j]<min) {
					min = distance[j];
					cur = j;
				}
			}
			
			// 2.2 최소비용으로 선택된 정점을 방문 처리하기
			visited[cur] = true;
			
			// 2.3 기존의 최소비용과 경유를 통한 비용중 더 적은 비용으로 갱신
			for (int j = 0; j < V; j++) {
				if(!visited[j] && map[cur][j] !=0  // 인접 되지 않은 정보
						&& distance[j]>min + map[cur][j]) {
					distance[j] = min + map[cur][j]; // 경유 비용이 더 최소이므로 갱신
				}
			}
			
		}
		System.out.println(distance[end]);
	}

}
