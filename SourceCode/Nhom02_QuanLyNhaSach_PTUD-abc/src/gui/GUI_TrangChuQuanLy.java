package gui;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import connectDB.ConnectDB;
import dao.LoaiSanPham_DAO;
import dao.NhaCungCap_DAO;
import dao.NhaXuatBan_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import dao.TacGia_DAO;
import dao.TaiKhoan_DAO;
import dao.TheLoai_DAO;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.NhanVien;
import entity.Sach;
import entity.TacGia;
import entity.TheLoai;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;

import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;

public class GUI_TrangChuQuanLy extends JFrame {
	private static final long serialVersionUID = 4057349644354832605L;
	private int x1;

	private JPanel panel_3;
	private JPanel pnl_trangchu;
	private JPanel pnl_menu;
	private JScrollPane scr_menu;
	private JPanel pnl_menus;
	private JMenuBar mnu_trangchu;
	private JMenu mn_trangchu;
	private JMenuItem mni_1;
	private JMenuItem mni_2;
	private JMenu mn_trangchu1;
	private JMenuItem mni_3;
	private JLabel lbl_1;
	private JLabel lbl_5;
	private JPanel pnl_1;
	private JLabel lbl_2;
	private JLabel lbl_11;
	private JLabel lbl_4;
	private JMenuBar mnu_1;
	private JMenu mnu_2;
	private JMenuItem mni_1_3;
	private JMenuItem mni_5;
	private JMenuItem mni_6;
	private JMenuItem mni_4;
	private JLabel lbl_8;
	private JLabel lbl_9;
	private JLabel lbl_3;
	private JLabel lbl_1_1;
	private MenuItem menutrangchu, menuStaff1, menuStaff2, messagesp, messagess1, messagencc, messagencc1, messagencc3,
			messagencc4, messagentk, messagentk1, menuKhachHang, menuDatabase, menuSanPham, menuNCC, menuHoaDon,
			menuQLNV, menuQLTK, menuTKNV;
	private String manv;
	ConnectDB cn = new ConnectDB();
	Connection conn;
	private JLabel tennv;
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private Sach_DAO s_dao = new Sach_DAO();
	private TheLoai_DAO tl_dao = new TheLoai_DAO();
	private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();
	private NhaXuatBan_DAO nxb_dao = new NhaXuatBan_DAO();
	private TacGia_DAO tg_dao =new TacGia_DAO();
	

	public GUI_TrangChuQuanLy() {
		getContentPane().setBackground(Color.WHITE);
		initComponents();
		GUI_TrangChu1();
		execute();

	}

