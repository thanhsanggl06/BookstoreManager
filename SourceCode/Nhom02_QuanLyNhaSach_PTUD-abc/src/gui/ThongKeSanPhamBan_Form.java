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

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Panel;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;
import com.toedter.calendar.JMonthChooser;

public class ThongKeSanPhamBan_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_doanhthu;
	private JScrollPane src_doanhthu;
	private JLabel lbl_ngay;
	private JLabel lbl_thang;
	private JLabel lbl_backronund;
	private JLabel lbl_thongkedoanhthu;
	private JLabel lbl_nam;
	private JCheckBox chk_thang;
	private JCheckBox chk_nam;
	private JButton btn_inbaocao;
	private JButton btn_lammoi;
	private JPanel pnl_bieudo_1;

	public ThongKeSanPhamBan_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã Khách hàng", "Tên Khách hàng", "Ngày sinh","Giới tính", "Số ĐT",};
		modelkh = new DefaultTableModel(headers, 0);
		tbl_doanhthu = new JTable(modelkh);
		src_doanhthu = new JScrollPane(tbl_doanhthu);
		src_doanhthu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		src_doanhthu.setBounds(10, 265, 1097, 546);
		///
		

				

					
		add(src_doanhthu);
		
		JPanel pnl_bieudo = new JPanel();
		pnl_bieudo.setBounds(1117, 265, 518, 546);
		add(pnl_bieudo);
		pnl_bieudo.setLayout(null);
		
		JLabel lbl_tongdoanhthu = new JLabel("Tổng Doanh Thu :");
		lbl_tongdoanhthu.setBounds(10, 472, 185, 28);
		pnl_bieudo.add(lbl_tongdoanhthu);
		lbl_tongdoanhthu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		JLabel lbl_bieudo = new JLabel("Biểu đồ");
		lbl_bieudo.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_bieudo.setBounds(216, 11, 103, 34);
		pnl_bieudo.add(lbl_bieudo);
		
		pnl_bieudo_1 = new JPanel();
		pnl_bieudo_1.setBackground(Color.WHITE);
		pnl_bieudo_1.setBounds(10, 56, 498, 405);
		pnl_bieudo.add(pnl_bieudo_1);
		
		JLabel lbl_tongdoanhthu_nhap = new JLabel("");
		lbl_tongdoanhthu_nhap.setBounds(205, 474, 268, 26);
		pnl_bieudo.add(lbl_tongdoanhthu_nhap);
		
		JLabel lbl_tongdoanhthu_1 = new JLabel("Tổng sản phẩm đã bán :");
		lbl_tongdoanhthu_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_tongdoanhthu_1.setBounds(10, 511, 249, 28);
		pnl_bieudo.add(lbl_tongdoanhthu_1);
		
		JLabel lbl_tongdoanhthu_nhap_1 = new JLabel("");
		lbl_tongdoanhthu_nhap_1.setBounds(277, 511, 196, 26);
		pnl_bieudo.add(lbl_tongdoanhthu_nhap_1);
		
		JPanel pnl_ttthongke = new JPanel();
		pnl_ttthongke.setBorder(new TitledBorder(null, "Thống kê", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(190, 76, 1458, 178);
		pnl_ttthongke.setBackground(SystemColor.text);
		pnl_ttthongke.setToolTipText("Thông tin tìm kiếm");
		pnl_ttthongke.setBounds(10, 66, 1623, 188);
		add(pnl_ttthongke);
		pnl_ttthongke.setLayout(null);
		
		lbl_ngay = new JLabel("Ngày :");
		lbl_ngay.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_ngay.setBounds(50, 47, 71, 52);
		pnl_ttthongke.add(lbl_ngay);
		
		lbl_thang = new JLabel("Tháng :");
		lbl_thang.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_thang.setBounds(264, 49, 83, 48);
		pnl_ttthongke.add(lbl_thang);
		
		JButton btn_thongke = new JButton("");
		btn_thongke.setIcon(new ImageIcon("images_button\\ThongKeBC.png"));
		btn_thongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_thongke.setBounds(959, 67, 191, 52);
		pnl_ttthongke.add(btn_thongke);
		
		lbl_nam = new JLabel("Năm :");
		lbl_nam.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_nam.setBounds(525, 47, 61, 52);
		pnl_ttthongke.add(lbl_nam);
		
		JCheckBox chk_ngay = new JCheckBox("Thống kê theo ngày");
		chk_ngay.setBounds(50, 96, 188, 23);
		pnl_ttthongke.add(chk_ngay);
		
		chk_thang = new JCheckBox("Thống kê theo năm");
		chk_thang.setBounds(525, 96, 154, 23);
		pnl_ttthongke.add(chk_thang);
		
		chk_nam = new JCheckBox("Thống kê theo tháng");
		chk_nam.setBounds(263, 96, 203, 23);
		pnl_ttthongke.add(chk_nam);
		
		btn_inbaocao = new JButton("");
		btn_inbaocao.setIcon(new ImageIcon("images_button\\InBaoCao.png"));
		btn_inbaocao.setBounds(1406, 67, 191, 52);
		pnl_ttthongke.add(btn_inbaocao);
		
		btn_lammoi = new JButton("");
		btn_lammoi.setIcon(new ImageIcon("images_button\\LammoiHD.png"));
		btn_lammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_lammoi.setBounds(1187, 67, 191, 52);
		pnl_ttthongke.add(btn_lammoi);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(131, 67, 103, 20);
		pnl_ttthongke.add(dateChooser);
		
		JYearChooser yearChooser = new JYearChooser();
		yearChooser.getSpinner().setBounds(0, 0, 48, 20);
		yearChooser.setBounds(603, 67, 48, 20);
		pnl_ttthongke.add(yearChooser);
		yearChooser.setLayout(null);
		
		JMonthChooser monthChooser = new JMonthChooser();
		monthChooser.getSpinner().setBounds(0, 0, 99, 20);
		monthChooser.setBounds(343, 67, 125, 20);
		pnl_ttthongke.add(monthChooser);
		monthChooser.setLayout(null);
		
		lbl_thongkedoanhthu = new JLabel("THỐNG KÊ SẢN PHẨM ĐÃ BÁN");
		lbl_thongkedoanhthu.setForeground(Color.WHITE);
		lbl_thongkedoanhthu.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_thongkedoanhthu.setBounds(46, 0, 653, 57);
		add(lbl_thongkedoanhthu);
		
		lbl_backronund = new JLabel("");
		lbl_backronund.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_backronund.setBounds(0, 0, 1658, 822);
		add(lbl_backronund);
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
