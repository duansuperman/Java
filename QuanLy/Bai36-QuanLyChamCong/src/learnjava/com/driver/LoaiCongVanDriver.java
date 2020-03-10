package learnjava.com.driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import learnjava.com.connection.DriverConnection;
import learnjava.com.model.LoaiCongVan;

public class LoaiCongVanDriver {

	public static Connection conn = DriverConnection.getConnection();
	public static ArrayList<LoaiCongVan> getAllData() {
		ArrayList<LoaiCongVan> arrLoaiCongVan = null;
		try {
			arrLoaiCongVan = new ArrayList<LoaiCongVan>();
			String strSQL = "select * from LoaiCongVan";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			ResultSet result= prepared.executeQuery();
			while(result.next()) {
				LoaiCongVan lcv = new LoaiCongVan(result.getInt("ID"),
						result.getString("MaLoaiCongVan"),
						result.getString("TenCongVan"));
				arrLoaiCongVan.add(lcv);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return arrLoaiCongVan;
	}
	public static LoaiCongVan getDataById(int id) {
		LoaiCongVan lcv = null;
		try {
		
			String strSQL = "select * from LoaiCongVan where ID = ?";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			prepared.setInt(1, id);
			ResultSet result= prepared.executeQuery();
			if(result.next()) {
				lcv = new LoaiCongVan(result.getInt("ID"),
						result.getString("MaLoaiCongVan"),
						result.getString("TenCongVan"));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lcv;
	}
	public static LoaiCongVan getDataByTenCongVan(String tenCongVan) {
		LoaiCongVan lcv = null;
		try {
		
			String strSQL = "select * from LoaiCongVan where TenCongVan = ?";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			prepared.setString(1, tenCongVan);
			ResultSet result= prepared.executeQuery();
			if(result.next()) {
				lcv = new LoaiCongVan(result.getInt("ID"),
						result.getString("MaLoaiCongVan"),
						result.getString("TenCongVan"));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return lcv;
	}
}
