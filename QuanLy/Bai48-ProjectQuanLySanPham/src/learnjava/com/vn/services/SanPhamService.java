package learnjava.com.vn.services;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import learnjava.com.vn.connection.Connect;
import learnjava.com.vn.models.SanPham;

public class SanPhamService {
	public static Connection conn = Connect.getConnect("ADMIN", "dbQuanLySanPham");
	public static ArrayList<SanPham> getAllData(){
		ArrayList<SanPham> listSP=  null;
		try {
			String strSQL = "select  * from SanPham where IsDeleted = 0";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			ResultSet result =  prepare.executeQuery();
			listSP = new ArrayList<SanPham>();
			while(result.next()) {
				SanPham sp = new SanPham(result.getString("MaSp"), result.getString("TenSP")
						, result.getInt("SoLuong"), result.getInt("DonGia"),
						result.getString("MADM"), result.getInt("IsDeleted"));
				listSP.add(sp);
			}
			return listSP;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return listSP;
	}
	public static SanPham getDataById(String maSP){
		SanPham sp = null;
		try {
			String strSQL = "select  * from SanPham where MaSP = ? and IsDeleted = 0";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setString(1, maSP);
			ResultSet result =  prepare.executeQuery();
			
			if(result.next()) {
				sp = new SanPham(result.getString("MaSp"), result.getString("TenSP")
						, result.getInt("SoLuong"), result.getInt("DonGia"),
						result.getString("MADM"), result.getInt("IsDeleted"));
				
			}
			return sp;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return sp;
	}
	public static String createMaSP() {
		String maSP = "sp";
		int index = 0;
		while(true) {
			if(getDataById(maSP+index) ==null) {
				return maSP+index;
				
			}
			index++;
		}
		
	}
	public static void insertSanPham(String tenSP, int soLuong, int donGia, String maDM) {
		try {
			String strSQL = "insert into SanPham values(?,?,?,?,?,?)";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setString(1, createMaSP());
			prepare.setString(2, tenSP);
			prepare.setInt(3, soLuong);
			prepare.setInt(4, donGia);
			prepare.setString(5, maDM);
			prepare.setInt(6, 0);
			int x = prepare.executeUpdate();
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Thêm thành công !");
			}
			else {
				JOptionPane.showMessageDialog(null, "Thêm thất bại !");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void deleteSanPham(String maSP) {
		try {
			String strSQL = "update SanPham set IsDeleted = 1 where MaSP = ?";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setString(1, maSP);
			
			int x = prepare.executeUpdate();
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Xóa thành công !");
			}
			else {
				JOptionPane.showMessageDialog(null, "Xóa thất bại !");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public static void updateSanPham(String maSP,String tenSP, int soLuong, int donGia, String maDM) {
		try {
			String strSQL = "update SanPham set  TenSP = ?, SoLuong = ?, DonGia = ?, MaDM = ? where MaSP = ? ";
			PreparedStatement prepare = conn.prepareStatement(strSQL);
			prepare.setString(1, tenSP);
			prepare.setInt(2, soLuong);
			prepare.setInt(3, donGia);
			prepare.setString(4, maDM);
			prepare.setString(5, maSP);
	
			int x = prepare.executeUpdate();
			if(x>0) {
				JOptionPane.showMessageDialog(null, "Cập nhật thành công !");
			}
			else {
				JOptionPane.showMessageDialog(null, "Cập nhật thất bại !");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
