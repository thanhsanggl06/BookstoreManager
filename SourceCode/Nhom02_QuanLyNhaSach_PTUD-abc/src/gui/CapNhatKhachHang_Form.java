package gui;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CapNhatKhachHang_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tablekh;
	private JScrollPane src_khachhang;
	private JLabel lbl_maKH;
	private JLabel lbl_tenKH;
	private JTextField txt_maKH;
	private JTextField txt_tenKH;
	private JLabel lbl_background;
	private JLabel lbl_Tieude;
	private JLabel lbl_ngaysinh;
	private JLabel lbl_sdt;
	private JTextField txt_sdt;
	private JDateChooser dateChooser;
	private JButton btn_themkh;
	private JButton btn_xoakh;
	private JButton btn_suakh;
	private JButton btn_xoatrangkh;
	private JButton btn_xemdskh;
	private JButton btn_xuatdskh;
	private JLabel lbl_gioiTinh;
	private JComboBox comboBox_gt;
	private KhachHang_DAO kh_dao = new KhachHang_DAO();

	public CapNhatKhachHang_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã Khách hàng", "Tên Khách hàng", "Ngày sinh","Giới tính", "Số ĐT",};
		modelkh = new DefaultTableModel(headers, 0);
		tablekh = new JTable(modelkh);
		tablekh.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tablekh.getSelectedRow();
				txt_maKH.setText(tablekh.getValueAt(row, 0).toString());
				txt_tenKH.setText(tablekh.getValueAt(row, 1).toString());
				txt_sdt.setText(tablekh.getValueAt(row, 4).toString());
				comboBox_gt.setSelectedItem(tablekh.getValueAt(row, 3).toString());
				java.util.Date ns = (java.util.Date) tablekh.getValueAt(row, 2);
				dateChooser.setDate(ns);
			}
		});
		src_khachhang = new JScrollPane(tablekh);
		src_khachhang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		src_khachhang.setBounds(10, 303, 1638, 508);
		///
		

				

					
		add(src_khachhang);
		
		JPanel pnl_thongtinkh = new JPanel();
		pnl_thongtinkh.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(10, 76, 1638, 301);
		pnl_thongtinkh.setBackground(Color.WHITE);
		pnl_thongtinkh.setToolTipText("Thông tin tìm kiếm");
		pnl_thongtinkh.setBounds(10, 59, 1638, 233);
		add(pnl_thongtinkh);
		pnl_thongtinkh.setLayout(null);
		
		lbl_maKH = new JLabel("Mã khách hàng   :");
		lbl_maKH.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_maKH.setBounds(33, 37, 257, 52);
		pnl_thongtinkh.add(lbl_maKH);
		
		lbl_tenKH = new JLabel("Tên khách hàng  :");
		lbl_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_tenKH.setBounds(616, 39, 191, 48);
		pnl_thongtinkh.add(lbl_tenKH);
		
		txt_maKH = new JTextField();
		txt_maKH.setBounds(225, 52, 321, 32);
		pnl_thongtinkh.add(txt_maKH);
		txt_maKH.setColumns(10);
		
		txt_tenKH = new JTextField();
		txt_tenKH.setBounds(817, 52, 321, 32);
		pnl_thongtinkh.add(txt_tenKH);
		txt_tenKH.setColumns(10);
		
		lbl_ngaysinh = new JLabel("Ngày sinh          :");
		lbl_ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_ngaysinh.setBounds(33, 99, 192, 52);
		pnl_thongtinkh.add(lbl_ngaysinh);
		
		lbl_sdt = new JLabel("Số điện thoại      :");
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_sdt.setBounds(616, 101, 191, 48);
		pnl_thongtinkh.add(lbl_sdt);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(817, 115, 321, 32);
		pnl_thongtinkh.add(txt_sdt);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(225, 115, 321, 32);
		pnl_thongtinkh.add(dateChooser);
		
		btn_themkh = new JButton("Thêm");
		btn_themkh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn_themkh.getText().equals("Thêm")) {
					txt_sdt.setText("");
					txt_tenKH.setText("");
					dateChooser.setDate(null);
					btn_themkh.setText("Lưu");
					btn_themkh.setIcon(new ImageIcon("images\\btnLuu.jpg"));
					enableTextField();
					btn_suakh.setEnabled(false);
					btn_xoakh.setEnabled(false);
					btn_xuatdskh.setBackground(Color.red);
					try {
						txt_maKH.setText(kh_dao.phatSinhMaKH());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					if(ktraTxt()) {
						String maKh = txt_maKH.getText();
						String tenKh = txt_tenKH.getText();
						String sdt = txt_sdt.getText();
						java.util.Date ngay = dateChooser.getDate();
						Date ngaySinh = new Date(ngay.getTime());
						String gioiTinh =  comboBox_gt.getSelectedItem().toString();
						KhachHang kh = new KhachHang(maKh, tenKh, ngaySinh, gioiTinh, sdt);
						btn_themkh.setText("Thêm");
						btn_themkh.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
						disableTextField();
						btn_suakh.setEnabled(true);
						btn_xoakh.setEnabled(true);
						btn_xuatdskh.setBackground(Color.LIGHT_GRAY);
						xoaTrang();
						try {
							if(kh_dao.addKhachHang(kh)) {
								JOptionPane.showMessageDialog(null, "Thêm Thành Công");
							}else {
								JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
							}
						} catch (HeadlessException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
				}
			}
		});
		btn_themkh.setForeground(Color.WHITE);
		btn_themkh.setBackground(Color.WHITE);
		btn_themkh.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
		btn_themkh.setBounds(1230, 24, 191, 52);
		//
		btn_themkh.setBorderPainted(false); ///xóa khung button 
		//
		pnl_thongtinkh.add(btn_themkh);
		
		btn_xoakh = new JButton("");
		btn_xoakh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablekh.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn Khách Hàng Cần Xóa");
				}else {
					try {
						if(kh_dao.deleteKhachHang(tablekh.getValueAt(tablekh.getSelectedRow(), 0).toString())) {
							JOptionPane.showMessageDialog(null, "Xóa thành công");
							modelkh.removeRow(tablekh.getSelectedRow());
						}else {
							JOptionPane.showMessageDialog(null, "Xóa thất bại");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tablekh.clearSelection();
				}
			}
		});
		btn_xoakh.setForeground(Color.WHITE);
		btn_xoakh.setBackground(Color.WHITE);
		btn_xoakh.setBorderPainted(false);
		btn_xoakh.setIcon(new ImageIcon("images_button\\btnXoa.jpg"));
		btn_xoakh.setBounds(1230, 87, 191, 56);
		pnl_thongtinkh.add(btn_xoakh);
		
		btn_suakh = new JButton("Sửa");
		btn_suakh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tablekh.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn khách hàng muốn sửa thông tin");
				}else {
					if(btn_suakh.getText().equals("Sửa")) {
						btn_themkh.setEnabled(false);
						btn_xoakh.setEnabled(false);
						btn_xuatdskh.setEnabled(true);
						btn_suakh.setText("Lưu");
						btn_suakh.setIcon(new ImageIcon("images\\btnLuu.jpg"));
						txt_sdt.setEditable(true);
						txt_tenKH.setEditable(true);
						comboBox_gt.setEnabled(true);
						dateChooser.setEnabled(true);
						btn_xuatdskh.setBackground(Color.red);
					}else {
						if(ktraTxt()) {
							
							String makh = txt_maKH.getText().toString();
							String tenkh = txt_tenKH.getText().toString();
							String sdt = txt_sdt.getText().toString();
							String gt = comboBox_gt.getSelectedItem().toString();
							java.util.Date ngay = dateChooser.getDate();
							Date ngaySinh = new Date(ngay.getTime());
							KhachHang kh = new KhachHang(makh, tenkh, ngaySinh, gt, sdt);
							try {
								if(kh_dao.updateKhachHang(kh)) {
									JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
								}else {
									JOptionPane.showMessageDialog(null, "Cập Nhật Thất Bại");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							btn_themkh.setEnabled(true);
							btn_xoakh.setEnabled(true);
							btn_xuatdskh.setEnabled(false);
							btn_suakh.setText("Sửa");
							btn_suakh.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
							txt_sdt.setEditable(false);
							txt_tenKH.setEditable(false);
							comboBox_gt.setEnabled(false);
							dateChooser.setEnabled(false);
							btn_xuatdskh.setBackground(Color.LIGHT_GRAY);
							tablekh.clearSelection();
							xoaTrang();
							try {
								docDuLieuDatabase();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
					}
				}
				
			}
		});
		btn_suakh.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
		btn_suakh.setForeground(Color.WHITE);
		btn_suakh.setBackground(Color.WHITE);
		btn_suakh.setBorderPainted(false);
		btn_suakh.setBounds(1431, 24, 191, 52);
		pnl_thongtinkh.add(btn_suakh);
		
		btn_xoatrangkh = new JButton("");
		btn_xoatrangkh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		btn_xoatrangkh.setIcon(new ImageIcon("images_button\\btnXoaTrang.jpg"));
		btn_xoatrangkh.setForeground(Color.WHITE);
		btn_xoatrangkh.setBorderPainted(false);
		btn_xoatrangkh.setBackground(Color.WHITE);
		btn_xoatrangkh.setBounds(1431, 87, 191, 56);
		pnl_thongtinkh.add(btn_xoatrangkh);
		
		btn_xemdskh = new JButton("");
		btn_xemdskh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					docDuLieuDatabase();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_xemdskh.setIcon(new ImageIcon("images_button\\btnXemDS.jpg"));
		btn_xemdskh.setForeground(Color.WHITE);
		btn_xemdskh.setBorderPainted(false);
		btn_xemdskh.setBackground(Color.WHITE);
		btn_xemdskh.setBounds(1230, 158, 191, 56);
		pnl_thongtinkh.add(btn_xemdskh);
		
		btn_xuatdskh = new JButton("Hủy");
		btn_xuatdskh.setBackground(Color.LIGHT_GRAY);
		btn_xuatdskh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_suakh.setText("Sửa");
				btn_suakh.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
				btn_themkh.setText("Thêm");
				btn_themkh.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
				btn_xuatdskh.setBackground(Color.LIGHT_GRAY);
				btn_themkh.setEnabled(true);
				btn_suakh.setEnabled(true);
				btn_xoakh.setEnabled(true);
				disableTextField();
				xoaTrang();
			}
		});
