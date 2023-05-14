package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.Sach;
import entity.VanPhongPham;

public class ChiTietHoaDon_DAO {
	private Sach_DAO sachDao = new Sach_DAO();
	private VanPhongPham_DAO vppDao = new VanPhongPham_DAO();
	public ArrayList<ChiTietHoaDon> getAllCTHD() throws SQLException{
		ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ChiTietHoaDon";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maHD = rs.getString(1);
				String maSP = rs.getString(2);
				Sach s = null;
				VanPhongPham vpp = null;
				if(maSP.contains("SP")== true) {
					s = sachDao.getSachTheoMa(maSP);
				}else {
					vpp = vppDao.getVPPTheoMa(maSP);
				}
				int soLuong = rs.getInt(3);
//				Double thanhTien = rs.getDouble(4);
				ChiTietHoaDon cthd = null;
				if(s==null) {
					cthd = new ChiTietHoaDon(vpp, soLuong, maHD);
				}else {
					cthd = new ChiTietHoaDon(s, soLuong, maHD);
				}
				ds.add(cthd);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	public boolean addCTHD(ChiTietHoaDon cthd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " ChiTietHoaDon values(?,?,?,?)");
			stmt.setString(1, cthd.getMaHD());
			stmt.setString(2, cthd.getSp().getMaSP());
			stmt.setInt(3, cthd.getSoLuong());
			stmt.setDouble(4, cthd.getSoLuong()*cthd.getSp().getGiaBan());
			
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
	
	public boolean deleteCthd (String ma) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from ChiTietHoaDon where MaHoaDon = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	
	public ArrayList<ChiTietHoaDon> getCthdTheoMa(String ma) {
		ArrayList<ChiTietHoaDon> ds = new ArrayList<ChiTietHoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from ChiTietHoaDon where MaHoaDon = '"+ma+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maHD = ma;
				String maSP = rs.getString(2);
				Sach s = null;
				VanPhongPham vpp = null;
				if(maSP.contains("SP")== true) {
					ArrayList<Sach> dssach = sachDao.getAllSach();
					for (Sach sach : dssach) {
						if(sach.getMaSP().equals(maSP)) {
							s = sach;
							break;
						}
					}
				}else {
					ArrayList<VanPhongPham> dsvpp = vppDao.getAllVanPhongPham();
					for (VanPhongPham vanPhongPham : dsvpp) {
						if(vanPhongPham.getMaSP().equals(maSP)) {
							vpp = vanPhongPham;
							break;
						}
					}
				}
				int soLuong = rs.getInt(3);
//				Double thanhTien = rs.getDouble(4);
				ChiTietHoaDon cthd = null;
				if(s==null) {
					cthd = new ChiTietHoaDon(vpp, soLuong, maHD);
				}else {
					cthd = new ChiTietHoaDon(s, soLuong, maHD);
				}
				ds.add(cthd);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	}
	
	

