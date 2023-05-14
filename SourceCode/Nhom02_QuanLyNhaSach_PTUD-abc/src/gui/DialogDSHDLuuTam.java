package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.ChiTietHoaDon_DAO;
import dao.HoaDon_DAO;
import dao.KhachHang_DAO;
import dao.VanPhongPham_DAO;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.VanPhongPham;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class DialogDSHDLuuTam extends JDialog {
	private DefaultTableModel modelkh;
	private JTable tbl_hdt;
	private JScrollPane src_hdt;
	private HoaDon_DAO hd_dao = new HoaDon_DAO();
	private ChiTietHoaDon_DAO cthd_dao = new ChiTietHoaDon_DAO();
	private VanPhongPham_DAO vpp_dao = new VanPhongPham_DAO();
	private KhachHang_DAO kh_dao = new KhachHang_DAO();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogDSHDLuuTam dialog = new DialogDSHDLuuTam();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogDSHDLuuTam() {
		setBounds(100, 100, 829, 479);
		setResizable(false);
		getContentPane().setLayout(null);
		{
			
			String[] headers = { "Mã hóa đơn", "Số điện thoại", "Tên Khách Hàng","Tổng Tiền"};
			modelkh = new DefaultTableModel(headers, 0);
			tbl_hdt = new JTable(modelkh);
			src_hdt = new JScrollPane(tbl_hdt); 
			src_hdt.setBounds(0, 124, 813, 233);
			getContentPane().add(src_hdt);
		}
		{
			JLabel lblNewLabel = new JLabel("Danh Sách Hóa Đơn Chờ Thanh Toán");
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblNewLabel.setBounds(0, 22, 813, 28);
			getContentPane().add(lblNewLabel);
		}
		
		JButton btnTiepTuc = new JButton("Tiếp tục");
		btnTiepTuc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_hdt.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn hóa đơn tiếp tục thanh toán");
				}else {
					if(LapHoaDonBan_Form.lbl_mahd_nhap.getText().equals("")) {
						double tt = Double.parseDouble(tbl_hdt.getValueAt(tbl_hdt.getSelectedRow(), 3).toString()) ;
						DecimalFormat dfm = new DecimalFormat("###,###.#VND");
						String tongct = dfm.format(tt*10/11);
						String tong = dfm.format(tt);
						String ma = tbl_hdt.getValueAt(tbl_hdt.getSelectedRow(), 0).toString();
						String sdtkh = tbl_hdt.getValueAt(tbl_hdt.getSelectedRow(), 1).toString();
						LapHoaDonBan_Form.lbl_mahd_nhap.setText(tbl_hdt.getValueAt(tbl_hdt.getSelectedRow(), 0).toString());
						LapHoaDonBan_Form.lbl_tenkh_nhap.setText(tbl_hdt.getValueAt(tbl_hdt.getSelectedRow(), 2).toString());
						LapHoaDonBan_Form.txt_sdtkh.setText(tbl_hdt.getValueAt(tbl_hdt.getSelectedRow(), 1).toString());
						LapHoaDonBan_Form.lbl_tongcongVAT_nhap.setText(tong);
						LapHoaDonBan_Form.lbl_tongtien_nhap.setText(tongct);
						
						LapHoaDonBan_Form.kh = kh_dao.getKhachHangTheoSDT(sdtkh);
						
						ArrayList<ChiTietHoaDon> dscthd = cthd_dao.getCthdTheoMa(ma);
						while (LapHoaDonBan_Form.tbl_sp.getRowCount() != 0) {
							LapHoaDonBan_Form.modelkh.removeRow(0);
						}
						for (ChiTietHoaDon cthd : dscthd) {
							String maSP = cthd.getSp().getMaSP();
							String tenSp = cthd.getSp().getTenSP();
							int soLuong = cthd.getSoLuong();
							double giaBan = cthd.getSp().getGiaBan();
							String dvt ="";
							if(cthd.getSp().getMaSP().startsWith("SP")) {
								dvt = "Quyển";
								
							}else {
								dvt = vpp_dao.getDonViTinhVPP(cthd.getSp().getMaSP());
							}
							LapHoaDonBan_Form.modelkh.addRow(new Object [] {maSP,tenSp,cthd.getSp().getSoLuongTon(),dvt,giaBan});
							
							
							double thanhTien = cthd.thanhTien();
							
							LapHoaDonBan_Form.modelkh1.addRow(new Object[] {maSP,tenSp,giaBan,soLuong,dvt,thanhTien});
						}
						try {
							cthd_dao.deleteCthd(ma);
							hd_dao.deleteHd(ma);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
						LapHoaDonBan_Form.btn_thanhtoan.setEnabled(true);
						LapHoaDonBan_Form.btn_luutam.setEnabled(true);
						LapHoaDonBan_Form.btn_huyhoadon.setEnabled(true);
					}else {
						JOptionPane.showMessageDialog(null, "Có hóa đơn hiện hành");
					}
				}
			}
		});
		btnTiepTuc.setBounds(471, 406, 89, 23);
		getContentPane().add(btnTiepTuc);
		
		JButton btnHuy = new JButton("Hủy Hóa Đơn");
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tbl_hdt.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null, "Chọn hóa đơn muốn hủy");
				}else {
					String ma = tbl_hdt.getValueAt(tbl_hdt.getSelectedRow(), 0).toString();
					int m = JOptionPane.showConfirmDialog(null, "Xác nhận hủy hóa đơn","Chú Ý", JOptionPane.YES_NO_OPTION);
					if(m== JOptionPane.YES_OPTION) {
						ArrayList<ChiTietHoaDon> dscthd = cthd_dao.getCthdTheoMa(ma);
						for (ChiTietHoaDon cthd : dscthd) {
							try {
								vpp_dao.updateSoLuongTonHDTam(cthd.getSp().getMaSP(), cthd.getSoLuong());
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						}
						try {
							
							cthd_dao.deleteCthd(ma);
							if(hd_dao.deleteHd(ma)) {
								JOptionPane.showMessageDialog(null, "Hủy Thành Công");
								modelkh.removeRow(tbl_hdt.getSelectedRow());
							}
							
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
			}
		});
		btnHuy.setBounds(570, 406, 137, 23);
		getContentPane().add(btnHuy);
		
		JButton btnNewButton = new JButton("Cancel");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton.setBounds(717, 406, 89, 23);
		getContentPane().add(btnNewButton);
		loadTable();
	}
	
	private void loadTable() {
		if(hd_dao.coHDChuaTT()) {
			ArrayList<HoaDon> dshdt = new ArrayList<>();
			try {
				dshdt = hd_dao.getAllHoaDonTam();
				for (HoaDon hoaDon : dshdt) {
					String maHd = hoaDon.getMaHD();
					String tenKh = hoaDon.getKh().getTenKH();
					String sodt = hoaDon.getKh().getSoDienThoai();
					double tt = (hoaDon.tongTien()*0.1) + hoaDon.tongTien();
					
					modelkh.addRow(new Object[] {maHd, sodt,tenKh,tt});
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
