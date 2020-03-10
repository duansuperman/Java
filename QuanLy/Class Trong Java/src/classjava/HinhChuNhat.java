package classjava;

public class HinhChuNhat {
	private double dai, rong;

	//Bien static la kieu du lieu khi co update o 1 doi tuong nao thi se lay doi tuong do
	public static int x=5;
	
	//Set value of x
	public void setX(int x) {
		this.x=x;
	}
	
	public double getDai() {
		return dai;
	}

	public void setDai(double dai) {
		this.dai = dai;
	}

	public double getRong() {
		return rong;
	}

	public void setRong(double rong) {
		this.rong = rong;
	}

	public HinhChuNhat() {
		super();
	}

	public HinhChuNhat(double dai, double rong) {
		super();
		this.dai = dai;
		this.rong = rong;
		
	}
	
	//service method dung de cac doi tuong ben ngoai tro den 
	public double tinhDienTich() {
		return dai*rong;
	}
	public double tinhChuVi() {
		return (dai+rong)*2;
	}
	//support method la method ho tro cho service method. Luon o che do private
	private boolean kiemTraHCN() {
		return dai>rong;
	}
	
	@Override
	public String toString() {
		if(kiemTraHCN()) {
			return "La HinhChuNhat [dai=" + dai + ", rong=" + rong + "]";
		}
		return "Khong la HinhChuNhat";
	}
	
	//Nap chong ham
	public void fn1() {
		System.out.println("HCN da duoc goi khong doi so");
	}
	public void fn1(int a) {
		System.out.println("HCN da duoc goi voi 1 doi so");
	}
	
	//Operator
	public double tinhTong2HCN(HinhChuNhat hcn) {
		return tinhChuVi()+hcn.tinhChuVi();
	}
	
	//Java doesn't support operator overloading
	

}
