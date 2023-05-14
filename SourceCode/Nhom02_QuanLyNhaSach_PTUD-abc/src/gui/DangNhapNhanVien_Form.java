package gui;

import javax.swing.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;
import javax.accessibility.Accessible;
import javax.management.loading.PrivateClassLoader;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.TabableView;
import javax.swing.JOptionPane;
import connectDB.ConnectDB;
import dao.KhachHang_DAO;
import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;

import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;

public class DangNhapNhanVien_Form extends JFrame implements ActionListener {

	private JTextField txt_UserName;
	private JPasswordField passwordField;
	private JPanel pnl_dangnhap;
	private JPanel pnl_dangnhapform;
	private JLabel lbl_backgrounddngnhap;
	private JLabel lbl_matkhau;
	private JLabel lbl_taikhoan;
	private JButton btn_dangnhap;
	private JLabel lbl_login;
	private JButton btn_quenmk;
	private JPanel pnl_dangnhap2;
	private JPanel pnl_chonquyen;
	private JLabel lbl_back;
	private JLabel lbl_nutdangnhap;
	private JComponent lbl_nhanvien;
	private JLabel lbl_backrounddangnhap;
	private JLabel lbl_backgrounddn2;
	private JLabel lbl_anh1;
	private JLabel lblNewLabel;
	private TaiKhoan_DAO tk_dao;
	ConnectDB cn = new ConnectDB();
	Connection conn;

	public DangNhapNhanVien_Form() {

		setTitle("Đăng nhập hệ thống");
		setSize(1850, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		tk_dao = new TaiKhoan_DAO();
		pnl_dangnhapform = new JPanel();
		pnl_dangnhapform.setBackground(Color.PINK);
		getContentPane().add(pnl_dangnhapform);
		pnl_dangnhapform.setLayout(null);

		pnl_dangnhap = new JPanel();

		pnl_dangnhap.setBounds(551, 255, 700, 449);
		pnl_dangnhapform.add(pnl_dangnhap);
		pnl_dangnhap.setLayout(null);

		lbl_backgrounddngnhap = new JLabel("");
		lbl_backgrounddngnhap.setIcon(new ImageIcon("images\\New Wireframe 2.png"));
		lbl_backgrounddngnhap.setBackground(new Color(0, 0, 0));
		lbl_backgrounddngnhap.setForeground(SystemColor.textHighlight);
		lbl_backgrounddngnhap.setBounds(391, 25, 78, 76);
		pnl_dangnhap.add(lbl_backgrounddngnhap);

		lbl_matkhau = new JLabel("Mật khẩu  ");
		lbl_matkhau.setForeground(Color.WHITE);
		lbl_matkhau.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_matkhau.setBounds(320, 217, 151, 38);
		pnl_dangnhap.add(lbl_matkhau);

		passwordField = new JPasswordField();
		passwordField.setForeground(SystemColor.activeCaptionBorder);
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setText("");
				passwordField.setEchoChar('*');
				passwordField.setForeground(new Color(0, 0, 0));
			}
		});
		passwordField.setBounds(320, 266, 311, 34);
		pnl_dangnhap.add(passwordField);
		passwordField.setText("Mật khẩu");
		passwordField.setEchoChar((char) 0);

		lbl_taikhoan = new JLabel("Tài khoản ");
		lbl_taikhoan.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_taikhoan.setForeground(Color.WHITE);
		lbl_taikhoan.setBackground(Color.BLACK);
		lbl_taikhoan.setBounds(320, 125, 136, 34);
		pnl_dangnhap.add(lbl_taikhoan);

		txt_UserName = new JTextField();
		txt_UserName.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_UserName.setText("");
				passwordField.setEchoChar((char) 0);
				txt_UserName.setForeground(new Color(0, 0, 0));
			}
		});
		txt_UserName.setForeground(SystemColor.activeCaptionBorder);
		txt_UserName.setText("Tên đăng nhập");
		txt_UserName.setToolTipText("uses\r\n");
		txt_UserName.setBounds(320, 170, 311, 36);
		pnl_dangnhap.add(txt_UserName);
		txt_UserName.setColumns(10);

		btn_dangnhap = new JButton("LOGIN");

		btn_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					conn = cn.getConnection();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				DangNhapNhanVien_Form dnnv = new DangNhapNhanVien_Form();
				String tendn = txt_UserName.getText().toString().trim();
				String paSs = passwordField.getText().toString().trim();
				TaiKhoan_DAO.manv = null;
				StringBuffer sb = new StringBuffer();
				if (tendn.equals("")) {
					sb.append("Tài khoản không được để trống \n");
				}
				if (paSs.equals("")) {
					sb.append("Mật khẩu không được để trống");
				}
				if (sb.length() > 0) {
					JOptionPane.showMessageDialog(null, sb.toString());
					return;
				}
				String sql_login = "Select * from TaiKhoan where TenDangNhap=? and Password =? and phanQuyen = N'Nhân Viên'";
				try {
					PreparedStatement pst = conn.prepareStatement(sql_login);
					pst.setString(1, tendn);
					pst.setString(2, paSs);
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(dnnv, "Đăng nhập thành công ");
						TaiKhoan_DAO.manv = rs.getString("MaNhanVien");
						getContentPane().removeAll();
						getContentPane().add(new Jpanel_ChaoGuiNV());
						getContentPane().repaint();
						getContentPane().revalidate();
						new Thongtincanhan_form(TaiKhoan_DAO.manv).setVisible(true);

					} else {
						JOptionPane.showMessageDialog(dnnv, "Sai tài khoản hoặc mật kh ");
						txt_UserName.setText("");
						passwordField.setText("");
					}

				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});

