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
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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

import dao.LoaiSanPham_DAO;
import dao.NhaCungCap_DAO;
import dao.NhaXuatBan_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import dao.TacGia_DAO;
import dao.TheLoai_DAO;
import dao.ThuongHieu_DAO;
import dao.VanPhongPham_DAO;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.Sach;
import entity.TacGia;
import entity.TheLoai;
import entity.ThuongHieu;
import entity.VanPhongPham;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.table.TableModel;
import java.awt.event.MouseAdapter;

public class CapNhatSanPham_Form extends JPanel {
	private JLabel jLabel1, lbl_maSP, lbl_tenSP, lbl_backroundvpp1, lbl_capnhatvpp, lbl_soluong,
			lbl_gianhap, lbl_chonnanh, lbl_background, lbl_mavpp, lbl_tensanphamvanphong, lbl_soluongvpp,
			lbl_gianhapvpp, lbl_NCCvpp, lbl_thuonghieuvpp, lbl_backgroudvpp, lbl_anhthem1, lbl_theloai, lbl_loaivpp;
	private DefaultTableModel model_Sach, model_vpp;
	private JTextField txt_maSP, txt_tensp, txt_soluong, txt_gianhap, txt_mavpp, txt_tenvpp, txt_soluongvpp, txt_gianhapvpp;
	private JButton btn_themsp, btn_Xa, btn_suasp, btn_xoatrang, btn_xemds, btn_xuatds, btn_chonanh, btn_chonanh3,
			btnthmvpp, btn_suavpp, btn_xuatDSvpp, btn_xemDSvpp, btn_xoatrangvpp, btn_xoavvp;
	private JTabbedPane tab_bedPane;
	private JPanel pnl_Capnhatsp, pnl_vanphongpham;
	private JComboBox cmb_nxbsp, cmb_nhacungcapvpp, cmb_thounghieuvpp, cmb_loaivpp, cmb_theloai,cmb_nccsach,cmb_tacgia,cmb_donvitinh, cmbNxb2;
	private JScrollPane scr_vanphongpham, scr_sp;
	private JTable tbl_sach, tbl_vpp;
	private JLabel lbl_nhacungcapsach;
	
	private Sach_DAO sach_dao = new Sach_DAO();
	private VanPhongPham_DAO vpp_dao = new VanPhongPham_DAO();
	private ThuongHieu_DAO th_dao = new ThuongHieu_DAO();
	private TheLoai_DAO tl_dao = new TheLoai_DAO();
	private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
	private NhaXuatBan_DAO nxb_dao = new NhaXuatBan_DAO();
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private LoaiSanPham_DAO lsp_dao = new LoaiSanPham_DAO();
	private TacGia_DAO tg_dao =new TacGia_DAO();
	
	private String pathFile = "";

	public CapNhatSanPham_Form() throws SQLException {
		setBackground(SystemColor.control);
		setLayout(null);
		

		///

		tab_bedPane = new JTabbedPane(JTabbedPane.TOP);
		tab_bedPane.setBounds(10, 56, 1638, 793);
		add(tab_bedPane);

		pnl_Capnhatsp = new JPanel();
		pnl_Capnhatsp.setBorder(new TitledBorder(null, "Thông tin sản phẩm", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0, 0, 0)));
		// panel.setBounds(10, 76, 1638, 301);
		pnl_Capnhatsp.setBackground(Color.WHITE);
		pnl_Capnhatsp.setToolTipText("Thông tin tìm kiếm");
		pnl_Capnhatsp.setBounds(10, 59, 1638, 233);
		pnl_Capnhatsp.setLayout(null);
		tab_bedPane.addTab("Sách", null, pnl_Capnhatsp, null);
		
		

