package com.ssafy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Reader, Writer 테스트
 * char 계열은 2byte 단위로 입출력해서 문자 처리하므로 문자 데이터가 아닌 경우
 * 원본이 손상된다.
 */
public class FileCopyTest3 {
	public static void main(String[] args) {
		FileReader fis = null;
		FileWriter fos = null;
		// 문자열로 된 파일은 char형으로 copy해도 전혀 깨지지 않는다.
		String readFile = "res/BaseStation1.txt";
		String wFile = "res/copy2.txt";
//		String readFile = "res/banana.jpg";
//		String wFile = "res/copy2.jpg";
				
		
		try {
			fis = new FileReader(readFile);
			fos = new FileWriter(wFile);
			
			int len =0;
			char[] buf = new char[1024];
			while((len = fis.read(buf)) != -1) {
				fos.write(buf,0,len);
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
