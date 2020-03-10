package model;

public class KhachHang {
	String hoTen;
	String diaChi;
	String phone;
	String email;
	NhomKhachHang nhomKhachHang;
	public KhachHang(String hoTen, String diaChi, String phone, String email) {
		super();
		this.hoTen = hoTen;
		this.diaChi = diaChi;
		this.phone = phone;
		this.email = email;
		nhomKhachHang = new NhomKhachHang();
	}
	public KhachHang() {
		super();
		nhomKhachHang = new NhomKhachHang();
	}
	public String getHoTen() {
		return hoTen;
		
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public NhomKhachHang getNhomKhachHang() {
		return nhomKhachHang;
	}
	public void setNhomKhachHang(NhomKhachHang nhomKhachHang) {
		this.nhomKhachHang = nhomKhachHang;
	}
	
	public String toString() {
		return this.hoTen;
	}
	
}
