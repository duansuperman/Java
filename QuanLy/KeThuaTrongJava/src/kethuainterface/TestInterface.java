package kethuainterface;

import java.util.ArrayList;
import java.util.Collections;

public class TestInterface {

	public static void main(String[] args) {
		ArrayList<Lop1> arr =  new ArrayList<Lop1>();
		arr.add(new Lop1("Nguyen Van An", 12));
		arr.add(new Lop1("Nguyen Van Teo", 14));
		arr.add(new Lop1("Nguyen Minh Hieu",15));
		arr.add(new Lop1("Ta Minh Hoan",14));
		arr.add(new Lop1("Ta Minh Hoan",23));
		for(Lop1 lp:arr) {
			System.out.println(lp);
		}
		Collections.sort(arr);
		System.out.println("Sau khi sort :");
		for(Lop1 lp:arr) {
			System.out.println(lp);
		}
	}

}
