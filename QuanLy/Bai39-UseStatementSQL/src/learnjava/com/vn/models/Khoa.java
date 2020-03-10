package learnjava.com.vn.models;

public class Khoa {
	String maKhoa;
	String tenKhoa;
	public void setMaKhoa(String maKhoa) {
		this.maKhoa = maKhoa;
	}
	public void setTenKhoa(String tenKhoa) {
		this.tenKhoa = tenKhoa;
	}
	public String getMaKhoa() {
		return maKhoa;
	}
	public String getTenKhoa() {
		return tenKhoa;
	}
	public Khoa(String maKhoa, String tenKhoa) {
		super();
		this.maKhoa = maKhoa;
		this.tenKhoa = tenKhoa;
	}
	public Khoa() {
		super();
	}
	@Override
	public String toString() {
		return tenKhoa;
	}
	

}
