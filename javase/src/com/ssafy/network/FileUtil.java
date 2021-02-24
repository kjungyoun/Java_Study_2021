package com.ssafy.network;

import java.io.Closeable;

public class FileUtil {
	public static void close(Closeable c) {
		if(c!=null) {
			try {
				c.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
}
