package com.ssafy.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */

public class G02_AdjListTest2 {
	
	static class Node{
		int vertex;
		// 가중치, ... 기타 정보들 -> next는 필요 없음
		
		public Node(int vertex) {
			this.vertex = vertex;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Node [vertex=").append(vertex).append("]");
			return builder.toString();
		}
		
	}
	
	static int N;
	static LinkedList<Node>[] adjList;
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int C = sc.nextInt();
		
		adjList = new LinkedList[N];
		visited = new boolean[N];
		
		// LinkedList가 Node를 관리해줄 것이므로 배열의 초기값이 null이면 안됨
		for (int i = 0; i < N; i++) {
			adjList[i] = new LinkedList<Node>();
		}
		
		for (int i = 0; i < C; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			adjList[from].addFirst(new Node(to));
			adjList[to].addFirst(new Node(from));
		}
		
		bfs();

	}
	private static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int cur = 0;
		queue.offer(cur);
		visited[cur]= true;
		
		while(!queue.isEmpty()) {
			cur = queue.poll();
			System.out.println((char)(cur+'A'));
			
			for (Node temp : adjList[cur]) {
				if(!visited[temp.vertex]) {
					queue.offer(temp.vertex);
					visited[temp.vertex] = true;
				}
			}
		}
		
	}

}
