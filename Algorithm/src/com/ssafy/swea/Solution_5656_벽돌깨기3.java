package com.ssafy.swea;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기3 {
	
	static class Point{
		int r, c, cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	
	private static int N,W,H,min;
	private static int[] dr = {-1,1,0,0};
	private static int[] dc = {0,0,-1,1};
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			go(0,map); // 구슬 떨어뜨리기 구현
			System.out.println("#"+tc+" "+min);
		}
	}
	
	// 중복 순열로 구슬 떨어뜨리기
	// boolean = true - 모두 깨뜨린 상황
	private static boolean go(int cnt, int[][] map) { // cnt: 구슬을 떨어뜨린 횟수
		int result = getRemain(map);
		if(result == 0) { // 모두 빈칸(깨뜨릴 벽돌이 없다.
			min = 0;
			return true;
		}
		
		if(cnt==N) {
			min = Math.min(min, result);
			return false;
		}
		
		int [][] newMap = new int[H][W];
		// 매 열마다 구슬 떨어뜨리는 시도
		for (int c = 0; c < W; c++) {
			// 해당 열에 구슬을 떨어뜨려 맞는 벽돌 찾기
			int r=0;
			while(r<H && map[r][c] == 0) ++r;
			if(r==H) { // 맞는 벽돌 없음(모두 빈칸)
				continue; // 다음 열로 떨어뜨리기
			}else {
				// 기존 cnt-1 구슬까지의 상태로 초기화 (배열 복사)
				copy(map,newMap);
				// 벽돌 깨뜨리기
				boom(newMap,r,c);
				//벽돌 내리기(깨지고 난 빈 공간 처리)
				down(newMap);
				// 다음 구슬 던지기
				if(go(cnt+1, newMap)) return true;
			}
		}
		return false;
	}

	private static int getRemain(int[][] map) {
		int count=0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if(map[i][j] > 0) count++;
			}
		}
		return count;
	}

	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static void down(int[][] map) {
		
		for (int c = 0; c < W; c++) {
			for (int r = H-1; r >-1; r--) {
				if(map[r][c]>0) { // 벽돌이면
					list.add(map[r][c]);
					map[r][c] = 0;
				}
			}// 벽돌 리스트에 넣기
			int r = H;
			for (int b : list) { // 리스트에 담긴 벽돌 차례대로 꺼내어 맨 아래행부터 채우기
				map[--r][c] = b;
			}
			
		}
		
	}

	private static void boom(int[][]map,int r, int c) {
		
		Queue<Point> queue = new LinkedList<Point>();
		if(map[r][c] > 1) {
			queue.offer(new Point(r,c,map[r][c]));
		}
		map[r][c] = 0; //제거처리 (방문 효과)
		
		while(!queue.isEmpty()) {
			Point p = queue.poll();
			
			for (int d = 0; d < 4; d++) {
				int nr = p.r;
				int nc = p.c;
				for (int k = 1; k < p.cnt; k++) {
					nr += dr[d];
					nc += dc[d];
					if(nr>-1 && nr<H && nc>-1 && nc<W && map[nr][nc]!=0) {
						if(map[nr][nc]>1) {
							queue.offer(new Point(nr,nc,map[nr][nc]));
						}
						map[nr][nc]=0;
					}
				}
			}
		}
		
	}

	private static void copy(int[][] map, int[][] newMap) {
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				newMap[i][j] = map[i][j];
			}
		}
		
	}

}
