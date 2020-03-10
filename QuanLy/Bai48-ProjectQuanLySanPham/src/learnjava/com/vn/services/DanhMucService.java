package learnjava.com.vn.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import learnjava.com.vn.connection.Connect;
import learnjava.com.vn.models.DanhMuc;

public class DanhMucService {
	public static Connection conn = Connect.getConnect("ADMIN", "dbQuanLySanPham");
	public static Vector<DanhMuc> getAllData(){
		Vector<DanhMuc> listDM = null;
		try {
			String strSQL = "select * from DanhMuc where IsDeleted = 0";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			ResultSet result =  prepare.executeQuery();
			listDM = new Vector<DanhMuc>();
			while(result.next()) {
				DanhMuc dm = new DanhMuc(result.getString("MaDM"), result.getString("TenDM"),
						result.getInt("IsDeleted"));
				listDM.add(dm);
			}
			return listDM;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listDM;
	}
	public static DanhMuc getDataById(String maDM){
		DanhMuc dm = null;
		try {
			String strSQL = "select * from DanhMuc where MaDM = ? and IsDeleted = 0";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setString(1, maDM);
			ResultSet result =  prepare.executeQuery();
			if(result.next()) {
				dm = new DanhMuc(result.getString("MaDM"), result.getString("TenDM"),
						result.getInt("IsDeleted"));
			}
			return dm;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return dm;
	}
	
}
