package gui;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.LineBorder;

import entity.Sach;
import entity.SanPham;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class KhungSanPham_form extends JPanel {
	public static Sach sach = null;

	public KhungSanPham_form(Sach s) {
		sach = s;
		
		setBackground(UIManager.getColor("Button.highlight"));
		setBorder(new LineBorder(new Color(0, 0, 0)));
		
		JLabel lbl_background = new JLabel("");
//		lbl_background.setIcon(new ImageIcon(("imgSanPham\\"+sach.getHinhAnh())));
		lbl_background.setBackground(new Color(203, 146, 187));
		
		
		JLabel lbl_masp = new JLabel("Mã Sản Phẩm :");
		lbl_masp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lbl_gia = new JLabel("Giá bán : ");
		lbl_gia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lbl_tenSP = new JLabel("Tên Sản Phẩm :");
		lbl_tenSP.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btn_xem = new JButton("Xem");
		btn_xem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XemChiTietSanPham ctsp = new XemChiTietSanPham(s);
				ctsp.setVisible(true);
				//dispose();
			}
		});
		btn_xem.setIcon(new ImageIcon("images\\iconSP.png"));
		btn_xem.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lbl_msp_nhap = new JLabel(sach.getMaSP());
		lbl_msp_nhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lbl_tensp_nhap = new JLabel(sach.getTenSP());
		lbl_tensp_nhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		DecimalFormat dfm = new DecimalFormat("###,###.#VND");
		String giaBan = dfm.format(sach.getGiaBan());
		JLabel lbl_GiaSp_nhap = new JLabel(giaBan);
		lbl_GiaSp_nhap.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lbl_masp, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lbl_msp_nhap, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addComponent(lbl_tenSP, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
							.addGap(6)
							.addComponent(lbl_tensp_nhap, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(10)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btn_xem, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(lbl_gia)
									.addGap(6)
									.addComponent(lbl_GiaSp_nhap, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(19)
							.addComponent(lbl_background, GroupLayout.PREFERRED_SIZE, 280, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(10, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(15)
					.addComponent(lbl_background, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_masp)
						.addComponent(lbl_msp_nhap))
					.addGap(8)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_tenSP)
						.addComponent(lbl_tensp_nhap))
					.addGap(6)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lbl_gia)
						.addComponent(lbl_GiaSp_nhap))
					.addGap(44)
					.addComponent(btn_xem)
					.addContainerGap())
		);
		setLayout(groupLayout);
		ImageIcon icon = new ImageIcon("imgSanPham\\"+s.getHinhAnh());
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(280, 210, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		lbl_background.setIcon(newIcon);
		
	}

}
