package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S1_7576_토마토 {

	static int M,N;
	static int[][] map;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static Queue<int[]> queue;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		queue = new LinkedList<int[]>();
		
		// 입력 저장
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) { // 처음 익은 토마토 queue에 삽입
					queue.add(new int[] {i,j});
				}
			}
		}
		
		System.out.println(bfs());
		
	}
	
	
	private static int bfs() {
		int time = 0;
		int r,c,nr,nc;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int tmp[] = queue.poll();
				r = tmp[0];
				c = tmp[1];
				for (int j = 0; j < 4; j++) {
					nr = r + dr[j];
					nc = c + dc[j];
					if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] == 0) {
						map[nr][nc] = 1;
						queue.add(new int[] {nr,nc});
					}
				}
			}
			time++;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) return -1; // 익지 않은 토마토가 있을 때 -1 출력
			}
		}
		
		return time-1; // 맨 마지막 토마토 시간 count 해주는 것을 빼줌
	}
}
