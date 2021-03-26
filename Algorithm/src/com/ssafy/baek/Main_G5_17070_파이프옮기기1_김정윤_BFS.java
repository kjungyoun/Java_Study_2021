package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G5_17070_파이프옮기기1_김정윤_BFS {
	
	static class Pipe{
		int row,col,idx;

		public Pipe(int row, int col, int idx) {
			super();
			this.row = row;
			this.col = col;
			this.idx = idx;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Pipe [row=").append(row).append(", col=").append(col).append(", idx=").append(idx)
					.append("]");
			return builder.toString();
		}
		
	}
	
	public static int bfs() {
		ArrayList<Pipe> queue = new ArrayList<Pipe>();
		queue.add(new Pipe(0,1,0));
		
		while(!queue.isEmpty()) {
			Pipe temp = queue.remove(queue.size()-1);
			int r = temp.row;
			int c = temp.col;
			int idx = temp.idx;
			int index[] = dir(idx);
			int nr,nc;
			boolean flag = check(r,c);
			
			if(r == N-1 && c == N-1) {
				cnt++;
			}
			
			for (int i = 0,size = index.length; i < size; i++) {
				nr = r + dr[index[i]];
				nc = c + dc[index[i]];
				if(index[i] != 2 && nr<N && nc<N && map[nr][nc] == 0) {
					queue.add(new Pipe(nr,nc,index[i]));
				}else if(index[i] == 2 && nr<N && nc<N && flag && map[nr][nc] == 0) { // 대각선 움직임
					queue.add(new Pipe(nr,nc,index[i]));
				}
			}
		}
		return cnt;
	}
	
	public static int[] dir(int idx) {
		switch (idx) {
		case 0:
			return new int[] {0,2};
		case 1:
			return new int[] {1,2};
		case 2:
			return new int[] {0,1,2};
		}
		return null;
	}
	
	public static boolean check(int r, int c) {
		int nr,nc;
		boolean flag = true;
		for (int i = 0; i < 3; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr>-1 && nr<N && nc>-1 && nc<N && map[nr][nc] == 0) {
				continue;
			}
			flag = false;
		}
		return flag;
	}
	
	static int[][] map;
	static int N,cnt;
	static int dr[] = {0,1,1};
	static int dc[] = {1,0,1};
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		map = new int[N][N];
		cnt = 0;
		
		StringTokenizer st = null;
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(bfs());
		

	}

}
