package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G1_1194_달이차오른다가자 {
	
	static class Pos{
		int row,col,flag;

		public Pos(int row, int col, int flag) {
			super();
			this.row = row;
			this.col = col;
			this.flag = flag;
		}
	}
	
	static int N,M,ans,startR,startC;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static char[][] map;
	static boolean [][][] visited;
	static String door = "ABCDEF";	// '문' 인 값들 저장
	static String key = "abcdef";	// '키' 인 값들 저장
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visited = new boolean[N][M][1<<('g'-'a')]; // flag의 최대크기만큼 배열 생성
		
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j);
				if(map[i][j] == '0') { // 시작위치 저장
					startR = i;
					startC = j;
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	private static int bfs() {
		Queue<Pos> queue = new LinkedList<Pos>();
		queue.add(new Pos(startR,startC,0));  // 시작점 add
		visited[startR][startC][0] = true;
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for (int i = 0; i < size; i++) { // 사이즈 만큼 반복
				Pos temp = queue.poll();
				int r = temp.row;
				int c = temp.col;
				int flag = temp.flag;
				int nr,nc;
				
				// 만약 시작위치라면 ans 리턴
				if(map[r][c] == '1') return ans;
				
				for (int k = 0; k < 4; k++) {
					nr = r + dr[k];
					nc = c + dc[k];
					
					if(nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc][flag]) { // 배열 범위 안 && 방문하지 않았으면
						// 빈공간이거나 자신으로 돌아오거나 종료지점이면
						if(map[nr][nc] == '.' || map[nr][nc] == '0' || map[nr][nc] == '1') {
							visited[nr][nc][flag] = true;
							queue.add(new Pos(nr,nc,flag));
						}else if(key.contains(Character.toString(map[nr][nc]))) { // 키가 있으면
							visited[nr][nc][flag] = true;
							queue.add(new Pos(nr,nc, flag | 1<<(map[nr][nc]-'a')));
						}else if(door.contains(Character.toString(map[nr][nc]))) { // 문이면
							if((flag & 1<<(map[nr][nc]-'A')) != 0) {
								visited[nr][nc][flag] = true;
								queue.add(new Pos(nr,nc,flag));
							}
						}
					}
				}
			}
			ans++;
		}
		return -1; // 못찾았을 경우
	}

}
