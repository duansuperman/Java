package learnjava.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

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
	Connection conn;
	PreparedStatement preparedStatement;

	JTextField txtHoTen;
	JTextField txtDiaChi;
	JButton btnAdd;
	String maPB;
	JButton btnXoaNhanVien, btnXoaPhongBan;
	String maNV ;
	private void hienThiPhongBan() {
		String filePath = ".\\db\\dbNhanVien.accdb";
		String strCon = "jdbc:ucanaccess://" + filePath;
		cbPhongBan.removeAllItems();
		try {
			conn = DriverManager.getConnection(strCon);
			if (conn != null) {
				String strSQL = "select * from PhongBan";
				preparedStatement = conn.prepareStatement(strSQL);
				ResultSet result = preparedStatement.executeQuery();
				while (result.next()) {
					cbPhongBan.addItem(result.getString("Ma") + "-" + result.getString("Ten"));
				}
			}
		} catch (Exception e) {
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
		btnXoaPhongBan =new JButton("Xóa phòng ban");
		pnPhongBan.add(lblPhongBan);
		pnPhongBan.add(cbPhongBan);
		pnPhongBan.add(btnXoaPhongBan);

		JPanel pnNhanVien = new JPanel();
		pnNhanVien.setLayout(new BorderLayout());
		lstNhanVien = new JList<String>();
		JScrollPane sc = new JScrollPane(lstNhanVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnNhanVien.add(sc);

		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));

		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		JLabel lblHoTen = new JLabel("Họ tên");
		txtHoTen = new JTextField(20);
		pnHoTen.add(lblHoTen);
		pnHoTen.add(txtHoTen);
		pnChiTiet.add(pnHoTen);

		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout());
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		txtDiaChi = new JTextField(20);
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		pnChiTiet.add(pnDiaChi);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnAdd = new JButton("Thêm");
		btnXoaNhanVien = new JButton("Xóa nhân viên");
		pnButton.add(btnAdd);
		pnButton.add(btnXoaNhanVien);
		pnChiTiet.add(pnButton);

		ct.add(pnPhongBan, BorderLayout.NORTH);
		ct.add(pnNhanVien);
		ct.add(pnChiTiet, BorderLayout.SOUTH);
	}

	public void addEvents() {
		cbPhongBan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cbPhongBan.getSelectedIndex() == -1)
					return;
				maPB = cbPhongBan.getSelectedItem().toString().split("-")[0];
				hienThiNhanVien();
			}
		});
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				themDuLieu();
			}
		});
		lstNhanVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				txtHoTen.setText(lstNhanVien.getSelectedValue().split("-")[1]);
				txtDiaChi.setText(lstNhanVien.getSelectedValue().split("-")[2]);
				maNV = lstNhanVien.getSelectedValue().split("-")[0];
			}
		});
		btnXoaNhanVien.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyXoaNhanVien();
				
			}
		});
		btnXoaPhongBan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int x = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa "+cbPhongBan.getSelectedItem().toString().split("-")[1],
						"Thông báo xóa", JOptionPane.YES_NO_OPTION);
				if(x==JOptionPane.YES_OPTION) {
					xyLyXoaPhongBan();
				}
			}
		});
	}

	protected void xyLyXoaPhongBan() {
		
		String strSQL = "delete from PhongBan where  Ma = ?";
		try {
			if(conn==null) return;
			preparedStatement = conn.prepareStatement(strSQL);
			preparedStatement.setString(1, maPB);
			int x = preparedStatement.executeUpdate();
			if(x>0) {
				hienThiPhongBan();
			}
			else {
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void xuLyXoaNhanVien() {
		String strSQL = "delete from NhanVien where  Ma = ?";
		try {
			if(conn==null) return;
			preparedStatement = conn.prepareStatement(strSQL);
			preparedStatement.setString(1, maNV);
			int x = preparedStatement.executeUpdate();
			if(x>0) {
				hienThiNhanVien();
			}
			else {
				JOptionPane.showMessageDialog(null, "Xóa không thành công");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void themDuLieu() {
		
		String strSQL = "insert into NhanVien values(?,?,?,?)";
		String maNV = taoMaMoiNhanVien();
		try {
			preparedStatement = conn.prepareStatement(strSQL);
			
			preparedStatement.setString(1, maNV);
			preparedStatement.setString(2, txtHoTen.getText());
			preparedStatement.setString(3, txtDiaChi.getText());
			preparedStatement.setString(4, maPB);
			int x = preparedStatement.executeUpdate();
			if (x > 0) {
				hienThiNhanVien();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void hienThiNhanVien() {
		if (conn == null)
			return;
		String strSQL = "select * from NhanVien where MaPhong = ?";
		try {
			preparedStatement = conn.prepareStatement(strSQL);
			preparedStatement.setString(1, maPB);
			ResultSet result = preparedStatement.executeQuery();
			Vector<String> vtNhanVien = new Vector<String>();
			while (result.next()) {
				vtNhanVien.add(result.getString("Ma") + "-" 
			+ result.getString("Ten")+"-"+result.getString("DiaChi"));
			}
			lstNhanVien.setListData(vtNhanVien);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String taoMaMoiNhanVien() {
		String strSQL = "select * from NhanVien where Ma = ?";
		try {
			int i = 0;
			while(i>=0) {
				preparedStatement = conn.prepareStatement(strSQL);
				preparedStatement.setString(1, "nv"+i);
				ResultSet result = preparedStatement.executeQuery();
				if(result.next()==false) {
					return "nv"+i;
				}
				i++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public void showWindow() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
