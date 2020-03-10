package luudocfile;

import java.util.ArrayList;

public class TestLuuDocFile {

	public static void main(String[] args) {
		ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
		arr.add(new KhachHang("Nguyen Minh Huy", "123"));
		arr.add(new KhachHang("Nguyen Binh Minh", "124"));
		arr.add(new KhachHang("Nguyen Minh An", "125"));
		arr.add(new KhachHang("Nguyen An Nguy", "126"));

		/*
		 * boolean kt = PhuongThucDocVaLuu.luuFile(arr, "D:\\LuuFile/dulieu.txt"); if
		 * (kt) { System.out.println("Luu thanh cong"); } else {
		 * System.out.println("Luu that bai"); }
		 */
		
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		list = PhuongThucDocVaLuu.DocFile("D:\\LuuFile/dulieu3.txt");
		for(KhachHang kh : list) {
			System.out.println(kh);
		}
	}

}
