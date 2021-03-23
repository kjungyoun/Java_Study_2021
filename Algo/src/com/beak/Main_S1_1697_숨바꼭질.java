package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_1697_숨바꼭질 {
	
	static int K,N,time;
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[100001];
		
		bfs();
		
		System.out.println(time);
	}
	
	public static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		visited[N] = true;
		
		time = 0;
		while(!queue.isEmpty()) {
			int size = queue.size();
			while(size-- > 0) {
				int current = queue.poll();
				if(current == K) return;
				if(current+1 < 100001 && !visited[current+1]) {
					queue.add(current+1);
					visited[current+1] = true;
				}
				if(current-1 > -1 && !visited[current-1]) {
					queue.add(current-1);
					visited[current-1] = true;
				}
				if(current*2 < 100001 && !visited[current*2]) {
					queue.add(current*2);
					visited[current*2] = true;
				}
			}
			time++;
		}
	}
}
