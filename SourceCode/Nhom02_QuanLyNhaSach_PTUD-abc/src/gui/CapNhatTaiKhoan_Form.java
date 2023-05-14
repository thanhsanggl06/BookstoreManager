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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

import com.lowagie.text.pdf.PdfWriter;
import com.toedter.calendar.JDateChooser;

import dao.NhanVien_DAO;
import dao.TaiKhoan_DAO;
import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.xml.bind.DatatypeConverter;

import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;

public class CapNhatTaiKhoan_Form extends JPanel implements ActionListener, MouseListener {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_taikhoan;
	private JScrollPane src_taikhoan;
	private JLabel lbl_maNV;
	private JLabel lbl_tenTk;
	private JTextField txt_tentk;
	private JLabel lbl_backgroundtaikhoan;
	private JLabel lbl_tieudetaikhoan;
	private JLabel lbl_matkhau;
	private JButton btn_themTk;
	private JButton btn_xoatk;
	private JButton btn_suaTK;
	private JButton btn_xoatrang;
	private JButton btn_xemds;
	private JLabel lbl_phanquyen;
	private JComboBox cmb_phanquyen;
	private TaiKhoan_DAO tk_dao;
	private JComboBox cmb_manv;
	private NhanVien_DAO nv_dao;
	private Object document;
	private JPasswordField passwordField;

	public CapNhatTaiKhoan_Form() throws SQLException {
		setBackground(SystemColor.control);
		setLayout(null);
		tk_dao = new TaiKhoan_DAO();
		nv_dao = new NhanVien_DAO();
		///
		String[] headers = { "Mã nhân viên", "Tên tài khoản", "Mật khẩu", "Phân quyền", };
		modelkh = new DefaultTableModel(headers, 0);
		tbl_taikhoan = new JTable(modelkh);
		src_taikhoan = new JScrollPane(tbl_taikhoan);
		src_taikhoan.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Danh sách tài khoản", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		src_taikhoan.setBounds(10, 303, 1638, 508);
		// DocDuLieuVaoTable();
		///

		add(src_taikhoan);

		JPanel pnl_tttaikhoan = new JPanel();
		pnl_tttaikhoan.setBorder(new TitledBorder(null, "Thông tin tài khoản", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0, 0, 0)));
		// panel.setBounds(10, 76, 1638, 301);
		pnl_tttaikhoan.setBackground(Color.WHITE);
		pnl_tttaikhoan.setToolTipText("Thông tin tìm kiếm");
		pnl_tttaikhoan.setBounds(10, 59, 1638, 233);
		add(pnl_tttaikhoan);
		pnl_tttaikhoan.setLayout(null);

		lbl_maNV = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn   :");
		lbl_maNV.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_maNV.setBounds(33, 37, 257, 52);
		pnl_tttaikhoan.add(lbl_maNV);

		lbl_tenTk = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n  :");
		lbl_tenTk.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_tenTk.setBounds(616, 39, 191, 48);
		pnl_tttaikhoan.add(lbl_tenTk);

		txt_tentk = new JTextField();
		txt_tentk.setBounds(804, 52, 321, 32);
		pnl_tttaikhoan.add(txt_tentk);
		txt_tentk.setColumns(10);

		lbl_matkhau = new JLabel("M\u1EADt kh\u1EA9u          :");
		lbl_matkhau.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_matkhau.setBounds(33, 100, 168, 52);
		pnl_tttaikhoan.add(lbl_matkhau);

