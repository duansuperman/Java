package mang1chieu;

import java.util.Arrays;
import java.util.Collections;


public class DeMo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer a[]= new Integer[4];
		a[0]=2;
		a[1]=3;
		a[2]=7;
		a[3]=1;
		
		//In cac so nguyen to
		System.out.print("Cac so nguyen to trong mang a :");
		for(int i=0;i<a.length;i++) {
			if(a[i]>=2) {
				if(a[i]==2) {
					System.out.print(a[i]+"\t");
				}
				else {
					for(int j=3;j<=a[i]/2;j++) {
						if(a[i]%j==0) {
							continue;
						}
					}
					System.out.print(a[i]+"\t");
				}
			}
		}
		System.out.println();
		
		//Sap xep cac phan tu trong mang tang dan
		Arrays.parallelSort(a);
		System.out.print("Mang a sau khi sap xep tang dan:");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
		System.out.println();
		//Sap xep cac phan tu trong mang giam dan
		Arrays.sort(a, Collections.reverseOrder());
		System.out.print("Mang a sau khi sap xep giam dan:");
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+"\t");
		}
	}

}
