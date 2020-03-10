package thuvienmath;

public class DeMo {

	public static void main(String[] args) {

		int a = 5;
		int b=10;
		//Ham pow
		System.out.println(a+"^"+b+"="+Math.pow(a, b));
		
		//double hay int deu dung chung ham abs
		int c=-125;
		System.out.println("Gia tri tuyet doi cua c "+Math.abs(c));
		
		//Tim min & max
		System.out.println("Min a&b "+Math.min(a, b));
		System.out.println("Max a&b "+Math.max(a, b));
		//Tinh dien tich & cv hinh tron
		int r= 5;
		System.out.println("S = "+Math.PI*Math.pow(r,2));
		System.out.println("CV = "+2*Math.PI*r);
		
		//Tinh sin cos tan cot
		int goc=30;
		double rad = goc*Math.PI/180;
		System.out.println("Sin(a) = "+Math.sin(rad));
		
		
		
	}

}
