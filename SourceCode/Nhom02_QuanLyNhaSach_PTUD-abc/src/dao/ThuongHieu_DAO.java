package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TheLoai;
import entity.ThuongHieu;

public class ThuongHieu_DAO {
	public ArrayList<ThuongHieu> getAllThuongHieu() throws SQLException{
		ArrayList<ThuongHieu> ds = new ArrayList<ThuongHieu>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ThuongHieu";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maTH = rs.getString(1);
				String tenTH = rs.getString(2);
				ThuongHieu th = new ThuongHieu(maTH, tenTH);
				ds.add(th);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public ThuongHieu getThuongHieuTheoMa(String maThuongHieu) {
		ThuongHieu th = new ThuongHieu();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ThuongHieu where MaThuongHieu = '"+maThuongHieu+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maTH = rs.getString(1);
				String tenTH = rs.getString(2);
				th = new ThuongHieu(maTH, tenTH);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return th;
		}
}
