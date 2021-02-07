package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {
	static int[] status;
	static int s;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		s = Integer.parseInt(in.readLine());
		status = new int[s+1];
		StringTokenizer st = new StringTokenizer(in.readLine());
		for (int i = 1; i < s+1; i++) {
			status[i] = Integer.parseInt(st.nextToken());
		}
		int num = Integer.parseInt(in.readLine());
		for (int i = 0; i < num; i++) {
			st = new StringTokenizer(in.readLine());
			int student = Integer.parseInt(st.nextToken());
			int index = Integer.parseInt(st.nextToken());
			switchOnOff(student,index);
		}
		for (int i = 1; i < s+1; i++) {
			System.out.print(status[i]+" ");
			if(i%20==0) System.out.println();
		}
		

	}
	
	public static void switchOnOff(int sex, int index) {
		if (sex == 1) {
			while(true) {
				switchOnOff(index);
				index += index;
				if(index >= s+1) break;
			}
		}
		else if(sex == 2) {
			switchOnOff(index);
			for (int i = 1; i < s+1; i++) {
				if(index+i <s+1 && index-i>0 && status[index+i] == status[index-i]) {
					switchOnOff(index-i);
					switchOnOff(index+i);
				}
			}
		}
	}
	
	public static void switchOnOff(int index) {
		if(status[index]==0) status[index] = 1;
		else if(status[index]==1) status[index] = 0;
	}

}
