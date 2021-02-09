package com.ssafy.linkedlist;

public class Node {
	public String name;
	Node link;
	
	public Node(String name) {
		super();
		this.name = name;
	}
	
	public Node(String name, Node link) {
		super();
		this.name = name;
		this.link = link;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [name=").append(name).append(", link=").append(link).append("]");
		return builder.toString();
	}
	
	
}
