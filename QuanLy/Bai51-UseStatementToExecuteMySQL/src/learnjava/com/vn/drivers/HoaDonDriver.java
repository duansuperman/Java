package learnjava.com.vn.drivers;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import learnjava.com.vn.modules.HangHoa;
import learnjava.com.vn.modules.HoaDon;

public class HoaDonDriver {
	public static  Connection conn = learnjava.com.vn.connection.Connection.getConnection();
	public static Vector<HoaDon> getAllData(){
		Vector<HoaDon> vecHoaDon = null;
		try {
			String strSQL = "Select * from hoadon";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			ResultSet result = prepare.executeQuery();
			vecHoaDon = new Vector<HoaDon>();
			while(result.next()) {
				vecHoaDon.add(new HoaDon(result.getInt("MaHD"), result.getDouble("TongTien")));
				
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return vecHoaDon;
	}
	public static HoaDon getDataById(int maHD) {
		HoaDon hd =null;
		try {
			String strSQL="select * from hoadon where MaHD = ?";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setInt(1, maHD);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				hd = new HoaDon(result.getInt("MaHD"), result.getDouble("TongTien"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return hd;
	}
	public static Boolean deleteHoaDonById(int maHD) {
		try {
			String strSQL="update hoadon set Active = 0 where MaHD = ?";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setInt(1, maHD);
			int x = prepare.executeUpdate();
			if(x>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
