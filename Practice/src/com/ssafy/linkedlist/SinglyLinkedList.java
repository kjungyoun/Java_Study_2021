package com.ssafy.linkedlist;

public class SinglyLinkedList {
	private Node head;
	
	public void addFirstNode(String name) {
		Node newNode = new Node(name,head);
		head = newNode;
	}
	
	public Node getLastNode() {
		Node currNode = head;
		if(currNode !=null) {
			while(currNode.link != null) {
				currNode = currNode.link;
			}
		}
		return currNode;
	}
	public void addLastNode(String name) {
		if(head == null) {
			addFirstNode(name);
		}else {
			Node lastNode = getLastNode();
			Node newNode = new Node(name);
			lastNode.link = newNode;
		}
	}
	
	public void insertAfterNode(Node preNode, String name) {
		if(preNode == null) {
			System.out.println("선행 노드가 없어 삽입 불가");
			return;
		}else {
			Node newNode = new Node(name,preNode.link);
			preNode.link = newNode;
		}
	}
	
	public Node getNode(String name) {
		for(Node currNode = head; currNode !=null; currNode = currNode.link) {
			if(currNode.name.equals(name))
			return currNode;
		}
		return null;
	}
	
	public Node getPreviousNode(Node target) {
		Node currNode = head;
		Node nextNode = null;
		if(currNode != null) {
			while((nextNode = currNode.link) !=null) {
				if(nextNode == target) {
					return currNode;
				}
				currNode = nextNode;
			}
		}
		return null;
	}
	
	public void deleteNode(String name) {
		if(head == null) {
			System.out.println("공백노드입니다. 삭제가 불가능");
			return;
		}else {
			Node targetNode = getNode(name);
			if(targetNode == null) return;
			Node preNode = getPreviousNode(targetNode);
			if(preNode == null && targetNode == head) {
				head = targetNode.link;
			}else {
				preNode.link = targetNode.link;
			}
			targetNode.link = null;
		}
	}
	
	public void printList() {
		System.out.print("L = (  ");
		for(Node currNode = head; currNode != null; currNode = currNode.link) {
			System.out.print(currNode.name+" ");
		}
		System.out.println("  )");
	}
}
