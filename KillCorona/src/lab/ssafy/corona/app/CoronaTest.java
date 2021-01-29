package lab.ssafy.corona.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lab.ssafy.corona.virus.Virus;

public class CoronaTest {

	public static void main(String[] args) {
		
		Virus fv1 = new Virus("fv1", 5);
		Virus fv2 = new Virus("fv2", 9);
		Virus fv3 = new Virus("fv3", 1);
		Virus fv4 = new Virus("fv4", 7);
		Virus fv5 = new Virus("fv5", 3);
		
		List<Virus> list = new ArrayList<>();
		list.add(fv1);
		list.add(fv2);
		list.add(fv3);
		list.add(fv4);
		list.add(fv5);
		
		Collections.sort(list, ( o1, o2 ) -> {

			return o1.getLevel() - o2.getLevel();
			
		}); //람다식 표현 
		
		for( Virus fv : list) System.out.println(fv);
	}
}