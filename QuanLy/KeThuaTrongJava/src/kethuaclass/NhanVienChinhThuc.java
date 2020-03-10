package kethuaclass;

public class NhanVienChinhThuc extends Nguoi {


	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " La nhan vien chinh thuc";
	}
	public void xuatTen() {
		System.out.println("Ten cua nhan vien la : "+super.getTen());
	}
	@Override
	public void inLuong() {
		System.out.println("Luong "+getLuong());
		
	}

}
