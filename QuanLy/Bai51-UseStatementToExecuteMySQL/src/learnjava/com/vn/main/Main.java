package learnjava.com.vn.main;

import java.text.Normalizer;
import java.util.regex.Pattern;

import learnjava.com.vn.connection.Connection;

public class Main {
	public static String deAccent(String str) {
	    String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD); 
	    Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	    return pattern.matcher(nfdNormalizedString).replaceAll("");
	}
	public static void main(String[] args) {
		if(Connection.getConnection()!=null) {
			System.out.println("Success");
		}
		else {
			System.out.println("fail");
		}
		
		System.out.println(deAccent("Anh y�u em"));
	}
	
	
}
