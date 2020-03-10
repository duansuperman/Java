package learnjava.com.model;

public class LoaiCongVan {
	int iD;
	String maLoaiCongVan;
	String tenCongVan;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getMaLoaiCongVan() {
		return maLoaiCongVan;
	}
	public void setMaLoaiCongVan(String maLoaiCongVan) {
		this.maLoaiCongVan = maLoaiCongVan;
	}
	public String getTenCongVan() {
		return tenCongVan;
	}
	public void setTenCongVan(String tenCongVan) {
		this.tenCongVan = tenCongVan;
	}
	public LoaiCongVan(int iD, String maLoaiCongVan, String tenCongVan) {
		super();
		this.iD = iD;
		this.maLoaiCongVan = maLoaiCongVan;
		this.tenCongVan = tenCongVan;
	}
	public LoaiCongVan() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tenCongVan;
	}
	
}
