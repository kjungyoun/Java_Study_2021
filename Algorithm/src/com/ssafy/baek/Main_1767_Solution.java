package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1767_Solution {
	static int N,max,totalCnt,min,map[][];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static ArrayList<int[]> list; // 고려해야하는 코어만 담고 있는 리스트 (가장자리 코어는 배제)
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int T = Integer.parseInt(in.readLine().trim());
		for (int test_case =1; test_case <=  T; test_case++) {
			N = Integer.parseInt(in.readLine().trim());
			map = new int[N][N];
			list = new ArrayList<int[]>();
			max = 0;
			min = Integer.MAX_VALUE;
			totalCnt = 0;
			
			for (int i = 0; i < N; i++) { // 입력 저장
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i == 0 || j == 0 || i == N-1 || j == N-1) continue; // 가장자리는 무시
					if(map[i][j] == 1) {
						list.add(new int[] {i,j});
						totalCnt++;
					}
				}
			}
			
			go(0,0);
			System.out.println("#"+test_case+" "+ min);
			
		}
	}
	/**
	 * 
	 * @param idx 부분집합에 고려할 코어 인덱스
	 * @param cCnt 연결된 코어 개수
	 */
	public static void go(int idx, int cCnt) {
		// 가지치기 totlaCnt - index : 남은 코어 수
		// cCnt + 남은 코어수 < max  => 가지치기 조건
		
		if(idx == totalCnt) {
			int res = getLength(); // 놓아진 전선의 길이 구하기
			
			if(max < cCnt) {
				max = cCnt;
				min = res;
			}else if (max == cCnt) {
				if(res < min) min = res;
			}
			return;
		}
		
		// 코어 선택 후 전선 놓아보기 (4방향으로 놓아보기)
		int[] cur = list.get(idx);
		int r = cur[0];
		int c = cur[1];
		
		for (int i = 0; i < 4; i++) {
			if(isAvailable(r,c,i)) { // 끝까지 갈 수 있으면
				// 전선을 놓기
				setStatus(r,c,i,2);
				// 다음 코어로 넘어감
				go(idx+1,cCnt+1);
				// 놓았던 전선 되돌리기 (메서드로 구현)
				setStatus(r,c,i,0);
			}
		}
		
		// 코어 비선택
		go(idx+1, cCnt);
	}
	
	/**
	 * 
	 * @param r 현재 위치 행값
	 * @param c 현재 위치 열값
	 * @param dir 현재 이동할 방향
	 * @param s 전선을 놓는지 수거하는지
	 */
	private static void setStatus(int r, int c, int dir, int s) {
		int nr =r, nc = c;
		while(true) {
			nr += dr[dir];
			nc += dc[dir];
			
			if(nr<0 || nr >=N || nc < 0 || nc >= N) break;
			
			map[nr][nc] = s;
		}
	}
	
	private static boolean isAvailable(int r, int c, int dir) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[dir];
			nc += dc[dir];
			
			// 계속해서 해당방향으로 직진을 해서 경계를 벗어남 = 전원 연결 가능
			if(nr<0 || nr >=N || nc < 0 || nc >= N) break;
			
			// 해당 자리에 코어가 있거나 전선이 놓아져있으면 불가능
			if(map[nr][nc] >= 1) return false;
		}
		return true;
	}
	
	/*
	 * 놓아진 전선의 길이 구하기
	 */
	private static int getLength() {
		int lCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 2) lCnt++;
			}
		}
		return lCnt;
	}

}
