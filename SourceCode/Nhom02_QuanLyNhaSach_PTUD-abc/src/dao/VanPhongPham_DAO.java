package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.LoaiSanPham;
import entity.NhaCungCap;
import entity.Sach;
import entity.SanPham;
import entity.ThuongHieu;
import entity.VanPhongPham;

public class VanPhongPham_DAO {
	private ThuongHieu_DAO thDao = new ThuongHieu_DAO();
	private LoaiSanPham_DAO lspDao = new LoaiSanPham_DAO();
	private NhaCungCap_DAO nccDao = new NhaCungCap_DAO();
	public ArrayList<VanPhongPham> getAllVanPhongPham() throws SQLException{
		ArrayList<VanPhongPham> ds = new ArrayList<VanPhongPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SanPham Where MaSanPham like 'VPP%' and TrangThai = 'c'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				Double giaNhap = rs.getDouble(4);
				String maTH = rs.getString(6);
				ThuongHieu th = thDao.getThuongHieuTheoMa(maTH);
				
				String maLoai = rs.getString(7);
				LoaiSanPham lsp = lspDao.getLoaiTheoMa(maLoai);
				
				String maNCC = rs.getString(8);
				NhaCungCap ncc = nccDao.getNccTheoMa(maNCC);
				
				int soLuongTon = rs.getInt(9);
				String hinhAnh = rs.getString(10);
				String donViTinh = rs.getString(12);
//				
				VanPhongPham vpp = new VanPhongPham(maSP, tenSP, giaNhap, hinhAnh, ncc, soLuongTon, th, donViTinh,lsp);
				ds.add(vpp);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public boolean addVanPhongPham(VanPhongPham s) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " SanPham values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, s.getMaSP());
			stmt.setString(2, s.getTenSP());
			stmt.setNull(3, Types.VARCHAR);
			stmt.setDouble(4, s.getGiaNhap());
			stmt.setNull(5, Types.VARCHAR);
			stmt.setString(6, s.getTh().getMaThuongHieu());
			stmt.setString(7, s.getLsp().getMaLoai());
			stmt.setString(8, s.getNcc().getMaNCC());
			stmt.setInt(9, s.getSoLuongTon());
			stmt.setString(10, s.getHinhAnh());
			stmt.setNull(11, Types.VARCHAR);
			stmt.setString(12,s.getDonViTinh());
			stmt.setString(13, "c");
			
			
			n= stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n>0;
	}
	
	
	public boolean updateVanPhongPham (VanPhongPham s ) throws SQLException
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0 ;
		try {
			stmt = con.prepareStatement("update SanPham set TenSanPham=?,GiaNhap=?, MaThuongHieu=?,MaLoaiSanPham = ?, MaNCC = ?, SoLuongTon = ?, Image = ?, DonViTinh = ? where MaSanPham=?");
			
			
			stmt.setString(9, s.getMaSP());
			stmt.setString(1, s.getTenSP());
			stmt.setDouble(2, s.getGiaNhap());
			stmt.setString(3, s.getTh().getMaThuongHieu());
			stmt.setString(4, s.getLsp().getMaLoai());
			stmt.setString(5, s.getNcc().getMaNCC());
			stmt.setInt(6, s.getSoLuongTon());
			stmt.setString(7, s.getHinhAnh());
			stmt.setString(8, s.getDonViTinh());			
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n > 0;
	}
	
