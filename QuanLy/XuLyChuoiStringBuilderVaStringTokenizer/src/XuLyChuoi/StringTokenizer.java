package XuLyChuoi;

public class StringTokenizer {

	public static void main(String[] args) {
		//Tao 1 string s
		String s = "hoc hoc , hoc nua, hoc mai,......hoc miet luon";
		
		//StringTokenizer dung de cat chuoi
		//Mac dinh cat theo khoang trang
		java.util.StringTokenizer token = new java.util.StringTokenizer(s);
		System.out.println("Duyet danh sach sau khi cat");
		while(token.hasMoreTokens()) {
			System.out.println(token.nextToken());
		}
		//Cat theo y muon
		java.util.StringTokenizer token1 = new java.util.StringTokenizer(s," , ");
		System.out.println("Duyet danh sach sau khi cat");
		System.out.println(token1.countTokens());
		while(token1.hasMoreTokens()) {
			System.out.println(token1.nextToken());
		}
	}

}
