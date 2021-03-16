package com.beak;

import java.util.Scanner;

public class Main_S5_10157_자리배정_김정윤_260 {
	// 델타 배열 선언
	static int dr[] = {0,1,0,-1};
	static int dc[] = {1,0,-1,0};
	
	public static void main(String[] args) {
		// 입력 저장
		Scanner sc = new Scanner(System.in);
		int C = sc.nextInt();
		int R = sc.nextInt();
		sc.nextLine();
		int num = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		
		// 좌석 배치할 수 없는 상황
		if(C*R < num) {
			sb.append(0);
			System.out.println(sb);
			return;
		}
		
		// 좌석 배치할 수 있는 상황
		boolean map[][] = new boolean[C][R]; // 좌석 정보 저장
		
		// 델타 배열 인덱스 선언
		int idx=0;
		
		// 시작 좌표 저장
		int r=0,c=0,cnt = 0;
		
		// map 순회
		while(true) {
			if(!map[r][c]) {
				cnt++;
				map[r][c] = true;
			}
			
			if(cnt == num) {
				sb.append(r+1).append(" ").append(c+1);
				System.out.println(sb);
				return;
			}
			
			int nr,nc;
			nr = r + dr[idx];
			nc = c + dc[idx];
			
			if(nr>-1 && nr<C && nc>-1 && nc<R && !map[nr][nc]){
				r = nr;
				c = nc;
			}else {
				idx = (idx+1)%4;
			}
			
		}

	}

}
