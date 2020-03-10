package learnjava.com.driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import learnjava.com.connection.DriverConnection;
import learnjava.com.model.NguoiDung;

public class NguoiDungDriver {
	public static Connection conn = DriverConnection.getConnection();
	public static ArrayList<NguoiDung> getAllData() {
		ArrayList<NguoiDung> arrNguoiDung = null;
		try {
			arrNguoiDung = new ArrayList<NguoiDung>();
			String strSQL = "select * from NguoiDung";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			ResultSet result= prepared.executeQuery();
			while(result.next()) {
				NguoiDung nd = new NguoiDung(result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4));
				arrNguoiDung.add(nd);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return arrNguoiDung;
	}
	public static NguoiDung getDataById(int id) {
		NguoiDung nd  = null;
		try {
			String strSQL = "select * from NguoiDung where ID = ?";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			prepared.setInt(1, id);
			ResultSet result= prepared.executeQuery();
			if(result.next()) {
				nd = new NguoiDung(result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4));
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return nd;
	}
	public static NguoiDung getDataByUserNamePassword(String userName, String password) {
		NguoiDung nd  = null;
		try {
			String strSQL = "select * from NguoiDung where UserName = ? and password = ?";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			prepared.setString(1, userName);
			prepared.setString(2, password);
			ResultSet result= prepared.executeQuery();
			while(result.next()) {
				nd = new NguoiDung(result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return nd;
	}
	public static boolean checkExitsDataById(int id) {
		return getDataById(id) != null;
	}
	public static boolean login(String userName, String password) {
		
		return getDataByUserNamePassword(userName, password)!=null;
	}
	public static NguoiDung getDataByHoTen(String hoTen) {
		NguoiDung nd  = null;
		try {
			String strSQL = "select * from NguoiDung where HoTen = ?";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			prepared.setString(1, hoTen);
			ResultSet result= prepared.executeQuery();
			if(result.next()) {
				nd = new NguoiDung(result.getInt(1),
						result.getString(2),
						result.getString(3),
						result.getString(4));
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return nd;
	}
}
