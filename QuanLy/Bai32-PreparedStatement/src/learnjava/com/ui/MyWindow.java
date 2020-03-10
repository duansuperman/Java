package learnjava.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MyWindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyWindow(String title) {
		super(title);
		addControls();
		showWindow();
		hienThiPhongBan();
		addEvents();
	}
	JComboBox<String> cbPhongBan;
	JList<String> lstNhanVien;
	Connection conn ;
	PreparedStatement preparedStatement ;
	private void hienThiPhongBan() {
		String filePath = ".\\db\\dbNhanVien.accdb";
		String strCon = "jdbc:ucanaccess://"+filePath;
		try {
			conn = DriverManager.getConnection(strCon);
			if(conn!=null) {
				String strSQL = "select * from PhongBan";
				preparedStatement = conn.prepareStatement(strSQL);
				ResultSet result = preparedStatement.executeQuery();
				while(result.next()) {
					cbPhongBan.addItem(result.getString("Ma")+"-"+result.getString("Ten"));
				}
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void addControls() {
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel pnPhongBan = new JPanel();
		pnPhongBan.setLayout(new FlowLayout());
		JLabel lblPhongBan = new JLabel("Danh sách phòng ban");
		cbPhongBan = new JComboBox<String>();
		pnPhongBan.add(lblPhongBan);
		pnPhongBan.add(cbPhongBan);
		
		JPanel pnNhanVien  = new JPanel();
		pnNhanVien.setLayout(new BorderLayout());
		lstNhanVien = new JList<String>();
		JScrollPane sc = new JScrollPane(lstNhanVien,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnNhanVien.add(sc);
		
		ct.add(pnPhongBan, BorderLayout.NORTH);
		ct.add(pnNhanVien);
	}
	public void addEvents() {
		cbPhongBan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cbPhongBan.getSelectedIndex()==-1) return;
				String maPB = cbPhongBan.getSelectedItem().toString().split("-")[0];
				hienThiNhanVien(maPB);
			}
		});
	}
	protected void hienThiNhanVien(String maPB) {
		if(conn==null)return ;
		String strSQL = "select * from NhanVien where MaPhong = ?";
		try {
			preparedStatement = conn.prepareStatement(strSQL);
			preparedStatement.setString(1, maPB);
			ResultSet result = preparedStatement.executeQuery();
			Vector<String> vtNhanVien = new Vector<String>();
			while(result.next()) {
				vtNhanVien.add(result.getString("Ma")+"-"+result.getString("Ten"));
			}
			lstNhanVien.setListData(vtNhanVien);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void showWindow() {
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
