package gui;

import java.awt.Component;
import java.awt.Dimension;

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

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.temporal.IsoFields;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import java.awt.Panel;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JYearChooser;

import dao.HoaDon_DAO;

import com.toedter.calendar.JMonthChooser;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class ThongKeDoanhThu_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_doanhthu;
	private JScrollPane src_doanhthu;
	private JLabel lbl_backronund;
	private JLabel lbl_thongkedoanhthu;
	private JButton btn_inbaocao;
	private JButton btn_lammoi;
	private JPanel pnl_bieudo_1;
	private JDateChooser nbd, nkt;
	private JComboBox comboBox;
	private DefaultCategoryDataset dataset;
	private JFreeChart chart;
	private HoaDon_DAO hd_dao = new HoaDon_DAO();

	public ThongKeDoanhThu_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã Hóa Đơn", "Tên Khách hàng", "Ngày Lập","Giờ Lập", "Tổng Tiền",};
		modelkh = new DefaultTableModel(headers, 0);
		tbl_doanhthu = new JTable(modelkh);
		src_doanhthu = new JScrollPane(tbl_doanhthu);
		src_doanhthu.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		src_doanhthu.setBounds(10, 265, 1019, 546);
		///
		

				

					
		add(src_doanhthu);
		
		JPanel pnl_bieudo = new JPanel();
		pnl_bieudo.setBounds(1039, 265, 596, 546);
		add(pnl_bieudo);
		pnl_bieudo.setLayout(null);
		
		JLabel lbl_tongdoanhthu = new JLabel("Tổng Doanh Thu :");
		lbl_tongdoanhthu.setBounds(10, 489, 185, 28);
		pnl_bieudo.add(lbl_tongdoanhthu);
		lbl_tongdoanhthu.setFont(new Font("Tahoma", Font.PLAIN, 23));
		

		 

		   
		        
		  
		
		pnl_bieudo_1 = new JPanel();
		pnl_bieudo_1.setBackground(Color.WHITE);
		pnl_bieudo_1.setBounds(0, 0, 596, 478);
		pnl_bieudo.add(pnl_bieudo_1);
		
		JLabel lbl_tongdoanhthu_nhap = new JLabel("");
		lbl_tongdoanhthu_nhap.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lbl_tongdoanhthu_nhap.setBounds(205, 489, 268, 26);
		pnl_bieudo.add(lbl_tongdoanhthu_nhap);
		
		JPanel pnl_ttthongke = new JPanel();
		pnl_ttthongke.setBorder(new TitledBorder(null, "Thống kê", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(190, 76, 1458, 178);
		pnl_ttthongke.setBackground(SystemColor.text);
		pnl_ttthongke.setToolTipText("Thông tin tìm kiếm");
		pnl_ttthongke.setBounds(10, 66, 1623, 188);
		add(pnl_ttthongke);
		pnl_ttthongke.setLayout(null);
		
		JButton btn_thongke = new JButton("");
		btn_thongke.setIcon(new ImageIcon("images_button\\ThongKeBC.png"));
		btn_thongke.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Ngày hôm nay")) {
					hd_dao.dsHoaDontkhn(modelkh, tbl_doanhthu);
					DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					hd_dao.dtBieuDoHomNay(dataset);
			        JFreeChart chart = ChartFactory.createBarChart(
		                "BIỂU ĐỒ DOANH THU HÔM NAY",
		                "Ngày", "Doanh Thu",
		                dataset, PlotOrientation.VERTICAL, false, false, false);
			        ChartPanel pnlchart= new ChartPanel(chart);
					pnlchart.setPreferredSize(new Dimension(550,450));
					pnl_bieudo_1.removeAll();
					pnl_bieudo_1.add(pnlchart);
					DecimalFormat dfm = new DecimalFormat("###,###.#VND");
					String tong = dfm.format(hd_dao.dtHomNay());
					lbl_tongdoanhthu_nhap.setText(tong);
					
				}else if(comboBox.getSelectedItem().equals("7 ngày qua")) {
					hd_dao.dsHoaDontk7ngay(modelkh, tbl_doanhthu);
					DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					hd_dao.dtBieuDo7Ngayqua(dataset);
			        JFreeChart chart = ChartFactory.createBarChart(
		                "BIỂU ĐỒ DOANH THU 7 NGÀY QUA",
		                "Ngày", "Doanh Thu",
		                dataset, PlotOrientation.VERTICAL, false, false, false);
			        ChartPanel pnlchart= new ChartPanel(chart);
					pnlchart.setPreferredSize(new Dimension(550,450));
					pnl_bieudo_1.removeAll();
					pnl_bieudo_1.add(pnlchart);
					DecimalFormat dfm = new DecimalFormat("###,###.#VND");
					String tong = dfm.format(hd_dao.dt7ngayQua());
					lbl_tongdoanhthu_nhap.setText(tong);
				}else if(comboBox.getSelectedItem().equals("Tháng này")) {
					hd_dao.dsHoaDontkthangnay(modelkh, tbl_doanhthu);
					DefaultCategoryDataset dataset = new DefaultCategoryDataset();
					hd_dao.dtBieuDoThangNay(dataset);
			        JFreeChart chart = ChartFactory.createBarChart(
		                "BIỂU ĐỒ DOANH THU THÁNG "+LocalDate.now().getMonthValue(),
		                "Ngày", "Doanh Thu",
		                dataset, PlotOrientation.VERTICAL, false, false, false);
			        ChartPanel pnlchart= new ChartPanel(chart);
					pnlchart.setPreferredSize(new Dimension(550,450));
					pnl_bieudo_1.removeAll();
					pnl_bieudo_1.add(pnlchart);
					DecimalFormat dfm = new DecimalFormat("###,###.#VND");
					String tong = dfm.format(hd_dao.dtthangnay());
					lbl_tongdoanhthu_nhap.setText(tong);
				}else if(comboBox.getSelectedItem().equals("Tùy chỉnh")) {
					Date ngaybd = nbd.getDate();
					Date ngaykt = nkt.getDate();
					Date now = new Date();
					int ngay = 0;
					if(ngaybd != null && ngaykt != null) {
						
						LocalDate bd = convertToLocalDateViaInstant(ngaybd);
						LocalDate kt = convertToLocalDateViaInstant(ngaykt);
						ngay = Period.between(bd, kt).getMonths();
					}
					if(ngaybd == null || ngaykt == null) {
						JOptionPane.showMessageDialog(null, "Ngày thống kê không hợp lệ");
						nbd.grabFocus();
						nkt.grabFocus();
					}
					else if(ngaybd.after(ngaykt)) {
						JOptionPane.showMessageDialog(null, "Ngày bắt đầu phải trước ngày kết thúc");
					}
					else if(ngaybd.after(now)) {
						JOptionPane.showMessageDialog(null, "Ngày thống kê không hợp lệ");
					}else if(ngay!=0){
						JOptionPane.showMessageDialog(null, "Khoảng thời gian thống kê không được lớn hơn 30 ngày");
					}
					else {
						hd_dao.dsHoaDontkTuyChinh(modelkh, tbl_doanhthu, ngaybd, ngaykt);
						DateFormat dateFormat = null;
				        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
				        String nbd1 = dateFormat.format(ngaybd);
				        String nkt1 = dateFormat.format(ngaykt);
						DefaultCategoryDataset dataset = new DefaultCategoryDataset();
						hd_dao.dtBieuDoTuyChinh(dataset, ngaybd, ngaykt);
				        JFreeChart chart = ChartFactory.createBarChart(
			                "BIỂU ĐỒ DOANH THU TỪ NGÀY "+nbd1+" ĐẾN NGÀY "+nkt1 ,
			                "Ngày", "Doanh Thu",
			                dataset, PlotOrientation.VERTICAL, false, false, false);
				        ChartPanel pnlchart= new ChartPanel(chart);
						pnlchart.setPreferredSize(new Dimension(550,450));
						pnl_bieudo_1.removeAll();
						pnl_bieudo_1.add(pnlchart);
						DecimalFormat dfm = new DecimalFormat("###,###.#VND");
						String tong = dfm.format(hd_dao.dttuychinh(ngaybd, ngaykt));
						lbl_tongdoanhthu_nhap.setText(tong);
//						System.out.println(ngay);

					}
				}
			}
		});
		btn_thongke.setBounds(959, 67, 191, 52);
		pnl_ttthongke.add(btn_thongke);
		
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
		
		JLabel lblNewLabel = new JLabel("Thống kê theo : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(34, 55, 112, 25);
		pnl_ttthongke.add(lblNewLabel);
		
		comboBox = new JComboBox();
		comboBox.addItem("Ngày hôm nay");
		comboBox.addItem("7 ngày qua");
		comboBox.addItem("Tháng này");
		comboBox.addItem("Tùy chỉnh");
		
		comboBox.setBounds(150, 57, 122, 22);
		pnl_ttthongke.add(comboBox);
		
		JLabel lblNgyBtu = new JLabel("Ngày bắt đầu : ");
		lblNgyBtu.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgyBtu.setBounds(315, 55, 112, 25);
		pnl_ttthongke.add(lblNgyBtu);
		
		nbd = new JDateChooser();
		nbd.setBounds(428,55,112,25);
		pnl_ttthongke.add(nbd);
		
		JLabel lblNgyKtThc = new JLabel("Ngày kết thúc : ");
		lblNgyKtThc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgyKtThc.setBounds(572, 55, 112, 25);
		pnl_ttthongke.add(lblNgyKtThc);
		
		nkt = new JDateChooser();
		nkt.setBounds(681, 55, 112, 25);
		pnl_ttthongke.add(nkt);
		
		
		lbl_thongkedoanhthu = new JLabel("THỐNG KÊ DOANH THU");
		lbl_thongkedoanhthu.setForeground(Color.WHITE);
		lbl_thongkedoanhthu.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_thongkedoanhthu.setBounds(46, 0, 653, 57);
		add(lbl_thongkedoanhthu);
		
		lbl_backronund = new JLabel("");
		lbl_backronund.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_backronund.setBounds(0, 0, 1658, 822);
		add(lbl_backronund);
		guithemkh();
		nbd.setEnabled(false);
		nkt.setEnabled(false);
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(e.getSource()==comboBox) {
					if(comboBox.getSelectedItem()=="Tùy chỉnh") {
						nbd.setEnabled(true);
						nkt.setEnabled(true);
					}else {
						nbd.setEnabled(false);
						nkt.setEnabled(false);
					}
				}
			}
		});

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
	public LocalDate convertToLocalDateViaInstant(java.util.Date dateToConvert) {
	    return dateToConvert.toInstant()
	      .atZone(ZoneId.systemDefault())
	      .toLocalDate();
	}
	
}
