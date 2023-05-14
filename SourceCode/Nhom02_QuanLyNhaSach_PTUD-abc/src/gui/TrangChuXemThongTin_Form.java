package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollBar;
import java.awt.GridBagLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import dao.NhanVien_DAO;
import dao.Sach_DAO;
import entity.Sach;

public class TrangChuXemThongTin_Form extends JPanel {
	private Sach_DAO sach_dao = new Sach_DAO();

	private JLabel lblNewLabel;

	/**
	 * Create the panel.
	 */
	public TrangChuXemThongTin_Form() {

		lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		JPanel PanelProduct = new JPanel();
		PanelProduct.setBackground(UIManager.getColor("Button.light"));
		PanelProduct.setLayout(new GridBagLayout());
		scrollPane.setViewportView(PanelProduct);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(scrollPane).addContainerGap()));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(scrollPane).addContainerGap()));
		setLayout(groupLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 20, 20);
		 ArrayList<KhungSanPham_form> list = new ArrayList<KhungSanPham_form>();
		 ArrayList<Sach> dssach = new ArrayList<Sach>();
		 try {
			dssach = sach_dao.gettop10sachbanchay();
			for (Sach sach : dssach) {
				list.add(new KhungSanPham_form(sach));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 dssach = null;
	     
	     int x=0;
	     int y=0;
	     for (int i=0;i<list.size();i++) {
	    	 gbc.gridx=x;
	    	 gbc.gridy=y;
	    	 PanelProduct.add(list.get(i),gbc);
	    	 x++;
	    	 if(x==4) {
	    		 x=0;
	    		 y++;
	    	 }
	    	 
	     }
	     list = null;
	     System.gc();

	}
}
