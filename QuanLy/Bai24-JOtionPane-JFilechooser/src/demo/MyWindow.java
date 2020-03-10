package demo;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.MenuBar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileFilter;



public class MyWindow extends JFrame {
	
	public MyWindow(String title) {
		super(title);
		addControls();
		addEvents();
		showWindow();
	}
	JMenuBar menuBar;
	JMenu menuOption;
	JMenuItem menuOptionExit;
	JMenuItem menuOptionOpen;
	JMenuItem menuOptionSave;
	
	JTextArea txtData;
	JFileChooser chooser;
	public void addControls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BorderLayout());
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuOption = new JMenu("Option");
		menuBar.add(menuOption);
		
		menuOptionOpen = new JMenuItem("Open");
		menuOptionSave = new JMenuItem("Save"); 
		menuOptionExit = new JMenuItem("Exit");
		
		menuOption.add(menuOptionOpen);
		menuOption.add(menuOptionSave);
		menuOption.addSeparator();
		menuOption.add(menuOptionExit);
		
		txtData = new JTextArea();
		txtData.setLineWrap(true);
		txtData.setWrapStyleWord(true);
		JScrollPane sc = new JScrollPane(txtData, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	
		pnMain.add(sc);
		
		Container ct = getContentPane();
		ct.add(pnMain);
		
		chooser=new JFileChooser();
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				
				return "Chọn file .txt";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".txt");
			}
		});
		chooser.setFileFilter(new FileFilter() {
			
			@Override
			public String getDescription() {
				// TODO Auto-generated method stub
				return "Chọn file .Doc|.Docx";
			}
			
			@Override
			public boolean accept(File f) {
				// TODO Auto-generated method stub
				return f.getAbsolutePath().endsWith(".doc")||f.getAbsolutePath().endsWith(".docx");
			}
		});
	}
	public void addEvents() {
		menuOptionExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThoatPhanMem();
				
			}
		});
		menuOptionOpen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyOpenFile();
			}
		});
		menuOptionSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLySave();
				
			}
		});
	}
	protected void xuLySave() {
		if(chooser.showSaveDialog(null)==JFileChooser.APPROVE_OPTION) {
			String txt = txtData.getText();
			try {
				FileOutputStream fos = new FileOutputStream(chooser.getSelectedFile());
				OutputStreamWriter osw = new OutputStreamWriter(fos,"UTF-8");
				osw.write(txt);
				osw.close();
				fos.close();
				JOptionPane.showMessageDialog(null, "Lưu thành công !");
				
			}
			catch (Exception e) {
			
			}
		}
	}
	protected void xuLyOpenFile() {
		if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
			try {
				File selectedFile = chooser.getSelectedFile();
				FileInputStream fis = new FileInputStream(selectedFile);
				java.io.InputStreamReader isr = new java.io.InputStreamReader(fis,"UTF-8");
				BufferedReader br = new BufferedReader(isr);
				String line = br.readLine();
				StringBuilder builder = new StringBuilder();
				while(line!=null) {
					builder.append(line);
					line = br.readLine();
				}
				br.close();
				isr.close();
				fis.close();
				txtData.setText(builder.toString());
			}
			catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	protected void xuLyThoatPhanMem() {
		int ret = JOptionPane.showConfirmDialog(null, "Are you exit program ?","Warning",JOptionPane.YES_NO_OPTION);
		if(ret==JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	public void showWindow() {
		this.setSize(400,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
}
