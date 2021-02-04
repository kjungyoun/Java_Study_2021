package com.ssafy.stack;

import java.util.Stack;

public class S3_StackAPITest {

	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		
		System.out.println(stack.isEmpty()+" "+stack.size());
		
		stack.push("피카츄");
		stack.push("꼬부기");
		stack.push("파이리");
		
		System.out.println(stack.isEmpty()+" "+stack.size());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty()+" "+stack.size());
		System.out.println(stack.pop()); // 삭제하면서 출력
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.isEmpty()+" "+stack.size());
		System.out.println(stack.pop());

	}

}
