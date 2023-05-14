package gui;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Jpanel_ChaoGuiNV extends JPanel {

	private JProgressBar progressBar;
	Timer t;
	int i = 0;
	private JLabel lblStatus;
	private GUI_TrangChuNhanVien m = null;

	/**
	 * Create the panel.
	 */
	public Jpanel_ChaoGuiNV() {
		setLayout(null);
		
		
		
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 787, 1861, 24);
		add(progressBar);
		
		lblStatus = new JLabel("");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblStatus.setForeground(Color.red);
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatus.setBounds(0, 745, 1834, 31);
		add(lblStatus);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1861, 849);
		ImageIcon icon = new ImageIcon("images_icon\\sach2.jpg");
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		lblNewLabel.setIcon(newIcon);
		add(lblNewLabel);
		load();
		
		
		

	}
	
	public void load() {
		
		t = new javax.swing.Timer(35, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				i++;
				progressBar.setValue(i);
				if(i==5) {
					lblStatus.setText("   Đang khởi tạo ...");
				}
				if(i==10) {
					
					m = new GUI_TrangChuNhanVien();
					
				}
				if(i==20)lblStatus.setText("   Đang khởi tạo ...");
                if(i==50)lblStatus.setText("   Đang kết nối ...");
                if(i==90)lblStatus.setText("   Chuẩn bị vào chương trình...");
				if(i==100) {
					t.stop();
					m.setVisible(true);
					Jpanel_ChaoGuiNV.this.setVisible(false);
					ChonNguoiDung_Form.gui_dangnhapNV.dispose();
					
				}
			}
		});
		t.start();
	}
}
