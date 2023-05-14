package gui;

import java.awt.Component;

import javax.mail.Message;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Hashtable;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.table.TableModel;


import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.Sach_DAO;
import dao.TaiKhoan_DAO;
import dao.VanPhongPham_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;
import entity.Sach;
import entity.SanPham;
import entity.VanPhongPham;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

//import net.sf.jasperreports.components.table.Row;
import java.awt.event.KeyAdapter;

import java.awt.event.MouseAdapter;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class LapHoaDonBan_Form extends JPanel {
	private JLabel jLabel1;
	public static DefaultTableModel modelkh;
	private JTable tablekh;
	public static JTable tbl_sp;
	private JTable tbl_hoadon;
	private JScrollPane jscroll;
	private JScrollPane src_sp;
	private JScrollPane src_hoadon;
	private JLabel lbl_backgroundtong;
	private JLabel lbl_tieude;
	private JTextField txt_masp;
	private JTextField txt_tiennhan;
	public static JTextField txt_sdtkh;
	private JTextField txt_soluongsp;
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private Sach_DAO sach_dao = new Sach_DAO();
	private VanPhongPham_DAO vpp_dao = new VanPhongPham_DAO();
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	public static JLabel lbl_tenkh_nhap;
	private JLabel lbl_tienthua_nhap;
	public static JLabel lbl_tongcongVAT_nhap;
	public static KhachHang kh = null;
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
	private String maTemp;
	public static DefaultTableModel modelkh1;
	public static JLabel lbl_mahd_nhap;
	private JButton btn_xoasp;
	private JButton btn_sua;
	public static JLabel lbl_tongtien_nhap;
	public static double tongTien;
	public static JButton btn_thanhtoan;
	private String tongThanhToan;
	private JButton btn_timKh;
	private NhanVien nv;
	public static JButton btn_huyhoadon;
	public static JButton btn_luutam;
	private JLabel lbl_masp_1;
	private JTextField txt_tensp;
	private JButton btnNewButton;
	

	public LapHoaDonBan_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		
		
		JPanel pnl_hoadon = new JPanel();
		pnl_hoadon.setBackground(Color.WHITE);
		pnl_hoadon.setLayout(null);
		pnl_hoadon.setBounds(669, 81, 968, 677);
		add(pnl_hoadon);
		
		String[] headers1 = { "Mã sản phẩm", "Tển sản phẩm", "Đơn giá","Số lượng","Đơn Vị Tính","Thành tiền"};
		modelkh1 = new DefaultTableModel(headers1, 0) {
			// Ghi đè phương thức chỉ cho sửa cột thứ 3
			@Override
			   public boolean isCellEditable(int row, int column) {
			       //Only the third column
			       return column == 3;
			   }
		};
		tbl_hoadon = new JTable(modelkh1);
		src_hoadon = new JScrollPane(tbl_hoadon);
		src_hoadon.setBounds(0, 217, 968, 358);
		pnl_hoadon.add(src_hoadon);
		src_hoadon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chi Tiết Hóa Đơn", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		//jscroll.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách Hóa đơn bán", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		
		tbl_hoadon.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				btn_xoasp.setEnabled(true);
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
		
		JLabel lbl_hoadonban = new JLabel("HÓA ĐƠN BÁN");
		lbl_hoadonban.setFont(new Font("Times New Roman", Font.BOLD, 25));
		lbl_hoadonban.setBounds(394, 25, 218, 55);
		pnl_hoadon.add(lbl_hoadonban);
		
		JLabel lbl_ngayban = new JLabel("Ngày bán :");
		lbl_ngayban.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbl_ngayban.setBounds(705, 56, 89, 24);
		pnl_hoadon.add(lbl_ngayban);
		
		java.util.Date now = new java.util.Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		String strNow = sdf.format(now);
		JLabel lbl_ngaynhap = new JLabel(strNow);
		lbl_ngaynhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_ngaynhap.setBounds(804, 59, 115, 18);
		pnl_hoadon.add(lbl_ngaynhap);
		
		JLabel lbl_mahoadon = new JLabel("Mã hóa đơn :");
		lbl_mahoadon.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_mahoadon.setBounds(43, 103, 150, 31);
		pnl_hoadon.add(lbl_mahoadon);
		
		JLabel lbl_nhanvien = new JLabel("Nhân viên :");
		lbl_nhanvien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_nhanvien.setBounds(43, 148, 150, 31);
		pnl_hoadon.add(lbl_nhanvien);
		
		JLabel lbl_sdtKH = new JLabel("SĐT Khách hàng ");
		lbl_sdtKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_sdtKH.setBounds(490, 106, 150, 24);
		pnl_hoadon.add(lbl_sdtKH);
		
		JLabel lbl_tenKH = new JLabel("Tên Khách hàng ");
		lbl_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tenKH.setBounds(490, 151, 150, 24);
		pnl_hoadon.add(lbl_tenKH);
		
		btn_timKh = new JButton("");
		btn_timKh.setEnabled(false);
		btn_timKh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ktraTxtsdt()) {
					
					String sdt = txt_sdtkh.getText();
					if(kh_dao.kHCoTrongHeThong(sdt)) {
						kh = kh_dao.getKhachHangTheoSDT(sdt);
						lbl_tenkh_nhap.setText(kh.getTenKH());
						if(lbl_mahd_nhap.getText()!= "") {
							btn_thanhtoan.setEnabled(true);
							btn_luutam.setEnabled(true);
						}
					}else {
						int message = JOptionPane.showConfirmDialog(null, "Khách hàng chưa có trong hệ thống, bạn có muốn thêm khách hàng?", "Xác Nhận", JOptionPane.YES_NO_OPTION);
						if(message == JOptionPane.YES_OPTION) {
							ThemKH_Dialog gd_them = new ThemKH_Dialog();
							gd_them.setVisible(true);
							gd_them.setLocationRelativeTo(null);
							gd_them.txt_sdt.setText(sdt);
						}
//					if(gd_them.check==1) {
//						kh = gd_them.kh;
//						lbl_tenkh_nhap.setText(kh.getTenKH());
//						txt_sdtkh.setText(kh.getSoDienThoai().toString());
//					}
					}
				}
				
			}
		});
		btn_timKh.setIcon(new ImageIcon("images_button\\TimKiem1.png"));
		btn_timKh.setBounds(857, 106, 46, 36);
		pnl_hoadon.add(btn_timKh);
		
		JLabel lbl_tongtien = new JLabel("Tổng tiền  :");
		lbl_tongtien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tongtien.setBounds(42, 586, 150, 31);
		pnl_hoadon.add(lbl_tongtien);
		
		JLabel lbl_tiennhan = new JLabel("Tiền nhận :");
		lbl_tiennhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tiennhan.setBounds(42, 628, 150, 31);
		pnl_hoadon.add(lbl_tiennhan);
		
		txt_tiennhan = new JTextField();
		txt_tiennhan.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				double so = 0;
				if(txt_tiennhan.getText().equals("")) {
					lbl_tienthua_nhap.setText("");
				}else if(txt_tiennhan.getText().chars().allMatch(Character::isDigit)) {
					so = Double.parseDouble(txt_tiennhan.getText());
					double tt = so -((tongTien *0.1) + tongTien);
					DecimalFormat dfm = new DecimalFormat("###,###.#VND");
					String tienthua = dfm.format(tt);
					
					lbl_tienthua_nhap.setText(tienthua);
				}else {
					lbl_tienthua_nhap.setText("");
				}
			}
		});
		txt_tiennhan.setBounds(148, 634, 214, 24);
		pnl_hoadon.add(txt_tiennhan);
		txt_tiennhan.setColumns(10);
		
		JLabel lbl_tongcongVAT = new JLabel("Tổng cộng(10% VAT) :");
		lbl_tongcongVAT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tongcongVAT.setBounds(497, 586, 211, 31);
		pnl_hoadon.add(lbl_tongcongVAT);
		
		JLabel lbl_tienthua = new JLabel("Tiền thừa  :");
		lbl_tienthua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tienthua.setBounds(496, 628, 150, 31);
		pnl_hoadon.add(lbl_tienthua);
		
		txt_sdtkh = new JTextField();
		txt_sdtkh.setBounds(637, 107, 210, 28);
		pnl_hoadon.add(txt_sdtkh);
		txt_sdtkh.setColumns(10);
		
		lbl_mahd_nhap = new JLabel("");
		lbl_mahd_nhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_mahd_nhap.setBounds(158, 106, 263, 31);
