package com.ssafy.ws02.step3;

/**
 * 교수님 코드
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_1 {
	static int AnswerN = 0;
	// 8방 탐색 배열
	static int[] dr = {-1,-1,-1,0,0,1,1,1};
	static int[] dc = {-1,0,1,-1,1,-1,0,1};
	static char map[][] ;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/SolutionInput.txt"));
		Scanner scan = new Scanner(System.in);
		int T = scan.nextInt();
		for(int test_case=1; test_case<=T; test_case++) {
			AnswerN = 0;
			int N = scan.nextInt();
			map = new char[N][N];
			scan.nextLine();
			// 1. 데이터 입력 받기
			for (int i = 0; i < N; i++) {
				String line = scan.nextLine();
				for (int j = 0,c=0; j < N; j++, c+=2) {
					map[i][j] = line.charAt(c);
				}
			}
			
			// 2. 전체를 순회하면서 B를 찾아 근처에 G가 있으면 높이를 2로 없으면 가로세로 빌딩 수 세기
			int nr, nc, high=0; //high가 0인 이유는 모두 G인 map이 있을 수 있기 때문
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int num=0;
					boolean isG = false;
					if(map[r][c] == 'B') {
						for (int i = 0; i < 8; i++) {
							nr = r+dr[i];
							nc = c+dc[i];
							if(nr > -1 && nr < N && nc > -1 && nc < N) { // 경계 조건 탐색
								if(map[nr][nc]=='G') { // 8방에 G가 하나라도 있으면,
									isG = true;
									num = 2;
									break;
								}
							}
						}
						if(!isG) {
							num=0;
							for (int i = 0; i <N ; i++) {
								if(map[r][i]=='B') num++;
								if(map[i][c]=='B') num++;
							}
							num--;
						}
						if(num>high) high=num;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+high);
		}

	}

}
