package model;

import java.util.Vector;

public class NhomKhachHang {
	String maNhom;
	String tenNhom;
	Vector<KhachHang> khachHangs;
	public String getMaNhom() {
		return maNhom;
	}
	public void setMaNhom(String maNhom) {
		this.maNhom = maNhom;
	}
	public String getTenNhom() {
		return tenNhom;
	}
	public void setTenNhom(String tenNhom) {
		this.tenNhom = tenNhom;
	}
	public Vector<KhachHang> getKhachHangs() {
		return khachHangs;
	}
	public void setKhachHangs(Vector<KhachHang> khachHangs) {
		this.khachHangs = khachHangs;
	}
	public NhomKhachHang() {
		super();
		khachHangs=new Vector<KhachHang>();
	}
	public NhomKhachHang(String maNhom, String tenNhom) {
		super();
		this.maNhom = maNhom;
		this.tenNhom = tenNhom;
		khachHangs =new Vector<KhachHang>();
	}
	
	public String toString() {
		// TODO Auto-generated method stub
		return this.tenNhom;
	}
	
}