	public GUI_TrangChuQuanLy(String manv) {
		// TODO Auto-generated constructor stub
		getContentPane().setBackground(Color.WHITE);
		initComponents();
		GUI_TrangChu1();
		execute();
		this.manv = manv;
		try {
			conn = cn.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			String sql_tt = "Select * from NhanVien where MaNhanVien=?";
			PreparedStatement pst = conn.prepareStatement(sql_tt);
			pst.setString(1, manv);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				tennv.setText("Tên :" + rs.getString("TenNhanVien"));
				// txt_email.setText("dsf"+rs.getString("SoDienThoai"));
				// txt_tenNhap.setText("Mã nhân viên" + rs.getString("TenNhanVien"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void execute() {

		ImageIcon iconDatabase = new ImageIcon("images/ThongKe.png");
		ImageIcon iconSubMenu = new ImageIcon("images/subMenu.png");
		ImageIcon iconTrangChu = new ImageIcon("images/trangchu.png");
		ImageIcon iconKhachhang = new ImageIcon("images/KhachHang.png");
		ImageIcon iconSanPham = new ImageIcon("images/iconSP.png");
		ImageIcon iconNCC = new ImageIcon("images/NCC.png");
		ImageIcon iconHoaDon = new ImageIcon("images/HoaDon.png");
		// ImageIcon iconBanHang = new ImageIcon("images/banhang.png");
		ImageIcon iconNhanVien = new ImageIcon("images/NhanVien1.png");
		ImageIcon iconTaiKhoan = new ImageIcon("images/TaiKhoan.png");

		menutrangchu = new MenuItem(iconTrangChu, "Trang chủ", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				TrangChuXemThongTin_Form sekh = new TrangChuXemThongTin_Form();
				pnl_trangchu.removeAll();
				pnl_trangchu.add(sekh);
				pnl_trangchu.validate();
				focus(menutrangchu);
			}
		});
		menuStaff1 = new MenuItem(iconSubMenu, "Cập nhật khách hàng", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				CapNhatKhachHang_Form qlkh1 = new CapNhatKhachHang_Form();
				pnl_trangchu.removeAll();
				pnl_trangchu.add(qlkh1);
				pnl_trangchu.validate();
				focus(menuStaff1);
			}
		});
		///
		menuStaff2 = new MenuItem(iconSubMenu, "Tìm kiếm khách hàng", new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent ae) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new TimKiemKhachHang_Form());
				pnl_trangchu.validate();
				focus(menuStaff2);
			}
		});

		messagesp = new MenuItem(iconSubMenu, "Cập nhật sản phẩm", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				CapNhatSanPham_Form capnhatsp = null;
				try {
					capnhatsp = new CapNhatSanPham_Form();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pnl_trangchu.removeAll();
				pnl_trangchu.add(capnhatsp);
				pnl_trangchu.validate();
				focus(messagesp);
			}
		});

		messagess1 = new MenuItem(iconSubMenu, "Tìm kiếm sản phẩm", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				TimkiemSanPham_Form timkiemsp = new TimkiemSanPham_Form();
				pnl_trangchu.removeAll();
				pnl_trangchu.add(timkiemsp);
				pnl_trangchu.validate();
				focus(messagess1);
			}
		});
