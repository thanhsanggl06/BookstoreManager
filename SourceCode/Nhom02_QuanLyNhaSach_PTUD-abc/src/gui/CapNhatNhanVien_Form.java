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
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.NhanVien_DAO;
import entity.NhanVien;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CapNhatNhanVien_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_nhanvien;
	private JScrollPane src_nhanvien;
	private JLabel lbl_maNhanvien;
	private JLabel lbl_tenNV;
	private JTextField txt_maNV;
	private JTextField txt_tenNV;
	private JLabel lbl_backgroundnv;
	private JLabel lbl_tieudenv;
	private JLabel lbl_ngaysinh;
	private JLabel lbl_ngayvaolam;
	private JDateChooser dateChooser,dateChooser_1;
	private JButton btn_themNV;
	private JButton btn_xoaNV;
	private JButton btn_suaNV;
	private JButton btn_xoatrangNV;
	private JButton btn_xemdsnv;
	private JButton btn_xuatfielnv;
	private JLabel lbl_diachinv;
	private JTextField txt_sdtNV;
	private JTextField txt_diachiNV;
	private JLabel lbl_iconnv;
	private JTextField txt_email;
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private JComboBox cmb_chucvuNV, cmb_gioiTinh;

	public CapNhatNhanVien_Form() {
		setBackground(SystemColor.control);
		setLayout(null);

		///
		String[] headers = { "Mã Nhân viên", "Tên Nhân viên", "Ngày sinh", "Giới Tính", "Ngày vào làm",
				"Chức Vụ ", "Địa Chỉ", "Số Điện Thoại", "Email" };
		modelkh = new DefaultTableModel(headers, 0);
		tbl_nhanvien = new JTable(modelkh);
		tbl_nhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = tbl_nhanvien.getSelectedRow();
				txt_maNV.setText(tbl_nhanvien.getValueAt(row, 0).toString());
				txt_tenNV.setText(tbl_nhanvien.getValueAt(row, 1).toString());
				txt_sdtNV.setText(tbl_nhanvien.getValueAt(row, 7).toString());
				cmb_gioiTinh.setSelectedItem(tbl_nhanvien.getValueAt(row, 3).toString());
				java.util.Date ns = (java.util.Date) tbl_nhanvien.getValueAt(row, 2);
				dateChooser.setDate(ns);
				java.util.Date nvl = (java.util.Date) tbl_nhanvien.getValueAt(row, 4);
				dateChooser_1.setDate(nvl);
				cmb_chucvuNV.setSelectedItem(tbl_nhanvien.getValueAt(row, 5).toString());
				txt_diachiNV.setText(tbl_nhanvien.getValueAt(row, 6).toString());
				txt_email.setText(tbl_nhanvien.getValueAt(row, 8).toString());
				
			}
		});
		src_nhanvien = new JScrollPane(tbl_nhanvien);
		src_nhanvien.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		src_nhanvien.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		src_nhanvien.setBounds(10, 303, 1638, 508);
		///

		add(src_nhanvien);

		JPanel pnl_ttNhanvien = new JPanel();
		pnl_ttNhanvien.setBorder(new TitledBorder(null, "Thông tin Nhân viên", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0, 0, 0)));
		// panel.setBounds(10, 76, 1638, 301);
		pnl_ttNhanvien.setBackground(Color.WHITE);
		pnl_ttNhanvien.setToolTipText("Thông tin tìm kiếm");
		pnl_ttNhanvien.setBounds(10, 59, 1638, 233);
		add(pnl_ttNhanvien);
		pnl_ttNhanvien.setLayout(null);

		lbl_maNhanvien = new JLabel("Mã nhân viên   :");
		lbl_maNhanvien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_maNhanvien.setBounds(30, 30, 153, 32);
		pnl_ttNhanvien.add(lbl_maNhanvien);

		lbl_tenNV = new JLabel("Tên nhân viên :");
		lbl_tenNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tenNV.setBounds(445, 22, 191, 48);
		pnl_ttNhanvien.add(lbl_tenNV);

		txt_maNV = new JTextField();
		txt_maNV.setBounds(182, 33, 253, 32);
		pnl_ttNhanvien.add(txt_maNV);
		txt_maNV.setColumns(10);

		txt_tenNV = new JTextField();
		txt_tenNV.setBounds(580, 33, 321, 32);
		pnl_ttNhanvien.add(txt_tenNV);
		txt_tenNV.setColumns(10);

		lbl_ngaysinh = new JLabel("Ngày sinh  :");
		lbl_ngaysinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_ngaysinh.setBounds(911, 20, 167, 52);
		pnl_ttNhanvien.add(lbl_ngaysinh);

		lbl_ngayvaolam = new JLabel("Ngày vào làm  :");
		lbl_ngayvaolam.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_ngayvaolam.setBounds(445, 69, 178, 48);
		pnl_ttNhanvien.add(lbl_ngayvaolam);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(1017, 32, 170, 32);
		pnl_ttNhanvien.add(dateChooser);

		btn_themNV = new JButton("Thêm");
		btn_themNV.setForeground(Color.WHITE);
		btn_themNV.setBackground(Color.WHITE);
		btn_themNV.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
		btn_themNV.setBounds(1230, 24, 191, 52);
		//
		btn_themNV.setBorderPainted(false); /// xóa khung button
		//
		
		btn_themNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn_themNV.getText().equals("Thêm")) {
					btn_xuatfielnv.setEnabled(true);
					btn_xuatfielnv.setBackground(Color.red);
					try {
						txt_maNV.setText(nv_dao.phatSinhMaNV());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					enableTextField();
					btn_suaNV.setEnabled(false); 
					btn_xoaNV.setEnabled(false);
					btn_themNV.setText("Lưu");
					btn_themNV.setIcon(new ImageIcon("images\\btnLuu.jpg"));
				}else {
					if(ktraTxt()) {
						themAction();
						disableTextField();
						btn_themNV.setText("Thêm");
						btn_themNV.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
						btn_suaNV.setEnabled(true); 
						btn_xoaNV.setEnabled(true);
						btn_xuatfielnv.setBackground(Color.gray);
						btn_xuatfielnv.setEnabled(false);
					}
				}
				
				
			}
		});
		pnl_ttNhanvien.add(btn_themNV);

		btn_xoaNV = new JButton("");
		btn_xoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_nhanvien.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn Khách Hàng Cần Xóa");
				}else {
					try {
						if(nv_dao.deleteNV(tbl_nhanvien.getValueAt(tbl_nhanvien.getSelectedRow(), 0).toString())) {
							JOptionPane.showMessageDialog(null, "Xóa thành công");
							modelkh.removeRow(tbl_nhanvien.getSelectedRow());
						}else {
							JOptionPane.showMessageDialog(null, "Xóa thất bại");
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					tbl_nhanvien.clearSelection();
				}
			}
		});
		btn_xoaNV.setForeground(Color.WHITE);
		btn_xoaNV.setBackground(Color.WHITE);
		btn_xoaNV.setBorderPainted(false);
		btn_xoaNV.setIcon(new ImageIcon("images_button\\btnXoa.jpg"));
		btn_xoaNV.setBounds(1230, 87, 191, 56);
		pnl_ttNhanvien.add(btn_xoaNV);

		btn_suaNV = new JButton("Sửa");
		btn_suaNV.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
		btn_suaNV.setForeground(Color.WHITE);
		btn_suaNV.setBackground(Color.WHITE);
		btn_suaNV.setBorderPainted(false);
		btn_suaNV.setBounds(1431, 24, 191, 52);
		pnl_ttNhanvien.add(btn_suaNV);
		btn_suaNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tbl_nhanvien.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn Nhân Viên Cần Sửa");
				}else {
					if(btn_suaNV.getText()=="Sửa") {
						txt_diachiNV.setEditable(true);
						txt_email.setEditable(true);
						txt_sdtNV.setEditable(true);
						txt_tenNV.setEditable(true);
						btn_themNV.setEnabled(false);
						btn_xoaNV.setEnabled(false);
						btn_xuatfielnv.setEnabled(true);
						btn_xuatfielnv.setBackground(Color.red);
						cmb_chucvuNV.setEnabled(true);
						cmb_gioiTinh.setEnabled(true);
						dateChooser.setEnabled(true);
						dateChooser_1.setEnabled(true);
						btn_suaNV.setText("Lưu");
						btn_suaNV.setIcon(new ImageIcon("images\\btnLuu.jpg"));
					}else {
						if(ktraTxt()) {
							
							String maNV = txt_maNV.getText().trim().toString(); 
							String tenNV = txt_tenNV.getText().trim().toString();
							java.util.Date birthDay = dateChooser.getDate();
							Date ngaySinh = new Date(birthDay.getTime());
							String diaChi = txt_diachiNV.getText().trim().toString();
							java.util.Date ngayVaoLamUtil =  dateChooser_1.getDate();
							Date ngayVaoLam = new Date(ngayVaoLamUtil.getTime());
							String soDT = txt_sdtNV.getText().trim().toString(); 
							String chucVu = cmb_chucvuNV.getSelectedItem().toString();
							String gioiTinh = cmb_gioiTinh.getSelectedItem().toString();
							
							String email = txt_email.getText().trim().toString();
							NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, ngayVaoLam, chucVu, diaChi, soDT, email);
							
							try {
								if(nv_dao.updateNhanVien(nhanVien)) {
									JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
								}else {
									JOptionPane.showMessageDialog(null, "Cập Nhật Thất Bại");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							txt_diachiNV.setEditable(false);
							txt_email.setEditable(false);
							txt_sdtNV.setEditable(false);
							txt_tenNV.setEditable(false);
							btn_themNV.setEnabled(true);
							btn_xoaNV.setEnabled(true);
							btn_xuatfielnv.setEnabled(false);
							btn_xuatfielnv.setBackground(Color.LIGHT_GRAY);
							cmb_chucvuNV.setEnabled(false);
							cmb_gioiTinh.setEnabled(false);
							dateChooser.setEnabled(false);
							dateChooser_1.setEnabled(false);
							xoaTrang();
							txt_maNV.setText("");
							btn_suaNV.setText("Sửa");
							btn_suaNV.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
							tbl_nhanvien.clearSelection();
							
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

		btn_xoatrangNV = new JButton("");
		btn_xoatrangNV.setIcon(new ImageIcon("images_button\\btnXoaTrang.jpg"));
		btn_xoatrangNV.setForeground(Color.WHITE);
		btn_xoatrangNV.setBorderPainted(false);
		btn_xoatrangNV.setBackground(Color.WHITE);
		btn_xoatrangNV.setBounds(1431, 87, 191, 56);
		btn_xoatrangNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
				
			}
		});
		pnl_ttNhanvien.add(btn_xoatrangNV);

		btn_xemdsnv = new JButton("");
		btn_xemdsnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					docDuLieuDatabase();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_xemdsnv.setIcon(new ImageIcon("images_button\\btnXemDS.jpg"));
		btn_xemdsnv.setForeground(Color.WHITE);
		btn_xemdsnv.setBorderPainted(false);
		btn_xemdsnv.setBackground(Color.WHITE);
		btn_xemdsnv.setBounds(1230, 158, 191, 56);
		pnl_ttNhanvien.add(btn_xemdsnv);

		btn_xuatfielnv = new JButton("Hủy");
//		btn_xuatfielnv.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\XuatDanhSach.png"));
//		btn_xuatfielnv.setForeground(Color.WHITE);
		btn_xuatfielnv.setBorderPainted(false);
		btn_xuatfielnv.setBackground(Color.gray);
		btn_xuatfielnv.setEnabled(false);
		btn_xuatfielnv.setBounds(1431, 158, 191, 56);
		btn_xuatfielnv.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xoaTrang();
				btn_themNV.setText("Thêm");
				btn_themNV.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
				btn_suaNV.setText("Sửa");
				btn_suaNV.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
				txt_maNV.setText("");
				btn_themNV.setEnabled(true);
				disableTextField();
				btn_suaNV.setEnabled(true); 
				btn_xoaNV.setEnabled(true);
				btn_xuatfielnv.setBackground(Color.LIGHT_GRAY);
				btn_xuatfielnv.setEnabled(false);
				
			}
		});
		pnl_ttNhanvien.add(btn_xuatfielnv);

		lbl_diachinv = new JLabel("Địa chỉ :");
		lbl_diachinv.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_diachinv.setBounds(30, 115, 82, 52);
		pnl_ttNhanvien.add(lbl_diachinv);

		txt_sdtNV = new JTextField();
		txt_sdtNV.setColumns(10);
		txt_sdtNV.setBounds(580, 177, 310, 32);
		pnl_ttNhanvien.add(txt_sdtNV);

		txt_diachiNV = new JTextField();
		txt_diachiNV.setColumns(10);
		txt_diachiNV.setBounds(182, 128, 708, 32);
		pnl_ttNhanvien.add(txt_diachiNV);

		dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(580, 81, 214, 32);
		pnl_ttNhanvien.add(dateChooser_1);

		JLabel lbl_gioitinhNV = new JLabel("Giới tính :");
		lbl_gioitinhNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_gioitinhNV.setBounds(30, 67, 82, 52);
		pnl_ttNhanvien.add(lbl_gioitinhNV);

		cmb_gioiTinh = new JComboBox();
		cmb_gioiTinh.setBounds(182, 82, 123, 29);
		pnl_ttNhanvien.add(cmb_gioiTinh);
		cmb_gioiTinh.addItem("Nam");
		cmb_gioiTinh.addItem("Nữ");

		JLabel lbl_sdt = new JLabel("Số điện thoại :");
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_sdt.setBounds(445, 166, 178, 48);
		pnl_ttNhanvien.add(lbl_sdt);

		JLabel lbl_chucvuNV = new JLabel("Chức vụ  :");
		lbl_chucvuNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_chucvuNV.setBounds(911, 67, 92, 52);
		pnl_ttNhanvien.add(lbl_chucvuNV);

		String chucvu[] = { "Quản lý", "Nhân viên" };
		cmb_chucvuNV = new JComboBox(chucvu);
		cmb_chucvuNV.setBounds(1017, 83, 170, 29);
		pnl_ttNhanvien.add(cmb_chucvuNV);

		lbl_iconnv = new JLabel("");
		lbl_iconnv
				.setIcon(new ImageIcon("images_background\\customer-service-technician-icon-600-w_20171207103233.png"));
		lbl_iconnv.setBounds(1001, -33, 614, 279);
		pnl_ttNhanvien.add(lbl_iconnv);
		
		JLabel lbl_email = new JLabel("Email :");
		lbl_email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_email.setBounds(30, 162, 82, 52);
		pnl_ttNhanvien.add(lbl_email);
		
		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(182, 177, 253, 32);
		pnl_ttNhanvien.add(txt_email);

		lbl_tieudenv = new JLabel("Cập nhật Nhân Viên\r\n");
		lbl_tieudenv.setForeground(Color.WHITE);
		lbl_tieudenv.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_tieudenv.setBounds(46, 0, 589, 62);
		add(lbl_tieudenv);

		lbl_backgroundnv = new JLabel("");
		lbl_backgroundnv.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_backgroundnv.setBounds(0, 0, 1658, 822);
		add(lbl_backgroundnv);
		guithemkh();
		disableTextField();
