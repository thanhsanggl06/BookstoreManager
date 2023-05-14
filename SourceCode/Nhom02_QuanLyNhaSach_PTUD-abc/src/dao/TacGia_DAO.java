package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.TacGia;
import entity.TheLoai;

public class TacGia_DAO {
	public ArrayList<TacGia> getAllTacGia() throws SQLException{
		ArrayList<TacGia> ds = new ArrayList<TacGia>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TacGia";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maTG = rs.getString(1);
				String tenTG = rs.getString(2);
				TacGia tg = new TacGia(maTG, tenTG);
				ds.add(tg);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public TacGia getTacGiaTheoMa(String maTGia) {
		TacGia tg = new TacGia();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TacGia where MaTacGia = '"+maTGia+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maTG = rs.getString(1);
				String tenTG = rs.getString(2);
				tg = new TacGia(maTG, tenTG);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return tg;
		}
}
