package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17144_미세먼지안녕 {
	
	static int R,C;
	static int [][]map;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] cleanX;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		
		cleanX = new int[2];
		int idx = 0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) cleanX[idx++] = i;
			}
		}
		
		for (int i = 0; i < T; i++) {
			map = spread();
			clean();
		}
		
		int answer = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] != -1) {
					answer += map[i][j];
				}
			}
		}
		System.out.println(answer);
	}
	
	// 공기청정기 동작 구현
	private static void clean() {
		int r = cleanX[0]-1; // 공기청정기 윗부분
		int c = 0;
		int nr,nc;
		int idx = 0;
		while(true) {
			nr = r + dr[idx];
			nc = c + dc[idx];
			if(nr == cleanX[0] && nc == 0) {
				map[r][c] = 0;
				break;
			}
			if(nr>-1 && nr<cleanX[1] && nc>-1 && nc<C) {
				map[r][c] = map[nr][nc];
				r = nr;
				c = nc;
			}else idx = (idx+1)%4;
		}
		
		r = cleanX[1]+1; // 공기청정기 아랫부분;
		idx = 3;
		c = 0;
		while(true) {
			nr = r + dr[idx];
			nc = c + dc[idx];
			if(nr == cleanX[1] && nc == 0) {
				map[r][c] = 0;
				break;
			}
			if(nr>cleanX[0] && nr<R && nc>-1 && nc<C) {
				map[r][c] = map[nr][nc];
				r = nr;
				c = nc;
			}else idx = (idx+3)%4;
		}
	}

	
	// 미세먼지 확산 구현
	private static int[][] spread() {
		Queue<int[]> queue = new LinkedList<int[]>();
		// 미세먼지 확산 동시 구현을 위함
		int temp[][] = new int[R][C];
		temp[cleanX[0]][0] = -1;
		temp[cleanX[1]][0] = -1;
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if(map[i][j] !=0 && map[i][j] != -1)
					queue.add(new int[] {i,j});
			}
		}
		
		while(!queue.isEmpty()) {
			int tmp[] = queue.poll();
			int r = tmp[0];
			int c = tmp[1];
			int nr,nc;
			int cnt = 0;
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				if(nr>-1 && nr<R && nc>-1 && nc<C && map[nr][nc] != -1) {
					temp[nr][nc] += map[r][c]/5;
					cnt++;
				}
			}
			temp[r][c] += map[r][c] - (map[r][c]/5)*cnt;
		}
		
		return temp;
	}

}