		//
		String[] headers1 = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Nhập", "Số Lượng Tồn", "Tác Giả", "Thể Loại",
				"Nhà Xuất Bản", "Nhà Cung Cấp"};
		model_Sach = new DefaultTableModel(headers1, 0);
		tbl_sach = new JTable(model_Sach);
		scr_sp = new JScrollPane(tbl_sach);
		scr_sp.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách Sách", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		scr_sp.setBounds(0, 274, 1638, 505);;
		///
		tbl_sach.addMouseListener(new MouseListener() {
			
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
				cmb_tacgia.setEditable(true);
				cmb_theloai.setEditable(true);
				cmb_nccsach.setEditable(true);
				cmb_nxbsp.setEditable(true);
				int row = tbl_sach.getSelectedRow();
				txt_maSP.setText(tbl_sach.getValueAt(row, 0).toString());
				txt_tensp.setText(tbl_sach.getValueAt(row, 1).toString());
				txt_gianhap.setText(tbl_sach.getValueAt(row, 2).toString());
				txt_soluong.setText(tbl_sach.getValueAt(row, 3).toString());
				Sach s = sach_dao.getSachTheoMa(tbl_sach.getValueAt(row, 0).toString());
				TacGia tg = s.getTg();
				NhaCungCap ncc = s.getNcc();
				NhaXuatBan nxb = s.getNxb();
				TheLoai tl = s.getTl();
				cmb_tacgia.setSelectedItem(tg);
				cmb_nccsach.setSelectedItem(ncc);
				cmb_nxbsp.setSelectedItem(nxb);
				cmb_theloai.setSelectedItem(tl);
				try {
					ImageIcon icon = new ImageIcon("imgSanPham\\"+s.getHinhAnh());
					Image img = icon.getImage();
					Image newImg = img.getScaledInstance(lbl_chonnanh.getWidth(), lbl_chonnanh.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon newIcon = new ImageIcon(newImg);
					lbl_chonnanh.setIcon(newIcon);
				} catch (Exception e2) {
					
				}
				
			}
		});

		pnl_Capnhatsp.add(scr_sp);
		lbl_maSP = new JLabel("Mã sản phẩm   :");
		lbl_maSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_maSP.setBounds(30, 46, 153, 32);
		pnl_Capnhatsp.add(lbl_maSP);

		lbl_tenSP = new JLabel("Tên sản phẩm :");
		lbl_tenSP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tenSP.setBounds(445, 38, 191, 48);
		pnl_Capnhatsp.add(lbl_tenSP);

		txt_maSP = new JTextField();
		txt_maSP.setBounds(182, 49, 253, 32);
		pnl_Capnhatsp.add(txt_maSP);
		txt_maSP.setColumns(10);

		txt_tensp = new JTextField();
		txt_tensp.setBounds(580, 49, 253, 32);
		pnl_Capnhatsp.add(txt_tensp);
		txt_tensp.setColumns(10);

		lbl_soluong = new JLabel("Số lượng :");
		lbl_soluong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_soluong.setBounds(30, 89, 167, 52);
		pnl_Capnhatsp.add(lbl_soluong);
		
		JLabel lbl_tacgia = new JLabel("Tác giả  :");
		lbl_tacgia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tacgia.setBounds(30, 145, 178, 48);
		pnl_Capnhatsp.add(lbl_tacgia);
		
		cmb_tacgia = new JComboBox();
		cmb_tacgia.setBounds(182, 158, 255, 29);
		pnl_Capnhatsp.add(cmb_tacgia);
		ArrayList<TacGia> dstg = tg_dao.getAllTacGia();
		for (TacGia tacGia : dstg) {
			cmb_tacgia.addItem(tacGia);
		}
		dstg =null;

		btn_themsp = new JButton("Thêm");
		btn_themsp.setForeground(Color.WHITE);
		btn_themsp.setBackground(Color.WHITE);
		btn_themsp.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
		btn_themsp.setBounds(1230, 24, 191, 52);
		//
		btn_themsp.setBorderPainted(false); /// xóa khung button
		//
		btn_themsp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btn_themsp.getText().equals("Thêm")) {
					txt_tensp.setText("");
					txt_soluong.setText("");
					txt_gianhap.setText("");
					ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
					Image img1 = icon1.getImage();
					Image newImg1 = img1.getScaledInstance(245, 206, Image.SCALE_SMOOTH);
					ImageIcon newIcon1 = new ImageIcon(newImg1);
					lbl_chonnanh.setIcon(newIcon1);
					enableTxtFromSach();
					try {
						txt_maSP.setText(sach_dao.phatSinhMaSach());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					btn_themsp.setText("Lưu");
					btn_themsp.setIcon(new ImageIcon("images\\btnLuu.jpg"));
					btn_xuatds.setBackground(Color.red);
					btn_xuatds.setEnabled(true);
					
				}else if(btn_themsp.getText().equals("Lưu")) {
					if(ktraTxtSP()) {
						
						String maSp = txt_maSP.getText();
						String tenSP = txt_tensp.getText();
						String gia = txt_gianhap.getText();
						Double giaNhap = Double.parseDouble(gia);
						int soLuong = Integer.parseInt(txt_soluong.getText()) ;
						TacGia tg = (TacGia) cmb_tacgia.getSelectedItem();
						TheLoai tl = (TheLoai) cmb_theloai.getSelectedItem();
						NhaCungCap ncc = (NhaCungCap) cmb_nccsach.getSelectedItem();
						NhaXuatBan nxb = (NhaXuatBan) cmb_nxbsp.getSelectedItem();
						String hinhAnh= "";
						if(pathFile == "") {
							hinhAnh = "not_found.jpg";
						}else {
							
							File source = new File(pathFile);
							File scopy = null;
							if(pathFile.endsWith("png")) {
								hinhAnh = maSp+".png";
								scopy = new File("imgSanPham\\"+maSp+".png");
							}else {
								hinhAnh = maSp+".jpg";
								scopy = new File("imgSanPham\\"+maSp+".jpg");
							}
							
							try {
								Files.copy(source.toPath(), scopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
						
						
						Sach s = new Sach(maSp, tenSP, giaNhap, hinhAnh, ncc, soLuong, tg, nxb, tl,"Quyển");
						try {
							if(sach_dao.addSach(s)) {
								JOptionPane.showMessageDialog(null, "Thêm Thành Công");
							}else {
								JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
							}
							
//						LoadTableSach();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						btn_themsp.setText("Thêm");
						btn_themsp.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
						lbl_chonnanh.setIcon(new ImageIcon("images\\bv.png"));
						disableTxtFromSach();
						xoaTrangTxtSach();
						txt_maSP.setText("");
						btn_suasp.setEnabled(true);
						btn_Xa.setEnabled(true);
						btn_xuatds.setEnabled(false);
						btn_xuatds.setBackground(Color.gray);
						pathFile = "";
					}
				}
				
				
				
			}
		});
		pnl_Capnhatsp.add(btn_themsp);

		btn_Xa = new JButton("");
		btn_Xa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_sach.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm cần xóa");
				}else {
					int m = JOptionPane.showConfirmDialog(null, "Xác nhận xóa sản phẩm","Chú Ý",JOptionPane.YES_NO_OPTION);
					if(m==JOptionPane.YES_NO_OPTION) {
						try {
							if(sach_dao.deleteSanPham(tbl_sach.getValueAt(tbl_sach.getSelectedRow(), 0).toString())) {
								JOptionPane.showMessageDialog(null, "Xóa thành công");
								ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
								Image img1 = icon1.getImage();
								Image newImg1 = img1.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
								ImageIcon newIcon1 = new ImageIcon(newImg1);
								lbl_chonnanh.setIcon(newIcon1);
								txt_maSP.setText("");
								txt_gianhap.setText("");
								txt_soluong.setText("");
								txt_tensp.setText("");
								LoadTableSach();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btn_Xa.setForeground(Color.WHITE);
		btn_Xa.setBackground(Color.WHITE);
		btn_Xa.setBorderPainted(false);
		btn_Xa.setIcon(new ImageIcon("images_button\\btnXoa.jpg"));
		btn_Xa.setBounds(1230, 87, 191, 56);
		pnl_Capnhatsp.add(btn_Xa);

		btn_suasp = new JButton("Sửa");
		btn_suasp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_sach.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm cần sửa");
				}else {
					if(btn_suasp.getText().equals("Sửa")) {
						btn_suasp.setText("Lưu");
						btn_suasp.setIcon(new ImageIcon("images\\btnLuu.jpg"));
						enableTxtFromSach();
						btn_themsp.setEnabled(false);
						btn_suasp.setEnabled(true);
						btn_xuatds.setEnabled(true);
						btn_xuatds.setBackground(Color.red);
					}else {
						if(ktrasuaSP()) {
							
							String maSp = txt_maSP.getText();
							String tenSP = txt_tensp.getText();
							String gia = txt_gianhap.getText();
							Double giaNhap = Double.parseDouble(gia);
							int soLuong = Integer.parseInt(txt_soluong.getText()) ;
							TacGia tg = (TacGia) cmb_tacgia.getSelectedItem();
							TheLoai tl = (TheLoai) cmb_theloai.getSelectedItem();
							NhaCungCap ncc = (NhaCungCap) cmb_nccsach.getSelectedItem();
							NhaXuatBan nxb = (NhaXuatBan) cmb_nxbsp.getSelectedItem();
							String hinhAnh= "";
							if(pathFile == "") {
								hinhAnh = vpp_dao.getHinhAnhSP(maSp);
							}else {
								
								File source = new File(pathFile);
								File scopy = null;
								if(pathFile.endsWith("png")) {
									hinhAnh = maSp+".png";
									scopy = new File("imgSanPham\\"+maSp+".png");
								}else {
									hinhAnh = maSp+".jpg";
									scopy = new File("imgSanPham\\"+maSp+".jpg");
								}
								
								try {
									Files.copy(source.toPath(), scopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
							
							
							Sach s = new Sach(maSp, tenSP, giaNhap, hinhAnh, ncc, soLuong, tg, nxb, tl,"Quyển");
							try {
								if(sach_dao.updateSach(s)) {
									JOptionPane.showMessageDialog(null, "Cập Nhật Thành Công");
									LoadTableSach();
								}else {
									JOptionPane.showMessageDialog(null, "Cập Nhật Thất Bại");
								}
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							btn_suasp.setText("Sửa");
							btn_suasp.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
							txt_tensp.setText("");
							txt_soluong.setText("");
							txt_gianhap.setText("");
							txt_maSP.setText("");
							disableTxtFromSach();
							btn_themsp.setEnabled(true);
							btn_suasp.setEnabled(true);
							btn_xuatds.setEnabled(false);
							btn_Xa.setEnabled(true);
							btn_xuatds.setBackground(Color.WHITE);
							tbl_sach.clearSelection();
							ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
							Image img1 = icon1.getImage();
							Image newImg1 = img1.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon newIcon1 = new ImageIcon(newImg1);
							lbl_chonnanh.setIcon(newIcon1);
							pathFile = "";
						}
						
					}
					
				}
				
			}
		});
		btn_suasp.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
		btn_suasp.setForeground(Color.WHITE);
		btn_suasp.setBackground(Color.WHITE);
		btn_suasp.setBorderPainted(false);
		btn_suasp.setBounds(1431, 24, 191, 52);
		pnl_Capnhatsp.add(btn_suasp);

		btn_xoatrang = new JButton("");
		btn_xoatrang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btn_suasp.getText()!="Lưu") {
					while(tbl_sach.getRowCount()!=0) {
						model_Sach.removeRow(0);
					}
				}
				if(btn_suasp.getText()!="Lưu" && btn_themsp.getText()!="Lưu") {
					txt_maSP.setText("");
				}
				txt_tensp.setText("");
				txt_gianhap.setText("");
				txt_soluong.setText("");
				ImageIcon icon = new ImageIcon("images\\not_found.jpg");
				Image img = icon.getImage();
				Image newImg = img.getScaledInstance(lbl_chonnanh.getWidth(), lbl_chonnanh.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newIcon = new ImageIcon(newImg);
				lbl_chonnanh.setIcon(newIcon);
				pathFile = "";
			}
		});
		btn_xoatrang.setIcon(new ImageIcon("images_button\\btnXoaTrang.jpg"));
		btn_xoatrang.setForeground(Color.WHITE);
//		btn_xoatrang.setBorderPainted(false);
		btn_xoatrang.setBackground(Color.WHITE);
		btn_xoatrang.setBounds(1431, 87, 191, 56);
		pnl_Capnhatsp.add(btn_xoatrang);

		btn_xemds = new JButton("");
		btn_xemds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadTableSach();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_xemds.setIcon(new ImageIcon("images_button\\btnXemDS.jpg"));
		btn_xemds.setForeground(Color.WHITE);
		btn_xemds.setBorderPainted(false);
		btn_xemds.setBackground(Color.WHITE);
		btn_xemds.setBounds(1230, 158, 191, 56);
		pnl_Capnhatsp.add(btn_xemds);

		btn_xuatds = new JButton("Hủy");
//		btn_xuatds.setIcon(new ImageIcon("images_button\\XuatDanhSach.png"));
//		btn_xuatds.setForeground(Color.WHITE);
		btn_xuatds.setBorderPainted(false);
//		btn_xuatds.setBackground(Color.red);
		btn_xuatds.setBounds(1431, 158, 191, 56);
		pnl_Capnhatsp.add(btn_xuatds);
		btn_xuatds.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
				Image img1 = icon1.getImage();
				Image newImg1 = img1.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newIcon1 = new ImageIcon(newImg1);
				lbl_chonnanh.setIcon(newIcon1);
				btn_themsp.setText("Thêm");
				btn_themsp.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
				btn_themsp.setEnabled(true);
				disableTxtFromSach();
				btn_suasp.setEnabled(true);
				btn_Xa.setEnabled(true);
				btn_xuatds.setBackground(Color.WHITE);
				btn_xuatds.setEnabled(false);
				txt_maSP.setText("");
				txt_gianhap.setText("");
				txt_soluong.setText("");
				txt_tensp.setText("");
				btn_suasp.setText("Sửa");
				btn_suasp.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
				tbl_sach.clearSelection();
				pathFile = "";
				
			}
		});

		btn_chonanh = new JButton("");
		btn_chonanh.setIcon(new ImageIcon("images_button\\chonanh2.png"));
		btn_chonanh.setBounds(938, 224, 153, 39);
		pnl_Capnhatsp.add(btn_chonanh);
