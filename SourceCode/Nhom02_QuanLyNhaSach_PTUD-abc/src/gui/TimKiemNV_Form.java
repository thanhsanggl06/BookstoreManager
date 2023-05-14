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

public class TimKiemNV_Form extends JPanel {
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
	private JLabel lblNewLabel_5;
	private JButton btnNewButton_1;
	private JButton btnXutDanhSch;

	public TimKiemNV_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "Mã Nhân viên", "Tên Nhân viên", "Ngày sinh","Địa chỉ", "Ngày vào làm","Giới tính ","Số điện thoại","Chức vụ","Email"};
		modelkh = new DefaultTableModel(headers, 0);
		tablekh = new JTable(modelkh);
		jscroll = new JScrollPane(tablekh);
		jscroll.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách nhân viên", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		jscroll.setBounds(10, 265, 1638, 546);
		///
		

				

					
		add(jscroll);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Thông tin nhân viên", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(190, 76, 1458, 178);
		panel.setBackground(SystemColor.text);
		panel.setToolTipText("Thông tin tìm kiếm");
		panel.setBounds(253, 66, 1173, 188);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("Tên Nhân viên :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(73, 37, 257, 52);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Số điện thoại      :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(73, 100, 277, 48);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(337, 55, 392, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(337, 116, 392, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\timkiem.png"));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(772, 37, 191, 52);
		panel.add(btnNewButton);
		
		lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\—Pngtree—search vector icon with transparent_5156942.png"));
		lblNewLabel_5.setBounds(195, -15, 713, 459);
		panel.add(lblNewLabel_5);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\lammoi.png"));
		btnNewButton_1.setBounds(972, 37, 191, 52);
		panel.add(btnNewButton_1);
		
		btnXutDanhSch = new JButton("");
		btnXutDanhSch.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\Xuatdstk.png"));
		btnXutDanhSch.setBounds(875, 100, 191, 52);
		panel.add(btnXutDanhSch);
		
		lblNewLabel_2 = new JLabel("Tìm kiếm Nhân viên");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_2.setBounds(46, 0, 395, 76);
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
