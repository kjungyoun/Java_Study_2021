package com.SSAFY.HelloWorld;
import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
        int hour = scan.nextInt();
        int min = scan.nextInt();
        if(min<45){
            if(hour==0) hour = 23;
            hour -= 1;
            min = 60 + (min-45);
        }else{
            min = min-45;
        }
        System.out.print(hour+" "+min);
	}

}
