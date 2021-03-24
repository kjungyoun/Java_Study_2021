package com.ssafy.baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_S3_1463_김정윤_1로만들기_BFS {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		int count = 0;
		boolean visited[] = new boolean[1000001];
		Queue<int []> queue = new LinkedList<int []>();
		queue.add(new int[] {N,count});
		
		while(!queue.isEmpty()) {
			int temp[] = queue.poll();
			int x = temp[0];
			count = temp[1];
			
			if(x == 1) break;
			
			if(x%3 == 0 && !visited[x/3]) {
				queue.add(new int[] {x/3,count+1});
			}
			if(x%2 == 0 && !visited[x/2]) {
				queue.add(new int[] {x/2,count+1});
			}
			if(!visited[x-1])
				queue.add(new int[] {x-1,count+1});
			
		}
		System.out.println(count);
	}

}
