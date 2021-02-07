package com.ssafy.swea;

import java.util.Scanner;

public class Main_D2_1954 {
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	static int index;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		int nr,nc;
		int r=0,c=0;
		index =0;
		int num = 1;
		while(true) {
			arr[r][c] = num;
			nr = r + dr[index];
			nc = c + dc[index];
			if(nr>-1 && nr<N && nc > -1 && nc<N && arr[nr][nc]==0) {
				r = nr;
				c = nc;
				num++;
			}else {
				if(num == N*N) break;
				turn(); 
				continue;
			}
		}
	
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(arr[i][j]+"\t");
			}
			System.out.println();
		}

	}
	
	public static void turn() {
		if(index == 3) {
			index =0;
			return;
		}
		index += 1;
	}
}
