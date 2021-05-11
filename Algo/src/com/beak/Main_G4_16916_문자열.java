package com.beak;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main_G4_16916_문자열 {

	public static void main(String[] args)throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String word = in.readLine();
		String part = in.readLine();
		char start = part.charAt(0);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		
		for (int i = 0, size = word.length(); i < size; i++) {
			if(word.charAt(i) == start)
				queue.add(i);
		}
		
		boolean flag = false;
		int partSize = part.length();
		
		top: while(!queue.isEmpty()) {
			int idx = queue.poll();
			for (int i = idx; i < idx+partSize; i++) {
				if(i >= word.length()) {
					flag = false;
					break top;
				}
				if(word.charAt(i) != part.charAt(i-idx)) {
					continue top;
				}
			}
			flag = true;
			break;
		}
		
		System.out.println(flag? 1 : 0);

	}

}
