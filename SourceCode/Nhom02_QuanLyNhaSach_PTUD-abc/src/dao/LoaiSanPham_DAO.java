package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.LoaiSanPham;


public class LoaiSanPham_DAO {
	public ArrayList<LoaiSanPham> getAllLoaiSP() throws SQLException{
		ArrayList<LoaiSanPham> ds = new ArrayList<LoaiSanPham>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiSanPham";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maLoai = rs.getString(1);
				String tenLoai = rs.getString(2);
				LoaiSanPham lsp = new LoaiSanPham(maLoai, tenLoai);
				ds.add(lsp);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public LoaiSanPham getLoaiTheoMa(String malsp) {
		LoaiSanPham lsp = new LoaiSanPham();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from LoaiSanPham where MaLoaiSanPham = '"+malsp+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maLoai = rs.getString(1);
				String tenLoai = rs.getString(2);
				lsp = new LoaiSanPham(maLoai, tenLoai);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return lsp;
		}
}
