package learnjava.com.driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import learnjava.com.connection.DriverConnection;
import learnjava.com.model.CoQuanBanHanh;
import learnjava.com.model.CongVan;
import learnjava.com.model.NguoiDung;

public class CongVanDriver {
	public static Connection conn = DriverConnection.getConnection();
	public static ArrayList<CongVan> getAllData() {
		ArrayList<CongVan> arrCongVan = null;
		try {
			arrCongVan = new ArrayList<CongVan>();
			String strSQL = "select * from CongVan";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			ResultSet result= prepared.executeQuery();
			while(result.next()) {
				CongVan cv=new CongVan();
				cv.setId(result.getInt("Id"));
				cv.setLoaiCongVanId(result.getInt("loaiCongVanId"));
				cv.setNguoiNhanId(result.getInt("nguoiNhanId"));
				cv.setCoQuanId(result.getInt("coQuanId"));
				cv.setNgayThangVaoSo(result.getDate("ngayThangVaoSo"));
				cv.setSoVanBan(result.getString("soVanBan"));
				cv.setNgayVanBan(result.getDate("ngayVanBan"));
				cv.setGhiChu(result.getString("ghiChu"));
				arrCongVan.add(cv);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return arrCongVan;
	}
	public static CongVan getDataByById(int iD) {
		CongVan cv= null;
		try {
			
			String strSQL = "select * from CongVan where ID = ?";
			PreparedStatement prepared = conn.prepareStatement(strSQL);
			prepared.setInt(1, iD);
			ResultSet result= prepared.executeQuery();
			if(result.next()) {
				cv=new CongVan();
				cv.setId(result.getInt("Id"));
				cv.setLoaiCongVanId(result.getInt("loaiCongVanId"));
				cv.setNguoiNhanId(result.getInt("nguoiNhanId"));
				cv.setCoQuanId(result.getInt("coQuanId"));
				cv.setNgayThangVaoSo(result.getDate("ngayThangVaoSo"));
				cv.setSoVanBan(result.getString("soVanBan"));
				cv.setNgayVanBan(result.getDate("ngayVanBan"));
				cv.setGhiChu(result.getString("ghiChu"));
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return cv;
	}
	public static void deleteDataById(int iD) {
		String strSQL = "delete * from CongVan where ID = ?";
		try {
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setInt(1, iD);
			prepare.executeUpdate();
			JOptionPane.showMessageDialog(null, "Đã xóa công văn có ID = "+iD);
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi khi xóa công văn có ID = "+iD);
			e.printStackTrace();
		}
	}
	public static void updateDataWithId(int iD, String noiDung, int iDCoQuan, int iDNguoiNhan, int iDLoaiCongVan) {
		String strSQL = "update CongVan set CoQuanID = ?, NguoiNhanID = ?, LoaiCongVanID = ?, GhiChu = ? where ID = ?";
		try {
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setInt(1, iDCoQuan);
			prepare.setInt(2, iDNguoiNhan);
			prepare.setInt(3, iDLoaiCongVan);
			prepare.setString(4, noiDung);
			prepare.setInt(5, iD);
			prepare.executeUpdate();
			JOptionPane.showMessageDialog(null, "Cập nhật thành công Công Văn có ID = "+iD);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
