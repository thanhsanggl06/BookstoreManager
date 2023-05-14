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

import dao.NhanVien_DAO;

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

public class TimKiemNhanVien_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_nhanvien;
	private JScrollPane src_timkiemnhanvien;
	private JLabel lbl_tenNV;
	private JTextField txt_nhanVien;
	private JLabel lbl_background;
	private JLabel lbl_tieudeNhanVien;
	private JButton btn_lammoinb;
	private JButton btn_xuatdsnv;
	private NhanVien_DAO nv_dao = new NhanVien_DAO();
	private JButton btn_xemtatca;

	public TimKiemNhanVien_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã Nhân viên", "Tên Nhân viên", "Ngày sinh","Địa chỉ", "Ngày vào làm","Giới tính ","Số điện thoại","Chức vụ","Email"};
		modelkh = new DefaultTableModel(headers, 0);
		tbl_nhanvien = new JTable(modelkh);
		src_timkiemnhanvien = new JScrollPane(tbl_nhanvien);
		src_timkiemnhanvien.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		src_timkiemnhanvien.setBounds(10, 265, 1638, 546);
		///
		

				

					
		add(src_timkiemnhanvien);
		
		JPanel pnl_ttNhanvien = new JPanel();
		pnl_ttNhanvien.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(190, 76, 1458, 178);
		pnl_ttNhanvien.setBackground(SystemColor.text);
		pnl_ttNhanvien.setToolTipText("Thông tin tìm kiếm");
		pnl_ttNhanvien.setBounds(253, 66, 1173, 188);
		add(pnl_ttNhanvien);
		pnl_ttNhanvien.setLayout(null);
		
		lbl_tenNV = new JLabel("");
		lbl_tenNV.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lbl_tenNV.setBounds(93, 44, 55, 52);
		ImageIcon icon = new ImageIcon("images_icon\\search-interface-symbol.png");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(lbl_tenNV.getWidth(), lbl_tenNV.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		lbl_tenNV.setIcon(newIcon);
		pnl_ttNhanvien.add(lbl_tenNV);
		
		txt_nhanVien = new JTextField();
		txt_nhanVien.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				nv_dao.dsNVTimKiem(txt_nhanVien, modelkh, tbl_nhanvien);
			}
		});
		txt_nhanVien.setBounds(158, 54, 392, 32);
		pnl_ttNhanvien.add(txt_nhanVien);
		txt_nhanVien.setColumns(10);
		
		btn_lammoinb = new JButton("");
		btn_lammoinb.setIcon(new ImageIcon("images_button\\lammoi.png"));
		btn_lammoinb.setBounds(764, 107, 191, 52);
		pnl_ttNhanvien.add(btn_lammoinb);
		
		btn_xuatdsnv = new JButton("");
		btn_xuatdsnv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_nhanvien.getRowCount()!=0) {
					XSSFWorkbook wb = new XSSFWorkbook();
					XSSFSheet sheet = wb.createSheet();
					XSSFRow row = sheet.createRow(1);
					Cell cell = null;
					
					cell = row.createCell(0,CellType.STRING);
					cell.setCellValue("STT");
					
					cell = row.createCell(1,CellType.STRING);
					cell.setCellValue("Mã NV");
					
					cell = row.createCell(2,CellType.STRING);
					cell.setCellValue("Tên Nhân Viên");
					
					cell = row.createCell(3,CellType.STRING);
					cell.setCellValue("Ngày Sinh");
					
					cell = row.createCell(4,CellType.STRING);
					cell.setCellValue("Địa Chỉ");
					
					cell = row.createCell(5,CellType.STRING);
					cell.setCellValue("Ngày Vào Làm");
					
					cell = row.createCell(6,CellType.STRING);
					cell.setCellValue("Giới Tính");
					
					cell = row.createCell(7,CellType.STRING);
					cell.setCellValue("Số Điện Thoại");
					
					cell = row.createCell(8,CellType.STRING);
					cell.setCellValue("Chức Vụ");
					
					cell = row.createCell(9,CellType.STRING);
					cell.setCellValue("Email");
					
					for(int i = 0 ;i<tbl_nhanvien.getRowCount();i++) {
						
						row = sheet.createRow(2+i);
						 
						cell = row.createCell(0,CellType.NUMERIC);
						cell.setCellValue(i+1);
						
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 0).toString());
						
						cell = row.createCell(2,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 1).toString());
						
						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 2).toString());
						
						cell = row.createCell(4,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 3).toString());
						
						cell = row.createCell(5,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 4).toString());
						
						cell = row.createCell(6,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 5).toString());
						
						cell = row.createCell(7,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 6).toString());
						
						cell = row.createCell(8,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 7).toString());
						
						cell = row.createCell(9,CellType.STRING);
						cell.setCellValue(tbl_nhanvien.getValueAt(i, 8).toString());
						
						
					}
					File f = new File("File\\danhsachnv.xlsx");
					
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
		btn_xuatdsnv.setIcon(new ImageIcon("images_button\\Xuatdstk.png"));
		btn_xuatdsnv.setBounds(972, 107, 191, 52);
		pnl_ttNhanvien.add(btn_xuatdsnv);
		
		btn_xemtatca = new JButton("Tất Cả");
		btn_xemtatca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nv_dao.dsNV(modelkh, tbl_nhanvien);
				
			}
		});
		btn_xemtatca.setBounds(555, 107, 191, 52);
		pnl_ttNhanvien.add(btn_xemtatca);
		
		lbl_tieudeNhanVien = new JLabel("Tìm kiếm Nhân viên");
		lbl_tieudeNhanVien.setForeground(Color.WHITE);
		lbl_tieudeNhanVien.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_tieudeNhanVien.setBounds(46, 0, 395, 76);
		add(lbl_tieudeNhanVien);
		
		lbl_background = new JLabel("");
		lbl_background.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_background.setBounds(0, 0, 1658, 822);
		add(lbl_background);
		guithemkh();

	}

	private void guithemkh() {
		// TODO Auto-generated method stub
		jLabel1 = new javax.swing.JLabel();
		setSize(1658, 822);
	}
}
