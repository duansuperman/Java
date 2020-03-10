package learnjava.com.vn.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import learnjava.com.vn.models.DanhMuc;
import learnjava.com.vn.models.SanPham;
import learnjava.com.vn.services.DanhMucService;
import learnjava.com.vn.services.SanPhamService;

public class MainUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MainUI(String title) {
		super(title);
		addControls();
		hienThiListDanhMuc();
		hienThiTableSanPham();
		hienThiComboDanhMuc();
		addEvents();
		showWindow();
	}
	
	JList<DanhMuc> lstDanhMuc;
	JButton btnThem, btnXoa, btnSua;
	DefaultTableModel dtm;
	JTable tblSanPham;
	JTextField txtTenSP,txtGia,txtSoLuong;

	JComboBox<DanhMuc> cbDanhMuc;
	JButton btnThemSP,btnXoaSP, btnSuaSP;
	Vector<DanhMuc> listDM = null;
	ArrayList<SanPham> listSP = null;
	JLabel lblMaSP;

	private void hienThiListDanhMuc() {
		lstDanhMuc.removeAll();
		listDM = DanhMucService.getAllData();
		lstDanhMuc.setListData(listDM);
	}
	private void hienThiTableSanPham() {
		listSP = SanPhamService.getAllData();
		dtm.setRowCount(0);
		for(SanPham sp : listSP) {
			Vector<Object> vt = new Vector<Object>();
			vt.add(sp.getMaSP());
			vt.add(sp.getTenSP());
			vt.add(sp.getSoLuong());
			vt.add(sp.getDonGia());
			DanhMuc dm = DanhMucService.getDataById(sp.getMaDM());
			vt.add(dm.getTenDM());
			dtm.addRow(vt);
		}
	}
	private void hienThiComboDanhMuc() {
		for(DanhMuc dm : listDM) {
			cbDanhMuc.addItem(dm);
		}
	}
	public void addEvents() {
		tblSanPham.addMouseListener(new MouseListener() {
			
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
				if(tblSanPham.getSelectedRow()<0) return ;
				int row = tblSanPham.getSelectedRow();
				
				txtTenSP.setText(tblSanPham.getValueAt(row, 1).toString());
				lblMaSP.setText(tblSanPham.getValueAt(row, 0).toString());
				txtSoLuong.setText(tblSanPham.getValueAt(row,2 ).toString());
				txtGia.setText(tblSanPham.getValueAt(row, 3).toString());
				hienThiDanhMucTuongUng(tblSanPham.getValueAt(row, 4).toString());
			}
		});
		
		btnThemSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DanhMuc danhMuc = (DanhMuc)cbDanhMuc.getSelectedItem();
				
				SanPhamService.insertSanPham(txtTenSP.getText(), 
						Integer.parseInt(txtSoLuong.getText()),
						Integer.parseInt(txtGia.getText()),
						danhMuc.getMaDM());
				hienThiTableSanPham();
			}
		});
		btnXoaSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				SanPhamService.deleteSanPham(lblMaSP.getText());
				hienThiTableSanPham();
			}
		});
		btnSuaSP.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DanhMuc danhMuc = (DanhMuc)cbDanhMuc.getSelectedItem();
				SanPhamService.updateSanPham(lblMaSP.getText(), 
						txtTenSP.getText(),
						Integer.parseInt(txtSoLuong.getText()),
						Integer.parseInt(txtGia.getText()), 
						danhMuc.getMaDM());
				hienThiTableSanPham();
			}
		});
	}
	protected void hienThiDanhMucTuongUng(String tenDM) {
		int index = 0;
		for(DanhMuc dm : listDM) {
			if(dm.getTenDM().equals(tenDM)) {
				cbDanhMuc.setSelectedIndex(index);
				break;
			}
			index++;
		}
		
	}
	public void addControls() {
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTitle = new JLabel("Quản lý sản phẩm");
		Font font = new Font("cambria", Font.BOLD, 20);
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.blue);
		pnTitle.add(lblTitle);
		
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BorderLayout());
		pnLeft.setPreferredSize(new Dimension(300,0));
		lstDanhMuc = new JList<DanhMuc>();
		JScrollPane spDanhMuc = new JScrollPane(lstDanhMuc
				, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(spDanhMuc);
		
		JPanel pnButton  = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnThem = new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		pnButton.add(btnThem);
		pnButton.add(btnXoa);
		pnButton.add(btnSua);
		pnButton.setPreferredSize(new Dimension(0,100));
		pnLeft.add(pnButton,BorderLayout.SOUTH);
		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		
		JPanel pnBottomRight = new JPanel();
		pnBottomRight.setLayout(new BoxLayout(pnBottomRight, BoxLayout.Y_AXIS));
		
		JPanel pnTopRight = new JPanel();
		pnTopRight.setLayout(new BorderLayout());
		
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pnTopRight,pnBottomRight);
		pnTopRight.setPreferredSize(new Dimension(0,200));
		pnRight.add(spRight);
		dtm = new DefaultTableModel();
		dtm.addColumn("Mã sp");
		dtm.addColumn("Tên sản phẩm");
		dtm.addColumn("Số lượng");
		dtm.addColumn("Gía");
		dtm.addColumn("Danh mục");
		
		tblSanPham = new JTable(dtm);
		JScrollPane spSanPham = new JScrollPane(tblSanPham,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnTopRight.add(spSanPham);
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		sp.setOneTouchExpandable(true);
		
		lblMaSP = new JLabel();
		lblMaSP.setForeground(Color.blue);
		Font fontMaSP = new Font("cambria", Font.BOLD, 15);
		lblMaSP.setFont(fontMaSP);
		pnBottomRight.add(lblMaSP);
		
		JPanel pnDanhMuc = new JPanel();
		pnDanhMuc.setLayout(new FlowLayout());
		JLabel lblDanhMuc = new JLabel("Danh mục");
		cbDanhMuc = new JComboBox<DanhMuc>();
		pnDanhMuc.add(lblDanhMuc);
		pnDanhMuc.add(cbDanhMuc);
		pnBottomRight.add(pnDanhMuc);
		
		JPanel pnTenSP = new JPanel();
		pnTenSP.setLayout(new FlowLayout());
		JLabel lblTenSP = new JLabel("Tên sản phẩm");
		txtTenSP = new JTextField(20);
		pnTenSP.add(lblTenSP);
		pnTenSP.add(txtTenSP);
		pnBottomRight.add(pnTenSP);
		
		JPanel pnGia = new JPanel();
		pnGia.setLayout(new FlowLayout());
		JLabel lblGia = new JLabel("Gía");
		txtGia = new JTextField(20);
		pnGia.add(lblGia);
		pnGia.add(txtGia);
		pnBottomRight.add(pnGia);
		
		JPanel pnSoLuong = new JPanel();
		pnSoLuong.setLayout(new FlowLayout());
		JLabel lblSoLuong = new JLabel("Số lượng");
		txtSoLuong = new JTextField(20);
		pnSoLuong.add(lblSoLuong);
		pnSoLuong.add(txtSoLuong);
		pnBottomRight.add(pnSoLuong);

		lblGia.setPreferredSize(lblTenSP.getPreferredSize());
		lblDanhMuc.setPreferredSize(lblTenSP.getPreferredSize());
		lblSoLuong.setPreferredSize(lblTenSP.getPreferredSize());
		
		JPanel pnButtonSP = new JPanel();
		pnButtonSP.setLayout(new FlowLayout());
		btnThemSP = new JButton("Thêm");
		btnXoaSP = new JButton("Xóa");
		btnSuaSP = new JButton("Sửa");
		pnButtonSP.add(btnThemSP);
		pnButtonSP.add(btnXoaSP);
		pnButtonSP.add(btnSuaSP);
		pnBottomRight.add(pnButtonSP);
		
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.red),
				"Danh mục sản phẩm");
		titleBorder.setTitleColor(Color.blue);
		pnLeft.setBorder(titleBorder);
		
		ct.add(sp);
		ct.add(pnTitle,BorderLayout.NORTH);
	}
	public void showWindow() {
		this.setSize(800,600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
