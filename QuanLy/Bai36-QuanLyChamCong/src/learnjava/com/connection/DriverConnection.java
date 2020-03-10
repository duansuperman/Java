package learnjava.com.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public  class DriverConnection {
	public static Connection getConnection() {
		String filePath = ".\\db\\QuanLyChamCong.accdb";
		String strCon = "jdbc:ucanaccess://"+filePath;
		try {
			return DriverManager.getConnection(strCon);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
