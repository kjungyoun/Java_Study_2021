package com.ssafy.array;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayInputTest {

	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/input.txt")); // Input을 명령프롬프트가 아닌 파일로 받아오는 것 (속도가 상승!)
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		char[][] map = new char[N][N];
		scan.nextLine(); // nextInt() 즉, next는 엔터를 읽어오지 않기 때문에 nextLine()과 같이 쓰기 위해 엔터를 추가해주어야 한다. 따라서 nextLine()을 통해서 엔터를 읽어야 한다.
		
		long start = System.nanoTime(); // 시스템 동작 시간 (시작 시간)을 받아옴
		for (int i = 0; i < N; i++) {
			String line = scan.nextLine(); // next와 nextLine을 한번에 사용할 경우 제대로 읽어오지 못함 
			for (int j = 0, c=0; j < N; j++, c += 2) {
			//map[i][j] = scan.next().charAt(0);
				map[i][j] = line.charAt(c); 
				// 한 줄을 통째롤 읽어오는 것으로 읽는 시간이 현저히 줄어드는 것을 알 수 있다. -> 데이터가 공백을 기준으로 길이가 서로 다르면 line.charAt()을 사용할 수 없음.
				// 이럴 때는 next.charAt()을 사용해야 한다.
			}
		}
		long end = System.nanoTime(); // 시스템 동작 시간 (종료 시간)을 받아옴
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.printf("%dnano\n",end-start);
	}

}
