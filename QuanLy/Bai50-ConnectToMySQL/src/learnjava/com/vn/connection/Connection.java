package learnjava.com.vn.connection;

import java.util.Properties;

import com.mysql.jdbc.Driver;

public class Connection {
	public static java.sql.Connection getConnect(){
		
		try {
			String strServer = "jdbc:mysql://localhost/dbSinhVien";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			return driver.connect(strServer, pro);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
