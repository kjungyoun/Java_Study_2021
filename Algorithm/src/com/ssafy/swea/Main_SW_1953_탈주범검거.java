package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_SW_1953_탈주범검거 {
	static int N,M,R,C,L;
	static int[][] map;
	static int[][] dr = {{0},{-1,1,0,0},{-1,1},{0,0},{-1,0},{1,0},{1,0},{-1,0}};
	static int[][] dc = {{0},{0,0,-1,1},{0,0},{-1,1},{0,1},{0,1},{0,-1},{0,-1}};
	static int[][][] direction = {
			{{0}},
			{{1,2,5,6},{1,2,4,7},{1,3,4,5},{1,3,6,7}},
			{{1,2,5,6},{1,2,4,7}},
			{{1,3,4,5},{1,3,6,7}},
			{{1,2,5,6},{1,3,6,7}},
			{{1,2,4,7,},{1,3,6,7}},
			{{1,2,4,7},{1,3,4,5}},
			{{1,2,5,6},{1,3,4,5}}
	};
	static boolean[][] visited;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+tc+" "+bfs());
		}
	}
	
	private static int bfs() {
		Queue<int[]>queue = new LinkedList<int[]>();
		int time = 1;
		int count = 0;
		queue.add(new int[] {R,C});
		count++;
		visited[R][C] = true;
		
		while(!queue.isEmpty()) {
			if(time == L) break;
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				int temp[] = queue.poll();
				int r = temp[0];
				int c = temp[1];
				int dir = map[r][c];
				int nr,nc;
				int end = dr[dir].length;
				for (int k = 0; k < end; k++) {
					nr = r + dr[dir][k];
					nc = c + dc[dir][k];
					
					if(nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc] && check(nr,nc,dir,k)) {
						queue.add(new int[] {nr,nc});
						visited[nr][nc] = true;
						count++;
					}
				}
			}
			time++;
		}
		
		return count;
	}

	private static boolean check(int r, int c, int dir, int k) {
		for (int i = 0; i < 4; i++) {
			if(map[r][c] == direction[dir][k][i]) return true;
		}
		return false;
	}

}
