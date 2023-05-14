package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TheLoai;

public class TheLoai_DAO {
	public ArrayList<TheLoai> getAllTheLoai() throws SQLException{
		ArrayList<TheLoai> ds = new ArrayList<TheLoai>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TheLoai";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maTL = rs.getString(1);
				String tenTL = rs.getString(2);
				TheLoai tl = new TheLoai(maTL, tenTL);
				ds.add(tl);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	public TheLoai getTheLoaiTheoMa(String maTLoai) {
		TheLoai tl = new TheLoai();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TheLoai where MaTheLoai = '"+maTLoai+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maTL = rs.getString(1);
				String tenTL = rs.getString(2);
				tl = new TheLoai(maTL,tenTL);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return tl;
		}
	}

