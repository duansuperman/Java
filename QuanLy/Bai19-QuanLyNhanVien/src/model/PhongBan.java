package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Vector;

//Việc kế thừa interface Serializable nhằm để xuất đối tượng ra file txt
public class PhongBan implements Serializable {

	private String maPhongBan;
	private String tenPhongBan;
	private Vector<NhanVien> nhanViens;
	
	
	public String getMaPhongBan() {
		return maPhongBan;
	}
	public void setMaPhongBan(String maPhongBan) {
		this.maPhongBan = maPhongBan;
	}
	public String getTenPhongBan() {
		return tenPhongBan;
	}
	public void setTenPhongBan(String tenPhongBan) {
		this.tenPhongBan = tenPhongBan;
	}
	public Vector<NhanVien> getNhanViens() {
		return nhanViens;
	}
	public void setNhanViens(Vector<NhanVien> nhanViens) {
		this.nhanViens = nhanViens;
	}
	
	public void addNhanVien(NhanVien nv) {
		nhanViens.add(nv);
	}

	public String toString() {
		//return "PhongBan [maPhongBan=" + maPhongBan + ", tenPhongBan=" + tenPhongBan + ", nhanViens=" + nhanViens + "]";
		return this.tenPhongBan;
	}
	public PhongBan() {
		nhanViens = new Vector<NhanVien>();
	}
	public PhongBan(String maPhongBan, String tenPhongBan) {
		super();
		this.maPhongBan = maPhongBan;
		this.tenPhongBan = tenPhongBan;
		nhanViens = new Vector<NhanVien>();
	}
	
	

}
