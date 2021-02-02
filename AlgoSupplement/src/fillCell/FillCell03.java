package fillCell;
import java.util.Arrays;
import java.util.Scanner;
/**
 * 배열 개수와 좌표를 입력 받아 해당 좌표에 상하좌우에 1을 표시한후 전체 배열을 화면에 출력
 * 경계 검사
 * 
 * 입력 : 
 *  배열의 개수   row좌표, column좌표
 *  ex) 3 0 0 
 * 
 */
public class FillCell03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] map = new int[N][N];
		int r = sc.nextInt();
		int c = sc.nextInt();
		////////////////
		/// 처리 코드 작성
		int [] dr = {-1,1,0,0};
		int[] dc = {0,0,-1,1};
		
		int nr,nc; // 이동할 좌표를 저장할 변수
		for (int i = 0; i < 4; i++) {
			nr = r + dr[i];
			nc = c + dc[i];
			
			if(nr < 0 || nr >= N || nc<0 || nc>N) { // 경계바깥일 때 
				// 크거나 같다 같이 두 개를 비교하는 것보다 크다 이런식의 비교문이 조금 더 빠르다.
				continue;
			}
			map[nc][nc] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
