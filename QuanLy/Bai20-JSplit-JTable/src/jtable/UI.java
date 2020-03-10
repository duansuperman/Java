package jtable;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class UI extends JFrame {
	public UI(String title) {
		super(title);
		addControls();
		addEvents();
		myWindow();
	}
	DefaultTableModel dtm;
	JTable tb;
	JButton btnThem;
	JButton btnXoa;
	JButton btnThongTin;
	public void addControls() {
		JPanel pnMain= new JPanel();
		pnMain.setLayout(new BorderLayout());
		
		JPanel pnLeft = new JPanel(new BorderLayout());
		pnLeft.setPreferredSize(new Dimension(300, 0));
		JPanel pnRight = new JPanel();
		
		JSplitPane spMain = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,pnLeft,pnRight);
		pnMain.add(spMain);
		
		dtm = new DefaultTableModel();
		dtm.addColumn("Mã");
		dtm.addColumn("Tên");
		dtm.addColumn("Quê");
		
		String []row1= {"nv1","Nguyễn Văn Tèo","Quảng Ngãi"};
		String []row2= {"nv2","Nguyễn Minh Tý","Quảng Ngãi"};
		String []row3= {"nv3","Nguyễn Thị Mèo","Quảng Ngãi"};
		
		dtm.addRow(row1);
		dtm.addRow(row2);
		dtm.addRow(row3);
		
		tb = new JTable(dtm);
		
		pnLeft.add(tb,BorderLayout.CENTER);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btnThem=new JButton("Thêm");
		btnXoa = new JButton("Xóa");
		btnThongTin = new JButton("Thông tin");
		pnButton.add(btnThem);
		pnButton.add(btnXoa);
		pnButton.add(btnThongTin);
		
		pnLeft.add(pnButton,BorderLayout.SOUTH);
		
		Container ct = getContentPane();
		ct.add(pnMain);
	}
	public void addEvents() {
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyXoa();
				
			}
		});;
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThem();
			}
		});
		btnThongTin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThongTin();
			}
		});
	}
	protected void xuLyThongTin() {
		if(tb.getSelectedRow()==-1) return ;
		int row = tb.getSelectedRow();
		String ten=tb.getValueAt(row, 1)+"";
		String ma = tb.getValueAt(row, 0)+"";
		String que = tb.getValueAt(row, 2)+"";
		JOptionPane.showMessageDialog(null, ma+"\n"+ten+"\n"+que);
	}
	protected void xuLyThem() {
		Vector<String> vt = new Vector<String>();
		vt.add("Mã xyz");
		vt.add("Tên xyz");
		vt.add("Quê xyz");
		
		dtm.addRow(vt);
	}
	protected void xuLyXoa() {
		if(tb.getSelectedRow()==-1) return ;
		dtm.removeRow(tb.getSelectedRow());
	}
	public void myWindow() {
		this.setSize(600,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