//		CapNhatSanPham_Form form = new CapNhatSanPham_Form();
		btn_chonanh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chọn Ảnh");
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG", "png" ,"jpg"); // định dạng file
				fileChooser.addChoosableFileFilter(filter);
//				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// Chỉ cho chọn file
				int returnValue = fileChooser.showOpenDialog(pnl_Capnhatsp);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					pathFile = file.getAbsolutePath();// lấy đường dẫn file
					try {
						ImageIcon icon = new ImageIcon(pathFile);
						Image img = icon.getImage();
						Image newImg = img.getScaledInstance(lbl_chonnanh.getWidth(), lbl_chonnanh.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon newIcon = new ImageIcon(newImg);
						lbl_chonnanh.setIcon(newIcon);
					} catch (Exception e2) {
						
					}
					
				}
				
			}
				
			});

		lbl_chonnanh = new JLabel("");
		ImageIcon iconAnh = new ImageIcon("images\\not_found.jpg");
		Image img = iconAnh.getImage();
		Image newImg = img.getScaledInstance(245,206, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		lbl_chonnanh.setIcon(newIcon);
		lbl_chonnanh.setBounds(896, 11, 245, 206);
		pnl_Capnhatsp.add(lbl_chonnanh);

		lbl_gianhap = new JLabel("Giá nhập :");
		lbl_gianhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_gianhap.setBounds(445, 89, 82, 52);
		pnl_Capnhatsp.add(lbl_gianhap);

		txt_soluong = new JTextField();
		txt_soluong.setColumns(10);
		txt_soluong.setBounds(182, 102, 253, 32);
		pnl_Capnhatsp.add(txt_soluong);

		lbl_theloai = new JLabel("Thể loại:");
		lbl_theloai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_theloai.setBounds(445, 143, 82, 52);
		pnl_Capnhatsp.add(lbl_theloai);

		cmb_theloai = new JComboBox();
		cmb_theloai.setBounds(580, 158, 253, 29);
		pnl_Capnhatsp.add(cmb_theloai);
		ArrayList<TheLoai> dstl = tl_dao.getAllTheLoai();
		for (TheLoai theLoai : dstl) {
			cmb_theloai.addItem(theLoai);
		}
		dstl = null;

		JLabel lbl_nhaxuatban = new JLabel("Nhà xuất bản  :");
		lbl_nhaxuatban.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_nhaxuatban.setBounds(30, 198, 134, 48);
		pnl_Capnhatsp.add(lbl_nhaxuatban);

		txt_gianhap = new JTextField();
		txt_gianhap.setColumns(10);
		txt_gianhap.setBounds(580, 102, 253, 32);
		pnl_Capnhatsp.add(txt_gianhap);

		cmb_nxbsp = new JComboBox();
		cmb_nxbsp.setBounds(180, 211, 255, 29);
		pnl_Capnhatsp.add(cmb_nxbsp);
		
//		cmbNxb2 = new JComboBox<>();
//		cmbNxb2.setBounds(190,220,225,29);
//		pnl_Capnhatsp.add(cmbNxb2);
		
		
		
		ArrayList<NhaXuatBan> dsnxb = nxb_dao.getAllNXB();
		for (NhaXuatBan nhaXuatBan : dsnxb) {
			cmb_nxbsp.addItem(nhaXuatBan);
//			cmbNxb2.addItem(nhaXuatBan);
		}
		dsnxb = null;

		
		
		lbl_nhacungcapsach = new JLabel("Nhà cung cấp  :");
		lbl_nhacungcapsach.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_nhacungcapsach.setBounds(445, 200, 178, 48);
		pnl_Capnhatsp.add(lbl_nhacungcapsach);
		

		
		cmb_nccsach = new JComboBox();
		cmb_nccsach.setBounds(580, 211, 253, 29);
		pnl_Capnhatsp.add(cmb_nccsach);
		
		
		ArrayList<NhaCungCap> dsncc = ncc_dao.getAllNhaCungCap();
		for (NhaCungCap nhaCungCap : dsncc) {
			cmb_nccsach.addItem(nhaCungCap);
		}
		
		pnl_vanphongpham = new JPanel();
		tab_bedPane.addTab("Văn phòng phẩm", null, pnl_vanphongpham, null);
		pnl_vanphongpham.setLayout(null);

		//

		String[] headers3 = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Giá Nhập", "Số Lượng Tồn","Đơn Vị Tính", "Loại Sản Phẩm", "Thương Hiệu",
				"Nhà Cung Cấp" };
		model_vpp = new DefaultTableModel(headers3, 0);
		tbl_vpp = new JTable(model_vpp);
		tbl_vpp.addMouseListener(new MouseListener() {
			
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
				int row = tbl_vpp.getSelectedRow();
				txt_mavpp.setText(tbl_vpp.getValueAt(row, 0).toString());
				txt_tenvpp.setText(tbl_vpp.getValueAt(row, 1).toString());
				txt_gianhapvpp.setText(tbl_vpp.getValueAt(row, 2).toString());
				txt_soluongvpp.setText(tbl_vpp.getValueAt(row, 3).toString());
				VanPhongPham vpp = vpp_dao.getVPPTheoMa(tbl_vpp.getValueAt(row, 0).toString());
				
				NhaCungCap ncc = vpp.getNcc();
				LoaiSanPham lsp = vpp.getLsp();
				ThuongHieu th = vpp.getTh();
				String dvt = vpp.getDonViTinh();
				cmb_donvitinh.setSelectedItem(dvt);
				cmb_loaivpp.setSelectedItem(lsp);
				cmb_thounghieuvpp.setSelectedItem(th);
				cmb_nhacungcapvpp.setSelectedItem(ncc);
				try {
					ImageIcon icon = new ImageIcon("imgSanPham\\"+vpp.getHinhAnh());
					Image img = icon.getImage();
					Image newImg = img.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
					ImageIcon newIcon = new ImageIcon(newImg);
					lbl_anhthem1.setIcon(newIcon);
				} catch (Exception e2) {
					
				}
				
			}
		});
		scr_vanphongpham = new JScrollPane(tbl_vpp);
		scr_vanphongpham.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách văn phòng phẩm", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		scr_vanphongpham.setBounds(0, 304, 1633, 465);
		pnl_vanphongpham.add(scr_vanphongpham);

		lbl_mavpp = new JLabel("Mã sản phẩm   :");
		lbl_mavpp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_mavpp.setBounds(30, 57, 153, 32);
		pnl_vanphongpham.add(lbl_mavpp);

		lbl_tensanphamvanphong = new JLabel("Tên sản phẩm :");
		lbl_tensanphamvanphong.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tensanphamvanphong.setBounds(445, 49, 191, 48);
		pnl_vanphongpham.add(lbl_tensanphamvanphong);

		lbl_anhthem1 = new JLabel("");
		ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
		Image img1 = icon1.getImage();
		Image newImg1 = img1.getScaledInstance(245, 206, Image.SCALE_SMOOTH);
		ImageIcon newIcon1 = new ImageIcon(newImg1);
		lbl_anhthem1.setIcon(newIcon1);
		lbl_anhthem1.setBounds(886, 36, 245, 206);
		pnl_vanphongpham.add(lbl_anhthem1);

		txt_mavpp = new JTextField();
		txt_mavpp.setColumns(10);
		txt_mavpp.setBounds(182, 60, 253, 32);
		pnl_vanphongpham.add(txt_mavpp);

		txt_tenvpp = new JTextField();
		txt_tenvpp.setColumns(10);
		txt_tenvpp.setBounds(580, 60, 253, 32);
		pnl_vanphongpham.add(txt_tenvpp);
		txt_mavpp.setEditable(false);
		btnthmvpp = new JButton("Thêm");
		btnthmvpp.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(btnthmvpp.getText().equals("Thêm")) {
					ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
					Image img1 = icon1.getImage();
					Image newImg1 = img1.getScaledInstance(245, 206, Image.SCALE_SMOOTH);
					ImageIcon newIcon1 = new ImageIcon(newImg1);
					lbl_anhthem1.setIcon(newIcon1);
					lbl_anhthem1.setIcon(newIcon1);
					txt_gianhapvpp.setText("");
					txt_soluongvpp.setText("");
					txt_tenvpp.setText("");
					btn_chonanh3.setEnabled(true);
					btnthmvpp.setText("Lưu");
					btnthmvpp.setIcon(new ImageIcon("images\\btnLuu.jpg"));
					btn_suavpp.setEnabled(false);
					btn_xoavvp.setEnabled(false);
					txt_tenvpp.setEditable(true);
					txt_gianhapvpp.setEditable(true);
					txt_soluongvpp.setEditable(true);
					cmb_thounghieuvpp.setEnabled(true);
					cmb_loaivpp.setEnabled(true);
					cmb_donvitinh.setEnabled(true);
					cmb_nhacungcapvpp.setEnabled(true);
					btn_xuatDSvpp.setEnabled(true);
					btn_xuatDSvpp.setBackground(Color.red);
					
					try {
						txt_mavpp.setText(vpp_dao.phatSinhMaVPP());
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else if(btnthmvpp.getText().equals("Lưu")) {
					if(ktraTxtvpp()) {
						
						String masp = txt_mavpp.getText();
						String tensp = txt_tenvpp.getText();
						int sl = Integer.parseInt(txt_soluongvpp.getText());
						double giaNhap = Double.parseDouble(txt_gianhapvpp.getText());
						ThuongHieu th = (ThuongHieu) cmb_thounghieuvpp.getSelectedItem();
						NhaCungCap ncc = (NhaCungCap) cmb_nhacungcapvpp.getSelectedItem();
						LoaiSanPham lsp = (LoaiSanPham) cmb_loaivpp.getSelectedItem();
						String dvt = (String) cmb_donvitinh.getSelectedItem();
						String hinhAnh= "";
						if(pathFile == "") {
							hinhAnh = "not_found.jpg";
						}else {
							File source = new File(pathFile);
							File scopy = null;
							
							if(pathFile.endsWith("png")) {
								hinhAnh = masp+".png";
								scopy = new File("imgSanPham\\"+masp+".png");
							}else {
								hinhAnh = masp+".jpg";
								scopy = new File("imgSanPham\\"+masp+".jpg");
							}
							
							try {
								Files.copy(source.toPath(), scopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
							} catch (Exception e2) {
								// TODO: handle exception
							}
						}
						VanPhongPham vpp = new VanPhongPham(masp, tensp, giaNhap, hinhAnh, ncc, sl, th, dvt, lsp);
						try {
							if(vpp_dao.addVanPhongPham(vpp)) {
								JOptionPane.showMessageDialog(null, "Thêm Thành Công");
							}else {
								JOptionPane.showMessageDialog(null, "Thêm Thất Bại");
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						btnthmvpp.setText("Thêm");
						btnthmvpp.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
//					lbl_anhthem1.setIcon(new ImageIcon("images\\bv.png"));
						ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
						Image img1 = icon1.getImage();
						Image newImg1 = img1.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon newIcon1 = new ImageIcon(newImg1);
						lbl_anhthem1.setIcon(newIcon1);
						txt_mavpp.setText("");
						btn_suavpp.setEnabled(true);
						btn_xoavvp.setEnabled(true);
						txt_tenvpp.setEditable(false);
						txt_gianhapvpp.setEditable(false);
						txt_soluongvpp.setEditable(false);
						cmb_thounghieuvpp.setEnabled(false);
						cmb_loaivpp.setEnabled(false);
						cmb_donvitinh.setEnabled(false);
						cmb_nhacungcapvpp.setEnabled(false);
						btn_xuatDSvpp.setEnabled(false);
						btn_xuatDSvpp.setBackground(Color.WHITE);
						txt_gianhapvpp.setText("");
						txt_soluongvpp.setText("");
						txt_tenvpp.setText("");
						pathFile = "";
					}
					
				}
			}
		});
		btnthmvpp.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
		btnthmvpp.setForeground(Color.WHITE);
		btnthmvpp.setBorderPainted(false);
		btnthmvpp.setBackground(Color.WHITE);
		btnthmvpp.setBounds(1174, 37, 191, 52);
		pnl_vanphongpham.add(btnthmvpp);

		btn_suavpp = new JButton("Sửa");
		btn_suavpp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_vpp.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn Sản Phẩm Cần Sửa");
				}else {
					if(btn_suavpp.getText().equals("Sửa")) {
						
						btn_suavpp.setText("Lưu");
						btn_suavpp.setIcon(new ImageIcon("images\\btnLuu.jpg"));
						btn_chonanh3.setEnabled(true);
						btnthmvpp.setEnabled(false);
						btn_xoavvp.setEnabled(false);
						txt_tenvpp.setEditable(true);
						txt_gianhapvpp.setEditable(true);
						txt_soluongvpp.setEditable(true);
						cmb_thounghieuvpp.setEnabled(true);
						cmb_loaivpp.setEnabled(true);
						cmb_donvitinh.setEnabled(true);
						cmb_nhacungcapvpp.setEnabled(true);
						btn_xuatDSvpp.setEnabled(true);
						btn_xuatDSvpp.setBackground(Color.red);
					}else {
						if(ktrasuavpp()) {
							
							String masp = txt_mavpp.getText();
							String tensp = txt_tenvpp.getText();
							int sl = Integer.parseInt(txt_soluongvpp.getText());
							double giaNhap = Double.parseDouble(txt_gianhapvpp.getText());
							ThuongHieu th = (ThuongHieu) cmb_thounghieuvpp.getSelectedItem();
							NhaCungCap ncc = (NhaCungCap) cmb_nhacungcapvpp.getSelectedItem();
							LoaiSanPham lsp = (LoaiSanPham) cmb_loaivpp.getSelectedItem();
							String dvt = (String) cmb_donvitinh.getSelectedItem();
							String hinhAnh= "";
							if(pathFile.equals("")) {
								hinhAnh = vpp_dao.getHinhAnhSP(masp);
							}else {
								File source = new File(pathFile);
								File scopy = null;
								if(pathFile.endsWith("png")) {
									hinhAnh = masp+".png";
									scopy = new File("imgSanPham\\"+masp+".png");
								}else {
									hinhAnh = masp+".jpg";
									scopy = new File("imgSanPham\\"+masp+".jpg");
								}
								
								try {
									Files.copy(source.toPath(), scopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
								} catch (Exception e2) {
									// TODO: handle exception
								}
							}
							VanPhongPham vpp = new VanPhongPham(masp, tensp, giaNhap, hinhAnh, ncc, sl, th, dvt, lsp);
							try {
								if(vpp_dao.updateVanPhongPham(vpp)) {
									JOptionPane.showMessageDialog(null,"Cập Nhập Thành Công" );
									vpp = null;
								}else {
									JOptionPane.showMessageDialog(null,"Cập Nhập Thất Bại" );
									vpp= null;
								}
							} catch (HeadlessException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							pathFile = "";
							btn_suavpp.setText("Sửa");
							btn_suavpp.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
							btn_chonanh3.setEnabled(false);
							btnthmvpp.setEnabled(true);
							btn_xoavvp.setEnabled(true);
							txt_tenvpp.setEditable(false);
							txt_gianhapvpp.setEditable(false);
							txt_soluongvpp.setEditable(false);
							cmb_thounghieuvpp.setEnabled(false);
							cmb_loaivpp.setEnabled(false);
							cmb_donvitinh.setEnabled(false);
							cmb_nhacungcapvpp.setEnabled(false);
							btn_xuatDSvpp.setEnabled(false);
							txt_gianhapvpp.setText("");
							txt_soluongvpp.setText("");
							txt_tenvpp.setText("");
							txt_maSP.setText("");
							btn_xuatDSvpp.setBackground(Color.WHITE);
							ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
							Image img1 = icon1.getImage();
							Image newImg1 = img1.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon newIcon1 = new ImageIcon(newImg1);
							lbl_anhthem1.setIcon(newIcon1);
							tbl_vpp.clearSelection();
							try {
								LoadTableVPP();
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						
					}
				}
				
			}
		});
		btn_suavpp.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
		btn_suavpp.setForeground(Color.WHITE);
		btn_suavpp.setBorderPainted(false);
		btn_suavpp.setBackground(Color.WHITE);
		btn_suavpp.setBounds(1174, 122, 191, 56);
		pnl_vanphongpham.add(btn_suavpp);

		btn_xoavvp = new JButton("");
		btn_xoavvp.setIcon(new ImageIcon("images_button\\btnXoa.jpg"));
		btn_xoavvp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_vpp.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm cần xóa");
				}else {
					int m = JOptionPane.showConfirmDialog(null,"Xác nhận xóa sản phẩm","Chú Ý",JOptionPane.YES_NO_OPTION);
					if(m==JOptionPane.YES_OPTION) {
						try {
							if(sach_dao.deleteSanPham(tbl_vpp.getValueAt(tbl_vpp.getSelectedRow(), 0).toString()))
								JOptionPane.showMessageDialog(null, "Xóa thành công");
							LoadTableVPP();
							ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
							Image img1 = icon1.getImage();
							Image newImg1 = img1.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
							ImageIcon newIcon1 = new ImageIcon(newImg1);
							lbl_anhthem1.setIcon(newIcon1);
							txt_gianhapvpp.setText("");
							txt_soluongvpp.setText("");
							txt_tenvpp.setText("");
							txt_mavpp.setText("");
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btn_xoavvp.setForeground(Color.WHITE);
		btn_xoavvp.setBorderPainted(false);
		btn_xoavvp.setBackground(Color.WHITE);
		btn_xoavvp.setBounds(1402, 37, 191, 52);
		pnl_vanphongpham.add(btn_xoavvp);

		btn_xoatrangvpp = new JButton("");
		btn_xoatrangvpp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl_anhthem1.setIcon(new ImageIcon("images\\bv.png"));
				txt_gianhapvpp.setText("");
				txt_soluongvpp.setText("");
				txt_tenvpp.setText("");
				if(btn_suavpp.getText()!="Lưu") {
					while(tbl_vpp.getRowCount()!=0) {
						model_vpp.removeRow(0);
					}
				}
				if(btn_suavpp.getText()!="Lưu" && btnthmvpp.getText()!="Lưu") {
					txt_mavpp.setText("");
				}
				ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
				Image img1 = icon1.getImage();
				Image newImg1 = img1.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newIcon1 = new ImageIcon(newImg1);
				lbl_anhthem1.setIcon(newIcon1);
				pathFile = "";
			}
		});
		btn_xoatrangvpp.setIcon(new ImageIcon("images_button\\btnXoaTrang.jpg"));
		btn_xoatrangvpp.setForeground(Color.WHITE);
		btn_xoatrangvpp.setBorderPainted(false);
		btn_xoatrangvpp.setBackground(Color.WHITE);
		btn_xoatrangvpp.setBounds(1402, 122, 191, 56);
		pnl_vanphongpham.add(btn_xoatrangvpp);

		btn_xemDSvpp = new JButton("");
		btn_xemDSvpp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					LoadTableVPP();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btn_xemDSvpp.setIcon(new ImageIcon("images_button\\btnXemDS.jpg"));
		btn_xemDSvpp.setForeground(Color.WHITE);
		btn_xemDSvpp.setBorderPainted(false);
		btn_xemDSvpp.setBackground(Color.WHITE);
		btn_xemDSvpp.setBounds(1174, 201, 191, 56);
		pnl_vanphongpham.add(btn_xemDSvpp);

		btn_xuatDSvpp = new JButton("Hủy");
		btn_xuatDSvpp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ImageIcon icon1 = new ImageIcon("images\\not_found.jpg");
				Image img1 = icon1.getImage();
				Image newImg1 = img1.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
				ImageIcon newIcon1 = new ImageIcon(newImg1);
				lbl_anhthem1.setIcon(newIcon1);
				btnthmvpp.setText("Thêm");
				btnthmvpp.setIcon(new ImageIcon("images_button\\btnThem.jpg"));
				btn_suavpp.setText("Sửa");
				btn_suavpp.setIcon(new ImageIcon("images_button\\btnSua.jpg"));
				txt_mavpp.setText("");
				btn_suavpp.setEnabled(true);
				btn_xoavvp.setEnabled(true);
				txt_tenvpp.setEditable(false);
				txt_gianhapvpp.setEditable(false);
				txt_soluongvpp.setEditable(false);
				cmb_thounghieuvpp.setEnabled(false);
				cmb_loaivpp.setEnabled(false);
				cmb_donvitinh.setEnabled(false);
				cmb_nhacungcapvpp.setEnabled(false);
				btn_xuatDSvpp.setEnabled(false);
				btn_xuatDSvpp.setBackground(Color.WHITE);
				txt_gianhapvpp.setText("");
				txt_soluongvpp.setText("");
				txt_tenvpp.setText("");
				btnthmvpp.setEnabled(true);
				tbl_vpp.clearSelection();
				pathFile = "";
				
				
				
			}
		});
