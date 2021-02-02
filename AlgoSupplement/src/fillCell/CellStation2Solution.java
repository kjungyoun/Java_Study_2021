package fillCell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * SS 탤래콤에서 현재 기지국의 위치와 집들이 표시된 지도를 2차원 n * n 배열로 변환하여 기지국에 커버되지 않는 집의 수를 찾고자
 * 한다. s 기지국은 세가지 종류가 있다. 각각의 기지국은 기지국이 위치한 셀에서 동서남북으로 각 기지국은 A는 1개, B는 2개, C는
 * 3개의 셀을 커버하며 하나의 집은 1개의 셀에 있다.
 * 
 * 첫줄은 테스트 케이스 두번째 줄은 배열의 개수 n 세번째 줄부터 n x n 배열내의 기지국(A, B, C)와 집(H), 아무것도 없는 곳에
 * X가 표시된다.
 *
 * 
 */
public class CellStation2Solution {
	static int AnswerN = 0;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/cellstation2.txt"));
		try {
			Scanner sc = new Scanner(System.in);
			int testCase;
			testCase = sc.nextInt();
			for (int t = 1; t <= testCase; t++) {
				AnswerN = 0;
				int n = sc.nextInt();
				char[][] map = new char[n][n];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						map[i][j] = sc.next().charAt(0);
					}
				}
				/////////////////////////// 구현하세요//////////////////////////////
				int nr, nc, count;
				// 1. 맵 전체를 탐사하면서
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						// 2. 현재 cell이 기지국(A, B, C) 인지 확인
						if (map[r][c] == 'A' || map[r][c] == 'B' || map[r][c] == 'C') {
							count = map[r][c] - 'A' + 1; // 아스키코드 값의 차이를 이용한 이동할 칸수 구하기
							// 3. 상하 좌우
							// 3.1 지정된 칸 수 내에 H가 있다면 다른 cell(X)로 채우기
							for (int i = 0; i < 4; i++) {
								for (int j = 1; j <= count; j++) {
									nr = r + dr[i] * j;
									nc = c + dc[i] * j;
									if (nr > -1 && nr < n && nc > -1 && nc < n && map[nr][nc] == 'H') {
										map[nr][nc] = 'X';
									}
								}
							}
						}
					}

				}
				// 4. 맵 전체를 탐사하면서 남은 H개수를 세기
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (map[r][c] == 'H')
							AnswerN++;
					}
				}

				/////////////////////////// 결과 출력/////////////////////////////
				System.out.println("#" + t + " " + AnswerN);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
