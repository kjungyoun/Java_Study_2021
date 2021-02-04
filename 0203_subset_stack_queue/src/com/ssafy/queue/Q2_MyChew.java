package com.ssafy.queue;

import java.util.LinkedList;
import java.util.Queue;

public class Q2_MyChew {

	public static void main(String[] args) {
		int N = 20;
		int person = 1; // 사람의 번호
		
		Queue<int[]> queue = new LinkedList<int[]>();
		// 배열의 첫번째 인자 : 사람의 번호
		// 배열의 두번째 인자 : 가져가는 갯수
		queue.offer(new int[] {person,1});
		
		int[] p;
		int availableCnt = 0;
		while(N>0) {
			p = queue.poll();
			// 남아있는 개수가 그 사람이 원하는 개수보다 같거나 크면 원하는 만큼 줄 수 있음
			// 아니면 가지고 있는 개수만 줄 수 있음
			availableCnt = (N>=p[1]) ? p[1] : N;
			
			N -= availableCnt;
			
			if(N==0) {
				System.out.println("마지막 마이쮸를 가져간 사람 : " +p[0]+"번,"+availableCnt+"개");
			}else {
				System.out.println(p[0]+"번 사람이 마이쮸를 가져갑니다. 남은 개수 : "+N);
				p[1]++;
				queue.offer(p);
				// person+1로 넣으면 person의 값이 변하지 않기때문에 들어올때마다 늘려야함
				// 따라서 전치연산
				// 새로운 사람이 들어옴
				queue.offer(new int[] {++person,1});
			}
		}
	}

}
