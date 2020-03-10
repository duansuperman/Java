package classjava;

public class TestHCN {

	public static int x = 1;
	//Nhap chong ham overloading 
	static void ovl1(int a) {
		System.out.println("ham ovl1 oc 1 doi so a");
	}
	static void ovl1(int a, int b) {
		System.out.println("ham ovl1 co 2 doi so a&b");
	}
	
	public static String fn1() {
		return "OK";
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HinhChuNhat hcn = new HinhChuNhat();
		System.out.println(hcn);
		HinhChuNhat hcn1 = new HinhChuNhat(4,2);
		System.out.println(hcn1);
		System.out.println("Chu vi hcn1 = "+hcn1.tinhChuVi());
		System.out.println("Dien tich hcn1 = "+hcn1.tinhDienTich());
		HinhChuNhat hcn2 = new HinhChuNhat(1,4);
		System.out.println(hcn2);
		
		//Thu ham overloading 
		ovl1(1);
		ovl1(1,2);
		HinhChuNhat hcn3 = new HinhChuNhat();
		hcn3.fn1();
		hcn3.fn1(1);
		System.out.println(fn1());
		
		HinhChuNhat hcn4 = new HinhChuNhat(1,2);
		HinhChuNhat hcn5 = new HinhChuNhat(2,3);
		System.out.println("Tong hcn4 & hcn 5 = "+hcn4.tinhTong2HCN(hcn5));
		
		//Test static ingredient
		System.out.println(HinhChuNhat.x);
		HinhChuNhat.x = 100;
		HinhChuNhat hcn6= new HinhChuNhat();
		System.out.println(hcn6.x);
		System.out.println(x);
		
		//alias mechanism
		HinhChuNhat hcn7 = new HinhChuNhat(7,5);
		HinhChuNhat hcn8 =  new HinhChuNhat(3,2);
		System.out.println(hcn7);
		System.out.println(hcn8);
		
		//hcn8 tro den vung nho hcn7 va vung nho hcn8 tro truoc do goi la rac va he thong se tu gom lai
		hcn8=hcn7;
		System.out.println(hcn7);
		System.out.println(hcn8);
		
		HinhChuNhat hcn9 = new HinhChuNhat(10,9);
		hcn8=hcn9;
		hcn7 = hcn9;
		System.out.println(hcn7);
		System.out.println(hcn8);
		System.out.println(hcn9);
		
	}

}
