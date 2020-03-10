package xulychuoi;

public class DeMo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String t1="abc";
		String t2="aba";
		//Ham compare so sanh 2 chuoi 
		int k  = t1.compareTo(t2);
		System.out.println(k);
		
		//Mo so thao tac xu ly chuoi
		String hoten = " Nguyen    Van   A";
		
		//Chieu dai cua chuoi
		System.out.println("Chieu dai cua chuoi "+hoten.length());
		
		//Lay phan tu thu 1
		char []arr = hoten.toCharArray();
		System.out.println("Phan tu thu 1 trong chuoi "+arr[1]);
		
		//Lay chuoi con tu hoten tu vi tri thu 1 den 6
		String subHoTen = hoten.substring(1,7);
		System.out.println("Chuoi co can lay la "+subHoTen);
		
		//Tim vi tri ky tu n trong chuoi ho ten
		int vitri = hoten.indexOf("n");
		System.out.println("Vi tri chuoi tim duoc ky tu n :"+vitri);
		
		//Format chuoi theo dinh dang
		hoten=hoten.trim();
		String []arrHoTen = hoten.split(" ");
		System.out.println("So luong phan tu trong mang arrHoTen :"+arrHoTen.length);
		System.out.print("Ho ten sau khi format :");
		for(String tu:arrHoTen) {
			if(tu.trim().length()!=0) {
				System.out.print(tu+" ");
			}
			
		}
		System.out.println();
	}

}