///
		messagencc = new MenuItem(iconSubMenu, "Cập nhật NCC", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new CapNhatNhaCungCap_Form());
				pnl_trangchu.validate();
				focus(messagencc);
			}
		});
		messagencc1 = new MenuItem(iconSubMenu, "Tìm kiếm NCC", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new TimKiemNhaCungCap_Form());
				pnl_trangchu.validate();
				focus(messagencc1);
			}
		});

		messagencc3 = new MenuItem(iconSubMenu, "Danh sách hóa đơn", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new DanhSachHoaDonBan_Form());
				pnl_trangchu.validate();
				focus(messagencc3);
			}
		});
		messagencc4 = new MenuItem(iconSubMenu, "Lập hóa đơn", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent ae) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new LapHoaDonBan_Form());
				pnl_trangchu.validate();
				focus(messagencc4);
			}
		});
		////
		messagentk = new MenuItem(iconSubMenu, "Thông kê doanh thu", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a1) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new ThongKeDoanhThu_Form());
				pnl_trangchu.validate();
				focus(messagentk);
			}
		});
		messagentk1 = new MenuItem(iconSubMenu, "Thống kê SP đã bán", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a2) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new ThongKeSanPhamBan_Form());
				pnl_trangchu.validate();
				focus(messagentk1);
			}
		});
		// create submenu setting

		// MenuItem mebanhang = new MenuItem(iconSubMenu, "Bán hàng", null);
		///
		// MenuItem menuSetting1 = new MenuItem(iconSubMenu, "Setting 001", null);
		menuQLNV = new MenuItem(iconSubMenu, "Quản lý Nhân viên", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a2) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new CapNhatNhanVien_Form());
				pnl_trangchu.validate();
				focus(menuQLNV);
			}
		});
		menuTKNV = new MenuItem(iconSubMenu, "Tìm kiếm nhân viên", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a2) {
				pnl_trangchu.removeAll();
				pnl_trangchu.add(new TimKiemNhanVien_Form());
				pnl_trangchu.validate();
				focus(menuTKNV);
			}
		});
		//
		menuQLTK = new MenuItem(iconSubMenu, "Quản lý Tài Khoản", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a2) {
				pnl_trangchu.removeAll();
				try {
					pnl_trangchu.add(new CapNhatTaiKhoan_Form());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pnl_trangchu.validate();
				focus(menuQLTK);
			}
		});

		MenuItem menuKhachHang = new MenuItem(iconKhachhang, "Khách hàng", null, menuStaff1, menuStaff2);
		MenuItem menuDatabase = new MenuItem(iconDatabase, "Thống kê", null, messagentk, messagentk1);
		MenuItem menuSanPham = new MenuItem(iconSanPham, "Sản Phẩm", null, messagesp, messagess1);
		MenuItem menuNCC = new MenuItem(iconNCC, "Nhà cung cấp", null, messagencc, messagencc1);
		MenuItem menuHoaDon = new MenuItem(iconHoaDon, "Hóa đơn", null, messagencc3, messagencc4);
		// MenuItem menubanhang = new MenuItem(iconBanHang, "Bán hàng", null,
		// mebanhang);
		MenuItem menuQLNhanVien = new MenuItem(iconNhanVien, "Nhân viên", null, menuQLNV, menuTKNV);
		MenuItem menutaikhoan = new MenuItem(iconTaiKhoan, "Tài khoản", null, menuQLTK);

		addMenu(menutrangchu, menuSanPham, menuKhachHang, menuQLNhanVien, menuNCC, menuHoaDon, menuDatabase,
				menutaikhoan);
		menutrangchu.setBackground(Color.cyan);
	}

	private void addMenu(MenuItem... menu) {
		for (int i = 0; i < menu.length; i++) {
			pnl_menus.add(menu[i]);
			ArrayList<MenuItem> subMenu = menu[i].getSubMenu();
			for (MenuItem m : subMenu) {
				addMenu(m);
			}
		}
		pnl_menus.revalidate();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {
		NhanVien nv = nv_dao.getNVTheoMa(TaiKhoan_DAO.manv);
		tennv = new JLabel("Xin chào, "+nv.getTenNV());
		tennv.setHorizontalAlignment(SwingConstants.RIGHT);
		tennv.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tennv.setBounds(1503, 11, 320, 49);
		getContentPane().add(tennv);
		
		pnl_trangchu = new JPanel();
		pnl_trangchu.setLayout(null);
		pnl_trangchu.setBounds(250, 114, 1676, 875);
		getContentPane().add(pnl_trangchu);
		pnl_trangchu.setBackground(new java.awt.Color(255, 255, 255));
		pnl_trangchu.setLayout(new BorderLayout());

		TrangChuXemThongTin_Form sekh = new TrangChuXemThongTin_Form();
		sekh.setSize(1676, 875);
		pnl_trangchu.removeAll();
		pnl_trangchu.add(sekh);
		pnl_trangchu.validate();
		

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		// JLabel lblNewLabel_7 = new JLabel("");
		// lblNewLabel_7.setIcon(new ImageIcon("images\\kehoac.png"));
		// pnl_trangchu.add(lblNewLabel_7, BorderLayout.NORTH);

		setSize(new Dimension(1920, 1009));
		setLocationRelativeTo(null);

		mnu_trangchu = new JMenuBar();
		mnu_trangchu.setBackground(SystemColor.inactiveCaption);
		setJMenuBar(mnu_trangchu);

		mn_trangchu = new JMenu("File");
		mnu_trangchu.add(mn_trangchu);

		mni_1 = new JMenuItem("Nhập danh sách Sách");
		mni_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setDialogTitle("Chọn danh sách");
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File", "xls" ,"xlsx"); // định dạng file
				fileChooser.addChoosableFileFilter(filter);
				int returnValue = fileChooser.showOpenDialog(null);
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					File file = fileChooser.getSelectedFile();
					String pathFile = file.getAbsolutePath();// lấy đường dẫn file
					FileInputStream fxlsx = null;
					try {
						 fxlsx = new FileInputStream(pathFile);
						 XSSFWorkbook wb = new XSSFWorkbook(fxlsx);
						 //chuyen file sang dinh dang excel
						XSSFSheet sheet = wb.getSheetAt(0); //Đọc từ sheet 1
						FormulaEvaluator fml = wb.getCreationHelper().createFormulaEvaluator();
						
						int i = 0;
						int j = 1;
						String tenSP ="";
						int manxb = 0;
						double giaNhap = 0;
						int matl = 0;
						int mancc = 0;
						int sl = 0;
						String hinhAnh = "";
						int matacGia = 0;
						String dvt = "";
						TheLoai tl = null;
						TacGia tg = null;
						NhaCungCap ncc = null;
						NhaXuatBan nxb = null;
						for(Row row : sheet) {
							if(j == 1) {
								j=0;
							}
							else{
								for(Cell cell : row ) {
									if(i==0) {
										if(cell.getCellType()==CellType.STRING) {
											tenSP = cell.getStringCellValue();
										}
										i++;
									}
									else if(i==1) {
										if(cell.getCellType()==CellType.NUMERIC) {
											manxb =  (int) cell.getNumericCellValue();
											
											nxb = nxb_dao.getNXBTheoMa(String.valueOf(manxb));
										}
										i++;
									}else if(i==2) {
										if(cell.getCellType()==CellType.NUMERIC) {
											giaNhap =  cell.getNumericCellValue();
										}
										i++;
									}else if(i==3) {
										if(cell.getCellType()==CellType.NUMERIC) {
											matl =  (int)cell.getNumericCellValue();
											tl = tl_dao.getTheLoaiTheoMa(String.valueOf(matl));
										}
										i++;
									}else if(i==4) {
										if(cell.getCellType()==CellType.NUMERIC) {
											mancc =  (int) cell.getNumericCellValue();
											ncc = ncc_dao.getNccTheoMa(String.valueOf(mancc));
										}
										i++;
									}else if(i==5) {
										if(cell.getCellType()==CellType.NUMERIC) {
											sl =  (int) cell.getNumericCellValue();
										}
										i++;
									}else if(i==6) {
										if(cell.getCellType()==CellType.STRING) {
											hinhAnh =  cell.getStringCellValue();
											File source = new File(hinhAnh);
											File scopy = null;
											if(hinhAnh.endsWith("png")) {
												try {
													hinhAnh = s_dao.phatSinhMaSach()+".png";
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												scopy = new File("imgSanPham\\"+hinhAnh);
											}else {
												try {
													hinhAnh = s_dao.phatSinhMaSach()+".jpg";
												} catch (SQLException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
												scopy = new File("imgSanPham\\"+hinhAnh);
											}
											try {
												Files.copy(source.toPath(), scopy.toPath(), StandardCopyOption.REPLACE_EXISTING);
											} catch (Exception e2) {
												// TODO: handle exception
											}
										}
										i++;
									}else if(i==7) {
										if(cell.getCellType()==CellType.NUMERIC) {
											matacGia = (int) cell.getNumericCellValue();
											tg = tg_dao.getTacGiaTheoMa(String.valueOf(matacGia));
										}
										i++;
									}else if(i==8) {
										if(cell.getCellType()==CellType.STRING) {
											dvt =  cell.getStringCellValue();
										}
										i=0;
									}
									
								}
								try {
									Sach s = new Sach(s_dao.phatSinhMaSach(), tenSP, giaNhap, hinhAnh, ncc, sl, tg,nxb, tl, dvt);
									s_dao.addSach(s);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}
							
						}
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "Thêm danh sách thành công");
					
				}
			}
		});
		mni_1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_DOWN_MASK));
		mn_trangchu.add(mni_1);

		mni_2 = new JMenuItem("New menu item");
		mn_trangchu.add(mni_2);

		mn_trangchu1 = new JMenu("Setting");
		mnu_trangchu.add(mn_trangchu1);

		mni_3 = new JMenuItem("Thay đổi màu chủ đề");
		mn_trangchu1.add(mni_3);
		
		JMenu mnNewMenu = new JMenu("Help");
		mnu_trangchu.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Trợ giúp");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File htmlFile = new File("File/help.html");
				try {
					Desktop.getDesktop().browse(htmlFile.toURI());
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntm_infor = new JMenuItem("Thông tin");
		mntm_infor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogInfor a = new DialogInfor();
				a.setVisible(true);
				a.setLocationRelativeTo(null);
			}
		});
		mnNewMenu.add(mntm_infor);
	}

	private void focus(MenuItem a) {
		menutrangchu.setBackground(Color.white);
		menuStaff1.setBackground(Color.white);
		menuStaff2.setBackground(Color.white);
		messagencc.setBackground(Color.white);
		messagencc1.setBackground(Color.white);
		messagencc3.setBackground(Color.white);
		messagencc4.setBackground(Color.white);
		messagentk.setBackground(Color.white);
		messagentk1.setBackground(Color.white);
		messagesp.setBackground(Color.white);
		messagess1.setBackground(Color.white);
		menuQLNV.setBackground(Color.white);
		menuQLTK.setBackground(Color.white);
		menuTKNV.setBackground(Color.white);

		a.setBackground(Color.cyan);
	}

	private void GUI_TrangChu1() {
		setTitle("Trang chủ");
		setSize(1920, 1050);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		pnl_menu = new JPanel();
		pnl_menu.setBackground(SystemColor.inactiveCaption);
		pnl_menu.setBounds(10, 114, 227, 747);
		//
		//
		getContentPane().add(pnl_menu);
		int x = 227;
		lbl_1 = new JLabel("");
		lbl_1.setBounds(4, 5, 219, 39);
		lbl_1.setVerticalAlignment(SwingConstants.TOP);

		//
//		jScrollPane1 = new javax.swing.JScrollPane();
//		jScrollPane1.setBorder(null);
//		jScrollPane1.setViewportView(panel_1_1);
		//

		x1 = 227;
		lbl_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 == 227) {
					pnl_menu.setSize(227, 747);
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								for (int i = 227; i >= 0; i--) {
									Thread.sleep(1);
									pnl_menu.setSize(i, 747);
								}
							} catch (Exception e1) {
								JOptionPane.showConfirmDialog(null, e1);
							}
						}
					};
					th.start();
					x1 = 0;
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				Labelcolor(lbl_1);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				resetcolor(lbl_1);
			}
		});
		pnl_menu.setLayout(null);
		pnl_menu.add(lbl_1);
		lbl_1.setIcon(new ImageIcon("images\\moi1.png"));

		panel_3 = new JPanel();
		panel_3.setBounds(0, 49, 227, 698);
		pnl_menu.add(panel_3);
		pnl_menus = new JPanel();
		scr_menu = new JScrollPane();
		panel_3.add(scr_menu);

		////
		scr_menu.setBorder(null);

		pnl_menus.setBackground(new java.awt.Color(255, 255, 255));
		pnl_menus.setLayout(new javax.swing.BoxLayout(pnl_menus, javax.swing.BoxLayout.Y_AXIS));
		scr_menu.setViewportView(pnl_menus);

		javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panel_3);
		panel_3.setLayout(panelMenuLayout);
		panelMenuLayout
				.setHorizontalGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scr_menu, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE));
		panelMenuLayout.setVerticalGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scr_menu, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE));

		///

		lbl_5 = new JLabel("Quản lý nhà sách ACB");
		lbl_5.setForeground(SystemColor.windowBorder);
		lbl_5.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lbl_5.setBounds(767, 30, 360, 49);
		getContentPane().add(lbl_5);

		pnl_1 = new JPanel();
		pnl_1.setBackground(Color.WHITE);
		pnl_1.setBounds(-215, 90, 464, 771);

		getContentPane().add(pnl_1);

		lbl_2 = new JLabel("");
		lbl_2.setBounds(321, 33, 162, 32);
		lbl_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (x1 == 0) {
					pnl_menu.setSize(x1, 747);
					Thread th = new Thread() {
						@Override
						public void run() {
							try {
								for (int i = 0; i <= x1; i++) {
									Thread.sleep(1);
									pnl_menu.setSize(i, 747);
								}
							} catch (Exception e1) {
								JOptionPane.showConfirmDialog(null, e1);
							}
						}
					};
					th.start();
					x1 = 227;
				}
			}

		});
		pnl_1.setLayout(null);
		pnl_1.add(lbl_2);
		lbl_2.setIcon(new ImageIcon("images\\ra.png"));

		lbl_11 = new JLabel("New label");
		lbl_11.setBounds(226, 11, 235, 760);
		lbl_11.setIcon(new ImageIcon("images\\khung1.png"));
		pnl_1.add(lbl_11);

		lbl_4 = new JLabel("");
		lbl_4.setBounds(215, 0, 1834, 14);
		lbl_4.setIcon(new ImageIcon("images\\Untitled.png"));
		lbl_4.setForeground(Color.WHITE);
		lbl_4.setBackground(Color.WHITE);
		pnl_1.add(lbl_4);

		mnu_1 = new JMenuBar();
		mnu_1.setBounds(1833, 11, 61, 48);
		getContentPane().add(mnu_1);

		mnu_2 = new JMenu("");
		mnu_2.setIcon(new ImageIcon("images_icon\\user.png"));
		mnu_1.add(mnu_2);

		mni_1_3 = new JMenuItem("Đăng xuất");

		mni_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChonNguoiDung_Form guinv = new ChonNguoiDung_Form();
				guinv.setVisible(true);
				dispose();
			}
		});

		mni_5 = new JMenuItem("Thông tin cá nhân");
		mni_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				Thongtincanhan_form ttcn = new Thongtincanhan_form(TaiKhoan_DAO.manv);
				pnl_trangchu.removeAll();
				pnl_trangchu.add(ttcn);
				pnl_trangchu.validate();
			}
		});
		mni_5.setIcon(new ImageIcon("images\\thongtincanhan.png"));
		mnu_2.add(mni_5);

		mni_6 = new JMenuItem("Đổi mật khẩu");
		mni_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoiMatKhauTCQL doimkql = new DoiMatKhauTCQL();
				doimkql.setVisible(true);
				// dispose();
			}
		});
		mni_6.setIcon(new ImageIcon("images\\Doimatkhau.png"));
		mnu_2.add(mni_6);
		mni_1_3.setIcon(new ImageIcon("images\\dangxuat.png"));
		mnu_2.add(mni_1_3);

		mni_4 = new JMenuItem("Thoát chương trình");
		mni_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int lc = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn thoát chương trình không?",
						"Xác nhận", JOptionPane.YES_NO_OPTION);
				if (lc == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				// dispose();
			}
		});
		mni_4.setIcon(new ImageIcon("images\\exit.png"));
		mnu_2.add(mni_4);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(SystemColor.inactiveCaption);
		panel_2.setBounds(0, 860, 248, 129);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lbl_8 = new JLabel("");
		lbl_8.setIcon(new ImageIcon("images\\New Wireframe 2.png"));
		lbl_8.setBounds(72, 11, 82, 71);
		panel_2.add(lbl_8);

		lbl_9 = new JLabel("QUAN LY");
		lbl_9.setFont(new Font("Stencil", Font.PLAIN, 30));
		lbl_9.setBounds(56, 82, 203, 36);
		panel_2.add(lbl_9);

		lbl_3 = new JLabel("");
		lbl_3.setIcon(new ImageIcon("images\\label3.png"));
		lbl_3.setBounds(0, -39, 249, 183);
		getContentPane().add(lbl_3);

		lbl_1_1 = new JLabel("");
		lbl_1_1.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_1_1.setBounds(0, -21, 1926, 1022);
		getContentPane().add(lbl_1_1);

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	private void Labelcolor(JLabel label) {
		label.setBackground(new java.awt.Color(53, 162, 107));
	}

	private void resetcolor(JLabel label) {
		label.setBackground(new java.awt.Color(54, 70, 78));
	}

	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		// <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
		// (optional) ">
		/*
		 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
		 * look and feel. For details see
		 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(GUI_TrangChuQuanLy.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(GUI_TrangChuQuanLy.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(GUI_TrangChuQuanLy.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GUI_TrangChuQuanLy.class.getName()).log(java.util.logging.Level.SEVERE,
					null, ex);
		}
		// </editor-fold>

		/* Create and display the form */

	}
}
