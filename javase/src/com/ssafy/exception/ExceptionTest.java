package com.ssafy.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

class MyUtil {
	public static void load(String path) throws FileNotFoundException {
		FileInputStream fis = null;
		fis = new FileInputStream(path);
	}
	
	public static int div(int a, int b) throws Exception {
		if(b==0) {
			throw new Exception("0으로 나눌 수 없습니다.");
		}else {
			return a/b;
		}
	}
}

public class ExceptionTest {

	public static void main(String[] args) throws Exception {
		try {
			MyUtil.load("c:/test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println(MyUtil.div(128, 0));
	}

}
