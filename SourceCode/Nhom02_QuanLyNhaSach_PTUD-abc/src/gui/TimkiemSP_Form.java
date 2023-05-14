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
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;

public class TimkiemSP_Form extends JPanel {
	private JLabel jLabel1;
	private DefaultTableModel modelkh;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JTextField textField;

	public TimkiemSP_Form() {
		setBackground(SystemColor.control);
		setLayout(null);

		///
		String[] headers = { "Mã Nhân viên", "Tên Nhân viên", "Ngày sinh", "Địa chỉ", "Ngày vào làm", "Trình độ",
				"Giới tính ", "Số điện thoại", "Chức vụ" };
		modelkh = new DefaultTableModel(headers, 0);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 56, 1638, 766);
		add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Sách", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane jscroll = new JScrollPane((Component) null);
		jscroll.setBounds(10, 270, 1613, 468);
		jscroll.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		panel.add(jscroll);
		
		JLabel lblNewLabel = new JLabel("Thể loại  :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(123, 161, 257, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tên sách   :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(123, 68, 277, 48);
		panel.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(299, 84, 392, 32);
		panel.add(textField_1);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\LammoiHD.png"));
		btnNewButton_1.setBounds(1014, 196, 191, 52);
		panel.add(btnNewButton_1);
		
		JButton btnXutDanhSch = new JButton("");
		btnXutDanhSch.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\TimKiemThoeMaHD.png"));
		btnXutDanhSch.setBounds(1215, 196, 191, 52);
		panel.add(btnXutDanhSch);
		
		JButton btnXutDanhSch_1_1_1 = new JButton("");
		btnXutDanhSch_1_1_1.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\xuatfile.png"));
		btnXutDanhSch_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnXutDanhSch_1_1_1.setBounds(1419, 196, 191, 52);
		panel.add(btnXutDanhSch_1_1_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(299, 179, 392, 32);
		panel.add(comboBox);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhà xuất bản:");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1.setBounds(788, 80, 277, 48);
		panel.add(lblNewLabel_1_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("TÌm kiếm theo tên");
		chckbxNewCheckBox.setBounds(299, 131, 191, 23);
		panel.add(chckbxNewCheckBox);
		
		JCheckBox chckbxTmKimTheo = new JCheckBox("Tìm kiếm theo thể loại");
		chckbxTmKimTheo.setBounds(299, 220, 191, 23);
		panel.add(chckbxTmKimTheo);
		
		JCheckBox chckbxTmKimTheo_1 = new JCheckBox("Tìm kiếm theo nhà xuất bản");
		chckbxTmKimTheo_1.setBounds(1001, 123, 257, 23);
		panel.add(chckbxTmKimTheo_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(1001, 84, 392, 32);
		panel.add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\background-xam (1).jpg"));
		lblNewLabel_4.setBounds(0, 0, 1633, 756);
		panel.add(lblNewLabel_4);
		
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Văn phòng phẩm", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane jscroll_1 = new JScrollPane((Component) null);
		jscroll_1.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Danh sách sản phẩm", TitledBorder.CENTER, TitledBorder.TOP, null, Color.BLACK));
		jscroll_1.setBounds(10, 278, 1613, 449);
		panel_1.add(jscroll_1);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(327, 77, 392, 32);
		panel_1.add(textField);
		
		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\LammoiHD.png"));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setBounds(1217, 209, 191, 52);
		panel_1.add(btnNewButton_1_1);
		
		JButton btnXutDanhSch_1 = new JButton("");
		btnXutDanhSch_1.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\TimKiemThoeMaHD.png"));
		btnXutDanhSch_1.setBounds(1016, 209, 191, 52);
		panel_1.add(btnXutDanhSch_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(327, 168, 392, 32);
		panel_1.add(comboBox_2);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Tên sản phẩm :");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1.setBounds(106, 61, 277, 48);
		panel_1.add(lblNewLabel_1_1_1);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("TÌm kiếm theo tên");
		chckbxNewCheckBox_1.setBounds(327, 116, 191, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxTmKimTheo_2 = new JCheckBox("Tìm kiếm theo nhà cung cấp");
		chckbxTmKimTheo_2.setBounds(327, 209, 191, 23);
		panel_1.add(chckbxTmKimTheo_2);
		
		JCheckBox chckbxTmKimTheo_1_1 = new JCheckBox("Tìm kiếm theo thương hiệu");
		chckbxTmKimTheo_1_1.setBounds(965, 116, 257, 23);
		panel_1.add(chckbxTmKimTheo_1_1);
		
		JButton btnXutDanhSch_1_1 = new JButton("");
		btnXutDanhSch_1_1.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\xuatfile.png"));
		btnXutDanhSch_1_1.setBounds(1418, 209, 191, 52);
		panel_1.add(btnXutDanhSch_1_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(961, 77, 392, 32);
		panel_1.add(comboBox_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Thương hiệu  :");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1_1.setBounds(749, 61, 277, 48);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nhà cung cấp :");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_1_1_1_1.setBounds(106, 165, 277, 48);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("New label");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\background-xam (1).jpg"));
		lblNewLabel_5.setBounds(0, 0, 1633, 776);
		panel_1.add(lblNewLabel_5);

		lblNewLabel_2 = new JLabel("Tìm kiếm sản phẩm");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblNewLabel_2.setBounds(30, -13, 395, 76);
		add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3
				.setIcon(new ImageIcon("C:\\Users\\Ngducvi\\Downloads\\spots_background_faded_solid-669746 (2).png"));
		lblNewLabel_3.setBounds(0, 0, 1658, 847);
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
