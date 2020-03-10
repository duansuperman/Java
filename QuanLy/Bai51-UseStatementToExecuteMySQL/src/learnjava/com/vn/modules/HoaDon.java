package learnjava.com.vn.modules;

public class HoaDon {
	int MaHD;
	double TongTien;
	public HoaDon(int maHD, double tongTien) {
		super();
		MaHD = maHD;
		TongTien = tongTien;
	}
	public HoaDon() {
		super();
	}
	public int getMaHD() {
		return MaHD;
	}
	public void setMaHD(int maHD) {
		MaHD = maHD;
	}
	public double getTongTien() {
		return TongTien;
	}
	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	@Override
	public String toString() {
		return Double.toString(TongTien);
	}
	
}
