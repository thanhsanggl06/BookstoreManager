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

public class DoiMatKhauTCQL {

	private JFrame frm_ChonNguoiDung;
	private JTextField txt_mkhientai;
	private JTextField txt_mkmoi;
	private Window guiql;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiMatKhauTCQL window = new DoiMatKhauTCQL();
					window.frm_ChonNguoiDung.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public DoiMatKhauTCQL() {
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

		JPanel pnl_doimkql = new JPanel();
		pnl_doimkql.setBounds(0, 0, 651, 445);
		pnl_doimkql.setBackground(SystemColor.info);
		frm_ChonNguoiDung.getContentPane().add(pnl_doimkql);
		pnl_doimkql.setLayout(null);

		JLabel lbl_TieuDe = new JLabel("Đổi mật khẩu ");
		lbl_TieuDe.setBounds(68, 35, 534, 41);
		pnl_doimkql.add(lbl_TieuDe);
		lbl_TieuDe.setForeground(Color.BLACK);
		lbl_TieuDe.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_TieuDe.setBackground(Color.BLACK);
		lbl_TieuDe.setFont(new Font("Tahoma", Font.BOLD, 20));

		JButton btn_NhanVien = new JButton("Hủy");
		btn_NhanVien.setBackground(SystemColor.info);
		btn_NhanVien.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_ChonNguoiDung.setVisible(false);
				GUI_TrangChuQuanLy gui_trangchuql = new GUI_TrangChuQuanLy();
				gui_trangchuql.setVisible(true);
				dispose();
			}
		});

		btn_NhanVien.setBounds(416, 359, 128, 51);
		pnl_doimkql.add(btn_NhanVien);

		btn_NhanVien.setForeground(new Color(72, 61, 139));
		btn_NhanVien.setBackground(Color.WHITE);
		btn_NhanVien.setFont(new Font("Tahoma", Font.BOLD, 15));

		JButton btn_xacnhan = new JButton("Xác nhận ");
		btn_xacnhan.setBackground(Color.WHITE);
		btn_xacnhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frm_ChonNguoiDung.setVisible(false);
				GUI_TrangChuQuanLy gui_dangnhapQL = new GUI_TrangChuQuanLy();
				gui_dangnhapQL.setVisible(true);
				dispose();
			}
		});

		btn_xacnhan.setBounds(124, 359, 128, 51);
		pnl_doimkql.add(btn_xacnhan);
		btn_xacnhan.setForeground(new Color(72, 61, 139));
		btn_xacnhan.setBackground(Color.WHITE);
		btn_xacnhan.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbl_matkhaumoi = new JLabel("Mật khẩu mới       :");
		lbl_matkhaumoi.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_matkhaumoi.setBounds(54, 198, 198, 28);
		pnl_doimkql.add(lbl_matkhaumoi);
		
		JLabel lbl_matkhauhientaij = new JLabel("Mật khẩu hiện tại :");
		lbl_matkhauhientaij.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_matkhauhientaij.setBounds(54, 145, 198, 21);
		pnl_doimkql.add(lbl_matkhauhientaij);
		
		txt_mkhientai = new JTextField();
		txt_mkhientai.setBounds(281, 146, 263, 28);
		pnl_doimkql.add(txt_mkhientai);
		txt_mkhientai.setColumns(10);
		
		txt_mkmoi = new JTextField();
		txt_mkmoi.setBounds(282, 196, 252, 29);
		pnl_doimkql.add(txt_mkmoi);
		txt_mkmoi.setColumns(10);

		JLabel lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon("images_background\\background-xam.jpg"));
		lbl_background.setForeground(SystemColor.textHighlight);
		lbl_background.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_background.setBounds(0, 0, 651, 456);

		pnl_doimkql.add(lbl_background);

	}

	protected void dispose() {
		// TODO Auto-generated method stub
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frm_ChonNguoiDung.setVisible(true);
		GUI_TrangChuQuanLy guiql = new GUI_TrangChuQuanLy();
		//guiql.setVisible(true);
	}
}
