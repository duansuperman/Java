package learnjava.com.vn.ui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MyWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyWindow(String title) {
		super(title);
		addControls();
		hienThiCombobox();
		addEvents();
		showWindow();
	}
	
	JComboBox<Integer> cbDoDaiPass,cbDoDaiUser,cbSuiteTotal;
	JCheckBox chkCapitalCharsPass, chkSmallCharsPass, chkNumbersPass, chkSymboysPass;
	JCheckBox chkCapitalCharsUser, chkSmallCharsUser, chkNumbersUser, chkSymboysUser;
	JButton btnCreate;
	
	String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 
    String Small_chars = "abcdefghijklmnopqrstuvwxyz"; 
    String numbers = "0123456789"; 
    String symbols = "!@#$%^&*_=+-/.?<>)"; 
    String user;
    String pass;
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    private void hienThiCombobox() {
		for(int i=0;i<=20;i++) {
			cbDoDaiPass.addItem(i);
			cbDoDaiUser.addItem(i);
		}
		for(int i=0;i<=200;i++) {
			cbSuiteTotal.addItem(i);
		}
	}
	public void addControls() {
		Container ct = getContentPane();
		ct.setLayout(new BoxLayout(ct, BoxLayout.Y_AXIS));
		
		JPanel pnTitLe = new JPanel();
		pnTitLe.setLayout(new FlowLayout());
		JLabel lblTitle = new JLabel("Phần mềm tạo user&password");
		Font font = new Font("cambria", Font.BOLD, 20);
		lblTitle.setFont(font);
		lblTitle.setForeground(Color.BLUE);
		pnTitLe.add(lblTitle);
		
		JPanel pnDoDaiPass = new JPanel();
		pnDoDaiPass.setLayout(new FlowLayout());
		JLabel lblDoDai = new JLabel("Độ dài password");
		cbDoDaiPass = new JComboBox<Integer>();
		pnDoDaiPass.add(lblDoDai);
		pnDoDaiPass.add(cbDoDaiPass);
		btnCreate = new JButton("Tạo");
		pnDoDaiPass.add(btnCreate);
		
		JPanel pnCheckBoxPass = new JPanel();
		pnCheckBoxPass.setLayout(new FlowLayout());
		
		chkCapitalCharsPass = new JCheckBox("ABCD...");
		chkSmallCharsPass = new JCheckBox("abc...");
		chkNumbersPass = new JCheckBox("123..9");
		chkSymboysPass = new JCheckBox("!@#$%..?<>");
		
		pnCheckBoxPass.add(chkCapitalCharsPass);
		pnCheckBoxPass.add(chkSmallCharsPass);
		pnCheckBoxPass.add(chkNumbersPass);
		pnCheckBoxPass.add(chkSymboysPass);
		
		JPanel pnPassword = new JPanel();
		pnPassword.setLayout(new BoxLayout(pnPassword, BoxLayout.Y_AXIS));
		pnPassword.add(pnDoDaiPass);
		
		TitledBorder titleBorder = new TitledBorder(BorderFactory.createLineBorder(Color.red),
				"Password");
		titleBorder.setTitleColor(Color.blue);
		titleBorder.setTitleJustification(TitledBorder.CENTER);
		pnPassword.setBorder(titleBorder);
		pnPassword.add(pnCheckBoxPass);
		
	
		
		JPanel pnContentUser = new  JPanel();
		pnContentUser.setLayout(new BoxLayout(pnContentUser, BoxLayout.Y_AXIS));
		
		JPanel pnDoDaiUser = new JPanel();
		pnDoDaiUser.setLayout(new FlowLayout());
		JLabel lblDoDaiUser = new JLabel("Độ dài username");
		cbDoDaiUser = new JComboBox<Integer>();
		pnDoDaiUser.add(lblDoDaiUser);
		pnDoDaiUser.add(cbDoDaiUser);
	
		JPanel pnCheckBoxUser = new JPanel();
		pnCheckBoxUser.setLayout(new FlowLayout());
		
		chkCapitalCharsUser = new JCheckBox("ABCD...");
		chkSmallCharsUser = new JCheckBox("abc...");
		chkNumbersUser = new JCheckBox("123..9");
		chkSymboysUser = new JCheckBox("!@#$%..?<>");
		
		pnCheckBoxUser.add(chkCapitalCharsUser);
		pnCheckBoxUser.add(chkSmallCharsUser);
		pnCheckBoxUser.add(chkNumbersUser);
		pnCheckBoxUser.add(chkSymboysUser);
		
		JPanel pnUser = new JPanel();
		pnUser.setLayout(new BoxLayout(pnUser, BoxLayout.Y_AXIS));
		pnUser.add(pnDoDaiUser);
		
		TitledBorder titleBorderUser = new TitledBorder(BorderFactory.createLineBorder(Color.red),
				"Username");
		titleBorderUser.setTitleColor(Color.blue);
		titleBorderUser.setTitleJustification(TitledBorder.CENTER);
		pnUser.setBorder(titleBorderUser);
		pnUser.add(pnCheckBoxUser);
		
		JPanel pnContent = new JPanel();
		pnContent.setLayout(new FlowLayout());
		pnContent.add(pnUser);
		pnContent.add(pnPassword);
		
		pnPassword.setPreferredSize(pnUser.getPreferredSize());
		
		
		cbSuiteTotal = new JComboBox<Integer>();
		JLabel lblSuitTotal = new JLabel("Số lượng cần tạo: ");
		JPanel pnSuiTotal = new JPanel();
		pnSuiTotal.add(lblSuitTotal);
		pnSuiTotal.add(cbSuiteTotal);
		pnSuiTotal.add(btnCreate);
		
		TitledBorder titleBorderSuitTotal = new TitledBorder(BorderFactory.createLineBorder(Color.RED), 
				"Tạo", TitledBorder.CENTER,TitledBorder.CENTER);
		titleBorderSuitTotal.setTitleColor(Color.BLUE);
		
		pnSuiTotal.setBorder(titleBorderSuitTotal);
		pnSuiTotal.setPreferredSize(pnContent.getPreferredSize());
		
		
		TitledBorder titleBorderContent = new TitledBorder(BorderFactory.createLineBorder(Color.RED), 
				"user & password", TitledBorder.CENTER,TitledBorder.CENTER);
		titleBorderContent.setTitleColor(Color.BLUE);
		pnContent.setBorder(titleBorderContent);
		ct.add(pnTitLe);
		ct.add(pnSuiTotal);
		ct.add(pnContent);
		
	
	}
	public void addEvents() {
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				user="";
				pass="";
				if(chkCapitalCharsUser.isSelected()) {
					user+=Capital_chars;
				}
				if(chkNumbersUser.isSelected()) {
					user+=numbers;
				}
				if(chkSmallCharsUser.isSelected()) {
					user+=Small_chars;
				}
				if(chkSymboysUser.isSelected()) {
					user+=symbols;
				}
				
				if(chkCapitalCharsPass.isSelected()) {
					pass+=Capital_chars;
				}
				if(chkNumbersPass.isSelected()) {
					pass+=numbers;
				}
				if(chkSmallCharsPass.isSelected()) {
					pass+=Small_chars;
				}
				if(chkSymboysPass.isSelected()) {
					pass+=symbols;
				}
				
				try {
					String resultPass="";
					String resultUser ="";
					int lengthUser = (int)cbDoDaiUser.getSelectedItem();
					int lengthPass = (int)cbDoDaiPass.getSelectedItem();
					int suiteTotal = (int)cbSuiteTotal.getSelectedItem();
					Random rd = new Random();
					workbook = new XSSFWorkbook();
			        sheet = workbook.createSheet("Test suite");
			        
			        Row row = sheet.createRow(0);
			        for(int i=0;i<5;i++) {
			        	Cell cell = row.createCell(i);
			        	switch (i) {
						case 0:
							cell.setCellValue("Số TT");
							break;
						case 1:
							cell.setCellValue("UserName");
							break;
						case 2:
							cell.setCellValue("Password");
							break;
						case 3:
							cell.setCellValue("Kết Quả");
							break;
						case 4:
							cell.setCellValue("Ghi chú");
							break;
						default:
							break;
						}
			           
			        }
			        
					for(int i=0;i<suiteTotal;i++) {
						for(int j=0;j<lengthUser;j++) {
							int index = rd.nextInt(user.length());
							resultUser+=user.charAt(index);
						}
						for(int k=0;k<lengthPass;k++) {
							int index = rd.nextInt(pass.length());
							resultPass+=pass.charAt(index);
						}
						 
						themVaoRowExcel(resultUser,resultPass,i+1);
						resultPass="";
						resultUser="";
					}
					FileOutputStream outputStream = new FileOutputStream("files//TestUser&Pass.xlsx");
					workbook.write(outputStream);
					JOptionPane.showMessageDialog(null, "Đã tạo thành công ! Vui lòng kiểm tra file tạo");
				}
				catch (Exception e) {
					user="";
					pass="";
					JOptionPane.showMessageDialog(null, "Khởi tạo thất bại ! Vui lòng kiểm tra lại thao tác tạo");
					e.printStackTrace();
				}
			}
		});
	}
	protected void themVaoRowExcel(String resultUser, String resultPass,int rowNumber) {
		
        Row row = sheet.createRow(rowNumber);
        for(int i=0;i<4;i++) {
        	Cell cell = row.createCell(i);
        	switch (i) {
			case 0:
				cell.setCellValue(rowNumber);
				break;
			case 1:
				cell.setCellValue(resultUser);
				break;
			case 2:
				cell.setCellValue(resultPass);
				break;
			case 3:
				 cell.setCellValue(0);
				 break;
			default:
				break;
			}
            
        }
        
        		
	}
	public void showWindow() {
		this.setSize(800,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
