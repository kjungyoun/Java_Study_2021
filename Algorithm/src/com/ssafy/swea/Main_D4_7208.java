package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
public class Main_D4_7208 {
	static int newColor[];
	static int colNum,N;
	static ArrayList<int []> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		colNum = 4;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			list = new ArrayList<int []>();
			N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			int color[] = new int[N]; // 기존 색깔
			newColor = new int[N];
			int [][]map = new int[N][N];
			int min = Integer.MAX_VALUE;
			
			// 기존 색깔 정보 저장
			for (int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}
			
			// map 정보 저장
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine()," ");
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			permutation(0);
			
			for (int i = 0; i < list.size(); i++) {
				boolean isNext = false;
				int[] p = list.get(i);
				top:
				for (int j = 0; j < N; j++) {
					for (int r = 0; r < N; r++) {
						if(map[j][r] == 1) {
							if(p[j] == p[r]) {
								isNext = true;
								break top;
							}
						}
					}
				}
				if(!isNext) {
					int count =0;
					for (int j = 0; j < N; j++) {
						if(color[j] != p[j]) count++;
					}
					min = Math.min(min, count);
				}
			}
			System.out.println("#"+test_case+" "+min);
			
		}
	}
	
	public static void permutation(int cnt) {
		if(cnt==N) {
			// 배열은 Reference Type이므로 add할 시 newColor가 현재 가지고 있는 값을 가리키므로 모두 같은 값을 가진다.
			// 따라서 현재의 값을 보내고 싶은 경우에는 Arrays.copyOf를 이용해서 현재 배열을 복사해서 보내줘야 한다.
			list.add(Arrays.copyOf(newColor, N));
			return;
		}
		for(int i=1; i<=4;i++) {
			newColor[cnt] = i;
			permutation(cnt+1);
		}
	}
}
