package learnjava.com.vn.models;

public class SanPham {
	String MaSP;
	String TenSP;
	int SoLuong;
	int DonGia;
	String MaDM;
	int IsDeleted;
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public int getDonGia() {
		return DonGia;
	}
	public void setDonGia(int donGia) {
		DonGia = donGia;
	}
	public String getMaDM() {
		return MaDM;
	}
	public void setMaDM(String maDM) {
		MaDM = maDM;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	public SanPham(String maSP, String tenSP, int soLuong, int donGia, String maDM, int isDeleted) {
		super();
		MaSP = maSP;
		TenSP = tenSP;
		SoLuong = soLuong;
		DonGia = donGia;
		MaDM = maDM;
		IsDeleted = isDeleted;
	}
	public SanPham() {
		super();
	}
	@Override
	public String toString() {
		return this.TenSP;
	}
	
}
