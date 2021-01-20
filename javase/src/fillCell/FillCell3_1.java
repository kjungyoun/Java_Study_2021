package fillCell;
import java.util.Scanner;
/**
 * 배열 개수와 좌표를 입력 받아 해당 좌표에 상하좌우에 1을 표시한후 전체 배열을 화면에 출력
 * 
 * 입력 : 
 *  배열의 개수   row좌표, column좌표
 *  ex) 3  1 1
 * 
 */
public class FillCell3_1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();

		////////////////
//		/// 처리 코드 작성
//		map[r-1][c] = 1;		//상
//		map[r+1][c] = 1;		//하
//		map[r][c-1] = 1;		//좌
//		map[r][c+1] = 1;		//우
		
		// 이 코드는 4방, 8방 탐색에서 가장 기본이 되는 코드이므로 외우는 것이 좋다.
		int dr[] = {-1, 1, 0, 0};
		int dc[] = {0, 0, -1, 1};
		int nr, nc;
		for(int i=0; i<4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			if(nr > -1 && nr < N && nc > -1 && nc < N) // 이거 하나면 4방이던 8방이던 상하좌우 경계검사가 다 됨.
			map[nr][nc] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
	}
}
