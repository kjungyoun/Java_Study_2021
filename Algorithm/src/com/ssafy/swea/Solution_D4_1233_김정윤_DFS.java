package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_1233_김정윤_DFS {
	static int AnswerN,N;
	static char [][]arr;
	static Queue<char []> queue;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= 10; test_case++) {
			queue = new LinkedList<char[]>();
			AnswerN =1;
			N = Integer.parseInt(in.readLine());
			arr = new char[N+1][4];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = st.nextToken().charAt(0);
				}
				
			}
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}
	
	public static void dfs(int index) {
		if(index*2>N || index*2+1 > N) return;
		dfs(index*2);
		dfs(index*2+1);
	}

}
