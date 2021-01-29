package com.ssafy.io;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

/**
 * 자바의 기본 타입을 쉽게 입출력
 *
 */
public class DataIOTest {
	public static void main(String[] args) {
		// try문 바깥에 선언하고 안에서 생성해야한다.
		//1.8 버전에서는 try문안에 선언하고 생성가능해서 따로 close 안해도 된다.
		DataInputStream dis = null;
		DataOutputStream dos = null;
		FileInputStream fis = null;
		FileOutputStream fos = null;
		
		try {
			fos = new FileOutputStream("data.txt");
			dos = new DataOutputStream(fos);
			
			dos.writeLong(256);
			dos.writeDouble(256);			
			dos.writeBoolean(true);			
			dos.writeUTF("Hello");	
			
			// 반드시 출력한 순서대로 읽어야 한다!
			
			fis = new FileInputStream("data.txt");
			dis = new DataInputStream(fis);
			System.out.println(dis.readLong());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readUTF());
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			FileUtil.close(dis);
			FileUtil.close(dos);
			FileUtil.close(fis);
			FileUtil.close(fos);
		}
	}
}
