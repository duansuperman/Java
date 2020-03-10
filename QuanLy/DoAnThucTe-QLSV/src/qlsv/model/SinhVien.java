package qlsv.model;

import java.io.Serializable;

public class SinhVien implements Serializable, Comparable<SinhVien>{
	/**
	 * 
	 */
	private final long serialVersionUID = 1L;
	static int dem=0;
	int ma = 0;
	String hoTen;
	String lop;
	float dtb;
	
	public int getMa() {
		return ma;
	}

	public void setMa(int ma) {
		this.ma = ma;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public float getDtb() {
		return dtb;
	}

	public void setDtb(float dtb) {
		this.dtb = dtb;
	}

	
	public SinhVien(String hoTen, String lop, float dtb) {
		super();
		this.hoTen = hoTen;
		this.lop = lop;
		this.dtb = dtb;
	}

	public long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public SinhVien() {
		super();
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ma+" - "+hoTen+" - "+lop+" - "+dtb;
	}
	@Override
	public int compareTo(SinhVien o) {
		// TODO Auto-generated method stub
		return hoTen.compareToIgnoreCase(o.hoTen);
	}
	
	
}
