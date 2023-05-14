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
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import entity.ChiTietHoaDon;

import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DanhSachHoaDonBan_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh, model_cthd;
	private JTable tablekh, tbl_cthd;
	private JScrollPane jscroll;
	private JScrollPane src_cthd;
	private JScrollPane src_hoadon;
	private JLabel lbl_background;
	private JLabel lbl_QuanLyHoaDon;
	private JTextField txt_tkh;
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
	private ArrayList<ChiTietHoaDon> dscthd = null;
	private JLabel lblNewLabel;
	private JLabel lblSdtKhchHng;
	private JTextField txt_sdt;
	private JButton btnNewButton;
	private JLabel lblMHan;
	private JTextField txt_mhd;

	public DanhSachHoaDonBan_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		
		
		JPanel pnl_HD = new JPanel();
		pnl_HD.setBackground(Color.WHITE);
		pnl_HD.setLayout(null);
		pnl_HD.setBounds(821, 106, 827, 705);
		add(pnl_HD);
		
		String[] headers1 = { "Mã Sản Phẩm", "Tên Sản Phẩm", "Số Lượng" ,"Đơn giá","Thành tiền"};
		model_cthd = new DefaultTableModel(headers1, 0);
		tbl_cthd = new JTable(model_cthd);
		src_cthd = new JScrollPane(tbl_cthd);
		
		src_cthd.setBounds(0, 133, 805, 573);
		pnl_HD.add(src_cthd);
		src_cthd.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách Hóa đơn bán", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		
		JLabel lbl_tieudetkCTHD = new JLabel("Chi Tiết Hóa Đơn");
		lbl_tieudetkCTHD.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieudetkCTHD.setFont(new Font("Times New Roman", Font.BOLD, 23));
		lbl_tieudetkCTHD.setBounds(0, 57, 817, 27);
		pnl_HD.add(lbl_tieudetkCTHD);
		
		JPanel pnl_CTHD = new JPanel();
		pnl_CTHD.setBackground(SystemColor.inactiveCaptionBorder);
		pnl_CTHD.setBounds(10, 105, 805, 706);
		add(pnl_CTHD);
		pnl_CTHD.setLayout(null);
		
		String[] headers = { "Mã hóa đơn", "Thu Ngân", "Khách Hàng","Ngày lập","Tổng Tiền"};
		modelkh = new DefaultTableModel(headers, 0);
		tablekh = new JTable(modelkh);
		tablekh.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
//				while (tbl_cthd.getRowCount() != 0) {
//					model_cthd.removeRow(0);
//				}
//				ArrayList<ChiTietHoaDon> dscthd = null;
//				int row = tablekh.getSelectedRow();
//				String mahd = tablekh.getValueAt(row, 0).toString();
//				dscthd = cthd_dao.getCthdTheoMa(mahd);
//				for (ChiTietHoaDon cthd : dscthd) {
//					model_cthd.addRow(new Object[] {cthd.getSp().getMaSP(),cthd.getSp().getTenSP(),cthd.getSoLuong(),cthd.getSp().getGiaBan(),cthd.thanhTien()});
//				}
//				dscthd = null;
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				while (tbl_cthd.getRowCount() != 0) {
					model_cthd.removeRow(0);
				}
				
				int row = tablekh.getSelectedRow();
				String mahd = tablekh.getValueAt(row, 0).toString();
				dscthd = cthd_dao.getCthdTheoMa(mahd);
				for (ChiTietHoaDon cthd : dscthd) {
					model_cthd.addRow(new Object[] {cthd.getSp().getMaSP(),cthd.getSp().getTenSP(),cthd.getSoLuong(),cthd.getSp().getGiaBan(),cthd.thanhTien()});
				}
				dscthd = null;
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		src_hoadon = new JScrollPane(tablekh);
		src_hoadon.setBounds(0, 133, 805, 573);
		pnl_CTHD.add(src_hoadon);
		src_hoadon.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách Hóa đơn bán", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		ImageIcon icon = new ImageIcon("images_icon\\search-interface-symbol.png");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		txt_tkh = new JTextField();
