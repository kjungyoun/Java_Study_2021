package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_모의SW_2112_보호필름 {
	static int D,W,K,answer,map[][], tmp[][];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(in.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			map = new int[D][W]; // 입력 원본 정보 저장
			tmp = new int[D][W]; // map 배열 복사본
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = tmp[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			transform(0,0,0);
			System.out.println("#"+tc+" "+answer);
			
		}
	}
	
	private static void transform(int cnt, int row, int shot) {
		if(cnt == D) {
			if(check(tmp))
			answer = Math.min(answer, shot);
			return;
		}
		
		if(shot>answer) return; // 이미 answer 보다 커버리면 의미 없으므로 return
		
		transform(cnt+1,row+1,shot); // 약물투여 하지 않았을 때
		
		
		for (int i = 0; i < W; i++) {
			tmp[row][i] = 0;
		}
		transform(cnt+1,row+1,shot+1); // 약물0을 투여했을 때
		
		
		for (int i = 0; i < W; i++) {
			tmp[row][i] = 1;
		}
		transform(cnt+1,row+1,shot+1); // 약물1을 투여했을 때
		
		// 되돌아 왔을 때 tmp 배열 원래대로 되돌리기
		for (int i = 0; i < W; i++) {
			tmp[row][i] = map[row][i]; // 바꾼 곳을 원본 배열에서 원본데이터 가져오기
		}
	}

	private static boolean check(int[][] map) {
		for (int c = 0; c < W; c++) { // 열을 고정하여 검사
			int cnt=0,t=0,cel=0;
			
			for (int r = 0; r < D; r++) { // 해당 열의 각 행을 검사
				if(map[r][c] == cel) t++;
				else {
					cel = map[r][c];
					t = 1;
				}
				cnt = Math.max(cnt, t);
			}
			if(cnt>=K) continue; // 해당 열이 조건 만족시 계속
			else return false;	// 해당 열이 조건을 만족하지 못하면 false
		}
		return true;
	}

}
