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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.sql.SQLException;
import java.text.Normalizer;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.NhaCungCap_DAO;
import entity.NhaCungCap;
import entity.NhanVien;

import javax.swing.UIManager;
import java.awt.event.MouseAdapter;

public class CapNhatNhaCungCap_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_ncc;
	private JScrollPane scr_ncc;
	private JLabel lbl_mancc;
	private JLabel lbl_tenncc;
	private JTextField txt_mancc;
	private JTextField txt_tenncc;
	private JLabel lbl_background;
	private JLabel lbl_ten;
	private JLabel lblNgySinh;
	private JLabel lbl_sdt;
	private JTextField txt_sdt;
	private JLabel lbl_anhnen;
	private JButton btn_them;
	private JButton btnXoa;
	private JButton btn_sua;
	private JButton btnXoat;
	private JTextField txt_email;
	private JLabel lblEmail_1;
	private JButton btnXem;
	private JButton btnHuy;
	private JPanel pnl_ncc;
	private JTextField txtDiaChi;
	private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();

	public CapNhatNhaCungCap_Form() {
		setBackground(SystemColor.control);
		setLayout(null);

		///
		String[] headers = { "Mã nhà cung cấp", "Tên nhà cấp", "Địa chỉ ", "Số điện thoại", "Email", };
		modelkh = new DefaultTableModel(headers, 0);
		tbl_ncc = new JTable(modelkh);
		tbl_ncc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl_ncc.getSelectedRow();
				txt_mancc.setText(tbl_ncc.getValueAt(row, 0).toString());
				txt_tenncc.setText(tbl_ncc.getValueAt(row, 1).toString());
				txt_sdt.setText(tbl_ncc.getValueAt(row, 3).toString());
				txtDiaChi.setText(tbl_ncc.getValueAt(row, 2).toString());
				txt_email.setText(tbl_ncc.getValueAt(row, 4).toString());
			}
		});
		tbl_ncc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		scr_ncc = new JScrollPane(tbl_ncc);
		scr_ncc.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách nhà cung cấp", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		scr_ncc.setBounds(10, 303, 1638, 508);
		///

		add(scr_ncc);

		pnl_ncc = new JPanel();
		pnl_ncc.setBorder(new TitledBorder(null, "Thông tin nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0, 0, 0)));
		pnl_ncc.setBackground(Color.WHITE);
		pnl_ncc.setToolTipText("Thông tin tìm kiếm");
		pnl_ncc.setBounds(10, 59, 1638, 233);
		add(pnl_ncc);
		pnl_ncc.setLayout(null);

		lbl_mancc = new JLabel("Mã nhà cung cấp :");
		lbl_mancc.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_mancc.setBounds(33, 37, 257, 52);
		pnl_ncc.add(lbl_mancc);

		lbl_tenncc = new JLabel("Tên nhà cung cấp :");
		lbl_tenncc.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_tenncc.setBounds(616, 39, 191, 48);
		pnl_ncc.add(lbl_tenncc);

		txt_mancc = new JTextField();
		txt_mancc.setBounds(225, 52, 321, 32);
		pnl_ncc.add(txt_mancc);
		txt_mancc.setColumns(10);

		txt_tenncc = new JTextField();
		txt_tenncc.setBounds(817, 52, 321, 32);
		pnl_ncc.add(txt_tenncc);
		txt_tenncc.setColumns(10);

		lblNgySinh = new JLabel("Địa chỉ               :");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNgySinh.setBounds(33, 99, 192, 52);
		pnl_ncc.add(lblNgySinh);

		lbl_sdt = new JLabel("Số điện thoại      :");
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_sdt.setBounds(33, 162, 178, 48);
		pnl_ncc.add(lbl_sdt);

		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(225, 175, 321, 32);
		pnl_ncc.add(txt_sdt);

		lblEmail_1 = new JLabel("Email                  :");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblEmail_1.setBounds(615, 99, 192, 52);
		pnl_ncc.add(lblEmail_1);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setColumns(10);
		txtDiaChi.setBounds(225, 106, 321, 38);
		pnl_ncc.add(txtDiaChi);

		lbl_anhnen = new JLabel("");
		lbl_anhnen.setIcon(new ImageIcon("images\\ACB.png"));
		lbl_anhnen.setBounds(190, 11, 497, 203);
		pnl_ncc.add(lbl_anhnen);

		btn_them = new JButton("Thêm");
		btn_them.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn_them.getText().equals("Thêm")) {
					btnHuy.setEnabled(true);
					btnHuy.setBackground(Color.red);
					try {
						txt_mancc.setText(ncc_dao.phatSinhMaNCC());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					txt_email.setEnabled(true);
					txt_sdt.setEnabled(true);
					txt_tenncc.setEnabled(true);
					txtDiaChi.setEnabled(true);
					btn_sua.setEnabled(false); 
					btnXoa.setEnabled(false);
					btn_them.setText("Lưu");
					btn_them.setIcon(new ImageIcon("images\\btnLuu.jpg"));
				}else {
					if(ktraTxt()) {
						themAction();
						txt_email.setEnabled(false);
						txt_sdt.setEnabled(false);
						txt_tenncc.setEnabled(false);
						txtDiaChi.setEnabled(false);
						btn_them.setText("Thêm");
						btn_them.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
						btn_sua.setEnabled(true); 
						btnXoa.setEnabled(true);
						btnHuy.setBackground(Color.gray);
						btnHuy.setEnabled(false);
					}
				}
			}
		});
		btn_them.setForeground(Color.WHITE);
		btn_them.setBackground(Color.WHITE);
		btn_them.setIcon(new ImageIcon("images_button\\THemHd.png"));
		btn_them.setBounds(1230, 37, 191, 52);
		//
		btn_them.setBorderPainted(false); /// xóa khung button
		//
		pnl_ncc.add(btn_them);

		btnXoa = new JButton("");
		btnXoa.setForeground(Color.WHITE);
		btnXoa.setBackground(Color.WHITE);
		btnXoa.setBorderPainted(false);
		btnXoa.setIcon(new ImageIcon("images_button\\Xoahd.png"));
		btnXoa.setBounds(1230, 99, 191, 56);
		pnl_ncc.add(btnXoa);

		btn_sua = new JButton("Sửa");
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_ncc.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn Nhà cung cấp cần sửa");
				}else {
					if(btn_sua.getText()=="Sửa") {
						btnHuy.setEnabled(true);
						btnHuy.setBackground(Color.red);
						txt_email.setEnabled(true);
						txt_sdt.setEnabled(true);
						txt_tenncc.setEnabled(true);
						txtDiaChi.setEnabled(true);
						btnXoa.setEnabled(false);
						btn_sua.setText("Lưu");
						btn_sua.setIcon(new ImageIcon("images\\btnLuu.jpg"));
					}else {
						if(ktraTxt()) {
							
							String mancc = txt_mancc.getText().trim().toString(); 
							String tenncc = txt_tenncc.getText().trim().toString();
							String diaChi = txtDiaChi.getText().trim().toString();
							String soDT = txt_sdt.getText().trim().toString(); 
							String email = txt_email.getText().trim().toString();
							NhaCungCap ncc = new NhaCungCap(mancc, tenncc, diaChi, soDT, email);
							try {
								if(ncc_dao.updateNhaCungCap(ncc)) {
									JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
								}else {
									JOptionPane.showMessageDialog(null, "Cập Nhật Thất Bại");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							txtDiaChi.setEditable(false);
							txt_email.setEditable(false);
							txt_sdt.setEditable(false);
							txt_tenncc.setEditable(false);
							btn_them.setEnabled(true);
							btnXoa.setEnabled(true);
							btnHuy.setEnabled(false);
							btnHuy.setBackground(Color.LIGHT_GRAY);
							txt_mancc.setText("");
							txt_email.setText("");
							txt_sdt.setText("");
							txt_tenncc.setText("");
							txtDiaChi.setText("");
							ncc = null;
							btn_sua.setText("Sửa");
							btn_sua.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
							tbl_ncc.clearSelection();
							
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
		btn_sua.setIcon(new ImageIcon("images_button\\SuaHd.png"));
		btn_sua.setForeground(Color.WHITE);
		btn_sua.setBackground(Color.WHITE);
		btn_sua.setBorderPainted(false);
		btn_sua.setBounds(1431, 37, 191, 52);
		pnl_ncc.add(btn_sua);

		btnXem = new JButton("");
		btnXem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					docDuLieuDatabase();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnXem.setIcon(new ImageIcon("images_button\\XemDanhSach.png"));
		btnXem.setForeground(Color.WHITE);
		btnXem.setBorderPainted(false);
		btnXem.setBackground(Color.WHITE);
		btnXem.setBounds(1230, 162, 191, 56);
		pnl_ncc.add(btnXem);

		btnXoat = new JButton("");
		btnXoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
			}
		});
		btnXoat.setIcon(new ImageIcon("images_button\\Xoatrangn.png"));
		btnXoat.setForeground(Color.WHITE);
		btnXoat.setBorderPainted(false);
		btnXoat.setBackground(Color.WHITE);
		btnXoat.setBounds(1431, 99, 191, 56);
		pnl_ncc.add(btnXoat);

		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(817, 106, 321, 32);
		pnl_ncc.add(txt_email);

		btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_mancc.setText("");
				txt_email.setText("");
				txt_sdt.setText("");
				txt_tenncc.setText("");
				txtDiaChi.setText("");
				btn_them.setText("Thêm");
				btn_them.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
				btn_sua.setText("Sửa");
				btn_sua.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
				btn_them.setEnabled(true);
				txt_email.setEnabled(false);
				txt_sdt.setEnabled(false);
				txt_tenncc.setEnabled(false);
				txtDiaChi.setEnabled(false);
				btn_sua.setEnabled(true); 
				btnXoa.setEnabled(true);
				btnHuy.setBackground(Color.LIGHT_GRAY);
				btnHuy.setEnabled(false);
			}
		});
