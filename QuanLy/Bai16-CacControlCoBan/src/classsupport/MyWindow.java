package classsupport;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.StyledEditorKit.BoldAction;

public class MyWindow extends JFrame {
	JButton btSolve;
	JButton btExit;
	JTextField txtA;
	JTextField txtB;
	JTextField txtResult;
	//Biên actionlistener có khả năng sinh ra sự kiện
	ActionListener event = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String valueA = txtA.getText();
			String valueB= txtB.getText();
			double a = Integer.parseInt(valueA);
			double b = Integer.parseInt(valueB);
			if(a==0&&b==0) {
				txtResult.setText("Vô số nghiệm");
			}
			else if(a==0&&b!=0) {
				txtResult.setText("Vô nghiệm");
			}
			else {
				double x= -b/a;
				DecimalFormat df = new DecimalFormat("#.##");
				txtResult.setText("x = "+df.format(x));
			}
		}
	};
	public MyWindow(String title) {
		super(title);
		addControls();
		eventControls();
		showWindow();
		
	}
	public void showWindow() {
		this.setSize(350,250);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void addControls() {
		JPanel jpMain = new JPanel();
		jpMain.setLayout(new BoxLayout(jpMain, BoxLayout.Y_AXIS));
		
		//Tạo 1 jpanel để tổng hợp tiêu đề
		JPanel jpTitle =  new JPanel();
		jpTitle.setLayout(new FlowLayout());
		JLabel lblTitle =  new JLabel("Giải phương trình bậc nhất");
		Font fT = new Font("arial",Font.BOLD,20);
		lblTitle.setFont(fT);
		lblTitle.setForeground(Color.BLUE);
		jpTitle.add(lblTitle);
		
		
		//Tạo 1 jpanel để tổng hợp 1 jlable và 1 jtextfield của hệ số A
		JPanel jpA = new JPanel();
		jpA.setLayout(new FlowLayout());
		JLabel lblA = new JLabel("Hệ số a : ");
		Font fA = new Font("arial",Font.BOLD,20);
		lblA.setFont(fA);
		lblA.setForeground(Color.BLUE);
		txtA = new JTextField(10);
		jpA.add(lblA);
		jpA.add(txtA);
		
		//Tạo 1 jpanel để tổng hợp 1 lable và 1 jtextfield của hệ số B
		JPanel jpB =new JPanel();
		jpB.setLayout(new FlowLayout());
		JLabel lblB = new JLabel("Hệ số b : ");
		Font fB =new Font("arial",Font.BOLD,20);
		lblB.setFont(fB);
		lblB.setForeground(Color.BLUE);
		txtB = new JTextField(10);
		jpB.add(lblB);
		jpB.add(txtB);
		
		//tạo 1 jpanel để tổng hợp 3 button 
		JPanel jpButton = new JPanel();
		jpButton.setLayout(new FlowLayout());
		btSolve = new JButton("Giai");
		
		
		btExit = new JButton("Thoát");
		btExit.setIcon(new ImageIcon("Hinh/Exit.png"));
		jpButton.add(btSolve);
		jpButton.add(btExit);
		
		//Tạo 1 jpanel để tổng hợp 1 label và 1 jtextfield
		JPanel jpResult = new JPanel();
		jpResult.setLayout(new FlowLayout());
		JLabel lblResult = new JLabel("Kết quả : ");
		Font fResult  = new Font("arial",Font.BOLD,20);
		lblResult.setFont(fResult);
		lblResult.setForeground(Color.BLUE);
		txtResult = new JTextField(10);
		jpResult.add(lblResult);
		jpResult.add(txtResult);
		
		//Sử dụng jpMain để tổng hợp 2 jpanel trên
		jpMain.add(jpTitle);
		jpMain.add(jpA);
		jpMain.add(jpB);
		jpMain.add(jpButton);
		jpMain.add(jpResult);
		
		Container c= getContentPane();
		c.add(jpMain);
	}
	public void eventControls() {
		//Sử dụng inline anonymous listener để bắt sự kiện
		btExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
				
			}
		});
		
		//Sử dụng listener in variable để bắt sựu kiện
		//Tức là sử dụng biến có khả năng sinh sự kiện
		btSolve.addActionListener(event);
	}
}

public class Event implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// Viết sử ly lệnh ở đây
		
	}
	
}
