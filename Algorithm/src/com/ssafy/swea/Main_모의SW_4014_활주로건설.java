package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_모의SW_4014_활주로건설 {
	static int N,X;
	static int[][] map;
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int i = 0; i < N; i++) {
				if(rowCheck(i,0)) answer++;
				if(colCheck(0,i)) answer++;
			}
			
			System.out.println("#"+tc+" "+answer);
		
		}

	}
	private static boolean colCheck(int r, int c) {
		int cnt = 1;
		for (int i = r; i < N-1; i++) {
			if(map[i][c] - map[i+1][c] == -1 && cnt >=X) { // 올라가는 경우
				cnt = 1;
				continue;
			}else if(map[i][c] - map[i+1][c] == 1) { // 내려가는 방향일 때 경사로 놓을 수 있는지
				if(colCheckDesc(i+1,c)) {
					i += X-1; // 경사로가 놓인 위치 건너뜀
					cnt = 0;
					continue;
				}else return false;
			}else if(map[i][c] == map[i+1][c]) cnt++;
			else return false; // 활주로 건설이 불가능한 상황
		}
		return true;
	}
	
	// 내리막일 때 현재 위치 이후에 경사로를 놓을 수 있는지 판단
	private static boolean colCheckDesc(int r, int c) {
		int cnt = 1;
		for (int i = r; i < N-1; i++) {
			if(map[i][c] != map[i+1][c] && cnt < X) return false;
			else if(map[i][c] != map[i+1][c] && cnt >= X) return true;
			cnt++;
		}
		if(cnt < X) return false;
		return true;
	}
	
	private static boolean rowCheck(int r, int c) {
		int cnt = 1;
		for (int i = c; i < N-1; i++) {
			if(map[r][i] - map[r][i+1] == -1 && cnt >= X) { // 올라가는 경우
				cnt = 1;
				continue;
			}else if(map[r][i] - map[r][i+1] == 1) { // 내려가는 경우
				if(rowCheckDesc(r,i+1)) { // 내려가는 방향일 때 경사로 놓을 수 있는지
					i += X-1; // 경사로가 놓인 위치 건너뜀
					cnt = 0;
					continue;
				} else return false;
			}else if(map[r][i] == map[r][i+1]) cnt++;
			else return false; // 활주로 건설이 불가능한 상황
		}
		return true;
	}
	
	// 내리막일 때 현재 위치 이후에 경사로를 놓을 수 있는지 판단
	private static boolean rowCheckDesc(int r, int c) {
		int cnt = 1;
		for (int i = c; i < N-1; i++) {
			if(map[r][i] != map[r][i+1] && cnt < X) return false;
			else if(map[r][i] != map[r][i+1] && cnt >= X) return true;
			cnt++;
		}
		if(cnt < X) return false;
		return true;
	}

}