//		btnHuy.setIcon(new ImageIcon("images_button\\XuatDanhSach.png"));
		
		btnHuy.setBorderPainted(false);
		btnHuy.setBackground(Color.LIGHT_GRAY);
		btnHuy.setBounds(1431, 162, 191, 56);
		pnl_ncc.add(btnHuy);
		
		

		lbl_ten = new JLabel("CẬP NHẬT NHÀ CUNG CẤP");
		lbl_ten.setForeground(Color.WHITE);
		lbl_ten.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_ten.setBounds(46, 0, 589, 62);
		add(lbl_ten);

		lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_background.setBounds(0, 0, 1658, 822);
		add(lbl_background);
		txt_mancc.setEnabled(false);
		txt_email.setEnabled(false);
		txt_sdt.setEnabled(false);
		txt_tenncc.setEnabled(false);
		txtDiaChi.setEnabled(false);
		guithemkh();

	}

	private void guithemkh() {
		// TODO Auto-generated method stub
		jLabel1 = new javax.swing.JLabel();
		setSize(1658, 822);

	}
	
	private void themAction() {
		String mancc = txt_mancc.getText().trim().toString(); 
		String tenncc = txt_tenncc.getText().trim().toString();
		String diaChi = txtDiaChi.getText().trim().toString();
		String soDT = txt_sdt.getText().trim().toString(); 
		String email = txt_email.getText().trim().toString();
		NhaCungCap ncc = new NhaCungCap(mancc, tenncc, diaChi, soDT, email);
		try {
			if (ncc_dao.addNhaCungCap(ncc)) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
//				modelkh.addRow(new Object[] {maNV, tenNV, ngaySinh, gioiTinh, ngayVaoLam, chucVu, diaChi, soDT, email} );
				txt_mancc.setText("");
				txt_email.setText("");
				txt_sdt.setText("");
				txt_tenncc.setText("");
				txtDiaChi.setText("");
				ncc = null;
//				xoaTrang();
				
			} else {
				JOptionPane.showMessageDialog(null, "Thêm Không Thành Công");
//				txt_maNV.selectAll();
//				txt_maNV.requestFocus();
			}
		} catch (HeadlessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private boolean ktraTxt() {
		String tenncc = txt_tenncc.getText().trim();
		String sdt = txt_sdt.getText().trim();
		
		String tenncckdau = removeAccent(tenncc);
		String diaChi1 = txtDiaChi.getText().trim();
		String email = txt_email.getText().trim();
		
		String diaChi = removeAccent(diaChi1);
//		java.util.Date nvl = dateChooser_1.getDate();
		
		
		
		
		if(!(tenncckdau.length()>0)) {
			thongBao("Eror : Tên nhà cung cấp không được để trống", txt_tenncc);
			return false;
		}
		if(!(sdt.length()>0 && sdt.matches("^0[0-9]{9}"))) {
			thongBao("Error : SDT có dạng 0xxxxxxxxx", txt_sdt);
			return false;
			
		}
		if(!(diaChi.length()>0 && diaChi.matches("[a-zA-Z_0-9'(-||,) ]+"))) {
			thongBao("Địa chỉ không hợp lệ", txtDiaChi);
			return false;
		}
		if(!(email.length()>0 && email.matches("^[\\w]{5,32}(@gmail)\\.com"))) {
			thongBao("Email Phải theo định dạng abc@gmail.com", txt_email);
			return false;
			
		}
		
		return true;
	}
	
	public void thongBao(String er , JTextField txt) {
		JOptionPane.showMessageDialog(null, er);
		txt.selectAll();
		txt.requestFocus();
	}
	
	public String removeAccent(String s) {
		  
		  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
		  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		  return pattern.matcher(temp).replaceAll("");
		 }
	private void docDuLieuDatabase() throws SQLException{
		// TODO Auto-generated method stub
		while (tbl_ncc.getRowCount() != 0) {
			modelkh.removeRow(0);
		}
	ArrayList<NhaCungCap> dsncc = ncc_dao.getAllNhaCungCap();
	for (NhaCungCap ncc : dsncc ) {
		modelkh.addRow(new Object[] {ncc.getMaNCC(), ncc.getTenNCC(), ncc.getDiaChi(), ncc.getSoDT(), ncc.getEmail()});
	
		}
	dsncc = null;
	}
	private void xoaTrang() {
		if(btn_sua.getText()=="Sửa" && btn_them.getText()=="Thêm") {
			txt_mancc.setText("");
			while(tbl_ncc.getRowCount()!=0) {
				modelkh.removeRow(0);
			}
		}
		// TODO Auto-generated method stub
		txtDiaChi.setText("");
		txt_sdt.setText("");
		txt_tenncc.setText("");
		txt_email.setText("");
	}
}
