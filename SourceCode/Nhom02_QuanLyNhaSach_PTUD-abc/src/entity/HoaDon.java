package entity;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;



public class HoaDon {
	private String maHD;
	private Date ngayLap;
	private Time gioLap;
	private NhanVien nv;
	private KhachHang kh;
	private ArrayList<ChiTietHoaDon> dscthd;
	public String getMaHD() {
		return maHD;
	}
	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}
	public Date getNgayLap() {
		return ngayLap;
	}
	public void setNgayLap(Date ngayLap) {
		this.ngayLap = ngayLap;
	}
	public Time getGioLap() {
		return gioLap;
	}
	public void setGioLap(Time gioLap) {
		this.gioLap = gioLap;
	}
	public ArrayList<ChiTietHoaDon> getCthd() {
		return dscthd;
	}
	public void setCthd(ArrayList<ChiTietHoaDon> dscthd) {
		this.dscthd = dscthd;
	}
	public NhanVien getNv() {
		return nv;
	}
	public void setNv(NhanVien nv) {
		this.nv = nv;
	}
	public KhachHang getKh() {
		return kh;
	}
	public void setKh(KhachHang kh) {
		this.kh = kh;
	}
	public HoaDon() {
	}
	public HoaDon(String maHD, Date ngayLap, Time gioLap, NhanVien nv, KhachHang kh, ArrayList<ChiTietHoaDon> dscthd) {
		this.maHD = maHD;
		this.ngayLap = ngayLap;
		this.gioLap = gioLap;
		this.nv = nv;
		this.kh = kh;
		this.dscthd = dscthd;
	}
	
	
	public double tongTien() {
		double s = 0;
		for (ChiTietHoaDon chiTietHoaDon : dscthd) {
			s = s + chiTietHoaDon.thanhTien();
		}
		return s;
	}
	@Override
	public String toString() {
		return "HoaDon [maHD=" + maHD + ", ngayLap=" + ngayLap + ", nv=" + nv + ", kh=" + kh + ", dscthd=" + dscthd
				+ "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(dscthd, kh, maHD, ngayLap, nv);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HoaDon other = (HoaDon) obj;
		return Objects.equals(dscthd, other.dscthd) && Objects.equals(kh, other.kh) && Objects.equals(maHD, other.maHD)
				&& Objects.equals(ngayLap, other.ngayLap) && Objects.equals(nv, other.nv);
	}
	
	
	
}
