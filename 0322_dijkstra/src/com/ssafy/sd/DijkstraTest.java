package com.ssafy.sd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int V = Integer.parseInt(in.readLine()); // 정점의 개수
		int start = 0; // 시작 정점
		int end = V-1; // 도착 정점
		
		int[][] adjMatrix = new int [V][V];
		
		StringTokenizer st = null;
		
		// 인접 행렬 입력
		for (int i = 0; i < V; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < V; j++) {
				adjMatrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 시작점에서 각 정점까지의 최단 거리 저장
		int[] distance = new int[V];
		// 이미 지나온 정점 표시
		boolean[] visited = new boolean[V]; 
		
		// 각 거리를 최대값으로 셋팅
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[0] = 0;
		
		for (int i = 0; i < V; i++) {
		    int	min = Integer.MAX_VALUE;
		    int current = 0; // 현재 선택된 정점이 누군지 저장하는 변수
		    // step1 : 처리하지 않은 정점중에 출발지에서 가장 가까운 정점 선택
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > distance[j]) {
					min = distance[j];
					current = j;
				}
			}
			visited[current] = true;
			if(current == end) break;
			
			// step2 : 선택된 current를 경유지로 하여 아직 선택되지 않은 다른 정점으로의 최소 비용 비교
			for (int j = 0; j < V; j++) {
				if(!visited[j] && adjMatrix[current][j] !=0 && distance[j] > min + adjMatrix[current][j]) {
					// 현재 최소비용을 지금까지의 최소 경로를 거쳐 현재까지 오는 것으로 바꿈
					distance[j] = min + adjMatrix[current][j];
				}
			}
		}
		System.out.println(distance[end]);
	}

	
}
