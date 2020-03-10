package learnjava.com.vn.models;

public class DanhMuc {
	String MaDM;
	String TenDM;
	int IsDeleted;
	public String getMaDM() {
		return MaDM;
	}
	public void setMaDM(String maDM) {
		MaDM = maDM;
	}
	public String getTenDM() {
		return TenDM;
	}
	public void setTenDM(String tenDM) {
		TenDM = tenDM;
	}
	public int getIsDeleted() {
		return IsDeleted;
	}
	public void setIsDeleted(int isDeleted) {
		IsDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return this.TenDM;
	}
	public DanhMuc(String maDM, String tenDM, int isDeleted) {
		super();
		MaDM = maDM;
		TenDM = tenDM;
		IsDeleted = isDeleted;
	}
	public DanhMuc() {
		super();
	}
	
	
}
