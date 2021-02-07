package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D3_1873 {
	static char[][] map;
	static int index, r, c, H, W;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static char[] tank = { '^', 'v', '<', '>' };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine(), " ");
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][W];
			for (int i = 0; i < H; i++) {
				String line = in.readLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if (line.charAt(j) == '^') {
						r = i;
						c = j;
						index = 0;
					} else if (line.charAt(j) == 'v') {
						r = i;
						c = j;
						index = 1;
					} else if (line.charAt(j) == '<') {
						r = i;
						c = j;
						index = 2;
					} else if (line.charAt(j) == '>') {
						r = i;
						c = j;
						index = 3;
					}
				}
			}
			int N = Integer.parseInt(in.readLine());
			String line = in.readLine();
			for (int i = 0; i < N; i++) {
				if (line.charAt(i) == 'S') shoot(r,c);
				else turn(line.charAt(i));
			}
			System.out.print("#"+test_case+ " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

	public static void shoot(int r, int c) {
		int nr, nc;
		while (true) {
			nr = r + dr[index];
			nc = c + dc[index];
			if (nr > -1 && nr < H && nc > -1 && nc < W) {
				if (map[nr][nc] == '*') {
					map[nr][nc] = '.';
					break;
				}else if(map[nr][nc] == '#') break;
				r = nr;
				c = nc;
			}else break;
		}
	}
	
	public static void turn(char in) {
		if(in == 'U') {
			index = 0;
			map[r][c] = tank[index];
			move();
		}else if(in == 'D') {
			index=1;
			map[r][c] = tank[index];
			move();
		}else if(in == 'L') {
			index=2;
			map[r][c] = tank[index];
			move();
		}else if(in == 'R') {
			index=3;
			map[r][c] = tank[index];
			move();
		}
	}
	public static void move() {
		int nr,nc;
		nr = r+dr[index];
		nc = c + dc[index];
		if(nr>-1 && nr<H && nc>-1 && nc<W && map[nr][nc] == '.') {
			map[nr][nc] = map[r][c];
			map[r][c] = '.';
			r = nr;
			c = nc;
		}
	}
}
