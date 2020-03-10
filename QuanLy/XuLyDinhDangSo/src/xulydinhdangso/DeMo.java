package xulydinhdangso;

import java.text.DecimalFormat;

public class DeMo {

	public static void main(String[] args) {

		double toan = 10;
		double ly = 3;
		double hoa=7;
		double dtb = (toan+ly+hoa)/3;
		//DTB khi chua format
		System.out.println("DTB khi chua dinh dang "+dtb);
		
		//Format DTB
		DecimalFormat dcf = new DecimalFormat("#.##");
		System.out.println("DTB sau khi format "+dcf.format(dtb));
	}

}
