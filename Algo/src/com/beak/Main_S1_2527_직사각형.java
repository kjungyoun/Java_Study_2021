package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S1_2527_직사각형 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int rs1 = Integer.parseInt(st.nextToken());
			int cs1 = Integer.parseInt(st.nextToken());
			int rs2 = Integer.parseInt(st.nextToken());
			int cs2 = Integer.parseInt(st.nextToken());
			int rd1 = Integer.parseInt(st.nextToken());
			int cd1 = Integer.parseInt(st.nextToken());
			int rd2 = Integer.parseInt(st.nextToken());
			int cd2 = Integer.parseInt(st.nextToken());
			
			if(rd1 > rs2 || cd1 > cs2 || rs1 > rd2 || cs1 > cd2) {
				System.out.print("d");
			}else if((rs1 == rd2 && cs1 == cd2) || (rs1 == rd2 && cs2 == cd1) || (rs2 == rd1 && cs2 == cd1) || (rs2 == rd1 && cs1 == cd2)) {
				System.out.print("c");
			}else if(cs1 == cd2 && ((rs1 < rd2 && rd2 < rs2)||(rs1 < rd1 && rd1 < rs2)) ||
					(rs1 == rd2 && ((cs2 > cd1 && cd1 > cs1)|| (cs1 < cd2 && cs2 > cd2))) ||
					(cs2 == cd1 && ((rs2 > rd1 && rd1> rs1) || (rs2 > rd2 && rd2 > rs1)) ) ||
					(rs2 == rd1 && ((cs1 < cd2 && cd2 < cs2) || (cs1 < cd1 && cs2 > cd1))) ||
					(cs2 == cd2 && rs2 >= rd2 && rs1 <= rd1) ||
					(rs2 == rd2 && cs1 <= cd1 && cd2 >= cd2) ||
					(cs1 == cd1 && rs2 >= rd2 && rs1 <= rd1) ||
					(rs1 == rd1 && cs1 <= cd1 && cd2 >= cd2)) {
				System.out.print("b");
			}else {
				System.out.print("a");
			}
			System.out.println();
		}

	}

}
