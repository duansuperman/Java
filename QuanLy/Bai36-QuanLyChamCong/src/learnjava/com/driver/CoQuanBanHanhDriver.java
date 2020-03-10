package learnjava.com.driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import learnjava.com.connection.DriverConnection;
import learnjava.com.model.CoQuanBanHanh;

public class CoQuanBanHanhDriver {
	public static Connection conn = DriverConnection.getConnection();
	public static ArrayList<CoQuanBanHanh> getAllData() {
		ArrayList<CoQuanBanHanh> arrCoQuanBanHanh = null;
		try {
			arrCoQuanBanHanh = new ArrayList<CoQuanBanHanh>();
			String strSQL = "select * from CoQuanBanHanh";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			ResultSet result= prepared.executeQuery();
			while(result.next()) {
				CoQuanBanHanh cq = new CoQuanBanHanh(result.getInt("ID"),
						result.getString("MaCoQuan"),
						result.getString("TenCoQuan"));
				arrCoQuanBanHanh.add(cq);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return arrCoQuanBanHanh;
	}
	public static CoQuanBanHanh getDataById(int id) {
		CoQuanBanHanh cq = null;
		try {
			
			String strSQL = "select * from CoQuanBanHanh where ID = ?";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			prepared.setInt(1, id);
			ResultSet result= prepared.executeQuery();
			if(result.next()) {
				cq = new CoQuanBanHanh(result.getInt("ID"),
						result.getString("MaCoQuan"),
						result.getString("TenCoQuan"));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cq;
	}
	public static CoQuanBanHanh getDataByTenCoQuan(String tenCoQuan) {
		CoQuanBanHanh cq = null;
		try {
			
			String strSQL = "select * from CoQuanBanHanh where TenCoQuan = ?";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			prepared.setString(1, tenCoQuan);
			ResultSet result= prepared.executeQuery();
			if(result.next()) {
				cq = new CoQuanBanHanh(result.getInt("ID"),
						result.getString("MaCoQuan"),
						result.getString("TenCoQuan"));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cq;
	}
}
