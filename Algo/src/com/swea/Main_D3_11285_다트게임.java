package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_D3_11285_다트게임 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int score = 0;
			int N = Integer.parseInt(in.readLine());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				double dist = Math.sqrt((Math.pow(r, 2)+Math.pow(c, 2)));
				if(dist <=20) score += 10;
				else if(dist <=40) score += 9;
				else if(dist <=60) score += 8;
				else if(dist <=80) score += 7;
				else if(dist <=100) score += 6;
				else if(dist <=120) score += 5;
				else if(dist <=140) score += 4;
				else if(dist <=160) score += 3;
				else if(dist <=180) score += 2;
				else if(dist <=200) score += 1;
			}
			System.out.println("#"+test_case+" "+score);
		}

	}

}
