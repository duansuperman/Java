package layout;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class BorderLayout extends JFrame {

	public BorderLayout(String title) {
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
		JPanel jp = new JPanel();
		jp.setLayout(new java.awt.BorderLayout());
		
		JPanel jpNorth =  new JPanel();
		jpNorth.setBackground(Color.RED);
		jpNorth.setPreferredSize(new Dimension(0,100));
		JPanel jpSouth =  new JPanel();
		jpSouth.setBackground(Color.BLUE);
		JPanel jpWest = new JPanel();
		jpWest.setPreferredSize(new Dimension(100,0));
		jpWest.setBackground(Color.YELLOW);
		JPanel jpEast = new JPanel();
		jpEast.setBackground(Color.PINK);
		JPanel jpCenter = new JPanel();
		jpCenter.setBackground(Color.ORANGE);
		
		
		jp.add(jpNorth, java.awt.BorderLayout.NORTH);
		jp.add(jpSouth,java.awt.BorderLayout.SOUTH);
		jp.add(jpWest,java.awt.BorderLayout.WEST);
		jp.add(jpEast, java.awt.BorderLayout.EAST);
		jp.add(jpCenter, java.awt.BorderLayout.CENTER);
		Container c= getContentPane();
		c.add(jp);
	}
}
