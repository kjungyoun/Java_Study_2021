package com.ssafy.algo;

import java.util.Scanner;

public class DigitTest1 {
	public static void decimalCount(int num, int count[]) {
		if(num/10 == 0) count[0]++;
		else if(num/10 == 1) count[1]++;
		else if(num/10 == 2) count[2]++;
		else if(num/10 == 3) count[3]++;
		else if(num/10 == 4) count[4]++;
		else if(num/10 == 5) count[5]++;
		else if(num/10 == 6) count[6]++;
		else if(num/10 == 7) count[7]++;
		else if(num/10 == 8) count[8]++;
		else if(num/10 == 9) count[9]++;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] count = new int[10];
		while(true) {
			int num = scan.nextInt();
			if(num==0) break;
			decimalCount(num,count);
		}
		for (int i = 0; i < count.length; i++) {
			if(count[i] != 0) System.out.println(i+" : "+count[i]+"개");
		}
	}

}