//		btn_xuatdskh.setIcon(new ImageIcon("images_button\\XuatDanhSach.png"));
		btn_xuatdskh.setForeground(Color.BLACK);
		btn_xuatdskh.setBorderPainted(false);
//		btn_xuatdskh.setBackground(Color.WHITE);
		btn_xuatdskh.setBounds(1431, 158, 191, 56);
		pnl_thongtinkh.add(btn_xuatdskh);
		
		lbl_gioiTinh = new JLabel("Giới Tính            :");
		lbl_gioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_gioiTinh.setBounds(33, 162, 192, 52);
		pnl_thongtinkh.add(lbl_gioiTinh);
		
		comboBox_gt = new JComboBox();
		comboBox_gt.setBounds(225, 177, 114, 32);
		pnl_thongtinkh.add(comboBox_gt);
		comboBox_gt.addItem("Nam");
		comboBox_gt.addItem("Nữ");
		
		
		lbl_Tieude = new JLabel("Cập nhật thông tin  khách hàng");
		lbl_Tieude.setForeground(Color.WHITE);
		lbl_Tieude.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_Tieude.setBounds(46, 0, 589, 62);
		add(lbl_Tieude);
		
		lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_background.setBounds(0, 0, 1658, 822);
		add(lbl_background);
		guithemkh();
		disableTextField();
