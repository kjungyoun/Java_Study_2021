package Programmers;

import java.util.Scanner;

public class HashardNum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		boolean answer = true;
        int N = 0;
            N += (x/10000);
            N += (x%10000/1000);
            N += (x%1000/100);
            N += (x%100/10);
            N += (x%10);
            if(x%N != 0) answer = false;
	        System.out.println(answer);
	}

}
