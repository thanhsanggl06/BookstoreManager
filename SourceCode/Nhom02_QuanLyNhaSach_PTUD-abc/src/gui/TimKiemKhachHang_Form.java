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

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.KhachHang_DAO;

import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TimKiemKhachHang_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_khachhang;
	private JScrollPane src_khachhang;
	private JLabel lbl_tenKH;
	private JTextField txt_tenKH;
	private JLabel lbl_background;
	private JLabel lbl_tieude;
	private JLabel lbl_icontik;
	private JButton btn_lammoi;
	private JButton btn_xuatds;
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	public TimKiemKhachHang_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã Khách hàng", "Tên Khách hàng", "Ngày sinh","Giới tính", "Số ĐT",};
		modelkh = new DefaultTableModel(headers, 0);
		tbl_khachhang = new JTable(modelkh);
		src_khachhang = new JScrollPane(tbl_khachhang);
		src_khachhang.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		src_khachhang.setBounds(10, 265, 1638, 546);
		///
		

				
					
		add(src_khachhang);
		
		JPanel pnl_thongtinkh = new JPanel();
		pnl_thongtinkh.setBorder(new TitledBorder(null, "Thông tin khách hàng", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(190, 76, 1458, 178);
		pnl_thongtinkh.setBackground(SystemColor.text);
		pnl_thongtinkh.setToolTipText("Thông tin tìm kiếm");
		pnl_thongtinkh.setBounds(253, 66, 1173, 188);
		add(pnl_thongtinkh);
		pnl_thongtinkh.setLayout(null);
		
		lbl_tenKH = new JLabel("");
		lbl_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_tenKH.setBounds(230, 70, 56, 45);
		ImageIcon icon = new ImageIcon("images_icon\\search-interface-symbol.png");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(lbl_tenKH.getWidth(), lbl_tenKH.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		lbl_tenKH.setIcon(newIcon);
		pnl_thongtinkh.add(lbl_tenKH);
		
		txt_tenKH = new JTextField();
		txt_tenKH.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				kh_dao.dsKHTimKiem(txt_tenKH, modelkh, tbl_khachhang);
			}
		});
		txt_tenKH.setBounds(298, 77, 392, 32);
		pnl_thongtinkh.add(txt_tenKH);
		txt_tenKH.setColumns(10);
		
		btn_xuatds = new JButton("");
		btn_xuatds.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_khachhang.getRowCount()!=0) {
					XSSFWorkbook wb = new XSSFWorkbook();
					XSSFSheet sheet = wb.createSheet();
					XSSFRow row = sheet.createRow(1);
					Cell cell = null;
					
					cell = row.createCell(0,CellType.STRING);
					cell.setCellValue("STT");
					
					cell = row.createCell(1,CellType.STRING);
					cell.setCellValue("Mã Khách Hàng");
					
					cell = row.createCell(2,CellType.STRING);
					cell.setCellValue("Tên Khách Hàng");
					
					cell = row.createCell(3,CellType.STRING);
					cell.setCellValue("Ngày Sinh");
					
					cell = row.createCell(4,CellType.STRING);
					cell.setCellValue("Giới Tính");
					
					cell = row.createCell(5,CellType.STRING);
					cell.setCellValue("Số Điện Thoại");
					
					for(int i = 0 ;i<tbl_khachhang.getRowCount();i++) {
						
						row = sheet.createRow(2+i);
						 
						cell = row.createCell(0,CellType.NUMERIC);
						cell.setCellValue(i+1);
						
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue(tbl_khachhang.getValueAt(i, 0).toString());
						
						cell = row.createCell(2,CellType.STRING);
						cell.setCellValue(tbl_khachhang.getValueAt(i, 1).toString());
						
						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue(tbl_khachhang.getValueAt(i, 2).toString());
						
						cell = row.createCell(4,CellType.STRING);
						cell.setCellValue(tbl_khachhang.getValueAt(i, 3).toString());
						
						cell = row.createCell(5,CellType.STRING);
						cell.setCellValue(tbl_khachhang.getValueAt(i, 4).toString());
						
						
					}
					File f = new File("File\\danhsachkh.xlsx");
					
					try {
						FileOutputStream fis = new FileOutputStream(f);
						wb.write(fis);
						fis.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "In thành công");
					
				}else {
					JOptionPane.showMessageDialog(null, "Không có dữ liệu");
				}
			}
		});
		btn_xuatds.setIcon(new ImageIcon("images_button\\Xuatdstk.png"));
		btn_xuatds.setBounds(777, 125, 191, 52);
		pnl_thongtinkh.add(btn_xuatds);
		
		lbl_icontik = new JLabel("New label");
		lbl_icontik.setIcon(new ImageIcon("images_background\\—Pngtree—search vector icon with transparent_5156942.png"));
		lbl_icontik.setBounds(192, -13, 713, 459);
		pnl_thongtinkh.add(lbl_icontik);
		
		btn_lammoi = new JButton("");
		btn_lammoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_tenKH.setText("");
				while(tbl_khachhang.getRowCount()!=0) {
					modelkh.removeRow(0);
				}
			}
		});
		btn_lammoi.setIcon(new ImageIcon("images_button\\lammoi.png"));
		btn_lammoi.setBounds(978, 125, 191, 52);
		pnl_thongtinkh.add(btn_lammoi);
		
		
		
		lbl_tieude = new JLabel("Tìm kiếm khách hàng");
		lbl_tieude.setForeground(Color.WHITE);
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_tieude.setBounds(46, 0, 395, 76);
		add(lbl_tieude);
		
		lbl_background = new JLabel("New label");
		lbl_background.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_background.setBounds(0, 0, 1658, 822);
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
