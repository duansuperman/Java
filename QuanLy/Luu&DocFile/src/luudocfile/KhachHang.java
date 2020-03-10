package luudocfile;

import java.io.Serializable;

public class KhachHang implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String ten;
	String ma;
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getMa() {
		return ma;
	}
	public void setMa(String ma) {
		this.ma = ma;
	}
	public KhachHang(String ten, String ma) {
		super();
		this.ten = ten;
		this.ma = ma;
	}
	public KhachHang() {
		super();
	}
	@Override
	public String toString() {
		return "KhachHang [ten=" + ten + ", ma=" + ma + "]";
	}
	
	
}
