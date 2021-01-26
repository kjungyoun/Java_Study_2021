package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Workshop {
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static int AnswerN = 0;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/SolutionInput.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			AnswerN = 0;
			int nr, nc;
			int N = scan.nextInt();
			char[][] map = new char[N][N];
			scan.nextLine();
			for (int i = 0; i < N; i++) {
				String line = scan.nextLine();
				for (int j = 0, c = 0; j < N; j++, c += 2) {
					map[i][j] = line.charAt(c);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean isG = false;
					int height = 0;
					if (map[i][j] == 'B') {
						for (int k = 0; k < 8; k++) {
							nr = i + dr[k];
							nc = j + dc[k];
							if (nr > -1 && nr < N && nc > -1 && nc < N) {
								if (map[nr][nc] == 'G') {
									isG = true;
									height = 2;
									break;
								}
							}
						}
						if (!isG) {
							for (int r = 0; r < N; r++) {
								if (map[i][r] == 'B')
									height++;
								if (map[r][j] == 'B')
									height++;
							}
							height--;
						}
						AnswerN = Math.max(AnswerN, height);
					}
				}
			}
			System.out.println("#" + test_case + " " + AnswerN);
		}

	}

}
