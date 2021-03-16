package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_S5_10158_개미 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		
		st = new StringTokenizer(in.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int t = Integer.parseInt(in.readLine());
		
		int idxr = 1;
		int idxc = 1;
		int rtemp = r;
		int ctemp = c;
		int time = 1;
		boolean isCircle = false;
		
		for (int i = 1; i <= t; i++) {
			int nr = rtemp + idxr;
			int nc = ctemp + idxc;
			
			if(nr < 0 || nr > w) {
				idxr = -idxr;
				nr = rtemp + idxr;
			}
			if(nc<0 | nc > h) {
				idxc = -idxc;
				nc = ctemp + idxc;
			}
			
			if(nr == r && nc == c && idxr == 1 && idxc == 1) {
				time = i;
				rtemp = nr;
				ctemp = nc;
				isCircle = true;
				break;
			}else {
				rtemp = nr;
				ctemp = nc;
			}
		}
		
		if(isCircle) {
			idxr = 1;
			int num = t%time;
			for (int i = 1; i <= num; i++) {
				int nr = rtemp + idxr;
				int nc = ctemp + idxc;
				if((nr < 0 || nr > w) && (nc<0 | nc > h)) {
					idxr = -idxr;
					idxc = -idxc;
					nr = rtemp + idxr;
					nc = ctemp + idxc;
				}else if(nr < 0 || nr > w) {
					idxr = -idxr;
					nr = rtemp + idxr;
				}else if(nc<0 | nc > h) {
					idxc = -idxc;
					nc = ctemp + idxc;
				}
					rtemp = nr;
					ctemp = nc;
				
			}
		}
		
		System.out.println(rtemp +" "+ctemp);
		
	}

}
