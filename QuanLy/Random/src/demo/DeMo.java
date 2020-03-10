package demo;

import java.util.ArrayList;
import java.util.Random;

public class DeMo {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();
		Random rd = new Random();
		for(int i=0;i<100;i++) {
			//Lay cac gia tri tu 1->100
			int k = rd.nextInt(100)+1;
			a.add(k);
		}
	
		for(int i:a) {
			System.out.println(i);
		}
	}

}
