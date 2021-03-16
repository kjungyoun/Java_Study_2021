package com.swea;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_8382_방향전환_bfs {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			int x1 = sc.nextInt() + 100;
			int y1 = sc.nextInt() + 100;
			int x2 = sc.nextInt() + 100;
			int y2 = sc.nextInt() + 100;

			System.out.println("#"+tc+" "+bfs(x1, y1, x2, y2));
		}
	}

	static int bfs(int x1, int y1, int x2, int y2) {
		int[] di = { 0, 1, 0, -1 }; // 0:right, 1:down, 2:left, 3:up
		int[] dj = { 1, 0, -1, 0 };

		boolean[][][] visit = new boolean[201][201][2];

		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(x1, y1, 0));
		queue.add(new Point(x1, y1, 1));
		queue.add(new Point(x1, y1, 2));
		queue.add(new Point(x1, y1, 3));
		visit[x1][y1][0] = true;
		visit[x1][y1][1] = true;

		int dist = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();

			for (int s = 0; s < size; s++) {
				Point now = queue.poll();

				if(now.i == x2 && now.j == y2) {
					return dist;
				}
				for (int d = 0; d < 4; d++) {
					if (now.dir % 2 != d % 2) {
						int ni = now.i + di[d];
						int nj = now.j + dj[d];
						if(ni>=0 && ni<=200 && nj>=0 && nj<=200 && !visit[ni][nj][d%2]) {
							visit[ni][nj][d%2] = true;
							queue.add(new Point(ni, nj, d));
						}
					}
				}
			}
			dist++;
		}
		return dist;
	}

	static class Point {
		int i, j, dir;

		Point(int i, int j, int dir) {
			this.i = i;
			this.j = j;
			this.dir = dir;
		}
	}
}