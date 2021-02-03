package com.ssafy.swea;

import java.util.Arrays;
import java.util.Scanner;

public class Main_D3_1873_김정윤 {
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static char tank[] = { '^', 'v', '<', '>' };
	static char curDir;
	static int r, c; // 전차의 현재 위치
	static int H, W;
	static int index ;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			H = sc.nextInt();
			W = sc.nextInt();
			char [][] map = new char[H][W];
			sc.nextLine();
			// map 입력 저장
			for (int i = 0; i < H; i++) {
				String line = sc.nextLine();
				for (int j = 0; j < W; j++) {
					map[i][j] = line.charAt(j);
					if(line.charAt(j)=='^') {
						curDir = line.charAt(j);
						r=i;
						c=j;
						index = 0;
					}else if(line.charAt(j)=='v') {
						curDir = line.charAt(j);
						r=i;
						c=j;
						index = 1;
					}else if(line.charAt(j)=='<') {
						curDir = line.charAt(j);
						r=i;
						c=j;
						index = 2;
					}else if(line.charAt(j)=='>') {
						curDir = line.charAt(j);
						r=i;
						c=j;
						index = 3;
					}
				}
			}
			
			// 사용자의 입력 저장
			int N = sc.nextInt();
			char []input = new char[N];
			String st = sc.next();
			for (int i = 0; i < N; i++) {
				input[i] = st.charAt(i);
			}
			
			// 사용자의 입력 수행
			for (int i = 0; i <N; i++) {
				if(input[i] == 'S') {
					shoot(r,c,map,index);
					continue;
				}
				turn(input[i],map);
				move(map);
				
				
			}
			System.out.printf("#%d ",test_case);
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}	
			
		}
	}

	/**
	 * 전차의 방향 회전을 구현
	 * @param dir	입력으로 들어온 방향 문자 값
	 * @return		현재 index를 리턴
	 */
	public static	 void turn(char dir, char[][]map) {
		if (dir == 'U') {
			map[r][c] = tank[0];
			index =  0;
		}
		else if (dir == 'D') {
			map[r][c] = tank[1];
			index= 1;
		}
		else if (dir == 'L') {
			map[r][c] = tank[2];
			index = 2;
		}
		else if (dir == 'R') {
			map[r][c] = tank[3];
			index= 3;
		}
	}

	/**
	 * 전차의 포탄 발사를 구현
	 * @param r			현재 전차의 행의 값 (포탄의 시작 위치)
	 * @param c			현재 전차의 열의 값 (포탄의 시작 위치)
	 * @param map		맵의 정보를 담은 배열
	 */
	public static void shoot( int r, int c, char[][] map, int index) {
		int nr, nc;
		while(true) {
			nr = r +dr[index];
			nc = c + dc[index];
			if(nr>-1 && nr < H && nc>-1 && nc<W) { // map 배열을 벗어나지 않았을 경우
				if(map[nr][nc] == '*') {
					map[nr][nc] = '.';
					break;
				}
				else if (map[nr][nc] == '#') break; // 강철이면 포탄 사라짐
			}
			else break; //map 배열을 벗어났을 경우
			r = nr;
			c = nc;
			
		}
	}
	
	/**
	 * 전차의 한 칸 이동을 구현
	 * @param map 맵의 정보가 담긴 배열
	 */
	public static void move(char[][]map) {
		int nr,nc;
		nr = r + dr[index];
		nc = c + dc[index];
		if(nr>-1 && nr<H && nc>-1 && nc<W) {
			if(map[nr][nc] == '.') {
				map[nr][nc] = tank[index];
				map[r][c] = '.';
				r = nr;
				c = nc;
			}
		}
	}
}