//		GUI_TrangChuNhanVien gui_TrangChuNhanVien = new GUI_TrangChuNhanVien();
//		gui_TrangChuNhanVien.setVisible(true);
//		dispose();
		btn_dangnhap.setIcon(new ImageIcon("images\\w.png"));
		btn_dangnhap.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 32));
		btn_dangnhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_dangnhap.setBounds(391, 383, 176, 55);
		pnl_dangnhap.add(btn_dangnhap);

		lbl_login = new JLabel("LOGIN");
		lbl_login.setForeground(Color.WHITE);
		lbl_login.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		lbl_login.setBounds(467, 33, 110, 68);
		pnl_dangnhap.add(lbl_login);

		btn_quenmk = new JButton("Quên mật khẩu ?");
		btn_quenmk.setBackground(new Color(255, 255, 255));
		btn_quenmk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogQuenMK qmk = new DialogQuenMK();
				qmk.setVisible(true);
				qmk.setLocationRelativeTo(getContentPane());
			}
		});
		btn_quenmk.setFont(new Font("Tahoma", Font.BOLD, 16));
		btn_quenmk.setForeground(new Color(30, 144, 255));
		btn_quenmk.setBorderPainted(false);
		btn_quenmk.setContentAreaFilled(false);
		btn_quenmk.setBounds(467, 311, 176, 23);
		pnl_dangnhap.add(btn_quenmk);

		JButton button = new JButton("");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar((char) 0);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				passwordField.setEchoChar('*');
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// passwordField.setEchoChar('*');
			}
		});

		button.setBorderPainted(false);
		button.setContentAreaFilled(false);
		button.setIcon(new ImageIcon("images\\conmat2.png"));
		button.setBounds(623, 266, 52, 23);

		pnl_dangnhap.add(button);

		pnl_dangnhap2 = new JPanel();
		pnl_dangnhap2.setBackground(new Color(51, 102, 153));
		pnl_dangnhap2.setBounds(215, 0, 42, 412);
		pnl_dangnhap.add(pnl_dangnhap2);
		pnl_dangnhap2.setLayout(new BorderLayout(0, 0));

		lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		pnl_dangnhap2.add(lblNewLabel, BorderLayout.CENTER);

		pnl_chonquyen = new JPanel();
		pnl_chonquyen.setBackground(Color.WHITE);
		pnl_chonquyen.setBounds(0, 0, 216, 68);
		pnl_dangnhap.add(pnl_chonquyen);
		pnl_chonquyen.setLayout(null);

		lbl_back = new JLabel("");
		lbl_back.setBounds(84, 11, 48, 48);
		pnl_chonquyen.add(lbl_back);
		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DangNhapNhanVien_Form dangNhapNhanVien_Form = new DangNhapNhanVien_Form();
				ChonNguoiDung_Form ChonNguoiDung = new ChonNguoiDung_Form();
				ChonNguoiDung.main(null);
				dangNhapNhanVien_Form.setVisible(false);
				dispose();

			}
		});
		lbl_back.setIcon(new ImageIcon("images_icon\\Back.png"));

		lbl_nutdangnhap = new JLabel("");
		lbl_nutdangnhap.setIcon(new ImageIcon("images_icon\\DangnhapNV.png"));
		lbl_nutdangnhap.setBounds(44, 194, 146, 90);
		pnl_dangnhap.add(lbl_nutdangnhap);

		lbl_nhanvien = new JLabel("Nhân Viên");
		lbl_nhanvien.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		lbl_nhanvien.setBounds(44, 144, 146, 29);
		pnl_dangnhap.add(lbl_nhanvien);

		lbl_backrounddangnhap = new JLabel("");
		// lblNewLabel_2_1_1.setBackground(getForeground());
		lbl_backrounddangnhap.setBounds(0, -27, 743, 439);
		pnl_dangnhap.add(lbl_backrounddangnhap);
		lbl_backrounddangnhap
				.setIcon(new ImageIcon("images_background\\50-Beautiful-and-Minimalist-Presentation-Backgroun.jpg"));
		lbl_backrounddangnhap.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_backrounddangnhap.setForeground(Color.RED);
		lbl_backrounddangnhap.setBackground(new Color(176, 224, 230));

		lbl_backgrounddn2 = new JLabel("");
		lbl_backgrounddn2.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_backgrounddn2.setBounds(-546, -254, 1799, 861);
		pnl_dangnhap.add(lbl_backgrounddn2);

		lbl_anh1 = new JLabel("");
		lbl_anh1.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_anh1.setBounds(0, 0, 1834, 861);
		pnl_dangnhapform.add(lbl_anh1);

		btn_dangnhap.addActionListener(this);
		btn_quenmk.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapNhanVien_Form frame = new DangNhapNhanVien_Form();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
