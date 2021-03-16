package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D4_8382_방향전환 {
	static int dr[] = { -1, 0, 1, 0 };
	static int dc[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			int rs = Integer.parseInt(st.nextToken()) + 100;
			int cs = Integer.parseInt(st.nextToken()) + 100;
			int rd = Integer.parseInt(st.nextToken()) + 100;
			int cd = Integer.parseInt(st.nextToken()) + 100;

			boolean visited[][][] = new boolean[201][201][2];
			Queue<int[]> queue = new LinkedList<int[]>();

			queue.offer(new int[] { rs, cs, 0, 0 });
			queue.offer(new int[] { rs, cs, 1, 0 });
			queue.offer(new int[] { rs, cs, 2, 0 });
			queue.offer(new int[] { rs, cs, 3, 0 });
			
			while (!queue.isEmpty()) {
				int[] temp = queue.poll();
				int r = temp[0];
				int c = temp[1];
				int idx = temp[2];
				int count = temp[3];
				if (r == rd && c == cd) {
					System.out.println("#" + test_case + " " + count);
					break;
				}
				int nr = r + dr[idx];
				int nc = c + dc[idx];
				if (nr > -1 && nr < 201 && nc > -1 && nc < 201 && !visited[nr][nc][idx%2]) {
					if (idx % 2 == 0) {
						visited[nr][nc][idx%2] = true;
						queue.offer(new int[] { nr, nc, 1, count + 1 });
						queue.offer(new int[] { nr, nc, 3, count + 1 });
					} else if (idx % 2 != 0) {
						visited[nr][nc][idx%2] = true;
						queue.offer(new int[] { nr, nc, 0, count + 1 });
						queue.offer(new int[] { nr, nc, 2, count + 1 });
					}
				}
			}
		}
	}

}
