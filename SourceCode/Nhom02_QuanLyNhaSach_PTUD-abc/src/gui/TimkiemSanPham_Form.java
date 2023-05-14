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

import dao.Sach_DAO;
import dao.VanPhongPham_DAO;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TimkiemSanPham_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JLabel lbl_background;
	private JLabel lbl_TieudeSp;
	private JTextField txt_msp;
	private JTextField txt_mvpp;
	private JScrollPane scr_sach;
	public static JTable tbl_sach;
	private DefaultTableModel modelkh1;
	public static JTable tbl_vpp;
	private JComponent scr_vpp;
	private Sach_DAO s_dao = new Sach_DAO();
	private VanPhongPham_DAO vpp_dao = new VanPhongPham_DAO();
	public static String masp = "";
	private Dialog_ThemSL d = null;
	private JTextField txt_tensp;
	private JTextField txt_ncc;
	private JTextField txt_theloai;
	private JTextField txt_tenvpp;
	private JTextField txt_th;
	private JTextField txt_lsp;

	public TimkiemSanPham_Form() {
		setBackground(SystemColor.control);
		setLayout(null);

		///
		
		
		JTabbedPane tab_sanpham = new JTabbedPane(JTabbedPane.TOP);
		tab_sanpham.setBounds(10, 56, 1638, 788);
		add(tab_sanpham);
		
		JPanel pnl_sach = new JPanel();
		pnl_sach.setBackground(Color.WHITE);
		tab_sanpham.addTab("Sách", null, pnl_sach, null);
		pnl_sach.setLayout(null);
	
		
		///
		String[] headers1 = { "Mã Sản Phẩm", "Tên Sản Phẩm","Tác Giả", "Nhà Xuất Bản", "Thể Loại",
				"Nhà Cung Cấp","Số Lượng Tồn","Giá Nhập","Đơn Vị Tính"};
		modelkh = new DefaultTableModel(headers1, 0);
		tbl_sach = new JTable(modelkh);
		scr_sach = new JScrollPane(tbl_sach);
		scr_sach.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		scr_sach.setBounds(0, 163, 1633, 593);
		///

		pnl_sach.add(scr_sach);
//		ImageIcon icon = new ImageIcon("images_icon\\search-interface-symbol.png");
//		Image img = icon.getImage();
//		ImageIcon newIcon = new ImageIcon(newImg);
		
		txt_msp = new JTextField();
//		txt_msp.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				s_dao.dsSPTimKiem(txt_msp, modelkh, tbl_sach);
//			}
//		});
		txt_msp.setColumns(10);
		txt_msp.setBounds(142, 11, 197, 32);
		pnl_sach.add(txt_msp);
		
		JButton btn_lammoi = new JButton("");
		btn_lammoi.setIcon(new ImageIcon("images_button\\LammoiHD.png"));
		btn_lammoi.setBounds(1151, 78, 191, 52);
		pnl_sach.add(btn_lammoi);
		
		JButton btn_themslsp = new JButton("Thêm Số Lượng");
		btn_themslsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_sach.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm cần thêm số lượng");
				}else {
					masp = tbl_sach.getValueAt(tbl_sach.getSelectedRow(), 0).toString();
					if(d==null) {
						d= new Dialog_ThemSL();
						d.setVisible(true);
					}else {
						d.setVisible(true);
					}
				}
			}
		});
		btn_themslsp.setBounds(1365, 78, 191, 52);
		pnl_sach.add(btn_themslsp);
		
		JLabel lblNewLabel = new JLabel("Mã Sản Phẩm : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 9, 122, 32);
		pnl_sach.add(lblNewLabel);
		
		JLabel lblTnSnPhm = new JLabel("Tên Sản Phẩm : ");
		lblTnSnPhm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTnSnPhm.setBounds(10, 52, 122, 32);
		pnl_sach.add(lblTnSnPhm);
		
		txt_tensp = new JTextField();
		txt_tensp.setColumns(10);
		txt_tensp.setBounds(142, 60, 197, 32);
		pnl_sach.add(txt_tensp);
		
		JLabel lblNhCungCp = new JLabel("Nhà Cung Cấp :");
		lblNhCungCp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNhCungCp.setBounds(394, 11, 122, 32);
		pnl_sach.add(lblNhCungCp);
		
		txt_ncc = new JTextField();
		txt_ncc.setColumns(10);
		txt_ncc.setBounds(526, 11, 197, 32);
		pnl_sach.add(txt_ncc);
		
		JLabel lblThLoi = new JLabel("Thể Loại : ");
		lblThLoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblThLoi.setBounds(394, 52, 122, 32);
		pnl_sach.add(lblThLoi);
		
		txt_theloai = new JTextField();
		txt_theloai.setColumns(10);
		txt_theloai.setBounds(526, 60, 197, 32);
		pnl_sach.add(txt_theloai);
		
		JButton btn_timkiem = new JButton("Tìm Kiếm");
		btn_timkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_msp.getText().equals("") && txt_tensp.getText().equals("") && txt_ncc.getText().equals("")&& txt_theloai.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin tìm kiếm!");
				}else {
					String sql = "SELECT       dbo.SanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.SanPham.GiaNhap, dbo.SanPham.SoLuongTon, dbo.SanPham.DonViTinh, dbo.NhaXuatBan.TenNXB, dbo.TacGia.TenTacGia, dbo.NhaCungCap.TenNCC, \r\n"
							+ "                         dbo.TheLoai.TenTheLoai\r\n"
							+ "FROM            dbo.SanPham INNER JOIN\r\n"
							+ "                         dbo.NhaXuatBan ON dbo.SanPham.MaNXB = dbo.NhaXuatBan.MaNXB INNER JOIN\r\n"
							+ "                         dbo.TacGia ON dbo.SanPham.MaTacGia = dbo.TacGia.MaTacGia INNER JOIN\r\n"
							+ "                         dbo.NhaCungCap ON dbo.SanPham.MaNCC = dbo.NhaCungCap.MaNCC INNER JOIN\r\n"
							+ "                         dbo.TheLoai ON dbo.SanPham.MaTheLoai = dbo.TheLoai.MaTheLoai\r\n"
							+ "Where TrangThai = 'c' and sanpham.masanpham like 'SP%' ";
					if(!(txt_msp.getText().isEmpty())) {
						sql = sql + "and sanpham.masanpham = '"+txt_msp.getText()+"' ";
					}
					if(!(txt_tensp.getText().isEmpty())) {
						sql = sql + "and sanpham.tensanpham = N'"+txt_tensp.getText()+"' ";
					}
					if(!(txt_ncc.getText().isEmpty())) {
						sql = sql + "and nhacungcap.tenncc = N'"+txt_ncc.getText()+"' ";
					}
					if(!(txt_theloai.getText().isEmpty())) {
						sql = sql + "and theloai.tentheloai = N'"+txt_theloai.getText()+"' ";
					}
//					System.out.println(sql);
					s_dao.dsSPTimKiem(sql, modelkh, tbl_sach);
				}
			}
		});
		btn_timkiem.setBounds(945, 78, 191, 52);
		pnl_sach.add(btn_timkiem);

		
		JLabel lbl_backroundpnl = new JLabel("New label");
		lbl_backroundpnl.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_backroundpnl.setBounds(0, 0, 1633, 756);
		pnl_sach.add(lbl_backroundpnl);
		
		
		
		
		
		
		
		
		
		JPanel pnl_vanphongpham = new JPanel();
		tab_sanpham.addTab("Văn phòng phẩm", null, pnl_vanphongpham, null);
		pnl_vanphongpham.setLayout(null);
		//
		String[] headers2 = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Loại Sản Phẩm", "Thương Hiệu", "Nhà Cung Cấp","Số Lượng Tồn", "Giá Nhập",
				"Đơn Vị Tính"};
		modelkh1 = new DefaultTableModel(headers2, 0);
		tbl_vpp = new JTable(modelkh1);
		scr_vpp = new JScrollPane(tbl_vpp);
		scr_vpp.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách văn phòng phẩm", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		scr_vpp.setBounds(0, 180, 1633, 578);
		///

		pnl_vanphongpham.add(scr_vpp);
		//
		
		txt_mvpp = new JTextField();
