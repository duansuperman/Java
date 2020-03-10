package demo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class MyWindow extends JFrame{

	public MyWindow(String title) {
		super(title);
		addControls();
		hienThiThongTinSinhVien();
		addEvents();
		showWindow();
	}
	DefaultTableModel dtm;
	JTable tbSinhVien;
	Connection conn;
	JTextField txtHoTen,txtDiaChi,txtTuoi;
	JButton btnSave ;
	public void addControls() {
		dtm=new DefaultTableModel();
		dtm.addColumn("Họ tên");
		dtm.addColumn("Địa chỉ");
		dtm.addColumn("Tuổi");
		tbSinhVien = new JTable(dtm);
		JScrollPane sc = new JScrollPane(tbSinhVien,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		Container ct =getContentPane();
		ct.setLayout(new BorderLayout());
		JPanel pnChiTiet = new JPanel();
		
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		JLabel lbHoTen = new JLabel("Họ Tên");
		txtHoTen = new JTextField(20);
		pnHoTen.add(lbHoTen);
		pnHoTen.add(txtHoTen);
		pnChiTiet.add(pnHoTen);
		
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout());
		JLabel lbDiaChi = new JLabel("Địa chỉ");
		txtDiaChi = new JTextField(20);
		pnDiaChi.add(lbDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnChiTiet.add(pnDiaChi);
		
		JPanel pnTuoi = new JPanel();
		pnTuoi.setLayout(new FlowLayout());
		JLabel lbTuoi = new JLabel("Tuổi");
		txtTuoi = new JTextField(20);
		pnTuoi.add(lbTuoi);
		pnTuoi.add(txtTuoi);
		pnChiTiet.add(pnTuoi);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnSave = new JButton("Lưu");
		pnButton.add(btnSave);
		pnChiTiet.add(btnSave);
		
		lbHoTen.setPreferredSize(lbDiaChi.getPreferredSize());
		lbTuoi.setPreferredSize(lbDiaChi.getPreferredSize());
		
		ct.add(sc);
		ct.add(pnChiTiet,BorderLayout.SOUTH);
	}
	public void addEvents() {
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyLuuDuLieu();
				
			}
		});
	}
	protected void xuLyLuuDuLieu() {
		if(conn==null) return ;
		try {
			Statement statement = conn.createStatement();
			String strSQL= "insert into SinhVien values('"+txtHoTen.getText()+"','"+txtDiaChi.getText()+"',"+txtTuoi.getText()+")";
			int k = statement.executeUpdate(strSQL);
			if(k>0) {
				JOptionPane.showMessageDialog(null, "Lưu thành công");
				hienThiThongTinSinhVien();
			}
			else {
				JOptionPane.showMessageDialog(null, "Lư thất bại");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void hienThiThongTinSinhVien() {
		try {
			String dbPath = "C:\\Users\\Admin\\Desktop\\Java\\dbSinhVien.accdb";
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
