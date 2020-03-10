package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import model.NhanVien;
import model.PhongBan;

public class Interface extends JFrame{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	JComboBox<PhongBan> cbPhongBan;
	JList<NhanVien> listNhanVien ;
	
	JTextField txtMa;
	JTextField txtTen;
	JTextField txtNgayLam;
	JTextField txtNgaySinh;
	
	JButton btLuu;
	JButton btXoa;
	JButton btThoat;
	JButton btXuatFile;
	PhongBan pbSelected ;
	NhanVien nvSelected;
	SimpleDateFormat sdf =new SimpleDateFormat("dd/MM/yyyy");
	public Interface(String title) {
		super(title);
		addControls();
		loadFakeData();
		addEvents();
		showWinDow();
		
	}
	public void addControls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		JPanel pnPhongBan = new JPanel();
		pnPhongBan.setLayout(new FlowLayout() );
		JLabel lblPhongBan = new JLabel("Phòng ban");
		cbPhongBan = new JComboBox<PhongBan>();
		pnPhongBan.add(lblPhongBan);
		pnPhongBan.add(cbPhongBan);
		
		pnMain.add(pnPhongBan);
		
		JPanel pnDanhSachVaChiTiet = new JPanel();
		pnDanhSachVaChiTiet.setLayout(new GridLayout(1,2));
		
		
		JPanel pnDanhSach =  new JPanel();
		pnDanhSach.setLayout(new BorderLayout());
		listNhanVien = new JList<NhanVien>();
		pnDanhSach.add(listNhanVien,BorderLayout.CENTER);
		pnDanhSachVaChiTiet.add(pnDanhSach);
		Border borderDanhSach = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleBorderDanhSach = new TitledBorder(borderDanhSach,"Danh sách nhân viên");
		titleBorderDanhSach.setTitleJustification(TitledBorder.CENTER);
		titleBorderDanhSach.setTitleColor(Color.RED);
		pnDanhSach.setBorder(titleBorderDanhSach);
		
		
		JPanel pnChiTiet = new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		Border borderChiTiet = BorderFactory.createLineBorder(Color.BLUE);
		TitledBorder titleborderChiTiet = new TitledBorder(borderChiTiet,"Chi tiết ");
		titleborderChiTiet.setTitleJustification(TitledBorder.CENTER);
		titleborderChiTiet.setTitleColor(Color.RED);
		pnChiTiet.setBorder(titleborderChiTiet);
		
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout());
		JLabel lblMa = new JLabel("Mã");
		txtMa = new JTextField(15);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		pnChiTiet.add(pnMa);

		JPanel pnTen  = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Tên");
		txtTen = new JTextField(15);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		pnChiTiet.add(pnTen);
		
		JPanel pnNgayLam  = new JPanel();
		pnNgayLam.setLayout(new FlowLayout());
		JLabel lblNgayLam = new JLabel("Ngày làm");
		txtNgayLam = new JTextField(15);
		pnNgayLam.add(lblNgayLam);
		pnNgayLam.add(txtNgayLam);
		pnChiTiet.add(pnNgayLam);
		
		JPanel pnNgaySinh  = new JPanel();
		pnNgaySinh.setLayout(new FlowLayout());
		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		txtNgaySinh = new JTextField(15);
		pnNgaySinh.add(lblNgaySinh);
		pnNgaySinh.add(txtNgaySinh);
		pnChiTiet.add(pnNgaySinh);
		
		pnDanhSachVaChiTiet.add(pnChiTiet);
		pnMain.add(pnDanhSachVaChiTiet);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btLuu = new JButton("Lưu");
		btXoa = new JButton("Xóa");
		btThoat = new JButton("Thoát");
		btXuatFile = new JButton("Xuất file");
		pnButton.add(btLuu);
		pnButton.add(btXoa);
		pnButton.add(btThoat);
		pnButton.add(btXuatFile);
		
		//Set size label
		lblMa.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblTen.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblNgaySinh.setPreferredSize(lblNgaySinh.getPreferredSize());
		lblNgayLam.setPreferredSize(lblNgaySinh.getPreferredSize());
		
		cbPhongBan.setPreferredSize(new Dimension(200,25));
		
		pnMain.add(pnButton);
		
		Container ct =getContentPane();
		ct.add(pnMain);
	}
	
	public void loadFakeData() {
		
		ArrayList<PhongBan> arrPhongBan = new ArrayList<PhongBan>();
		
		PhongBan pHanhChinh =  new PhongBan("PB01","Phòng hành chính");
		PhongBan pVatTu = new PhongBan("PB02","Phòng vật tư");
		PhongBan pKyThuat = new PhongBan("PB03","Phòng kỹ thuật");
		PhongBan pKinhDoanh = new PhongBan("PB04","Phòng kinh doanh");
		
		NhanVien nv1 = new NhanVien("NV01", "Nguyễn Văn Tèo",new Date(2016-1900,1, 1),new Date(1998-1900, 1, 2));
		NhanVien nv2 = new NhanVien("NV02", "Nguyễn Văn Ân",new Date(2016-1900,1, 1),new Date(1998-1900, 1, 2));
		NhanVien nv3 = new NhanVien("NV03", "Nguyễn Văn Anh",new Date(2016-1900,1, 1),new Date(1998-1900, 1, 2));
		NhanVien nv4 = new NhanVien("NV04", "Nguyễn Văn Bình",new Date(2016-1900,1, 1),new Date(1998-1900, 1, 2));
		NhanVien nv5 = new NhanVien("NV05", "Nguyễn Hạnh Phúc",new Date(2016-1900,1, 1),new Date(1998-1900, 1, 2));
		NhanVien nv6 = new NhanVien("NV06", "Nguyễn Bình Minh",new Date(2016-1900,1, 1),new Date(1998-1900, 1, 2));
		
		pHanhChinh.addNhanVien(nv1);
		pHanhChinh.addNhanVien(nv2);
		pVatTu.addNhanVien(nv3);
		pVatTu.addNhanVien(nv4);
		pKyThuat.addNhanVien(nv5);
		pKinhDoanh.addNhanVien(nv6);
		
		arrPhongBan.add(pHanhChinh);
		arrPhongBan.add(pKyThuat);
		arrPhongBan.add(pVatTu);
		arrPhongBan.add(pKinhDoanh);
		
		for(PhongBan pb : arrPhongBan) {
			cbPhongBan.addItem(pb);
		}
		
		
	}
	public void addEvents() {
		
		cbPhongBan.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				if(cbPhongBan.getSelectedIndex()==-1) return;
				pbSelected = (PhongBan)cbPhongBan.getSelectedItem();
				listNhanVien.setListData(pbSelected.getNhanViens());
				
			}
		});
		
		//Bắt sự kiện selected list
		
		
		listNhanVien.addMouseListener(new MouseListener() {

			
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
				if(listNhanVien.getSelectedIndex()==-1) return ;
				// TODO Auto-generated method stub
				nvSelected = listNhanVien.getSelectedValue();
				txtMa.setText(nvSelected.getMaNhanVien());
				txtTen.setText(nvSelected.getTenNhanVien());
				txtNgayLam.setText(sdf.format(nvSelected.getNgayVaoLam()));
				txtNgaySinh.setText(sdf.format(nvSelected.getNgaySinh()));
			}
		});
		
		btLuu.addActionListener(new ActionListener() {
			
		
			public void actionPerformed(ActionEvent e) {
				xuLyLuu();
				
			}
		});
		
		btXoa.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyXoa();
			}
		});
		btThoat.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				xuLyThoat();
			}
		});
		
	}
	
	protected void xuLyThoat() {
		System.exit(0);
	}
	protected void xuLyXoa() {
		// TODO Auto-generated method stub
		pbSelected.getNhanViens().remove(nvSelected);
		nvSelected=null;
		listNhanVien.setListData(pbSelected.getNhanViens());
		
		txtMa.setText(null);
		txtTen.setText(null);
		txtNgaySinh.setText(null);
		txtNgayLam.setText(null);
		
	}
	protected void xuLyLuu() {
		
		try {
			NhanVien nv = new NhanVien(txtMa.getText(), txtTen.getText(),
					sdf.parse(txtNgaySinh.getText()),
					sdf.parse(txtNgayLam.getText()));
			if(pbSelected!=null) {
				pbSelected.addNhanVien(nv);
				listNhanVien.setListData(pbSelected.getNhanViens());
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString());
		}
		
	}
	public void showWinDow() {
		this.setSize(550,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	
}
