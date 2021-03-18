package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D4_3289_김정윤_서로소집합 {
	
	static int N;
	static int parents[];
	
	public static void makeSet() {
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}
	}
	
	public static int findSet(int num) {
		if(parents[num] == num) return num;
		return parents[num] = findSet(parents[num]);
	}
	
	public static void union(int a, int b) {
		if(check(a,b)) return;
		parents[findSet(b)] = findSet(a);
	}
	
	public static boolean check(int a, int b) {
		int rootA = findSet(a);
		int rootB = findSet(b);
		if(rootA == rootB) return true;
		return false;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			
			st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			parents = new int[N+1];
			makeSet();
			
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(test_case).append(" ");
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(in.readLine());
				int cal = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				switch (cal) {
				case 0:
					union(a,b);
					break;

				case 1:
					if(check(a,b)) sb.append(1);
					else sb.append(0);
					break;
				}
			}
			System.out.println(sb);
		}

	}

}
