package gui;

import java.awt.GridBagConstraints;
import java.awt.Insets;
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

import dao.Sach_DAO;
import entity.Sach;

import java.awt.GridLayout;

public class Trangchusanpham extends JPanel {
	private Sach_DAO sach_dao = new Sach_DAO();

	/**
	 * Create the panel.
	 */
	public Trangchusanpham() {

		JLabel lblNewLabel = new JLabel("New label");
		add(lblNewLabel);
		JScrollPane scrollPane = new JScrollPane();
		JPanel PanelProduct = new JPanel();
		PanelProduct.setLayout(new GridBagLayout());
		scrollPane.setViewportView(PanelProduct);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 1341, Short.MAX_VALUE).addContainerGap()));
		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING).addGroup(groupLayout.createSequentialGroup()
						.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 800, Short.MAX_VALUE).addContainerGap()));
		setLayout(groupLayout);
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(20, 20, 20, 20);
		 ArrayList<khungsp> list = new ArrayList<khungsp>();
	     
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

	}
}