//		try {
//			lbl_mahd_nhap.setText(hd_dao.phatSinhMaHD());
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
		pnl_hoadon.add(lbl_mahd_nhap);
		
		nv = nv_dao.getNVTheoMa(TaiKhoan_DAO.manv);
		JLabel lbl_nhanvien_nhap = new JLabel(nv.getTenNV());
		lbl_nhanvien_nhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_nhanvien_nhap.setBounds(148, 148, 263, 31);
		pnl_hoadon.add(lbl_nhanvien_nhap);
		
		lbl_tongtien_nhap = new JLabel("");
		lbl_tongtien_nhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tongtien_nhap.setBounds(148, 586, 263, 31);
		pnl_hoadon.add(lbl_tongtien_nhap);
//		lbl_tongtien_nhap.setText("");
		
		lbl_tongcongVAT_nhap = new JLabel("");
		lbl_tongcongVAT_nhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tongcongVAT_nhap.setBounds(705, 586, 263, 31);
		pnl_hoadon.add(lbl_tongcongVAT_nhap);
		
		lbl_tienthua_nhap = new JLabel("");
		lbl_tienthua_nhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tienthua_nhap.setBounds(597, 628, 263, 31);
		pnl_hoadon.add(lbl_tienthua_nhap);
		
		lbl_tenkh_nhap = new JLabel("");
		lbl_tenkh_nhap.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_tenkh_nhap.setBounds(626, 151, 263, 31);
		pnl_hoadon.add(lbl_tenkh_nhap);
		
		JPanel pnl_thongtinsp = new JPanel();
		pnl_thongtinsp.setBorder(new TitledBorder(null, "Thông tin sản phẩm", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		pnl_thongtinsp.setBackground(SystemColor.inactiveCaptionBorder);
		pnl_thongtinsp.setBounds(10, 81, 634, 686);
		add(pnl_thongtinsp);
		pnl_thongtinsp.setLayout(null);
		
		String[] headers = { "Mã sản phẩm", "Tên sản phẩm", "Số lượng","Đơn vị tính","Giá bán"};
		modelkh = new DefaultTableModel(headers, 0);
		tbl_sp = new JTable(modelkh);
		src_sp = new JScrollPane(tbl_sp);
		src_sp.setBounds(0, 216, 634, 383);
		pnl_thongtinsp.add(src_sp);
		src_sp.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		
		JLabel lbl_masp = new JLabel("Mã sản phẩm : ");
		lbl_masp.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_masp.setBounds(22, 38, 120, 29);
		pnl_thongtinsp.add(lbl_masp);
		
		txt_masp = new JTextField();
		txt_masp.setColumns(10);
		txt_masp.setBounds(138, 42, 395, 27);
		pnl_thongtinsp.add(txt_masp);
		
		JButton btn_themsp = new JButton("Thêm sản phẩm");
		btn_themsp.setIcon(new ImageIcon("images_button\\Themvaohoadon.png"));
		btn_themsp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ma = "";
				if(tbl_sp.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Vui lòng chọn sản phẩm");
				}else {
					if(txt_soluongsp.getText().isEmpty()) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập số lượng");
					}else {
						if(ktraTxtsl()) {
							
							int slt = Integer.parseInt(tbl_sp.getValueAt(tbl_sp.getSelectedRow(), 2).toString());
							if(slt - Integer.parseInt(txt_soluongsp.getText())>=0) {
								
								addSPVaoHD();
								tinhTongTien();
								tinhTongCong();
							}else {
								JOptionPane.showMessageDialog(null, "Không đủ số lượng");
								
							}
						}
					}
				}
				txt_soluongsp.setText("");
				
				
			}
		});
		btn_themsp.setBounds(337, 617, 228, 49);
		pnl_thongtinsp.add(btn_themsp);
		
		JLabel lbl_soluongsp = new JLabel("Số lượng :");
		lbl_soluongsp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_soluongsp.setBounds(83, 624, 126, 29);
		pnl_thongtinsp.add(lbl_soluongsp);
		
		txt_soluongsp = new JTextField();
		txt_soluongsp.setBounds(175, 624, 86, 27);
		pnl_thongtinsp.add(txt_soluongsp);
		txt_soluongsp.setColumns(10);
		
		lbl_masp_1 = new JLabel("Tên sản phẩm : ");
		lbl_masp_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_masp_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lbl_masp_1.setBounds(0, 78, 132, 29);
		pnl_thongtinsp.add(lbl_masp_1);
		
		txt_tensp = new JTextField();
		txt_tensp.setColumns(10);
		txt_tensp.setBounds(138, 78, 395, 27);
		pnl_thongtinsp.add(txt_tensp);
		
		btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_masp.getText().equals("") && txt_tensp.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin tìm kiếm!");
				}else {
					String sql = "Select MaSanPham, TenSanPham, GiaNhap, SoLuongTon, DonViTinh from SanPham Where trangthai ='c' ";
					if(!(txt_masp.getText().isEmpty())) {
						sql = sql + "and sanpham.masanpham = '"+txt_masp.getText()+"' ";
					}
					if(!(txt_tensp.getText().isEmpty())) {
						sql = sql + "and sanpham.tensanpham = N'"+txt_tensp.getText()+"' ";
					}
//					System.out.println(sql);
					vpp_dao.dsSPTimKiem(sql, modelkh, tbl_sp);
				}
			}
		});
		btnNewButton.setBounds(461, 170, 143, 35);
		pnl_thongtinsp.add(btnNewButton);
		
		btn_huyhoadon = new JButton("");
		btn_huyhoadon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int message = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn hủy hóa đơn","Chú ý", JOptionPane.YES_NO_OPTION);
				if(message == JOptionPane.YES_OPTION) {
					huyHD();
					btn_huyhoadon.setEnabled(false);
				}
				
			}
		});
		btn_huyhoadon.setIcon(new ImageIcon("images\\huyhd.jpg"));
		btn_huyhoadon.setBounds(889, 762, 138, 49);
		add(btn_huyhoadon);
		
		btn_luutam = new JButton("Lưu tạm");
		btn_luutam.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbl_mahd_nhap.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Chưa phát sinh hóa đơn");
				}else {
					String maHd = lbl_mahd_nhap.getText();
					NhanVien nv = nv_dao.getNVTheoMa("NV0001");
					java.util.Date ngay = new java.util.Date();
					Date now = new Date(ngay.getTime());
					Time gioLap = new Time(ngay.getHours(), ngay.getMinutes(), ngay.getSeconds());
					ChiTietHoaDon cthd = null;
					ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
					for(int i = 0 ; i<tbl_hoadon.getRowCount();i++) {
						String masp = tbl_hoadon.getValueAt(i, 0).toString();
						String soLuong = tbl_hoadon.getValueAt(i, 3).toString();
						int sl = Integer.parseInt(soLuong);
						if(masp.startsWith("SP")) {
							Sach s = sach_dao.getSachTheoMa(masp);
							cthd = new ChiTietHoaDon(s, sl, maHd);
							
						}
						else {
							VanPhongPham vpp = vpp_dao.getVPPTheoMa(masp);
							cthd = new ChiTietHoaDon(vpp, sl, maHd);
						}
						dscthd.add(cthd);
					}
					HoaDon hd = new HoaDon(maHd, now, gioLap, nv, kh, dscthd);
					try {
						hd_dao.addHoaDonCho(hd,(tongTien*0.1)+tongTien);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (ChiTietHoaDon ct: dscthd) {
						try {
							cthd_dao.addCTHD(ct);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					while (tbl_hoadon.getRowCount() != 0) {
						modelkh1.removeRow(0);
					}
					while (tbl_sp.getRowCount() != 0) {
						modelkh.removeRow(0);
					}
					lbl_mahd_nhap.setText("");
					btn_thanhtoan.setEnabled(false);
					lbl_tenkh_nhap.setText("");
					btn_timKh.setEnabled(false);
					txt_sdtkh.setText("");
					txt_masp.setText("");
					btn_xoasp.setEnabled(false);
					lbl_tongtien_nhap.setText("");
					lbl_tongcongVAT_nhap.setText("");
					lbl_tienthua_nhap.setText("");
					kh = null;
					btn_huyhoadon.setEnabled(false);
					btn_luutam.setEnabled(false);
				}
				
			}
		});
		btn_luutam.setIcon(new ImageIcon("images\\Luutam2.png"));
		btn_luutam.setBounds(1037, 762, 138, 49);
		add(btn_luutam);
		
		btn_thanhtoan = new JButton("");
		btn_thanhtoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			if(lbl_tienthua_nhap.getText().startsWith("-") || lbl_tienthua_nhap.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Chưa nhận đủ số tiền thanh toán");
			}else {
				
				int message = JOptionPane.showConfirmDialog(null, "Số tiền phải nhận là : "+tongThanhToan, "Xác Nhận", JOptionPane.YES_NO_OPTION);
				if(message == JOptionPane.YES_OPTION) {
					String maHd = lbl_mahd_nhap.getText();
					java.util.Date ngay = new java.util.Date();
					Date now = new Date(ngay.getTime());
					Time gioLap = new Time(ngay.getHours(), ngay.getMinutes(), ngay.getSeconds());
					ChiTietHoaDon cthd = null;
					ArrayList<ChiTietHoaDon> dscthd = new ArrayList<ChiTietHoaDon>();
					for(int i = 0 ; i<tbl_hoadon.getRowCount();i++) {
						String masp = tbl_hoadon.getValueAt(i, 0).toString();
						String soLuong = tbl_hoadon.getValueAt(i, 3).toString();
						int sl = Integer.parseInt(soLuong);
						if(masp.startsWith("SP")) {
							Sach s = sach_dao.getSachTheoMa(masp);
							cthd = new ChiTietHoaDon(s, sl, maHd);
							
						}
						else {
							VanPhongPham vpp = vpp_dao.getVPPTheoMa(masp);
							cthd = new ChiTietHoaDon(vpp, sl, maHd);
						}
						dscthd.add(cthd);
					}
					HoaDon hd = new HoaDon(maHd, now, gioLap, nv, kh, dscthd);
					try {
						hd_dao.addHoaDon(hd,(tongTien*0.1)+tongTien);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (ChiTietHoaDon ct: dscthd) {
						try {
							cthd_dao.addCTHD(ct);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					int msg = JOptionPane.showConfirmDialog(null, "Bạn có muốn xuất hóa đơn ?","Xuất hóa đơn",JOptionPane.YES_NO_OPTION);
					if(msg==JOptionPane.YES_OPTION) {
						xuatHoaDon(maHd);
					}
					JOptionPane.showMessageDialog(null, "Thanh toán thành công");
					while (tbl_hoadon.getRowCount() != 0) {
						modelkh1.removeRow(0);
					}
					while (tbl_sp.getRowCount() != 0) {
						modelkh.removeRow(0);
					}
					lbl_mahd_nhap.setText("");
					btn_thanhtoan.setEnabled(false);
					lbl_tenkh_nhap.setText("");
					btn_timKh.setEnabled(false);
					txt_sdtkh.setText("");
					txt_masp.setText("");
					btn_xoasp.setEnabled(false);
					lbl_tongtien_nhap.setText("");
					lbl_tongcongVAT_nhap.setText("");
					lbl_tienthua_nhap.setText("");
					kh = null;
					btn_huyhoadon.setEnabled(false);
					btn_luutam.setEnabled(false);
					txt_tiennhan.setText("");
				}
			}
			}
		});
		btn_thanhtoan.setIcon(new ImageIcon("images\\ThanhToanMoi.png"));
		btn_thanhtoan.setBounds(1493, 762, 144, 49);
		add(btn_thanhtoan);
		btn_thanhtoan.setEnabled(false);
		
		btn_xoasp = new JButton("");
		btn_xoasp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int Row = tbl_hoadon.getSelectedRow();
				if(tbl_hoadon.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn sản phẩm cần xóa trong hóa đơn");
				}else {
					String ma = tbl_hoadon.getValueAt(Row, 0).toString();
					int soLuong = Integer.parseInt(tbl_hoadon.getValueAt(Row, 3).toString()) ;
					int soLuongTon = 0;
					for(int i = 0 ;i<tbl_sp.getRowCount();i++) {
						if(tbl_sp.getValueAt(i, 0).equals(ma)) {
							soLuongTon = Integer.parseInt(tbl_sp.getValueAt(i, 2).toString());
							tbl_sp.setValueAt(soLuong+soLuongTon, i, 2);
							break;
						}
					}
					if(tbl_hoadon.getRowCount()==1) {
						lbl_mahd_nhap.setText("");
						btn_thanhtoan.setEnabled(false);
						btn_xoasp.setEnabled(false);
						btn_timKh.setEnabled(false);
						btn_luutam.setEnabled(false);
						btn_huyhoadon.setEnabled(false);
						txt_sdtkh.setText("");
						lbl_tongtien_nhap.setText("");
						lbl_tongcongVAT_nhap.setText("");
						lbl_tenkh_nhap.setText("");
						kh = null;
					}
					try {
						vpp_dao.updateSoLuongTonHDTam(ma, soLuong);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					modelkh1.removeRow(Row);
					tinhTongTien();
					tinhTongCong();
				}
			}
		});
		btn_xoasp.setIcon(new ImageIcon("images\\xoaSp.png"));
		btn_xoasp.setBounds(1339, 762, 144, 49);
		add(btn_xoasp);
		btn_xoasp.setEnabled(false);
		
		lbl_tieude = new JLabel("L\u1EACP H\u00D3A \u0110\u01A0N");
		lbl_tieude.setForeground(Color.WHITE);
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_tieude.setBounds(682, 11, 249, 49);
		add(lbl_tieude);
		
		
		
		btn_sua = new JButton("Hàng Chờ");
		btn_sua.setBounds(1185, 762, 144, 49);
		add(btn_sua);
		
		
		btn_sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogDSHDLuuTam gd = new DialogDSHDLuuTam();
				gd.setVisible(true);
				gd.setLocationRelativeTo(null);
				
			}
		});
