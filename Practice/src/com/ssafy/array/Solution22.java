package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Solution22 {
	static int[] dr = { 0,-1, 1, 0, 0 };
	static int[] dc = { 0,0, 0, -1, 1 };
	static int AnswerN = 0;

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/solution22Input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int test_case = 1; test_case <= T; test_case++) {
			AnswerN=0;
			int N = sc.nextInt();
			int map[][] = new int[N][N];
			int num = sc.nextInt();
			for(int i=0; i<num;i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				int dir = sc.nextInt();
				map[r][c] = 1;
				for(int j=3; j>0; j--) {
					r = r+dr[dir]*j;
					c = c+dc[dir]*j;
					if(r>-1 && r<N && c>-1 && c<N) {
						if(map[r][c] != 1) {
							map[r][c] = 1;
							map[r-dr[dir]*j][c-dc[dir]*j] = 0;
							}else {
								map[r-dr[dir]*j][c-dc[dir]*j] = 0;
								break;
							}
						}else {
							map[r-dr[dir]*j][c-dc[dir]*j] = 0;
							break;
						}		
					}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 1) AnswerN++;
				}
			}
			
			System.out.println("#" + test_case+" "+AnswerN);
		}

	}

}
