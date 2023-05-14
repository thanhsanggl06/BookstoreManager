package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;


public class NhanVien_DAO {
	public ArrayList<NhanVien> getAllNhanVien() throws SQLException{
		ArrayList<NhanVien> ds = new ArrayList<NhanVien>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien where TinhTrang = 'in'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				java.sql.Date ngaySinh = rs.getDate(3);
				String gioiTinh = rs.getString(4);
				java.sql.Date ngayVaoLam = rs.getDate(5);
				String chucVu = rs.getString(6);
				String diaChi = rs.getString(7);
				String soDienThoai = rs.getString(8);
				String email = rs.getString(9);
				NhanVien nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, ngayVaoLam, chucVu, diaChi, soDienThoai, email);
				ds.add(nv);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public boolean addNhanVien(NhanVien nv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " NhanVien values(?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, nv.getMaNV());
			stmt.setString(2, nv.getTenNV());
			stmt.setDate(3, nv.getNgaySinh());
			stmt.setString(4, nv.getGioiTinh());
			stmt.setDate(5, nv.getNgayVaoLam());
			stmt.setString(6, nv.getChucVu());
			stmt.setString(7, nv.getDiaChi());
			stmt.setString(8, nv.getSoDienThoai());
			stmt.setString(9, nv.getEmail());
			stmt.setString(10, "in");
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
	public boolean deleteNV(String ma) throws SQLException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update NhanVien set TinhTrang = 'out' where MaNhanVien = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return n > 0;
	}
	
	public boolean updateNhanVien (NhanVien nv ) throws SQLException
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0 ;
		try {
			stmt = con.prepareStatement("update NhanVien set TenNhanVien=?,NgaySinh=?,GioiTinh=?,NgayVaoLam=?,ChucVu=?, DiaChi=?, SoDienThoai = ?, Email = ? where MaNhanVien=?");
			
			
			stmt.setString(1, nv.getTenNV());
			stmt.setDate(2, nv.getNgaySinh());
			stmt.setString(3, nv.getGioiTinh());
			stmt.setDate(4, nv.getNgayVaoLam());
			stmt.setString(5, nv.getChucVu());
			stmt.setString(6, nv.getDiaChi());
			stmt.setString(7, nv.getSoDienThoai());
			stmt.setString(8, nv.getEmail());
			stmt.setString(9, nv.getMaNV());
			
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n > 0;
	}
	public NhanVien getNVTheoMa(String maNv) {
		NhanVien nv = new NhanVien();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien where MaNhanVien = '"+maNv+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maNV = rs.getString(1);
				String tenNV = rs.getString(2);
				java.sql.Date ngaySinh = rs.getDate(3);
				String gioiTinh = rs.getString(4);
				java.sql.Date ngayVaoLam = rs.getDate(5);
				String chucVu = rs.getString(6);
				String diaChi = rs.getString(7);
				String soDienThoai = rs.getString(8);
				String email = rs.getString(9);
				nv = new NhanVien(maNV, tenNV, ngaySinh, gioiTinh, ngayVaoLam, chucVu, diaChi, soDienThoai, email);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return nv;
		}
	public String phatSinhMaNV() throws SQLException {

		String sql = "select MAX(MaNhanVien) from NhanVien";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				if (rs.getString(1) == null) {
					return "NV0001";
				}

				else {

					long id = Long.parseLong(rs.getString(1).substring(2, rs.getString(1).trim().length()));
					id++;
					return "NV" + String.format("%04d", id);
				}
			}
		}
	}
	
	public void dsNVTimKiem(JTextField txtTimKiem, DefaultTableModel model, JTable tbl){
		while (tbl.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		try {
			String chuoi = txtTimKiem.getText();
			
			if(txtTimKiem.getText().isEmpty()) {
				chuoi = "00000000000000";
			}
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien Where (MaNhanVien like'%"+chuoi+"%'"
					+ "or TenNhanVien like N'%"+chuoi+"%' or SoDienThoai like '%" +chuoi+"%')";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String manv = rs.getString(1);
				String tennv = rs.getString(2);
				Date ns = rs.getDate(3);
				String gt = rs.getNString(4);
				Date nvl =rs.getDate(5);
				String chucVu = rs.getString(6);
				String diaChi = rs.getString(7);
				String sdt = rs.getString(8);
				String email = rs.getString(9);
				
				model.addRow(new Object[] {manv,tennv,ns,diaChi,nvl,gt,sdt,chucVu, email});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	
	public void dsNV(DefaultTableModel model, JTable tbl){
		while (tbl.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		try {
			
			
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhanVien where TinhTrang = 'in'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String manv = rs.getString(1);
				String tennv = rs.getString(2);
				Date ns = rs.getDate(3);
				String gt = rs.getNString(4);
				Date nvl =rs.getDate(5);
				String chucVu = rs.getString(6);
				String diaChi = rs.getString(7);
				String sdt = rs.getString(8);
				String email = rs.getString(9);
				
				model.addRow(new Object[] {manv,tennv,ns,diaChi,nvl,gt,sdt,chucVu, email});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	
	}

