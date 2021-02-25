package com.ssafy.boj;

import java.util.Arrays;
import java.util.Scanner;

/*
 * 백준 B2 2309 일곱난쟁이
 */
public class Main_B2_2309 {
	static int[] input, numbers;
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		input = new int[9];
		numbers = new int[7];

		for (int i = 0; i < 9; i++) {
			input[i] = sc.nextInt();
		}

		dfs(0, 0, 0);
	}

	public static void dfs(int cnt, int start, int sum) {
		if (cnt == 7) {
			if (sum == 100 && count == 0) {
				count ++;
				Arrays.sort(numbers);
				for (int x : numbers) {
					System.out.println(x);
				}
			}
			return;
		}

		if (sum > 100)
			return;

		for (int i = start; i < 9; i++) {
			numbers[cnt] = input[i];
			dfs(cnt + 1, i + 1, sum + input[i]);
		}
	}

}