//		try {
//			docDuLieuDatabase();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		System.gc();
		

	}

	private void docDuLieuDatabase() throws SQLException{
		// TODO Auto-generated method stub
		while (tbl_nhanvien.getRowCount() != 0) {
			modelkh.removeRow(0);
		}
	ArrayList<NhanVien> dsnv = nv_dao.getAllNhanVien();
	for (NhanVien nv : dsnv ) {
		modelkh.addRow(new Object[] {nv.getMaNV(), nv.getTenNV(), nv.getNgaySinh(), nv.getGioiTinh(), nv.getNgayVaoLam(), nv.getChucVu(), nv.getDiaChi(),nv.getSoDienThoai(), nv.getEmail()});
	
		}
	dsnv = null;
	}
	
	
	private void guithemkh() {
		// TODO Auto-generated method stub
		jLabel1 = new javax.swing.JLabel();
		
		setSize(1658, 822);
	}


//	
		private void suaNV() {
		// TODO Auto-generated method stub
		
	}
		

	private void xuatFile() {
		// TODO Auto-generated method stub
		
	}


	private void xemDSNV() {
		// TODO Auto-generated method stub
		
	}


	private void xoaTrang() {
		if(btn_suaNV.getText()=="Sửa" && btn_themNV.getText()=="Thêm") {
			txt_maNV.setText("");
			while(tbl_nhanvien.getRowCount()!=0) {
				modelkh.removeRow(0);
			}
		}
		// TODO Auto-generated method stub
		txt_diachiNV.setText("");
		dateChooser.setDate(null);
		dateChooser_1.setDate(null);
		txt_sdtNV.setText("");
		txt_tenNV.setText("");
		txt_email.setText("");
	}


	


	private void themAction() {
		String maNV = txt_maNV.getText().trim().toString(); 
		String tenNV = txt_tenNV.getText().trim().toString();
		java.util.Date birthDay = dateChooser.getDate();
		Date ngaySinh = new Date(birthDay.getTime());
		String diaChi = txt_diachiNV.getText().trim().toString();
		java.util.Date ngayVaoLamUtil =  dateChooser_1.getDate();
		Date ngayVaoLam = new Date(ngayVaoLamUtil.getTime());
		String soDT = txt_sdtNV.getText().trim().toString(); 
		String chucVu = cmb_chucvuNV.getSelectedItem().toString();
		String gioiTinh = cmb_gioiTinh.getSelectedItem().toString();
		
		String email = txt_email.getText().trim().toString();
		NhanVien nhanVien = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, ngayVaoLam, chucVu, diaChi, soDT, email);
		try {
			if (nv_dao.addNhanVien(nhanVien)) {
				JOptionPane.showMessageDialog(null, "Thêm Thành Công");
				modelkh.addRow(new Object[] {maNV, tenNV, ngaySinh, gioiTinh, ngayVaoLam, chucVu, diaChi, soDT, email} );
				xoaTrang();
				nhanVien = null;
//				xoaTrang();
				
			} else {
				JOptionPane.showMessageDialog(null, "Thêm Không Thành Công");
				txt_maNV.selectAll();
				txt_maNV.requestFocus();
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
		String tennv = txt_tenNV.getText().trim();
		String sdt = txt_sdtNV.getText().trim();
		
		String tennvkdau = removeAccent(tennv);
		String diaChi1 = txt_diachiNV.getText().trim();
		String email = txt_email.getText().trim();
		
		String diaChi = removeAccent(diaChi1);
		java.util.Date nvl = dateChooser_1.getDate();
		
		
		
		
		if(!(tennvkdau.length()>0 && tennvkdau.matches("[a-zA-Z' ]+"))) {
			thongBao("Eror : Họ tên không hợp lệ", txt_tenNV);
			return false;
		}
		if(!(sdt.length()>0 && sdt.matches("^0[0-9]{9}"))) {
			thongBao("Error : SDT có dạng 0xxxxxxxxx", txt_sdtNV);
			return false;
			
		}
		java.util.Date b = dateChooser.getDate();
		if(b==null) {
			JOptionPane.showMessageDialog(null, "Ngày sinh không được để trống");
			dateChooser.grabFocus();
			return false;
		}
		LocalDate birthday = convertToLocalDateViaInstant(b);
		LocalDate now = LocalDate.now();
		
		int age = Period.between(birthday, now).getYears();
		
		if(age<18) {
			JOptionPane.showMessageDialog(null,"Nhân viên chưa đủ 18 tuổi");
			return false;
		}
		
		if(nvl == null) {
			JOptionPane.showMessageDialog(null, "Ngày vào làm không được để trống");
			dateChooser_1.grabFocus();
			return false;
		} 
		
		java.util.Date now1 = new java.util.Date();
		if(nvl.after(now1)) {
			JOptionPane.showMessageDialog(null, "Ngày Vào Làm Không Hợp Lệ");
			return false;
		}
		if(!(diaChi.length()>0 && diaChi.matches("[a-zA-Z_0-9'(-||,) ]+"))) {
			thongBao("Địa chỉ không hợp lệ", txt_diachiNV);
			return false;
		}
		if(!(email.length()>0 && email.matches("^[\\w]{5,32}(@gmail)\\.com"))) {
			thongBao("Email Phải theo định dạng abcde@gmail.com", txt_email);
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
	
	private void disableTextField() {
		txt_maNV.setEditable(false);
		txt_tenNV.setEditable(false);
		dateChooser.setEnabled(false);
		dateChooser_1.setEnabled(false);
		txt_diachiNV.setEditable(false);
		txt_sdtNV.setEditable(false);
		txt_email.setEditable(false);
		cmb_chucvuNV.setEnabled(false);
		cmb_gioiTinh.setEnabled(false);
	}
	private void enableTextField() {
		txt_tenNV.setEditable(true);
		dateChooser.setEnabled(true);
		dateChooser_1.setEnabled(true);
		txt_diachiNV.setEditable(true);
		txt_sdtNV.setEditable(true);
		txt_email.setEditable(true);
		cmb_chucvuNV.setEnabled(true);
		cmb_gioiTinh.setEnabled(true);
	}
	public LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}

}