		cmb_manv = new JComboBox(new Object[] {});
		cmb_manv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cmb_manv.getSelectedIndex()!=-1) {
					txt_tentk.setText(cmb_manv.getSelectedItem().toString());
				}
			}
		});
		cmb_manv.setBounds(225, 52, 321, 32);
		pnl_tttaikhoan.add(cmb_manv);
		ArrayList<String> dsmanv = tk_dao.dsNVChuaCoTK();
		for (String manv : dsmanv) {
			cmb_manv.addItem(manv);
		}
		dsmanv = null;

		btn_themTk = new JButton("");
		btn_themTk.setForeground(Color.WHITE);
		btn_themTk.setBackground(Color.WHITE);
		btn_themTk.setIcon(new ImageIcon("images_button\\THemHd.png"));
		btn_themTk.setBounds(1230, 24, 191, 52);
		//
		btn_themTk.setBorderPainted(false); /// xóa khung button
		//
		pnl_tttaikhoan.add(btn_themTk);

		btn_xoatk = new JButton("");
		btn_xoatk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_xoatk.setForeground(Color.WHITE);
		btn_xoatk.setBackground(Color.WHITE);
		btn_xoatk.setBorderPainted(false);
		btn_xoatk.setIcon(new ImageIcon("images_button\\Xoahd.png"));
		btn_xoatk.setBounds(1230, 87, 191, 56);
		pnl_tttaikhoan.add(btn_xoatk);

		btn_suaTK = new JButton("");
		btn_suaTK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_suaTK.setIcon(new ImageIcon("images_button\\SuaHd.png"));
		btn_suaTK.setForeground(Color.WHITE);
		btn_suaTK.setBackground(Color.WHITE);
		btn_suaTK.setBorderPainted(false);
		btn_suaTK.setBounds(1431, 24, 191, 52);
		pnl_tttaikhoan.add(btn_suaTK);

		btn_xoatrang = new JButton("");
		btn_xoatrang.setIcon(new ImageIcon("images_button\\Xoatrangn.png"));
		btn_xoatrang.setForeground(Color.WHITE);
		btn_xoatrang.setBorderPainted(false);
		btn_xoatrang.setBackground(Color.WHITE);
		btn_xoatrang.setBounds(1431, 87, 191, 56);
		pnl_tttaikhoan.add(btn_xoatrang);

		btn_xemds = new JButton("");
		btn_xemds.setIcon(new ImageIcon("images_button\\XemDanhSach.png"));
		btn_xemds.setForeground(Color.WHITE);
		btn_xemds.setBorderPainted(false);
		btn_xemds.setBackground(Color.WHITE);
		btn_xemds.setBounds(1340, 158, 191, 56);
		pnl_tttaikhoan.add(btn_xemds);

		lbl_phanquyen = new JLabel("Ph\u00E2n quy\u1EC1n      :");
		lbl_phanquyen.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lbl_phanquyen.setBounds(616, 100, 192, 52);
		pnl_tttaikhoan.add(lbl_phanquyen);
		String phanquyen[] = { "Nhân Viên", "Quản Lý" };
		cmb_phanquyen = new JComboBox(phanquyen);
		cmb_phanquyen.setBounds(804, 115, 164, 32);

		pnl_tttaikhoan.add(cmb_phanquyen);
		Date date = new Date();// Return thời gian hiện tại với định dạng rất khó coi
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		lbl_tieudetaikhoan = new JLabel("Qu\u1EA3n l\u00FD t\u00E0i kho\u1EA3n");
		lbl_tieudetaikhoan.setForeground(Color.WHITE);
		lbl_tieudetaikhoan.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_tieudetaikhoan.setBounds(46, 0, 589, 48);
		add(lbl_tieudetaikhoan);

		lbl_backgroundtaikhoan = new JLabel("New label");
		lbl_backgroundtaikhoan.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_backgroundtaikhoan.setBounds(0, 0, 1658, 822);
		add(lbl_backgroundtaikhoan);
		guithemkh();

		btn_xemds.addActionListener(this);
		btn_themTk.addActionListener(this);
		btn_xoatk.addActionListener(this);
		btn_suaTK.addActionListener(this);
		btn_xoatrang.addActionListener(this);
		tbl_taikhoan.addMouseListener(this);
		txt_tentk.setEditable(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(225, 115, 321, 32);
		pnl_tttaikhoan.add(passwordField);

	}

	private void DocDuLieuVaoTable() {
		List<TaiKhoan> listtk = tk_dao.getallTaiKhoan();
		for (TaiKhoan tk : listtk) {
				String pwd = tk.getPassWord();
				MessageDigest md1 = null;
				try {
					md1 = MessageDigest.getInstance("MD5");
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        md1.update(pwd.getBytes());
		        byte[] digest = md1.digest();
		        String myHash = DatatypeConverter
		                .printHexBinary(digest).toUpperCase();
		        
			modelkh.addRow(
					new Object[] { tk.getNv().getMaNV(), tk.getTenDangNhap(), myHash, tk.getPhanQuyen() });
		}

	}

	private void guithemkh() {
		jLabel1 = new javax.swing.JLabel();
		setSize(1658, 822);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int row = tbl_taikhoan.getSelectedRow();
		cmb_manv.setSelectedItem(modelkh.getValueAt(row, 0));
		;
		cmb_manv.setEditable(true);
		txt_tentk.setText(modelkh.getValueAt(row, 1).toString());
//		pass.setText(modelkh.getValueAt(row, 2).toString());
		// txt_ngaytao.setText((String) modelkh.getValueAt(row, 4));
		cmb_phanquyen.setSelectedItem(modelkh.getValueAt(row, 3));
		cmb_phanquyen.setEditable(true);

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		if (obj.equals(btn_xemds)) {
			modelkh.setRowCount(0);// Xóa tr
			DocDuLieuVaoTable();
			cmb_manv.setEnabled(true);
			cmb_phanquyen.setEnabled(true);
		} else if (obj.equals(btn_themTk)) {
			if(ktrapwd()) {
				themTaiKhoan();
				while(cmb_manv.getItemCount()!=0) {
					cmb_manv.removeAllItems();
				}
				ArrayList<String> dsmanv = tk_dao.dsNVChuaCoTK();
				for (String manv : dsmanv) {
					cmb_manv.addItem(manv);
				}
				dsmanv = null;
			}
				

		} else if (obj.equals(btn_xoatk)) {
			try {
				xoaTaiKhoan();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (obj.equals(btn_xoatrang)) {
			xoaTrang();

		} else if (obj.equals(btn_suaTK)) {
			cmb_manv.setEnabled(false);
			cmb_phanquyen.setEnabled(false);
			try {
				ChinhSuaTaiKhoan();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	private void ChinhSuaTaiKhoan() throws SQLException {
		int row = tbl_taikhoan.getSelectedRow();
		NhanVien manv = new NhanVien(cmb_manv.getSelectedItem().toString());
		String tendn = txt_tentk.getText();
		String pass = String.valueOf(passwordField.getPassword());
		String phanQ = cmb_phanquyen.getSelectedItem().toString();

		TaiKhoan tkk = new TaiKhoan(manv, tendn, pass);
		if (row >= 0) {
			if (tk_dao.update(tkk)) {
				tbl_taikhoan.setValueAt(txt_tentk.getText(), row, 1);
				tbl_taikhoan.setValueAt(passwordField.getText(), row, 2);
				// tbl_taikhoan.setValueAt(cmb_phanquyen.getSelectedItem(), row, 5);
			}
		}

	}

	private void XuatDS() {
		// TODO Auto-generated method stub

	}

	private void xoaTaiKhoan() throws SQLException {
		// TODO Auto-generated method stub
		int row = tbl_taikhoan.getSelectedRow();
		if (row >= 0) {
			String makh = (String) tbl_taikhoan.getValueAt(row, 0);
			if (tk_dao.XoaTaiKhoan(makh)) {
				modelkh.removeRow(row);
				xoaTrang();
			}
		}
	}

	private void xoaTrang() {
		// TODO Auto-generated method stub
		txt_tentk.setText("");
		passwordField.setText("");
	}

	private void themTaiKhoan() {
		// TODO Auto-generated method stub

		NhanVien manv = new NhanVien(cmb_manv.getSelectedItem().toString());
		String tendn = txt_tentk.getText();
//		String mk = txt_matkhau.getText();
		String mk = String.valueOf(passwordField.getPassword());
		String phanquyen = cmb_phanquyen.getSelectedItem().toString();

		TaiKhoan tk = new TaiKhoan(manv, tendn, mk, phanquyen);
		try {
			tk_dao.createtaikhoan(tk);
			modelkh.addRow(
					new Object[] { tk.getNv().getMaNV(), tk.getTenDangNhap(), tk.getPassWord(), tk.getPhanQuyen() });
		} catch (Exception e1) {
			JOptionPane.showConfirmDialog(this, "trung");
		}

	}
	private boolean ktrapwd() {
		String pwd = String.valueOf(passwordField.getPassword());
		if(passwordField.getPassword().length == 0) {
			thongBao("Nhập mật khẩu", passwordField);
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
