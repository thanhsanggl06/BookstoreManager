package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;
import javax.swing.JToolBar;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;
import java.awt.Window.Type;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import java.awt.FlowLayout;

public class ChonNguoiDung_Form {

	private JFrame frm_ChonNguoiDung;
	private JLabel lbl_IconNhanVien, lbl_IconQuanLy, lbl_TieuDe, lblBackG1, lbl_Anhnen;
	private JPanel pnl_chonnd, pnl_cnd1, pnl_NhanVien, pnl_QuanLy, pnl_anh;
	private JButton btn_NhanVien, btn_NguoiQuanLy;
	private JLayeredPane layeredPane;
	public static DangNhapQuanLy_Form gui_dangnhapQL = null;
	public static DangNhapNhanVien_Form gui_dangnhapNV = null;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChonNguoiDung_Form window = new ChonNguoiDung_Form();
					window.frm_ChonNguoiDung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		System.gc();
	}

	public ChonNguoiDung_Form() {
		initialize();
	}

	private void initialize() {
		frm_ChonNguoiDung = new JFrame();
		frm_ChonNguoiDung.setType(Type.UTILITY);
		frm_ChonNguoiDung.getContentPane().setBackground(new Color(72, 61, 139));
		frm_ChonNguoiDung.setResizable(false);
		frm_ChonNguoiDung.setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		frm_ChonNguoiDung.setTitle("Chọn người dùng");
		frm_ChonNguoiDung.setBounds(100, 100, 667, 484);
		frm_ChonNguoiDung.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm_ChonNguoiDung.setLocationRelativeTo(null);
		frm_ChonNguoiDung.getContentPane().setLayout(null);

		pnl_chonnd = new JPanel();
		pnl_chonnd.setForeground(new Color(51, 0, 51));
		pnl_chonnd.setBackground(Color.BLACK);
		pnl_chonnd.setLayout(null);
		pnl_chonnd.setBounds(0, 111, 651, 213);
		frm_ChonNguoiDung.getContentPane().add(pnl_chonnd);

		lbl_IconNhanVien = new JLabel("");
		lbl_IconNhanVien.setForeground(Color.DARK_GRAY);
		lbl_IconNhanVien.setIcon(new ImageIcon("images_icon\\Quanly-removebg-preview.png"));
		lbl_IconNhanVien.setBackground(Color.LIGHT_GRAY);
		lbl_IconNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IconNhanVien.setBounds(65, 11, 251, 191);
		pnl_chonnd.add(lbl_IconNhanVien);

		lbl_IconQuanLy = new JLabel("");
		lbl_IconQuanLy.setIcon(new ImageIcon("images_icon\\NhanVien.png"));
		lbl_IconQuanLy.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_IconQuanLy.setBounds(361, 11, 251, 174);
		pnl_chonnd.add(lbl_IconQuanLy);

		pnl_cnd1 = new JPanel();
		pnl_cnd1.setBounds(0, 0, 651, 445);
		pnl_cnd1.setBackground(SystemColor.info);
		frm_ChonNguoiDung.getContentPane().add(pnl_cnd1);
		pnl_cnd1.setLayout(null);

		lbl_TieuDe = new JLabel("CHỌN QUYỀN ĐĂNG NHẬP");
		lbl_TieuDe.setBounds(68, 35, 534, 41);
		pnl_cnd1.add(lbl_TieuDe);
		lbl_TieuDe.setForeground(Color.BLACK);
		lbl_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDe.setBackground(Color.BLACK);
		lbl_TieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));

		btn_NhanVien = new JButton("NHÂN VIÊN");
		btn_NhanVien.setBackground(SystemColor.info);
		btn_NhanVien.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				frm_ChonNguoiDung.setVisible(false);
				gui_dangnhapNV = new DangNhapNhanVien_Form();
				gui_dangnhapNV.setVisible(true);
				dispose();
			}
		});

		btn_NhanVien.setBounds(416, 359, 128, 51);
		pnl_cnd1.add(btn_NhanVien);

		btn_NhanVien.setForeground(new Color(72, 61, 139));
		btn_NhanVien.setBackground(Color.WHITE);
		btn_NhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));

		btn_NguoiQuanLy = new JButton("QUẢN LÝ");
		btn_NguoiQuanLy.setBackground(Color.WHITE);
		btn_NguoiQuanLy.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				frm_ChonNguoiDung.setVisible(false);
				gui_dangnhapQL = new DangNhapQuanLy_Form();
				gui_dangnhapQL.setVisible(true);
				dispose();
			}
		});

		btn_NguoiQuanLy.setBounds(124, 359, 128, 51);
		pnl_cnd1.add(btn_NguoiQuanLy);
		btn_NguoiQuanLy.setForeground(new Color(72, 61, 139));
		btn_NguoiQuanLy.setBackground(Color.WHITE);
		btn_NguoiQuanLy.setFont(new Font("Tahoma", Font.BOLD, 15));

		lblBackG1 = new JLabel("");
		lblBackG1.setBounds(0, 0, 534, 41);
		pnl_cnd1.add(lblBackG1);
		lblBackG1.setHorizontalAlignment(SwingConstants.LEFT);

		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 333, 534, -332);
		pnl_cnd1.add(layeredPane);

		pnl_NhanVien = new JPanel();
		pnl_NhanVien.setBackground(Color.GREEN);
		pnl_NhanVien.setBounds(0, -333, 534, 331);
		layeredPane.add(pnl_NhanVien);

		pnl_QuanLy = new JPanel();
		pnl_QuanLy.setBackground(Color.MAGENTA);
		pnl_QuanLy.setBounds(0, -334, 534, 335);
		layeredPane.add(pnl_QuanLy);

		pnl_anh = new JPanel();
		pnl_anh.setBackground(Color.CYAN);
		pnl_anh.setBounds(0, -334, 534, 334);
		layeredPane.add(pnl_anh);

		lbl_Anhnen = new JLabel("");
		lbl_Anhnen.setIcon(new ImageIcon("images_background\\background-xam.jpg"));
		lbl_Anhnen.setForeground(SystemColor.textHighlight);
		lbl_Anhnen.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Anhnen.setBounds(0, 0, 651, 456);

		pnl_cnd1.add(lbl_Anhnen);

	}

	protected void dispose() {
		// TODO Auto-generated method stub

	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frm_ChonNguoiDung.setVisible(true);
	}
}
