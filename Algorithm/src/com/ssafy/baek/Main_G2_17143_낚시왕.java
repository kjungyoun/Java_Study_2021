	package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G2_17143_낚시왕 {
	
	static class Shark{
		int row,col,speed,dir,size,cnt;

		public Shark(int row, int col, int speed, int dir, int size, int cnt) {
			super();
			this.row = row;
			this.col = col;
			this.speed = speed;
			this.dir = dir;
			this.size = size;
			this.cnt = cnt;
		}
	}
	
	static int R,C,M,sizeSum;
	static int[] dr = {-1,0,1,0};
	static int[] dc = {0,1,0,-1};
	static int[] direction = {0,2,1,3};  // 원하는 방향으로 만듬
	static Shark map[][];
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new Shark[R][C];
		
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(in.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int speed = Integer.parseInt(st.nextToken());
			int dir = direction[Integer.parseInt(st.nextToken())-1];
			int size = Integer.parseInt(st.nextToken());
			map[r][c] = new Shark(r,c,speed,dir,size,-1);
		}
		
		for (int m = 0; m < C; m++) {
			catchShark(m);
			moveAll(m);
		}
		
		System.out.println(sizeSum);

	}
	
	
	private static void moveAll(int cnt) {
		for (int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				if(map[r][c] != null && map[r][c].cnt < cnt)
					move(r,c,cnt);
			}
		}
		
	}

	
	private static void move(int r, int c, int cnt) {
		Queue<Shark>queue = new LinkedList<Shark>();
		queue.offer(map[r][c]);
		
		while(!queue.isEmpty()) {
			Shark sh = queue.poll();
			int row = sh.row;
			int col = sh.col;
			int dir = sh.dir;
			int size = sh.size;
			int speed = sh.speed;
			int count = sh.cnt;
			int move = 0;
			
			if(dir == 1 || dir == 3) 
				move = 2*(C-1);
			else
				move = 2*(R-1);
			
			speed %= move;
			
			int nr,nc;
			
			if(map[row][col].size == size) { // 이전위치가 자신일 때 지움
				map[row][col] = null;
			}
			
			
			if(speed == 0) { // 자신의 자리로 돌아온 상어일 때
				if(map[row][col] != null && map[row][col].size != size) {
					int curSize = map[row][col].size;
					if(curSize<size) {
						map[row][col] = new Shark(row,col,speed,dir,size,count+1);
						continue;	
					}
				}else {
					map[row][col] = new Shark(row,col,speed,dir,size,count+1);
					continue;					
				}
			}
			
			for (int i = 0; i < speed; i++) {
				nr = row + dr[dir];
				nc = col + dc[dir];
				
				if(nr<0 || nr>=R || nc<0 || nc>=C) { // 범위를 넘어설때
					dir = (dir+2)%4; // 자신의 반대방향을 가리킴
					nr = row + dr[dir];
					nc = col + dc[dir];
				}
				
				if(nr>-1 && nr<R && nc>-1 && nc<C) {  // 범위 내 일때
					if(i == speed-1) { // 마지막 위치일 때
						
						
						if(map[nr][nc] != null && map[nr][nc].cnt < cnt) { // 상어가 있고 이동하지 않은 상어일 때
							queue.offer(map[nr][nc]); // 해당 위치 상어 큐에 저장
							map[nr][nc] = new Shark(nr,nc,speed,dir,size,count+1); // 상어 덮어 쓰기
						}
						
						
						else if(map[nr][nc] != null && map[nr][nc].cnt == cnt) { // 이미 이동한 상어일 때
							int curSize = map[nr][nc].size;
							
							if(size > curSize) // 내가 더 클때
								map[nr][nc] = new Shark(nr,nc,speed,dir,size,count+1); // 상어 먹기
							
							else  // 내가 더 작으면 먹힘
								continue;
						}
						
						else
							map[nr][nc] = new Shark(nr,nc,speed,dir,size,count+1); // 상어 저장
					}
					
					row = nr;
					col = nc;
				}
			}
			
		}
		
	}
	

	private static void catchShark(int col) {
		for (int row = 0; row < R; row++) {
			if(map[row][col] != null) {
				int size = map[row][col].size;
				sizeSum += size;
				map[row][col] = null;
				return;
			}
		}
	}

}
