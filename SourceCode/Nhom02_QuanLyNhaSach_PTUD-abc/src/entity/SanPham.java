package entity;

import java.util.Objects;

public abstract class SanPham {
	private String maSP;
	private String tenSP;
	private double giaNhap;
	private String hinhAnh;
	private double giaBan;
	private NhaCungCap ncc;
	private int soLuongTon;
	private String donViTinh;
	public String getDonViTinh() {
		return donViTinh;
	}
	public void setDonViTinh(String donViTinh) {
		this.donViTinh = donViTinh;
	}
	public int getSoLuongTon() {
		return soLuongTon;
	}
	public void setSoLuongTon(int soLuongTon) {
		this.soLuongTon = soLuongTon;
	}
	public String getMaSP() {
		return maSP;
	}
	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public double getGiaNhap() {
		return giaNhap;
	}
	public void setGiaNhap(double giaNhap) {
		this.giaNhap = giaNhap;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	
	public NhaCungCap getNcc() {
		return ncc;
	}
	public void setNcc(NhaCungCap ncc) {
		this.ncc = ncc;
	}
	public SanPham() {
		
	}
	public SanPham(String maSP, String tenSP, double giaNhap, String hinhAnh,NhaCungCap ncc, int soLuongTon) {
		this.maSP = maSP;
		this.tenSP = tenSP;
		this.giaNhap = giaNhap;
		this.hinhAnh = hinhAnh;
		this.ncc = ncc;
		this.soLuongTon = soLuongTon;
	}
	
	@Override
	public String toString() {
		return tenSP;
	}
	public double getGiaBan() {
		this.giaBan = this.giaNhap + (this.giaNhap * 0.5);
		return giaBan;
	}
	@Override
	public int hashCode() {
		return Objects.hash(giaBan, giaNhap, hinhAnh, maSP, ncc, soLuongTon, tenSP);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SanPham other = (SanPham) obj;
		return Double.doubleToLongBits(giaBan) == Double.doubleToLongBits(other.giaBan)
				&& Double.doubleToLongBits(giaNhap) == Double.doubleToLongBits(other.giaNhap)
				&& Objects.equals(hinhAnh, other.hinhAnh) && Objects.equals(maSP, other.maSP)
				&& Objects.equals(ncc, other.ncc) && soLuongTon == other.soLuongTon
				&& Objects.equals(tenSP, other.tenSP);
	}
	
	
	
	
}
