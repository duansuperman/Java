package collection;

import java.util.Collections;

public class ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Khai bao mag arraylist kieu khong tuong minh
		java.util.ArrayList ds = new java.util.ArrayList();
		ds.add("duan");
		ds.add(9);
		ds.add(9+"ok");
		System.out.println("So luong phan tu trong mang : "+ds.size());
		
		//Them 1 phan tu vao ArrayList
		ds.add(1,"okbaby");
		
		//Xoa 1 phan tu trong ArrayList
		ds.remove("okbaby");
		
		//Sua mot phan tu trong ArrayList
		ds.set(0, "hoc java");
		
		//Duyet mang dung for 
		System.out.println("Phan tu trong mang ds : ");
		for(int i=0;i<ds.size();i++) {
			System.out.println(ds.get(i));
		}
		
		//Duyet mang dung object 
		System.out.println("Phan tu trong mang ds : ");
		for(Object o: ds) {
			System.out.println(o);
		}
		
		//Khai bao ArrayList kieu tuong minh
		java.util.ArrayList<Double> ds1 = new java.util.ArrayList<Double>();
		for(int i=0;i<=10;i++) {
			ds1.add(i*2.0);
		}
		
		//Sort trong ArrayList
		Collections.sort(ds1);
		//Duyet mang ArrayList bang for 
		System.out.println("Mang ds1 : ");
		for(int i=0;i<ds1.size();i++) {
			System.out.println(ds1.get(i));
		}
		
		
		//Sort giam dan
		Collections.sort(ds1,Collections.reverseOrder());
		//Duyet mang dung object
		System.out.println("Mang ds2 : ");
		for(Double k: ds1) {
			System.out.println(k);
		}
		

	}

}
