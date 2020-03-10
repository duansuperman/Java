package qlsv.model;

import java.util.ArrayList;
import java.util.Scanner;

import qlsv.io.SerializeFileFactory;

public class ChucNang {

	public static SinhVien nhapThongTinSV() {
		SinhVien sv  =new SinhVien();
		sv.ma=SinhVien.dem;
		SinhVien.dem++;
		
		//Nhap ten
		System.out.println("Nhap ten sinh vien :");
		String ten = new Scanner(System.in).nextLine();
		sv.hoTen= ten;
		//Nhap lop
		System.out.println("Nhap lop sinh vien :");
		String lop = new Scanner(System.in).nextLine();
		sv.lop=lop;
		//Nhap dtb;
		System.out.println("Nhap dtb cu sinh vien :");
		float dtb = new Scanner(System.in).nextFloat();
		sv.dtb= dtb;
		
		return sv;
	}
	public static void hienThiDanhSachSV(ArrayList<SinhVien> arr) {
		System.out.println("Danh sach sinh vien la :");
		for(SinhVien sv : arr) {
			System.out.println(sv);
		}
	}
	
	public static boolean luuFile(ArrayList<SinhVien> arr, String path) {
		SerializeFileFactory.luuFile(arr, path);
		return false;
	}
	public static ArrayList<SinhVien> docFile(String path){
		ArrayList<SinhVien> arr = new ArrayList<SinhVien>();
		arr = SerializeFileFactory.docFile(path);
		return arr;
	}
	public static void timKiemThongTinSV(ArrayList<SinhVien> arr, String key) {
		int check =0;
		for(SinhVien sv: arr) {
			if(sv.getHoTen().contains(key)) {
				System.out.println(sv);
				check=1;
			}
		}
		if(check==0) {
			System.out.println("Khong tim thay sinh vien voi tu khoa :"+key);
		}
	}
	public static void thoat() {
		System.exit(0);
	}
}
