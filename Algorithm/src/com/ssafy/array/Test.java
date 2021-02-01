package com.ssafy.array;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) throws Exception {
		// 파일로 입력 읽기
		System.setIn(new FileInputStream("res/swea/d3/1289_원재의메모리복구하기.txt"));
		// test.txt는 공백이 있는 데이터임
		System.setIn(new FileInputStream("res/swea/d3/test.txt"));
		// 콘솔창으로 입력 읽기 -> 알고리즘 제출 시 위에 파일로 읽는 코드는 주석처리하면 된다.
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		StringTokenizer st = null;
		for (int test_case = 0; test_case < T; test_case++) {
			// 두번째 인자인 구분자로 각 데이터를 구분지어 입력받음
			st = new StringTokenizer(in.readLine()," ");
			for (int i = 0, end = st.countTokens(); i < end; i++) {
				// token 개수를 알 수 없을 때 countTokens() 메서드를 이용하면 됨
				System.out.println(st.nextToken());
			}
			System.out.println();
			// String data = in.readLine();
			//System.out.println(data);
		}

	}

}
