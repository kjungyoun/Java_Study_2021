package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1661_김정윤 {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static int map[][];
	static boolean isChecked[][];
	static int N, M, lastIndex, count, size,r,c,x,y;
	static int arr[][];

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(in.readLine());
		r = Integer.parseInt(st.nextToken()); // 출발 좌표
		c = Integer.parseInt(st.nextToken()); // 출발 좌표
		x = Integer.parseInt(st.nextToken()); // 도착 좌표
		y = Integer.parseInt(st.nextToken()); // 도착 좌표
		map = new int[M][N];
		isChecked = new boolean[M][N];
		size = (N + 2) * (M + 2);
		arr = new int[size + 1][2];

		for (int i = 0; i < M; i++) { // map에 각 인자 저장
			String line = in.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = Character.getNumericValue(line.charAt(j));
			}
		}
		isChecked[r][c] = true; // 첫 위치 check
		
		for (int i = r; i < N; i++) {
			for (int j = c; j < M; j++) {
				for (int k = 0; k < 4; k++) {
					int nr = i + dr[k];
					int nc = j + dc[k];
					if(nr>-1 && nr<M && nc>-1 && nc<N) {
						if(map[nr][nc] == 0 && !isChecked[nr][nc]) {
							
						}
					}
				}
			}
		}
		bfs(1);
		System.out.println(count);
	}

	public static void add(int r, int c) {
		if (lastIndex == size)
			return;
		arr[++lastIndex][0] = r;
		arr[lastIndex][1] = c;
	}

	public static void bfs(int index) {
		if(lastIndex == 0)return;
		Queue<Integer>queue = new LinkedList<Integer>();
		queue.offer(1);
		int current;
		while(!queue.isEmpty()) {
			current = queue.poll();
			int i = arr[current][0];
			int j = arr[current][1];
			if(i != r &&  j != c) { // 시작 위치가 아닐때 검사
				if(map[i][j] == 0 && !isChecked[i][j]) {
					isChecked[i][j] = true;
					count++;
				}
			}
			if(current*4-2<=size) queue.offer(current*4-2);
			if(current*4-1<=size) queue.offer(current*4-1);
			if(current*4<=size) queue.offer(current*4);
			if(current*4+1<=size) queue.offer(current*4+1);
		}
		
	}

}
