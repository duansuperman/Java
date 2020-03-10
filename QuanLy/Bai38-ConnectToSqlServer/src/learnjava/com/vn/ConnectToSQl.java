package learnjava.com.vn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToSQl {
	public static Connection getConnect(String strServer,String strDatabase)
	{
		Connection conn=null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionUrl=
					"jdbc:sqlserver://"+strServer+":1433;databaseName="+strDatabase+";integratedSecurity=true;";
			conn= DriverManager.getConnection(connectionUrl);
		} catch (SQLException e) {
			System.out.println("SQL Exception: "+ e.toString());
		} catch (ClassNotFoundException cE) {
			System.out.println("Class Not Found Exception: "+ cE.toString());
		}
		return conn;
	}


	public static void main(String[] args) {
		Connection conn = getConnect("ADMIN", "QLBD");
		if(conn!=null) {
			System.out.println("Kết nối thành công !");
		}
		else {
			System.out.println("Kết nối không thành công");
		}

	}

}
