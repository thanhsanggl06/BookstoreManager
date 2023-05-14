package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.HoaDon;
import entity.NhanVien;
import entity.Sach;

public class Test {
	private static NhanVien_DAO nhanVienDao = new NhanVien_DAO();
	private static Sach_DAO sachDao = new Sach_DAO();
	private static HoaDon_DAO hoadonDao = new HoaDon_DAO();
	
	
	
	public static void main(String[] args) throws SQLException {
		ArrayList<Sach> ds = sachDao.getAllSach();
		System.out.println(sachDao.getSachTheoMa("SP2395"));
		ArrayList<HoaDon> dshd = hoadonDao.getAllHoaDon();
		for (HoaDon hoaDon : dshd) {
			System.out.println(hoaDon.toString());
		}
	}
	
}
