package entity;

import java.util.Objects;

public class ChiTietHoaDon {
	private SanPham sp;
	private int soLuong;
	private String maHD;
	
	public double thanhTien() {
		return sp.getGiaBan()*soLuong;
	}

	public SanPham getSp() {
		return sp;
	}

	public void setSp(SanPham sp) {
		this.sp = sp;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public ChiTietHoaDon() {
		
	}

	public ChiTietHoaDon(SanPham sp, int soLuong, String maHD) {
		
		this.sp = sp;
		this.soLuong = soLuong;
		this.maHD = maHD;
	}

	public String getMaHD() {
		return maHD;
	}

	public void setMaHD(String maHD) {
		this.maHD = maHD;
	}

	@Override
	public String toString() {
		return "ChiTietHoaDon [sp=" + sp + ", soLuong=" + soLuong + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(soLuong, sp);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ChiTietHoaDon other = (ChiTietHoaDon) obj;
		return soLuong == other.soLuong && Objects.equals(sp, other.sp);
	}
	
}
