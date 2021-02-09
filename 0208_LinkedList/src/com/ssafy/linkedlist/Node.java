package com.ssafy.linkedlist;

public class Node {
	// 알고리즘 문제를 풀 때는 Setter와 Getter를 사용해서 접근하는 것보다 직접 접근하는 것이 좋다.
	public String data;
	public Node link;
	
	public Node(String data) {
		super();
		this.data = data;
	}

	public Node(String data, Node link) {
		super();
		this.data = data;
		this.link = link;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [data=").append(data).append(", link=").append(link).append("]");
		return builder.toString();
	}
	
	
}