//		txt_maHD.addKeyListener(new KeyAdapter() {
//			@Override
//			public void keyReleased(KeyEvent e) {
//				hd_dao.dsHoaDonTimKiem(txt_maHD, modelkh, tablekh);
//				
//			}
//		});
		txt_tkh.setBounds(153, 66, 395, 34);
		pnl_CTHD.add(txt_tkh);
		txt_tkh.setColumns(10);
		
		lblNewLabel = new JLabel("Tên khách hàng : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(21, 68, 129, 26);
		pnl_CTHD.add(lblNewLabel);
		
		lblSdtKhchHng = new JLabel("SDT khách hàng : ");
		lblSdtKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSdtKhchHng.setBounds(21, 19, 129, 26);
		pnl_CTHD.add(lblSdtKhchHng);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(153, 17, 146, 34);
		pnl_CTHD.add(txt_sdt);
		
		btnNewButton = new JButton("Tìm kiếm");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_sdt.getText().equals("") && txt_mhd.getText().equals("") && txt_tkh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin tìm kiếm!");
				}else {
					String sql = "SELECT DISTINCT  dbo.HoaDon.MaHoaDon, dbo.HoaDon.MaKhachHang, dbo.HoaDon.MaNhanVien, dbo.HoaDon.NgayLapHoaDon, dbo.HoaDon.TongTien, dbo.KhachHang.TenKhachHang, dbo.NhanVien.TenNhanVien\r\n"
							+ "FROM            dbo.HoaDon INNER JOIN\r\n"
							+ "                         dbo.ChiTietHoaDon ON dbo.HoaDon.MaHoaDon = dbo.ChiTietHoaDon.MaHoaDon INNER JOIN\r\n"
							+ "                         dbo.KhachHang ON dbo.HoaDon.MaKhachHang = dbo.KhachHang.MaKhachHang INNER JOIN\r\n"
							+ "                         dbo.NhanVien ON dbo.HoaDon.MaNhanVien = dbo.NhanVien.MaNhanVien INNER JOIN\r\n"
							+ " 						dbo.SanPham ON dbo.ChiTietHoaDon.MaSanPham = dbo.SanPham.MaSanPham\r\n"
							+ "Where HoaDon.TrangThai = 'dtt' ";
					if(!(txt_sdt.getText().isEmpty())) {
						sql = sql + "and khachhang.SoDienThoai = '"+txt_sdt.getText()+"' ";
					}
					if(!(txt_mhd.getText().isEmpty())) {
						sql = sql + "and hoadon.mahoadon = N'"+txt_mhd.getText()+"' ";
					}
					if(!(txt_tkh.getText().isEmpty())) {
						sql = sql + "and khachhang.tenkhachhang = N'"+txt_tkh.getText()+"' ";
					}
//					System.out.println(sql);
					hd_dao.dsHoaDonTimKiem(sql, modelkh, tablekh);
				}
			}
		});
		btnNewButton.setBounds(640, 88, 122, 34);
		pnl_CTHD.add(btnNewButton);
		
		lblMHan = new JLabel("Mã hóa đơn : ");
		lblMHan.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMHan.setBounds(309, 19, 94, 26);
		pnl_CTHD.add(lblMHan);
		
		txt_mhd = new JTextField();
		txt_mhd.setColumns(10);
		txt_mhd.setBounds(402, 17, 146, 34);
		pnl_CTHD.add(txt_mhd);
		
		lbl_QuanLyHoaDon = new JLabel("QUẢN LÝ HÓA ĐƠN");
		lbl_QuanLyHoaDon.setForeground(Color.WHITE);
		lbl_QuanLyHoaDon.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_QuanLyHoaDon.setBounds(30, 0, 433, 54);
		add(lbl_QuanLyHoaDon);
		
		lbl_background = new JLabel("New label");
		lbl_background.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_background.setBounds(0, 0, 1681, 875);
		add(lbl_background);
		guithemkh();

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
}
