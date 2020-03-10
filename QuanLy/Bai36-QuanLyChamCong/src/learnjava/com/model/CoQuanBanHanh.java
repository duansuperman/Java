package learnjava.com.model;

public class CoQuanBanHanh {
	int iD;
	String maCoQuan;
	String tenCoQuan;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getMaCoQuan() {
		return maCoQuan;
	}
	public void setMaCoQuan(String maCoQuan) {
		this.maCoQuan = maCoQuan;
	}
	public String getTenCoQuan() {
		return tenCoQuan;
	}
	public void setTenCoQuan(String tenCoQuan) {
		this.tenCoQuan = tenCoQuan;
	}
	public CoQuanBanHanh(int iD, String maCoQuan, String tenCoQuan) {
		super();
		this.iD = iD;
		this.maCoQuan = maCoQuan;
		this.tenCoQuan = tenCoQuan;
	}
	public CoQuanBanHanh() {
		super();
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return tenCoQuan;
	}
}
