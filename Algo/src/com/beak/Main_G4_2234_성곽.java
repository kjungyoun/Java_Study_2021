package com.beak;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_G4_2234_성곽 {
	
	static int N,M,max,count;
	static int [][] map, room;
	static boolean[][] visited;
	//				 서, 북, 동, 남
	static int dr[] = {0,-1,0,1};
	static int dc[] = {-1,0,1,0};
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		room = new int[N][M];
		visited = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(!visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		
		int plus = 0;
		int nr,nc;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(map[i][j] == max) {
					for (int k = 0; k < 4; k++) {
						nr = i+dr[k];
						nc = j + dc[k];
						if(nr>-1 && nr<N && nc>-1 && nc<M && room[i][j] != room[nr][nc]) {
							plus = Math.max(plus, map[i][j] + map[nr][nc]);
						}
					}
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
		System.out.println(plus);
	}
	
	private static void bfs(int i, int j) {
		Queue<int[]> queue = new LinkedList<int[]>();
		Queue<int[]> temp = new LinkedList<int[]>();
		queue.add(new int[] {i,j});
		temp.add(new int[] {i,j});
		visited[i][j] = true;
		
		while(!queue.isEmpty()) {
			int arr[] = queue.poll();
			int r = arr[0];
			int c = arr[1];
			
			int nr,nc;
			for (int k = 0; k < 4; k++) {
				if((map[r][c] & 1<<k) == 0) {
				nr = r + dr[k];
				nc = c + dc[k];
				if(nr>-1 && nr<N && nc>-1 && nc<M && !visited[nr][nc]) {
						visited[nr][nc] = true;
						queue.add(new int[] {nr,nc});
						temp.add(new int[] {nr,nc});
						
					}
				}
			}
		}
		
		int size = temp.size();
		max = Math.max(max, size);
		count++; // 방의 개수
		
		for (int k = 0; k < size; k++) {
			int arr[] = temp.poll();
			int r = arr[0];
			int c = arr[1];
			map[r][c] = size;
			room[r][c] = count;
		}
		
	}

}
