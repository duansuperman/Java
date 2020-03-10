package XuLyChuoi;

public class StringBuilder {

	public static void main(String[] args) {
		//StringBuilder dung de noi chuoi

		java.lang.StringBuilder str = new java.lang.StringBuilder();
		for(int i=0;i<3;i++) {
			str.append("Phan tu thu "+i);
			str.append("\n");
		}
		System.out.println(str);
	}

}
