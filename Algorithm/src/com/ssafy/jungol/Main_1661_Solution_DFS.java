package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1661_Solution_DFS {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(inputData));
		// data 입력 ( 맵, 방문처리 배열, 시작 종료 좌표 선언)
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		colN = Integer.parseInt(st.nextToken().trim());
		rowN = Integer.parseInt(st.nextToken().trim());

		// 좌표가 1,1 부터 시작하므로 입력 받은 좌표에서 -1 해서 0,0 좌표에서 시작
		st = new StringTokenizer(in.readLine(), " ");
		sc = Integer.parseInt(st.nextToken().trim()) - 1;
		sr = Integer.parseInt(st.nextToken().trim()) - 1;
		ec = Integer.parseInt(st.nextToken().trim()) - 1;
		er = Integer.parseInt(st.nextToken().trim()) - 1;

		map= new int[rowN][colN];
		visited= new boolean[rowN][colN];

		// 맵 크기, 시작 좌표, 종료 좌표, 맵 정보 입력 받기
		for (int r = 0; r < rowN; r++) {
			String line = in.readLine();
			for (int c = 0; c < colN; c++) {
				map[r][c] = line.charAt(c) - '0'; // 문자로 들어오므로 빼준다.
			}
		}
		result = Integer.MAX_VALUE;
		visited[sr][sc] = true;
		dfs(new int[] {sr,sc,0});
		System.out.println(result);
		
	}
	
	public static void dfs(int []info) {
		int nr,nc,r,c,dist;
		r = info[0];
		c = info[1];
		dist = info[2];
		for (int i = 0; i < 4; i++) { // 사방 탐색해서 자식 검색
			nr = r + dr[i];
			nc = c + dc[i];
			
			// 다음 위치가 경계 내, 길이고, 가지 않은 곳
			if(nr > -1 && nr< rowN && nc > -1 && nc<colN && map[nr][nc] == 0 && !visited[nr][nc]) {
				visited[nr][nc] = true;
				
				// 만약 다음 위치가 목적지라면 (기저조건)
				if(nr == er && nc == ec) { 
					result = Math.min(result, dist+1); // 각 다른 결과중 최소값을 저장
					visited[nr][nc] = false; // 목적지의 visited를 다른 경로의 경우를 위해 false로 바꾸어주고 return
					return;
				}
				
				// 다음 위치가 목적지가 아니라면
				dfs(new int[] {nr,nc,dist+1});
				// 갔다가 다시 돌아오면 다른 길로 가야 하므로 가지 않았다라고 재표시!! (핵심)
				visited[nr][nc] = false;
			}
		}
		// 해당 위치 계산
	}
	static int rowN, colN,er,ec,sr,sc,result;
	static int map[][];
	static boolean visited[][];
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, 1, 0, -1 };
	static String inputData = "8 7\r\n" + "1 2 7 5\r\n" + "11111111\r\n" + "00000111\r\n" + "10110011\r\n"
			+ "10111001\r\n" + "10111101\r\n" + "10000001\r\n" + "11111111";

}
