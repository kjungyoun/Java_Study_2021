package Programmers;
import java.util.Scanner;
public class WaterMelon {
	public static String solution(int n) {
        String su = "수";
        String bak = "박";
        String answer = "";
        for(int i=1; i<=n; i++){
            if(i%2 == 1){
                answer = answer + su;
            }else{
                answer = answer + bak;
            }
        }
        
        return answer;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(solution(N));
    }

}
