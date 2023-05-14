package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.KhachHang;
import entity.NhanVien;
import entity.ThuongHieu;

public class KhachHang_DAO {
	public ArrayList<KhachHang> getAllKhachHang() throws SQLException {
		ArrayList<KhachHang> ds = new ArrayList<KhachHang>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang where tinhtrang = 'in'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				java.sql.Date ngaySinh = rs.getDate(3);
				String gioiTinh = rs.getString(4);
//				String diaChi = rs.getString(5);
				String soDienThoai = rs.getString(6);
				KhachHang kh = new KhachHang(maKH, tenKH, ngaySinh, gioiTinh, soDienThoai);
				ds.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public boolean addKhachHang(KhachHang kh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " KhachHang values(?,?,?,?,?,?,?)");
			stmt.setString(1, kh.getMaKH());
			stmt.setString(2, kh.getTenKH());
			stmt.setDate(3, kh.getNgaySinh());
			stmt.setString(4, kh.getGioiTinh());
			stmt.setString(5, "a");
			stmt.setString(6, kh.getSoDienThoai());
			stmt.setString(7, "in");

			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return n > 0;
	}

	public boolean deleteKhachHang(String ma) throws SQLException {
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("update KhachHang set TinhTrang = 'out' where MaKhachHang = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return n > 0;
	}

	public boolean updateKhachHang(KhachHang kh) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0;
		try {
			stmt = con.prepareStatement(
					"update KhachHang set TenKhachHang=?,NgaySinh=?,GioiTinh=?, DiaChi=?, SoDienThoai = ? where MaKhachHang=?");

			stmt.setString(6, kh.getMaKH());
			stmt.setString(1, kh.getTenKH());
			stmt.setDate(2, kh.getNgaySinh());
			stmt.setString(3, kh.getGioiTinh());
			stmt.setString(4, "a");
			stmt.setString(5, kh.getSoDienThoai());
			n = stmt.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			stmt.close();
		}
		return n > 0;
	}

	public KhachHang getKhachHangTheoMa(String maKh) {
		KhachHang kh = new KhachHang();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang where MaKhachHang = '" + maKh + "'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				java.sql.Date ngaySinh = rs.getDate(3);
				String gioiTinh = rs.getString(4);
//				String diaChi = rs.getString(5);
				String soDienThoai = rs.getString(6);
				kh = new KhachHang(maKH, tenKH, ngaySinh, gioiTinh, soDienThoai);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
	
	public KhachHang getKhachHangTheoSDT(String SDT) {
		KhachHang kh = new KhachHang();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from KhachHang where SoDienThoai =" + SDT + "";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String maKH = rs.getString(1);
				String tenKH = rs.getString(2);
				java.sql.Date ngaySinh = rs.getDate(3);
				String gioiTinh = rs.getString(4);
//				String diaChi = rs.getString(5);
				String soDienThoai = rs.getString(6);
				kh = new KhachHang(maKH, tenKH, ngaySinh, gioiTinh, soDienThoai);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kh;
	}
	
	public boolean kHCoTrongHeThong(String sdt) {
		int dem = -1;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count (distinct sodienthoai) from KhachHang where sodienthoai = '"+sdt+"' and TinhTrang = 'in'";
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

	public String phatSinhMaKH() throws SQLException {

		String sql = "select MAX(MaKhachHang) from KhachHang";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				if (rs.getString(1) == null) {
					return "KH0001";
				}

				else {

					long id = Long.parseLong(rs.getString(1).substring(2, rs.getString(1).trim().length()));
					id++;
					return "KH" + String.format("%04d", id);
				}
			}
		}
	}
	
	public void dsKHTimKiem(JTextField txtTimKiem, DefaultTableModel model, JTable tbl){
		while (tbl.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		try {
			String chuoi = txtTimKiem.getText();
			if(txtTimKiem.getText().equals("")) {
				chuoi = "73662728682436";
			}
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT       MaKhachHang, TenKhachHang, Ngaysinh, GioiTinh, SoDienThoai\r\n"
					+ "FROM            dbo.KhachHang\r\n"
					+ "Where (MaKhachHang like '%"+chuoi+"%' or TenKhachHang like N'%"+chuoi+"%' or GioiTinh like N'%"+chuoi+"%' or SoDienThoai like '%"+chuoi+"%' or Ngaysinh like '%"+chuoi+"%')"
							+ "and TinhTrang = 'in'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String makh = rs.getString(1);
				String tenkh = rs.getString(2);
				java.sql.Date ns = rs.getDate(3);
				String gt = rs.getNString(4);
				String sdt = rs.getString(5);
				
				model.addRow(new Object[] {makh,tenkh,ns,gt,sdt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