//		btn_xuatDSvpp.setIcon(new ImageIcon("images_button\\XuatDanhSach.png"));
		btn_xuatDSvpp.setForeground(Color.WHITE);
		btn_xuatDSvpp.setBorderPainted(false);
		btn_xuatDSvpp.setBackground(Color.red);
		btn_xuatDSvpp.setBounds(1402, 201, 191, 56);
		pnl_vanphongpham.add(btn_xuatDSvpp);

		lbl_soluongvpp = new JLabel("Số lượng :");
		lbl_soluongvpp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_soluongvpp.setBounds(30, 100, 167, 52);
		pnl_vanphongpham.add(lbl_soluongvpp);

		lbl_gianhapvpp = new JLabel("Giá nhập :");
		lbl_gianhapvpp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_gianhapvpp.setBounds(455, 100, 82, 52);
		pnl_vanphongpham.add(lbl_gianhapvpp);

		lbl_loaivpp = new JLabel("Loại sản phẩm  :");
		lbl_loaivpp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_loaivpp.setBounds(30, 156, 178, 48);
		pnl_vanphongpham.add(lbl_loaivpp);

		txt_soluongvpp = new JTextField();
		txt_soluongvpp.setColumns(10);
		txt_soluongvpp.setBounds(182, 113, 253, 32);
		pnl_vanphongpham.add(txt_soluongvpp);

		lbl_NCCvpp = new JLabel("Nhà cung cấp  :");
		lbl_NCCvpp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_NCCvpp.setBounds(445, 156, 130, 48);
		pnl_vanphongpham.add(lbl_NCCvpp);

		cmb_loaivpp = new JComboBox();
		cmb_loaivpp.setBounds(182, 169, 253, 29);
		pnl_vanphongpham.add(cmb_loaivpp);
		ArrayList<LoaiSanPham> dslsp = lsp_dao.getAllLoaiSP();
		for (LoaiSanPham loaiSanPham : dslsp) {
			cmb_loaivpp.addItem(loaiSanPham);
		}
		
		dslsp = null;

		cmb_nhacungcapvpp = new JComboBox();
		cmb_nhacungcapvpp.setBounds(580, 169, 253, 29);
		pnl_vanphongpham.add(cmb_nhacungcapvpp);
		for (NhaCungCap ncc : dsncc) {
			cmb_nhacungcapvpp.addItem(ncc);
		}
		dsncc = null;

		lbl_thuonghieuvpp = new JLabel("Thương hiệu   :");
		lbl_thuonghieuvpp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_thuonghieuvpp.setBounds(30, 209, 178, 48);
		pnl_vanphongpham.add(lbl_thuonghieuvpp);

		btn_chonanh3 = new JButton("New button");
		btn_chonanh3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chọn Ảnh");
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG and JPG", "png" ,"jpg"); // định dạng file
				fileChooser.addChoosableFileFilter(filter);
