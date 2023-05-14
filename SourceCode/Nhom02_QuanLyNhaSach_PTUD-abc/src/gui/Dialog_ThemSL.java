package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.openxmlformats.schemas.drawingml.x2006.main.TblDocument;

import dao.VanPhongPham_DAO;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Dialog_ThemSL extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private VanPhongPham_DAO vpp_dao = new VanPhongPham_DAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Dialog_ThemSL dialog = new Dialog_ThemSL();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Dialog_ThemSL() {
		setBounds(100, 100, 323, 138);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("Số Lượng :");
			lblNewLabel.setBounds(10, 21, 60, 14);
			contentPanel.add(lblNewLabel);
		}
		
		textField = new JTextField();
		textField.setBounds(92, 18, 150, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						int sl = Integer.parseInt(textField.getText()) ;
						try {
							if(vpp_dao.updateSoLuongTonHDTam(TimkiemSanPham_Form.masp,sl)) {
								JOptionPane.showMessageDialog(null, "Cập nhật thành công");
								if(TimkiemSanPham_Form.masp.startsWith("SP")) {
									String slt = TimkiemSanPham_Form.tbl_sach.getValueAt(TimkiemSanPham_Form.tbl_sach.getSelectedRow(), 6).toString();
									int slccn = Integer.parseInt(slt);
									TimkiemSanPham_Form.tbl_sach.setValueAt(slccn+sl, TimkiemSanPham_Form.tbl_sach.getSelectedRow(), 6);
									TimkiemSanPham_Form.tbl_sach.clearSelection();
								}else {
									String slt = TimkiemSanPham_Form.tbl_vpp.getValueAt(TimkiemSanPham_Form.tbl_vpp.getSelectedRow(), 5).toString();
									int slccn = Integer.parseInt(slt);
									TimkiemSanPham_Form.tbl_vpp.setValueAt(slccn+sl, TimkiemSanPham_Form.tbl_vpp.getSelectedRow(), 5);
									TimkiemSanPham_Form.tbl_vpp.clearSelection();
								}
							}else {
								JOptionPane.showMessageDialog(null, "Cập nhật thất bại");

							}
							textField.setText("");
							dispose();
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
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
						textField.setText("");
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
