package vonglap;

import java.util.Scanner;

public class DeMo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap n = ");
		int n = sc.nextInt();
		//Do while
		int gt = 1;
		int dem =1;
		do {
			gt*=dem;
			dem++;
		}while(dem<=n);
		System.out.println("n! = "+gt);
		
		//while
		gt=1;
		dem=1;
		while(dem<=n) {
			gt*=dem;
			dem++;
		}
		System.out.println("n! = "+gt);
		
		//For
		gt=1;
		for(int i=1;i<=n;i++) {
			gt*=i;
		}
		System.out.println("n! = "+gt);
	}

}
