package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_G5_1753_최단경로_김정윤 {
	
	static class Node{
		int weight,to;

		public Node(int to, int weight) {
			super();
			this.weight = weight;
			this.to = to;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [weight=").append(weight).append(", to=").append(to).append("]");
			return builder.toString();
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점갯수
		int E = Integer.parseInt(st.nextToken()); // 간선갯수
		int start = Integer.parseInt(in.readLine())-1; // 시작점 입력
		
		ArrayList<Node>[] adjList = new ArrayList[V]; // 인접리스트 생성
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Node>(); // 인접리스트 배열에 ArrayList 초기화
		}
		int dir[] = new int [V]; // 시작점에서 각 정점까지 최단거리 저장 배열
		boolean visited[] = new boolean[V]; // 방문 표시 배열
		
		
		for (int i = 0; i < E; i++) { // 인접리스트 입력 저장
			st = new StringTokenizer(in.readLine());
			adjList[Integer.parseInt(st.nextToken())-1]
					.add(new Node(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())));
		}
		
		Arrays.fill(dir, Integer.MAX_VALUE); // 초기 Infinity 값으로 셋팅
		dir[start] = 0; // 시작점의 최단거리 배열 0으로 셋팅
		
		for (int i = 0; i < V; i++) {
			int min = Integer.MAX_VALUE;
			int cur = 0;
			for (int j = 0; j < V; j++) {
				if(!visited[j] && min > dir[j]) {
					min = dir[j];
					cur = j; // 최소 거리 정점 뽑음
				}
			}
			visited[cur] = true; // 해당 정점 방문 표시
			
			for (int j = 0, size = adjList[cur].size(); j < size; j++) {
				int idx = adjList[cur].get(j).to; // 인접 정점 번호
				int weight = adjList[cur].get(j).weight; // 인접 정점 가중치
				if(!visited[idx] && dir[idx] > min + weight) {
					dir[idx] = min + weight;
				}
			}
			
		}
		
		for (int x : dir) {
			if(x == Integer.MAX_VALUE) System.out.println("INF");
			else System.out.println(x);
		}

	}

}
