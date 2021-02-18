package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1773_김정윤 {
	static int[][]map = new int[19][19];
	// 오른위, 오른, 오른아래, 아래
	static int dr[] = {-1,0,1,1};
	static int dc[] = {1,1,1,0};
	static int count;
	public static void main(String[] args) throws IOException {
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = null;
	
	for (int i = 0; i < 19; i++) { // 입력 저장
		st = new StringTokenizer(in.readLine());
		for (int j = 0; j < 19; j++) {
			map[i][j] = Integer.parseInt(st.nextToken());
		}
	}
	for (int i = 0; i < 19; i++) {
		for (int j = 0; j < 19; j++) {
			if(map[i][j] != 0) { // 바둑돌이면
				for (int k = 0; k < 4; k++) {
					count = 1;
					if(match(i,j,k) && !isSix(i,j,k)) {
						System.out.println(map[i][j]);
						System.out.println((i+1) + " " + (j+1));
						return;
					}
				}
			}
		}
	}
	
	System.out.println(0);

	}
	
	public static boolean match(int r, int c, int idx) {
		// 바둑돌의 색깔 저장
		int color = map[r][c];
		int	nr = r + dr[idx];
		int	nc = c + dc[idx];
		
		if(count == 5) { 
			// 다음 바둑돌이 같은 색이면 6목이므로 false
			if(nr<19 && nr >-1 && nc < 19 && nc > -1 && map[nr][nc] == color) return false;
			return true;
		}
		
		if(nr<19 && nr >-1 && nc < 19 && nc > -1 && map[nr][nc] == color) {
			count++;
			if(match(nr,nc,idx))return true;			
		}
		return false;
	}
	
	public static boolean isSix(int r, int c, int idx) {
		int color = map[r][c];
		int nr, nc;
		nr = r-dr[idx];
		nc = c - dc[idx];
		if(nr > -1 && nr < 19 && nc >-1 && nc < 19 && map[nr][nc] == color) return true;
		return false;
	}
	
}
