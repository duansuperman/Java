package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;

import model.KhachHang;
import model.NhomKhachHang;

public class MyWindow extends JFrame {
	public MyWindow(String title) {
		super(title);
		addControls();
		fakeData();
		addEvents();
		showWindow();
	}
	DefaultMutableTreeNode root;
	JTree tree;
	DefaultTableModel dtm ;
	JTable tbKhachHang;
	NhomKhachHang nkhSelected;
	JTextField txtHoTen;
	JTextField txtDiaChi;
	JTextField txtPhone;
	JTextField txtEmail;
	JButton btnSave;
	JButton btnDelete;
	public void addControls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BorderLayout());
		pnLeft.setPreferredSize(new Dimension(200,0));
		pnLeft.setBackground(Color.GREEN);
		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		
		JPanel pnTopOfRight = new JPanel();
		pnTopOfRight.setLayout(new BorderLayout());
		pnTopOfRight.setPreferredSize(new Dimension(0,150));
		pnTopOfRight.setBackground(Color.GREEN);
		
		JPanel pnBottomOfRight = new JPanel();
		pnBottomOfRight.setLayout(new BoxLayout(pnBottomOfRight, BoxLayout.Y_AXIS));
		pnBottomOfRight.setBackground(Color.GREEN);
		
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pnTopOfRight,pnBottomOfRight);
		pnRight.add(spRight);		
		
		pnMain.add(sp);
		Container ct = getContentPane();
		
		root = new DefaultMutableTreeNode("Nhóm khách hàng");
		tree = new JTree(root);
		
		
		JScrollPane sc = new JScrollPane(tree,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(sc);
		
		dtm=new DefaultTableModel();
		tbKhachHang = new JTable(dtm);
		dtm.addColumn("Tên khách hàng");
		dtm.addColumn("Địa chỉ");
		dtm.addColumn("Email");
		dtm.addColumn("Phone");
		dtm.setRowCount(0);
		
		
		JScrollPane scTopOfRight = new JScrollPane(tbKhachHang,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTopOfRight.add(scTopOfRight);
		
		JPanel pnHoTen = new JPanel();
		pnHoTen.setLayout(new FlowLayout(FlowLayout.LEFT));
		txtHoTen = new JTextField(20);
		JLabel lblHoTen = new JLabel("Họ tên");
		
		pnHoTen.add(lblHoTen);
		pnHoTen.add(txtHoTen);
		
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout(FlowLayout.LEFT));
		txtDiaChi = new JTextField(20);
		JLabel lblDiaChi = new JLabel("Địa chỉ");
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(txtDiaChi);
		
		JPanel pnPhone = new JPanel();
		pnPhone.setLayout(new FlowLayout(FlowLayout.LEFT));
		txtPhone = new JTextField(20);
		JLabel lblPhone = new JLabel("Phone");
		pnPhone.add(lblPhone);
		pnPhone.add(txtPhone);
		
		JPanel pnEmail = new JPanel();
		pnEmail.setLayout(new FlowLayout(FlowLayout.LEFT));
		txtEmail = new JTextField(20);
		JLabel lblEmail = new JLabel("Email");
		pnEmail.add(lblEmail);
		pnEmail.add(txtEmail);
		
		pnBottomOfRight.add(pnHoTen);
		pnBottomOfRight.add(pnDiaChi);
		pnBottomOfRight.add(pnPhone);
		pnBottomOfRight.add(pnEmail);
		
		lblHoTen.setPreferredSize(lblDiaChi.getPreferredSize());
		lblPhone.setPreferredSize(lblDiaChi.getPreferredSize());
		lblEmail.setPreferredSize(lblDiaChi.getPreferredSize());
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnSave = new JButton("Lưu");
		btnDelete = new JButton("Xóa");
		pnButton.add(btnSave);
		pnButton.add(btnDelete);
		pnBottomOfRight.add(pnButton);
		
		ct.add(pnMain);
	}
	public void addEvents() {
		tree.addMouseListener(new MouseListener() {
			
		
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		
			public void mouseClicked(MouseEvent e) {
				nkhSelected = new NhomKhachHang();
				DefaultMutableTreeNode select = (DefaultMutableTreeNode)tree.getLastSelectedPathComponent();
				nkhSelected = (NhomKhachHang)select.getUserObject();
				Vector<String> khachHang ;
				dtm.setRowCount(0);
				for(KhachHang kh : nkhSelected.getKhachHangs()) {
					khachHang = new Vector<String>();
					khachHang.add(kh.getHoTen());
					khachHang.add(kh.getDiaChi());
					khachHang.add(kh.getPhone());
					khachHang.add(kh.getEmail());
					
					dtm.addRow(khachHang);
				}
				
			}
		});
		tbKhachHang.addMouseListener(new MouseListener() {
			
			
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			
			public void mouseClicked(MouseEvent e) {
				if(tbKhachHang.getSelectedRow()==-1) return;
				txtHoTen.setText(tbKhachHang.getValueAt(tbKhachHang.getSelectedRow(), 0).toString());
				txtDiaChi.setText(tbKhachHang.getValueAt(tbKhachHang.getSelectedRow(), 1).toString());
				txtPhone.setText(tbKhachHang.getValueAt(tbKhachHang.getSelectedRow(), 2).toString());
				txtEmail.setText(tbKhachHang.getValueAt(tbKhachHang.getSelectedRow(), 3).toString());
			}
		});
		btnSave.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				if(nkhSelected ==null) return;
				
				KhachHang kh = new KhachHang(txtHoTen.getText(),txtDiaChi.getText(),txtPhone.getText(),txtEmail.getText());
				nkhSelected.getKhachHangs().add(kh);
				JOptionPane.showMessageDialog(null, "Bạn đã lưu thành công !");
				Vector<String> khachHang ;
				khachHang = new Vector<String>();
				khachHang.add(kh.getHoTen());
				khachHang.add(kh.getDiaChi());
				khachHang.add(kh.getPhone());
				khachHang.add(kh.getEmail());
				
				dtm.addRow(khachHang);
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				if(tbKhachHang.getSelectedRow()==-1) return;
				
				KhachHang kh = new KhachHang(txtHoTen.getText(),txtDiaChi.getText(),txtPhone.getText(),txtEmail.getText());
				if(nkhSelected==null)return;
				nkhSelected.getKhachHangs().remove(tbKhachHang.getSelectedRow());
				
				dtm.removeRow(tbKhachHang.getSelectedRow());
			}
		});
	}
	public void fakeData() {
		ArrayList<NhomKhachHang> arrNhomKH= new ArrayList<NhomKhachHang>();
		NhomKhachHang nkhVip = new NhomKhachHang("N01","Khách Hang VIP");
		NhomKhachHang nkhThuongXuyen = new NhomKhachHang("N02","Khách Hàng Thường xuyên");
		NhomKhachHang nkhMoi = new NhomKhachHang("N03","Khách Hàng Mới");
		
		arrNhomKH.add(nkhVip);
		arrNhomKH.add(nkhThuongXuyen);
		arrNhomKH.add(nkhMoi);
		
		nkhVip.getKhachHangs().add(new KhachHang("Nguyễn Văn Tèo","HCM","123","Email"));
		nkhVip.getKhachHangs().add(new KhachHang("Nguyễn Văn Tý","HCM","123","Email"));
		nkhVip.getKhachHangs().add(new KhachHang("Nguyễn MaiAnh","HCM","123","Email"));
		for (NhomKhachHang nhomKhachHang : arrNhomKH) {
			root.add(new DefaultMutableTreeNode(nhomKhachHang));
		}
		
		tree.expandRow(0);
	}
	public void showWindow() {
		this.setSize(600,450);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
