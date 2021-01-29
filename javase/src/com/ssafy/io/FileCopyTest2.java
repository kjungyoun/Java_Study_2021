package com.ssafy.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
/** byte 계열은 byte 단위로 입출력 하므로 원본 손상 없이 모든 파일 입출력*/
public class FileCopyTest2 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
//		String readFile = "C:/SSAFY/WordCloud2.zip";
//		String wFile = "C:/SSAFY/copy1.zip";
		String readFile = "res/banana.jpg";
		String wFile = "res/copy1.jpg";
				
		
		try {
			fis = new FileInputStream(readFile);
			fos = new FileOutputStream(wFile);
			
			int len =0;
			byte[] buf = new byte[1024];
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
