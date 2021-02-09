package com.ssafy.linkedlist;

public class SinglyLinkedList {
	private Node head;
	
	// 연결리스트에 첫번째 원소로 삽입하기
	public void addFirstNode(String data) {
		// 만약 공백 리스트였다면 head에 null이 들어옴
		// 만약 공백 리스트가 아니였다면 첫 list의 reference가 들어옴
		Node newNode = new Node(data,head);
		// 지금 만든 노드를 첫 노드로 바꾸어줌
		head = newNode;
	}
	
	// 연결리스트의 마지막 원소 찾기
	public Node getLastNode() {
		// head 부터 출발
		Node currNode = head;
		if(currNode != null) { // 현재 노드가 Null 이 아니면
			while(currNode.link != null) {
				//현재 노드의 link를 현재로 바꿈
				currNode = currNode.link;
			}
		}
		return currNode;
	}
	
	// 연결 리스트에 마지막 원소로 삽입하기
	public void addLastNode(String data) {
		if(head == null) {
			// head 가 null 이면 처음에 삽입하는 것과 같음
			addFirstNode(data);
		}else {
			Node lastNode = getLastNode();
			Node newNode = new Node(data); // Reference 타입은 자동으로 null 로 초기화 되므로 link를 초기화 할 필요 X
			lastNode.link = newNode;
		}
	}
	
	// 연결 리스트 중간에 원소 삽입
	public void insertAfterNode(Node preNode, String data) {
		// 여기서는 선행 노드가 없으면 추가를 하지 않을 것이다.
		if(preNode == null) {
			// 아래는 이후에 Custom Exception을 사용하여 예외로 던질 수 있음
			System.out.println("선행 노드가 없어 삽입이 불가능합니다.");
			return;
		}else {
			// 원래 pre노드가 가리키던 노드를 내가 가리키게 함
			Node newNode = new Node(data,preNode.link);
			// pre노드의 링크를 새로운 노드로 넣어줌
			preNode.link = newNode;
		}
	}
	
	// 리스트의 맨 앞부터 순차 탐색
	// 데이터를 주면 해당 데이터를 가지고 있는 노드 반환
	// 같은 데이터를 가진 노드를 만나면 가장 먼저 만나는 노드를 반환
	public Node getNode(String data) {
		for (Node currNode = head;  currNode != null; currNode = currNode.link) {
			if(currNode.data.equals(data)) { // 현재 탐색하는 노드의 data와 나의 data가 일치할 경우
				return currNode;
			}
		}
		// 노드를 찾지 못했을 경우
		return null;
	}
	
	// 이전 노드를 찾는 메서드
	public Node getPreviousNode(Node target) {
		Node currNode = head,nextNode=null;
		if(currNode != null) { // 현재 노드가 null이 아니면
			while((nextNode = currNode.link) != null) { // 현재 노드의 다음노드가 null이 아닐때 까지
				if(nextNode == target) // 다음노드가 target이면
				return currNode;
				currNode = nextNode; // 아니면 현재 노드에 다음 노드를 저장
			}
		}
		return null;
	}
	
	// 해당 데이터를 가지고 있는 노드를 삭제
	public void deleteNode(String data){
		if(head == null) {
			System.out.println("공백리스트여서 삭제가 불가능합니다.");
		}else {
			Node targetNode = getNode(data);
			if(targetNode == null) return;
			Node preNode = getPreviousNode(targetNode);
			if(preNode == null && targetNode == head) { // 내가 지우려는 노드가 첫번째 노드일 경우
				head = targetNode.link; // 해당 데이터 노드가 첫째 이면 나의 다음 노드를 head로 만듬
			}else {
				preNode.link = targetNode.link;
			}
			// 지우려는 노드의 Link는 null 처리하여 모든 연결을 끊음
			targetNode.link = null;
		}
	}
	
	// 모든 노드를 출력
	public void printList() {
		System.out.print("L = (  ");
		
		for(Node currNode =head; currNode!=null; currNode = currNode.link) {
			System.out.print(currNode.data+"  ");
		}
		
		System.out.println("  )");
	}
	
}
