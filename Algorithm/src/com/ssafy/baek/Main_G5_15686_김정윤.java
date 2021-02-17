package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * 백준 G5 15686 치킨배달
 */
public class Main_G5_15686_김정윤 {
	static ArrayList<int[]> house = new ArrayList<int[]>(); // 집의 좌표값을 저장하는 ArrayList
	static ArrayList<int[]> chicken = new ArrayList<int[]>(); // 치킨집의 좌표값을 저장하는 ArrayList
	static boolean[] isSelected; // 조합으로 뽑혔는지 확인하는 배열
	static int M, N, answer;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		answer = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) { // 집과 치킨집 좌표를 각 ArrayList에 저장
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int k = Integer.parseInt(st.nextToken());
				if (k == 1) // 집이면
					house.add(new int[] { i, j });
				else if (k == 2) // 치킨집이면
					chicken.add(new int[] { i, j });
			}
		}
		
		isSelected = new boolean[chicken.size()]; // 치킨집의 개수 만큼 배열 생성
		combination(0,0);
		System.out.println(answer);

	}

	public static void combination(int cnt, int start) {
		if (cnt == M) {
			int sum = 0; // 해당 조합의 도시의 치킨거리
			for (int i = 0, size = house.size(); i < size; i++) {
				int h[] = house.get(i);
				int dist = Integer.MAX_VALUE;
				for (int j = 0, end = isSelected.length; j < end; j++) {
					if(isSelected[j]) { // 조합으로 선택된 치킨집이면
						int c[] = chicken.get(j);
						int row = Math.abs(h[0]-c[0]); // row의 거리
						int col = Math.abs(h[1]-c[1]); // col의 거리
						dist = Math.min(row+col, dist); // 집과 모든 치킨집과의 거리중 최소 거리가 치킨 거리
					}
				}
				sum += dist;
			}
			answer = Math.min(answer, sum);
			return;
		}
		
		for (int i = start, size = chicken.size(); i < size; i++) {
			isSelected[i] = true; // 조합에 선택되었다고 표시
			combination(cnt + 1, i + 1);
			isSelected[i] = false; // 조합에 선택 해제
		}
	}

}
