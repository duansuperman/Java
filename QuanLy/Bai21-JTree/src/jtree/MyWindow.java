package jtree;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class MyWindow extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	DefaultMutableTreeNode root;
	JTree tree;
	public MyWindow(String title) {
		super(title);
		addControls();
		addEvents();
		showWindow();
	}
	public void addControls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		JPanel pnLeft = new JPanel(new BorderLayout());
		pnLeft.setPreferredSize(new Dimension(150,0));
		JPanel pnRight = new JPanel();
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		
		pnMain.add(sp);
		
		root = new DefaultMutableTreeNode("Thư mục của tôi");
		tree = new JTree(root);
		
		pnLeft.add(tree);
		
		DefaultMutableTreeNode nodeAmNhac = new DefaultMutableTreeNode("Âm nhạc");
		DefaultMutableTreeNode nodeTiengAnh = new DefaultMutableTreeNode("Tiếng Anh");
		DefaultMutableTreeNode nodeToanHoc = new DefaultMutableTreeNode("Toán Học");
		DefaultMutableTreeNode nodeMyThuat = new DefaultMutableTreeNode("Mỹ Thuật");
		
		root.add(nodeAmNhac);
		root.add(nodeTiengAnh);
		root.add(nodeToanHoc);
		root.add(nodeMyThuat);
		
		tree.expandRow(0);
		
		DefaultMutableTreeNode nodeToic = new DefaultMutableTreeNode("Toic");
		DefaultMutableTreeNode nodeIelts = new DefaultMutableTreeNode("Ielts");
		DefaultMutableTreeNode nodeGiaoTiep = new DefaultMutableTreeNode("GiaoTiếp");
		
		nodeTiengAnh.add(nodeToic);
		nodeTiengAnh.add(nodeIelts);
		nodeTiengAnh.add(nodeGiaoTiep);
		
		tree.expandRow(2);
		Container ct = getContentPane();
		ct.add(pnMain);
		
	}
	public void addEvents() {
		tree.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Object o = tree.getLastSelectedPathComponent();
				DefaultMutableTreeNode nodeO = (DefaultMutableTreeNode) o;
				JOptionPane.showMessageDialog(null, nodeO);
			}
		});
	}
	public void showWindow() {
		this.setSize(400,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
