package fillCell;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * NxN 배열을 위한 기지국(A)와 집(H)가에 대한 정보가 주어진다. 
 * 기지국은 상하좌우 1셀씩만 커버한다. 커버하지 못하는 집의 개수를 출력
 *
 * [제약조건]
 * N은 3~15이하
 * 
 * [입력]
 * 첫줄은 테스트 케이스 수(T)가 주어진다.
 * 두번째 줄은 배열 크기(N)이 주어지고
 * 세번째 줄부터 N개의 기지국 정보가 제공된다. 
 * 
 * [출력 결과]
 * #1 4
 * #2 5
 * #3 9
 */
public class BaseStation1 {
    static int AnswerN=0;
	public static void main(String[] args) throws FileNotFoundException {
		System.setIn(new FileInputStream("res/basestation1.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case=1; test_case<=T; test_case++){
			AnswerN=0;
			int	N=sc.nextInt();
				
			/**
			* :TODO 
			* 1. 데이터 입력받기
			* 2. 배열 전체를 탐색하면서 기지국(A) 찾기
			* 3. 상하좌우가 경계 내 && H 이면
			* 	3.1 커버한 H를 다른 데이터로 표시 (or 커버했다고 표시)
			* 4. 배열 전체를 탐색하면서 커버되지 못한 H 개수를 찾기  
			*/
			
//			sc.nextLine();
			// 입력 데이터를 저장할 배열 생성
			char map[][] = new char[N][N];
			// A기지국 4방에 있는 H 탐색 배열
			int search[][] = new int[N][N];
//			String line = sc.nextLine();
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
//					map[i][j] = line.charAt(c);
					map[i][j] = sc.next().charAt(0);
				}
			}
			
			//4방 탐색 좌표 배열
			int dr[] = {-1,1,0,0};
			int dc[] = {0,0,-1,1};
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(map[i][j] == 'A') {
						int nr, nc;
						for (int k = 0; k < 4; k++) {
							// 행은 행끼리 열은 열끼리만 더하면 됨
							nr = i + dr[k];
							nc = j + dc[k];
							if(nr > -1 && nr < N && nc > -1 && nc < N) { // 배열 범위 제한 조건
								if(map[nr][nc]== 'H')
								search[nr][nc] = 1;
							}
							}
						}
					}
				}
			
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				// A 기지국 근처에 없는 H 카운트
				if(search[i][j] == 0 && map[i][j] == 'H') AnswerN ++;
			}
		}
			System.out.println("#"+test_case+" "+AnswerN);
		}
	}//end main
}//end class