//				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);// Chỉ cho chọn file
				int returnValue = fileChooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					pathFile = file.getAbsolutePath();// lấy đường dẫn file
					try {
						ImageIcon icon = new ImageIcon(pathFile);
						Image img = icon.getImage();
						Image newImg = img.getScaledInstance(lbl_anhthem1.getWidth(), lbl_anhthem1.getHeight(), Image.SCALE_SMOOTH);
						ImageIcon newIcon = new ImageIcon(newImg);
						lbl_anhthem1.setIcon(newIcon);
					} catch (Exception e2) {
						
					}
					
				}
			}
		});
		btn_chonanh3.setIcon(new ImageIcon("images_button\\chonanh2.png"));
		btn_chonanh3.setBounds(944, 253, 126, 32);
		pnl_vanphongpham.add(btn_chonanh3);

		txt_gianhapvpp = new JTextField();
		txt_gianhapvpp.setColumns(10);
		txt_gianhapvpp.setBounds(580, 113, 253, 32);
		pnl_vanphongpham.add(txt_gianhapvpp);
		
		JLabel lbl_donvitinh = new JLabel("Đơn vị tính   :");
		lbl_donvitinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_donvitinh.setBounds(445, 209, 178, 48);
		pnl_vanphongpham.add(lbl_donvitinh);
		
		cmb_donvitinh = new JComboBox();
		cmb_donvitinh.setBounds(578, 222, 255, 29);
		pnl_vanphongpham.add(cmb_donvitinh);
		cmb_donvitinh.addItem("Hộp");
		cmb_donvitinh.addItem("Cây");
		cmb_donvitinh.addItem("Ram");
		cmb_donvitinh.addItem("Tập");
		cmb_donvitinh.addItem("Bộ");
		cmb_donvitinh.addItem("Cuộn");
		cmb_donvitinh.addItem("Cái");

		cmb_thounghieuvpp = new JComboBox();
		cmb_thounghieuvpp.setBounds(180, 222, 255, 29);
		pnl_vanphongpham.add(cmb_thounghieuvpp);
		ArrayList<ThuongHieu> dsth = th_dao.getAllThuongHieu();
		for (ThuongHieu thuongHieu : dsth) {
			cmb_thounghieuvpp.addItem(thuongHieu);
		}
		
		dsth = null;

		lbl_backgroudvpp = new JLabel("");
		lbl_backgroudvpp.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_backgroudvpp.setBounds(0, 0, 1648, 727);
		pnl_vanphongpham.add(lbl_backgroudvpp);

		lbl_capnhatvpp = new JLabel("Cập nhật sản phẩm\r\n");
		lbl_capnhatvpp.setForeground(Color.WHITE);
		lbl_capnhatvpp.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_capnhatvpp.setBounds(46, 0, 589, 62);
		add(lbl_capnhatvpp);

		lbl_backroundvpp1 = new JLabel("");
		lbl_backroundvpp1.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_backroundvpp1.setBounds(0, 0, 1714, 875);
		add(lbl_backroundvpp1);
		
		lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_background.setBounds(0, 0, 1648, 727);
		pnl_Capnhatsp.add(lbl_background);
		
		guithemkh();
