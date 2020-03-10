package jsplitpane;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class UI extends JFrame {
	
	public UI(String title) {
		super(title);
		addControls();
		showWindow();
	}
	public void addControls() {
		Container ct = getContentPane();
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		JPanel pnLeft = new JPanel();
		pnLeft.setPreferredSize(new Dimension(200,0));
		JPanel pnRight = new JPanel(new BorderLayout());
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		sp.setOneTouchExpandable(true);
		
		JPanel pnRight1 = new JPanel();
		JPanel pnRight2 = new JPanel();
		
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pnRight1,pnRight2);
		spRight.setOneTouchExpandable(true);
		pnRight.add(spRight);
		
		pnRight1.setPreferredSize(new Dimension(0,175));
		
		pnMain.add(sp);
		ct.add(pnMain);
		
	}
	public void showWindow() {
		this.setSize(400,350);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
