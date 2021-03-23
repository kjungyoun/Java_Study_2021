package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D4_1227_미로2 {
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int map[][];
	static int sr,sc; // 시작 위치
	static boolean visited[][]; // 방문 체크
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int test_case =1; test_case <= 10; test_case++) {
			in.readLine();
			map = new int[100][100]; // 미로 배열 생성
			visited = new boolean[100][100];
			
			for (int i = 0; i < 100; i++) {
				String line = in.readLine();
				for (int j = 0; j < 100; j++) {
					int input = line.charAt(j)-'0';
					map[i][j] = input;
					if(input == 2) { // 시작 위치이면
						sr = i;
						sc = j;
					}
				}
			}
			bfs(test_case);
		}

	}
	private static void bfs(int test) {
		Queue<int[]> queue = new LinkedList<int[]>();
		queue.add(new int[] {sr,sc});
		visited[sr][sc] = true;
		int nr,nc;
		int flag = 0;
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int r = temp[0];
			int c = temp[1];
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if(nr>-1 && nr < 100 && nc>-1 && nc<100) {
					if(map[nr][nc] == 0 && !visited[nr][nc]) {						
						queue.add(new int[] {nr,nc});
						visited[nr][nc] = true;
					}
					else if(map[nr][nc] == 3) {
						flag = 1;
						break;
					}
				}
			}
		}
		System.out.println("#"+test+" "+flag);
	}

}
