package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_5644_무선충전 {
	
	static int M,bcCnt;
	static int[] pathA, pathB, playerA, playerB;
	static int[][] bc;
	static int[] dx = {0,0,1,0,-1};
	static int[] dy = {0,-1,0,1,0}; // 그대로, 상, 우, 하, 좌
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		playerA = new int[2]; // 사용자 A 위치
		playerB = new int[2]; // 사용자 B 위치
		
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			M = Integer.parseInt(st.nextToken());
			bcCnt = Integer.parseInt(st.nextToken());
			playerA[0] = playerA[1] = 1; // playerA 시작위치
			playerB[0] = playerB[1] = 10; // playerB 시작위치
			
			pathA = new int[M+1];
			pathB = new int[M+1];
			bc = new int[bcCnt][4];
			
			StringTokenizer stA = new StringTokenizer(in.readLine());
			StringTokenizer stB = new StringTokenizer(in.readLine());
			
			for (int i = 1; i <= M; i++) { // i=0 값은 0으로 남아있다. (0:그대로)
				pathA[i] = Integer.parseInt(stA.nextToken());
				pathB[i] = Integer.parseInt(stB.nextToken());
			}
			
			for (int i = 0; i < bcCnt; i++) {
				st = new StringTokenizer(in.readLine());
				bc[i][0] = Integer.parseInt(st.nextToken());	// x
				bc[i][1] = Integer.parseInt(st.nextToken());	// y
				bc[i][2] = Integer.parseInt(st.nextToken());	// 거리
				bc[i][3] = Integer.parseInt(st.nextToken());	// 충전량
			}
			
			System.out.println("#"+tc+" "+move());
	 	} // end for tc

	} // end for main
	
	
	private static int move() {
		int totalSum = 0;
		
		// 매시간마다의 각 위치에서 두 플레이어의 최대 충전량을 계산하여 합산
		for (int t = 0; t <=M; t++) { // 초기 위치도 충전 시도
			// 두 플레이어 궤적에 따라 이동
			playerA[0] += dx[pathA[t]];
			playerA[1] += dy[pathA[t]];
			playerB[0] += dx[pathB[t]];
			playerB[1] += dy[pathB[t]];
			
			// 현 위치에서 최대 충전량 계산
			totalSum += getMaxCharge();
		}
		return totalSum;
	}

	private static int check(int a, int x, int y) {
		return Math.abs(bc[a][0] - x) + Math.abs(bc[a][1] - y) <= bc[a][2] ? bc[a][3] : 0;
	}
	
	private static int getMaxCharge() {
		int max =0;
		for (int a = 0; a < bcCnt; a++) { // 플레이어 A가 선택한 BC
			for (int b = 0; b < bcCnt; b++) { // 플레이어 B가 선택한 BC
				// 0,0  0,1  0,2  1,0  1,1  1,2  2,0  2,1  2,2
				int sum = 0;
				int amountA = check(a,playerA[0],playerA[1]);
				int amountB = check(b,playerB[0],playerB[1]);
				
				// 두 충전소가 다르면
				if(a != b) sum = amountA + amountB;
				else sum = Math.max(amountA, amountB);
				if(max<sum) max = sum;
			}
		}
		return max;
	}

}
