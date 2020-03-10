package learnjava.com.vn.modules;

public class HangHoa {
	int Ma;
	String TenHangHoa;
	String DinhDanh;
	int SoLuong;
	double DonGia;
	public int getMa() {
		return Ma;
	}
	public void setMa(int ma) {
		Ma = ma;
	}
	public String getTenHangHoa() {
		return TenHangHoa;
	}
	public void setTenHangHoa(String tenHangHoa) {
		TenHangHoa = tenHangHoa;
	}
	public String getDinhDanh() {
		return DinhDanh;
	}
	public void setDinhDanh(String dinhDanh) {
		DinhDanh = dinhDanh;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public double getDonGia() {
		return DonGia;
	}
	
	public void setDonGia(double donGia) {
		DonGia = donGia;
	}
	@Override
	public String toString() {
		return TenHangHoa;
	}
	public HangHoa(int ma, String tenHangHoa, String dinhDanh, int soLuong, double donGia) {
		super();
		Ma = ma;
		TenHangHoa = tenHangHoa;
		DinhDanh = dinhDanh;
		SoLuong = soLuong;
		DonGia = donGia;
	}
	public HangHoa() {
		super();
	}
	
}