//		try {
//			docDuLieuDatabase();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

	}

	private void guithemkh() {
		// TODO Auto-generated method stub
		jLabel1 = new javax.swing.JLabel();
		/// jButton1 = new javax.swing.JButton();
		// jTextField1 = new javax.swing.JTextField();
		setSize(1658, 822);
//
//		jTextField1.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				jTextField1ActionPerformed(evt);
//			}
//		});
	}
	private void docDuLieuDatabase() throws SQLException{
		// TODO Auto-generated method stub
		while (tablekh.getRowCount() != 0) {
			modelkh.removeRow(0);
		}
	ArrayList<KhachHang> dskh = kh_dao.getAllKhachHang();
	for (KhachHang kh : dskh ) {
		modelkh.addRow(new Object[] {kh.getMaKH(), kh.getTenKH(), kh.getNgaySinh(), kh.getGioiTinh(),kh.getSoDienThoai()});
	
		}
	}
	
	private void disableTextField() {
		txt_maKH.setEditable(false);
		txt_tenKH.setEditable(false);
		txt_sdt.setEditable(false);
		comboBox_gt.setEnabled(false);
		dateChooser.setEnabled(false);
		btn_xuatdskh.setEnabled(false);
		
	}
	
	private void enableTextField() {
		txt_tenKH.setEditable(true);
		txt_sdt.setEditable(true);
		comboBox_gt.setEnabled(true);
		dateChooser.setEnabled(true);
		btn_xuatdskh.setEnabled(true);
	}
	
	private void xoaTrang() {
		if(btn_suakh.getText() == "Sửa" && btn_themkh.getText()== "Thêm") {
			txt_maKH.setText("");
			while (tablekh.getRowCount() != 0) {
				modelkh.removeRow(0);
			}
		}
		
		txt_sdt.setText("");
		txt_tenKH.setText("");
		dateChooser.setDate(null);
	}
	private boolean ktraTxt() {
		String tenkh = txt_tenKH.getText().trim();
		String sdt = txt_sdt.getText().trim();
		
		String tenkhkdau = removeAccent(tenkh);
		java.util.Date ns = dateChooser.getDate();
		
		
		
		
		
		
		if(!(tenkhkdau.length()>0 && tenkhkdau.matches("[a-zA-Z' ]+"))) {
			thongBao("Eror : Họ tên không hợp lệ", txt_tenKH);
			return false;
		}
		if(!(sdt.length()>0 && sdt.matches("^0[0-9]{9}"))) {
			thongBao("Error : SDT có dạng 0xxxxxxxxx", txt_sdt);
			return false;
			
		}
		
		if(ns == null) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống");
			dateChooser.grabFocus();
			return false;
		}
		java.util.Date date = new java.util.Date();
		
		if(ns.after(date)) {
			JOptionPane.showMessageDialog(null, "Ngày Sinh Không Hợp Lệ");
			return false;
		}
		
		return true;
	}
	
	public void thongBao(String er , JTextField txt) {
		JOptionPane.showMessageDialog(null, er);
		txt.selectAll();
		txt.requestFocus();
	}
	
	public static String removeAccent(String s) {
		  
		  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		  return pattern.matcher(temp).replaceAll("");
		 }
}
