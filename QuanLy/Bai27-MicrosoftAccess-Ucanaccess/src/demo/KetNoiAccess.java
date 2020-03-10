package demo;




import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class KetNoiAccess {

	public static void main(String[] args) {
		String databasePath = "C:\\Users\\Admin\\Desktop\\Java";
		String strConnection = "jdbc:ucanaccess//"+databasePath;
		Connection con = DriverManager.getConnection(strConnection);
		if(con!=null) {
			JOptionPane.showMessageDialog(null, "Thành công");
		}
		else {
			JOptionPane.showMessageDialog(null, "Thất bại");
		}
	}

}
