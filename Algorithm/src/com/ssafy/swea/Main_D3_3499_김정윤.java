package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_D3_3499_김정윤 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = Integer.parseInt(in.readLine());
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(in.readLine()," ");
			Queue<String> queue1 = new LinkedList<String>();
			Queue<String> queue2 = new LinkedList<String>();
//			String []input1 = new String[N-(N/2)];
//			String []input2 = new String[N/2]; 
//			for (int i = 0; i < N-(N/2); i++) {
//				input1[i] = st.nextToken();
//			}
//			for (int i = 0; i < N/2; i++) {
//				input2[i] = st.nextToken();
//			}
//			
//			if(N%2 != 0) {
//				sb.append(input1[0]).append(" ");
//				for (int i = 0; i < N/2; i++) {
//					sb.append(input2[i]).append(" ");
//					sb.append(input1[i+1]).append(" ");
//				}
//			}else {
//				for (int i = 0; i < N/2; i++) {
//					sb.append(input1[i]).append(" ");
//					sb.append(input2[i]).append(" ");
//				}
//			}
			for (int i = 0; i < N-(N/2); i++) {
				queue1.offer(st.nextToken());
			}
			for (int i = 0; i < N/2; i++) {
				queue2.offer(st.nextToken());
			}
			for (int i = 0; i < N/2; i++) {
				sb.append(queue1.poll()).append(" ");
				sb.append(queue2.poll()).append(" ");
			}
			if(N%2 !=0)
				sb.append(queue1.poll()).append(" ");
			
			System.out.println("#"+test_case +" "+sb.toString());
		}
	}

}
