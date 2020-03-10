package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class MyWindow extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public MyWindow(String title) {
		super(title);
		addControls();
		addEvents();
		
		showWindow();
	}
	
	JMenuBar menuBar;
	JMenu menuAdvanced;
	JMenu menuHelp;
	
	JMenuItem menuAdvancedEdit;
	JMenuItem menuAdvancedRemove;
	JMenuItem menuAdvancedNew;
	
	JMenuItem menuHelpUser;
	JButton btnComponent1;
	JButton btnComponent2;
	
	JMenuItem menuItemClick;
	JMenuItem menuItemAdd;
	
	JButton btnChoose;
	
	//ToolBar
	JToolBar toolBar;
	public void addControls() {

		menuBar = new  JMenuBar();
		setJMenuBar(menuBar);
		
		menuAdvanced = new JMenu("Advanced");
		menuHelp = new JMenu("Help");
		menuBar.add(menuAdvanced);
		menuBar.add(menuHelp);
		
		menuAdvancedNew = new JMenuItem("New");
		menuAdvancedEdit = new JMenuItem("Edit");
		menuAdvancedEdit.setAccelerator(KeyStroke.getKeyStroke('N', Toolkit.getDefaultToolkit ().getMenuShortcutKeyMask()));
		menuAdvancedRemove = new JMenuItem("Remove");
		
		menuAdvanced.add(menuAdvancedNew);
		menuAdvanced.add(menuAdvancedEdit);
		menuAdvanced.add(menuAdvancedRemove);
		
		menuHelpUser = new JMenuItem("User");
		menuHelp.add(menuHelpUser);
		
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		btnComponent1 = new JButton("Nhấn vào đây !");
		btnComponent2 = new JButton("Nhấn vào đây !");
		
		pnMain.add(btnComponent1,BorderLayout.WEST);
		
		pnMain.add(btnComponent2,BorderLayout.EAST);
		toolBar = new JToolBar("ToolBar đây nè");
		JButton btn1 = new JButton("Btn1");
		JButton btn2 = new JButton("Btn2");
		
		toolBar.add(btn1);
		toolBar.add(btn2);
		
		JPanel pnToolBar = new JPanel();
		pnToolBar.setLayout(new BorderLayout());
		
		pnToolBar.add(toolBar,BorderLayout.NORTH);
		pnMain.add(pnToolBar,BorderLayout.NORTH);
		Container ct = getContentPane();
		ct.add(pnMain);
		
	}
	public void addEvents() {
		menuAdvancedEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Bạn đang chọn tác Edit");
			}
		});
		btnComponent1.addMouseListener(new PopClickListener());
		btnComponent2.addMouseListener(new PopClickListener());
	}
	public void showWindow() {
		this.setSize(400,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	//Bước 1: Tạo 1 Lớp PopUp kế thừa từ JPopupMenu

	class PopUpDemo extends JPopupMenu {
		//Context menu
		
	    public PopUpDemo(){
	        menuItemClick = new JMenuItem("Click Me!");
	        menuItemAdd = new JMenuItem("Add new");
	        
	        add(menuItemClick);
	        add(menuItemAdd);
	        menuItemClick.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(btnChoose!=null) {
						btnChoose.setBackground(Color.RED);
					}
					
				}
			});
	        menuItemAdd.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					if(btnChoose!=null) {
						btnChoose.setBackground(Color.BLUE);
					}
					
				}
			});
	    }
	    
	}
	
	//Bước 2 Tạo 1 Lớp để lắng sự kiện nhấn chuột

	class PopClickListener extends MouseAdapter {
	    public void mousePressed(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	        
	    }

	    public void mouseReleased(MouseEvent e){
	        if (e.isPopupTrigger())
	            doPop(e);
	    }

	    private void doPop(MouseEvent e){
	        PopUpDemo menu = new PopUpDemo();
	        btnChoose = (JButton)e.getComponent();
	        menu.show(e.getComponent(), e.getX(), e.getY());
	    }
	}

}



