package learnjava.com.ui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import org.hsqldb.lib.ArrayCounter;

import learnjava.com.driver.CoQuanBanHanhDriver;
import learnjava.com.driver.CongVanDriver;
import learnjava.com.driver.LoaiCongVanDriver;
import learnjava.com.driver.NguoiDungDriver;
import learnjava.com.model.CoQuanBanHanh;
import learnjava.com.model.CongVan;
import learnjava.com.model.LoaiCongVan;
import learnjava.com.model.NguoiDung;


public class CongVanUI extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CongVanUI(String title) {
		this.setTitle(title);
		addControls();
		hienThiCongVan();
		addEvents();
		showWindow();
		
		
	}
	DefaultTableModel dtm;
	JTable tblCongVan;
	JComboBox<CoQuanBanHanh> cbCoQuan;
	JComboBox<NguoiDung> cbNguoiDung;
	JComboBox<LoaiCongVan> cbLoaiCongVan;
	JLabel lblId ;
	JButton btnAdd, btnDelete, btnUpdate;
	JTextArea txtNoiDung;
	CongVan cv =null;

	private void hienThiCongVan() {
		ArrayList<CongVan> arrCongVan = CongVanDriver.getAllData();
		dtm.setRowCount(0);
		for(CongVan cv : arrCongVan) {
			Vector<Object> vec= new Vector<Object>();
			vec.add(cv.getId());
			vec.add(LoaiCongVanDriver.getDataById(cv.getLoaiCongVanId()).getTenCongVan());
			vec.add(CoQuanBanHanhDriver.getDataById(cv.getCoQuanId()).getTenCoQuan());
			vec.add(NguoiDungDriver.getDataById(cv.getNguoiNhanId()).getHoTen());
			dtm.addRow(vec);
		}
	}
	public void addControls() {
		Container ct = getContentPane();
		ct.setLayout(new BorderLayout());
		
		JPanel pnLeft = new JPanel();
		pnLeft.setLayout(new BorderLayout());
		pnLeft.setPreferredSize(new Dimension(400,0));
		
		JPanel pnRight = new JPanel();
		pnRight.setLayout(new BorderLayout());
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnLeft, pnRight);
		
		dtm = new DefaultTableModel();
		dtm.addColumn("ID");
		dtm.addColumn("Loại công văn");
		dtm.addColumn("Cơ quan ban hành");
		dtm.addColumn("Người nhận");
		tblCongVan = new JTable(dtm);
		JScrollPane sc = new JScrollPane(tblCongVan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pnLeft.add(sc);
		
		JPanel pnTopRight =new JPanel();
		pnTopRight.setLayout(new BoxLayout(pnTopRight,BoxLayout.Y_AXIS));
		JPanel pnBottomRight = new JPanel();
		pnBottomRight.setLayout(new BorderLayout());
		JSplitPane spRight = new JSplitPane(JSplitPane.VERTICAL_SPLIT,pnTopRight,pnBottomRight);
		pnRight.add(spRight);
		
		pnTopRight.setPreferredSize(new Dimension(0,250));
		
		JPanel pnCoQuan =new JPanel();
		pnCoQuan.setLayout(new FlowLayout());
		cbCoQuan = new JComboBox<CoQuanBanHanh>();
		pnCoQuan.add(cbCoQuan);
		
		JPanel pnNguoiDung =new JPanel();
		pnNguoiDung.setLayout(new FlowLayout());
		cbNguoiDung = new JComboBox<NguoiDung>();
		pnNguoiDung.add(cbNguoiDung);
		
		JPanel pnLoaiCongVan = new JPanel();
		pnLoaiCongVan.setLayout(new FlowLayout());
		cbLoaiCongVan = new JComboBox<LoaiCongVan>();
		pnLoaiCongVan.add(cbLoaiCongVan);
		lblId = new JLabel();
		
		
		
		pnTopRight.add(lblId);
		pnTopRight.add(pnCoQuan);
		pnTopRight.add(pnLoaiCongVan);
		pnTopRight.add(pnNguoiDung);
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout());
		btnAdd = new JButton("Thêm");
		
		
		JPanel pnDelete = new JPanel();
		pnDelete.setLayout(new FlowLayout());
		btnDelete = new JButton("Xóa");
		
		btnUpdate = new JButton("Cập nhật");
		
		pnButton.add(btnAdd);
		pnButton.add(btnDelete);
		pnButton.add(btnUpdate);
		pnBottomRight.add(pnButton);
		txtNoiDung = new JTextArea();
		pnTopRight.add(txtNoiDung);
		
		ct.add(sp);
	}
	public void addEvents() {
		tblCongVan.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(tblCongVan.getSelectedRow()<0) return ;
				int row = tblCongVan.getSelectedRow();
				lblId.setText(tblCongVan.getValueAt(row, 0).toString());
				
				int iD = Integer.parseInt(tblCongVan.getValueAt(row, 0).toString());
				cv  = CongVanDriver.getDataByById(iD);
				CoQuanBanHanh coQuan = CoQuanBanHanhDriver.getDataByTenCoQuan(
						tblCongVan.getValueAt(row, 2).toString());
			
				LoaiCongVan loaiCongVan = LoaiCongVanDriver.getDataByTenCongVan(
						tblCongVan.getValueAt(row, 1).toString());
				NguoiDung nguoiDung = NguoiDungDriver.getDataByHoTen(
						tblCongVan.getValueAt(row, 3).toString());
				
				ArrayList<LoaiCongVan> arrLoaiCongVan = LoaiCongVanDriver.getAllData();
				ArrayList<CoQuanBanHanh> arrCoQuan = CoQuanBanHanhDriver.getAllData();
				ArrayList<NguoiDung> arrNguoiDung = NguoiDungDriver.getAllData();
				
				cbCoQuan.removeAllItems();
				cbLoaiCongVan.removeAllItems();
				cbNguoiDung.removeAllItems();
				
				for(LoaiCongVan lcv : arrLoaiCongVan) {
				
					cbLoaiCongVan.addItem(lcv);
				}
				for(CoQuanBanHanh cq : arrCoQuan) {
					cbCoQuan.addItem(cq);
				}
				for(NguoiDung nd : arrNguoiDung) {
					cbNguoiDung.addItem(nd);
				}
				cbLoaiCongVan.setSelectedIndex(loaiCongVan.getiD()-1);
				cbCoQuan.setSelectedIndex(coQuan.getiD()-1);
				cbNguoiDung.setSelectedIndex(nguoiDung.getiD()-1);
				txtNoiDung.setText(cv.getGhiChu());
				
				
				cbCoQuan.setPreferredSize(cbNguoiDung.getPreferredSize());
				cbLoaiCongVan.setPreferredSize(cbNguoiDung.getPreferredSize());
			}
		});
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cv==null) return;
				CongVanDriver.deleteDataById(cv.getId());
				hienThiCongVan();
			}
		});
		btnUpdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cv == null) return;
				
				CoQuanBanHanh coQuan = (CoQuanBanHanh)cbCoQuan.getSelectedItem();
				NguoiDung nguoiDung = (NguoiDung)cbNguoiDung.getSelectedItem();
				LoaiCongVan loaiCongVan = (LoaiCongVan)cbLoaiCongVan.getSelectedItem();
				
				CongVanDriver.updateDataWithId(cv.getId(), txtNoiDung.getText(),
						coQuan.getiD(), nguoiDung.getiD(), loaiCongVan.getiD());
				hienThiCongVan();
			}
		});
	}
	public void showWindow() {
		this.setSize(800,400);
		this.setModal(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
