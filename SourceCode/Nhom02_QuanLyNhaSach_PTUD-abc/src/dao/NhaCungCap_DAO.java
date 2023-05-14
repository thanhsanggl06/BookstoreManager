package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhaCungCap;
import entity.NhaXuatBan;

public class NhaCungCap_DAO {
	public ArrayList<NhaCungCap> getAllNhaCungCap() throws SQLException{
		ArrayList<NhaCungCap> ds = new ArrayList<NhaCungCap>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhaCungCap";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String diaChi = rs.getString(3);
				String soDienThoai = rs.getString(4);
				String email = rs.getString(5);
				NhaCungCap ncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai, email);
				ds.add(ncc);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public boolean addNhaCungCap(NhaCungCap ncc) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " NhaCungCap values(?,?,?,?,?)");
			stmt.setString(1, ncc.getMaNCC());
			stmt.setString(2, ncc.getTenNCC());
			stmt.setString(3, ncc.getDiaChi());
			stmt.setString(4,ncc.getSoDT());
			stmt.setString(5, ncc.getEmail());
			
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
	public boolean deleteNhaCungCap (String ma) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from NhaCungCap where MaNCC = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	
	public boolean updateNhaCungCap (NhaCungCap ncc ) throws SQLException
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0 ;
		try {
			stmt = con.prepareStatement("update NhaCungCap set TenNCC=?, DiaChi=?, SoDienThoai = ?, Email = ? where MaNCC=?");
			
			
			stmt.setString(5, ncc.getMaNCC());
			stmt.setString(1, ncc.getTenNCC());
			stmt.setString(2, ncc.getDiaChi());
			stmt.setString(3,ncc.getSoDT());
			stmt.setString(4, ncc.getEmail());		
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n > 0;
	}
	
	public NhaCungCap getNccTheoMa(String maNcc) {
		NhaCungCap ncc = new NhaCungCap();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhaCungCap where MaNCC = '"+maNcc+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maNCC = rs.getString(1);
				String tenNCC = rs.getString(2);
				String diaChi = rs.getString(3);
				String soDienThoai = rs.getString(4);
				String email = rs.getString(5);
				ncc = new NhaCungCap(maNCC, tenNCC, diaChi, soDienThoai, email);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ncc;
		}
	public String phatSinhMaNCC() throws SQLException {

		String sql = "select MAX(MaNCC) from NhaCungCap";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				if (rs.getString(1) == null) {
					return "NCC0001";
				}

				else {

					long id = Long.parseLong(rs.getString(1).substring(3, rs.getString(1).trim().length()));
					id++;
					return "NCC" + String.format("%04d", id);
				}
			}
		}
	}
	public void dsNCCTimKiem(String sql, DefaultTableModel model, JTable tbl){
		while (tbl.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT       dbo.SanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.SanPham.GiaNhap, dbo.SanPham.SoLuongTon, dbo.SanPham.DonViTinh, dbo.NhaXuatBan.TenNXB, dbo.TacGia.TenTacGia, dbo.NhaCungCap.TenNCC, \r\n"
//					+ "                         dbo.TheLoai.TenTheLoai\r\n"
//					+ "FROM            dbo.SanPham INNER JOIN\r\n"
//					+ "                         dbo.NhaXuatBan ON dbo.SanPham.MaNXB = dbo.NhaXuatBan.MaNXB INNER JOIN\r\n"
//					+ "                         dbo.TacGia ON dbo.SanPham.MaTacGia = dbo.TacGia.MaTacGia INNER JOIN\r\n"
//					+ "                         dbo.NhaCungCap ON dbo.SanPham.MaNCC = dbo.NhaCungCap.MaNCC INNER JOIN\r\n"
//					+ "                         dbo.TheLoai ON dbo.SanPham.MaTheLoai = dbo.TheLoai.MaTheLoai\r\n"
//					+ "Where (TacGia.TenTacGia Like N'%"+chuoi+"%' or SanPham.MaSanPham like '%"+chuoi+"%' or SanPham.TenSanPham like N'%"+chuoi+"%' or NhaCungCap.TenNCC like N'%"+chuoi+"%' or NhaXuatBan.TenNXB like N'%"+chuoi+"%' or TheLoai.TenTheLoai like N'%"+chuoi+"%') and TrangThai = 'c' and SanPham.MaSanPham like '%SP%'\r\n"
//					+ "";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String mancc = rs.getString(1);
				String tenncc = rs.getString(2);
				String diachi = rs.getString(3);
				String sdt = rs.getString(4);
				String email = rs.getString(5);
				
				model.addRow(new Object[] {mancc,tenncc,diachi,email,sdt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
