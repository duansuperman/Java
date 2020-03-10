package learnjava.com.vn.drivers;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import learnjava.com.vn.modules.HangHoa;

public class HangHoaDriver {
	public static  Connection conn = learnjava.com.vn.connection.Connection.getConnection();
	public static Vector<HangHoa> getAllData(){
		Vector<HangHoa> vecHangHoa = null;
		try {
			String strSQL = "Select * from HangHoa";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			ResultSet result = prepare.executeQuery();
			vecHangHoa = new Vector<HangHoa>();
			while(result.next()) {
				vecHangHoa.add(new HangHoa(result.getInt("Ma"), result.getString("TenHangHoa"),
						result.getString("DinhDanh"), result.getInt("SoLuong"), 
						result.getDouble("DonGia")));
				
			}
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return vecHangHoa;
	}
	public static HangHoa getDataById(int ma) {
		HangHoa hh =null;
		try {
			String strSQL="select * from hanghoa where Ma = ?";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setInt(1, ma);
			ResultSet result = prepare.executeQuery();
			if(result.next()) {
				hh = new HangHoa(ma, result.getString("TenHangHoa"), 
						result.getString("DinhDanh"),
						result.getInt("SoLuong"), result.getDouble("DonGia"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return hh;
	}
	public static Boolean deleteHangHoaById(int maHH) {
		try {
			String strSQL="update hanghoa set Active = 0 where Ma = ?";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setInt(1, maHH);
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
