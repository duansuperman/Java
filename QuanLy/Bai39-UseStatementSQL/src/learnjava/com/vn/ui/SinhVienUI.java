package learnjava.com.vn.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Position;

import learnjava.com.vn.connection.Connect;
import learnjava.com.vn.models.Khoa;

public class SinhVienUI extends JFrame {
	public SinhVienUI(String title) {
		super(title);
		addControl();
		hienThiThongTin();
		addEvents();
		hienThiComboBox();
		
		showWindow();
		
	}

	

	DefaultTableModel dtm;
	JTable tblSinhVien;
	JButton btnLast, btnFirst, btnNext, btnPrevious;
	JTextArea txtNoiDung;
	Connection conn = Connect.getConnect("ADMIN", "dbSinhVien");
	ResultSet result;
	int position = 0;
	Statement state;
	JTextField txtHoTen,txtNgaySinh;
	JComboBox<Khoa> cbKhoa;
	Vector<Khoa> vt = new Vector<Khoa>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	JButton btnThem, btnSua, btnXoa;
	JLabel lblMaSV;
	private void hienThiComboBox() {
		try {
			String strSQL = "select * from KHOA";
			state = conn.createStatement();
			ResultSet listKhoa = state.executeQuery(strSQL);
			
			while(listKhoa.next()) {
				Khoa kh = new Khoa();
				kh.setMaKhoa(listKhoa.getString(1));
				kh.setTenKhoa(listKhoa.getString(2));
				cbKhoa.addItem(kh);
				vt.add(kh);
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public String layTenKhoa(String maKhoa) {
		try {
			String strKhoa = "select * from KHOA where MAKHOA = '"+maKhoa+"'";
			state = conn.createStatement();
			ResultSet ketQua = state.executeQuery(strKhoa);
			
			if(ketQua.next()) {
				return ketQua.getString(2);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	public void hienThiThongTin() {
		dtm.setRowCount(0);
		try {
			
			String strSQL = "select * from SINHVIEN ";
			state = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			result = state.executeQuery(strSQL);
			
			
			
			while (result.next()) {
				Vector<Object> vt = new Vector<Object>();
				vt.add(result.getString(1));
				vt.add(result.getString(2));
				vt.add(sdf.format(result.getDate(3)));
				vt.add(layTenKhoa(result.getString("MAKHOA")));
				dtm.addRow(vt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addControl() {
		Container ct = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());

		dtm = new DefaultTableModel();
		dtm.addColumn("MSSV");
		dtm.addColumn("Tên sinh viên");
		dtm.addColumn("Ngày sinh");
		dtm.addColumn("Khoa");
		tblSinhVien = new JTable(dtm);
		JScrollPane sp = new JScrollPane(tblSinhVien, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnNext = new JButton(">>");
		btnPrevious = new JButton("<<");
		btnLast = new JButton(">|");
		btnFirst = new JButton("|<");
		pnButton.add(btnFirst);
		pnButton.add(btnPrevious);
		pnButton.add(btnNext);
		pnButton.add(btnLast);

		
		
		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		
		lblMaSV = new JLabel();
		pnChiTiet.add(lblMaSV);
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout());
		txtHoTen = new JTextField(15);
		JLabel lblHoTen = new JLabel("Tên sinh viên");
		pnHoTen.add(lblHoTen);
		pnHoTen.add(txtHoTen);
		pnChiTiet.add(pnHoTen);
		
		JPanel pnNgaySinh = new JPanel();
		pnNgaySinh.setLayout(new FlowLayout());
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		txtNgaySinh = new JTextField(15);
		pnNgaySinh.add(lblNgaySinh);
		pnNgaySinh.add(txtNgaySinh);
		pnChiTiet.add(pnNgaySinh);
		
		JPanel pnKhoa = new JPanel();
		pnKhoa.setLayout(new FlowLayout());
		JLabel lblKhoa = new JLabel("Khoa");
		cbKhoa = new JComboBox<Khoa>();
		pnKhoa.add(lblKhoa);
		pnKhoa.add(cbKhoa);
		pnChiTiet.add(pnKhoa);
		
		lblNgaySinh.setPreferredSize(lblHoTen.getPreferredSize());
		lblKhoa.setPreferredSize(lblHoTen.getPreferredSize());
		cbKhoa.setPreferredSize(txtHoTen.getPreferredSize());
		
		JPanel pnButtonChiTiet = new JPanel();
		pnButtonChiTiet.setLayout(new FlowLayout());
		btnThem = new JButton("Thêm");
		btnSua = new JButton("Sửa");
		btnXoa = new JButton("Xóa");
		pnButtonChiTiet.add(btnThem);
		pnButtonChiTiet.add(btnSua);
		pnButtonChiTiet.add(btnXoa);
		pnChiTiet.add(pnButtonChiTiet);
		
		
		pnMain.add(pnButton, BorderLayout.NORTH);
		pnMain.add(sp);
		pnMain.add(pnChiTiet,BorderLayout.SOUTH);
		ct.add(pnMain);
	}
	public Khoa timKhoaBoiTenKhoa(String maKhoa) {
		String strSQL = "select * from KHOA where MAKHOA = '"+
				maKhoa+"'";
		Khoa khoa = null;
		try {
			state = conn.createStatement();
			ResultSet kq =  state.executeQuery(strSQL);
			
			if(kq.next()==true) {
				khoa = new Khoa(kq.getString(1), kq.getString(2));
				return khoa;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public String taoMaSinhVienMoi() {
		int i = 0;
		String maSV  = "sv0";
		
		try {
			
			while(true) {
				maSV += i;
				String strSQL = "select * from SINHVIEN where MSSV = '"+maSV+"'";
				state = conn.createStatement();
				result = state.executeQuery(strSQL);
				if(result.next()==false) {
					return maSV;
				}
				maSV  = "sv0";
				i++;
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void addEvents() {
		btnFirst.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					result.first();
					txtHoTen.setText(result.getString(2));
					
					txtNgaySinh.setText(sdf.format(result.getDate(3)));
					hienThiPhanTuKhoa(timKhoaBoiTenKhoa(result.getString(4)));
					lblMaSV.setText("Mã sv : "+result.getString(1));
					position = 0;
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnLast.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					result.last();
					txtHoTen.setText(result.getString(2));
					txtNgaySinh.setText(sdf.format(result.getDate(3)));
					hienThiPhanTuKhoa(timKhoaBoiTenKhoa(result.getString(4)));
					lblMaSV.setText("Mã sv : "+result.getString(1));
					position = dtm.getRowCount();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					
					
					if(result.isLast()==false) {
						position++;
						result.absolute(position);
						txtHoTen.setText(result.getString(2));
						txtNgaySinh.setText(sdf.format(result.getDate(3)));
						hienThiPhanTuKhoa(timKhoaBoiTenKhoa(result.getString(4)));
						lblMaSV.setText("Mã sv : "+result.getString(1));
					}
					else {
						result.last();
					}
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnPrevious.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if(result.isFirst()==false) {
						position--;
						result.absolute(position);
						txtHoTen.setText(result.getString(2));
						txtNgaySinh.setText(sdf.format(result.getDate(3)));
						hienThiPhanTuKhoa(timKhoaBoiTenKhoa(result.getString(4)));
						lblMaSV.setText("Mã sv : "+result.getString(1));
					}
					else {
						result.first();
					}
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		tblSinhVien.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tblSinhVien.getSelectedRow()<0) return ;
				int row = tblSinhVien.getSelectedRow();
				
				lblMaSV.setText("Mã sv: "+tblSinhVien.getValueAt(row, 0).toString());
				txtHoTen.setText(tblSinhVien.getValueAt(row, 1).toString());
				txtNgaySinh.setText(tblSinhVien.getValueAt(row, 2).toString());
				
				String strSQL = "select * from KHOA where TENKHOA = N'"+
				tblSinhVien.getValueAt(row, 3).toString()+"'";
				Khoa khoa = null;
				try {
					state = conn.createStatement();
					ResultSet kq =  state.executeQuery(strSQL);
					
					if(kq.next()==true) {
						khoa = new Khoa(kq.getString(1), kq.getString(2));
						hienThiPhanTuKhoa(khoa);
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}

			
		});
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				try {
					Khoa khoa = (Khoa)cbKhoa.getSelectedItem();
					java.util.Date ngaySinh =  sdf.parse(txtNgaySinh.getText());
					String strSQL = "insert into SINHVIEN values('"+taoMaSinhVienMoi()+"',N'"+txtHoTen.getText()+
							"','"+new SimpleDateFormat("yyyy-MM-dd").format(ngaySinh)+"','"+khoa.getMaKhoa()+"')";
					state = conn.createStatement();
					int x = state.executeUpdate(strSQL);
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Thêm mới thành công");
					}
					hienThiThongTin();
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					String strSQL = "delete from SINHVIEN where MSSV = '"+lblMaSV.getText().split(": ")[1]+"'";
					state = conn.createStatement();
					int x = state.executeUpdate(strSQL);
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Xóa thành công sinh viên có mã số: "+lblMaSV.getText().split(": ")[1]);
					}
					hienThiThongTin();
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		});
		btnSua.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Khoa khoa = (Khoa)cbKhoa.getSelectedItem();
					java.util.Date ngaySinh =  sdf.parse(txtNgaySinh.getText());
					String strSQL = "update  SINHVIEN set HOTEN =N'"+txtHoTen.getText()+"', NGAYSINH ='"+
							new SimpleDateFormat("yyyy-MM-dd").format(ngaySinh)+"', MAKHOA ='"+khoa.getMaKhoa()
							+"' where MSSV = '"+lblMaSV.getText().split(": ")[1]+"'";
					state = conn.createStatement();
					int x = state.executeUpdate(strSQL);
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Cập nhật thành công sinh viên có mã số: "+lblMaSV.getText().split(": ")[1]);
					}
					hienThiThongTin();
					
				}
				catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
	}
	
	private void hienThiPhanTuKhoa(Khoa khoa) {
		int index = 0;
		
		for(Khoa item : vt) {
			
			if(item.getMaKhoa().equals(khoa.getMaKhoa())) {
				break;
				
			}
			index++;
			
		}
		cbKhoa.setSelectedIndex(index);
		
	}
	public void showWindow() {
		this.setSize(400, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
