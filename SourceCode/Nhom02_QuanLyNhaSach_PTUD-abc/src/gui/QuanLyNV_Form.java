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
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import dao.NhanVien_DAO;
import entity.KhachHang;
import entity.NhanVien;

import javax.swing.UIManager;
import javax.swing.JComboBox;

public class QuanLyNV_Form extends JPanel {
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
	private JDateChooser dateChooser;
	private JButton btnNewButton_2;
	private JButton btnXa;
	private JButton btnNewButton;
	private JButton btnXa_1;
	private JButton btnXa_2;
	private JButton btnXa_3;
	private JLabel lblNewLabel_5;
	private JTextField textField_2;
	private JTextField textField_4;
	private JLabel lblNewLabel_4;

	public QuanLyNV_Form() {
		setBackground(SystemColor.control);
		setLayout(null);
		
		///
		String[] headers = { "MĂ£ NhĂ¢n viĂªn", "TĂªn NhĂ¢n viĂªn", "NgĂ y sinh","Ä�á»‹a chá»‰", "NgĂ y vĂ o lĂ m","TrĂ¬nh Ä‘á»™","Giá»›i tĂ­nh ","Sá»‘ Ä‘iá»‡n thoáº¡i","Chá»©c vá»¥"};
		modelkh = new DefaultTableModel(headers, 0);
		tablekh = new JTable(modelkh);
		jscroll = new JScrollPane(tablekh);
		jscroll.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sĂ¡ch nhĂ¢n viĂªn", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		jscroll.setBounds(10, 303, 1638, 508);
		///
		

				

					
		add(jscroll);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "ThĂ´ng tin NhĂ¢n viĂªn", TitledBorder.LEADING, TitledBorder.TOP,
				new Font("Arial", Font.BOLD, 16), new Color(0,0,0)));
		//panel.setBounds(10, 76, 1638, 301);
		panel.setBackground(Color.WHITE);
		panel.setToolTipText("ThĂ´ng tin tĂ¬m kiáº¿m");
		panel.setBounds(10, 59, 1638, 233);
		add(panel);
		panel.setLayout(null);
		
		lblNewLabel = new JLabel("MĂ£ nhĂ¢n viĂªn   :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 30, 153, 32);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("TĂªn nhĂ¢n viĂªn :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(445, 22, 191, 48);
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(182, 33, 253, 32);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(580, 33, 321, 32);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		lblNgySinh = new JLabel("NgĂ y sinh  :");
		lblNgySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNgySinh.setBounds(911, 20, 167, 52);
		panel.add(lblNgySinh);
		
		lblNewLabel_6 = new JLabel("NgĂ y vĂ o lĂ m  :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(445, 69, 178, 48);
		panel.add(lblNewLabel_6);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(1017, 32, 170, 32);
		panel.add(dateChooser);
		
		btnNewButton_2 = new JButton("");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\themkh.png"));
		btnNewButton_2.setBounds(1230, 24, 191, 52);
		//
		btnNewButton_2.setBorderPainted(false); ///xĂ³a khung button 
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
		
		lblNewLabel_5 = new JLabel("Ä�á»‹a chá»‰ :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(28, 67, 82, 52);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6_1 = new JLabel("TrĂ¬nh Ä‘á»™    :");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_1.setBounds(911, 69, 178, 48);
		panel.add(lblNewLabel_6_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(580, 128, 310, 32);
		panel.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(182, 80, 253, 32);
		panel.add(textField_4);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(579, 76, 138, 32);
		panel.add(dateChooser_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1017, 82, 167, 29);
		panel.add(comboBox);
		
		JLabel lblNewLabel_5_1 = new JLabel("Giá»›i tĂ­nh :");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_1.setBounds(28, 118, 82, 52);
		panel.add(lblNewLabel_5_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(182, 132, 123, 29);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_6_2 = new JLabel("Sá»‘ Ä‘iá»‡n thoáº¡i :");
		lblNewLabel_6_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6_2.setBounds(445, 120, 178, 48);
		panel.add(lblNewLabel_6_2);
		
		JLabel lblNewLabel_5_1_1 = new JLabel("Chá»©c vá»¥  :");
		lblNewLabel_5_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_5_1_1.setBounds(911, 115, 92, 52);
		panel.add(lblNewLabel_5_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(1017, 132, 170, 29);
		panel.add(comboBox_1_1);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\customer-service-technician-icon-600-w_20171207103233.png"));
		lblNewLabel_4.setBounds(1001, -33, 614, 279);
		panel.add(lblNewLabel_4);
		
		lblNewLabel_2 = new JLabel("Cáº­p nháº­t NhĂ¢n ViĂªn\r\n");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_2.setBounds(46, 0, 589, 62);
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
