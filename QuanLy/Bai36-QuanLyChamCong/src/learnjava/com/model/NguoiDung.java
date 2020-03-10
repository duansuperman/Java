package learnjava.com.model;

public class NguoiDung {
	public NguoiDung() {
		super();
	}
	int iD;
	String userName;
	String password;
	String hoTen;
	public int getiD() {
		return iD;
	}
	public void setiD(int iD) {
		this.iD = iD;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public NguoiDung(int iD, String userName, String password, String hoTen) {
		super();
		this.iD = iD;
		this.userName = userName;
		this.password = password;
		this.hoTen = hoTen;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return hoTen;
	}
	
	
}
