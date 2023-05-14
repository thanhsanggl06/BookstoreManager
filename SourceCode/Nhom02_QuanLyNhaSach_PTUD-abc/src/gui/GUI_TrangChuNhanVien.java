package gui;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import connectDB.ConnectDB;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.Toolkit;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Choice;
import java.awt.Panel;
import javax.swing.JDesktopPane;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTabbedPane;

public class GUI_TrangChuNhanVien extends JFrame {
	private static final long serialVersionUID = 4057349644354832605L;
	private int x1;
	private JPanel pnl_trangchu, pnl_menus, pnl_menu, pnl_khungmenu, pnl_khungmenu_1;
	private JMenuBar mnu_trangchu, mnu_1;
	private JMenu mn_trangchu, mn_trangchu1, mnu_2;
	private JMenuItem mni_1, mni_2, mni_3, mni_5, mni_6, mni_4;
	private JScrollPane scr_menu;
	private JLabel lbl_icon7, lbl_icon1, lbl_tieudeql, lbl_icon2, lbl_icon3, lbl_icon4, lbl_8, lbl_icon8, lbl_icon9,
			lbl_3, lbl_background;
	private MenuItem menutrangchu, menuStaff1, menuStaff2, messagesp, messagess1, messagencc, messagencc1, messagencc3,
			messagencc4, messagentk, messagentk1, menuKhachHang, menuDatabase, menuSanPham, menuNCC, menuHoaDon;
	private String manv;
	ConnectDB cn = new ConnectDB();
	Connection conn;
	private JLabel tennv;
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	public GUI_TrangChuNhanVien() {
		getContentPane().setBackground(Color.WHITE);
		initComponents();
		GUI_TrangChu1();
		execute();

	}
	public GUI_TrangChuNhanVien(String manv) {
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
				//txt_email.setText("dsf"+rs.getString("SoDienThoai"));
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
///

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
		//
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
				pnl_trangchu.add(new ThongKeDoanhThuNV_Form());
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

		// MenuItem mebanhang = new MenuItem(iconSubMenu, "Bán hàng", null);
		menuKhachHang = new MenuItem(iconKhachhang, "Khách hàng", null, menuStaff1, menuStaff2);
		menuDatabase = new MenuItem(iconDatabase, "Thống kê", null, messagentk, messagentk1);
		menuSanPham = new MenuItem(iconSanPham, "Sản Phẩm", null, messagesp, messagess1);
		menuNCC = new MenuItem(iconNCC, "Nhà cung cấp", null, messagencc, messagencc1);
		menuHoaDon = new MenuItem(iconHoaDon, "Hóa đơn", null, messagencc3, messagencc4);
		// MenuItem menubanhang = new MenuItem(iconBanHang, "Bán hàng", null,
		// mebanhang);
		addMenu(menutrangchu, menuSanPham, menuKhachHang, menuNCC, menuHoaDon, menuDatabase);
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
		
		tennv = new JLabel("");
		tennv.setHorizontalAlignment(SwingConstants.RIGHT);
		tennv.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		tennv.setBounds(1433, 11, 399, 49);
		tennv.setText("Xin chào, "+nv_dao.getNVTheoMa(TaiKhoan_DAO.manv).getTenNV());
		getContentPane().add(tennv);

		pnl_trangchu = new JPanel();
		pnl_trangchu.setLayout(null);
		pnl_trangchu.setBounds(247, 114, 1647, 850);
		getContentPane().add(pnl_trangchu);
		pnl_trangchu.setBackground(new java.awt.Color(255, 255, 255));
		pnl_trangchu.setLayout(new BorderLayout());

		TrangChuXemThongTin_Form sekh = new TrangChuXemThongTin_Form();
		pnl_trangchu.removeAll();
		pnl_trangchu.add(sekh);
		pnl_trangchu.validate();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//		lbl_icon7 = new JLabel("");
//		lbl_icon7.setIcon(new ImageIcon("images\\kehoac.png"));
//		pnl_trangchu.add(lbl_icon7, BorderLayout.NORTH);

		setSize(new Dimension(1145, 747));
		setLocationRelativeTo(null);

		mnu_trangchu = new JMenuBar();
		mnu_trangchu.setBackground(SystemColor.inactiveCaption);
		setJMenuBar(mnu_trangchu);

		mn_trangchu = new JMenu("File");
		mnu_trangchu.add(mn_trangchu);

		mni_1 = new JMenuItem("New menu item");
		mn_trangchu.add(mni_1);

		mni_2 = new JMenuItem("New menu item");
		mn_trangchu.add(mni_2);

		mn_trangchu1 = new JMenu("Setting");
		mnu_trangchu.add(mn_trangchu1);

		mni_3 = new JMenuItem("Thay đổi màu chủ đề");
		mn_trangchu1.add(mni_3);
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

		a.setBackground(Color.cyan);
	}