	public VanPhongPham getVPPTheoMa(String maVPP) {
		VanPhongPham vpp = new VanPhongPham();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SanPham where MaSanPham = '"+maVPP+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				Double giaNhap = rs.getDouble(4);
				String maTH = rs.getString(6);
				ThuongHieu th = thDao.getThuongHieuTheoMa(maTH);
				
				String maLoai = rs.getString(7);
				LoaiSanPham lsp = lspDao.getLoaiTheoMa(maLoai);
				
				String maNCC = rs.getString(8);
				NhaCungCap ncc = nccDao.getNccTheoMa(maNCC);
				
				int soLuongTon = rs.getInt(9);
				String hinhAnh = rs.getString(10);
				String donViTinh = rs.getString(12);
//				
				vpp = new VanPhongPham(maSP, tenSP, giaNhap, hinhAnh, ncc, soLuongTon, th, donViTinh,lsp);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return vpp;
		}
	public String getDonViTinhVPP(String ma) {
		String dvt = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select DonViTinh from SanPham Where MaSanPham = '"+ma+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				dvt = rs.getString(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return dvt;
	}
	public String phatSinhMaVPP() throws SQLException {

		String sql = "select MAX(MaSanPham) from SanPham where MaSanPham like 'VPP%'";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				if (rs.getString(1) == null) {
					return "VPP0001";
				}

				else {

					long id = Long.parseLong(rs.getString(1).substring(3, rs.getString(1).trim().length()));
					id++;
					return "VPP" + String.format("%04d", id);
				}
			}
		}
	}
	public boolean vppCoTrongHeThong(String masp) {
		int dem = -1;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count (distinct masanpham) from SanPham where MaSanPham = '"+masp+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				dem = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (dem == 0) {
			return false;
		}else {
			return true;
		}
	}
	
	public String selectTenSP(String ma) {
		String ten = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select TenSanPham from SanPham Where MaSanPham = '"+ma+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				ten = rs.getString(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ten;
		}
	public void dsSPTimKiem(String sql, DefaultTableModel model, JTable tbl){
		while (tbl.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		try {
//			double so = 0;
//			if(txtTimKiem.getText().equals("")) {
//				so = 0;
//			}else if(txtTimKiem.getText().chars().allMatch(Character::isDigit)) {
//				so = Double.parseDouble(txtTimKiem.getText());
//			}
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
//			String sql = "Select MaSanPham, TenSanPham, GiaNhap, SoLuongTon, DonViTinh from SanPham Where (MaSanPham like'%"+txtTimKiem.getText()+"%'"
//					+ "or TenSanPham like N'%"+txtTimKiem.getText()+"%' or GiaNhap * 1.5 = " +so+ ") and TrangThai = 'c'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String masp = rs.getString(1);
				String tensp = rs.getString(2);
				double gia = rs.getDouble(3);
				int slt = rs.getInt(4);
				String dvt = rs.getString(5);
				
				model.addRow(new Object[] {masp,tensp,slt,dvt,gia*1.5});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	public int selectSLT(String ma) {
		int slt = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select SoLuongTon from SanPham Where MaSanPham = '"+ma+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				slt = rs.getInt(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return slt;
		}
	public boolean updateSoLuongTon(String ma, int sldb ) throws SQLException
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0 ;
		try {
			stmt = con.prepareStatement("update SanPham set soluongton = soluongton - "+sldb+" where masanpham = '"+ma+"'");
//			stmt.setString(2, ma);
//			stmt.setInt(1, slt);
						
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n > 0;
	}
	
	public boolean updateSoLuongTonHDTam(String ma, int slhdt ) throws SQLException
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0 ;
		try {
			stmt = con.prepareStatement("update SanPham set soluongton = soluongton + "+slhdt+" where masanpham = '"+ma+"'");
//			stmt.setString(2, ma);
//			stmt.setInt(1, slt);
						
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n > 0;
	}
	
	public String getHinhAnhSP(String ma) {
		String hinhAnh = "";
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select Image from SanPham Where MaSanPham = '"+ma+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				hinhAnh = rs.getString(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return hinhAnh;
	}
	
	public void dsVPPTimKiem(String sql, DefaultTableModel model, JTable tbl){
		while (tbl.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		try {
//			String chuoi = txtTimKiem.getText();
//			if(txtTimKiem.getText().equals("")) {
//				chuoi = "73662728682436";
//			}
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT       dbo.SanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.SanPham.GiaNhap, dbo.SanPham.SoLuongTon, dbo.SanPham.DonViTinh, dbo.ThuongHieu.TenThuongHieu, dbo.LoaiSanPham.TenLoaiSanPham, \r\n"
//					+ "                         dbo.NhaCungCap.TenNCC\r\n"
//					+ "FROM            dbo.SanPham INNER JOIN\r\n"
//					+ "                         dbo.ThuongHieu ON dbo.SanPham.MaThuongHieu = dbo.ThuongHieu.MaThuongHieu INNER JOIN\r\n"
//					+ "                         dbo.LoaiSanPham ON dbo.SanPham.MaLoaiSanPham = dbo.LoaiSanPham.MaLoaiSanPham INNER JOIN\r\n"
//					+ "                         dbo.NhaCungCap ON dbo.SanPham.MaNCC = dbo.NhaCungCap.MaNCC\r\n"
//					+ "Where (SanPham.TenSanPham like N'%"+chuoi+"%' or SanPham.MaSanPham like '%"+chuoi+"%' or ThuongHieu.TenThuongHieu like N'%"+chuoi+"%' or LoaiSanPham.TenLoaiSanPham like N'%"+chuoi+"%' or NhaCungCap.TenNCC like N'%"+chuoi+"%') and SanPham.MaSanPham like '%VPP%' and SanPham.TrangThai = 'c'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String masp = rs.getString(1);
				String tensp = rs.getString(2);
				double gia = rs.getDouble(3);
				int slt = rs.getInt(4);
				String dvt = rs.getString(5);
				String th = rs.getNString(6);
				String lsp = rs.getNString(7);
				String ncc = rs.getNString(8);
				
				model.addRow(new Object[] {masp,tensp,lsp,th,ncc,slt,gia,dvt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	
}

