package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_2636_치즈_김정윤 {

	static int N, M,cnt,time;
	static int map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		time = 0;
		while(check()) {
			bfs();
		}
		System.out.println(time);
		System.out.println(cnt);
	}
	
	// 녹지 않은 치즈 확인
	public static boolean check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1)
					return true;
			}
		}
		return false;
	}
	
	public static void bfs() {
		Queue<int[]> search = new LinkedList<int[]>();
		Queue<int[]> cheeze = new LinkedList<int[]>();
		boolean[][] visited = new boolean[N][M];
		boolean[][] melt = new boolean[N][M];
		search.add(new int[] {0,0});
		visited[0][0] = true;
		
		int nr,nc;
		
		// 바깥 치즈 찾기
		while(!search.isEmpty()) {
			int temp[] = search.poll();
			int r = temp[0];
			int c = temp[1];
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				
				if(nr>-1 && nr<N && nc>-1 && nc<M) {
					if(map[nr][nc] == 0 && !visited[nr][nc]) {
						visited[nr][nc] = true;
						search.add(new int[] {nr,nc});
					}
					else if(map[nr][nc] == 1 && !melt[nr][nc]) {
						melt[nr][nc] = true;
						cheeze.add(new int[] {nr,nc});
					}
				}
			}
		}
		
		// 큐의 요소 개수 = 녹은 치즈 개수
		cnt = cheeze.size();
		
		// 치즈 녹이기
		while(!cheeze.isEmpty()) {
			int temp[] = cheeze.poll();
			int r = temp[0];
			int c = temp[1];
			map[r][c] = 0;
		}
		time ++;
	}

}