	private void GUI_TrangChu1() {
		setTitle("Trang chủ");
		setSize(1920, 1050);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		

		URL urlIconNotpat = GUI_TrangChuNhanVien.class.getResource("bv.png");
		Image img = Toolkit.getDefaultToolkit().createImage(urlIconNotpat);
		this.setIconImage(img);

		pnl_menu = new JPanel();
		pnl_menu.setBackground(SystemColor.inactiveCaption);
		pnl_menu.setBounds(10, 114, 227, 747);

		getContentPane().add(pnl_menu);
		int x = 227;
		lbl_icon1 = new JLabel("");
		lbl_icon1.setBounds(4, 5, 219, 39);
		lbl_icon1.setVerticalAlignment(SwingConstants.TOP);

		x1 = 227;
		lbl_icon1.addMouseListener(new MouseAdapter() {
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
				Labelcolor(lbl_icon1);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				resetcolor(lbl_icon1);
			}
		});
		pnl_menu.setLayout(null);
		pnl_menu.add(lbl_icon1);
		lbl_icon1.setIcon(new ImageIcon("images\\moi1.png"));

		pnl_khungmenu = new JPanel();
		pnl_khungmenu.setBounds(0, 49, 227, 698);
		pnl_menu.add(pnl_khungmenu);
		pnl_menus = new JPanel();
		scr_menu = new JScrollPane();
		pnl_khungmenu.add(scr_menu);

		////
		scr_menu.setBorder(null);

		pnl_menus.setBackground(new java.awt.Color(255, 255, 255));
		pnl_menus.setLayout(new javax.swing.BoxLayout(pnl_menus, javax.swing.BoxLayout.Y_AXIS));
		scr_menu.setViewportView(pnl_menus);

		javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(pnl_khungmenu);
		pnl_khungmenu.setLayout(panelMenuLayout);
		panelMenuLayout
				.setHorizontalGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(scr_menu, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE));
		panelMenuLayout.setVerticalGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addComponent(scr_menu, GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE));

		///

		lbl_tieudeql = new JLabel("Quản lý nhà sách ACB");
		lbl_tieudeql.setForeground(SystemColor.windowBorder);
		lbl_tieudeql.setFont(new Font("Times New Roman", Font.BOLD, 36));
		lbl_tieudeql.setBounds(767, 30, 360, 49);
		getContentPane().add(lbl_tieudeql);

		pnl_khungmenu_1 = new JPanel();
		pnl_khungmenu_1.setBackground(Color.WHITE);
		pnl_khungmenu_1.setBounds(-215, 90, 464, 771);

		getContentPane().add(pnl_khungmenu_1);

		lbl_icon2 = new JLabel("");
		lbl_icon2.setBounds(321, 33, 162, 32);
		lbl_icon2.addMouseListener(new MouseAdapter() {
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
		pnl_khungmenu_1.setLayout(null);
		pnl_khungmenu_1.add(lbl_icon2);
		lbl_icon2.setIcon(new ImageIcon("images\\ra.png"));

		lbl_icon3 = new JLabel("");
		lbl_icon3.setBounds(226, 11, 235, 760);
		lbl_icon3.setIcon(new ImageIcon("images\\khung1.png"));
		pnl_khungmenu_1.add(lbl_icon3);

		lbl_icon4 = new JLabel("");
		lbl_icon4.setBounds(215, 0, 1834, 14);
		lbl_icon4.setIcon(new ImageIcon("images\\Untitled.png"));
		lbl_icon4.setForeground(Color.WHITE);
		lbl_icon4.setBackground(Color.WHITE);
		pnl_khungmenu_1.add(lbl_icon4);

		mnu_1 = new JMenuBar();
		mnu_1.setBounds(1833, 11, 61, 48);
		getContentPane().add(mnu_1);

		mnu_2 = new JMenu("");
		mnu_2.setIcon(new ImageIcon("images_icon\\user.png"));
		mnu_1.add(mnu_2);

		mni_3 = new JMenuItem("Đăng xuất");

		mni_3.addActionListener(new ActionListener() {
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
		mni_6.setIcon(new ImageIcon("images\\Doimatkhau.png"));
		mnu_2.add(mni_6);
		mni_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DoiMatKhauDN_Form doimk1 = new DoiMatKhauDN_Form();
				doimk1.setVisible(true);
				// dispose();
			}
		});
		//

		mni_3.setIcon(new ImageIcon("images\\dangxuat.png"));
		mnu_2.add(mni_3);

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
		panel_2.setBounds(10, 860, 227, 129);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		lbl_icon8 = new JLabel("");
		lbl_icon8.setIcon(new ImageIcon("images\\New Wireframe 2.png"));
		lbl_icon8.setBounds(72, 11, 82, 71);
		panel_2.add(lbl_icon8);

		lbl_icon9 = new JLabel("Nhân viên");
		lbl_icon9.setFont(new Font("Stencil", Font.PLAIN, 30));
		lbl_icon9.setBounds(24, 82, 203, 36);
		panel_2.add(lbl_icon9);

		lbl_3 = new JLabel("");
		lbl_3.setIcon(new ImageIcon("images\\label3.png"));
		lbl_3.setBounds(0, -39, 249, 183);
		getContentPane().add(lbl_3);

		lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_background.setBounds(0, -21, 1904, 1022);
		getContentPane().add(lbl_background);

		JCheckBoxMenuItem checkBoxMenuItem = new JCheckBoxMenuItem("New check item");
		checkBoxMenuItem.setBounds(331, 31, 137, 26);
		getContentPane().add(checkBoxMenuItem);

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
