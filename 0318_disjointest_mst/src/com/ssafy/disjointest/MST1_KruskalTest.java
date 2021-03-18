package com.ssafy.disjointest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MST1_KruskalTest {

	static class Edge implements Comparable<Edge> {
		int from, to, weight;

		public Edge(int from, int to, int weight) {
			super();
			this.from = from;
			this.to = to;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
//			return this.weight - o.weight;
			// 가중치가 양수나 음수가 될 경우에 발생하는 under, overflow 방지를 위해 아래처럼 정렬
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int V, E;
	static int parents[];
	static Edge[] edgeList;

	// 크기가 1인 단위 집합을 만드는 메서드
	static void make() {
		for (int i = 0; i < V; i++) {
			parents[i] = i;
		}
	}

	static int findSet(int a) {
		if (parents[a] == a)
			return a;
//		return findSet(parents[a]); // path compression 전
		return parents[a] = findSet(parents[a]); // path compression 후
	}

	// union의 리턴값은 없어도 되지만 알고리즘 문제를 풀 때 필요한 경우도 있음
	static boolean union(int a, int b) {
		int aRoot = findSet(a); // a 집합의 대표자
		int bRoot = findSet(b); // b 집합의 대표자
		if (aRoot == bRoot)
			return false;

		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		parents = new int[V];
		edgeList = new Edge[E];
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeList[i] = new Edge(from,to,weight);
		} // 간선리스트
		
		// 1. 간선리스트 가중치 기준 오름차순 정렬
		Arrays.sort(edgeList);
		
		make();
		int result = 0;
		int count = 0; // 선택한 간선 수
		
		for (Edge edge : edgeList) {
			if(union(edge.from, edge.to)) { // 싸이클이 발생하지 않았다면
				result += edge.weight;
				if(++count == V-1) break;
			}
		}
		System.out.println(result);
	}

}
