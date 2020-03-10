package qlsv.interfaces;

import java.util.ArrayList;
import java.util.Scanner;

import qlsv.model.ChucNang;
import qlsv.model.SinhVien;

public class ManHinhChinh {
	static ArrayList<SinhVien> arr =  new ArrayList<SinhVien>();
	
	public static void menu() {
		System.out.println("===================================");
		System.out.println("============ MENU THAO TAC =========");
		System.out.println("1. Nhap sinh vien moi");
		System.out.println("2. Hien thi danh sach sinh vien moi");
		System.out.println("3. Tim kiem sinh vien voi khoa");
		System.out.println("4. Thoat");
		System.out.println("===================================\n");
	}
	
	public static void thaoTac() {
		System.out.println("Moi ban nhap thao tac so : ");
		int key = new Scanner(System.in).nextInt();
		String path = "d:\\ketqua.txt";
		switch (key) {
		case 1:
			SinhVien sv = new SinhVien();
			
			sv = ChucNang.nhapThongTinSV();
			arr.add(sv);
			ChucNang.luuFile(arr, path);
			break;

		case 2:
			ChucNang.hienThiDanhSachSV(arr);
			break;
		case 3:
			System.out.println("Tim kiem sinh vien voi tu khoa : ");
			String strKey = new Scanner(System.in).nextLine();
			ChucNang.timKiemThongTinSV(arr, strKey);
			break;
		case 4:
			System.out.println("Neu ban muon thoat nhan 1 de thoat va 0 de huy lenh :");
			int check = new Scanner(System.in).nextInt();
			if(check ==1) {
				ChucNang.thoat();
			}
			
		default:
			System.out.println("Yeu cau ban chua dung. Vui long nhap lai");
		}
	}
	public static void main(String[] args) {
		
		
		while(true) {
			menu();
			thaoTac();
		}
		
	}

}
