package learnjava.com.vn.test;

import java.sql.Connection;

public class TestMain {
	public static void main(String[] args) {
		Connection conn = learnjava.com.vn.connection.Connection.getConnect();
		if(conn!=null) {
			System.out.println("Connect success");
		}
		else {
			System.out.println("Connect not success");
		}
	}
}
