package gui;

import javax.swing.*;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.table.DefaultTableModel;
import javax.accessibility.Accessible;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import javax.swing.text.TabableView;

import connectDB.ConnectDB;
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

public class DangNhapQuanLy_Form extends JFrame implements ActionListener {

	private JTextField txt_name;
	private JPasswordField passwordField;
	private JPanel pnl_dangnhapql;
	private JPanel pnl_dnql;
	private JLabel lbl_background;
	private JLabel lbl_mkdn;
	private JLabel lbl_taikhoanql;
	private JButton btn_login;
	private JLabel lbl_login;
	private JButton btn_quenmk;
	private JButton btn_nhapnha;
	private JPanel pnl_dangnhapql2;
	private JLabel lbl_back;
	private JPanel pnl_dangql3;
	private JLabel lbl_dangnhapQL;
	private JLabel lbl_iconQL;
	private JLabel lbl_iconbackgr;
	private JLabel lbl_backgroungdql;
	private JLabel lbl_anhnen;
//	public static String manv;
	ConnectDB cn = new ConnectDB();
	Connection conn;
	public DangNhapQuanLy_Form() {
		setTitle("Đăng nhập hệ thống");
		setSize(1850, 900);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);

		pnl_dangnhapql = new JPanel();
		pnl_dangnhapql.setBackground(Color.PINK);
		getContentPane().add(pnl_dangnhapql);
		pnl_dangnhapql.setLayout(null);

		pnl_dnql = new JPanel();
		pnl_dnql.setBounds(551, 255, 700, 449);
		pnl_dangnhapql.add(pnl_dnql);
		pnl_dnql.setLayout(null);

		lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon("images\\New Wireframe 2.png"));
		lbl_background.setBackground(new Color(0, 0, 0));
		lbl_background.setForeground(SystemColor.textHighlight);
		lbl_background.setBounds(391, 25, 78, 76);
		pnl_dnql.add(lbl_background);

		lbl_mkdn = new JLabel("Mật khẩu  ");
		lbl_mkdn.setForeground(Color.WHITE);
		lbl_mkdn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_mkdn.setBounds(320, 217, 151, 38);
		pnl_dnql.add(lbl_mkdn);

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
		pnl_dnql.add(passwordField);
		passwordField.setText("Mật khẩu");
		passwordField.setEchoChar((char) 0);

		lbl_taikhoanql = new JLabel("Tài khoản ");
		lbl_taikhoanql.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_taikhoanql.setForeground(Color.WHITE);
		lbl_taikhoanql.setBackground(Color.BLACK);
		lbl_taikhoanql.setBounds(320, 125, 136, 34);
		pnl_dnql.add(lbl_taikhoanql);

		txt_name = new JTextField();
		txt_name.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txt_name.setText("");
				passwordField.setEchoChar((char) 0);
				txt_name.setForeground(new Color(0, 0, 0));
			}
		});
		txt_name.setForeground(SystemColor.activeCaptionBorder);
		txt_name.setText("Tên đăng nhập");
		txt_name.setToolTipText("uses\r\n");
		txt_name.setBounds(320, 170, 311, 36);
		pnl_dnql.add(txt_name);
		txt_name.setColumns(10);

		btn_login = new JButton("LOGIN");
		btn_login.setIcon(new ImageIcon("images\\w.png"));
		btn_login.setFont(new Font("Microsoft JhengHei Light", Font.PLAIN, 32));
		btn_login.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				
				
				try {
					conn =cn.getConnection();
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				DangNhapNhanVien_Form dnnv = new DangNhapNhanVien_Form();
				String tendn = txt_name.getText().toString().trim();
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
				String sql_login = "Select * from TaiKhoan where TenDangNhap=? and Password =? and phanQuyen = N'Quản Lý'";
				try {
					PreparedStatement pst = conn.prepareStatement(sql_login);
					pst.setString(1, tendn);
					pst.setString(2, paSs);
					ResultSet rs = pst.executeQuery();
					if (rs.next()) {
						JOptionPane.showMessageDialog(dnnv, "Đăng nhập thành công ");
						TaiKhoan_DAO.manv = rs.getString("MaNhanVien");
						getContentPane().removeAll();
						getContentPane().add(new Jpanel_Chao());
						getContentPane().repaint();
						getContentPane().revalidate();
//						new GUI_TrangChuQuanLy().setVisible(true);
//						new Thongtincanhan_form(TaiKhoan_DAO.manv).setVisible(true);
//						dispose();
						
					} else {
						JOptionPane.showMessageDialog(dnnv, "Sai tài khoản ");
						txt_name.setText("");
						passwordField.setText("");
					}

				} catch (Exception e1) {
					// TODO: handle exception
				}
			}
		});
		btn_login.setBounds(391, 383, 176, 55);
		pnl_dnql.add(btn_login);

		lbl_login = new JLabel("LOGIN");
		lbl_login.setForeground(Color.WHITE);
		lbl_login.setFont(new Font("Eras Demi ITC", Font.PLAIN, 25));
		lbl_login.setBounds(467, 33, 110, 68);
		pnl_dnql.add(lbl_login);

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
		pnl_dnql.add(btn_quenmk);

		btn_nhapnha = new JButton("");
		btn_nhapnha.addMouseListener(new MouseAdapter() {
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

		btn_nhapnha.setBorderPainted(false);
		btn_nhapnha.setContentAreaFilled(false);
		btn_nhapnha.setIcon(new ImageIcon("images\\conmat2.png"));
		btn_nhapnha.setBounds(623, 266, 52, 23);

		pnl_dnql.add(btn_nhapnha);

		pnl_dangnhapql2 = new JPanel();
		pnl_dangnhapql2.setBackground(new Color(51, 102, 153));
		pnl_dangnhapql2.setBounds(215, 0, 52, 412);
		pnl_dnql.add(pnl_dangnhapql2);
		pnl_dangnhapql2.setLayout(new BorderLayout(0, 0));

		lbl_back = new JLabel("");
		lbl_back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DangNhapQuanLy_Form dangNhapNhanVien_Form = new DangNhapQuanLy_Form();

				ChonNguoiDung_Form ChonNguoiDung = new ChonNguoiDung_Form();
				ChonNguoiDung.main(null);
				dangNhapNhanVien_Form.setVisible(false);
				dispose();

			}
		});
		lbl_back.setIcon(new ImageIcon("images_icon\\Back.png"));
		lbl_back.setBounds(85, 0, 67, 76);
		pnl_dnql.add(lbl_back);

		pnl_dangql3 = new JPanel();
		pnl_dangql3.setBackground(Color.BLACK);
		pnl_dangql3.setBounds(0, 73, 216, 3);
		pnl_dnql.add(pnl_dangql3);

		lbl_dangnhapQL = new JLabel("");
		lbl_dangnhapQL.setIcon(new ImageIcon("images_icon\\DangnhapNV.png"));
		lbl_dangnhapQL.setBounds(44, 194, 146, 90);
		pnl_dnql.add(lbl_dangnhapQL);

		lbl_iconQL = new JLabel("Quản lý ");
		lbl_iconQL.setFont(new Font("Times New Roman", Font.PLAIN, 31));
		lbl_iconQL.setBounds(55, 142, 146, 29);
		pnl_dnql.add(lbl_iconQL);

		lbl_iconbackgr = new JLabel("");
		lbl_iconbackgr.setBounds(0, -27, 743, 439);
		pnl_dnql.add(lbl_iconbackgr);
		lbl_iconbackgr
				.setIcon(new ImageIcon("images_background\\50-Beautiful-and-Minimalist-Presentation-Backgroun.jpg"));
		lbl_iconbackgr.setHorizontalAlignment(SwingConstants.TRAILING);
		lbl_iconbackgr.setForeground(Color.RED);
		lbl_iconbackgr.setBackground(new Color(176, 224, 230));

		lbl_backgroungdql = new JLabel("");
		lbl_backgroungdql.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_backgroungdql.setBounds(-546, -254, 1799, 861);
		pnl_dnql.add(lbl_backgroungdql);

		lbl_anhnen = new JLabel("");
		lbl_anhnen.setIcon(new ImageIcon("images_background\\background-xam (1).jpg"));
		lbl_anhnen.setBounds(0, 0, 1834, 861);
		pnl_dangnhapql.add(lbl_anhnen);

		btn_login.addActionListener(this);
		btn_quenmk.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapQuanLy_Form frame = new DangNhapQuanLy_Form();
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
