package learnjava.com.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import learnjava.com.driver.NguoiDungDriver;

public class LoginUI extends JFrame{
	public LoginUI(String title) {
		super(title);
		addControls();
		addEvents();
		showWindow();
	}
	JTextField txtUserName;
	JPasswordField txtPassword;
	JButton btnLogin,btnExit;
	public void addControls() {
		Container ct = getContentPane();
		ct.setLayout(new BoxLayout(ct, BoxLayout.Y_AXIS));
		
		JPanel pnTitle = new JPanel();
		pnTitle.setLayout(new FlowLayout());
		JLabel lblTiTle = new JLabel("Đăng nhập hệ thống quản lý công văn");
		Font font = new Font("cambria", Font.BOLD, 20);
		lblTiTle.setForeground(Color.blue);
		lblTiTle.setFont(font);
		pnTitle.add(lblTiTle);
		ct.add(pnTitle);
		
		
		JPanel pnUserName = new JPanel();
		pnUserName.setLayout(new FlowLayout());
		JLabel lblUserName = new JLabel("User name");
		txtUserName = new JTextField(20);
		pnUserName.add(lblUserName);
		pnUserName.add(txtUserName);
		
		JPanel pnPassword = new JPanel();
		pnPassword.setLayout(new FlowLayout());
		JLabel lblPassword = new JLabel("Password");
		txtPassword = new JPasswordField(20);
		pnPassword.add(lblPassword);
		pnPassword.add(txtPassword);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnLogin = new JButton("Đăng nhập");
		btnExit = new JButton("Thoát");
		pnButton.add(btnLogin);
		pnButton.add(btnExit);
		
		JPanel pnChiTiet  = new JPanel();
		pnChiTiet.setLayout(new BoxLayout(pnChiTiet, BoxLayout.Y_AXIS));
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.RED), 
				"Thông tin đăng nhập");
		pnChiTiet.setBorder(titleBorder);
		
		pnChiTiet.add(pnUserName);
		pnChiTiet.add(pnPassword);
		pnChiTiet.add(pnButton);
		
		pnChiTiet.setBackground(Color.GREEN);
		btnLogin.setBackground(Color.BLUE);
		btnExit.setBackground(Color.BLUE);
		pnTitle.setBackground(Color.GREEN);
		lblUserName.setForeground(Color.blue);
		lblPassword.setForeground(Color.blue);
		btnLogin.setForeground(Color.white);
		btnExit.setForeground(Color.white);
		pnUserName.setBackground(Color.WHITE);
		pnPassword.setBackground(Color.WHITE);
		pnButton.setBackground(Color.WHITE);
		
		ct.add(pnChiTiet);
		
	}
	public void addEvents() {
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(NguoiDungDriver.login(txtUserName.getText(), txtPassword.getText())) {
					JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
					CongVanUI cvUI = new CongVanUI("Công văn");
				}
				else {
					JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
				}
				
			}
		});
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
	}
	public void showWindow() {
		this.setSize(400,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