//		txt_mvpp.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				vpp_dao.dsVPPTimKiem(txt_mvpp, modelkh1, tbl_vpp);
//			}
//		});
		txt_mvpp.setColumns(10);
		txt_mvpp.setBounds(144, 11, 220, 32);
		pnl_vanphongpham.add(txt_mvpp);
		
		JButton btn_lammoivpp = new JButton("");
		btn_lammoivpp.setIcon(new ImageIcon("images_button\\LammoiHD.png"));
		btn_lammoivpp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_lammoivpp.setBounds(1113, 117, 191, 52);
		pnl_vanphongpham.add(btn_lammoivpp);
//		ImageIcon icon1 = new ImageIcon("images_icon\\search-interface-symbol.png");
//		Image img1 = icon1.getImage();
//		ImageIcon newIcon1 = new ImageIcon(newImg1);
		
		JButton btn_themsl = new JButton("Thêm Số Lượng");
		btn_themsl.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_vpp.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm cần nhập thêm số lượng");
				}else {
					masp = tbl_vpp.getValueAt(tbl_vpp.getSelectedRow(), 0).toString();
					if(d==null) {
						d = new Dialog_ThemSL();
						d.setVisible(true);
					}else {
						d.setVisible(true);
					}
				}
			}
		});
		btn_themsl.setBounds(1314, 117, 191, 52);
		pnl_vanphongpham.add(btn_themsl);
		
		JLabel lblNewLabel_1 = new JLabel("Mã sản phẩm :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(23, 15, 111, 21);
		pnl_vanphongpham.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên sản phẩm :");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(23, 76, 111, 32);
		pnl_vanphongpham.add(lblNewLabel_1_1);
		
		txt_tenvpp = new JTextField();
		txt_tenvpp.setColumns(10);
		txt_tenvpp.setBounds(144, 76, 220, 32);
		pnl_vanphongpham.add(txt_tenvpp);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Thương Hiệu :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(397, 11, 111, 32);
		pnl_vanphongpham.add(lblNewLabel_1_1_1);
		
		txt_th = new JTextField();
		txt_th.setColumns(10);
		txt_th.setBounds(513, 11, 220, 32);
		pnl_vanphongpham.add(txt_th);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Loại sản phẩm :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1_1_1.setBounds(397, 76, 111, 32);
		pnl_vanphongpham.add(lblNewLabel_1_1_1_1);
		
		txt_lsp = new JTextField();
		txt_lsp.setColumns(10);
		txt_lsp.setBounds(513, 76, 220, 32);
		pnl_vanphongpham.add(txt_lsp);
		
		JButton btn_tkvpp = new JButton("Tìm kiếm");
		btn_tkvpp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_mvpp.getText().equals("") && txt_tenvpp.getText().equals("") && txt_th.getText().equals("")&& txt_lsp.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin tìm kiếm!");
				}else {
					String sql = "SELECT       dbo.SanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.SanPham.GiaNhap, dbo.SanPham.SoLuongTon, dbo.SanPham.DonViTinh, dbo.ThuongHieu.TenThuongHieu, dbo.LoaiSanPham.TenLoaiSanPham, \r\n"
							+ "                         dbo.NhaCungCap.TenNCC\r\n"
							+ "FROM            dbo.SanPham INNER JOIN\r\n"
							+ "                         dbo.ThuongHieu ON dbo.SanPham.MaThuongHieu = dbo.ThuongHieu.MaThuongHieu INNER JOIN\r\n"
							+ "                         dbo.LoaiSanPham ON dbo.SanPham.MaLoaiSanPham = dbo.LoaiSanPham.MaLoaiSanPham INNER JOIN\r\n"
							+ "                         dbo.NhaCungCap ON dbo.SanPham.MaNCC = dbo.NhaCungCap.MaNCC\r\n"
							+ "Where SanPham.MaSanPham like '%VPP%' and SanPham.TrangThai = 'c' ";
					if(!(txt_mvpp.getText().isEmpty())) {
						sql = sql + "and sanpham.masanpham = '"+txt_mvpp.getText()+"' ";
					}
					if(!(txt_tenvpp.getText().isEmpty())) {
						sql = sql + "and sanpham.tensanpham = N'"+txt_tenvpp.getText()+"' ";
					}
					if(!(txt_th.getText().isEmpty())) {
						sql = sql + "and thuonghieu.tenthuonghieu = N'"+txt_th.getText()+"' ";
					}
					if(!(txt_lsp.getText().isEmpty())) {
						sql = sql + "and loaisanpham.tenloaisanpham = N'"+txt_lsp.getText()+"' ";
					}
//					System.out.println(sql);
					vpp_dao.dsVPPTimKiem(sql, modelkh1, tbl_vpp);
				}
			}
		});
		btn_tkvpp.setBounds(912, 117, 191, 52);
		pnl_vanphongpham.add(btn_tkvpp);
		
		JLabel lbl_backroundvpp = new JLabel("");
		lbl_backroundvpp.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_backroundvpp.setBounds(0, 0, 1633, 776);
		pnl_vanphongpham.add(lbl_backroundvpp);
		
		
		
		
		
		

		lbl_TieudeSp = new JLabel("Tìm kiếm sản phẩm");
		lbl_TieudeSp.setForeground(Color.WHITE);
		lbl_TieudeSp.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_TieudeSp.setBounds(30, -13, 395, 76);
		add(lbl_TieudeSp);

		lbl_background = new JLabel("");
		lbl_background
				.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_background.setBounds(0, 0, 1702, 875);
		add(lbl_background);
		guithemkh();
		System.gc();

	}

	private void guithemkh() {
		// TODO Auto-generated method stub
		jLabel1 = new javax.swing.JLabel();
		setSize(1658, 822);

	}
}
