package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import entity.Sach;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class XemChiTietSanPham extends JFrame {
	public XemChiTietSanPham(Sach s) {
		setSize(938, 420);
		setLocationRelativeTo(null);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Thông tin chi tiết sản phẩm");
		setResizable(false);
		//setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(32, 34, 851, 298);
		panel.add(panel_1);
		panel_1.setLayout(null);

		
		
		JLabel lbl_chonnanh = new JLabel("");
		lbl_chonnanh.setBounds(56, 55, 280, 210);
		panel_1.add(lbl_chonnanh);
		ImageIcon icon = new ImageIcon("imgSanPham\\"+s.getHinhAnh());
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(lbl_chonnanh.getWidth(), lbl_chonnanh.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		lbl_chonnanh.setIcon(newIcon);

		JLabel lblNewLabel = new JLabel(s.getTenSP());
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblNewLabel.setBounds(372, 53, 428, 39);
		panel_1.add(lblNewLabel);

		JLabel lblThngHiu = new JLabel("Nhà cung cấp:");
		lblThngHiu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblThngHiu.setBounds(372, 85, 117, 39);
		panel_1.add(lblThngHiu);

		JLabel lblNewLabel_1 = new JLabel(s.getNcc().toString());
		lblNewLabel_1.setBounds(488, 92, 164, 25);
		panel_1.add(lblNewLabel_1);

		JLabel lblMSp = new JLabel("Tác giả  :");
		lblMSp.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblMSp.setBounds(662, 85, 61, 39);
		panel_1.add(lblMSp);

		JLabel lblNewLabel_1_1 = new JLabel(s.getTg().toString());
		lblNewLabel_1_1.setBounds(729, 92, 112, 28);
		panel_1.add(lblNewLabel_1_1);
		
		double gia = s.getGiaBan();
		DecimalFormat dfm = new DecimalFormat("###,###.#VND");
		String giaBan = dfm.format(gia);
		JLabel lblNewLabel_2 = new JLabel(giaBan);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(372, 170, 203, 52);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("(Chưa bao gồm thuế VAT)");
		lblNewLabel_3.setBounds(582, 180, 164, 25);
		panel_1.add(lblNewLabel_3);

		JLabel lblNhXutBn = new JLabel("Nhà xuất bản :");
		lblNhXutBn.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNhXutBn.setBounds(372, 114, 117, 39);
		panel_1.add(lblNhXutBn);

		JLabel lblThLoi = new JLabel("Thể loại :");
		lblThLoi.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblThLoi.setBounds(662, 114, 102, 39);
		panel_1.add(lblThLoi);

		JLabel lblNewLabel_1_1_1 = new JLabel(s.getNxb().toString());
		lblNewLabel_1_1_1.setBounds(488, 114, 164, 28);
		panel_1.add(lblNewLabel_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel(s.getTl().toString());
		lblNewLabel_1_1_1_1.setBounds(729, 114, 112, 28);
		panel_1.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		
		
		lblNewLabel_4.setIcon(new ImageIcon("images_icon\\Back.png"));
		lblNewLabel_4.setBounds(0, 0, 54, 54);
		panel_1.add(lblNewLabel_4);
		System.gc();
	}
}
