package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2105_디저트카페 {
	
	static int[] dr = {1,1,-1,-1};
	static int[] dc = {1,-1,-1,1};
	static boolean[] desert;
	static int map[][];
	static int N,answer,startR,startC;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			map = new int[N][N];
			desert = new boolean[101]; // 디저트 종류 먹음 표시
			answer = Integer.MIN_VALUE;
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 임의의 점에서 시작하므로 모든 점에서 한번씩 시도하도록 map 전체배열 순회
			for (int i = 0; i < N-2; i++) { // 행의 시작 범위는 N-3 까지 이고 그 이후는 사각형 구성 불가!
				for (int j = 0; j < N-1; j++) { // 열의 시작범위는 N-2까지 이고 그 이후는 사각형 구성 불가!
					startR = i; // 시작 R 위치
					startC = j; // 시작 C 위치
					dfs(startR,startC,0,1);
				}
			}
			// 갈 수 없는 경로면 -1 출력, 아니면 answer 출력
			System.out.println("#"+tc+" "+ (answer == Integer.MIN_VALUE ? -1 : answer));
		}

	}
	
	/**
	 * @param r 현재 위치 R
	 * @param c 현재 위치 C
	 * @param dir 현재 보는 방향
	 * @param cnt 현재까지 들린 디저트 카페 수
	 */
	private static void dfs(int r, int c, int dir, int cnt) {
		desert[map[r][c]] = true; // 디저트 종류 먹은걸로 체크를 처음에 바로 체크
		int nr=r, nc=c;
		for (int i = 0; i < 2; i++) {
			dir = dir+i;
			if(dir<4) { // 사각형을 그리기 위한 조건 (3일때 다시 0으로 돌아가면 안됨)
			nr = r + dr[dir];
			nc = c + dc[dir];
			}
			
			if(nr == startR && nc == startC) { // 시작위치로 돌아오면 종료
				answer = Math.max(answer, cnt);
				continue;
			}
			
			if(nr>-1 && nr<N && nc>-1 && nc<N && !desert[map[nr][nc]]) {
				dfs(nr,nc,dir,cnt+1);
			}
		}		
		desert[map[r][c]] = false; // 그 지역의 디저트 종류 안먹은 걸로 되돌림
	}

}
