package dieukien;

import java.util.Scanner;

public class DieuKien {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int thang;
		int nam;
		Scanner sc = new Scanner(System.in);
		System.out.println("Nhap thang = ");
		thang= sc.nextInt();
		System.out.println("Nhap nam = ");
		nam = sc.nextInt();
		switch (thang) {
		case 1:
			System.out.println("thang co 31 ngay");
			break ;
		case 3:
			System.out.println("thang co 31 ngay");
			break ;
		case 5:
			System.out.println("thang co 31 ngay");
			break ;
		case 7:
			System.out.println("thang co 31 ngay");
			break ;
		case 8:
			System.out.println("thang co 31 ngay");
			break ;
		case 10:
			System.out.println("thang co 31 ngay");
			break ;
		case 12:
			System.out.println("thang co 31 ngay");
			break ;
		case 2:
			if((nam%4==0&&nam%100!=0)||nam%400==0) {
				System.out.println("Nam nhuan co 29 ngay");
			}
			else {
				System.out.println("Nam khong nhuan co 28 ngay");
			}
			break ;
		default:
			System.out.println("Ban nhap sai roi");
		}
	}

}
