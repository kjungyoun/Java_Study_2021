package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_S5_1158_김정윤 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		Queue<Integer> queue = new LinkedList<Integer>();
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) {
			queue.offer(i);
		}
		System.out.print("<");
		while(queue.size()>1) {
			for (int i = 1; i < K; i++) {
				// k-1 까지 맨 앞에 있는 것을 빼서 맨뒤로 다시 넣어줌
				queue.offer(queue.poll());
			}
			System.out.print(queue.poll()+", ");
		}
		System.out.print(queue.poll()+">");

	}

}
