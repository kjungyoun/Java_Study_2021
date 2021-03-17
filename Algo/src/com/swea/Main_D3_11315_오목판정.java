package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_D3_11315_오목판정 {
	static int dr[] = {-1,-1,-1,0,1,1,1,0};
	static int dc[] = {-1,0,1,1,1,0,-1,-1};
	static int N;
	static char map[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		top: for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(in.readLine());
			map = new char[N][N];
			boolean answer = false;
			for (int i = 0; i < N; i++) {
				String line = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'o') {
						for (int k = 0; k < 8; k++) {
							answer = five(k,i,j,1);
							if(answer) {
								System.out.println("#"+test_case+" YES");
								continue top;
							}
						}
					}
				}
			}
			System.out.println("#"+ test_case+" NO");
			
			
		}

	}
	
	public static boolean five(int dir, int r, int c, int cnt) {
		int nr,nc;
		while(true) {
			nr = dr[dir] + r;
			nc = dc[dir] + c;
			if(nr>-1 && nr < N && nc > -1 && nc < N && map[nr][nc] == 'o') {
				cnt++;
				r = nr;
				c = nc;
			}else break;
		}
		if(cnt >= 5) return true;
		else return false;
	}

}
