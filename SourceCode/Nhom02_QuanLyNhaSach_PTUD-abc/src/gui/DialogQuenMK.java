package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.TaiKhoan_DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogQuenMK extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txt_Tk;
	private JTextField txt_mxn;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private TaiKhoan_DAO tk_dao = new TaiKhoan_DAO();
	private JLabel lbl_email;
	private String ranDom = "";
	private JButton okButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogQuenMK dialog = new DialogQuenMK();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogQuenMK() {
		setBounds(100, 100, 413, 302);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quên Mật Khẩu");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 387, 20);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tài Khoản : ");
		lblNewLabel_1.setBounds(20, 51, 70, 14);
		contentPanel.add(lblNewLabel_1);
		
		txt_Tk = new JTextField();
		txt_Tk.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				tk_dao.dsKHTimKiem(txt_Tk, lbl_email);
			}
		});
		txt_Tk.setBounds(110, 48, 146, 20);
		contentPanel.add(txt_Tk);
		txt_Tk.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mã Xác Nhận : ");
		lblNewLabel_1_1.setBounds(20, 110, 90, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		txt_mxn = new JTextField();
		txt_mxn.setColumns(10);
		txt_mxn.setBounds(110, 107, 231, 20);
		contentPanel.add(txt_mxn);
		
		lbl_email = new JLabel("");
		lbl_email.setBounds(20, 80, 367, 14);
		contentPanel.add(lbl_email);
		lbl_email.setForeground(Color.red);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Mật Khẩu Mới : ");
		lblNewLabel_1_1_1.setBounds(20, 146, 90, 14);
		contentPanel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Nhập Lại MK : ");
		lblNewLabel_1_1_1_1.setBounds(20, 179, 81, 14);
		contentPanel.add(lblNewLabel_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 143, 231, 20);
		contentPanel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(110, 176, 231, 20);
		contentPanel.add(passwordField_1);
		
		JButton btnNhanMa = new JButton("Nhận Mã");
		btnNhanMa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(lbl_email.getText()== "") {
					JOptionPane.showMessageDialog(null, "Tài Khoản Không Tồn Tại!");
				}else {
					final String username = "thanhsanggl06@gmail.com";
			        final String password = "xxsrowufosiurybw";

			        Properties prop = new Properties();
					prop.put("mail.smtp.host", "smtp.gmail.com");
			        prop.put("mail.smtp.port", "587");
			        prop.put("mail.smtp.auth", "true");
			        prop.put("mail.smtp.starttls.enable", "true"); //TLS
			        
			        
			        Session session = Session.getInstance(prop,
			                new javax.mail.Authenticator() {
			                    protected PasswordAuthentication getPasswordAuthentication() {
			                        return new PasswordAuthentication(username, password);
			                    }
			                });

			        try {

			            Message message = new MimeMessage(session);
			            message.setFrom(new InternetAddress("thanhsanggl06@gmail.com"));
			            message.setRecipients(
			                    Message.RecipientType.TO,
			                    InternetAddress.parse(TaiKhoan_DAO.email)
			            );
			            
			            Random rand = new Random();
			            int ranNum = rand.nextInt(999999)+1;
			            ranDom = String.format("%06d", ranNum);
			            message.setSubject("Testing Mail");
			            message.setText("Mã Xác Thực Của Bạn Là : "+ranDom);
			            

			            Transport.send(message);

//			            System.out.println("Done");
			            btnNhanMa.setEnabled(false);
			            txt_Tk.setEditable(false);
			            okButton.setEnabled(true);
			            

			        } catch (MessagingException e1) {
			            e1.printStackTrace();
			        }
				}
			}
		});
		btnNhanMa.setBounds(254, 47, 89, 23);
		contentPanel.add(btnNhanMa);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(txt_mxn.getText().equals(ranDom)) {
							String pwd = String.valueOf(passwordField.getPassword());
							String pwd1 = String.valueOf(passwordField_1.getPassword());
							if(pwd.equals(pwd1)) {
								try {
									if(tk_dao.updateMK(txt_Tk.getText().toString(), pwd)) {
										JOptionPane.showMessageDialog(null, "Cập Nhật Mật Khẩu Thành Công");
										dispose();
									}
								} catch (HeadlessException | SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							}else {
								JOptionPane.showMessageDialog(null, "Mật Khẩu Xác Nhận Không Trùng Khớp");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Mã Xác Nhận Không Hợp Lệ");
							System.out.println(passwordField.getPassword());
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		okButton.setEnabled(false);
	}
}
