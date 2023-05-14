package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import java.sql.Date;

import connectDB.ConnectDB;
import entity.ChiTietHoaDon;
import entity.HoaDon;
import entity.KhachHang;
import entity.NhanVien;

public class HoaDonNV_DAO {
	private NhanVien_DAO nhanvienDao = new NhanVien_DAO();
	private KhachHang_DAO khachhangDao = new KhachHang_DAO();
	private ChiTietHoaDon_DAO cthdDao = new ChiTietHoaDon_DAO();
	private Calendar c;

	
	public ArrayList<HoaDon> getAllHoaDon() throws SQLException{
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maHD = rs.getString(1);
				String maKH = rs.getString(2);
				String maNV = rs.getString(3);
				Date ngayLap = rs.getDate(4);
				Double tongTien = rs.getDouble(5);
				Time gioLap = rs.getTime(6);
				NhanVien nv = nhanvienDao.getNVTheoMa(maNV);
				
				KhachHang kh = khachhangDao.getKhachHangTheoMa(maKH);
				
				ArrayList<ChiTietHoaDon> dscthd = cthdDao.getCthdTheoMa(maHD);
				HoaDon hd = new HoaDon(maHD, ngayLap, gioLap, nv, kh, dscthd);
				ds.add(hd);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public ArrayList<HoaDon> getAllHoaDonTam() throws SQLException{
		ArrayList<HoaDon> ds = new ArrayList<HoaDon>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from HoaDon where trangthai = 'ctt'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maHD = rs.getString(1);
				String maKH = rs.getString(2);
				String maNV = rs.getString(3);
				Date ngayLap = rs.getDate(4);
				Double tongTien = rs.getDouble(5);
				Time gioLap = rs.getTime(6);
				NhanVien nv = nhanvienDao.getNVTheoMa(maNV);
				
				KhachHang kh = khachhangDao.getKhachHangTheoMa(maKH);
				
				ArrayList<ChiTietHoaDon> dscthd = cthdDao.getCthdTheoMa(maHD);
				HoaDon hd = new HoaDon(maHD, ngayLap, gioLap, nv, kh, dscthd);
				ds.add(hd);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public boolean addHoaDon(HoaDon hd, double tongTien) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " HoaDon values(?,?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setString(2, hd.getKh().getMaKH());
			stmt.setString(3, hd.getNv().getMaNV());
			stmt.setDate(4, hd.getNgayLap());
			
			
			stmt.setDouble(5, tongTien);
			stmt.setTime(6, hd.getGioLap());
			stmt.setString(7, "dtt");
			
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
	
	public boolean addHoaDonCho(HoaDon hd, double tongTien) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " HoaDon values(?,?,?,?,?,?,?)");
			stmt.setString(1, hd.getMaHD());
			stmt.setString(2, hd.getKh().getMaKH());
			stmt.setString(3, hd.getNv().getMaNV());
			stmt.setDate(4, hd.getNgayLap());
			
			
			stmt.setDouble(5, tongTien);
			stmt.setTime(6, hd.getGioLap());
			stmt.setString(7, "ctt");
			
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
	
	public double tongTienHD(String maHD) {
		ArrayList<ChiTietHoaDon> cthd = cthdDao.getCthdTheoMa(maHD);
		double s = 0;
		for (ChiTietHoaDon chiTietHoaDon : cthd) {
			s = s+ chiTietHoaDon.thanhTien();
		}
		return s;
	}
	public String phatSinhMaHD() throws SQLException {

		String sql = "select MAX(MaHoaDon) from HoaDon";
		c = Calendar.getInstance();
		String maHoaDon = "";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				if (rs.getString(1) == null) {
					maHoaDon = "HD" + (c.get(Calendar.YEAR)-2000)+(c.get(Calendar.MONTH)+1)+"00001";
					return  maHoaDon;
				}

				else {
					String thang = ""+(c.get(Calendar.YEAR)-2000) + (c.get(Calendar.MONTH)+1);
					long ma = Long.parseLong(rs.getString(1).substring(2,6));
					long b = Long.parseLong(thang);
					long id = 0;
					if(b>ma) {
						id = 1;
						return "HD" + (c.get(Calendar.YEAR)-2000)+(c.get(Calendar.MONTH)+1) + String.format("%05d", id);
					}else {
						id = Long.parseLong(rs.getString(1).substring(6, rs.getString(1).trim().length()));
						id++;
						return "HD" + (c.get(Calendar.YEAR)-2000)+(c.get(Calendar.MONTH)+1) + String.format("%05d", id);
					}
					
					
					
				}
			}
		}
	}
	
	public boolean coHDChuaTT() {
		int dem = -1;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count (distinct trangThai) from hoadon where trangthai = 'ctt'";
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
	
	public boolean deleteHd (String ma) throws SQLException
	{
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("delete from HoaDon where MaHoaDon = ?");
			stmt.setString(1, ma);
			n = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n>0;
	}
	
	public void dsHoaDonTimKiem(String sql, DefaultTableModel model, JTable tbl){
		while (tbl.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		try {
//			String chuoi = txtTimKiem.getText();
//			if(txtTimKiem.getText().equals("")) {
//				chuoi = "73662728682436";
//			}
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT DISTINCT  dbo.HoaDon.MaHoaDon, dbo.HoaDon.MaKhachHang, dbo.HoaDon.MaNhanVien, dbo.HoaDon.NgayLapHoaDon, dbo.HoaDon.TongTien, dbo.KhachHang.TenKhachHang, dbo.NhanVien.TenNhanVien\r\n"
//					+ "FROM            dbo.HoaDon INNER JOIN\r\n"
//					+ "                         dbo.ChiTietHoaDon ON dbo.HoaDon.MaHoaDon = dbo.ChiTietHoaDon.MaHoaDon INNER JOIN\r\n"
//					+ "                         dbo.KhachHang ON dbo.HoaDon.MaKhachHang = dbo.KhachHang.MaKhachHang INNER JOIN\r\n"
//					+ "                         dbo.NhanVien ON dbo.HoaDon.MaNhanVien = dbo.NhanVien.MaNhanVien INNER JOIN\r\n"
//					+ " 						dbo.SanPham ON dbo.ChiTietHoaDon.MaSanPham = dbo.SanPham.MaSanPham\r\n"
//					+ "Where HoaDon.MaHoaDon like '%"+chuoi+"%' or NhanVien.MaNhanVien like '%"+chuoi+"%' or NhanVien.TenNhanVien like N'%"+chuoi+"%' or KhachHang.MaKhachHang like '%"+chuoi+"%' or KhachHang.TenKhachHang like N'%"+chuoi+"%' or HoaDon.NgayLapHoaDon like '%"+chuoi+"%'"
//					+ "or SanPham.TenSanPham like N'%"+chuoi+"%' or SanPham.MaSanPham like '%"+chuoi+"%'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String mahd = rs.getString(1);
				String makh = rs.getString(2);
				String tenkh = rs.getString(6);
				String tennv = rs.getString(7);
				String manv = rs.getString(3);
				double tt = rs.getDouble(5);
				Date ngaylap = rs.getDate(4);
				
				model.addRow(new Object[] {mahd,manv+" - "+tennv,makh+" - "+tenkh,ngaylap,tt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
	public void dtBieuDoHomNay(DefaultCategoryDataset dataset) {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formatDate = date.format(dtf);
		String manv = TaiKhoan_DAO.manv;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select DATEPART(day, NgayLapHoaDon) as time, Sum(tongTien) as tongTien	\r\n"
					+ "from HoaDon \r\n"
					+ "WHERE NgayLapHoaDon = '"+formatDate+"' or NgayLapHoaDon = Dateadd(day ,-1,'"+formatDate+"') and trangthai ='dtt' and manhanvien = '"+manv+"'\r\n"
					+ "GROUP BY CAST(HoaDon.NgayLapHoaDon AS DATE), DATEPART(day , HoaDon.NgayLapHoaDon)";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int ngay = rs.getInt(1);
				double tongTien = rs.getDouble(2);
				dataset.addValue(tongTien, "Doanh Thu", ngay+"");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void dtBieuDo7Ngayqua(DefaultCategoryDataset dataset) {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formatDate = date.format(dtf);
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String manv= TaiKhoan_DAO.manv;
			String sql = "select DATEPART(day, NgayLapHoaDon) as time, Sum(tongTien) as tongTien	\r\n"
					+ "from HoaDon \r\n"
					+ "WHERE NgayLapHoaDon <= '"+formatDate+"' and NgayLapHoaDon > Dateadd(day ,-7,'"+formatDate+"') and trangthai = 'dtt' and manhanvien = '"+manv+"'\r\n"
					+ "GROUP BY CAST(HoaDon.NgayLapHoaDon AS DATE), DATEPART(day , HoaDon.NgayLapHoaDon)";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int ngay = rs.getInt(1);
				double tongTien = rs.getDouble(2);
				dataset.addValue(tongTien, "Doanh Thu", ngay+"");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dtBieuDoThangNay(DefaultCategoryDataset dataset) {
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String manv= TaiKhoan_DAO.manv;
			String sql = "select DATEPART(day, NgayLapHoaDon) as time, Sum(tongTien) as tongTien	\r\n"
					+ "from HoaDon \r\n"
					+ "WHERE Month(NgayLapHoaDon) = MONTH(GETDATE()) and TrangThai = 'dtt' and manhanvien = '"+manv+"'\r\n"
					+ "GROUP BY CAST(HoaDon.NgayLapHoaDon AS DATE), DATEPART(day , HoaDon.NgayLapHoaDon)";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				int ngay = rs.getInt(1);
				double tongTien = rs.getDouble(2);
				dataset.addValue(tongTien, "Doanh Thu", ngay+"");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dtBieuDoTuyChinh(DefaultCategoryDataset dataset, java.util.Date ngaybd, java.util.Date ngaykt) {
		DateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String nbd = dateFormat.format(ngaybd);
        String nkt = dateFormat.format(ngaykt);
        String manv= TaiKhoan_DAO.manv;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select NgayLapHoaDon as time, Sum(tongTien) as tongTien	\r\n"
					+ "from HoaDon \r\n"
					+ "WHERE NgayLapHoaDon >= '"+nbd+"' and NgayLapHoaDon <= '"+nkt+"' and trangthai ='dtt' and manhanvien = '"+manv+"'\r\n"
					+ "GROUP BY CAST(HoaDon.NgayLapHoaDon AS DATE), HoaDon.NgayLapHoaDon";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Date ngay = rs.getDate(1);
				double tongTien = rs.getDouble(2);
				dataset.addValue(tongTien, "Doanh Thu", ngay+"");
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public Double dtHomNay() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formatDate = date.format(dtf);
		String manv= TaiKhoan_DAO.manv;
		double tongTien = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select DATEPART(day, NgayLapHoaDon) as time, Sum(tongTien) as tongTien	\r\n"
					+ "from HoaDon \r\n"
					+ "WHERE NgayLapHoaDon = '"+formatDate+"' and trangthai = 'dtt' and manhanvien = '"+manv+"'\r\n"
					+ "GROUP BY CAST(HoaDon.NgayLapHoaDon AS DATE), DATEPART(day , HoaDon.NgayLapHoaDon)";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//				int ngay = rs.getInt(1);
				tongTien = rs.getDouble(2);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tongTien;
	}
	
	public Double dt7ngayQua() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formatDate = date.format(dtf);
		String manv= TaiKhoan_DAO.manv;
		double tongTien = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select Sum(tongTien) as tongTien	\r\n"
					+ "from HoaDon \r\n"
					+ "WHERE NgayLapHoaDon <= '"+formatDate+"' and NgayLapHoaDon > Dateadd(day ,-7,'"+formatDate+"') and trangthai = 'dtt' and manhanvien = '"+manv+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//				int ngay = rs.getInt(1);
				tongTien = rs.getDouble(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tongTien;
	}
	
	public Double dtthangnay() {
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formatDate = date.format(dtf);
		String manv= TaiKhoan_DAO.manv;
		double tongTien = 0;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select  Sum(tongTien) as tongTien	\r\n"
					+ "from HoaDon \r\n"
					+ "WHERE Month(NgayLapHoaDon) = MONTH(GETDATE()) and trangthai = 'dtt' and manhanvien = '"+manv+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//				int ngay = rs.getInt(1);
				tongTien = rs.getDouble(1);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tongTien;
	}
	public Double dttuychinh(java.util.Date ngaybd, java.util.Date ngaykt) {
		DateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String nbd = dateFormat.format(ngaybd);
        String nkt = dateFormat.format(ngaykt);
        double tongTien = 0;
        String manv= TaiKhoan_DAO.manv;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select Sum(tongTien) as tongTien	\r\n"
					+ "from HoaDon \r\n"
					+ "WHERE NgayLapHoaDon >= '"+nbd+"' and NgayLapHoaDon <= '"+nkt+"' and trangthai ='dtt' and manhanvien = '"+manv+"'\r\n";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
//				Date ngay = rs.getDate(1);
				tongTien = rs.getDouble(1);
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tongTien;
	}
	public void dsHoaDontk7ngay(DefaultTableModel modelkh, JTable tbl_doanhthu) {
		while (tbl_doanhthu.getRowCount() != 0) {
			modelkh.removeRow(0);
		}
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formatDate = date.format(dtf);
		String manv= TaiKhoan_DAO.manv;
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT       dbo.HoaDon.MaHoaDon, dbo.KhachHang.TenKhachHang, dbo.HoaDon.NgayLapHoaDon, dbo.HoaDon.GioLap, dbo.HoaDon.TongTien\r\n"
					+ "FROM            dbo.HoaDon INNER JOIN\r\n"
					+ "                         dbo.KhachHang ON dbo.HoaDon.MaKhachHang = dbo.KhachHang.MaKhachHang\r\n"
					+ "WHERE		NgayLapHoaDon <= '"+formatDate+"' and NgayLapHoaDon > Dateadd(day ,-7,'"+formatDate+"') and trangthai = 'dtt' and manhanvien = '"+manv+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String mahd = rs.getString(1);
				String tenkh = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				Time gioLap= rs.getTime(4);
				double tt = rs.getDouble(5);
//				Date ngaylap = rs.getDate(4);
				
				modelkh.addRow(new Object[] {mahd,tenkh,ngayLap,gioLap,tt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void dsHoaDontkhn(DefaultTableModel modelkh, JTable tbl_doanhthu) {
		while (tbl_doanhthu.getRowCount() != 0) {
			modelkh.removeRow(0);
		}
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formatDate = date.format(dtf);
		String manv= TaiKhoan_DAO.manv;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT       dbo.HoaDon.MaHoaDon, dbo.KhachHang.TenKhachHang, dbo.HoaDon.NgayLapHoaDon, dbo.HoaDon.GioLap, dbo.HoaDon.TongTien\r\n"
					+ "FROM            dbo.HoaDon INNER JOIN\r\n"
					+ "                         dbo.KhachHang ON dbo.HoaDon.MaKhachHang = dbo.KhachHang.MaKhachHang\r\n"
					+ "WHERE		NgayLapHoaDon = '"+formatDate+"'  and trangthai = 'dtt' and manhanvien = '"+manv+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String mahd = rs.getString(1);
				String tenkh = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				Time gioLap= rs.getTime(4);
				double tt = rs.getDouble(5);
//				Date ngaylap = rs.getDate(4);
				
				modelkh.addRow(new Object[] {mahd,tenkh,ngayLap,gioLap,tt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dsHoaDontkthangnay(DefaultTableModel modelkh, JTable tbl_doanhthu) {
		while (tbl_doanhthu.getRowCount() != 0) {
			modelkh.removeRow(0);
		}
		LocalDateTime date = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM-dd-yyyy");
		String formatDate = date.format(dtf);
		String manv= TaiKhoan_DAO.manv;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT       dbo.HoaDon.MaHoaDon, dbo.KhachHang.TenKhachHang, dbo.HoaDon.NgayLapHoaDon, dbo.HoaDon.GioLap, dbo.HoaDon.TongTien\r\n"
					+ "FROM            dbo.HoaDon INNER JOIN\r\n"
					+ "                         dbo.KhachHang ON dbo.HoaDon.MaKhachHang = dbo.KhachHang.MaKhachHang\r\n"
					+ "WHERE Month(NgayLapHoaDon) = MONTH(GETDATE()) and trangthai = 'dtt' and manhanvien = '"+manv+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String mahd = rs.getString(1);
				String tenkh = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				Time gioLap= rs.getTime(4);
				double tt = rs.getDouble(5);
//				Date ngaylap = rs.getDate(4);
				
				modelkh.addRow(new Object[] {mahd,tenkh,ngayLap,gioLap,tt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dsHoaDontkTuyChinh(DefaultTableModel modelkh, JTable tbl_doanhthu,java.util.Date ngaybd, java.util.Date ngaykt) {
		while (tbl_doanhthu.getRowCount() != 0) {
			modelkh.removeRow(0);
		}
		DateFormat dateFormat = null;
        dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String nbd = dateFormat.format(ngaybd);
        String nkt = dateFormat.format(ngaykt);
        String manv= TaiKhoan_DAO.manv;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "SELECT       dbo.HoaDon.MaHoaDon, dbo.KhachHang.TenKhachHang, dbo.HoaDon.NgayLapHoaDon, dbo.HoaDon.GioLap, dbo.HoaDon.TongTien\r\n"
					+ "FROM            dbo.HoaDon INNER JOIN\r\n"
					+ "                         dbo.KhachHang ON dbo.HoaDon.MaKhachHang = dbo.KhachHang.MaKhachHang\r\n"
					+ "WHERE NgayLapHoaDon >= '"+nbd+"' and NgayLapHoaDon <= '"+nkt+"' and trangthai ='dtt' and manhanvien = '"+manv+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String mahd = rs.getString(1);
				String tenkh = rs.getString(2);
				Date ngayLap = rs.getDate(3);
				Time gioLap= rs.getTime(4);
				double tt = rs.getDouble(5);
//				Date ngaylap = rs.getDate(4);
				
				modelkh.addRow(new Object[] {mahd,tenkh,ngayLap,gioLap,tt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
}
