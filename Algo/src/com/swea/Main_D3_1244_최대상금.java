package com.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_D3_1244_최대상금 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int T = Integer.parseInt(in.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(in.readLine());
			String input = st.nextToken();
			int K = Integer.parseInt(st.nextToken());

			Integer num[] = new Integer[input.length()];
			for (int i = 0, size = input.length(); i < size; i++) {
				num[i] = Character.getNumericValue(input.charAt(i));
			}

			Integer maxN[] = Arrays.copyOf(num, num.length);

			Arrays.sort(maxN, new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});

			int max = toNum(maxN);
			int count = 0;
			int prevIdx = -1;
			int prevNum = -1;

			while (count != K) {
				int idx = -1;
	 			int mn = 0;
				int curr = toNum(num);
				if (curr == max) {
					int remain = K - count;
					if (remain % 2 == 0) {
						System.out.println("#" + test_case + " " + max);
						break;
					} else {
						int temp = num[0];
						num[0] = num[1];
						num[1] = temp;
						System.out.println("#" + test_case + " " + toNum(num));
						break;
					}
				}

				// 각 자리 수 중 최대값과 인덱스 저장
				for (int i = 0, size = num.length; i < size; i++) {
					if (num[i] > mn) {
						if (num[i] != prevNum) {
							mn = num[i];
							idx = i;
						} else {
							if (prevIdx != i) {
								mn = num[i];
								idx = i;
							} else
								continue;
						}
					}else if(num[i] == mn) {
						if (num[i] != prevNum) {
							mn = num[i];
							idx = i;
						} else {
							if (prevIdx != i) {
								mn = num[i];
								idx = i;
							} else
								continue;
						}
					}
				}

				// 교환 작업
				for (int i = 0, size = num.length; i < size; i++) {
					if (num[i] < mn) {
						prevIdx = i;
						prevNum = mn;
						int temp = num[i];
						num[i] = num[idx];
						num[idx] = temp;
						count++;
						break;
					} else
						continue;
				}
			}
			System.out.println("#" + test_case + " " + toNum(num));

		}
	}

	public static int toNum(Integer[] arr) {
		int size = arr.length;
		int num = 0;
		int temp = 1;
		for (int i = size - 1; i > -1; i--) {
			num += temp * arr[i];
			temp *= 10;
		}
		return num;
	}

}
