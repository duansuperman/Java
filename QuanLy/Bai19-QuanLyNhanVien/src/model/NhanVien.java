package model;

import java.io.Serializable;


public class NhanVien implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String maNhanVien;
	private String tenNhanVien;
	private java.util.Date ngaySinh;
	private java.util.Date ngayVaoLam;
	public String getMaNhanVien() {
		return maNhanVien;
	}
	public void setMaNhanVien(String maNhanVien) {
		this.maNhanVien = maNhanVien;
	}
	public String getTenNhanVien() {
		return tenNhanVien;
	}
	public void setTenNhanVien(String tenNhanVien) {
		this.tenNhanVien = tenNhanVien;
	}
	public java.util.Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(java.util.Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public java.util.Date getNgayVaoLam() {
		return ngayVaoLam;
	}
	public void setNgayVaoLam(java.util.Date ngayVaoLam) {
		this.ngayVaoLam = ngayVaoLam;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String toString() {
		return this.tenNhanVien;
	}
	public NhanVien(String maNhanVien, String tenNhanVien, java.util.Date ngaySinh, java.util.Date ngayVaoLam) {
		super();
		this.maNhanVien = maNhanVien;
		this.tenNhanVien = tenNhanVien;
		this.ngaySinh = ngaySinh;
		this.ngayVaoLam = ngayVaoLam;
	}
	public NhanVien() {
		super();
	}

	
	
}
