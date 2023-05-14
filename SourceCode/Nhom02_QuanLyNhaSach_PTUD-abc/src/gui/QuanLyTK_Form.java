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

public class QuanLyTK_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JTable tablekh;
	private JScrollPane jscroll;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblNgySinh;
	private JLabel lblNewLabel_6;
	private JTextField textField_3;
	private JDateChooser dateChooser;
	private JButton btnNewButton_2;
	private JButton btnXa;
	private JButton btnNewButton;
	private JButton btnXa_1;
	private JButton btnXa_2;
	private JButton btnXa_3;
	private JLabel lblPhnQuyn;
	private JComboBox comboBox;
	private JLabel lblNewLabel_4;

	public QuanLyTK_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã nhân viên", "Tên tài khoản", "Mật khẩu","Ngày tạo", "Phân quyền",};
		modelkh = new DefaultTableModel(headers, 0);
		tablekh = new JTable(modelkh);
		jscroll = new JScrollPane(tablekh);
		jscroll.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách tài khoản", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		jscroll.setBounds(10, 303, 1638, 508);
		///
		

				

					
		add(jscroll);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông tin tài khoản", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(10, 76, 1638, 301);
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("Thông tin tìm kiếm");
		panel.setBounds(10, 59, 1638, 233);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("M\u00E3 nh\u00E2n vi\u00EAn   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(33, 37, 257, 52);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("T\u00EAn t\u00E0i kho\u1EA3n  :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(616, 39, 191, 48);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(225, 52, 321, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(804, 52, 321, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblNgySinh = new JLabel("M\u1EADt kh\u1EA9u          :");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNgySinh.setBounds(33, 100, 168, 52);
		panel.add(lblNgySinh);
		
		lblNewLabel_6 = new JLabel("Ng\u00E0y t\u1EA1o     :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel_6.setBounds(616, 102, 178, 48);
		panel.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(225, 115, 321, 32);
		panel.add(textField_3);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(804, 114, 321, 38);
		panel.add(dateChooser);
		
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
		
		lblPhnQuyn = new JLabel("Ph\u00E2n quy\u1EC1n      :");
		lblPhnQuyn.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblPhnQuyn.setBounds(33, 162, 192, 52);
		panel.add(lblPhnQuyn);
		
		comboBox = new JComboBox();
		comboBox.setBounds(225, 172, 164, 32);
		panel.add(comboBox);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\icontaikhoan.png"));
		lblNewLabel_4.setBounds(211, 11, 729, 239);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_2 = new JLabel("Qu\u1EA3n l\u00FD t\u00E0i kho\u1EA3n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_2.setBounds(46, 0, 589, 48);
		add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\spots_background_faded_solid-669746 (2).png"));
		lblNewLabel_3.setBounds(0, 0, 1658, 822);
		add(lblNewLabel_3);
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
