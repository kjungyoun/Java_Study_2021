package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class ExceptionTest1 {

	 public static void main(String[] args) {
		
		// Code We Need
//		FileInputStream fins = new FileInputStream("hello.txt");
		
		// #1 try-catch-finally
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("hello.txt");
//			// 수행 코드 ....
//		}catch(FileNotFoundException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//			e.printStackTrace();
//		}finally {
//			try {
//				fis.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
//		
		// #2 throws
//		 public static void main(String[] args) throws FileNotFoundException {
//		 FileInputStream fins = new FileInputStream("hello.txt");
		
		// #3 throw e
//		FileInputStream fis = null;
//		try {
//			fis = new FileInputStream("hello.txt");			
//		}catch(FileNotFoundException e) {
//			System.out.println("Handing Exception : " + e.getMessage());
//			e.printStackTrace();
//			
//			throw new IOException(); // throw IOException 객체 to main() 메인메소드에게 부담을 줌,
//			
//		}finally {
//			try {
//				fis.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		// #4 use AutoCloseable
		try( FileInputStream fis  = new FileInputStream("hello.txt"); ) {
			// fis code (예외 발생 가능성 있는 자원 txt), 알아서 close 시키기 위해 작성
		}catch(IOException e) {
			System.out.println("Handing Exception : " + e.getMessage());
			e.printStackTrace();
		}	

	}

}