package loingoaile;

public class LoiLogic {

	public static void main(String[] args) {
		/* Loi xuat hien khi khong dap ung duoc nhu cau khach hang */
		int toan = 1;
		int ly= 10;
		int van = 12;
		double dtb = (toan+ly+van)*1.0/3;
		System.out.println((double)Math.round(dtb*10)/10);
	}

}
