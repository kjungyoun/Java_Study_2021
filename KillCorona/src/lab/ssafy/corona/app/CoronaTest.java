package lab.ssafy.corona.app;

import lab.ssafy.corona.virus.Corona;
import lab.ssafy.corona.virus.Virus;

public class CoronaTest {

	public static void main(String[] args) {
//		Virus virus = new Virus();
//		virus.setName("MERS");
//		virus.setLevel(5);
		
		Corona corona = new Corona("COVID-19",8,200);
//		corona.setName("COVID-19");
//		corona.setLevel(8);
//		corona.setSpreadSpeed(200);
		corona.showInfo();
		
		Virus virus = new Virus();
		System.out.println(virus);
		System.out.println(corona);
		
		Virus virus1 = new Corona();
		System.out.println(virus1);
	}

}
