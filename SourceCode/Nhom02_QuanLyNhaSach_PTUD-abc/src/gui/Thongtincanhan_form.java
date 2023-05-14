package gui;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class Thongtincanhan_form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_khachhang;
	private JScrollPane src_khachhang;
	private JLabel lbl_tenNhanvien;
	private JLabel lbl_sdt;
	private JLabel lbl_tieude;
	private JLabel lbl_manv;
	private JLabel lbl_icon;
	private JLabel lbl_khung;
	private JLabel lbl_khungttcn;
	private JLabel lbl_ttcn;
	private JLabel lbl_manv_nhap;
	private JLabel lbl_ngaysinh;
	private JLabel lbl_diachi;
	private JLabel lbl_ngayvaolam;
	private JLabel lbl_chucvu;
	private JLabel lbl_gioitinh;
	private JButton btn_suathongtincn;
	private JTextField txt_diachi;
	private JTextField txt_sdtnv;
	private JTextField txt_ngaysing;
	private JTextField txt_ngayvaolam;
	private JLabel lbl_gioitinh_1;
	private JTextField txt_email;
	private String tendn, paSs, manv;
	ConnectDB cn = new ConnectDB();
	Connection conn;
	private JComboBox comboBox;
	private JLabel lbl_chucvu_nhap;
	private JLabel lbl_tennhap;

	public Thongtincanhan_form(String manv) {
		guithemkh();
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
				lbl_tennhap.setText(rs.getString("TenNhanVien"));
				lbl_manv_nhap.setText(rs.getString("MaNhanVien"));
				txt_ngaysing.setText(rs.getString("NgaySinh"));
				txt_diachi.setText(rs.getString("DiaChi"));
				txt_ngayvaolam.setText(rs.getString("NgayVaoLam"));
				comboBox.setSelectedItem(rs.getString("GioiTinh"));
				comboBox.setEditable(true);
				txt_email.setText(rs.getString("Email"));
				txt_sdtnv.setText(rs.getString("SoDienThoai"));
				lbl_chucvu_nhap.setText(rs.getString("ChucVu"));
				// txt_email.setText("dsf"+rs.getString("SoDienThoai"));
				// txt_tenNhap.setText("Mã nhân viên" + rs.getString("TenNhanVien"));
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public Thongtincanhan_form() {
		guithemkh();

	}

	private void guithemkh() {
		// TODO Auto-generated method stub
		jLabel1 = new javax.swing.JLabel();
		setSize(1658, 822);
		setBackground(Color.LIGHT_GRAY);
		setLayout(null);

		///

		JPanel pnl_thongtinkh = new JPanel();
		pnl_thongtinkh.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0, 0, 0)));
		// panel.setBounds(190, 76, 1458, 178);
		pnl_thongtinkh.setBackground(SystemColor.text);
		pnl_thongtinkh.setToolTipText("Thông tin tìm kiếm");
		pnl_thongtinkh.setBounds(70, 66, 1520, 721);
		add(pnl_thongtinkh);
		pnl_thongtinkh.setLayout(null);

		lbl_tenNhanvien = new JLabel("Tên nhân viên :");
		lbl_tenNhanvien.setForeground(Color.WHITE);
		lbl_tenNhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lbl_tenNhanvien.setBounds(28, 365, 257, 52);
		pnl_thongtinkh.add(lbl_tenNhanvien);
		
		lbl_tennhap = new JLabel("");
		lbl_tennhap.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lbl_tennhap.setBounds(324, 364, 222, 53);
		pnl_thongtinkh.add(lbl_tennhap);

		lbl_sdt = new JLabel("Số điện thoại      :");
		lbl_sdt.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl_sdt.setBounds(28, 623, 178, 48);
		pnl_thongtinkh.add(lbl_sdt);

		lbl_manv = new JLabel("Mã nhân viên :");
		lbl_manv.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl_manv.setBounds(28, 517, 164, 52);
		pnl_thongtinkh.add(lbl_manv);

		lbl_ttcn = new JLabel("Thông tin cá nhân");
		lbl_ttcn.setFont(new Font("Times New Roman", Font.BOLD, 26));
		lbl_ttcn.setBounds(28, 441, 241, 44);
		pnl_thongtinkh.add(lbl_ttcn);

		lbl_icon = new JLabel("");
		lbl_icon.setIcon(new ImageIcon("images_background\\customer-service-technician-icon-600-w_20171207103233.png"));
		lbl_icon.setBounds(411, 11, 657, 353);
		pnl_thongtinkh.add(lbl_icon);

		lbl_khung = new JLabel("");
		lbl_khung.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_khung.setBounds(0, 373, 1520, 44);
		pnl_thongtinkh.add(lbl_khung);

		lbl_khungttcn = new JLabel("");
		lbl_khungttcn.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_khungttcn.setBounds(0, 441, 1520, 44);
		pnl_thongtinkh.add(lbl_khungttcn);

		lbl_manv_nhap = new JLabel("");
		lbl_manv_nhap.setBounds(202, 529, 193, 25);
		pnl_thongtinkh.add(lbl_manv_nhap);

		lbl_ngaysinh = new JLabel("Ngày sinh :");
		lbl_ngaysinh.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl_ngaysinh.setBounds(452, 517, 123, 52);
		pnl_thongtinkh.add(lbl_ngaysinh);

		txt_ngaysing = new JTextField();
		txt_ngaysing.setColumns(10);
		txt_ngaysing.setBounds(604, 535, 192, 25);
		pnl_thongtinkh.add(txt_ngaysing);

		lbl_diachi = new JLabel("Địa chỉ :");
		lbl_diachi.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl_diachi.setBounds(28, 567, 164, 52);
		pnl_thongtinkh.add(lbl_diachi);

		txt_diachi = new JTextField();
		txt_diachi.setBounds(202, 587, 192, 25);
		pnl_thongtinkh.add(txt_diachi);
		txt_diachi.setColumns(10);

		lbl_ngayvaolam = new JLabel("Ngày vào làm :");
		lbl_ngayvaolam.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl_ngayvaolam.setBounds(452, 567, 164, 52);
		pnl_thongtinkh.add(lbl_ngayvaolam);

		txt_ngayvaolam = new JTextField();
		txt_ngayvaolam.setColumns(10);
		txt_ngayvaolam.setBounds(604, 585, 192, 25);
		pnl_thongtinkh.add(txt_ngayvaolam);

		txt_sdtnv = new JTextField();
		txt_sdtnv.setColumns(10);
		txt_sdtnv.setBounds(203, 639, 192, 25);
		pnl_thongtinkh.add(txt_sdtnv);

		lbl_gioitinh_1 = new JLabel("Email :");
		lbl_gioitinh_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl_gioitinh_1.setBounds(839, 517, 164, 52);
		pnl_thongtinkh.add(lbl_gioitinh_1);

		txt_email = new JTextField();
		txt_email.setColumns(10);
		txt_email.setBounds(959, 535, 192, 25);
		pnl_thongtinkh.add(txt_email);

		lbl_chucvu = new JLabel("Chức vụ  :");
		lbl_chucvu.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl_chucvu.setBounds(452, 623, 178, 48);
		pnl_thongtinkh.add(lbl_chucvu);

		lbl_gioitinh = new JLabel("Giới tính  :");
		lbl_gioitinh.setFont(new Font("Times New Roman", Font.PLAIN, 24));
		lbl_gioitinh.setBounds(839, 567, 164, 52);
		pnl_thongtinkh.add(lbl_gioitinh);

		btn_suathongtincn = new JButton("");
		btn_suathongtincn.setIcon(new ImageIcon("images_button\\SuaHd.png"));
		btn_suathongtincn.setBounds(1302, 668, 208, 42);
		pnl_thongtinkh.add(btn_suathongtincn);

		comboBox = new JComboBox();
		comboBox.setBounds(959, 583, 193, 25);
		pnl_thongtinkh.add(comboBox);
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");

		JButton btn_suathongtincn_1 = new JButton("Lưu");
		btn_suathongtincn_1.setIcon(new ImageIcon("images_button\\Luu.png"));
		btn_suathongtincn_1.setBounds(1302, 597, 208, 42);
		pnl_thongtinkh.add(btn_suathongtincn_1);

		lbl_chucvu_nhap = new JLabel("");
		lbl_chucvu_nhap.setBounds(604, 633, 193, 25);
		pnl_thongtinkh.add(lbl_chucvu_nhap);

		JPanel pnl_ttcn = new JPanel();
		pnl_ttcn.setBounds(80, 76, 1520, 721);
		add(pnl_ttcn);

		lbl_tieude = new JLabel("THÔNG TIN CÁ NHÂN");
		lbl_tieude.setForeground(Color.WHITE);
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_tieude.setBounds(46, 0, 395, 76);
		add(lbl_tieude);
	}
}
