package kethuaclass;

public class TestNhanVien {

	public static void main(String[] args) {
		
		Nguoi nvct1 = new NhanVienChinhThuc();
		nvct1.setTen("nguyen Van A");
		nvct1.setCmnd("123456");
		nvct1.setLuong(10000);
		nvct1.setSdt("123");
		System.out.println("Thong tin cua nhan vien chinh thuc 1: "+nvct1);
		nvct1.inLuong();
		nvct1.xuatTen();
		
		NhanVienChinhThuc nvct2= new NhanVienChinhThuc();
		nvct2.setTen("Nguyen Van Teo");
		nvct2.setCmnd("123456");
		nvct2.setLuong(50000);
		System.out.println("Thong tin cua nhan vien chinh thuc 2: "+nvct2);
		nvct2.inLuong();
		nvct2.xuatTen();
		
		
		Nguoi nvtv1 = new NhanVienThoiVu();
		nvtv1.setCmnd("123");
		nvtv1.setTen("Nguyen Van Rot");
		nvtv1.setLuong(6000);
		
		System.out.println("Thong tin nhan vien thoi vu 1 : "+nvtv1);
				
		NhanVienThoiVu nvtv2 = new NhanVienThoiVu();
		nvtv2.setCmnd("123");
		nvtv2.setTen("Nguyen Van Dau");
		nvtv2.setLuong(7000);
	}

}
