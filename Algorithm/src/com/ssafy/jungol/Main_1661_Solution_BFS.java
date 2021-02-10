package com.ssafy.jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1661_Solution_BFS {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		in = new BufferedReader(new StringReader(inputData));
		// data 입력 ( 맵, 방문처리 배열, 시작 종료 좌표 선언)
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		int colN = Integer.parseInt(st.nextToken().trim());
		int rowN = Integer.parseInt(st.nextToken().trim());

		// 좌표가 1,1 부터 시작하므로 입력 받은 좌표에서 -1 해서 0,0 좌표에서 시작
		st = new StringTokenizer(in.readLine(), " ");
		int sc = Integer.parseInt(st.nextToken().trim()) - 1;
		int sr = Integer.parseInt(st.nextToken().trim()) - 1;
		int ec = Integer.parseInt(st.nextToken().trim()) - 1;
		int er = Integer.parseInt(st.nextToken().trim()) - 1;

		int map[][] = new int[rowN][colN];
		boolean visited[][] = new boolean[rowN][colN];

		// 맵 크기, 시작 좌표, 종료 좌표, 맵 정보 입력 받기
		for (int r = 0; r < rowN; r++) {
			String line = in.readLine();
			for (int c = 0; c < colN; c++) {
				map[r][c] = line.charAt(c) - '0'; // 문자로 들어오므로 빼준다.
			}
		}

		int dr[] = { -1, 1, 0, 0 };
		int dc[] = { 0, 0, -1, 1 };

		// BFS
		Queue<int[]> queue = new LinkedList<int[]>();

		// 시작 좌표와 거리를 queue 넣고 시작
		queue.offer(new int[] { sr, sc, 0});
		visited[sr][sc] = true;
		int[] node;
		int r, c, nc, nr, dist=0, result=0;
		
		top:
		while (!queue.isEmpty()) {
			node = queue.poll();
			r = node[0];
			c = node[1];
			dist = node[2];

			// 상하 좌우로 이동
			for (int i = 0; i < 4; i++) { // 자식의 위치
				nr = r + dr[i];
				nc = c + dc[i];
				
				// 경계 내                                             && 길(0)인지?           && 가지 않았던 길인지?
				if(nr>-1 && nr<rowN && nc>-1 && nc<colN && map[nr][nc] == 0 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					// 다음 위치가 종료좌표이면 BFS 종료
					if(nr == er && nc == ec) {
						// 다음이 목적지이면 한칸을 이동한 것이기 때문에 또 dist +1 해준다.
						result = dist+1;
						break top;
					}
					// 갈 수 있는 길이면 큐에 넣기
					// 다음 좌표로 간 것이기 때문에 거리도 1 증가 시킴
					queue.offer(new int[] {nr,nc,dist+1});
				}
			}
		}
		System.out.println(result);
	}

	static String inputData = "8 7\r\n" + "1 2 7 5\r\n" + "11111111\r\n" + "00000111\r\n" + "10110011\r\n"
			+ "10111001\r\n" + "10111101\r\n" + "10000001\r\n" + "11111111";

}
