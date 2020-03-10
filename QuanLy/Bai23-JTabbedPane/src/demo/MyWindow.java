package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class MyWindow extends JFrame{
	public MyWindow(String title) {
		super(title);
		addControls();
		showWindow();
	}
	JTabbedPane tab ;
	JSplitPane sp ;
	public void addControls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		tab=new JTabbedPane();
		
		JPanel pnTab1 = new JPanel();
		pnTab1.setBackground(Color.BLUE);
		JPanel pnTab2 = new JPanel();
		pnTab2.setBackground(Color.RED);
		JPanel pnTab3 = new JPanel();
		pnTab3.setBackground(Color.GREEN);
		
		tab.add(pnTab1,"Cấu hình");
		tab.add(pnTab2,"Cài đặt");
		tab.add(pnTab3,"Trợ giúp");
		
		pnMain.add(tab);
		Container ct = getContentPane();
		ct.add(pnMain);
		
	}
	public void showWindow() {
		this.setSize(400,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
