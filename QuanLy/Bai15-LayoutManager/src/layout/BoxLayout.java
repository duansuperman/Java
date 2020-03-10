package layout;


import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class BoxLayout extends JFrame {
	public BoxLayout(String title) {
		super(title);
		addControls();
		showWindow();
		
	}
	public void showWindow() {
		this.setSize(500,400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	public void addControls() {
		JPanel jP = new JPanel();
		jP.setLayout(new javax.swing.BoxLayout(jP, javax.swing.BoxLayout.X_AXIS));
		JButton bt1= new JButton("Button 1");
		JButton bt2= new JButton("Button 2");
		JButton bt3= new JButton("Button 3");
		JButton bt4= new JButton("Button 4");
		JButton bt5= new JButton("Button 5");
	
		
		jP.add(bt1);
		jP.add(bt2);
		jP.add(bt3);
		jP.add(bt4);
		jP.add(bt5);
		Container c = getContentPane();
		c.add(jP);
		
	}

}
