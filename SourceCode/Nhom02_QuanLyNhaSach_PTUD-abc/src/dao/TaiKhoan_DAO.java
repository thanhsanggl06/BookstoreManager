package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import entity.NhanVien;
import connectDB.ConnectDB;
import entity.TaiKhoan;

public class TaiKhoan_DAO {
	public static String manv;
	public static String email;
	private static TaiKhoan taikhoan;

	public ArrayList<TaiKhoan> getallTaiKhoan() {
		ArrayList<TaiKhoan> dstk = new ArrayList<TaiKhoan>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from TaiKhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				NhanVien manv = new NhanVien(rs.getString("MaNhanVien"));
				String tendn = rs.getString("TenDangNhap");
				String passw = rs.getString("Password");
				String pQ = rs.getString("PhanQuyen");
				TaiKhoan tk = new TaiKhoan(manv, tendn, passw, pQ);
				dstk.add(tk);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dstk;
	}

	public boolean createtaikhoan(TaiKhoan tk) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {

			stmt = con.prepareStatement("insert into TaiKhoan values(?,?,?,?)");
			stmt.setString(1, tk.getNv().getMaNV());
			stmt.setString(2, tk.getTenDangNhap());
			stmt.setString(3, tk.getPassWord());
			stmt.setString(4, tk.getPhanQuyen());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean XoaTaiKhoan(String manv) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from TaiKhoan where MaNhanVien=?");
			stmt.setString(1, manv);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean update(TaiKhoan tk) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set TenDangNhap=?, Password=? where MaNhanVien=? ");
			stmt.setString(1, tk.getTenDangNhap());
			stmt.setString(2, tk.getPassWord());
			stmt.setString(3, tk.getNv().getMaNV());
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException ee) {
				ee.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean updateMK(String tdn, String pwd) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update TaiKhoan set Password=? where TenDangNhap =? ");
			stmt.setString(1, pwd);
			stmt.setString(2, tdn);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException ee) {
				ee.printStackTrace();
			}
		}
		return n > 0;
	}

	public void dsKHTimKiem(JTextField txtTimKiem, JLabel lbl) {
		if (lbl.getText() != "") {
			lbl.setText("");
		}
		try {
			String chuoi = txtTimKiem.getText();
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT       dbo.NhanVien.Email\r\n" + "FROM            dbo.TaiKhoan INNER JOIN\r\n"
					+ "                         dbo.NhanVien ON dbo.TaiKhoan.MaNhanVien = dbo.NhanVien.MaNhanVien\r\n"
					+ "Where TenDangNhap = '" + chuoi + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				email = rs.getString(1);

				lbl.setText("Mã Xác Nhận Sẽ Được Gửi Về Email : " + email);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public ArrayList<String> dsNVChuaCoTK(){
		ArrayList<String> dstk = new ArrayList<String>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select MaNhanVien from NhanVien except select MaNhanVien from Taikhoan";
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				String manv = rs.getString("MaNhanVien");
				dstk.add(manv);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return dstk;
	}

}
