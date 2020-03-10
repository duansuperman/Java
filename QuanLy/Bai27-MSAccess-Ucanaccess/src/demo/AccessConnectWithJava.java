package demo;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class AccessConnectWithJava {
	public static void main(String[] args) {
		try {
			
			String databasePath = "C:\\Users\\Admin\\Desktop\\Java\\quanlykhachhang.accdb";
			String strConnect = "jdbc:ucanaccess//"+databasePath;
			Connection con = DriverManager.getConnection(strConnect);
			if(con!=null) {
				JOptionPane.showMessageDialog(null, "Thành công");
			}
			else {
				JOptionPane.showMessageDialog(null, "Thất bại");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

}
