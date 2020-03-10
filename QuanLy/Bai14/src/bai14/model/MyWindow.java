package bai14.model;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyWindow extends JFrame {
	public MyWindow(String title) {
		super(title);
	}
	public void addControl() {
		//Lay lop chua chua cua so ra
		Container c = getContentPane();
		JPanel p = new JPanel();
		p.setBackground(Color.GREEN);
		JButton bt = new JButton("Day la nut lenh");
		p.add(bt);
		c.add(p);
	}
	public void showWindow() {
		this.setSize(500, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
