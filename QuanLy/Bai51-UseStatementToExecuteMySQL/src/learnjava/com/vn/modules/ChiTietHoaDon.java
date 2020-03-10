package learnjava.com.vn.modules;

public class ChiTietHoaDon {
	int MaCT;
	int MaHH;
	int MaHD;
	int SoLuongMua;
	double ThanhTien;
	public int getMaCT() {
		return MaCT;
	}
	public void setMaCT(int maCT) {
		MaCT = maCT;
	}
	public int getMaHH() {
		return MaHH;
	}
	public void setMaHH(int maHH) {
		MaHH = maHH;
	}
	public int getMaHD() {
		return MaHD;
	}
	public void setMaHD(int maHD) {
		MaHD = maHD;
	}
	public int getSoLuongMua() {
		return SoLuongMua;
	}
	public void setSoLuongMua(int soLuongMua) {
		SoLuongMua = soLuongMua;
	}
	public double getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(double thanhTien) {
		ThanhTien = thanhTien;
	}
	public ChiTietHoaDon(int maCT, int maHH, int maHD, int soLuongMua, double thanhTien) {
		super();
		MaCT = maCT;
		MaHH = maHH;
		MaHD = maHD;
		SoLuongMua = soLuongMua;
		ThanhTien = thanhTien;
	}
	public ChiTietHoaDon() {
		super();
	}
	@Override
	public String toString() {
		return "ChiTietHoaDon [MaCT=" + MaCT + ", MaHH=" + MaHH + ", MaHD=" + MaHD + ", SoLuongMua=" + SoLuongMua
				+ ", ThanhTien=" + ThanhTien + "]";
	}
	
}
