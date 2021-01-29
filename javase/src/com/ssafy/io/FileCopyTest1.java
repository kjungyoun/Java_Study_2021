package com.ssafy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyTest1 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		String readFile = "res/BaseStation1.txt";
		String wFile = "res/copy1.txt";
		
		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(wFile);
			
			int len =0;
			while((len = fis.read()) != -1) {
				fos.write(len);
			}
			System.out.println("IO 종료");
		} catch (Exception e) { 
			// try를 사용했다고 해서 무조건 catch를 해줘야한다는 것은 아님!
			e.printStackTrace();
		}finally {
			FileUtil.close(fis);
			FileUtil.close(fos);
		}
	}
}
