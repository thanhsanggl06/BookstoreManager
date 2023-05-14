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
import com.toedter.calendar.JDateChooser;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

public class CapNhatSp_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNgySinh;
	private JLabel lblNewLabel_6;
	private JButton btnNewButton_2;
	private JButton btnXa;
	private JButton btnNewButton;
	private JButton btnXa_1;
	private JButton btnXa_2;
	private JButton btnXa_3;
	private JLabel lblNewLabel_5;
	private JTextField textField_4;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JScrollPane jscroll;
	private JTextField textField_3;
	private JComboBox comboBox_2;
	private JTextField textField_2;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_7;
	private JScrollPane jscroll_1;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_9;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblNgySinh_1;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_12;
	private JTextField textField_7;
	private JLabel lblNewLabel_5_2;
	private JComboBox comboBox;
	private JLabel lblNewLabel_6_1;
	private JTextField textField_8;
	private JComboBox comboBox_3;
	private JTextField textField_9;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_11;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnXa_4;
	private JButton btnNewButton_5;
	private JButton btnXa_5;
	private JButton btnXa_6;
	private JButton btnXa_7;
	private JLabel lblNewLabel_6_3;
	private JComboBox comboBox_4;

	public CapNhatSp_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã Nhân viên", "Tên Nhân viên", "Ngày sinh","Địa chỉ", "Ngày vào làm","Trình độ","Giới tính ","Số điện thoại","Chức vụ"};
		modelkh = new DefaultTableModel(headers, 0);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 56, 1638, 755);
		add(tabbedPane);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông tin sản phẩm", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(10, 76, 1638, 301);
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("Thông tin tìm kiếm");
		panel.setBounds(10, 59, 1638, 233);
		panel.setLayout(null);
		tabbedPane.addTab("Sách", null, panel, null);
		
		jscroll = new JScrollPane((Component) null);
		jscroll.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		jscroll.setBounds(10, 274, 1638, 436);
		panel.add(jscroll);
		lblNewLabel = new JLabel("Mã sản phẩm   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 46, 153, 32);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Tên sản phẩm :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(445, 38, 191, 48);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(182, 49, 253, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(580, 49, 253, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblNgySinh = new JLabel("Số lượng :");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh.setBounds(30, 89, 167, 52);
		panel.add(lblNgySinh);
		
		lblNewLabel_6 = new JLabel("Giá bán:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(30, 145, 178, 48);
		panel.add(lblNewLabel_6);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\themkh.png"));
		btnNewButton_2.setBounds(1230, 24, 191, 52);
		//
		btnNewButton_2.setBorderPainted(false); ///xóa khung button 
		//
		panel.add(btnNewButton_2);
		
		btnXa = new JButton("");
		btnXa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXa.setForeground(Color.WHITE);
		btnXa.setBackground(Color.WHITE);
		btnXa.setBorderPainted(false);
		btnXa.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\xoakh.png"));
		btnXa.setBounds(1230, 87, 191, 56);
		panel.add(btnXa);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\suakhachhang.png"));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(1431, 24, 191, 52);
		panel.add(btnNewButton);
		
		btnXa_1 = new JButton("");
		btnXa_1.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\Xoatrang.png"));
		btnXa_1.setForeground(Color.WHITE);
		btnXa_1.setBorderPainted(false);
		btnXa_1.setBackground(Color.WHITE);
		btnXa_1.setBounds(1431, 87, 191, 56);
		panel.add(btnXa_1);
		
		btnXa_2 = new JButton("");
		btnXa_2.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\XemDS.png"));
		btnXa_2.setForeground(Color.WHITE);
		btnXa_2.setBorderPainted(false);
		btnXa_2.setBackground(Color.WHITE);
		btnXa_2.setBounds(1230, 158, 191, 56);
		panel.add(btnXa_2);
		
		btnXa_3 = new JButton("");
		btnXa_3.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\Xuatds.png"));
		btnXa_3.setForeground(Color.WHITE);
		btnXa_3.setBorderPainted(false);
		btnXa_3.setBackground(Color.WHITE);
		btnXa_3.setBounds(1431, 158, 191, 56);
		panel.add(btnXa_3);
		
		btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\chonanh2.png"));
		btnNewButton_1.setBounds(938, 224, 153, 39);
		panel.add(btnNewButton_1);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\bv.png"));
		lblNewLabel_7.setBounds(879, 8, 283, 206);
		panel.add(lblNewLabel_7);
		
		lblNewLabel_5 = new JLabel("Giá nhập :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(455, 89, 82, 52);
		panel.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(182, 102, 253, 32);
		panel.add(textField_4);
		
		JLabel lblNewLabel_5_1 = new JLabel("Thể loại:");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_1.setBounds(455, 143, 82, 52);
		panel.add(lblNewLabel_5_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(580, 158, 253, 29);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Nhà xuất bản  :");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_2.setBounds(30, 198, 178, 48);
		panel.add(lblNewLabel_6_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(580, 102, 253, 32);
		panel.add(textField_3);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(180, 211, 255, 29);
		panel.add(comboBox_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(182, 156, 253, 32);
		panel.add(textField_2);
		
		lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\background-xam (1).jpg"));
		lblNewLabel_8.setBounds(0, 0, 1648, 727);
		panel.add(lblNewLabel_8);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Văn phòng phẩm", null, panel_1, null);
		panel_1.setLayout(null);
		
		jscroll_1 = new JScrollPane((Component) null);
		jscroll_1.setBounds(10, 304, 1613, 423);
		jscroll_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel_1.add(jscroll_1);
		
		lblNewLabel_4 = new JLabel("Mã sản phẩm   :");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(30, 57, 153, 32);
		panel_1.add(lblNewLabel_4);
		
		lblNewLabel_9 = new JLabel("Tên sản phẩm :");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_9.setBounds(445, 49, 191, 48);
		panel_1.add(lblNewLabel_9);
		
		lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\bv.png"));
		lblNewLabel_11.setBounds(886, 36, 222, 168);
		panel_1.add(lblNewLabel_11);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(182, 60, 253, 32);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(580, 60, 253, 32);
		panel_1.add(textField_6);
		
		btnNewButton_4 = new JButton("");
		btnNewButton_4.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\themkh.png"));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(Color.WHITE);
		btnNewButton_4.setBounds(1174, 37, 191, 52);
		panel_1.add(btnNewButton_4);
		
		btnXa_4 = new JButton("");
		btnXa_4.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\suakhachhang.png"));
		btnXa_4.setForeground(Color.WHITE);
		btnXa_4.setBorderPainted(false);
		btnXa_4.setBackground(Color.WHITE);
		btnXa_4.setBounds(1174, 122, 191, 56);
		panel_1.add(btnXa_4);
		
		btnNewButton_5 = new JButton("");
		btnNewButton_5.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\xoakh.png"));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(1402, 37, 191, 52);
		panel_1.add(btnNewButton_5);
		
		btnXa_5 = new JButton("");
		btnXa_5.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\Xoatrang.png"));
		btnXa_5.setForeground(Color.WHITE);
		btnXa_5.setBorderPainted(false);
		btnXa_5.setBackground(Color.WHITE);
		btnXa_5.setBounds(1402, 122, 191, 56);
		panel_1.add(btnXa_5);
		
		btnXa_6 = new JButton("");
		btnXa_6.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\XemDS.png"));
		btnXa_6.setForeground(Color.WHITE);
		btnXa_6.setBorderPainted(false);
		btnXa_6.setBackground(Color.WHITE);
		btnXa_6.setBounds(1174, 201, 191, 56);
		panel_1.add(btnXa_6);
		
		btnXa_7 = new JButton("");
		btnXa_7.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\Xuatds.png"));
		btnXa_7.setForeground(Color.WHITE);
		btnXa_7.setBorderPainted(false);
		btnXa_7.setBackground(Color.WHITE);
		btnXa_7.setBounds(1402, 201, 191, 56);
		panel_1.add(btnXa_7);
		
		lblNgySinh_1 = new JLabel("Số lượng :");
		lblNgySinh_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh_1.setBounds(30, 100, 167, 52);
		panel_1.add(lblNgySinh_1);
		
		lblNewLabel_10 = new JLabel("Giá bán:");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_10.setBounds(30, 156, 178, 48);
		panel_1.add(lblNewLabel_10);
		
		lblNewLabel_12 = new JLabel("Giá nhập :");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_12.setBounds(455, 100, 82, 52);
		panel_1.add(lblNewLabel_12);
		
		lblNewLabel_6_3 = new JLabel("Loại sản phẩm  :");
		lblNewLabel_6_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_3.setBounds(445, 209, 178, 48);
		panel_1.add(lblNewLabel_6_3);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(182, 113, 253, 32);
		panel_1.add(textField_7);
		
		lblNewLabel_5_2 = new JLabel("Nhà cung cấp :");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_2.setBounds(445, 154, 125, 52);
		panel_1.add(lblNewLabel_5_2);
		
		comboBox_4 = new JComboBox();
		comboBox_4.setBounds(580, 222, 253, 29);
		panel_1.add(comboBox_4);
		
		comboBox = new JComboBox();
		comboBox.setBounds(580, 169, 253, 29);
		panel_1.add(comboBox);
		
		lblNewLabel_6_1 = new JLabel("Thương hiệu   :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(30, 209, 178, 48);
		panel_1.add(lblNewLabel_6_1);
		
		btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\chonanh2.png"));
		btnNewButton_3.setBounds(933, 243, 126, 32);
		panel_1.add(btnNewButton_3);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(580, 113, 253, 32);
		panel_1.add(textField_8);
		
		comboBox_3 = new JComboBox();
		comboBox_3.setBounds(180, 222, 255, 29);
		panel_1.add(comboBox_3);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(182, 167, 253, 32);
		panel_1.add(textField_9);
		
		lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\background-xam (1).jpg"));
		lblNewLabel_13.setBounds(0, 0, 1648, 727);
		panel_1.add(lblNewLabel_13);
		
		lblNewLabel_2 = new JLabel("Cập nhật sản phẩm\r\n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_2.setBounds(46, 0, 589, 62);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\spots_background_faded_solid-669746 (2).png"));
		lblNewLabel_3.setBounds(0, 0, 1658, 822);
		add(lblNewLabel_3);
		guithemkh();
		System.gc();

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
