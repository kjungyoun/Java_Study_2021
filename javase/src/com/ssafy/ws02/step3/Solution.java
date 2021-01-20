package com.ssafy.ws02.step3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int AnswerN = 0;
	// 8방 탐색 배열
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static char map[][];
	static int tower[][];

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/SolutionInput.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			AnswerN = 0;
			int N = scan.nextInt();
			map = new char[N][N];
			tower = new int[N][N];
			scan.nextLine();
			// 1. 데이터 입력 받기
			for (int i = 0; i < N; i++) {
				String line = scan.nextLine();
				for (int j = 0, c = 0; j < N; j++, c += 2) {
					map[i][j] = line.charAt(c);
				}
			}
//			for (int i = 0; i < N; i++) {
//					System.out.println(Arrays.toString(map[i]));
//			}

			// 2. 전체를 순회하면서 근처에 G가 있는지 확인하기
			int max = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean isG = false;
					if (map[i][j] == 'B') {
						int count=0;
						for (int k = 0; k < 8; k++) {
							int nr = i + dr[k];
							int nc = j + dc[k];
							if (nr > -1 && nr < N && nc > -1 && nc < N) {
								if (map[nr][nc] == 'G') {
									tower[i][j] = 2;
									isG = true;
									break;
								}
							}
						}
						if (!isG) {
							count = 0;
							for (int r = 0; r < N; r++) {
								if (map[i][r] == 'B')
									count += 1;
								if (map[r][j] == 'B')
									count += 1;
							}
							tower[i][j] = count - 1;
						}
					}

				}

			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					max = Math.max(tower[i][j], max);
				}
			}

			AnswerN = max;
			System.out.println("#" + test_case + " " + AnswerN);
		}

	}

}
