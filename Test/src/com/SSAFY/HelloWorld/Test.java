package com.SSAFY.HelloWorld;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		int sum = 0;
		boolean used[][] = new boolean[4][4];
		Scanner scan = new Scanner(System.in);
		char[][] grid = new char[4][4];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				grid[i][j] = scan.next().charAt(0);
			}
		}
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == 'X') {
					if(j-1 >=0 && grid[i][j-1] != 'X' && used[i][j-1] == false) {
						sum += grid[i][j-1] -'0';
						used[i][j-1] = true;
					}if(j+1<4 && grid[i][j+1] != 'X' && used[i][j+1] == false) {
						sum += grid[i][j+1]-'0';
						used[i][j+1] = true;
					}
					if(i-1 >=0 && grid[i-1][j] != 'X' && used[i-1][j] == false) {
						sum += grid[i-1][j]-'0';
						used[i-1][j] = true;
					}if(i+1<4 && grid[i+1][j] != 'X' && used[i+1][j]==false) {
						sum += grid[i+1][j]-'0';
						used[i+1][j] = true;
					}
				}
			}
		}
		
		System.out.println("sum: "+sum);
		
		
		}
}
