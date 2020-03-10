package demo;

import java.awt.BorderLayout;
import java.awt.Container;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MyWindow extends JFrame{

	public MyWindow(String title) {
		super(title);
		addControls();
		hienThiThongTinSinhVien();
		showWindow();
	}
	DefaultTableModel dtm;
	JTable tbSinhVien;
	Connection conn;
	public void addControls() {
		dtm=new DefaultTableModel();
		dtm.addColumn("Họ tên");
		dtm.addColumn("Địa chỉ");
		dtm.addColumn("Tuổi");
		tbSinhVien = new JTable(dtm);
		JScrollPane sc = new JScrollPane(tbSinhVien,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		Container ct =getContentPane();
		ct.setLayout(new BorderLayout());
		ct.add(sc);
	}
	public void addEvents() {
		
	}
	public void hienThiThongTinSinhVien() {
		try {
			String dbPath = ".\\dbSinhVien.accdb";
			String strConn = "jdbc:ucanaccess://"+dbPath ;
			conn = DriverManager.getConnection(strConn); //mở kết nối db access
			if(conn!=null) {
				Statement statement= conn.createStatement();
				ResultSet result = statement.executeQuery("Select * from SinhVien");
				dtm.setRowCount(0);
				while(result.next()) {
					String hoTen = result.getString("HoTen");
					String diaChi = result.getString("DiaChi");
					String tuoi = result.getString("Tuoi");
					Object []arr = {hoTen,diaChi,tuoi};
					
					dtm.addRow(arr);
				}
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void showWindow() {
		this.setSize(500,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
