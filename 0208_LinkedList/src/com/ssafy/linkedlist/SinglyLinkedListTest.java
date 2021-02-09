package com.ssafy.linkedlist;

public class SinglyLinkedListTest {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.addLastNode("김정윤");
		System.out.println(list.getLastNode());
		list.printList();
		list.addLastNode("피카츄");
		list.printList();
		
		list.addFirstNode("잠만보");
		list.printList();
		
		Node node = list.getNode("잠만보");
		list.insertAfterNode(node, "마자용");
		list.printList();
		
		// Link의 타입이 Node 타입이므로 Link가 출력될 때 link.toString으로 출력되므로 뒤에 노드들의 정보까지 다 나옴
		System.out.println(list.getPreviousNode(list.getNode("김정윤")));
		
		list.deleteNode("김정윤"); // 중간 노드 삭제
		list.printList();
		
		list.deleteNode("피카츄"); // 맨뒤 노드 삭제
		list.printList();
		
		list.deleteNode("잠만보"); // 맨 앞 노드 삭제
		list.printList();
		list.deleteNode("마자용"); // 맨 앞 노드 삭제
		list.printList();
		
	}

}
