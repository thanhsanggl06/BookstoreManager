package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import connectDB.ConnectDB;
import entity.NhaCungCap;
import entity.NhaXuatBan;
import entity.Sach;
import entity.TacGia;
import entity.TheLoai;
import entity.ThuongHieu;

public class Sach_DAO {
	private NhaXuatBan_DAO nxbDao = new NhaXuatBan_DAO();
	private NhaCungCap_DAO nccDao = new NhaCungCap_DAO();
	private TacGia_DAO tgDao = new TacGia_DAO();
	private TheLoai_DAO tlDao = new TheLoai_DAO();
	public ArrayList<Sach> getAllSach() throws SQLException{
		ArrayList<Sach> ds = new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SanPham Where MaSanPham like 'SP%' and TrangThai = 'c'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				String maNXB = rs.getString(3);
				NhaXuatBan nxb = nxbDao.getNXBTheoMa(maNXB);
				
				Double giaNhap = rs.getDouble(4);
				String maTL = rs.getString(5);
				TheLoai tl = tlDao.getTheLoaiTheoMa(maTL);
				
				String maNCC = rs.getString(8);
				NhaCungCap ncc = nccDao.getNccTheoMa(maNCC);
				
				int soLuongTon = rs.getInt(9);
				String hinhAnh = rs.getString(10);
				String maTG = rs.getString(11);
				String donViTinh = rs.getString(12);
				TacGia tg = tgDao.getTacGiaTheoMa(maTG);
				
//				
				Sach sach = new Sach(maSP, tenSP, giaNhap, hinhAnh, ncc, soLuongTon, tg, nxb, tl,donViTinh);
				ds.add(sach);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	
	public boolean addSach(Sach s) throws SQLException {
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;
		int n = 0;
		try {
			stmt = con.prepareStatement("insert into" + " SanPham values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			stmt.setString(1, s.getMaSP());
			stmt.setString(2, s.getTenSP());
			stmt.setString(3, s.getNxb().getMaNXB());
			stmt.setDouble(4, s.getGiaNhap());
			stmt.setString(5, s.getTl().getMaTheLoai());
			stmt.setNull(6, Types.VARCHAR);
			stmt.setNull(7, Types.VARCHAR);
			stmt.setString(8, s.getNcc().getMaNCC());
			stmt.setInt(9, s.getSoLuongTon());
			stmt.setString(10, s.getHinhAnh());
			stmt.setString(11, s.getTg().getMaTacGia());
			stmt.setString(12, s.getDonViTinh());
			stmt.setString(13, "c");
			
			
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
	
	
	public boolean updateSach (Sach s ) throws SQLException
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0 ;
		try {
			stmt = con.prepareStatement("update SanPham set TenSanPham=?,MaNXB=?,GiaNhap=?, MaTheLoai=?, MaNCC = ?, SoLuongTon = ?, Image = ?, MaTacGia = ? where MaSanPham=?");
			
			
			stmt.setString(9, s.getMaSP());
			stmt.setString(1, s.getTenSP());
			stmt.setString(2, s.getNxb().getMaNXB());
			stmt.setDouble(3, s.getGiaNhap());
			stmt.setString(4, s.getTl().getMaTheLoai());
			stmt.setString(5, s.getNcc().getMaNCC());
			stmt.setInt(6, s.getSoLuongTon());
			stmt.setString(7, s.getHinhAnh());
			stmt.setString(8, s.getTg().getMaTacGia());			
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n > 0;
	}
	
	public boolean deleteSanPham (String ma ) throws SQLException
	{
		ConnectDB.getInstance();
		Connection con = ConnectDB.getConnection();
		PreparedStatement stmt = null;

		int n = 0 ;
		try {
			stmt = con.prepareStatement("update SanPham set TrangThai = 'k' where MaSanPham=?");
			
			
			stmt.setString(1, ma);
					
			n = stmt.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}finally {
			stmt.close();
		}
		return n > 0;
	}
	
	public Sach getSachTheoMa(String maSach) {
		Sach s = new Sach();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "Select * from SanPham where MaSanPham = '"+maSach+"'";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getString(2);
				String maNXB = rs.getString(3);
				NhaXuatBan nxb = nxbDao.getNXBTheoMa(maNXB);
				
				Double giaNhap = rs.getDouble(4);
				String maTL = rs.getString(5);
				TheLoai tl = tlDao.getTheLoaiTheoMa(maTL);
				
				String maNCC = rs.getString(8);
				NhaCungCap ncc = nccDao.getNccTheoMa(maNCC);
				
				int soLuongTon = rs.getInt(9);
				String hinhAnh = rs.getString(10);
				String maTG = rs.getString(11);
				String donViTinh = rs.getString(12);
				TacGia tg = tgDao.getTacGiaTheoMa(maTG);
				
//				
				 s = new Sach(maSP, tenSP, giaNhap, hinhAnh, ncc, soLuongTon, tg, nxb, tl,donViTinh);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return s;
		}
	public ArrayList<Sach> gettop10sachbanchay() throws SQLException{
		ArrayList<Sach> ds = new ArrayList<Sach>();
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select top 10 SanPham.MaSanPham as msp, sum(ChiTietHoaDon.SoLuong) as soluong\r\n"
					+ "from SanPham inner join ChiTietHoaDon on SanPham.MaSanPham = ChiTietHoaDon.MaSanPham\r\n"
					+ "where SanPham.MaSanPham like 'SP%'\r\n"
					+ "group by SanPham.MaSanPham\r\n"
					+ "order by soluong desc";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String maSP = rs.getString(1);
				
//				
				Sach s = getSachTheoMa(maSP);
				ds.add(s);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			return ds;
		}
	public String phatSinhMaSach() throws SQLException {

		String sql = "select MAX(MaSanPham) from SanPham where masanpham like 'SP%'";
		try (Connection conn = ConnectDB.getConnection()) {
			try (ResultSet rs = conn.prepareStatement(sql).executeQuery()) {
				rs.next();
				rs.getString(1);
				if (rs.getString(1) == null) {
					return "SP0001";
				}

				else {

					long id = Long.parseLong(rs.getString(1).substring(2, rs.getString(1).trim().length()));
					id++;
					return "SP" + String.format("%04d", id);
				}
			}
		}
	}
	public boolean sachCoTrongHeThong(String masp) {
		int dem = -1;
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
			String sql = "select count (distinct masanpham) from SanPham where MaSanPham = '"+masp+"'";
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
	
	public void dsSPTimKiem(String sql, DefaultTableModel model, JTable tbl){
		while (tbl.getRowCount() != 0) {
			model.removeRow(0);
		}
		
		try {
			ConnectDB.getInstance();
			Connection con = ConnectDB.getConnection();
//			String sql = "SELECT       dbo.SanPham.MaSanPham, dbo.SanPham.TenSanPham, dbo.SanPham.GiaNhap, dbo.SanPham.SoLuongTon, dbo.SanPham.DonViTinh, dbo.NhaXuatBan.TenNXB, dbo.TacGia.TenTacGia, dbo.NhaCungCap.TenNCC, \r\n"
//					+ "                         dbo.TheLoai.TenTheLoai\r\n"
//					+ "FROM            dbo.SanPham INNER JOIN\r\n"
//					+ "                         dbo.NhaXuatBan ON dbo.SanPham.MaNXB = dbo.NhaXuatBan.MaNXB INNER JOIN\r\n"
//					+ "                         dbo.TacGia ON dbo.SanPham.MaTacGia = dbo.TacGia.MaTacGia INNER JOIN\r\n"
//					+ "                         dbo.NhaCungCap ON dbo.SanPham.MaNCC = dbo.NhaCungCap.MaNCC INNER JOIN\r\n"
//					+ "                         dbo.TheLoai ON dbo.SanPham.MaTheLoai = dbo.TheLoai.MaTheLoai\r\n"
//					+ "Where (TacGia.TenTacGia Like N'%"+chuoi+"%' or SanPham.MaSanPham like '%"+chuoi+"%' or SanPham.TenSanPham like N'%"+chuoi+"%' or NhaCungCap.TenNCC like N'%"+chuoi+"%' or NhaXuatBan.TenNXB like N'%"+chuoi+"%' or TheLoai.TenTheLoai like N'%"+chuoi+"%') and TrangThai = 'c' and SanPham.MaSanPham like '%SP%'\r\n"
//					+ "";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				String masp = rs.getString(1);
				String tensp = rs.getString(2);
				double gia = rs.getDouble(3);
				int slt = rs.getInt(4);
				String dvt = rs.getString(5);
				String nxb = rs.getNString(6);
				String tg = rs.getNString(7);
				String ncc = rs.getNString(8);
				String tl = rs.getNString(9);
				
				model.addRow(new Object[] {masp,tensp,tg,nxb,tl,ncc,slt,gia,dvt});
				
				
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}
}
