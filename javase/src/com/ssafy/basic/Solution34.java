package com.ssafy.basic;

public class Solution34 {

	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {

			if (i % 2 == 0) {
				System.out.println(i);
			}

			if (i == 3)
				break;
		}

		for (int i = 0; i < 5; i++) {

			switch (i % 2) {
			case 0:
				System.out.println(i);
			}

			switch (i) {
			case 3:
				break;
			}
		}

	}

}
