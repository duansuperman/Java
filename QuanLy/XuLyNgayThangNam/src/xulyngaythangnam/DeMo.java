package xulyngaythangnam;


import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DeMo {

	public static void main(String[] args) {

		//Khai báo Calendar
		Calendar cal =  Calendar.getInstance();
		
		//Lấy ngày 
		int ngay = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("Ngay hien tai "+ ngay);
		
		//Lấy tháng
		int thang = cal.get(Calendar.MONTH);
		System.out.println("Thang hien tai "+thang);
		
		//Lấy năm 
		int nam = cal.get(Calendar.YEAR);
		System.out.println("Nam hien tai "+nam);
		
		//Lấy ngày tháng năm khi chua format theo dd/MM/yyyy
		java.util.Date d = cal.getTime();
		System.out.println("Chua format "+d);
		
		//format theo SimpleDateFormat 
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println("Ngaythang sau khi format "+ sdf.format(d));
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("d/M/yyyy");
		System.out.println("Ngaythang sau khi format "+ sdf1.format(d));
		
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Ngaythang sau khi format "+ sdf2.format(d));
	}

}
