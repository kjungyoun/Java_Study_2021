package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main_D4_1249_보급로_PriorityQueue {
	
	static int N, INF = Integer.MAX_VALUE;
	static int map[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(in.readLine());
			
			map = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				char[] ch = in.readLine().toCharArray();
				for (int j = 0; j < N; j++) {
					map[i][j] = ch[j]-'0';
				}
			}
			System.out.println("#"+tc+" "+dijkstra(0,0));
		}

	}

	private static int dijkstra(int startR, int startC) {
		boolean [][] visited = new boolean[N][N];
		int[][] minTime = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			Arrays.fill(minTime[i], INF);
		}
		
		PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
			
		}); // 정점 r,c, 출발지부터 복구시간
		
		minTime[startR][startC] = 0;
		queue.offer(new int[] {startR,startC,minTime[startR][startC]});
		
		int[] current;
		int r=0,c=0,cost=0,nr,nc;
		while(true) {
			// 방문하지 않은 정점 중 출발지에서 자신으로 오는 비용이 최소인 정점 선택
			current = queue.poll();
			r = current[0];
			c = current[1];
			cost = current[2];
			
			// 해당 정점이 이미 처리가 된 것이라면 pass
			// 업데이트 과정에서 기존에 있는 값을 삭제하고 넣는 방식이 아니므로 기존의 정점이 중복으로 존재함
			if(visited[r][c]) continue;
			
			visited[r][c] = true;
			if(r == N-1 && c == N-1) return cost;
			
			// 선택된 정점 기준으로 인접한 정점 중에 방문하지 않은 나머지 정점들 
			// 자신과의 경유시의 비용과 기존 최소비용 비교하여 최소값 업데이트
			
			// 현재 선택된 정점 위치 기준으로 4방의 인접 정점 처리
			for (int i = 0; i < 4; i++) {
				nr = r + dr[i];
				nc = c + dc[i];
				
				if(nr>-1 && nr<N && nc>-1 && nc<N && !visited[nr][nc]
						&& minTime[nr][nc] > cost+map[nr][nc]) {
					minTime[nr][nc] = cost+map[nr][nc];
					queue.offer(new int[] {nr,nc,minTime[nr][nc]});
				}
			}
			
		}
	}

}
