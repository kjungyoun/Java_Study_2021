package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_G5_15683_감시 {
	
	static int N,M,answer,size;
	static int[] dr = {-1,0,1,0};	// 상,우,하,좌
	static int[] dc = {0,1,0,-1};	// 상,우,하,좌
	static List<int[]>list = new LinkedList<int[]>();
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]>0 && map[i][j]<6) {
					list.add(new int[] {i,j});	// cctv 위치 리스트에 추가
				}
			}
		}
		
		answer = Integer.MAX_VALUE;
		size = list.size();
		check(0,map);
		
		System.out.println(answer);
	}
	
	// cctv의 각 위치에서 회전했을 때 사각지대 모든 경우의 수 확인
	private static void check(int cnt, int[][] map) {
		if(size == cnt) {
			answer = Math.min(answer, count(map));
			return;
		}
		
		int r = list.get(cnt)[0];
		int c = list.get(cnt)[1];
		
		if(map[r][c] == 5) { // cctv가 5일때는 회전 필요 없음
			int tmp[][] = new int[N][M];
			tmp = copy(map); // map 배열 복사
			check(cnt+1,cctv(0,r,c,5,tmp)); // 복사한 배열을 넘김
		}else { // 각 cctv가 회전하는 모든 경우의 수를 확인
			for (int idx = 0; idx < 4; idx++) {
				int tmp[][] = new int[N][M];
				tmp = copy(map);
				check(cnt+1, cctv(idx, r, c, map[r][c], tmp));
			}
		}
		
	}

	// 배열을 복사하는 함수
	private static int[][] copy(int[][] map) {
		int tmp[][] = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
		return tmp;
	}

	
	// cctv 감시할 수 있는 공간을 cctv 종류별로 나누어 -1로 표시하고 return으로 넘김 
	private static int[][] cctv(int idx, int row, int col, int status, int[][] map) {
		int nr,nc;
		switch(status) {
		
		case 1:
			while(true) {
				nr = row + dr[idx];
				nc = col + dc[idx];
				
				if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] != 6) {
					if(map[nr][nc] == 0) {
						map[nr][nc] = -1;
					}
					row = nr;
					col = nc;
				}else break;
			}
			break;
			
		case 2:
			for (int i = 0; i < 2; i++) {
				// 다시 cctv 자리로 복귀
				int r = row;
				int c = col;
				idx  = (idx+(i*2))%4;
				while(true) {
					nr = r + dr[idx];
					nc = c + dc[idx];
					
					if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] != 6) {
						if(map[nr][nc] == 0) {
							map[nr][nc] = -1;
						}
						r = nr;
						c = nc;
					}else break;
				}
			}
			break;
			
		case 3:
			for (int i = 0; i < 2; i++) {
				// 다시 cctv 자리로 복귀
				int r = row;
				int c = col;
				idx  = (idx+i)%4;
				while(true) {
					nr = r + dr[idx];
					nc = c + dc[idx];
					
					if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] != 6) {
						if(map[nr][nc] == 0) {
							map[nr][nc] = -1;
						}
						r = nr;
						c = nc;
					}else break;
				}
			}
			break;
			
		case 4:
			for (int i = 0; i < 3; i++) {
				// 다시 cctv 자리로 복귀
				int r = row;
				int c = col;
				idx  = (idx+i)%4;
				while(true) {
					nr = r + dr[idx];
					nc = c + dc[idx];
					
					if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] != 6) {
						if(map[nr][nc] == 0) {
							map[nr][nc] = -1;
						}
						r = nr;
						c = nc;
					}else break;
				}
			}
			break;
			
		case 5:
			for (int i = 0; i < 4; i++) {
				// 다시 cctv 자리로 복귀
				int r = row;
				int c = col;
				idx  = (idx+i)%4;
				while(true) {
					nr = r + dr[idx];
					nc = c + dc[idx];
					
					if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] != 6) {
						if(map[nr][nc] == 0) {
							map[nr][nc] = -1;
						}
						r = nr;
						c = nc;
					}else break;
				}
			}
			break;
		}
		return map;
	}


	private static int count(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == 0) cnt++;
			}
		}
		return cnt;
	}

}
