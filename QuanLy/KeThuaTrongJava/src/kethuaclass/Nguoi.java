package kethuaclass;

public abstract class Nguoi {
	private String cmnd;
	private String ten;
	private String sdt;
	
	public int k;
	/*
	 * Bat ky phuong thuc chung ma cac lop con deu dung thi phai co tu khoa abstract
	 * => the hien tinh da hinh
	 */
	 
	
	public abstract void inLuong();
	
	public void xuatTen() {
		System.out.println("Ten cua nhan vien lay tu lop cha "+ten);
	}
	
	public double getLuong() {
		return luong;
	}
	public void setLuong(double luong) {
		this.luong = luong;
	}

	private double luong;
	public String getCmnd() {
		return cmnd;
	}
	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}
	public String getTen() {
		return ten;
	}
	public void setTen(String ten) {
		this.ten = ten;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	
	public Nguoi(String cmnd, String ten, String sdt) {
		super();
		this.cmnd = cmnd;
		this.ten = ten;
		this.sdt = sdt;
	}
	public Nguoi() {
		super();
	}
	@Override
	public String toString() {
		return "Nguoi [cmnd=" + cmnd + ", ten=" + ten + ", sdt=" + sdt + ", luong=" + luong + "]";
	}
	
	public void test() {
		
	}
	

}
