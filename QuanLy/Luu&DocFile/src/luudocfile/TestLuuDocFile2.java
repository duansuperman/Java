package luudocfile;

import java.util.ArrayList;

public class TestLuuDocFile2 {

	public static void main(String[] args) {
		ArrayList<KhachHang> arr = new ArrayList<KhachHang>();
		arr.add(new KhachHang("Nguyen Minh Huy", "123"));
		arr.add(new KhachHang("Nguyen Binh Minh", "124"));
		arr.add(new KhachHang("Nguyen Minh An", "125"));
		arr.add(new KhachHang("Nguyen An Nguy", "126"));
		
		/*
		 * if(SerializeFileFactory.luuFile(arr, "D:\\LuuFile/dulieu4.txt")) {
		 * System.out.println("Thanh cong"); } else { System.out.println("That bai"); }
		 */
		ArrayList<KhachHang> list = new ArrayList<KhachHang>();
		list = SerializeFileFactory.DocFile("D:\\LuuFile/dulieu4.txt");
		for(KhachHang kh : list) {
			System.out.println(kh);
		}
	}

}
