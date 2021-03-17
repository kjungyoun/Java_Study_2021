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

public class G2_AdjListTest {
	
	static class Node{
		int vertex;
		Node next;
		public Node(int vertex, Node next) {
			super();
			this.vertex = vertex;
			this.next = next;
		}
		public Node(int vertex) {
			super();
			this.vertex = vertex;
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [vertex=").append(vertex).append(", next=").append(next).append("]");
			return builder.toString();
		}
		
	}
	
	static int N;
	static Node[] adjList;
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		int C = Integer.parseInt(in.readLine());
		adjList = new Node[N];
		
		StringTokenizer st = null;
		for (int i = 0; i < C; i++) {
			st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			// 현재 from에 있는 Node가 나의 다음 노드로 오게 포지셔닝함
			// 즉 리스트의 맨앞에 삽입하는 과정!
			adjList[from] = new Node(to,adjList[from]);
			adjList[to] = new Node(from,adjList[to]);
			
		}
		System.out.println("====================bfs======================");
		bfs();
		
	}
	private static boolean[] visited;
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[]visited = new boolean[N];
		
		int start = 0;
		queue.offer(0);
		visited[0] = true;
		while(!queue.isEmpty()) {
			int current = queue.poll();
			System.out.println((char)(current+65));
			
			for (Node temp = adjList[current]; temp != null;temp = temp.next) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
	}
	
	private static void dfs(int current) {
		visited[current] = true;
		System.out.println((char)(current+65));
		
		for (Node temp = adjList[current]; temp != null; temp = temp.next) {
			if(!visited[temp.vertex]) {
				dfs(temp.vertex);
			}
		}
	}

}
