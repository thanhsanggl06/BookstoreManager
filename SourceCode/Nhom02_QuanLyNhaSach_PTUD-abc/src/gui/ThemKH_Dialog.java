package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;

import dao.KhachHang_DAO;
import entity.KhachHang;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class ThemKH_Dialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_makh;
	private JTextField txt_tenKh;
	public JTextField txt_sdt;
	private JDateChooser dateChooser;
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	public int check =0;
//	private KhachHang kh;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ThemKH_Dialog dialog = new ThemKH_Dialog();
			dialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ThemKH_Dialog() {
		setBounds(100, 100, 849, 359);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Thêm Khách Hàng");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(318, 10, 186, 45);
			contentPanel.add(lblNewLabel);
		}
		
		JLabel lblNewLabel_1 = new JLabel("Mã Khách Hàng :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(24, 88, 147, 21);
		contentPanel.add(lblNewLabel_1);
		
		txt_makh = new JTextField();
		txt_makh.setBounds(171, 87, 194, 30);
		contentPanel.add(txt_makh);
		txt_makh.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Tên Khách Hàng : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1.setBounds(24, 149, 168, 21);
		contentPanel.add(lblNewLabel_1_1);
		
		txt_tenKh = new JTextField();
		txt_tenKh.setColumns(10);
		txt_tenKh.setBounds(171, 148, 194, 30);
		contentPanel.add(txt_tenKh);
		
		JLabel lblNewLabel_1_2 = new JLabel("Số Điện Thoại : ");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2.setBounds(429, 95, 147, 21);
		contentPanel.add(lblNewLabel_1_2);
		
		txt_sdt = new JTextField();
		txt_sdt.setColumns(10);
		txt_sdt.setBounds(565, 87, 194, 30);
		contentPanel.add(txt_sdt);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Ngày Sinh :");
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_2_1.setBounds(429, 156, 147, 21);
		contentPanel.add(lblNewLabel_1_2_1);
		
		dateChooser = new JDateChooser();
		dateChooser.setBounds(565, 146, 194, 32);
		contentPanel.add(dateChooser);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(171, 207, 194, 30);
		contentPanel.add(comboBox);
		comboBox.addItem("Nam");
		comboBox.addItem("Nữ");
		
		
		
		txt_makh.setEditable(false);
		try {
			txt_makh.setText(kh_dao.phatSinhMaKH());
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giới Tính  : ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1_1_1.setBounds(24, 209, 106, 21);
		contentPanel.add(lblNewLabel_1_1_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Thêm");
				okButton.addActionListener(new ActionListener() {
					

					public void actionPerformed(ActionEvent e) {
						String makh = txt_makh.getText();
						String tenKh = txt_tenKh.getText();
						String sdt = txt_sdt.getText();
						java.util.Date birth = dateChooser.getDate();
						Date ngaySinh = new Date(birth.getTime());
						String gioiTinh = (String) comboBox.getSelectedItem();
						LapHoaDonBan_Form.kh = new KhachHang(makh, tenKh, ngaySinh, gioiTinh, sdt);
						try {
							if(kh_dao.addKhachHang(LapHoaDonBan_Form.kh)) {
								JOptionPane.showMessageDialog(null, "Thêm Thành Công");
								LapHoaDonBan_Form.lbl_tenkh_nhap.setText(LapHoaDonBan_Form.kh.getTenKH());
								LapHoaDonBan_Form.btn_thanhtoan.setEnabled(true);
								LapHoaDonBan_Form.btn_luutam.setEnabled(true);
								dispose();
								
								
								
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
						
					}
				});
				buttonPane.add(cancelButton);
			}
		}
	}
}
