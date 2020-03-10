package loingoaile;

public class LoiThucThi {

	public static void main(String[] args) {
		int h =1/0;
		try {
			int  k =1/0;
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("Bi loi roi nhe");
		
	}

}