//		btn_sua.setIcon(new ImageIcon("images\\SuaSp.png"));
		
		
		lbl_backgroundtong = new JLabel("");
		lbl_backgroundtong.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_backgroundtong.setBounds(0, 0, 1680, 875);
		add(lbl_backgroundtong);
		
		btn_huyhoadon.setEnabled(false);
		guithemkh();
//		txt_masp.addKeyListener(new CustomKeyListener());
		btn_luutam.setEnabled(false);
		

	}
	
	private void loadSPTableTimKiem(SanPham sp) {
		if(sp.getMaSP().startsWith("VPP")) {
			String dvt ="";
			dvt = vpp_dao.getDonViTinhVPP(sp.getMaSP());
			modelkh.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getSoLuongTon(),dvt,sp.getGiaBan()});
		}else {
			modelkh.addRow(new Object[] {sp.getMaSP(),sp.getTenSP(),sp.getSoLuongTon(),"Quyển",sp.getGiaBan()});
		}
		
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
	
	private void addSPVaoHD() {
		int Row = tbl_sp.getSelectedRow();
		String ma = tbl_sp.getValueAt(Row, 0).toString();
		String tenSp = tbl_sp.getValueAt(Row, 1).toString();
		String soLuong = txt_soluongsp.getText();
		String dvt = tbl_sp.getValueAt(Row, 3).toString();
		String giaBan = tbl_sp.getValueAt(Row, 4).toString();
		int sl = Integer.parseInt(soLuong);
		double dg = Double.parseDouble(giaBan);
		double thanhTien = sl*dg;
		int check = 0;
		if(tbl_hoadon.getRowCount()==0) {
			try {
				lbl_mahd_nhap.setText(hd_dao.phatSinhMaHD());
				btn_huyhoadon.setEnabled(true);
				btn_timKh.setEnabled(true);
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for(int i = 0 ; i<tbl_hoadon.getRowCount();i++) {
			if(tbl_hoadon.getValueAt(i, 0).equals(ma)) {
				String sldc = tbl_hoadon.getValueAt(i, 3).toString();
				int sldcInt = Integer.parseInt(sldc);
				check =1;
				JOptionPane.showMessageDialog(null, "Cập Nhập Số Lượng Thành Công");
				tbl_hoadon.setValueAt(sldcInt+sl, i, 3);
				double dg1 = Double.parseDouble(tbl_hoadon.getValueAt(i, 2).toString());
				tbl_hoadon.setValueAt((sldcInt+sl)*dg1, i, 5);
				break;
				}
			}
		if(check==0) {
			modelkh1.addRow(new Object[] {ma,tenSp,giaBan,soLuong,dvt,thanhTien});
		}
		
		int slt = Integer.parseInt(tbl_sp.getValueAt(tbl_sp.getSelectedRow(), 2).toString());
		int s = slt - sl;
		try {
			vpp_dao.updateSoLuongTon(ma, sl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		tbl_sp.setValueAt(s,Row, 2);
		
		}
	
	class CustomKeyListener implements KeyListener {
        public void keyTyped(KeyEvent e) {
        	
        }
 
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
               
            }
        }
 
        public void keyReleased(KeyEvent e) {
//        		maTemp = txt_masp.getText();
//        		txt_tensp.setText(vpp_dao.selectTenSP(maTemp));
//        	vpp_dao.dsSPTimKiem(txt_masp, modelkh,tbl_sp);
        	
        }
    }
	
	private void tinhTongTien() {
		DecimalFormat dfm = new DecimalFormat("###,###.#VND");
		tongTien = 0;
		for(int i = 0; i<tbl_hoadon.getRowCount();i++) {
			double tt = Double.parseDouble(tbl_hoadon.getValueAt(i, 5).toString());
			tongTien = tongTien + tt;
			
		}
		String tong = dfm.format(tongTien);
		lbl_tongtien_nhap.setText(tong);
	}
	
	private void tinhTongCong() {
		double tc = (tongTien *0.1) + tongTien;
		DecimalFormat dfm = new DecimalFormat("###,###.#VND");
		tongThanhToan = dfm.format(tc);
		
		lbl_tongcongVAT_nhap.setText(tongThanhToan);
	}
	private void xuatHoaDon(String ma) {
		
		try {
			Hashtable map = new Hashtable();
			JasperReport jrp = JasperCompileManager.compileReport("D:\\Java\\20118191_NguyenThanhSang\\Nhom02_QuanLyNhaSach_PTUD-abc\\src\\gui\\XuatHoaDon.jrxml");
			map.put("sMahd", ma);
			Connection con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databasename=QuanLyHieuSach","sa","10102002Hh");
			JasperPrint p = JasperFillManager.fillReport(jrp, map,con);
			JasperViewer.viewReport(p,false);
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void huyHD() {
		for(int i = 0 ;i<tbl_hoadon.getRowCount();i++) {
			String ma = tbl_hoadon.getValueAt(i, 0).toString();
			String sl = tbl_hoadon.getValueAt(i, 3).toString();
			int sluong = Integer.parseInt(sl);
			try {
				vpp_dao.updateSoLuongTonHDTam(ma, sluong);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while (tbl_hoadon.getRowCount() != 0) {
			modelkh1.removeRow(0);
		}
		while (tbl_sp.getRowCount() != 0) {
			modelkh.removeRow(0);
		}
		lbl_mahd_nhap.setText("");
		btn_thanhtoan.setEnabled(false);
		lbl_tenkh_nhap.setText("");
		btn_timKh.setEnabled(false);
		txt_sdtkh.setText("");
		txt_masp.setText("");
		btn_xoasp.setEnabled(false);
		lbl_tongtien_nhap.setText("");
		lbl_tongcongVAT_nhap.setText("");
		lbl_tienthua_nhap.setText("");
		btn_luutam.setEnabled(false);
		kh = null;
	}
	private boolean ktraTxtsl() {
		String soluong = txt_soluongsp.getText().toString();
		if(!(soluong.length()>0 && soluong.matches("[0-9']+"))) {
			
			thongBao("Số lượng không hợp lệ", txt_soluongsp);
			return false;
		}
		int sl = Integer.parseInt(txt_soluongsp.getText());
		if(sl<=0) {
			thongBao("Số lượng phải lớn hơn 0", txt_soluongsp);
			return false;
		}
		return true;
	}
	
	private boolean ktraTxtsdt() {
		String sdt = txt_sdtkh.getText().toString();
		if(!(sdt.length()>0 && sdt.matches("^0[0-9]{9}"))) {
			thongBao("Error : SDT có dạng 0xxxxxxxxx", txt_sdtkh);
			return false;
			
		}
		return true;
	}
	
	public void thongBao(String er , JTextField txt) {
		JOptionPane.showMessageDialog(null, er);
		txt.selectAll();
		txt.requestFocus();
	}
	
}

