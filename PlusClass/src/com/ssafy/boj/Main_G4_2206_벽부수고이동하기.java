package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2206_벽부수고이동하기 {
	
	static class Info{
		int row,col;
		int flag; // 벽을 부술수 있는가?
		
		public Info(int row, int col,int flag) {
			super();
			this.row = row;
			this.col = col;
			this.flag = flag; 
		}
		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Info [row=").append(row).append(", col=").append(col).append(", flag=").append(flag)
					.append("]");
			return builder.toString();
		}
		
	}
	
	public static int bfs() {
		Queue<Info> queue = new LinkedList<Info>();
		// 시작점 추가
		queue.add(new Info(0,0,1));
		visited[0][0][1] = true;
		
		int nr,nc;
		int count =1;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				Info temp = queue.poll();
				int r = temp.row;
				int c = temp.col;
				int flag = temp.flag;
				
				if(r == N-1 && c == M-1) {
					return count;
				}
				
				for (int j = 0; j < 4; j++) {
					nr = r + dr[j];
					nc = c + dc[j];
					if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] == 0 && !visited[nr][nc][flag]) {
						visited[nr][nc][flag] = true; // 방문 표시
						queue.add(new Info(nr,nc,flag));
					}else if(nr>-1 && nr<N && nc>-1 && nc<M && map[nr][nc] == 1 && flag == 1 && !visited[nr][nc][0]) {
						visited[nr][nc][0] = true;
						queue.add(new Info(nr,nc,0)); // 벽을 부쉈기 때문에 flag = 0
					}
				}
			}
			count++;
		}
		return -1;
	}
	
	static int N,M;
	static int map[][];
	static boolean[][][] visited;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visited = new boolean[N][M][2];
		
		// 입력 저장
		for (int i = 0; i < N; i++) {
			String line = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		// bfs
		System.out.println(bfs());
	}

}
