package comm.ssafy.tree;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBinaryTree {
	private char[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public CompleteBinaryTree(int size) {
		super();
		SIZE = size;
		// index를 1부터 사용하기 위해 size +1 크기의 배열 생성
		nodes = new char[size+1];
	}
	
	public boolean isEmpty() {
		// 마지막 인덱스가 0이면 비어있다고 봄
		return lastIndex == 0;
	}
	
	public boolean isFull() {
		// 배열의 사이즈를 하나 키웠으므로 마지막 인덱스는 SIZE가 된다
		// 따라서 마지막 인덱스가 SIZE이면 가득 참
		return lastIndex == SIZE;
	}
	
	public void add(char e) {
		if(isFull()) {
			System.out.println("포화상태");
			return;
		}
		// 마지막 인덱스 다음에 삽입
		nodes[++lastIndex] = e;
	}
	
	public void bfs() {
		if(isEmpty()) { // 비어있으면 탐색 X
			return;
		}
		// 큐에서는 노드의 탐색 순서를 관리
		// 탐색 순서 번호를 큐로 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		// 루트 노드를 먼저 삽입
		queue.offer(1);
		// 현재 인덱스를 저장할 변수
		int current;
		while(!queue.isEmpty()) {
			// 현재 꺼내고 있는 것의 너비가 0인지 1인지 2인지 확인할 수 없음
			// 따라서 너비를 알고 싶으면 너비정보도 큐에 함께 담아서 저장
			current = queue.poll();
			System.out.println(nodes[current]);
			// current*2 는 왼쪽 자식
			// 왼쪽 자식이 마지막 인덱스를 벗어나지 않을 경우
			// 자식이 있다면 큐에 집어 넣는다.
			if(current*2<=lastIndex) queue.offer(current*2);
			// current*2+1은 오른쪽자식
			if(current*2+1<=lastIndex) queue.offer(current*2+1);
		}
	}
	
	
	public void bfs2() {
		if(isEmpty()) { // 비어있으면 탐색 X
			return;
		}
		// 큐에서는 노드의 탐색 순서를 관리
		// 탐색 순서 번호를 큐로 관리
		Queue<Integer> queue = new LinkedList<Integer>();
		// 루트 노드를 먼저 삽입
		queue.offer(1);
		// 현재 인덱스를 저장할 변수
		int current;
		//  현재 사이즈와 level을 저장할 변수
		int size,level=0;
		while(!queue.isEmpty()) {
			// 현재 큐에 담겨있는 원소의 사이즈
			size = queue.size();
			System.out.print("level"+level+" : ");
			// 현재 큐에 담겨있는 원소 크기만큼씩 poll을 하기 위함
			while(--size>=0) {				
				// 현재 꺼내고 있는 것의 너비가 0인지 1인지 2인지 확인할 수 없음
				// 따라서 너비를 알고 싶으면 너비정보도 큐에 함께 담아서 저장
				current = queue.poll();
				System.out.print(nodes[current]);
				// current*2 는 왼쪽 자식
				// 왼쪽 자식이 마지막 인덱스를 벗어나지 않을 경우
				if(current*2<=lastIndex) queue.offer(current*2);
				// current*2+1은 오른쪽자식
				if(current*2+1<=lastIndex) queue.offer(current*2+1);
			}
			System.out.println();
			++level;
		}
	}
	
	// 전위 순회
	public void dfs(int current) {
		// 현재 index가 마지막 index를 넘어가면
		if(current>lastIndex) return;
		//VLR
		System.out.println(nodes[current]); // 방문 관련 처리
		dfs(current*2); // 왼쪽 자식도 똑같은 수행하도록 처리
		dfs(current*2+1); // 오른쪽 자식도 똑같은 수행하도록 처리
	}
	
	// 중위 순회
	public void dfs2(int current) {
		// 현재 index가 마지막 index를 넘어가면
		if(current>lastIndex) return;
		//LVR
		dfs(current*2); // 왼쪽 자식도 똑같은 수행하도록 처리
		System.out.println(nodes[current]); // 방문 관련 처리
		dfs(current*2+1); // 오른쪽 자식도 똑같은 수행하도록 처리
	}
	
// 후위 순회
	public void dfs3(int current) {
		// 현재 index가 마지막 index를 넘어가면
		if(current>lastIndex) return;
		//LRV
		dfs(current*2); // 왼쪽 자식도 똑같은 수행하도록 처리
		dfs(current*2+1); // 오른쪽 자식도 똑같은 수행하도록 처리
		System.out.println(nodes[current]); // 방문 관련 처리
	}
}