//		LoadTableSach();
//		LoadTableVPP();
		txt_maSP.setEnabled(false);
		btn_chonanh3.setEnabled(false);
		txt_tenvpp.setEditable(false);
		txt_gianhapvpp.setEditable(false);
		txt_soluong.setEditable(false);
		btn_xuatDSvpp.setEnabled(false);
		btn_xuatDSvpp.setBackground(Color.WHITE);
		cmb_loaivpp.setEnabled(false);
		cmb_nhacungcapvpp.setEnabled(false);
		cmb_thounghieuvpp.setEnabled(false);
		cmb_donvitinh.setEnabled(false);
		disableTxtFromSach();
		btn_xuatds.setEnabled(false);
		txt_soluongvpp.setEditable(false);
		System.gc();

	}
	public void LoadTableSach() throws SQLException {
		while (tbl_sach.getRowCount() != 0) {
			model_Sach.removeRow(0);
		}
	ArrayList<Sach> dssach = sach_dao.getAllSach();
	for (Sach s : dssach) {
		model_Sach.addRow(new Object[] {s.getMaSP(),s.getTenSP(),s.getGiaNhap(),s.getSoLuongTon(),s.getTg().getTenTacGia(),s.getTl().getTenTheLoai(),
						s.getNxb().getTenNXB(),s.getNcc().getTenNCC()});
	}
	}
	
	public void LoadTableVPP() throws SQLException {
		while (tbl_vpp.getRowCount() != 0) {
			model_vpp.removeRow(0);
		}
	ArrayList<VanPhongPham> dsvpp = vpp_dao.getAllVanPhongPham();
	for (VanPhongPham vpp : dsvpp) {
		model_vpp.addRow(new Object[] {vpp.getMaSP(),vpp.getTenSP(),vpp.getGiaNhap(),vpp.getSoLuongTon(),vpp.getDonViTinh(),vpp.getLsp().getTenLoai(),vpp.getTh().getTenThuongHieu(),
						vpp.getNcc().getTenNCC()});
	}
	}

	private void guithemkh() {
		// TODO Auto-generated method stub
		jLabel1 = new javax.swing.JLabel();
		setSize(1658, 875);

	}
	
	public void disableTxtFromSach() {
		txt_maSP.setEditable(false);
		txt_gianhap.setEditable(false);
		txt_tensp.setEditable(false);
		txt_soluong.setEditable(false);
		cmb_theloai.setEnabled(false);
		cmb_nccsach.setEnabled(false);
		cmb_nxbsp.setEnabled(false);
		cmb_tacgia.setEnabled(false);
		btn_chonanh.setEnabled(false);
		btn_xuatds.setEnabled(false);
	}
	public void enableTxtFromSach() {
		txt_gianhap.setEditable(true);
		txt_tensp.setEditable(true);
		txt_soluong.setEditable(true);
		cmb_theloai.setEnabled(true);
		cmb_nccsach.setEnabled(true);
		cmb_nxbsp.setEnabled(true);
		cmb_tacgia.setEnabled(true);
		btn_chonanh.setEnabled(true);
		btn_suasp.setEnabled(false);
		btn_Xa.setEnabled(false);
		cmb_tacgia.setEditable(false);
		cmb_theloai.setEditable(false);
		cmb_nccsach.setEditable(false);
		cmb_nxbsp.setEditable(false);
	}
	
	public void xoaTrangTxtSach() {
		txt_maSP.setText("");
		txt_tensp.setText("");
		txt_gianhap.setText("");
		txt_soluong.setText("");
	}
	private boolean ktraTxtSP() {
		String tensp = txt_tensp.getText();
		String tenspkdau = removeAccent(tensp);
		String soluong = txt_soluong.getText();
		String giaNhap = txt_gianhap.getText();
		
		
		
		
		
		if(!(tenspkdau.length()>0)) {
			thongBao("Eror : Tên sản phẩm không được để trống", txt_tensp);
			return false;
		}
		if(!(soluong.length()>0 && soluong.matches("[0-9']+"))) {
			
			thongBao("Số lượng không hợp lệ", txt_soluong);
			return false;
		}
		int sl = Integer.parseInt(txt_soluong.getText());
		if(sl<=0) {
			thongBao("Số lượng phải lớn hơn 0", txt_soluong);
			return false;
		}
		
		if(!(giaNhap.length()>0 && giaNhap.matches("[0-9']+"))) {
			
			thongBao("Giá nhập không hợp lệ", txt_gianhap);
			return false;
		}
		
		double giaNhapso = Double.parseDouble(txt_gianhap.getText());
		
		if(giaNhapso<=0) {
			thongBao("Giá nhập phải lớn hơn 0", txt_gianhap);
			return false;
		}
		if(pathFile == "") {
			JOptionPane.showMessageDialog(null,"Bạn chưa chọn hình ảnh");
			return false;
		}
		
		
		return true;
	}
	private boolean ktrasuaSP() {
		String tensp = txt_tensp.getText().trim();
		String tenspkdau = removeAccent(tensp);
		String soluong = txt_soluong.getText();
		String giaNhap = txt_gianhap.getText();
		
		
		
		
		
		if(!(tenspkdau.length()>0)) {
			thongBao("Eror : Tên sản phẩm không được để trống", txt_tensp);
			return false;
		}
		if(!(soluong.length()>0 && soluong.matches("[0-9']+"))) {
			
			thongBao("Số lượng không hợp lệ", txt_soluong);
			return false;
		}
		int sl = Integer.parseInt(txt_soluong.getText());
		if(sl<=0) {
			thongBao("Số lượng phải lớn hơn 0", txt_soluong);
			return false;
		}
		
		if(!(giaNhap.length()>0 && giaNhap.matches("[0-9']+"))) {
			
			thongBao("Giá nhập không hợp lệ", txt_gianhap);
			return false;
		}
		
		double giaNhapso = Double.parseDouble(txt_gianhap.getText());
		
		if(giaNhapso<=0) {
			thongBao("Giá nhập phải lớn hơn 0", txt_gianhap);
			return false;
		}
		
		
		
		return true;
	}
	
	private boolean ktraTxtvpp() {
		String tensp = txt_tenvpp.getText().trim();
		String tenspkdau = removeAccent(tensp);
		String soluong = txt_soluongvpp.getText();
		String giaNhap = txt_gianhapvpp.getText();
		
		
		
		
		
		if(!(tenspkdau.length()>0)) {
			thongBao("Eror : Tên sản phẩm không được trống", txt_tenvpp);
			return false;
		}
		if(!(soluong.length()>0 && soluong.matches("[0-9']+"))) {
			
			thongBao("Số lượng không hợp lệ", txt_soluongvpp);
			return false;
		}
		int sl = Integer.parseInt(txt_soluongvpp.getText());
		if(sl<=0) {
			thongBao("Số lượng phải lớn hơn 0", txt_soluongvpp);
			return false;
		}
		
		if(!(giaNhap.length()>0 && giaNhap.matches("[0-9']+"))) {
			
			thongBao("Giá nhập không hợp lệ", txt_gianhapvpp);
			return false;
		}
		
		double giaNhapso = Double.parseDouble(txt_gianhapvpp.getText());
		
		if(giaNhapso<=0) {
			thongBao("Giá nhập phải lớn hơn 0", txt_gianhapvpp);
			return false;
		}
		if(pathFile == "") {
			JOptionPane.showMessageDialog(null,"Bạn chưa chọn hình ảnh");
			return false;
		}
		
		
		return true;
	}
	
	private boolean ktrasuavpp() {
		String tensp = txt_tenvpp.getText().trim();
		String tenspkdau = removeAccent(tensp);
		String soluong = txt_soluongvpp.getText();
		String giaNhap = txt_gianhapvpp.getText();
		
		
		
		
		
		if(!(tenspkdau.length()>0)) {
			thongBao("Eror : Tên sản phẩm không được trống", txt_tenvpp);
			return false;
		}
		if(!(soluong.length()>0 && soluong.matches("[0-9']+"))) {
			
			thongBao("Số lượng không hợp lệ", txt_soluongvpp);
			return false;
		}
		int sl = Integer.parseInt(txt_soluongvpp.getText());
		if(sl<=0) {
			thongBao("Số lượng phải lớn hơn 0", txt_soluongvpp);
			return false;
		}
		
		if(!(giaNhap.length()>0 && giaNhap.matches("[0-9']+"))) {
			
			thongBao("Giá nhập không hợp lệ", txt_gianhapvpp);
			return false;
		}
		
		double giaNhapso = Double.parseDouble(txt_gianhapvpp.getText());
		
		if(giaNhapso<=0) {
			thongBao("Giá nhập phải lớn hơn 0", txt_gianhapvpp);
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
}
