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

import dao.NhaCungCap_DAO;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

public class TimKiemNhaCungCap_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tbl_NCC;
	private JScrollPane src_ncc;
	private JLabel lbl_mancc;
	private JLabel lbl_tncc;
	private JTextField txt_mncc;
	private JTextField txt_tncc;
	private JLabel lbl_backround;
	private JLabel lbl_tieudeNCC;
	private JLabel lbl_icontkncc;
	private JLabel lbl_sdt;
	private JTextField txt_sdt;
	private JButton btn_xuatds;
	private NhaCungCap_DAO ncc_dao = new NhaCungCap_DAO();

	public TimKiemNhaCungCap_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã nhà cung cấp", "Tên nhà cấp", "Địa chỉ ","Email", "Số điện thoại",};
		modelkh = new DefaultTableModel(headers, 0);
		tbl_NCC = new JTable(modelkh);
		src_ncc = new JScrollPane(tbl_NCC);
		src_ncc.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách nhà cung cấp", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		src_ncc.setBounds(10, 265, 1638, 546);
		///
		

				

					
		add(src_ncc);
		
		JPanel pnl_ttNCC = new JPanel();
		pnl_ttNCC.setBorder(new TitledBorder(null, "Thông tin Nhà cung cấp", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(190, 76, 1458, 178);
		pnl_ttNCC.setBackground(SystemColor.text);
		pnl_ttNCC.setToolTipText("Thông tin tìm kiếm");
		pnl_ttNCC.setBounds(253, 66, 1173, 188);
		add(pnl_ttNCC);
		pnl_ttNCC.setLayout(null);
		
		lbl_mancc = new JLabel("Mã nhà cung cấp : ");
		lbl_mancc.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbl_mancc.setBounds(66, 20, 252, 52);
		pnl_ttNCC.add(lbl_mancc);
		
		lbl_tncc = new JLabel("Tên Nhà Cung Cấp : ");
		lbl_tncc.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbl_tncc.setBounds(70, 67, 277, 58);
		pnl_ttNCC.add(lbl_tncc);
		
		txt_mncc = new JTextField();
		txt_mncc.setBounds(337, 37, 392, 32);
		pnl_ttNCC.add(txt_mncc);
		txt_mncc.setColumns(10);
		
		txt_tncc = new JTextField();
		txt_tncc.setBounds(337, 82, 392, 32);
		pnl_ttNCC.add(txt_tncc);
		txt_tncc.setColumns(10);
		
		JButton btn_timkiemNCC = new JButton("");
		btn_timkiemNCC.setIcon(new ImageIcon("images\\timkiem.png"));
		btn_timkiemNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txt_mncc.getText().equals("") && txt_tncc.getText().equals("") && txt_sdt.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bạn chưa nhập thông tin tìm kiếm!");
				}else {
					String sql = "select * from nhacungcap where ";
					int flag = 0;	
					if(!(txt_mncc.getText().isEmpty())) {
						if (flag ==0) {
							sql = sql + "mancc = '"+txt_mncc.getText()+"' ";
							flag = 1;
						}
						else 
							sql = sql + "and mancc = '"+txt_mncc.getText()+"' ";
					}
					if(!(txt_tncc.getText().isEmpty())) {
						if(flag == 0) {
							sql = sql + "tenncc = N'"+txt_tncc.getText()+"' ";
							flag = 1;
						}else
							sql = sql + "and tenncc = N'"+txt_tncc.getText()+"' ";
					}
					if(!(txt_sdt.getText().isEmpty())) {
						if(flag == 0) {
							sql = sql + "sodienthoai = '"+txt_sdt.getText()+"' ";
							flag =1;
						}
						sql = sql + "and sodienthoai = '"+txt_sdt.getText()+"' ";
					}
//					if(!(txt_theloai.getText().isEmpty())) {
//						sql = sql + "and theloai.tentheloai = N'"+txt_theloai.getText()+"' ";
//					}
////					System.out.println(sql);
					ncc_dao.dsNCCTimKiem(sql, modelkh, tbl_NCC);
				}
			}
		});
		btn_timkiemNCC.setBounds(773, 20, 191, 52);
		pnl_ttNCC.add(btn_timkiemNCC);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(337, 136, 392, 32);
		pnl_ttNCC.add(txt_sdt);
		
		lbl_icontkncc = new JLabel("New label");
		lbl_icontkncc.setIcon(new ImageIcon("images_background\\—Pngtree—search vector icon with transparent_5156942.png"));
		lbl_icontkncc.setBounds(186, 20, 713, 459);
		pnl_ttNCC.add(lbl_icontkncc);
		
		JButton btn_lammoincc = new JButton("");
		btn_lammoincc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn_lammoincc.setIcon(new ImageIcon("images_button\\lammoi.png"));
		btn_lammoincc.setFont(new Font("Tahoma", Font.PLAIN, 26));
		btn_lammoincc.setBounds(972, 20, 191, 52);
		pnl_ttNCC.add(btn_lammoincc);
		
		lbl_sdt = new JLabel("Số điện thoại       :");
		lbl_sdt.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lbl_sdt.setBounds(70, 126, 277, 48);
		pnl_ttNCC.add(lbl_sdt);
		
		btn_xuatds = new JButton("");
		btn_xuatds.setIcon(new ImageIcon("images_button\\Xuatdstk.png"));
		btn_xuatds.setBounds(972, 82, 191, 52);
		pnl_ttNCC.add(btn_xuatds);
		
		lbl_tieudeNCC = new JLabel("Tìm kiếm nhà cung cấp ");
		lbl_tieudeNCC.setForeground(Color.WHITE);
		lbl_tieudeNCC.setFont(new Font("Tahoma", Font.BOLD, 34));
		lbl_tieudeNCC.setBounds(30, 0, 433, 54);
		add(lbl_tieudeNCC);
		
		lbl_backround = new JLabel("");
		lbl_backround.setIcon(new ImageIcon("images_background\\spots_background_faded_solid-669746 (2).png"));
		lbl_backround.setBounds(0, 0, 1658, 822);
		add(lbl_backround);
		guithemkh();

	}

	private void guithemkh() {
		// TODO Auto-generated method stub
		jLabel1 = new javax.swing.JLabel();
		setSize(1658, 822);
	}
}
