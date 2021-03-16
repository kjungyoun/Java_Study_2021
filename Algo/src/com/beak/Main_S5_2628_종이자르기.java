package com.beak;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_S5_2628_종이자르기 {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int N = Integer.parseInt(in.readLine());
		
		ArrayList<Integer> arr[] = new ArrayList[2];
		arr[0] = new ArrayList<Integer>();
		arr[1] = new ArrayList<Integer>();
		arr[0].add(0);
		arr[0].add(H);
		arr[1].add(0);
		arr[1].add(W);
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			arr[Integer.parseInt(st.nextToken())].add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(arr[0],Collections.reverseOrder());
		
		Collections.sort(arr[1]);
		int maxh = 0;
		int maxw = 0;
		for (int size = arr[0].size(), i=size-1; i >0; i--) {
			maxh = Math.max(maxh, arr[0].get(i)-arr[0].get(i-1));
		}
		
		for (int size = arr[1].size(), i=size-1; i >0; i--) {
			maxw = Math.max(maxw, arr[1].get(i)-arr[1].get(i-1));
		}
		
		System.out.println(maxw*maxh);
	}

}
