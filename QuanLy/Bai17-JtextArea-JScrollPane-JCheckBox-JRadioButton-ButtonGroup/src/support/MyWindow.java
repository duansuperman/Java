package support;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MyWindow extends JFrame {
	JButton btOK;
	JTextField txtTen;
	JTextArea txtDiaChi;
	
	JCheckBox chkDiBoi;
	JCheckBox chkDiXemPhim;
	JRadioButton rbtNam;
	JRadioButton rbtNu;
	public MyWindow(String title) {
		super(title);
		addControls();
		showWindow();
	}
	public void showWindow() {
		this.setSize(400, 350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void addControls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		
		//Tạo panel thông tin để tổng 2 dòng nhập thông tin và địa chỉ
		JPanel pnThongTin = new JPanel();
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		//Tạo border thông tin với viền màu đỏ
		Border borderThongTin = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorderThongTin = new TitledBorder(borderThongTin, "Thông tin");
		
		pnThongTin.setBorder(titleBorderThongTin);
		titleBorderThongTin.setTitleColor(Color.RED);
		titleBorderThongTin.setTitleJustification(titleBorderThongTin.RIGHT);
		
		//Tạo 1 panel tên để quản lý label họ tên và textfield nhập họ tên
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Nhập tên ");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		
		JPanel pnDiaChi = new JPanel();
		pnDiaChi.setLayout(new FlowLayout());
		JLabel lblDiaChi = new JLabel("Địa chỉ ");
		txtDiaChi = new JTextArea(5,19);
		
		JScrollPane sc = new JScrollPane(txtDiaChi, 
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		
		pnDiaChi.add(lblDiaChi);
		pnDiaChi.add(sc);
		
		//Dùng panel thông tin để tổng hợp panel họ tên và dịa chỉ
		pnThongTin.add(pnTen);
		pnThongTin.add(pnDiaChi);
		
		//Tạo 1 panel để tổng hợp 2 bordertitle sơt thích và giới tính
		JPanel pnSoThichVaGioiTinh = new JPanel();
		pnSoThichVaGioiTinh.setLayout(new GridLayout(1,2));
		
		//Tạo 1 panel sở thích để tổng hợp các control checkbox
		JPanel pnSoThich = new JPanel();
		pnSoThich.setLayout(new BoxLayout(pnSoThich, BoxLayout.Y_AXIS));
		chkDiBoi = new JCheckBox("Đi bơi");
		chkDiXemPhim = new JCheckBox("Đi xem phim"); 
		pnSoThich.add(chkDiBoi);
		pnSoThich.add(chkDiXemPhim);
		
		Border borderSoThich = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorderSoThich = new TitledBorder(borderSoThich, "Sở thích");
		
		pnSoThich.setBorder(titleBorderSoThich);
	
		
		//Tạo 1 panel về giới tính 
		JPanel pnGioiTinh = new JPanel();
		pnGioiTinh.setLayout(new BoxLayout(pnGioiTinh, BoxLayout.Y_AXIS));
		//Tạo các jradiobutton và dùng buttongroup để tổng hợp
		
		ButtonGroup btgGioiTinh = new ButtonGroup();
		rbtNam = new JRadioButton("Nam");
		rbtNu = new JRadioButton("Nữ");
		btgGioiTinh.add(rbtNam);
		btgGioiTinh.add(rbtNu);
		pnGioiTinh.add(rbtNam);
		pnGioiTinh.add(rbtNu);
		
		Border borderGioiTinh = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titleBorderGioiTinh = new TitledBorder(borderGioiTinh, "giới thích");
		
		pnGioiTinh.setBorder(titleBorderGioiTinh);
		
		//Dùng panel thông tin và sở thích để tổng hợp 2 panel sở thích và giưới tính
		pnSoThichVaGioiTinh.add(pnSoThich);
		pnSoThichVaGioiTinh.add(pnGioiTinh);
		
		//Tạo 1 panel ok
		JPanel pnOK = new JPanel();
		pnOK.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btOK = new JButton("OK");
		pnOK.add(btOK);
		
		//Dùng panel main để tổng hợp các panel con
		pnMain.add(pnThongTin);
		pnMain.add(pnSoThichVaGioiTinh);
		pnMain.add(pnOK);
		
		Container ct = getContentPane();
		ct.add(pnMain);
		
		lblDiaChi.setPreferredSize(lblTen.getPreferredSize());
		
		//Bắt sự kiện button OK
		btOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String t = txtTen.getText()+"\n";
				
				t+=txtDiaChi.getText()+"\n";
				
				if(chkDiBoi.isSelected()) {
					t+=chkDiBoi.getText()+"\n";
				}
				if(chkDiXemPhim.isSelected()) {
					t+=chkDiXemPhim.getText()+"\n";
				}
				
				if(rbtNam.isSelected()) {
					t+=rbtNam.getText();
				}
				if(rbtNu.isSelected()) {
					t+=rbtNu.getText();
				}
				
				JOptionPane.showMessageDialog(null, t);
			}
		});
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

}
