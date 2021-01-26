package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BaseStation {
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int AnswerN = 0;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/BaseStation1.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for (int test_case = 0;  test_case< T; test_case++) {
			int nr, nc;
			AnswerN=0;
			int N = scan.nextInt();
			int map[][] = new int[N][N];
			boolean isCount[][] = new boolean[N][N];
			scan.nextLine();
			for (int i = 0; i < N; i++) {
				String line = scan.nextLine();
				for (int j = 0, c=0; j < N; j++, c+=2) {
					map[i][j] = line.charAt(c);
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'A') {
						for (int k = 0; k < 4; k++) {
							nr = i + dr[k];
							nc = j + dc[k];
							if(nr>-1 && nr<N && nc>-1 && nc<N) {
								if(map[nr][nc] == 'H') isCount[nr][nc] = true;
							}
						}
					}
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'H' && !isCount[i][j])
						AnswerN++;
				}
			}
			System.out.println("#"+test_case + " " + AnswerN);
		}

	}

}
