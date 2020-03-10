package classjava;

public class KhachHang {
	private String maKH;
	private String tenKH;
	private String diaChi;
	private String soDT;
	
	//constructer không đối số
	public KhachHang() {
		System.out.println("Day la ham dung khong doi so");
	}
	//Neu tham so giong ten thuoc tinh thi phai dung con tro this
	public KhachHang(String maKH, String tenKH, String diaChi, String soDT) {
		this.maKH = maKH;
		this.tenKH = tenKH;
		this.diaChi = diaChi;
		this.soDT= soDT;
		
	}
	
	//Get & set trong class. co 4 thuoc tinh thi co 8 ham getter & setter
	public String getMaKH() {
		return maKH;
	}
	
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public String getSoDT() {
		return soDT;
	}
	
	public void setSoDT(String soDT) {
		this.soDT = soDT;
	}
	
	
	@Override
	//Khong dung this cung khong sao , neu dung this se cu the hon
	public String toString() {
		// TODO Auto-generated method stub
		return "MaKH: "+maKH+" TenKH: "+tenKH+" DiaChi: "+diaChi+" SDT: "+soDT;
	}
}
