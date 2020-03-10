package learnjava.com.vn.connection;

import java.util.Properties;

import com.mysql.jdbc.Driver;

public class Connection {
	public static java.sql.Connection getConnection() {
		try {
			String strCon= "jdbc:mysql://localhost/dbquanlybanhangtaphoa";
			Properties pro = new Properties();
			pro.put("user", "root");
			pro.put("password", "");
			Driver driver = new Driver();
			return driver.connect(strCon,pro);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
