package com.ssafy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest2 {

	public static void main(String[] args)  {
		
		// #0 Call Chain
		ControllerEx ec = new ControllerEx();
		ec.m();
	}
}

class ControllerEx{
	public void m()  {
		ServiceEx se = new ServiceEx();
		try {
		se.m();
		}catch(IOException e) {
			
		}
	}
}
class ServiceEx{
	public void m() throws IOException {
		DaoEx de = new DaoEx();
		de.m();
	}
}

//throws IOException 없을 때와 있을 때
class DaoEx{
	public void m() throws IOException {} 
}
