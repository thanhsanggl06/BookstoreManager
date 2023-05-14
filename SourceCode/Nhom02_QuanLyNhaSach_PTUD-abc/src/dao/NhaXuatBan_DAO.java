package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.NhaXuatBan;


public class NhaXuatBan_DAO {
	public ArrayList<NhaXuatBan> getAllNXB() throws SQLException{
		ArrayList<NhaXuatBan> ds = new ArrayList<NhaXuatBan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhaXuatBan";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maNXB = rs.getString(1);
				String tenNXB = rs.getString(2);
				NhaXuatBan nxb = new NhaXuatBan(maNXB, tenNXB);
				ds.add(nxb);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public NhaXuatBan getNXBTheoMa(String maNxb) {
		NhaXuatBan nxb = new NhaXuatBan();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from NhaXuatBan where MaNXB = '"+maNxb+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String ma = rs.getString(1);
				String ten = rs.getString(2);
				nxb = new NhaXuatBan(ma, ten);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return nxb;
		}
}
