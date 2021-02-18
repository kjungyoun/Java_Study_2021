package com.ssafy.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Algorithm12_식당예제_sol {
	
	static int R,C,cnt =0;
	static char[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][];
		visited = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}
		cnt = 0;
		makePipe();
		System.out.println(cnt);
		

	}
	private static void makePipe() {
		// 윗행부터 시도
		for (int i = 0; i < R; i++) {
			visited[i][0] = true;
			dfs(i,0);
		}
		
	}
	
	// 세방향 탐색 메서드
	// 열은 무조건 +1 되기 때문에 열의 델타값 (dc)은 필요 없음
	static int [] dr = {-1,0,1};
	private static boolean dfs(int r, int c) {
		if(c == C-1) {
			cnt++;
			return true; // 파이프 놓기 성공
			
		}
		int nr,nc = c+1; // 열은 무조건 현재 열보다 1 증가함
		for (int i = 0,end = dr.length; i < end; i++) {
			nr = r + dr[i];
			// 열의 경계체크는 우리는 열로 기저조건을 사용할 것이므로 열의 경계체크는 필요없음
			if(nr<0 || nr>=R || map[nr][nc] == 'x' || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			if(dfs(nr,nc))return true;
//			visited[nr][nc] = false; // 실패했던 흔적 되돌리지 않기 : 뒤의 선택지의 방향은 현재보다 유리하지 않은 상황이고 결국 같은 상황이 되풀이된다.
		}
		return false; // 파이프를 놓을 수 없음
	}

}
