package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_G5_1916_최소비용구하기 {
	
	static class Edge{
		int to,weight;

		public Edge(int to, int weight) {
			super();
			this.to = to;
			this.weight = weight;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Edge [to=").append(to).append(", weight=").append(weight).append("]");
			return builder.toString();
		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int V = Integer.parseInt(in.readLine());
		int E = Integer.parseInt(in.readLine());
		
		int[] dist = new int[V+1]; // 최소 거리 저장
		LinkedList<Edge>[] adjList = new LinkedList[V+1]; // 인접 리스트
		boolean visited[] = new boolean[V+1];
		
		for (int i = 0; i <=V; i++) {
			adjList[i] = new LinkedList<Edge>();
		}
		
		for (int i = 0; i <E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			adjList[from].add(new Edge(to,weight));
		}
		
		st = new StringTokenizer(in.readLine());
		int start = Integer.parseInt(st.nextToken()); // 시작점
		int end = Integer.parseInt(st.nextToken()); // 끝점
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;
		
		
		int cur = 0;
		for (int i = 1; i <=V ; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				if(!visited[j] && min > dist[j]) {
					min = dist[j];
					cur = j;
				}				
			}
			
			visited[cur] = true;
			
			for (int j = 0, size = adjList[cur].size(); j < size; j++) {
				int idx = adjList[cur].get(j).to; // cur 의 인접 정점 번호
				int weight = adjList[cur].get(j).weight; // cur 정점에서 idx 정점까지의 거리
				
				if(!visited[idx] && dist[idx] > dist[cur] + weight) {
					dist[idx] = dist[cur] + weight;
				}
				
			}
		}
		System.out.println(dist[end]);
	}

}
