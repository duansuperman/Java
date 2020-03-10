package demo;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.w3c.dom.ls.LSOutput;

public class Support extends JFrame{

	JComboBox<Integer> cbSo;
	JButton btOk ;
	JList<Integer> lSo;
	public Support(String title) {
		super(title);
		addControls();
		addEvents();
		showWindow();
	}
	public void addControls() {
		JPanel pnMain = new JPanel();
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.Y_AXIS));
		JPanel pnComBo = new JPanel();
		pnComBo.setLayout(new FlowLayout());
		cbSo = new JComboBox<Integer>();
		Random rd = new Random();
		for(int i=0;i<100;i++) {
			int k = rd.nextInt(100);
			cbSo.addItem(k);
		}
		cbSo.setSelectedIndex(2);
		cbSo.setSelectedItem(24);
		pnComBo.add(cbSo);
		
		//Jlist
		 JPanel pnJList = new JPanel();
		 pnJList.setLayout(new FlowLayout());
		 lSo = new JList<Integer>();
		 Vector<Integer> vtSo = new Vector<Integer>(); 
		 for(int i =0;i<500;i++) {
			 vtSo.add(i);
		 }
		lSo.setListData(vtSo);
		
		JScrollPane sc = new JScrollPane(lSo,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnJList.add(sc);
		
		JPanel pnBtOK = new JPanel();
		pnBtOK.setLayout(new FlowLayout(FlowLayout.RIGHT));
		btOk = new JButton("OK");
		
		pnBtOK.add(btOk);
		
		Container ct = getContentPane();
		
		pnMain.add(pnComBo);
		pnMain.add(pnJList);
		pnMain.add(pnBtOK);
		
		ct.add(pnMain);
	}
	public void addEvents() {
		cbSo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = cbSo.getSelectedIndex();
				if(index!=-1) {
					Object value = cbSo.getSelectedItem();
					int change = (int)value;
					JOptionPane.showMessageDialog(null, "Chỉ số của giá trị đang chọn = "+index+" Gía trị được chọn = "+value);
				}
				
			}
		});
		
		btOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int index = lSo.getSelectedIndex();
				int k[] = lSo.getSelectedIndices();
				Object h[]=lSo.getSelectedValues();
				int value = lSo.getSelectedValue();
				if(index!=-1) {
					JOptionPane.showMessageDialog(null, "Chỉ số của giá trị được chọn = "+index+" Gía trị được chọn  = "+value+" "+k[0]+ " "+h[0]);
				}
				
			}
		});
	}
	public void showWindow() {
		this.setSize(400,300);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
