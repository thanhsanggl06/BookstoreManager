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
import java.awt.Window;

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

public class Quenmatkhau_Form {

	private JFrame frm_ChonNguoiDung;
	private Window guiql;
	private JTextField txt_nhapemial;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Quenmatkhau_Form window = new Quenmatkhau_Form();
					window.frm_ChonNguoiDung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Quenmatkhau_Form() {
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

		JPanel pnl_quenmk = new JPanel();
		pnl_quenmk.setBounds(0, 0, 651, 445);
		pnl_quenmk.setBackground(SystemColor.info);
		frm_ChonNguoiDung.getContentPane().add(pnl_quenmk);
		pnl_quenmk.setLayout(null);

		JLabel lbl_TieuDe = new JLabel("Đổi mật khẩu ");
		lbl_TieuDe.setBounds(68, 35, 534, 41);
		pnl_quenmk.add(lbl_TieuDe);
		lbl_TieuDe.setForeground(Color.BLACK);
		lbl_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDe.setBackground(Color.BLACK);
		lbl_TieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));

		JButton btn_NhanVien = new JButton("Hủy");
		btn_NhanVien.setBackground(SystemColor.info);
		btn_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_ChonNguoiDung.setVisible(false);
				DangNhapQuanLy_Form gui_dnql = new DangNhapQuanLy_Form();
				gui_dnql.setVisible(true);
				//dispose();
			}
		});

		btn_NhanVien.setBounds(394, 326, 128, 51);
		pnl_quenmk.add(btn_NhanVien);

		btn_NhanVien.setForeground(new Color(72, 61, 139));
		btn_NhanVien.setBackground(Color.WHITE);
		btn_NhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btn_NguoiQuanLy = new JButton("Xác nhận ");
		btn_NguoiQuanLy.setBackground(Color.WHITE);
		btn_NguoiQuanLy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_ChonNguoiDung.setVisible(false);
				DangNhapQuanLy_Form gui_dnql = new DangNhapQuanLy_Form();
				gui_dnql.setVisible(true);
				//dispose();
			}
		});

		btn_NguoiQuanLy.setBounds(126, 337, 128, 51);
		pnl_quenmk.add(btn_NguoiQuanLy);
		btn_NguoiQuanLy.setForeground(new Color(72, 61, 139));
		btn_NguoiQuanLy.setBackground(Color.WHITE);
		btn_NguoiQuanLy.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbl_nhapemail = new JLabel("Nhập Email      :");
		lbl_nhapemail.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_nhapemail.setBounds(56, 135, 198, 28);
		pnl_quenmk.add(lbl_nhapemail);
		
		txt_nhapemial = new JTextField();
		txt_nhapemial.setColumns(10);
		txt_nhapemial.setBounds(246, 134, 252, 29);
		pnl_quenmk.add(txt_nhapemial);

		JLabel lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon("images_background\\background-xam.jpg"));
		lbl_background.setForeground(SystemColor.textHighlight);
		lbl_background.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_background.setBounds(0, 0, 651, 456);

		pnl_quenmk.add(lbl_background);

	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frm_ChonNguoiDung.setVisible(true);
		DangNhapQuanLy_Form guidnql = new DangNhapQuanLy_Form();
		//guiql.setVisible(true);
	}
}
